//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - UTC - Stéphane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "OdeManager.hxx"
#include "odeparameters.hxx"

extern "C"
{
#include "sciprint.h"
}

void OdeManager::parseFunctionFromOption(types::optional_list &opt, const wchar_t * _pwstLabel, functionKind what)
{
    types::InternalType *pIn = NULL;
    if (opt.find(_pwstLabel) == opt.end())
    {
        // we are possibly extending a solution with same Rhs, Jacobian, Events, ... function
        if (m_odeIsExtension)
        {
            m_functionAPI[what] =  getPreviousManager()->m_functionAPI[what];
            m_pCallFunction[what] = getPreviousManager()->m_pCallFunction[what]; // can be NULL
            m_pEntryPointFunction[what] = getPreviousManager()->m_pEntryPointFunction[what]; // can be NULL
            m_pEntryPointFunctionWithPar[what] = getPreviousManager()->m_pEntryPointFunctionWithPar[what]; // can be NULL
            m_pParameters[what] = getPreviousManager()->m_pParameters[what]; // can be NULL
            m_bHas[what] = getPreviousManager()->m_bHas[what]; // can be false
        }
        return;
    }
 
    pIn = opt[_pwstLabel];
    parseFunction(pIn, what);
 
    pIn->DecreaseRef();
    pIn->killMe();
    opt.erase(_pwstLabel);
}

void OdeManager::parseMatrices(types::typed_list &in)
{
    char errorMsg[256];
    types::Double *pDblTSpan = NULL;

    // Parse second argument "tspan"
    if (in[1]->isDouble() && !in[1]->getAs<types::Double>()->isComplex())
    {
        pDblTSpan = in[1]->getAs<types::Double>();

        // Check if we are extending a previously computed solution
        if (m_odeIsExtension)
        {
            OdeManager *prevManager = getPreviousManager();
            if (pDblTSpan->getSize() > 1)
            {
                sprintf(errorMsg, _("%s: Wrong size for input argument #%d: expecting %d.\n"), getSolverName().c_str(),1, 1);
                throw ast::InternalError(errorMsg);
            }
            double dblTFinal = prevManager->m_dblVecTOut.back();
            if ( ((pDblTSpan->get(0)-dblTFinal)*(dblTFinal-prevManager->m_dblT0)) < 0)
            {
                sprintf(errorMsg, _("%s: parameter #%d must be greater than %g.\n"), getSolverName().c_str(),2, dblTFinal);
                throw ast::InternalError(errorMsg);
            }
            // Simulate option t0 = tFinal
            m_dblOptT0 = dblTFinal;
        }

        m_pDblTSpan = pDblTSpan->clone();
        if (m_pDblTSpan->getSize() > 2)
        {
            for (int i=2; i<m_pDblTSpan->getSize(); i++)
            {
                if ( (m_pDblTSpan->get(i)-m_pDblTSpan->get(i-1)) * (m_pDblTSpan->get(i-1)-m_pDblTSpan->get(i-2)) < 0)
                {
                    sprintf(errorMsg, _("%s: values in parameter #%d should be monotone.\n"), getSolverName().c_str(),2);
                    throw ast::InternalError(errorMsg);
                }
            }
        }
    }
    else
    {
        sprintf(errorMsg, _("%s: Wrong type for input argument #%d: A real matrix expected.\n"), getSolverName().c_str(),2);
        throw ast::InternalError(errorMsg);
    }

    // parse initial conditions. Uses final conditions of previous solution if extending
    m_pDblY0 = parseInitialCondition(in, false);
    if (isDAE())
    {
        m_pDblYp0 = parseInitialCondition(in, true);
        if (m_pDblYp0->getSize() != m_pDblY0->getSize())
        {
            sprintf(errorMsg, _("%s: y0 and yp0 must have the same size.\n"), getSolverName().c_str());
            throw ast::InternalError(errorMsg);
        }
    }

    m_iNbEq = m_pDblY0->getSize();

    m_iSizeOfInput[RHS] = m_iNbEq;
    m_iSizeOfInput[SRHS] = m_iNbEq;
    m_iSizeOfInput[FRHS] = m_iNbEq;
    m_iSizeOfInput[RES] = m_iNbEq;
    m_iSizeOfInput[PROJ] = m_iNbEq;
 
    m_iSizeOfInput[JACY] = m_iNbEq*m_iNbEq;
    m_iSizeOfInput[JACYYP] = m_iNbEq*m_iNbEq;
    m_iSizeOfInput[MASS] = m_iNbEq*m_iNbEq;
}

types::Double *OdeManager::parseInitialCondition(types::typed_list &in, bool bIsDerivative)
{
    char errorMsg[256];
    types::Double *pDblY = NULL;
    double *pdblPrevYFinal = NULL;
    int iPos = bIsDerivative ? 3 : 2;

    // Parse argument "y0" or "yp0"
    // They are parsed as options when extending solution
    if (m_odeIsExtension == false)
    {
        if (in[iPos]->isDouble())
        {
            types::Double *pDbl =  in[iPos]->getAs<types::Double>();
            if (pDbl->isVector() && pDbl->getRows() == 1)
            {
                pDbl->transpose((types::InternalType *&)pDblY);
            }
            else
            {
                pDblY = pDbl->clone();
            }
        }
        else
        {
            sprintf(errorMsg, _("%s: Wrong type for input argument #%d: A real or complex matrix expected.\n"), getSolverName().c_str(),iPos+1);
            throw ast::InternalError(errorMsg);
        }
        m_odeIsComplex |= pDblY->isComplex();
    }
    else
    {
        OdeManager *prevManager = getPreviousManager();
        // by default, extend solution with Y0 resp. Yp0 = final value of previous Y resp. Yp
        int iNbEq = prevManager->m_iNbEq;
     
        pdblPrevYFinal = bIsDerivative ? N_VGetArrayPointer(prevManager->m_N_VectorYp) : N_VGetArrayPointer(prevManager->m_N_VectorY);

        pDblY = prevManager->m_pDblY0->clone(); // Just for the size and dimensions
        pDblY->setComplex(prevManager->m_odeIsComplex);
        std::copy(pdblPrevYFinal, pdblPrevYFinal+iNbEq, pDblY->get());
        if (pDblY->isComplex())
        {
            std::copy(pdblPrevYFinal+iNbEq, pdblPrevYFinal+2*iNbEq, pDblY->getImg());
        }
        m_odeIsComplex = prevManager->m_odeIsComplex;
    }
    return pDblY;
}

void OdeManager::parseOptions(types::optional_list &opt)
{
    char errorMsg[256];
    std::vector<int> emptyVect = {};
    std::vector<double> defaultAtolVect = {m_dblDefaultAtol};
    OdeManager *prevManager = getPreviousManager();

    // first process a struct of options
    if (opt.find(L"options") != opt.end())
    {
        if (opt[L"options"]->isStruct() == false || opt[L"options"]->getAs<types::Struct>()->getSize() != 1)
        {
            sprintf(errorMsg, _("%s: Wrong type for options parameter: expecting a scalar Struct.\n"), getSolverName().c_str());
            throw ast::InternalError(errorMsg);
        }
        types::Struct* pSt = opt[L"options"]->getAs<types::Struct>();
        types::String* pFields = pSt->getFieldNames();
         for (int i=0; i<pFields->getSize(); i++)
         {
             auto pWStr = pFields->get(i);
             types::InternalType *pIT = pSt->get(0)->get(pWStr)->clone();;
             pIT->IncreaseRef();
             if (opt.find(pWStr) == opt.end())
             {
                 opt[pWStr]=pIT;                 
             }
         }
         opt.erase(L"options");
    }
    
    if (m_odeIsExtension == false)
    {
        // Initial time
        if (m_pDblTSpan->getSize() > 1 )
        {
            if (m_pDblTSpan->get(0) < m_pDblTSpan->get(1))
            {
                getDoubleInPlist(getSolverName().c_str(),opt, L"t0", &m_dblOptT0,
                    m_dblOptT0, {-std::numeric_limits<double>::infinity(), m_pDblTSpan->get(0)});
            }
            else
            {
                getDoubleInPlist(getSolverName().c_str(),opt, L"t0", &m_dblOptT0,
                    m_dblOptT0, {m_pDblTSpan->get(0), std::numeric_limits<double>::infinity()});
            }
        }
        else // "t0" is mandatory if  m_TSpan->getSize() == 1
        {
            getDoubleInPlist(getSolverName().c_str(),opt, L"t0", &m_dblOptT0, m_dblOptT0, {});
        }
        // final definition of m_dblT0
        if (std::isnan(m_dblOptT0))
        {
            if (m_pDblTSpan->getSize() > 1)
            {
                m_dblT0 = m_pDblTSpan->get(0);
            }
            else
            {
                sprintf(errorMsg, _("%s: parameter \"%ls\" must be defined by user.\n"), getSolverName().c_str(),L"t0");
                throw ast::InternalError(errorMsg);
            }
         }
        else
        {
            m_dblT0 = m_dblOptT0;
        }
    }
    else
    {
        m_dblT0 = m_dblOptT0;
    }

    // Parse Jacobian first (as it restricts the possible methods and other stuff)
    functionKind whatJAC = isDAE() ? JACYYP : JACY;

    parseMatrixPattern(opt, L"jacPattern", whatJAC);
    //TODO: implement jacTimes option !
    if (m_pIPattern[JACY] == NULL)
    {
        getIntVectorInPlist(getSolverName().c_str(),opt, L"jacBand", m_iVecBand[whatJAC],
        m_odeIsExtension ? prevManager->m_iVecBand[whatJAC] : emptyVect, {0, m_iNbEq-1}, {2});
        if (m_iVecBand[whatJAC].size()>0)
        {
            // if band Jacobian is provided, Sundials packed style is supposed
            m_iSizeOfInput[whatJAC] = m_iNbEq*(m_iVecBand[whatJAC][0]+m_iVecBand[whatJAC][1]+1);
        }

        // parse Jacobian. If constant Jacobian then m_typeOfOutput[JACY] wil be set
        parseFunctionFromOption(opt, L"jacobian", whatJAC);

        // Detect Jacobian type by calling Scilab user function (if applicable)
        if (m_functionAPI[whatJAC] == SCILAB_CALLABLE)
        {
            // call will set m_typeOfOutput[JACY] or m_typeOfOutput[JACYYP]
            types::typed_list in;
            callOpening(whatJAC, in, m_dblT0);
            if (whatJAC == JACYYP)
            {
                in.push_back(new types::Double(1.0));
            }
            computeMatrix(in, whatJAC, NULL);
        }
        else if (m_functionAPI[whatJAC] == SUNDIALS_DLL)
        {
            // jacNonZeros must be declared if SUNDIALS DLL returns a sparse Jacobian
            getIntInPlist(getSolverName().c_str(),opt, L"jacNonZeros", &m_iNonZeros[whatJAC],
                m_odeIsExtension ? prevManager->m_iNonZeros[whatJAC] : -1, {0, m_iNbEq*m_iNbEq});
            if (m_iNonZeros[whatJAC] >= 0)
            {
                getStringInPlist(getSolverName().c_str(),opt, L"jacFormat", m_wstrSparseFormat[whatJAC],
                    m_odeIsExtension ? prevManager->m_wstrSparseFormat[whatJAC] : L"CSC", {L"CSC",L"CSR"});            
            }
        }
    }
    
    // Parse specific stuff (the method below is overriden for each solver)
    parseMethodAndOrder(opt);

#ifdef _OPENMP
    // Thread or no threads
    getIntInPlist(getSolverName().c_str(),opt, L"nbThreads", &m_iNbThreads,
        m_odeIsExtension ? prevManager->m_iNbThreads : 0, {0, INT_MAX});
#endif
    // Common options
    getDoubleInPlist(getSolverName().c_str(),opt, L"rtol", &m_dblRtol,
        m_odeIsExtension ? prevManager->m_dblRtol : m_dblDefaultRtol, {1e-15, 1});
    getDoubleVectorInPlist(getSolverName().c_str(),opt, L"atol", m_dblVecAtol,
        m_odeIsExtension ? prevManager->m_dblVecAtol : defaultAtolVect, {1e-15, std::numeric_limits<double>::infinity()}, m_iNbEq);
    getIntInPlist(getSolverName().c_str(),opt, L"refine", &m_iNRefine,
        m_odeIsExtension ? prevManager->m_iNRefine : 0, {0, INT_MAX});

    getDoubleInPlist(getSolverName().c_str(),opt, L"h0", &m_dblInitialStep,
        m_odeIsExtension ? prevManager->m_dblInitialStep : 0, {0, std::numeric_limits<double>::infinity()});
    getIntInPlist(getSolverName().c_str(),opt, L"maxSteps", &m_iMaxNumSteps,
        m_odeIsExtension ? prevManager->m_iMaxNumSteps : 0, {0, INT_MAX});
    getDoubleInPlist(getSolverName().c_str(),opt, L"hMax", &m_dblMaxStep,
        m_odeIsExtension ? prevManager->m_dblMaxStep : 0, {0, std::numeric_limits<double>::infinity()});
    getDoubleInPlist(getSolverName().c_str(),opt, L"hMin", &m_dblMinStep,
        m_odeIsExtension ? prevManager->m_dblMinStep : 0, {0, std::numeric_limits<double>::infinity()});

    getIntVectorInPlist(getSolverName().c_str(),opt, L"positive", m_iVecPositive,
        m_odeIsExtension ? prevManager->m_iVecPositive : emptyVect, {1,m_iNbEq}, {1,m_iNbEq});
    getIntVectorInPlist(getSolverName().c_str(),opt, L"negative", m_iVecNegative,
        m_odeIsExtension ? prevManager->m_iVecNegative : emptyVect, {1,m_iNbEq}, {1,m_iNbEq});
    getIntVectorInPlist(getSolverName().c_str(),opt, L"nonNegative", m_iVecNonNegative,
        m_odeIsExtension ? prevManager->m_iVecNonNegative : emptyVect, {1,m_iNbEq}, {1,m_iNbEq});
    getIntVectorInPlist(getSolverName().c_str(),opt, L"nonPositive", m_iVecNonPositive,
        m_odeIsExtension ? prevManager->m_iVecNonPositive : emptyVect, {1,m_iNbEq}, {1,m_iNbEq});

    // non linear solver
    getStringInPlist(getSolverName().c_str(),opt, L"nonLinSol", m_wstrNonLinSolver,
        m_odeIsExtension ? prevManager->m_wstrNonLinSolver : getDefaultNonLinSolver(), getAvailableNonLinSolvers());
    getIntInPlist(getSolverName().c_str(),opt, L"nonLinSolMaxIters", &m_iNonLinSolMaxIters,
        m_odeIsExtension ? prevManager->m_iNonLinSolMaxIters : 0, {0, INT_MAX});
    getIntInPlist(getSolverName().c_str(),opt, L"nonLinSolAccel", &m_iNonLinSolAccel,
        m_odeIsExtension ? prevManager->m_iNonLinSolAccel : 0, {0, INT_MAX});

    // parse linear solver
    getStringInPlist(getSolverName().c_str(),opt, L"linearSolver", m_wstrLinSolver, 
        m_odeIsExtension ? prevManager->m_wstrLinSolver : getDefaultLinSolver(), getAvailableLinSolvers());

    // iterative solvers
    if (m_wstrLinSolver == L"CG" || 
        m_wstrLinSolver == L"BCGS" || 
        m_wstrLinSolver == L"FGMR" || 
        m_wstrLinSolver == L"GMR" || 
        m_wstrLinSolver == L"TFQMR")
    {
        getIntInPlist(getSolverName().c_str(),opt, L"linSolMaxIters", &m_iLinSolMaxIters,
            m_odeIsExtension ? prevManager->m_iLinSolMaxIters : 0, {0, INT_MAX});
        if (hasBandPrec())
        {
            getIntVectorInPlist(getSolverName().c_str(),opt, L"precBand", m_iPrecBand,
                m_odeIsExtension ? prevManager->m_iPrecBand : emptyVect, {0, m_iNbEq-1}, {2});                
        }
        getStringInPlist(getSolverName().c_str(),opt, L"precType", m_wstrPrecondType,
            m_odeIsExtension ? prevManager->m_wstrPrecondType : getDefaultPrecondType(), getAvailablePrecondType());
    } 

    // options with user functions
    parseFunctionFromOption(opt, L"callback", INTCB);
    parseFunctionFromOption(opt, L"events", EVENTS);
    setupEvents(opt);

    if (m_odeIsExtension)
    {
        // y0 option
        if (opt.find(L"y0") != opt.end())
        {
            if (opt[L"y0"]->isDouble())
            {
                types::Double *pDbl = opt[L"y0"]->getAs<types::Double>();
                bool bSameDims = true;
                if (pDbl->getDims() == m_pDblY0->getDims())
                {
                    for (int i=0; i<pDbl->getDims(); i++)
                    {
                        bSameDims &= (pDbl->getDimsArray()[i] == m_pDblY0->getDimsArray()[i]);
                    }
                }
                if (bSameDims == false)
                {
                    sprintf(errorMsg, _("%s: Wrong size for option \"y0\": expecting %d x %d.\n"), getSolverName().c_str(),m_pDblY0->getRows(), m_pDblY0->getCols());
                    throw ast::InternalError(errorMsg);
                }
                if (prevManager->m_odeIsComplex == false && pDbl->isComplex())
                {
                    sprintf(errorMsg, _("%s: Wrong type (complex) for option \"y0\": extended ode is real.\n"), getSolverName().c_str());
                    throw ast::InternalError(errorMsg);
                }
                m_pDblY0->killMe();
                m_pDblY0 = pDbl->clone();
                m_pDblY0->setComplex(m_odeIsComplex);
                opt.erase(L"y0");
            }
            else
            {
                sprintf(errorMsg, _("%s: Wrong type for option \"y0\": a double vector is expected.\n"), getSolverName().c_str());
                throw ast::InternalError(errorMsg);
            }
        }

        if (isDAE() && opt.find(L"yp0") != opt.end())
        {
            if (opt[L"yp0"]->isDouble())
            {
                types::Double *pDbl = opt[L"yp0"]->getAs<types::Double>();
                bool bSameDims = true;
                if (pDbl->getDims() == m_pDblYp0->getDims())
                {
                    for (int i=0; i<pDbl->getDims(); i++)
                    {
                        bSameDims &= (pDbl->getDimsArray()[i] == m_pDblYp0->getDimsArray()[i]);
                    }
                }
                if (bSameDims == false)
                {
                    sprintf(errorMsg, _("%s: Wrong size for option \"y0\": expecting %d x %d.\n"), getSolverName().c_str(),m_pDblYp0->getRows(), m_pDblYp0->getCols());
                    throw ast::InternalError(errorMsg);
                }
                if (prevManager->m_odeIsComplex == false && pDbl->isComplex())
                {
                    sprintf(errorMsg, _("%s: Wrong type (complex) for option \"y0\": extended ode is real.\n"), getSolverName().c_str());
                    throw ast::InternalError(errorMsg);
                }
                m_pDblYp0->killMe();
                m_pDblYp0 = pDbl->clone();
                m_pDblYp0->setComplex(m_odeIsComplex);
                opt.erase(L"yp0");
            }
            else
            {
                sprintf(errorMsg, _("%s: Wrong type for option \"yp0\": a double vector is expected.\n"), getSolverName().c_str());
                throw ast::InternalError(errorMsg);
            }
        }

        // By default we use rhs of previous solution.
        // rhs or residual function can be overriden by "rhs" and "res" options
        functionKind what = isDAE() ? RES : RHS;
        parseFunctionFromOption(opt, isDAE() ? L"res" : L"rhs", what);

        // below call is made to detect complex extended ode
        if (m_pCallFunction[what] != NULL)
        {
            types::typed_list in;
            callOpening(what, in, m_dblT0);
            computeFunction(in, what);            
        }
    }
    else
    {
        if (isDAE())
        {
            getStringInPlist(getSolverName().c_str(),opt, L"calcIc", m_wstrCalcIc, L"", {L"y0",L"y0yp0"});
            getIntVectorInPlist(getSolverName().c_str(),opt, L"yIsAlgebraic", m_iVecIsAlgebraic, {}, {1,m_iNbEq}, {1,m_iNbEq});
            if (m_iVecIsAlgebraic.size() > 0)
            {
                getBooleanInPlist(getSolverName().c_str(),opt, L"suppressAlg", &m_bSuppressAlg, false);                
            }
        }
    }

    // check unparsed/invalid options
    if (opt.size() > 0)
    {
        std::wstringstream wstr;
        for (auto it = opt.begin(); it != opt.end(); it++)
        {
            wstr << L"\"" << it->first << L"\"";
            if (std::next(it) != opt.end())
            {
                wstr << L", ";
            }
        }
        if (opt.size() == 1)
        {
            sprintf(errorMsg, _("%s: %ls is an unknown or invalid (in this context) solver option.\n"), getSolverName().c_str(), wstr.str().c_str());
        }
        else
        {
            sprintf(errorMsg, _("%s: %ls are unkown or invalid (in this context) solver options.\n"), getSolverName().c_str(), wstr.str().c_str());
        }
        throw ast::InternalError(errorMsg);
    }

    if (m_odeIsExtension == false)
    {
            // Determine if ode is complex (can be already detected if Y0 is complex)
        // in the case where RHS is a Scilab function
        functionKind what = isDAE() ? RES : RHS;
    
        if (m_odeIsComplex == false && m_pCallFunction[what] != NULL)
        {
            types::typed_list in;
            callOpening(what, in, m_dblT0);
            computeFunction(in, what);
            if (m_odeIsComplex) // complexify Y0 (a clone of user Y0)
            {
                m_pDblY0->setComplex(true);
                if (isDAE())
                {
                    m_pDblYp0->setComplex(true);                        
                }
            }
        }    
    }

    if (m_odeIsExtension && m_odeIsComplex && prevManager->m_odeIsComplex == false)
    {
        sprintf(errorMsg, _("%s: Wrong type (complex) for option \"f\" or \"r\": extended ode is real.\n"), getSolverName().c_str());
        throw ast::InternalError(errorMsg);
    }

}


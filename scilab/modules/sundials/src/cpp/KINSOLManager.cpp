//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "KINSOLManager.hxx"
#include "KINSOLBridge.hxx"
#include "odeparameters.hxx"

extern "C"
{
#include "sciprint.h"
}

void KINSOLManager::parseMatrices(types::typed_list &in)
{
    char errorMsg[256];

    // parse initial conditions.
    if (in[1]->isDouble())
    {
        types::Double *pDbl =  in[1]->getAs<types::Double>();
        if (pDbl->isVector() && pDbl->getRows() == 1)
        {
            pDbl->transpose((types::InternalType *&)m_pDblY0);
        }
        else
        {
            m_pDblY0 = pDbl->clone();
        }
    }
    else
    {
        sprintf(errorMsg, _("%ls: Wrong type for input argument #%d: A real or complex matrix expected.\n"), m_wstrCaller.c_str(),2);
        throw ast::InternalError(errorMsg);
    }
    m_odeIsComplex = m_pDblY0->isComplex();

    m_iNbEq = m_pDblY0->getSize();
    m_iSizeOfInput[RHS] = m_iNbEq; 
    m_iSizeOfInput[JACY] = m_iNbEq*m_iNbEq;
}

void KINSOLManager::parseOptions(types::optional_list &opt)
{
    char errorMsg[256];
    std::vector<int> emptyIntVect = {};
    std::vector<double> emptyDblVect = {};
    std::vector<double> defaultAtolVect = {m_dblDefaultAtol};
    double dblEps = std::numeric_limits<double>::epsilon();

    // nonlinear solver
    getStringInPlist(m_wstrCaller.c_str(), opt, L"method", m_wstrNonLinSolver, getDefaultNonLinSolver(), getAvailableNonLinSolvers());

    // Parse Jacobian
    parseMatrixPattern(opt, L"jacPattern", JACY);
    //TODO: implement jacTimes option !
    if (m_pIPattern[JACY] == NULL)
    {
        getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"jacBand", m_iVecBand[JACY], emptyIntVect, {0, m_iNbEq-1}, {2});
        if (m_iVecBand[JACY].size()>0)
        {
            // if band Jacobian is provided, Sundials packed style is supposed
            m_iSizeOfInput[JACY] = m_iNbEq*(m_iVecBand[JACY][0]+m_iVecBand[JACY][1]+1);
        }
        // parse Jacobian. If constant Jacobian then m_typeOfOutput[JACY] wil be set
        parseFunctionFromOption(opt, L"jacobian", JACY);

        // Detect Jacobian type by calling Scilab user function (if applicable)
        if (m_functionAPI[JACY] == SCILAB_CALLABLE)
        {
            // call will set m_typeOfOutput[JACY]
            types::typed_list in;
            callOpening(JACY, in);
            computeMatrix(in, JACY, NULL);
        }
        else if (m_functionAPI[JACY] == SUNDIALS_DLL)
        {
            // jacNonZeros must be declared if SUNDIALS DLL returns a sparse Jacobian
            getIntInPlist(m_wstrCaller.c_str(), opt, L"jacNonZeros", &m_iNonZeros[JACY], -1, {0, m_iNbEq*m_iNbEq});
            if (m_iNonZeros[JACY] >= 0)
            {
                getStringInPlist(m_wstrCaller.c_str(), opt, L"jacFormat", m_wstrSparseFormat[JACY], L"CSC", {L"CSC",L"CSR"});            
            }
        }
    }

    // KINSOL options
    getDoubleInPlist(m_wstrCaller.c_str(), opt, L"tol", &m_dblTol, std::pow(dblEps,1.0/3.0), {1e-15, std::numeric_limits<double>::infinity()});
    getDoubleInPlist(m_wstrCaller.c_str(), opt, L"stepTol", &m_dblStepTol, std::pow(dblEps,2.0/3.0), {1e-15, std::numeric_limits<double>::infinity()});
    getDoubleInPlist(m_wstrCaller.c_str(), opt, L"maxNewtonStep", &m_dblMaxStep, 0, {1e-15, std::numeric_limits<double>::infinity()});

    getDoubleVectorInPlist(m_wstrCaller.c_str(), opt, L"typicalArg", m_dblVecTypicalX, emptyDblVect, {0, std::numeric_limits<double>::infinity()}, m_iNbEq);
    getDoubleVectorInPlist(m_wstrCaller.c_str(), opt, L"typicalF", m_dblVecTypicalF, emptyDblVect, {0, std::numeric_limits<double>::infinity()}, m_iNbEq);

    getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"positive", m_iVecPositive, emptyIntVect, {1,m_iNbEq}, {1,m_iNbEq});
    getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"negative", m_iVecNegative, emptyIntVect, {1,m_iNbEq}, {1,m_iNbEq});
    getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"nonNegative", m_iVecNonNegative, emptyIntVect, {1,m_iNbEq}, {1,m_iNbEq});
    getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"nonPositive", m_iVecNonPositive, emptyIntVect, {1,m_iNbEq}, {1,m_iNbEq});

    getIntInPlist(m_wstrCaller.c_str(), opt, L"maxIters", &m_iNonLinSolMaxIters, 0, {0, INT_MAX});
    getIntInPlist(m_wstrCaller.c_str(), opt, L"accel", &m_iNonLinSolAccel, 0, {0, INT_MAX});
    getDoubleInPlist(m_wstrCaller.c_str(), opt, L"damping", &m_dblNonLinSolDamping, 1.0, {0.0, 1.0});
    getIntInPlist(m_wstrCaller.c_str(), opt, L"jacUpdateFreq", &m_iJacUpdateFreq, 0, {0, INT_MAX});
    getIntInPlist(m_wstrCaller.c_str(), opt, L"resMonFreq", &m_iResMonFreq, 0, {0, INT_MAX});

    // parse linear solver
    getStringInPlist(m_wstrCaller.c_str(), opt, L"linearSolver", m_wstrLinSolver, getDefaultLinSolver(), getAvailableLinSolvers());

    // iterative solvers
    if (m_wstrLinSolver == L"PCG" || 
        m_wstrLinSolver == L"SBCGS" || 
        m_wstrLinSolver == L"FGMR" || 
        m_wstrLinSolver == L"GMR" || 
        m_wstrLinSolver == L"TFQMR")
    {
        getIntInPlist(m_wstrCaller.c_str(), opt, L"linSolMaxIters", &m_iLinSolMaxIters, 0, {0, INT_MAX});
        getStringInPlist(m_wstrCaller.c_str(), opt, L"precType", m_wstrPrecondType, getAvailablePrecondType()[0], getAvailablePrecondType()); 
    }
    else // direct solvers
    {
        if (m_iJacUpdateFreq > 0 && m_iResMonFreq > 0 && (m_iJacUpdateFreq % m_iResMonFreq) > 0)
        {
            sprintf(errorMsg, _("%ls: jacUpdateFreq must be a multiple of resMonFreq.\n"), m_wstrCaller.c_str());
        }        
    }

    // display
    getStringInPlist(m_wstrCaller.c_str(), opt, L"display", m_wstrDisplay, L"final", {L"none",L"iter",L"final"});
    
    // options with user functions
    parseFunctionFromOption(opt, L"callback", INTCB);

    // Determine if ode is complex (can be already detected if Y0 is complex)
    // in the case where RHS is a Scilab function
    if (m_odeIsComplex == false && m_pCallFunction[RHS] != NULL)
    {
        types::typed_list in;
        callOpening(RHS, in);
        computeFunction(in, RHS);            
        if (m_odeIsComplex) // complexify Y0 (a clone of user Y0)
        {
            m_pDblY0->setComplex(true);
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
            sprintf(errorMsg, _("%ls: %ls is an unknown or invalid (in this context) solver option.\n"), m_wstrCaller.c_str(),wstr.str().c_str());
        }
        else
        {
            sprintf(errorMsg, _("%ls: %ls are unkown or invalid (in this context) solver options.\n"), m_wstrCaller.c_str(),wstr.str().c_str());
        }
        throw ast::InternalError(errorMsg);
    }
}

void KINSOLManager::parseFunctionFromOption(types::optional_list &opt, const wchar_t * _pwstLabel, functionKind what)
{
    types::InternalType *pIn = NULL;
    if (opt.find(_pwstLabel) != opt.end())
    { 
        pIn = opt[_pwstLabel];
        parseFunction(pIn, what);
 
        pIn->DecreaseRef();
        pIn->killMe();
        opt.erase(_pwstLabel);
    }
}

bool KINSOLManager::create()
{
    m_prob_mem = KINCreate(m_sunctx);
    return m_prob_mem == NULL;
}

int KINSOLManager::DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr, N_Vector v, N_Vector Jv, realtype c_j, N_Vector work1, N_Vector work2)
{
    return kinLsDQJtimes(v, Jv, yy, NULL, m_prob_mem);
}

void KINSOLManager::init()
{
    char errorMsg[256];

    // Complex ode is handled by using [real(y); imag(y)] as state,
    // hence the number of *real* equations is twice the number of complex equatioms
    m_iNbRealEq = m_odeIsComplex ? 2*m_iNbEq : m_iNbEq;

    m_N_VectorY = N_VNew_Serial(m_iNbRealEq, m_sunctx);

    if (create())
    {
        sprintf(errorMsg,"Solver create error\n");
        throw ast::InternalError(errorMsg);
    }
    // Load Y0 into N_Serial vector
    // When ODE is complex m_N_VectorY has interlaced real and imaginary part of user Y (equivalent to std::complex)
    m_N_VectorY = N_VNew_Serial(m_iNbRealEq, m_sunctx);
  
    copyRealImgToComplexVector(m_pDblY0->get(), m_pDblY0->getImg(), NV_DATA_S(m_N_VectorY), m_iNbEq, m_odeIsComplex);

    if (m_wstrNonLinSolver == L"fixedPoint" || m_wstrNonLinSolver == L"Picard")
    {
        if (m_iNonLinSolAccel > 0) 
        {
            KINSetMAA(m_prob_mem, m_iNonLinSolAccel);
        }
        if (m_dblNonLinSolDamping != 1.0)
        {
            KINSetDampingAA(m_prob_mem, m_dblNonLinSolDamping);
        }
    }

    if (KINInit(m_prob_mem, KINSOLFun, m_N_VectorY) != KIN_SUCCESS)
    {
        sprintf(errorMsg, "KINInit error");
        throw ast::InternalError(errorMsg);
    }

    // constraints on solution
    if (m_iVecPositive.size() > 0     ||
        m_iVecNonPositive.size() > 0  ||
        m_iVecNegative.size() > 0     ||
        m_iVecNonNegative.size() > 0)
    {
        N_Vector NVConstr = N_VNew_Serial(m_iNbRealEq, m_sunctx);
        for (const auto &it : m_iVecPositive)
        {
            NV_Ith_S(NVConstr,it-1) = 2;
        }
        for (const auto &it : m_iVecNonNegative)
        {
            NV_Ith_S(NVConstr,it-1) = 1;
        }
        for (const auto &it : m_iVecNonPositive)
        {
            NV_Ith_S(NVConstr,it-1) = -1;
        }
        for (const auto &it : m_iVecNegative)
        {
            NV_Ith_S(NVConstr,it-1) = -2;
        }
        if (KINSetConstraints(m_prob_mem, NVConstr) < 0)
        {
            sprintf(errorMsg, "setConstraints error");
            throw ast::InternalError(errorMsg);
        }
    }

    if (KINSetUserData(m_prob_mem, (void *)this) < 0)
    {
        sprintf(errorMsg,"setUserData error\n");
        throw ast::InternalError(errorMsg);
    }
    
    //
    // Set linear solver (if applicable) according to Jacobian type (Dense, band or Sparse)
    //

    if (m_wstrNonLinSolver != L"fixedPoint")
    {
        m_wstrLinSolver = setLinearSolver(JACY, m_N_VectorY, m_A, m_LS);
        KINSetLinearSolver(m_prob_mem, m_LS, m_A);
        
        if (m_bHas[JACY])
        {
            // User provided Jacobian or Jacobian function
            if (KINSetJacFn(m_prob_mem, KINSOLJac) != KIN_SUCCESS)
            {
                sprintf(errorMsg,"KINSetJacFn error\n");
                throw ast::InternalError(errorMsg);
            }
        }
        else if (m_pIPattern[JACY] != NULL)
        {
            // Jacobian pattern has been provided
            if (KINSetJacFn(m_prob_mem, KINSOLColPackJac) != KIN_SUCCESS)
            {
                sprintf(errorMsg,"KINSetJacFn error\n");
                throw ast::InternalError(errorMsg);
            }
        }
    }

    // Scaling vectors
    m_N_VectorTypicalX = N_VNew_Serial(m_iNbRealEq, m_sunctx);
    if (m_dblVecTypicalX.size() > 0)
    {
        if (m_odeIsComplex)
        {
            for (int i=0; i<m_iNbEq; i++)
            {
                NV_Ith_S(m_N_VectorTypicalX,2*i) = 1.0/m_dblVecTypicalX[i];
                NV_Ith_S(m_N_VectorTypicalX,2*i+1) = 1.0/m_dblVecTypicalX[i];                
            }
        }
        else
        {
            for (int i=0; i<m_iNbEq; i++)
            {
                NV_Ith_S(m_N_VectorTypicalX,i) = 1.0/m_dblVecTypicalX[i];
            }
        }
    }
    else
    {
        N_VConst(1,m_N_VectorTypicalX);
    }

    m_N_VectorTypicalF = N_VNew_Serial(m_iNbRealEq, m_sunctx);
    if (m_dblVecTypicalF.size() > 0)
    {
        if (m_odeIsComplex)
        {
            for (int i=0; i<m_iNbEq; i++)
            {
                NV_Ith_S(m_N_VectorTypicalF,2*i) = 1./m_dblVecTypicalF[i];
                NV_Ith_S(m_N_VectorTypicalF,2*i+1) = 1./m_dblVecTypicalF[i];                
            }
        }
        else
        {
            for (int i=0; i<m_iNbEq; i++)
            {
                NV_Ith_S(m_N_VectorTypicalF,i) = 1./m_dblVecTypicalF[i];
            }
        }
    }
    else
    {
        N_VConst(1,m_N_VectorTypicalF);
    }
    
    // Convergence
    
    if (KINSetMaxNewtonStep(m_prob_mem, m_dblMaxStep) < 0)
    {
        sprintf(errorMsg,"KINSetMaxNewtonStep error\n");
        throw ast::InternalError(errorMsg);
    }
    if (KINSetFuncNormTol(m_prob_mem, m_dblTol) < 0)
    {
        sprintf(errorMsg,"KINSetFuncNormTol error\n");
        throw ast::InternalError(errorMsg);
    }
    if (KINSetScaledStepTol(m_prob_mem, m_dblStepTol) < 0)
    {
        sprintf(errorMsg,"KINSetScaledStepTol error\n");
        throw ast::InternalError(errorMsg);
    }
    if (KINSetNumMaxIters(m_prob_mem, m_iNonLinSolMaxIters) < 0)
    {
        sprintf(errorMsg,"KINSetNumMaxIters error\n");
        throw ast::InternalError(errorMsg);        
    }
    
    if (m_iJacUpdateFreq > 0)
    {
        KINSetMaxSetupCalls(m_prob_mem, m_iJacUpdateFreq);
    }
    if (m_iResMonFreq > 0)
    {
        KINSetMaxSubSetupCalls(m_prob_mem, m_iResMonFreq);        
    }
    
    // Error handling and intermediate callback
    
    if (KINSetErrHandlerFn(m_prob_mem, KINSOLErrHandler, (void *)this) < 0)
    {
        sprintf(errorMsg,"setHandlerFunction error\n");
        throw ast::InternalError(errorMsg);
    }

    if (m_bHas[INTCB] || m_wstrDisplay != L"none")
    {
        if (KINSetInfoHandlerFn(m_prob_mem, KINSOLIntCb,  (void *)this) < 0)
        {
            sprintf(errorMsg,"KINSetInfoHandlerFn error\n");
            throw ast::InternalError(errorMsg);
        }
        KINSetPrintLevel(m_prob_mem, 1);
    }
   
}

void KINSOLManager::solve()
{
    char msg[256];
    char emptyStr[1]="";
    m_wstrState = L"init";
    KINSOLIntCb(emptyStr,emptyStr,emptyStr,(void *)this);
    m_wstrState = L"iter";

    auto chrono_begin = std::chrono::steady_clock::now();

    m_liExitCode = KINSol(m_prob_mem, m_N_VectorY, strategy[m_wstrNonLinSolver], m_N_VectorTypicalX, m_N_VectorTypicalF);

    auto chrono_end = std::chrono::steady_clock::now();
    std::chrono::duration<double> diff = (chrono_end - chrono_begin);
    m_dblElapsedTime = diff.count();

    m_wstrState = L"done";
    KINSOLIntCb(emptyStr,emptyStr,emptyStr,(void *)this);

    if (m_wstrDisplay != L"none" && m_liExitCode >= 0)
    {
        switch(m_liExitCode)
        {
            case KIN_SUCCESS:
            sprintf(msg,_("%ls: stopping tolerance on scaled maximum norm of the system function was satisfied.\n"), m_wstrCaller.c_str());
            break;
            case KIN_INITIAL_GUESS_OK:
            sprintf(msg,_("%ls: initial user-supplied guess already satisfies the stopping criterion.\n"), m_wstrCaller.c_str());
            break;
            case KIN_STEP_LT_STPTOL:
            sprintf(msg,_("%ls: stopping tolerance on scaled step length was satisfied.\n"), m_wstrCaller.c_str());            
            break;
        }
        sciprint("\n%s",msg);
    }
}

types::Struct *KINSOLManager::getStats()
{    
    double dblStat[8] = {0.0,0.0,0.0,0.0,0.0,0.0};
    long int iValue;

    std::wstring fieldNames[8] = {L"nIters", L"nRhsEvals", L"nRhsEvalsFD", L"nJacEvals", 
     //L"nLiniters", L"nLinCVFails",
     L"nBacktrack",L"funcNorm", L"stepLength", L"eTime"};

    KINGetNumNonlinSolvIters(m_prob_mem, &iValue); dblStat[0] = (double)iValue;
    KINGetNumFuncEvals(m_prob_mem, &iValue); dblStat[1] = (double)iValue;
    if (m_LS != NULL)
    {
        KINGetNumLinFuncEvals(m_prob_mem, &iValue);  dblStat[2] = (double)iValue;
        KINGetNumJacEvals(m_prob_mem, &iValue);  dblStat[3] = (double)iValue;
//        KINGetNumLinIters(m_prob_mem, &iValue);  dblStat[4] = (double)iValue;
//        KINGetNumLinConvFails(m_prob_mem, &iValue);  dblStat[5] = (double)iValue;
    }
    KINGetNumBacktrackOps(m_prob_mem, &iValue);  dblStat[4] = (double)iValue;
    KINGetFuncNorm(m_prob_mem, &dblStat[5]);
    KINGetStepLength(m_prob_mem, &dblStat[6]);
    dblStat[7] = m_dblElapsedTime;

    types::Struct *pSt = new types::Struct(1,1);
    for (int i=0; i<8; i++)
    {
        pSt->addField(fieldNames[i].c_str());
        pSt->get(0)->set(fieldNames[i].c_str(),new types::Double(dblStat[i]));
    }
    return pSt;    
}

void KINSOLManager::createSolutionOutput(types::typed_list &out)
{
    types::MList *pObj = new types::MList();
    types::String *pStr = new types::String(1,7);
//    char *strExitCode = KINGetReturnFlagName(m_liExitCode);
//    std::string wstrExitCode(strExitCode);
//    free(strExitCode);
    
    int k=0;
    
    pStr->set(k++,L"_odeSolution");
    
    pStr->set(k++,L"solver");
    pStr->set(k++,L"nonLinearSolver");
    pStr->set(k++,L"linearSolver");
//    pStr->set(k++,L"status");
    pStr->set(k++,L"tol");
    pStr->set(k++,L"stepTol");
    pStr->set(k++,L"stats");

    k = 0;
    pObj->set(k++,pStr);
    pObj->set(k++,new types::String(m_wstrSolver.c_str()));
    pObj->set(k++,new types::String(m_wstrNonLinSolver.c_str()));
    pObj->set(k++,new types::String(m_wstrLinSolver.c_str()));
//    pObj->set(k++,new types::String(wstrExitCode.c_str()));
    pObj->set(k++,new types::Double(m_dblTol));
    pObj->set(k++,new types::Double(m_dblStepTol));
    pObj->set(k++,getStats());

    out.push_back(pObj);
}
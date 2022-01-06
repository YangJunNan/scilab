//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "CVODEManager.hxx"
#include "SUNDIALSBridge.hxx"
#include "odeparameters.hxx"
#include "complexHelpers.hxx"

bool CVODEManager::create()
{
    m_prob_mem = NULL;
 
    if (m_wstrMethod == L"ADAMS")
    {
        m_prob_mem = CVodeCreate(CV_ADAMS, m_sunctx);
    }
    else if (m_wstrMethod == L"BDF")
    {
        m_prob_mem = CVodeCreate(CV_BDF, m_sunctx);
    }

    return m_prob_mem == NULL;
}

std::wstring CVODEManager::getDefaultNonLinSolver()
{
    return m_wstrMethod == L"ADAMS" ? L"fixedPoint" : L"Newton";
}

std::vector<std::wstring> CVODEManager::getAvailableNonLinSolvers()
{
    return {L"Newton", L"fixedPoint"};
}

void CVODEManager::parseMethodAndOrder(types::optional_list &opt)
{
    char errorMsg[256];
    int iDefaultMaxOrder = 0;
    std::vector<int> emptyVect = {};
    std::wstring wstrDefaultMethod;

    // Projection (feature in CVODES since version 6.2.0)
    parseFunctionFromOption(opt, L"projection", PROJ);
    getBooleanInPlist(m_wstrCaller.c_str(), opt, L"projectError", &m_bErrProj, m_odeIsExtension ? m_prevManager->m_bErrProj : false);

    // stability limit detection
    getBooleanInPlist(m_wstrCaller.c_str(), opt, L"stabLimDet", &m_bStabLimDet, m_odeIsExtension ? m_prevManager->m_bStabLimDet : false);
 
    // ode solver method
    wstrDefaultMethod = m_odeIsExtension ? m_prevManager->m_wstrMethod : getAvailableMethods()[0];
    getStringInPlist(m_wstrCaller.c_str(), opt, L"method", m_wstrMethod, wstrDefaultMethod, getAvailableMethods());
 
    // order
    iDefaultMaxOrder = m_odeIsExtension ? m_prevManager->m_iMaxOrder : getMaxMethodOrder(m_wstrMethod);
    getIntInPlist(m_wstrCaller.c_str(), opt, L"maxorder", &m_iMaxOrder, iDefaultMaxOrder, {1, getMaxMethodOrder(m_wstrMethod)});
 
    // sensitivity
    if (opt.find(L"sensPar") != opt.end())
    {
        // parameter w.r.t. which sensitivity is to be computed
        if (opt[L"sensPar"]->isDouble())
        {
            types::Double *pDbl =  opt[L"sensPar"]->getAs<types::Double>();
            if (pDbl->isComplex() == false)
            {
                m_pDblSensPar = pDbl;
                m_pDblSensPar->IncreaseRef();
                // add the parameter to parameters list for RHS, SENSRHS, JACY, JACYTIMES before eventual other parameters
                for (auto& what : {RHS, SENSRHS, JACY, JACYTIMES})
                {
                    m_pParameters[what].insert(m_pParameters[what].begin(),m_pDblSensPar);                    
                }
                opt.erase(L"sensPar");
            }
        }
        if (m_pDblSensPar == NULL)
        {
            sprintf(errorMsg, _("%ls: Wrong type for option \"sensPar\": a real double vector is expected.\n"), m_wstrCaller.c_str());
            throw ast::InternalError(errorMsg);            
        }

        // parameter components w.r.t. which sensitivity is to be computed (default is 1:m_pDblSensPar->getSize())
        getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"sensParIndex", m_iVecSensParIndex,
            m_odeIsExtension ? m_prevManager->m_iVecSensParIndex : emptyVect, {1,m_pDblSensPar->getSize()}, {1,m_pDblSensPar->getSize()});

        // Scaling vector (default is ones(getNbSensPar(),1))
        getDoubleVectorInPlist(m_wstrCaller.c_str(), opt, L"typicalPar", m_dblVecTypicalPar,
            m_odeIsExtension ? m_prevManager->m_dblVecTypicalPar : std::vector<double>(getNbSensPar(),1.0), 
            {0, std::numeric_limits<double>::infinity()}, getNbSensPar());

        // initial condition of sensitivity (default is zeros(m_iNbEq,getNbSensPar()))
        if (opt.find(L"yS0") != opt.end())
        {
            if (m_pDblSensPar == NULL)
            {
                sprintf(errorMsg, _("%ls: sensitivity parameter \"sensPar\" has not been set.\n"), m_wstrCaller.c_str());
                throw ast::InternalError(errorMsg);         
            }
            if (opt[L"yS0"]->isDouble())
            {
                types::Double *pDbl = opt[L"yS0"]->getAs<types::Double>();
                if (pDbl->isComplex() == false && pDbl->getDims()==2 && pDbl->getRows() == m_iNbEq && pDbl->getCols() == getNbSensPar())
                {
                    m_pDblSens0 = pDbl;
                    m_pDblSens0->IncreaseRef();
                    opt.erase(L"yS0");
                }
            }
            if (m_pDblSens0 == NULL)
            {
                sprintf(errorMsg, _("%ls: Wrong type and/or size for option \"yS0\": a real double matrix of size %d x %d is expected.\n"), 
                    m_wstrCaller.c_str(),m_iNbEq,getNbSensPar());
                throw ast::InternalError(errorMsg);                
            }
        }
        // default zero matrix
        if (m_pDblSensPar != NULL && m_pDblSens0 == NULL)
        {
            m_pDblSens0 = new types::Double(m_iNbEq,getNbSensPar());
            m_pDblSens0->setZeros();
            m_pDblSens0->IncreaseRef();
        }
        // correction method 
        wstrDefaultMethod = m_odeIsExtension ? m_prevManager->m_wstrMethod : getAvailableMethods()[0];
        getStringInPlist(m_wstrCaller.c_str(), opt, L"sensCorrStep", m_wstrSensCorrStep, 
             m_odeIsExtension ? m_prevManager->m_wstrSensCorrStep : L"simultaneous", {L"simultaneous",L"staggered"});
        // Sensitivity error control (include sensitivity variables in error test, default is false)
        getBooleanInPlist(m_wstrCaller.c_str(), opt, L"sensErrCon", &m_bSensErrCon, m_odeIsExtension ? m_prevManager->m_bSensErrCon : false);
        
        // sensitivity rhs, if user knows how to derive rhs w.r.t. parameter
        parseFunctionFromOption(opt, L"sensRhs",SENSRHS);
        m_iSizeOfInput[SENSRHS] = getNbSensPar()*m_iNbEq;
    }
}

bool CVODEManager::initialize(char *errorMsg)
{
    if (CVodeInit(m_prob_mem, SUNDIALSFun, m_dblT0, m_N_VectorY) != CV_SUCCESS)
    {
        sprintf(errorMsg, "CVodeInit error");
        return true;
    }
    if (computeSens())
    {
        m_NVArraySens = N_VCloneVectorArray(getNbSensPar(), m_N_VectorY);
        // copy each column of S(0) in vectors m_NVArraySens[j], j=0...
        for (int j=0; j<getNbSensPar(); j++)
        {
            copyRealImgToComplexVector(m_pDblSens0->get()+j*m_iNbEq, m_pDblSens0->getImg()+j*m_iNbEq, 
                NV_DATA_S(m_NVArraySens[j]), m_iNbEq, m_odeIsComplex);
        }
        // initialize solver Sensitivity mode with user provided sensitivity rhs or finite difference mode :
        if (CVodeSensInit(m_prob_mem, getNbSensPar(), 
            m_wstrSensCorrStep == L"simultaneous" ? CV_SIMULTANEOUS : CV_STAGGERED, 
            m_bHas[SENSRHS] ? SUNDIALSSensRhs: NULL,
            m_NVArraySens) != CV_SUCCESS)
        {
            sprintf(errorMsg, "CVodeSensInit error");
            return true;            
        }
        if (m_iVecSensParIndex.size() == 0)
        {
            CVodeSetSensParams(m_prob_mem,  m_pDblSensPar->get(), m_dblVecTypicalPar.data(), NULL);
        }
        else
        {
            for(int& d : m_iVecSensParIndex) d--;
            // CVodeSetSensParams does a copy of array elements of last argument
            CVodeSetSensParams(m_prob_mem,  m_pDblSensPar->get(), m_dblVecTypicalPar.data(), m_iVecSensParIndex.data());
            for(int& d : m_iVecSensParIndex) d++;
        }
         if (CVodeSensEEtolerances(m_prob_mem) != CV_SUCCESS)
         {
             sprintf(errorMsg, "CVodeSensEEtolerances error");
             return true;
         }
         if (CVodeSetSensErrCon(m_prob_mem, m_bSensErrCon) != CV_SUCCESS)
         {
             sprintf(errorMsg, "CVodeSetSensErrCon error");
             return true;             
         }

         // there is nothing to do if m_wstrNonLinSolver = L"Newton" as this is the defaut sensitivity solver
         if (m_wstrNonLinSolver == L"fixedPoint")
         {
             /* attach nonlinear solver object to CVode */
             if (m_wstrSensCorrStep == L"simultaneous")
             {
                 m_NLSsens = SUNNonlinSol_FixedPointSens(getNbSensPar()+1, m_N_VectorY, 0, m_sunctx);
                 if (CVodeSetNonlinearSolverSensSim(m_prob_mem, m_NLSsens) != CV_SUCCESS)
                 {
                     sprintf(errorMsg, "CVodeSetNonlinearSolverSensSim error");
                     return true;                          
                 }
             }
             else // CV_STAGGERED
             {
                 m_NLSsens = SUNNonlinSol_FixedPointSens(getNbSensPar(), m_N_VectorY, 0, m_sunctx);
                 if (CVodeSetNonlinearSolverSensStg(m_prob_mem, m_NLSsens) != CV_SUCCESS)
                 {
                     sprintf(errorMsg, "CVodeSetNonlinearSolverSensStg error");
                     return true;                          
                 }                 
             }  
         }
    }
    return false;
}

bool CVODEManager::setSolverAndJacobian(char *errorMsg)
{
    if (m_wstrNonLinSolver == L"Newton")
    {
        if (CVodeSetLinearSolver(m_prob_mem, m_LS, m_A) != CV_SUCCESS)
        {
            sprintf(errorMsg,"CVodeSetLinearSolver error\n");
            return true;
        }
        
        m_NLS = SUNNonlinSol_Newton(m_N_VectorY, m_sunctx);

        if (m_bHas[JACY])
        {
            if (CVodeSetJacFn(m_prob_mem, SUNDIALSJac) != CV_SUCCESS)
            {
                sprintf(errorMsg,"CVodeSetJacFn error\n");
                return true;
            }
        }
        else if (m_pIPattern[JACY] != NULL)
        {
            // Jacobian pattern has been provided
            if (CVodeSetJacFn(m_prob_mem, CVODEColPackJac) != CV_SUCCESS)
            {
                sprintf(errorMsg,"CVodeSetJacFn error\n");
                throw ast::InternalError(errorMsg);
            }
        }
        else
        {
            if (CVodeSetJacFn(m_prob_mem, NULL) != CV_SUCCESS)
            {
                sprintf(errorMsg,"CVodeSetJacFn error\n");
                return true;
            }
            if (m_wstrLinSolver != L"KLU" && m_wstrLinSolver != L"DENSE" && m_iPrecBand.size()>0)
            {
                CVBandPrecInit(m_prob_mem, m_iNbRealEq, m_iPrecBand[0], m_iPrecBand[1]);
            }
        }
    }
    else
    {
        /* create fixed point nonlinear solver object */
        m_NLS = SUNNonlinSol_FixedPoint(m_N_VectorY, m_iNonLinSolAccel, m_sunctx);
    }

    /* attach nonlinear solver object to CVode */
    if (CVodeSetNonlinearSolver(m_prob_mem, m_NLS) != CV_SUCCESS)
    {
        sprintf(errorMsg,"CVodeSetNonlinearSolver error\n");
        return true;
    }
 
    // // attach projection function
    if (m_bHas[PROJ])
    {
        if (CVodeSetProjFn(m_prob_mem, SUNDIALSProj) != CV_SUCCESS)
        {
            sprintf(errorMsg,"CVodeSetProjFn error\n");
            return true;
        }
        if (CVodeSetProjErrEst(m_prob_mem, m_bErrProj) != CV_SUCCESS)
        {
            sprintf(errorMsg,"CVodeSetProjErrEst error\n");
            return true;
        }
    }
    
    if (m_bStabLimDet && CVodeSetStabLimDet(m_prob_mem, m_bStabLimDet) != CV_SUCCESS)
    {
        sprintf(errorMsg,"CVodeSetStabLimDet error\n");
        return true;        
    }
    return false;
}

bool CVODEManager::setEventFunction()
{
    if (CVodeRootInit(m_prob_mem, m_iNbEvents, SUNDIALSEvent) != CV_SUCCESS)
    {
        return true;
    }
    if (m_iVecEventDirection.size() > 0)
    {
        if (CVodeSetRootDirection(m_prob_mem, m_iVecEventDirection.data()) != CV_SUCCESS)
        {
            return true;
        }
    }
    return false;
}

int CVODEManager::getInterpBasisSize()
{
    int iLastOrder;
    CVodeGetLastOrder(m_prob_mem, &iLastOrder);
    return iLastOrder+1;
}

OdeManager::solverReturnCode CVODEManager::doStep(double dblFinalTime, double *pdblTime, solverTaskCode iKind)
{
    std::map<solverTaskCode, int> toCVODETask = {{ODE_ONE_STEP, CV_ONE_STEP}, {ODE_NORMAL, CV_NORMAL}};
 
    int iFlag = CVode(m_prob_mem, dblFinalTime, m_N_VectorY, pdblTime, toCVODETask[iKind]);
    CVodeGetLastOrder(m_prob_mem,&m_iLastOrder);
    return toODEReturn[iFlag];
}


// prepare record vector(s)
void CVODEManager::saveAdditionalStates() 
{
    if (m_odeIsExtension == false)
    {
        if (m_dblT0 == m_pDblTSpan->get(0) || m_iRetCount == 1)
        {
            for (int j=0; j<getNbSensPar(); j++)
            {
                m_vecSOut.push_back(std::vector<double>(NV_DATA_S(m_NVArraySens[j]),NV_DATA_S(m_NVArraySens[j]) + m_iNbRealEq));
            }
        }
    }
    else
    {
        // new values will be appended to previous ones
        m_vecSOut = m_prevManager->m_vecSOut;
        m_dblVecSEvent = m_prevManager->m_dblVecSEvent;
    } 
}

void CVODEManager::saveAdditionalStates(double dblTime)
{
    if (computeSens())
    {
        CVodeGetSensDky(m_prob_mem, dblTime, 0, m_NVArraySens);
        for (int j=0; j<getNbSensPar(); j++)
        {
            m_vecSOut.push_back(std::vector<double>(NV_DATA_S(m_NVArraySens[j]),NV_DATA_S(m_NVArraySens[j]) + m_iNbRealEq));
        }        
    }
}

void CVODEManager::saveAdditionalEventStates(double dblTime)
{
    if (computeSens())
    {
        CVodeGetSensDky(m_prob_mem, dblTime, 0, m_NVArraySens);
        for (int j=0; j<getNbSensPar(); j++)
        {
            m_dblVecSEvent.push_back(std::vector<double>(NV_DATA_S(m_NVArraySens[j]),NV_DATA_S(m_NVArraySens[j]) + m_iNbRealEq));
        }        
    }
}


std::vector<std::pair<std::wstring,types::Double *>> CVODEManager::getAdditionalFields()
{
    std::vector<std::pair<std::wstring,types::Double *>> out;
    if (computeSens())
    {
        out.push_back(std::make_pair(L"s", getSOut()));
    }
    return out;
}

std::vector<std::pair<std::wstring,types::Double *>> CVODEManager::getAdditionalEventFields()
{
    std::vector<std::pair<std::wstring,types::Double *>> out;
    if (computeSens())
    {
        out.push_back(std::make_pair(L"se", getSEvent()));
    }
    return out;
}

void CVODEManager::saveInterpBasisVectors()
{
    CVodeMem cv_mem = (CVodeMem) m_prob_mem;
    // Solution structure output
    // Store current ordrer and Nordsieck History Array
    // N_Vector cv_zn[L_MAX];   Nordsieck array, of size N x (q+1).
    // zn[j] is a vector of length N (j=0,...,q)
    // zn[j] = [1/factorial(j)] * h^j *(jth derivative of the interpolating polynomial)
    // m_indexInterpBasis is the cumulative index later used for solution interpolation
    // m_indexInterpBasis[i] is the column index in whole matrix where NS matrix of timestep i starts.
    m_indexInterpBasis.push_back(m_indexInterpBasis.back()+getInterpBasisSize());

    for (int i=0; i<m_iVecOrder.back()+1; i++)
    {
        std::vector<double> vdblNordsieckVector (NV_DATA_S(cv_mem->cv_zn[i]), NV_DATA_S(cv_mem->cv_zn[i]) + m_iNbRealEq);
        interpBasisVectorList.push_back(vdblNordsieckVector);
    }
}

void CVODEManager::getInterpVectors(double *pdblNS, int iOrderPlusOne, int iIndex, double dblt0, double dblTUser, double dblStep, double *pdblVect, double *pdblVectd)
{
    // pdblNS matrix of Nordsieck vectors not used here (unlike IDA)
    double dblS = (dblTUser-dblt0)/dblStep;
    pdblVect[0] = 1;
    pdblVectd[0] = 0;
    for (int j = 1; j < iOrderPlusOne; j++)
    {
        pdblVectd[j] = pdblVect[j-1]*j/dblStep;
        pdblVect[j] = pdblVect[j-1]*dblS;
    }
}

int CVODEManager::DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr, N_Vector v, N_Vector Jv, realtype c_j, N_Vector work2, N_Vector work3)
{
    return cvLsDQJtimes(v, Jv, tt, yy, yp, m_prob_mem, work2);
}

types::Struct *CVODEManager::getStats()
{
    double dblStat[6] = {0.0,0.0,0.0,0.0,0.0,0.0};
    int qlast;
    int qcur;

    std::wstring fieldNames[15] = {L"nSteps", L"nRhsEvals", L"nRhsEvalsFD", L"nJacEvals", L"nEventEvals",
    L"nLinSolve", L"nRejSteps", L"nNonLiniters", L"nNonLinCVFails", L"order",
    L"hIni", L"hLast", L"hCur", L"tCur", L"eTime"};

    dblStat[4] = m_dblElapsedTime;

    CVodeGetNonlinSolvStats(m_prob_mem, m_incStat+7, m_incStat+8);
    CVodeGetIntegratorStats(m_prob_mem, m_incStat, m_incStat+1, m_incStat+5, m_incStat+6, &qlast, &qcur, dblStat, dblStat+1, dblStat+2, dblStat+3);
    CVodeGetNumGEvals(m_prob_mem, m_incStat+4);
    CVodeGetNumLinSolvSetups(m_prob_mem,m_incStat+5); // CVodeGetIntegratorStats seems broken for nlinsolve(m_incStat+5), hence we do a direct call

    if (m_wstrNonLinSolver == L"Newton")
    {
        CVodeGetNumLinRhsEvals(m_prob_mem, m_incStat+2);
        CVodeGetNumJacEvals(m_prob_mem, m_incStat+3);
    }
    if (computeSens())
    {
        long int li;
        CVodeGetNumRhsEvalsSens(m_prob_mem, &li);
        m_incStat[2] += li;
    }

    // if extending a previous solution, update incremental stats only
    if (m_prevManager != NULL)
    {
        for (int i=0; i<9; i++)
        {
           m_incStat[i] += m_prevManager-> m_incStat[i];
        }
    }
 
    types::Struct *pSt = new types::Struct(1,1);
    for (int i=0; i<9; i++)
    {
        pSt->addField(fieldNames[i].c_str());
        pSt->get(0)->set(fieldNames[i].c_str(),new types::Double((double)m_incStat[i]));
    }

    // order of method for each step
    types::Double *pDblOrder = new types::Double(1,m_iVecOrder.size());
    std::copy(m_iVecOrder.begin(), m_iVecOrder.end(), pDblOrder->get());
    pSt->addField(fieldNames[9].c_str());
    pSt->get(0)->set(fieldNames[9].c_str(), pDblOrder);
 
    for (int i=10; i<15; i++)
    {
        pSt->addField(fieldNames[i].c_str());
        pSt->get(0)->set(fieldNames[i].c_str(), new types::Double(dblStat[i-10]));
    }
    return pSt;
}
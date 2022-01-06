//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "IDAManager.hxx"
#include "SUNDIALSBridge.hxx"
#include "odeparameters.hxx"
#include "complexHelpers.hxx"

#define MSGCV_HNIL_STOP "Internal " MSG_TIME_H " are such that t + h = t on the next step. Singularity likely."

bool IDAManager::create()
{
    m_prob_mem = IDACreate(m_sunctx);
    m_N_VectorYp = N_VNew_Serial(m_iNbRealEq, m_sunctx);

    return m_prob_mem == NULL;
}

std::wstring IDAManager::getDefaultNonLinSolver()
{
    return L"Newton";
}

std::vector<std::wstring> IDAManager::getAvailableNonLinSolvers()
{
    return {L"Newton"};
}

void IDAManager::parseMethodAndOrder(types::optional_list &opt)
{
    std::wstring wstrDefaultNonLinSolver;
    int iDefaultMaxOrder = 0;
    std::wstring wstrDefaultMethod;
    
    // method
    wstrDefaultMethod = m_odeIsExtension ? m_prevManager->m_wstrMethod : getAvailableMethods()[0];
    getStringInPlist(m_wstrCaller.c_str(), opt, L"method", m_wstrMethod, wstrDefaultMethod, getAvailableMethods());
    // order
    iDefaultMaxOrder = m_odeIsExtension ? m_prevManager->m_iMaxOrder : getMaxMethodOrder(m_wstrMethod);
    getIntInPlist(m_wstrCaller.c_str(), opt, L"maxorder", &m_iMaxOrder, iDefaultMaxOrder, {1, getMaxMethodOrder(m_wstrMethod)});
    // non linear solver
    wstrDefaultNonLinSolver = m_odeIsExtension ? m_prevManager->m_wstrNonLinSolver : (m_wstrMethod == L"Adams" ? L"fixedPoint" : L"Newton");
    getStringInPlist(m_wstrCaller.c_str(), opt, L"nonLinSol", m_wstrMethod, wstrDefaultMethod, {L"fixedPoint",L"Newton"});
}

bool IDAManager::initialize(char *errorMsg)
{
    // Load Yp0 if DAE solver (Y0 is loaded in  OdeManager::init)
    copyRealImgToComplexVector(m_pDblYp0->get(), m_pDblYp0->getImg(), NV_DATA_S(m_N_VectorYp), m_iNbEq, m_odeIsComplex);

    if (IDAInit(m_prob_mem, SUNDIALSRes, m_dblT0, m_N_VectorY, m_N_VectorYp) != IDA_SUCCESS)
    {
        sprintf(errorMsg,"IDAInit error.");
    }
    return false;
}

bool IDAManager::computeIC(char *errorMsg)
{
    // compute initial condition, if applicable
    if (m_wstrCalcIc == L"y0yp0")
    {
        // Compute yp0 and algebric components of y0 given differential components of y0
        N_Vector id = N_VNew_Serial(m_iNbRealEq, m_sunctx);
        std::fill(NV_DATA_S(id), NV_DATA_S(id)+m_iNbRealEq, 1);
        for (auto index : m_iVecIsAlgebric)
        {
            NV_DATA_S(id)[index-1] = 0; // 0 means algebric state
            if (m_odeIsComplex)
            {
                NV_DATA_S(id)[index-1+m_iNbEq] = 0; // 0 means algebric state
            }
        }
        if  (IDASetId(m_prob_mem, id) != IDA_SUCCESS)
        {
            sprintf(errorMsg,"IDASetId error\n");
            return true;
        }

        long int iFlag = IDACalcIC(m_prob_mem, IDA_YA_YDP_INIT, m_pDblTSpan->get(m_pDblTSpan->getSize()-1));

        if (iFlag != IDA_SUCCESS)
        {
            sprintf(errorMsg,"IDACalcIC error : %s\n", IDAGetReturnFlagName(iFlag));
            return true;
        }
    }
    else if (m_wstrCalcIc == L"y0")
    {
        // Compute y0 given yp0
        long int iFlag = IDACalcIC(m_prob_mem, IDA_Y_INIT, m_pDblTSpan->get(m_pDblTSpan->getSize()-1));
        if (iFlag != IDA_SUCCESS)
        {
            sprintf(errorMsg,"IDACalcIC error : %s\n", IDAGetReturnFlagName(iFlag));
            return true;
        }
    }
    if (IDAGetConsistentIC(m_prob_mem, m_N_VectorY, m_N_VectorYp) != IDA_SUCCESS)
    {
        sprintf(errorMsg,"IDAGetConsistentIC error\n");
        return true;
    }
    return false;
}

bool IDAManager::setSolverAndJacobian(char *errorMsg)
{
    /* Attach the matrix and linear solver */
    if (IDASetLinearSolver(m_prob_mem, m_LS, m_A) != IDA_SUCCESS)
    {
         sprintf(errorMsg,"IDASetLinearSolver error\n");
         return true;
    }
    
    if (m_bHas[JACYYP])
    {
        if (IDASetJacFn(m_prob_mem, SUNDIALSJacRes) != IDA_SUCCESS)
        {
            sprintf(errorMsg,"IDASetJacFn error\n");
            return true;
        }
        if (m_pIConstFunction[JACY] != NULL)
        {
            // Constant Jacobians case: clone Jacobian template m_A as m_TempSUNMat
            m_TempSUNMat = SUNMatClone(m_A);
            // then copy the constant dR/dy to m_TempSUNMat
            copyMatrixToSUNMatrix(m_pIConstFunction[JACY], m_TempSUNMat, m_iNbEq, m_odeIsComplex);
        }
    }
    else if (m_pIPattern[JACYYP] != NULL)
    {
        // Jacobian pattern has been provided
        if (IDASetJacFn(m_prob_mem, IDAColPackJac) != IDA_SUCCESS)
        {
            sprintf(errorMsg,"IDASetJacFn error\n");
            throw ast::InternalError(errorMsg);
        }
    }

    return false;
}

bool IDAManager::setEventFunction()
{
    if (IDARootInit(m_prob_mem, m_iNbEvents, SUNDIALSImplEvent) != IDA_SUCCESS)
    {
        return true;
    }
    if (m_iVecEventDirection.size() > 0)
    {
        if (IDASetRootDirection(m_prob_mem, m_iVecEventDirection.data()) != IDA_SUCCESS)
        {
            return true;
        }
    }
    return false;
}

int IDAManager::getInterpBasisSize()
{
    int iLastOrder;
    IDAGetLastOrder(m_prob_mem, &iLastOrder);
    return iLastOrder+1;
}


// Stepper function
OdeManager::solverReturnCode IDAManager::doStep(double dblFinalTime, double *pdblTime, solverTaskCode iKind)
{
    std::map<solverTaskCode, int> toIDATask = {{ODE_ONE_STEP, IDA_ONE_STEP}, {ODE_NORMAL, IDA_NORMAL}};
    
    int iFlag = IDASolve(m_prob_mem, dblFinalTime, pdblTime, m_N_VectorY, m_N_VectorYp, toIDATask[iKind]);
    IDAGetLastOrder(m_prob_mem,&m_iLastOrder);
    
    return toODEReturn[iFlag];
}


// prepare record vector(s)
void IDAManager::saveAdditionalStates()    
{
    if (m_odeIsExtension == false)
    {
        if (m_dblT0 == m_pDblTSpan->get(0) || m_iRetCount == 1)
        {
            m_vecYpOut.push_back(std::vector<double>(NV_DATA_S(m_N_VectorYp),NV_DATA_S(m_N_VectorYp) + m_iNbRealEq));
        }
    }
    else
    {
        // new values will be appended to previous ones
        m_vecYpOut = m_prevManager->m_vecYpOut;
        m_dblVecYpEvent = m_prevManager->m_dblVecYpEvent;
    }
}

void IDAManager::saveAdditionalStates(double dblTime)
{
    IDAGetDky(m_prob_mem, dblTime, 1, m_N_VectorYTemp);
    m_vecYpOut.push_back(std::vector<double>(NV_DATA_S(m_N_VectorYTemp), NV_DATA_S(m_N_VectorYTemp) + m_iNbRealEq));
}

void IDAManager::saveAdditionalEventStates(double dblTime)
{
    IDAGetDky(m_prob_mem, dblTime, 1, m_N_VectorYTemp);
    m_dblVecYpEvent.push_back(std::vector<double>(NV_DATA_S(m_N_VectorYTemp), NV_DATA_S(m_N_VectorYTemp) + m_iNbRealEq));
}


std::vector<std::pair<std::wstring,types::Double *>> IDAManager::getAdditionalFields()
{
    std::vector<std::pair<std::wstring,types::Double *>> out;
    out.push_back(std::make_pair(L"yp", getYpOut()));
    return out;
}

std::vector<std::pair<std::wstring,types::Double *>> IDAManager::getAdditionalEventFields()
{
    std::vector<std::pair<std::wstring,types::Double *>> out;
    out.push_back(std::make_pair(L"ype", getYpEvent()));
    return out;
}

void IDAManager::saveInterpBasisVectors()
{
    IDAMem ida_mem = (IDAMem) m_prob_mem;
    m_indexInterpBasis.push_back(m_indexInterpBasis.back()+getInterpBasisSize());

    for (int i=0; i<m_iVecOrder.back()+1; i++)
    {
        std::vector<double> vdblPhiVector (NV_DATA_S(ida_mem->ida_phi[i]), NV_DATA_S(ida_mem->ida_phi[i]) + m_iNbRealEq);
        // add scalar psi[i] at the end of vector phi[i]
        vdblPhiVector.push_back(ida_mem->ida_psi[i]);
        interpBasisVectorList.push_back(vdblPhiVector);
    }
}

void IDAManager::getInterpVectors(double *pdblNS, int iOrderPlusOne, int iIndex, double dblt0, double dblTUser, double dblStep, double *pdblVect, double *pdblVectd)
{
    double dblGamma = 0;
    double dblDelta = dblTUser-dblt0;
    double *pdblPsi = pdblNS + m_iNbRealEq; // psi[0] is the last value of first column (above lines are components of phi0)
    double psi_jm1 = *pdblPsi; // psi[0]
    double psi_j = 0; // psi0

    // code is adapted from IDAGetSolution(() in SUNDIALS ida.c
    dblGamma = dblDelta/psi_jm1;
    pdblVect[0] = 1;
    pdblVectd[0] = 0;
    for (int j = 1; j < iOrderPlusOne; j++)
    {
        pdblVectd[j] = pdblVectd[j-1]*dblGamma + pdblVect[j-1]/psi_jm1;
        pdblVect[j] = pdblVect[j-1]*dblGamma;
        pdblPsi += m_iNbRealEq+1; // NS matrix has m_nbRealEq+1 lines, psi[j] is last element of column j
        psi_j = *pdblPsi;
        dblGamma = (dblDelta + psi_jm1) / psi_j;
        psi_jm1 = psi_j;
    }
}

int IDAManager::DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr, N_Vector v, N_Vector Jv, realtype c_j, N_Vector work2, N_Vector work3)
{
    return idaLsDQJtimes(tt, yy, yp, rr, v, Jv, c_j, m_prob_mem, work2, work3);
}

types::Struct *IDAManager::getStats()
{
    double dblStat[6] = {0.0,0.0,0.0,0.0,0.0,0.0};
    int qlast;
    int qcur;

    std::wstring fieldNames[15] = {L"nSteps", L"nRhsEvals", L"nRhsEvalsFD", L"nJacEvals", L"nEventEvals",
    L"nLinSolve", L"nRejSteps", L"nNonLiniters", L"nNonLinCVFails", L"order",
    L"hIni", L"hLast", L"hCur", L"tCur", L"eTime"};

    IDAGetNonlinSolvStats(m_prob_mem, m_incStat+7, m_incStat+8);
    IDAGetIntegratorStats(m_prob_mem, m_incStat, m_incStat+1, m_incStat+5, m_incStat+6, &qlast, &qcur, dblStat, dblStat+1, dblStat+2, dblStat+3);
    dblStat[4] = m_dblElapsedTime;
    IDAGetNumGEvals(m_prob_mem, m_incStat+4);
    IDAGetNumLinSolvSetups(m_prob_mem,m_incStat+5); // IDAGetIntegratorStats seems broken for nlinsolve(m_incStat+5), hence we do a direct call
    IDAGetNumLinResEvals(m_prob_mem, m_incStat+2);
    IDAGetNumJacEvals(m_prob_mem, m_incStat+3);

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
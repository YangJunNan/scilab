//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "ARKODEManager.hxx"
#include "SUNDIALSBridge.hxx"
#include "odeparameters.hxx"
#include "arkode/arkode_interp_impl.h"

#define MSGCV_HNIL_STOP "Internal " MSG_TIME_H " are such that t + h = t on the next step. Singularity likely."

extern "C"
{
    int ARKStepSetMaxOrd(void *m_prob_mem, int i)
    {
        return 1;
    }
}

bool ARKODEManager::create()
{
    if (m_odeIsImEx)
    {
        m_prob_mem = ARKStepCreate(SUNDIALSFun, SUNDIALSFunStiff, m_dblT0, m_N_VectorY, m_sunctx);
    }
    else if (m_ERKButcherTable != NULL) // pure explicit
    {
        m_prob_mem = ARKStepCreate(SUNDIALSFun, NULL, m_dblT0, m_N_VectorY, m_sunctx);
    }
    else if (m_DIRKButcherTable != NULL) // pure implicit
    {
        m_prob_mem = ARKStepCreate(NULL, SUNDIALSFun, m_dblT0, m_N_VectorY, m_sunctx);
    }
    else
    {
        return true;
    }
    if (m_prob_mem == NULL)
    {
        return true;
    }
    return false;
}

std::wstring ARKODEManager::getDefaultNonLinSolver()
{
    // default is Newton when method is ImEx or fully implicit
    // and NONE when method is fully explicit.
    return m_DIRKButcherTable != NULL ? L"Newton" : L"NONE";
}

std::vector<std::wstring> ARKODEManager::getAvailableNonLinSolvers()
{
    // fixedPoint and Newton are available when method is ImEx or fully implicit
    if (m_DIRKButcherTable != NULL)
    {
        return {L"fixedPoint",L"Newton"};
    }
    // Only NONE is available when method is fully explicit
    return {L"NONE"};
}

void ARKODEManager::parseMethodAndOrder(types::optional_list &opt)
{
    char errorMsg[256];
    std::vector<double> defaultRAtolVect = {m_dblDefaultAtol};
    std::vector<int> emptyVect = {};

    // specific ARKODe options

    // stiff RHS for ImEx method
    if (m_odeIsExtension)
    {
        parseFunctionFromOption(opt, L"stiffRhs",SRHS);
        m_odeIsImEx = m_prevManager->m_odeIsImEx;
    }
    else if (opt.find(L"stiffRhs") != opt.end())
    {
        parseFunctionFromOption(opt, L"stiffRhs", SRHS);
        m_odeIsImEx = true;
    }

    // Parse Mass first (as it restricts the possible methods and other stuff)
    getIntVectorInPlist(m_wstrCaller.c_str(), opt, L"massBand", m_iVecBand[MASS],
        m_odeIsExtension ? m_prevManager->m_iVecBand[MASS] : emptyVect, {0, m_iNbEq-1}, {2});
    if (m_iVecBand[MASS].size()>0)
    {
        // if band Mass is provided, Sundials packed style is supposed
        m_iSizeOfInput[MASS] = m_iNbEq*(m_iVecBand[MASS][0]+m_iVecBand[MASS][1]+1);
    }

    // MASS function or constant mass
    parseFunctionFromOption(opt, L"mass", MASS);
    
    // Detect Mass type by calling Scilab user function (if applicable)
    if (m_functionAPI[MASS] == SCILAB_CALLABLE)
    {
        // call will set m_typeOfOutput[MASS]
        types::typed_list in;
        in.push_back(new types::Double(m_dblT0));
        computeMatrix(in, MASS);
    }
    else if (m_functionAPI[MASS] == SUNDIALS_DLL)
    {
        // massNonZeros must be declared if SUNDIALS DLL returns a sparse Jacobian
        getIntInPlist(m_wstrCaller.c_str(), opt, L"massNonZeros", &m_iNonZeros[MASS],
            m_odeIsExtension ? m_prevManager->m_iNonZeros[MASS] : -1, {0, m_iNbEq*m_iNbEq});
    }

    // User Butcher tableau
    if (m_odeIsExtension)
    {
        m_ERKButcherTable = m_prevManager->m_ERKButcherTable; // can be NULL
        m_DIRKButcherTable = m_prevManager->m_DIRKButcherTable; // can be NULL
    }
    else
    {
        getButcherTableInPlist(m_wstrCaller.c_str(), opt, L"ERKButcherTableau", m_ERKButcherTable);
        getButcherTableInPlist(m_wstrCaller.c_str(), opt, L"DIRKButcherTableau", m_DIRKButcherTable);
    }

    if (m_ERKButcherTable != NULL || m_DIRKButcherTable != NULL)
    {
        if (m_odeIsImEx)
        {
            if (m_ERKButcherTable == NULL || m_DIRKButcherTable == NULL)
            {
                sprintf(errorMsg, _("arkode: both ERKButcherTableau and DIRKButcherTableau must be set in imEx mode.\n"));
                throw ast::InternalError(errorMsg);
            }
            ARKodeButcherTable_CheckARKOrder(m_DIRKButcherTable, m_ERKButcherTable, &m_iMethodOrder , &m_iEmbeddedMethodOrder, NULL);
            std::wstringstream wss;
            wss << L"USER_ARK_" << m_ERKButcherTable->stages << L"_" << m_iMethodOrder << L"_" << m_iEmbeddedMethodOrder;
            m_wstrMethod.assign(wss.str()); 
        }
        else if (m_ERKButcherTable != NULL && m_DIRKButcherTable != NULL)
        {
            sprintf(errorMsg, _("%arkode: ""stiffRhs"" must be set in imEx mode.\n"));
            throw ast::InternalError(errorMsg);
        }
        std::wstringstream wss;
        if (m_ERKButcherTable != NULL)
        {
            wss << L"USER_ERK_" << m_ERKButcherTable->stages << L"_" << m_ERKButcherTable->p << L"_" << m_ERKButcherTable->q;
            m_iMethodOrder = m_ERKButcherTable->q;
            m_iEmbeddedMethodOrder = m_ERKButcherTable->p;
        }
        if (m_DIRKButcherTable != NULL)
        {
            wss << L"USER_DIRK_" << m_DIRKButcherTable->stages << L"_" << m_DIRKButcherTable->p << L"_" << m_DIRKButcherTable->q;            
            m_iMethodOrder = m_DIRKButcherTable->q;
            m_iEmbeddedMethodOrder = m_DIRKButcherTable->p;
        }
        m_wstrMethod = wss.str();
    }
    else
    {
        // parse eventual "method" option
        std::wstring wStrDefaultMethod = m_odeIsExtension ? m_prevManager->m_wstrMethod : (m_odeIsImEx ? L"ARK" : hasJacobian() ? L"DIRK" : L"ERK");
        getStringInPlist(m_wstrCaller.c_str(), opt, L"method", m_wstrMethod, wStrDefaultMethod, getAvailableMethods());        
        m_iMethodOrder = ARKODEMethods[m_wstrMethod].order;
        m_iEmbeddedMethodOrder = ARKODEMethods[m_wstrMethod].embeddedOrder;
        // get standard SUNDIALS tableaux
        if (ARKODEMethods[m_wstrMethod].dirkID >= ARKODE_MIN_DIRK_NUM)
        {
            m_DIRKButcherTable = ARKodeButcherTable_LoadDIRK(ARKODEMethods[m_wstrMethod].dirkID);            
        }
        if (ARKODEMethods[m_wstrMethod].erkID >= ARKODE_MIN_ERK_NUM)
        {
            m_ERKButcherTable = ARKodeButcherTable_LoadERK(ARKODEMethods[m_wstrMethod].erkID);                
        }        
    }

    // linearity of implicit part
    if (m_DIRKButcherTable != NULL) // implicit or ImEx
    {
        std::wstring wStrDefaultLinear = m_odeIsExtension ? m_prevManager->m_wstrIsLinear : L"no";
        getStringInPlist(m_wstrCaller.c_str(), opt, L"linear", m_wstrIsLinear, wStrDefaultLinear, {L"no",L"constant",L"timeDepend"});
    }

    // interpolation (cannot be changed when extending solution)
    if (m_odeIsExtension)
    {
        m_wstrInterpolationMethod = m_prevManager->m_wstrInterpolationMethod;
        m_iInterpolationMethod = m_prevManager->m_iInterpolationMethod;
        m_iInterpolationDegree = m_prevManager->m_iInterpolationDegree;
    }
    else
    {
        getStringInPlist(m_wstrCaller.c_str(), opt, L"interpolation", m_wstrInterpolationMethod, L"Hermite", {L"Hermite",L"Lagrange"});
        int iMaxInterpolationDegree = m_wstrInterpolationMethod == L"Hermite" ? 5:3;
        getIntInPlist(m_wstrCaller.c_str(), opt, L"degree", &m_iInterpolationDegree, iMaxInterpolationDegree, {0,iMaxInterpolationDegree});
        m_iInterpolationMethod = m_wstrInterpolationMethod == L"Hermite" ? ARK_INTERP_HERMITE : ARK_INTERP_LAGRANGE;
    }

    // Absolute tolerance for the residual norm in nonlinear solver iterations
    getDoubleVectorInPlist(m_wstrCaller.c_str(), opt, L"ratol", m_dblVecRAtol,
        m_odeIsExtension ? m_prevManager->m_dblVecRAtol : defaultRAtolVect, {1e-15, std::numeric_limits<double>::infinity()}, m_iNbEq);
}

void ARKODEManager::getButcherTableInPlist(const wchar_t * _pwstCaller, types::optional_list &opt, const wchar_t * _pwstLabel, ARKodeButcherTable &butcherTable)
{
    char errorMsg[1024];
    types::InternalType *pI = NULL;
    if (opt.find(_pwstLabel) != opt.end())
    {
        pI = opt[_pwstLabel];
        if (pI->isDouble() == false)
        {
            sprintf(errorMsg, _("%ls: wrong value type for parameter \"%ls\": %s expected.\n"), _pwstCaller, _pwstLabel, "double");
            throw ast::InternalError(errorMsg);
        }
        types::Double *pDbl = pI->getAs<types::Double>();

        int iStages = pDbl->getCols()-1;
        // Check if table size is these of a Butcher table with embedded method
        if (iStages < 1 || pDbl->getRows() != iStages+2)
        {
            sprintf(errorMsg, _("%ls: wrong size for parameter \"%ls\": size should be (s+2,s+1), where s is the number of stages.\n"), _pwstCaller, _pwstLabel);
            throw ast::InternalError(errorMsg);
        }
        double *pdblA = new double[iStages*iStages];
        double *pdblb = new double[iStages];
        double *pdblc = new double[iStages];
        double *pdbld = new double[iStages];
        int q,p;

        for (int i=0; i<iStages; i++)
        {
            pdblc[i] = pDbl->get(i,0);
            pdblb[i] = pDbl->get(iStages,i+1);
            pdbld[i] = pDbl->get(iStages+1,i+1);
            for (int j=0; j<iStages; j++)
            {
                pdblA[j+i*iStages] = pDbl->get(i,j+1);
            }
        }
        q = pDbl->get(iStages,0);
        p = pDbl->get(iStages+1,0);
        butcherTable = ARKodeButcherTable_Create(iStages, q, p, pdblc, pdblA, pdblb, pdbld);
        if (butcherTable == NULL)
        {
            sprintf(errorMsg, _("%ls: wrong value for parameter \"%ls\": incoherent tableau.\n"), _pwstCaller, _pwstLabel);
            throw ast::InternalError(errorMsg);
        }
        int iRes = ARKodeButcherTable_CheckOrder(butcherTable, &q, &p, NULL);
        if (iRes != 0)
        {
            if ((butcherTable->q >= 6 && q==6) || (butcherTable->p >= 6 && p==6))
            {
                sciprint(_("%ls: parameter \"%ls\": sufficient conditions not met for order > 6\n"), _pwstCaller, _pwstLabel);                
            }
            else
            {
                sprintf(errorMsg, _("%ls: wrong value for parameter \"%ls\": claimed orders are (%d,%d) while computed orders are (%d,%d)\n"),
                 _pwstCaller, _pwstLabel,butcherTable->q,butcherTable->p,q,p);            
                throw ast::InternalError(errorMsg);                
            }
        }
        delete[] pdblA;
        delete[] pdblb;
        delete[] pdblc;
        delete[] pdbld;
    }
    else
    {
        butcherTable = NULL;
        return;
    }

    pI->DecreaseRef();
    pI->killMe();
    opt.erase(_pwstLabel);
}

bool ARKODEManager::initialize(char *errorMsg)
{
    if (ARKStepSetTables(m_prob_mem, m_iMethodOrder, m_iEmbeddedMethodOrder, m_DIRKButcherTable, m_ERKButcherTable) != ARK_SUCCESS)
    {
        sprintf(errorMsg, "ARKStepSetTables error");
        return true;                
    };

    // interpolant type and degree
    m_iInterpolationDegree = std::min(m_iMethodOrder-1,m_iInterpolationDegree);
    ARKStepSetInterpolantType(m_prob_mem, m_iInterpolationMethod);
    ARKStepSetInterpolantDegree(m_prob_mem, m_iInterpolationDegree);

    // Absolute residual tolerance (used by ARKODE only)
    if (m_dblVecRAtol.size() > 0)
    {
        m_N_VectorRAtol = N_VNew_Serial(m_iNbRealEq, m_sunctx);
        if (m_odeIsComplex)
        {
            m_dblVecRAtol.resize(m_iNbRealEq);
            for (int i=0; i<m_iNbEq; i++)
            {
                m_dblVecRAtol[i+m_iNbEq] = m_dblVecRAtol[i];
            }
        }
        std::copy(m_dblVecRAtol.begin(), m_dblVecRAtol.end(), NV_DATA_S(m_N_VectorRAtol));
    }
    if (ARKStepResVtolerance(m_prob_mem, m_N_VectorRAtol) < 0)
    {
        sprintf(errorMsg, "ARKStepResVtolerance error");
        return true;
    }

    return false;
}

bool ARKODEManager::setSolverAndJacobian(char *errorMsg)
{
    // Mass matrix
    if (m_bHas[MASS])
    {
        bool bMassTimeDep = m_pIConstFunction[MASS] == NULL;

        setLinearSolver(MASS, m_N_VectorY, m_MASS, m_MASS_LS);
  
        if(ARKStepSetMassLinearSolver(m_prob_mem, m_MASS_LS, m_MASS, bMassTimeDep) != ARK_SUCCESS)
        {
            sprintf(errorMsg,"ARKStepSetMassLinearSolver error\n");
            return true;
        }
        if (ARKStepSetMassFn(m_prob_mem, SUNDIALSMass)  != ARK_SUCCESS)
        {
            {
                sprintf(errorMsg,"ARKStepSetMassFn error\n");
                return true;
            }
        }
    }

    // if method is purely explicit, exit
    if (m_ERKButcherTable != NULL || m_DIRKButcherTable != NULL)
    {
        if (m_DIRKButcherTable == NULL)
        {
            return false;
        }
    }
    else if (ARKODEMethods[m_wstrMethod].dirkID == ARKODE_DIRK_NONE)
    {
        return false;
    }

    if (m_wstrNonLinSolver == L"Newton")
    {
        if (ARKStepSetLinearSolver(m_prob_mem, m_LS, m_A) != ARK_SUCCESS)
        {
            sprintf(errorMsg,"ARKStepSetLinearSolver error\n");
            return true;
        }

        m_NLS = SUNNonlinSol_Newton(m_N_VectorY, m_sunctx);

        if (m_bHas[JACY])
        {
            if (ARKStepSetJacFn(m_prob_mem, SUNDIALSJac) != ARK_SUCCESS)
            {
                sprintf(errorMsg,"ARKStepSetJacFn error\n");
                return true;
            }
        }
        else if (m_pIPattern[JACY] != NULL)
        {
            // Jacobian pattern has been provided
            if (ARKStepSetJacFn(m_prob_mem, ARKODEColPackJac) != ARK_SUCCESS)
            {
                sprintf(errorMsg,"ARKStepSetJacFn error\n");
                throw ast::InternalError(errorMsg);
            }
        }
        else if (ARKStepSetJacFn(m_prob_mem, NULL) != ARK_SUCCESS)
        {
            sprintf(errorMsg,"ARKStepSetJacFn error\n");
            return true;
        }
        // Jacobian of implicit part is constant or only time dependent
        if (m_pIConstFunction[JACY] != NULL || m_wstrIsLinear == L"constant")
        {
            if (ARKStepSetLinear(m_prob_mem,0) != ARK_SUCCESS)
            {
                sprintf(errorMsg,"ARKStepSetLinear error\n");
                return true;
            }
        }
        else if (m_wstrIsLinear == L"timeDepend")
        {
            if (ARKStepSetLinear(m_prob_mem,1) != ARK_SUCCESS)
            {
                sprintf(errorMsg,"ARKStepSetLinear error\n");
                return true;
            }
        }
        if (m_wstrLinSolver != L"KLU" && m_wstrLinSolver != L"DENSE" && m_iPrecBand.size()>0)
        {
            sciprint("BANDPREC\n");
            ARKBandPrecInit(m_prob_mem, m_iNbRealEq, m_iPrecBand[0], m_iPrecBand[1]);
        }
    }
    else
    {
        /* create fixed point nonlinear solver object */
        m_NLS = SUNNonlinSol_FixedPoint(m_N_VectorY, m_iNonLinSolAccel, m_sunctx);
    }

    /* attach nonlinear solver object to ARKODE */
    if (ARKStepSetNonlinearSolver(m_prob_mem, m_NLS) != ARK_SUCCESS)
    {
        sprintf(errorMsg,"ARKStepSetNonlinearSolver error\n");
        return true;
    }
    if (m_iNonLinSolMaxIters > 0)
    {
        ARKStepSetMaxNonlinIters(m_prob_mem, m_iNonLinSolMaxIters);
    }

    return false;
}

bool ARKODEManager::setEventFunction()
{
    if (ARKStepRootInit(m_prob_mem, m_iNbEvents, SUNDIALSEvent) != ARK_SUCCESS)
    {
        return true;
    }
    if (m_iVecEventDirection.size() > 0)
    {
        if (ARKStepSetRootDirection(m_prob_mem, m_iVecEventDirection.data()) != ARK_SUCCESS)
        {
            return true;
        }
    }
    return false;
}

int ARKODEManager::getInterpBasisSize()
{
    return std::max(2,m_iInterpolationDegree+1);
}

// Stepper function. Note: ARKODE does not return Yp, but prototype is imposed by Odemanager class
// to include IDA stepper prototype, which yields Yp.
OdeManager::solverReturnCode ARKODEManager::doStep(double dblFinalTime, double *pdblTime, solverTaskCode iKind)
{
    std::map<solverTaskCode, int> toARKODETask = {{ODE_ONE_STEP, ARK_ONE_STEP}, {ODE_NORMAL, ARK_NORMAL}};

    int iFlag = ARKStepEvolve(m_prob_mem, dblFinalTime, m_N_VectorY, pdblTime, toARKODETask[iKind]);
    m_iLastOrder = m_iMethodOrder;

    return toODEReturn[iFlag];
}

int ARKODEManager::getBasisDimensionAtIndex(int iIndex)
{
    if (m_iInterpolationMethod == ARK_INTERP_HERMITE)
    {
        return m_indexInterpBasis[iIndex] -  m_indexInterpBasis[iIndex - 1];                
    }
    else
    {
        // ARK_INTERP_LAGRANGE
        return std::min(iIndex+1,m_iInterpolationDegree+1);
    }
}

double *ARKODEManager::getBasisAtIndex(int iIndex)
{
    if (m_iInterpolationMethod == ARK_INTERP_HERMITE)
    {
        return m_pDblInterpBasisVectors->get() + m_indexInterpBasis[iIndex-1]*m_pDblInterpBasisVectors->getRows();
    }
    else
    {
        // ARK_INTERP_LAGRANGE
        int iDim = std::min(iIndex+1,m_iInterpolationDegree+1);
        return m_pDblInterpBasisVectors->get() + (iIndex-iDim+1)*m_pDblInterpBasisVectors->getRows();
    }
}

void ARKODEManager::saveInterpBasisVectors()
{
    ARKodeMem ark_mem = (ARKodeMem) m_prob_mem;
    ARKInterp interp = ark_mem->interp;
    m_indexInterpBasis.push_back(m_indexInterpBasis.back()+getInterpBasisSize());

    if (m_iInterpolationMethod == ARK_INTERP_HERMITE)
    {
        std::vector<double> basisVector (m_iNbRealEq);
        basisVector.assign(NV_DATA_S(HINT_YOLD(interp)), NV_DATA_S(HINT_YOLD(interp)) + m_iNbRealEq);
        interpBasisVectorList.push_back(basisVector);
        basisVector.assign(NV_DATA_S(HINT_YNEW(interp)), NV_DATA_S(HINT_YNEW(interp)) + m_iNbRealEq);
        interpBasisVectorList.push_back(basisVector);
        if (m_iInterpolationDegree > 1)
        {
            basisVector.assign(NV_DATA_S(HINT_FNEW(interp)), NV_DATA_S(HINT_FNEW(interp)) + m_iNbRealEq);
            interpBasisVectorList.push_back(basisVector);
        }
        if (m_iInterpolationDegree > 2)
        {
            basisVector.assign(NV_DATA_S(HINT_FOLD(interp)), NV_DATA_S(HINT_FOLD(interp)) + m_iNbRealEq);
            interpBasisVectorList.push_back(basisVector);
        }
        if (m_iInterpolationDegree > 3)
        {
            // the call below just aims ensure that FA and FB exist
            arkInterpEvaluate(ark_mem, ark_mem->interp, 0.0, 0, ARK_INTERP_MAX_DEGREE, m_N_VectorYTemp);

            basisVector.assign(NV_DATA_S(HINT_FA(interp)), NV_DATA_S(HINT_FA(interp)) + m_iNbRealEq);
            interpBasisVectorList.push_back(basisVector);
        }
        if (m_iInterpolationDegree > 4)
        {
            basisVector.assign(NV_DATA_S(HINT_FB(interp)), NV_DATA_S(HINT_FB(interp)) + m_iNbRealEq);
            interpBasisVectorList.push_back(basisVector);
        }
    }
}

void ARKODEManager::getInterpVectors(double *pdblNS, int iOrderPlusOne, int iIndex, double dblt0, double dblTUser, double h, double *pdblVect, double *pdblVectd)
{
    char errorMsg[256];
    double tau = (dblTUser-dblt0)/h;
    double tval, a0, a1, tau2, tau3, tau4, tau5;
    double h2, h3, h4, h5;
    /* The code comes from arkInterpEvaluate_Hermite in arkode_interp.c */
    tau2 = tau*tau;
    tau3 = tau*tau2;
    tau4 = tau*tau3;
    tau5 = tau*tau4;

    h2 = h*h;
    h3 = h*h2;
    h4 = h*h3;
    h5 = h*h4;
    if (m_iInterpolationMethod == ARK_INTERP_HERMITE)
    {
        switch (m_iInterpolationDegree) {

            case(0):    /* constant interpolant, yout = 0.5*(yn+yp) */
            pdblVect[0] = 0.5;
            pdblVect[1] = 0.5;
            pdblVectd[0] = 0;
            pdblVectd[1] = 0;
            break;

            case(1):    /* linear interpolant */
            pdblVect[0] = -tau;
            pdblVect[1] = ONE+tau;
            pdblVectd[0] = -ONE/h;
            pdblVectd[1] =  ONE/h;
            break;

            case(2):    /* quadratic interpolant */
            pdblVect[0] = tau2;
            pdblVect[1] = ONE - tau2;
            pdblVect[2] = h*(tau2 + tau);
            pdblVectd[0] = TWO*tau/h;
            pdblVectd[1] = -TWO*tau/h;
            pdblVectd[2] = (ONE + TWO*tau);
            break;

            case(3):    /* cubic interpolant */
            // [2] and [3] are inverted since we store YOLD,YNEW,FNEW,FOLD (in that order)
            pdblVect[0] = THREE*tau2 + TWO*tau3;
            pdblVect[1] = ONE - THREE*tau2 - TWO*tau3;
            pdblVect[3] = h*(tau2 + tau3);
            pdblVect[2] = h*(tau + TWO*tau2 + tau3);
            pdblVectd[0] = SIX*(tau + tau2)/h;
            pdblVectd[1] = -SIX*(tau + tau2)/h;
            pdblVectd[3] = TWO*tau + THREE*tau2;
            pdblVectd[2] = ONE + FOUR*tau + THREE*tau2;
            break;

            case(4):    /* quartic interpolant */
            // [2] and [3] are inverted since we store YOLD,YNEW,FNEW,FOLD,FA (in that order)
            pdblVect[0] = -SIX*tau2 - RCONST(16.0)*tau3 - RCONST(9.0)*tau4;
            pdblVect[1] = ONE + SIX*tau2 + RCONST(16.0)*tau3 + RCONST(9.0)*tau4;
            pdblVect[3] = h*FOURTH*(-FIVE*tau2 - RCONST(14.0)*tau3 - RCONST(9.0)*tau4);
            pdblVect[2] = h*(tau + TWO*tau2 + tau3);
            pdblVect[4] = h*RCONST(27.0)*FOURTH*(-tau4 - TWO*tau3 - tau2);
            pdblVectd[0] = (-TWELVE*tau - RCONST(48.0)*tau2 - RCONST(36.0)*tau3)/h;
            pdblVectd[1] = (TWELVE*tau + RCONST(48.0)*tau2 + RCONST(36.0)*tau3)/h;
            pdblVectd[3] = HALF*(-FIVE*tau - RCONST(21.0)*tau2 - RCONST(18.0)*tau3);
            pdblVectd[2] = (ONE + FOUR*tau + THREE*tau2);
            pdblVectd[4] = -RCONST(27.0)*HALF*(TWO*tau3 + THREE*tau2 + tau);
            break;

            case(5):    /* quintic interpolant */
            // [2] and [3] are inverted since we store YOLD,YNEW,FNEW,FOLD,FA,FB (in that order)
            pdblVect[0] = RCONST(54.0)*tau5 + RCONST(135.0)*tau4 + RCONST(110.0)*tau3 + RCONST(30.0)*tau2;
            pdblVect[1] = ONE - pdblVect[0];
            pdblVect[3] = h/FOUR*(RCONST(27.0)*tau5 + RCONST(63.0)*tau4 + RCONST(49.0)*tau3 + RCONST(13.0)*tau2);
            pdblVect[2] = h/FOUR*(RCONST(27.0)*tau5 + RCONST(72.0)*tau4 + RCONST(67.0)*tau3 + RCONST(26.0)*tau2 + FOUR*tau);
            pdblVect[4] = h/FOUR*(RCONST(81.0)*tau5 + RCONST(189.0)*tau4 + RCONST(135.0)*tau3 + RCONST(27.0)*tau2);
            pdblVect[5] = h/FOUR*(RCONST(81.0)*tau5 + RCONST(216.0)*tau4 + RCONST(189.0)*tau3 + RCONST(54.0)*tau2);
            pdblVectd[0] = (RCONST(270.0)*tau4 + RCONST(540.0)*tau3 + RCONST(330.0)*tau2 + RCONST(60.0)*tau)/h;
            pdblVectd[1] = -pdblVectd[0];
            pdblVectd[3] = (RCONST(135.0)*tau4 + RCONST(252.0)*tau3 + RCONST(147.0)*tau2 + RCONST(26.0)*tau)/FOUR;
            pdblVectd[2] = (RCONST(135.0)*tau4 + RCONST(288.0)*tau3 + RCONST(201.0)*tau2 + RCONST(52.0)*tau + FOUR)/FOUR;
            pdblVectd[4] = (RCONST(405.0)*tau4 + RCONST(4.0)*189*tau3 + RCONST(405.0)*tau2 + RCONST(54.0)*tau)/FOUR;
            pdblVectd[5] = (RCONST(405.0)*tau4 + RCONST(864.0)*tau3 + RCONST(567.0)*tau2 + RCONST(108.0)*tau)/FOUR;
            break;

            default:
            sprintf(errorMsg, _("%ls: %d is an invalid interpolation degree \n"), getCallerName().c_str(), m_iInterpolationDegree);
            throw ast::InternalError(errorMsg);
        }
    }
    else
    {
        int iDim = std::min(iIndex+1,m_iInterpolationDegree+1);
        double q = 0;
        for (int j=0; j<iDim; j++)
        {
            // compute the value of jth Lagrange polynomial at t=dblTUser
            pdblVect[j] = 1.0;
            for (int k=0; k<iDim; k++)
            {
                if (k==j) continue;
                pdblVect[j] *= (dblTUser - m_dblVecCurrTime[iIndex-iDim+1+k])/(m_dblVecCurrTime[iIndex-iDim+1+j] - m_dblVecCurrTime[iIndex-iDim+1+k]);                    
            }
            // compute the value of the derivative of jth Lagrange polynomial at t=dblTUser
            // formula is obtained by derivating the logarithm of jth Lagrange polynomial
            pdblVectd[j] = 0;
            for (int i=0; i<iDim; i++)
            {
                if (i == j) continue;
                q = 1.0;
                for (int k=0; k<iDim; k++)
                {
                  if (k == j) continue;
                  if (k == i) continue;
                  q *= (dblTUser-m_dblVecCurrTime[iIndex-iDim+1+k])/(m_dblVecCurrTime[iIndex-iDim+1+j]-m_dblVecCurrTime[iIndex-iDim+1+k]);
                }
                pdblVectd[i] += q/(m_dblVecCurrTime[iIndex-iDim+1+j]-m_dblVecCurrTime[iIndex-iDim+1+i]);
            }            
        }
    }
}

int ARKODEManager::DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr, N_Vector v, N_Vector Jv, realtype c_j, N_Vector work2, N_Vector work3)
{
    return arkLsDQJtimes(v, Jv, tt, yy, yp, m_prob_mem, work2);
}

types::Struct *ARKODEManager::getStats()
{
    double dblStat[7] = {0.0,0.0,0.0,0.0,0.0,0.0,0.0};
    long int liNfeEvals,liNfiEvals;

    std::wstring fieldNames[16] = {L"nSteps", L"nRhsExplEvals", L"nRhsImplEvals", L"nRhsEvalsFD", L"nJacEvals", L"nEventEvals",
    L"nLinSolve", L"nRejSteps", L"nNonLiniters", L"nNonLinCVFails", L"order",
    L"hIni", L"hLast", L"hCur", L"tCur", L"eTime"};

    ARKStepGetStepStats(m_prob_mem, m_incStat, dblStat, dblStat+1, dblStat+2, dblStat+3);

    dblStat[4] = m_dblElapsedTime;
    ARKStepGetNumStepAttempts(m_prob_mem, m_incStat+7);
    m_incStat[7] = m_incStat[7]-m_incStat[0];

    ARKStepGetNumRhsEvals(m_prob_mem,  m_incStat+1, m_incStat+2);

    if (m_wstrNonLinSolver == L"Newton")
    {
        ARKStepGetNumLinSolvSetups(m_prob_mem, m_incStat+6);
        ARKStepGetNumJacEvals(m_prob_mem, m_incStat+4);
        ARKStepGetNumLinRhsEvals(m_prob_mem, m_incStat+3);
    }
    ARKStepGetNonlinSolvStats(m_prob_mem, m_incStat+8, m_incStat+9);

    if (m_iNbEvents > 0)
    {
        ARKStepGetNumGEvals(m_prob_mem, m_incStat+5);
    }

    // if extending a previous solution, update incremental stats only
    if (m_prevManager != NULL)
    {
        for (int i=0; i<10; i++)
        {
           m_incStat[i] += m_prevManager-> m_incStat[i];
        }
    }

    types::Struct *pSt = new types::Struct(1,1);
    for (int i=0; i<10; i++)
    {
        pSt->addField(fieldNames[i].c_str());
        pSt->get(0)->set(fieldNames[i].c_str(),new types::Double((double)m_incStat[i]));
    }

    // order of method for each step
    types::Double *pDblOrder = new types::Double(m_iMethodOrder);
    pSt->addField(fieldNames[10].c_str());
    pSt->get(0)->set(fieldNames[10].c_str(), pDblOrder);

    for (int i=11; i<16; i++)
    {
        pSt->addField(fieldNames[i].c_str());
        pSt->get(0)->set(fieldNames[i].c_str(), new types::Double(dblStat[i-11]));
    }
    return pSt;
}





















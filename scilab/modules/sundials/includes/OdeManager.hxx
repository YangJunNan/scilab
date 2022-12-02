//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef _ODEMANAGER_HXX_
#define _ODEMANAGER_HXX_

#include "SUNDIALSManager.hxx"
#include "SUNDIALSBridge.hxx"

class SUNDIALS_EXPORT OdeManager : public SUNDIALSManager
{
    public :

    OdeManager(const std::wstring& callerName, const std::wstring& solverName) : SUNDIALSManager(callerName, solverName)
    {
        m_iSizeOfInput[EVENTS] = -1;
        m_dblOptT0 = NAN;
        m_dblInitialStep = NAN;
        m_iNbEvents = 0;
    }

    virtual ~OdeManager() {
        if (m_N_VectorYp != NULL) N_VDestroy(m_N_VectorYp);
        if (m_MASS != NULL) SUNMatDestroy(m_MASS);
        if (m_MASS_LS != NULL) SUNLinSolFree(m_MASS_LS);
        if (m_TempSUNMat != NULL) SUNMatDestroy(m_TempSUNMat);
        SUNDIALSMANAGER_KILLME(m_pDblInterpBasisVectors);
    };

    enum solverTaskCode {ODE_NORMAL, ODE_ONE_STEP};
    enum solverReturnCode {ODE_SUCCESS=0, ODE_TSTOP_RETURN, ODE_ROOT_RETURN,
        ODE_CONV_FAILURE, ODE_TOO_MUCH_WORK, ODE_REPTD_RHSFUNC_ERR, ODE_REP_RES_ERR, ODE_WARNING};

    std::map<int, solverReturnCode> toODEReturn;
    std::map<solverReturnCode,int> fromODEReturn;

    types::Double *getTOut()
    {
            // time at the begining of each internal step of the method
            types::Double *pDblTOut = new types::Double(1,m_dblVecTOut.size());
            std::copy(m_dblVecTOut.begin(), m_dblVecTOut.end(), pDblTOut->get());
            return pDblTOut;
    }

    types::Double *getYOut()
    {
        // solution y at user prescribed timesteps or at each internal step of the method
        return getArrayFromVectors(m_pDblY0, m_vecYOut, m_dblVecTOut.size());
    }

    types::Double *getIndexEvent()
    {
        types::Double *pDbl = new types::Double(m_iNbEvents, m_dblVecIndexEvent.size());
        for (int i = 0; i < m_dblVecIndexEvent.size(); i++)
        {
            std::copy(m_dblVecIndexEvent[i].begin(), m_dblVecIndexEvent[i].end(), pDbl->get() + i*m_iNbEvents);
        }
        return pDbl;
    }

    types::Double *getTEvent()
    {
        types::Double *pDbl = new types::Double(1,m_dblVecEventTime.size());
        std::copy(m_dblVecEventTime.begin(), m_dblVecEventTime.end(), pDbl->get());
        return pDbl;
    }

    types::Double *getYEvent()
    {
        return getArrayFromVectors(m_pDblY0, m_dblVecYEvent,m_dblVecEventTime.size());
    }

    std::vector<double> getStepVector()
    {
        return m_dblVecStep;
    }
    std::vector<double> getCurrTimeVector()
    {
        return m_dblVecCurrTime;
    }

    int getNbEvents()
    {
        return m_iNbEvents;
    }

    bool getErrProj()
    {
        return m_bErrProj;
    }

    types::Double *getInterpBasis()
    {
        return m_pDblInterpBasisVectors;
    }

    std::vector<int> getInterpBasisIndex()
    {
        return m_indexInterpBasis;
    }
 
    SUNMatrix getTempSunMatrix()
    {
        return m_TempSUNMat;
    }
 
    int (*setUserData)(void *,void *);
    int (*setInitStep)(void *, realtype);
    int (*setMinStep)(void *, realtype);
    int (*setMaxStep)(void *, realtype);
    int (*setMaxNumSteps)(void *, long int);
    int (*setStopTime)(void *, realtype);
    int (*setMaxOrd)(void *, int);
    int (*getCurrentTime)(void *, double *);
    int (*getCurrentStep)(void *, double *);
    int (*getRootInfo)(void *, int *);
    int (*setConstraints)(void *, N_Vector);
    int (*setVTolerances)(void *, realtype, N_Vector);
    int (*setErrHandlerFn)(void *, SUNDIALSErrHandlerType, void *);
    int (*getDky)(void *, realtype, int, N_Vector);
    int (*getSens)(void *, realtype *, N_Vector *);
    int (*getSensDky)(void *, realtype, int, N_Vector *);
    int (*getLastStep)(void *, double *);
    char *(*getReturnFlagName)(long int);

    // SUNDIALSManager methods implemented in OdeManager 
    void callOpening(functionKind what, types::typed_list &in, double t, double *pdblY = NULL, double *pdblYp = NULL);
    void parseFunctionFromOption(types::optional_list &opt, const wchar_t * _pwstLabel, functionKind what);
    void parseMatrices(types::typed_list &in);
    void parseOptions(types::optional_list &opt);
    void init();
    void solve();
    types::Double *parseInitialCondition(types::typed_list &in, bool bIsDerivative);

    // New OdeManager specific methods
    void setupEvents(types::optional_list &opt);
    void createSolutionOutput(types::typed_list &out);
    types::Double *createYOut(types::Double *pDblTemplate, int iNbOut, int iSizeTSpan, bool bFlat = false);
    types::Double *getArrayFromVectors(types::Double *pDblTemplate, std::vector<std::vector<double>> &m_vecY, int iTSpanSize);
    void errHandler(int error_code, const char *module, const char *function, char *msg);

    virtual std::wstring getMethodName()
    {
        return m_wstrMethod;
    }
    virtual std::wstring getInterpolationMethod()
    {
        return L"native";
    }
    virtual bool computeIC(char *)
    {
        return false;
    }
    virtual std::vector<std::pair<std::wstring,types::Double *>> getAdditionalFields()
    {
        return {};
    }
    virtual std::vector<std::pair<std::wstring,types::Double *>> getAdditionalEventFields()
    {
        return {};
    }
    virtual void saveAdditionalStates()
    {}
    virtual void saveAdditionalStates(double dblTime)
    {}
    virtual void saveAdditionalEventStates(double dblTime)
    {}
    virtual int getNbSensPar()
    {
        return 0;
    }

    virtual int getBasisDimensionAtIndex(int iIndex);
    virtual double *getBasisAtIndex(int iIndex);

    // pure OdeManager virtual methods
    virtual void parseMethodAndOrder(types::optional_list &opt) = 0;
    virtual bool initialize(char *) = 0;
    virtual bool setEventFunction() = 0;
    virtual bool setSolverAndJacobian(char *errorMsg) = 0;
    virtual int getInterpBasisSize() = 0;
    virtual solverReturnCode doStep(double dblFinalTime, double *pdblTime, solverTaskCode iKind) = 0;
    virtual void saveInterpBasisVectors() = 0;
    virtual OdeManager *getPreviousManager() = 0;
    virtual std::vector<std::wstring> getAvailableMethods() = 0;
    virtual int getMaxMethodOrder(std::wstring wstrMethod) = 0;
    virtual void getInterpVectors(double *pdblNS, int iOrderPlusOne, int iIndex, double dblt0, double dblTUser, 
                                  double dblStep, double *pdblVect, double *pdblVectd) = 0;

    protected :
 
    std::wstring m_wstrMethod;
  
    N_Vector m_N_VectorYp = NULL;
    N_Vector m_N_VectorYTemp = NULL;

    SUNMatrix m_MASS = NULL;
    SUNMatrix m_TempSUNMat = NULL;
    SUNLinearSolver m_MASS_LS = NULL;
    SUNNonlinearSolver m_NLSsens = NULL;
    types::Double *m_pDblTSpan = NULL;
    types::Double *m_pDblYp0 = NULL;
    types::Double *m_pDblTOut = NULL;
    types::Double *m_pDblYpOut = NULL;

    std::vector<double> m_dblVecTypicalPar;

    std::vector<double> m_dblVecStep;
    std::vector<double> m_dblVecCurrTime;
    std::vector<int> m_iVecOrder;
    std::vector<int> m_iVecInterpBasisSize;
    std::vector<std::vector<double>> m_vecYOut;
 
    std::vector<int> m_iVecEventIsTerminal;
    std::vector<int> m_iVecEventDirection;
    std::vector<int> m_iVecIsAlgebraic;

    std::vector<int> m_iVecSensParIndex;

    std::vector<std::vector<double>> m_dblVecYEvent;
    std::vector<std::vector<int>> m_dblVecIndexEvent;
    std::vector<double> m_dblVecEventTime;

    std::wstring m_wstrCalcIc;
    std::wstring m_wstrSensCorrStep;
    // continuous formula vectors
    // Nordsieck vectors for CVODE, Phi/Psi vectors for IDA
    std::vector<int> m_indexInterpBasis;
    std::list<std::vector<double>> interpBasisVectorList;
    types::Double *m_pDblInterpBasisVectors = NULL;
 
    bool m_bSuppressAlg = false;
    bool m_odeIsExtension = false;
    bool m_odeIsImEx = false;
    bool m_bErrProj = false;
    bool m_bStabLimDet = false;
    bool m_bSensErrCon = false;

    double m_dblT0;
    double m_dblOptT0;
    double m_dblCurrentStep;
    double m_dblInitialStep;
    double m_dblMaxStep;
    double m_dblMinStep;

    int m_iMaxOrder;
    int m_iLastOrder;
    int m_iMaxNumSteps;
    int m_iNbEvents;
    int m_iNRefine;
 
    void *m_prob_mem = NULL;
};

#endif

//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef _IDAMANAGER_HXX_
#define _IDAMANAGER_HXX_

#include "OdeManager.hxx"

#include <ida/ida_impl.h>
#include <ida/ida_ls_impl.h>
#include <ida/ida.h>            /* prototypes for IDA fcts. and consts. */
#include <ida/ida_direct.h>    /* prototypes for various DlsMat operations */

extern "C"
{
    void SUN_chemres(int *n, double *t, double y[], double yd[], double r[]);
    void SUN_chemjac(int *n, double *t, double *cj, double y[], double yd[], double r[], double j[]);
    void SUN_chemevent(int *n,double *t,double *y, double *yd, int *ng, double *g, int *term, int *dir);
    int SUN_chemcb(int *n,double *t,double *y, double *yd, int *flag);
}

class SUNDIALS_EXPORT IDAManager final : public OdeManager
{
    public :

    IDAManager(const std::wstring& callerName, const std::wstring& solverName, IDAManager* prevManager = NULL) : OdeManager(callerName, solverName)
    {
        m_prevManager = prevManager;
        m_odeIsExtension = (prevManager != NULL);
        m_staticFunctionMap[L"SUN_chemres"] = (dynlibFunPtr)SUN_chemres;
        m_staticFunctionMap[L"SUN_chemjac"] = (dynlibFunPtr)SUN_chemjac;
        m_staticFunctionMap[L"SUN_chemevent"] = (dynlibFunPtr)SUN_chemevent;
        m_staticFunctionMap[L"SUN_chemcb"] = (dynlibFunPtr)SUN_chemcb;
 
        setUserData = IDASetUserData;
        setInitStep = IDASetInitStep;
        setMinStep = IDASetMinStep;
        setMaxStep = IDASetMaxStep;
        setMaxNumSteps = IDASetMaxNumSteps;
        setStopTime = IDASetStopTime;
        setMaxOrd = IDASetMaxOrd;
        getCurrentTime = IDAGetCurrentTime;
        getCurrentStep = IDAGetCurrentStep;
        getLastStep = IDAGetLastStep;
        getRootInfo = IDAGetRootInfo;
        setConstraints = IDASetConstraints;
        setVTolerances = IDASVtolerances;
        setErrHandlerFn = IDASetErrHandlerFn;
        getReturnFlagName = IDAGetReturnFlagName;
        getDky = IDAGetDky;
        LsATimes = idaLsATimes;

        toODEReturn.emplace(IDA_SUCCESS, ODE_SUCCESS);
        toODEReturn.emplace(IDA_TSTOP_RETURN, ODE_TSTOP_RETURN);
        toODEReturn.emplace(IDA_ROOT_RETURN, ODE_ROOT_RETURN);
        toODEReturn.emplace(IDA_CONV_FAIL, ODE_CONV_FAILURE);
        toODEReturn.emplace(IDA_TOO_MUCH_WORK, ODE_TOO_MUCH_WORK);
        toODEReturn.emplace(IDA_REP_RES_ERR, ODE_REP_RES_ERR);
        toODEReturn.emplace(IDA_WARNING, ODE_WARNING);

        fromODEReturn.emplace(ODE_SUCCESS, IDA_SUCCESS);
        fromODEReturn.emplace(ODE_TSTOP_RETURN, IDA_TSTOP_RETURN );
        fromODEReturn.emplace(ODE_ROOT_RETURN, IDA_ROOT_RETURN);
        fromODEReturn.emplace(ODE_CONV_FAILURE, IDA_CONV_FAIL);
        fromODEReturn.emplace(ODE_TOO_MUCH_WORK, IDA_TOO_MUCH_WORK);
        fromODEReturn.emplace(ODE_REP_RES_ERR, IDA_REP_RES_ERR);
        fromODEReturn.emplace(ODE_WARNING, IDA_WARNING);
     }

    ~IDAManager() {
        if (m_prob_mem != NULL)
        {
            if (m_prob_mem != NULL) IDAFree(&m_prob_mem);
            m_prob_mem = NULL;
        }
    }

    OdeManager *getPreviousManager()
    {
        return m_prevManager;
    }
    
    virtual bool isDAE()
    {
        return true;
    }

    types::Double *getYpOut()
    {
        // solution y' at user prescribed timesteps or at each internal step of the method
        return getArrayFromVectors(m_pDblY0, m_vecYpOut, m_dblVecTOut.size());
    }

    types::Double *getYpEvent()
    {
        return getArrayFromVectors(m_pDblY0, m_dblVecYpEvent, m_dblVecEventTime.size());
    }

    std::vector<std::pair<std::wstring,types::Double *>> getAdditionalFields();
    std::vector<std::pair<std::wstring,types::Double *>> getAdditionalEventFields();
    void saveAdditionalStates();
    void saveAdditionalStates(double dblTime);
    void saveAdditionalEventStates(double dblTime);

    bool setMaxOrder();
    bool computeIC(char *errorMsg);
    std::wstring getDefaultNonLinSolver();
    std::vector<std::wstring> getAvailableNonLinSolvers();
    void parseMethodAndOrder(types::optional_list &opt);
    bool create();
    bool initialize(char *errorMsg);
    // void errHandler(int error_code, const char *module, const char *function, char *msg);
    bool setEventFunction();
    bool setSolverAndJacobian(char *errorMsg);
    int getInterpBasisSize();
    solverReturnCode doStep(double dblFinalTime, double *pdblTime, solverTaskCode iKind);
    void saveInterpBasisVectors();
    void getInterpVectors(double *pdblNS, int iOrderPlusOne, int iIndex, double dblt0, double dblTUser, double dblStep, double *pdblVect, double *pdblVectd);

    types::Struct *getStats();

    int DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr,
                  N_Vector v, N_Vector Jv, realtype c_j,
                  N_Vector work1, N_Vector work2);

    std::vector<std::wstring> getAvailableMethods()
    {
        std::vector<std::wstring> availableMethods = {L"BDF"};
        return availableMethods;
    }

    int getMaxMethodOrder(std::wstring wstrMethod)
    {
        return 5;
    }

    std::vector<std::wstring> getAvailablePrecondType()
    {
        std::vector<std::wstring> available = {L"NONE",L"LEFT"};
        return available;
    }

    std::wstring getDefaultPrecondType()
    {
        if  (m_iPrecBand.size() > 0)
        {
            return L"LEFT";
        }
        else
        {
            return L"NONE";            
        }
    }

    private :

    IDAManager* m_prevManager;

    std::vector<std::vector<double>> m_vecYpOut;
    std::vector<std::vector<double>> m_dblVecYpEvent;

    long int m_incStat[9] = {0,0,0,0,0,0,0,0,0};
};

#endif


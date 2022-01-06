//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef _CVODEMANAGER_HXX_
#define _CVODEMANAGER_HXX_

#include "OdeManager.hxx"

#include <cvodes/cvodes_impl.h>
#include <cvodes/cvodes_ls_impl.h>
#include <cvodes/cvodes.h>            /* prototypes for CVODES fcts. and consts. */
#include <cvodes/cvodes_direct.h>    /* prototypes for various DlsMat operations */
#include <cvodes/cvodes_proj.h>
#include <cvodes/cvodes_bandpre.h>
#include <nvector/nvector_serial.h>    /* access to serial N_Vector       */
#include <sunmatrix/sunmatrix_dense.h> /* access to dense SUNmatrix       */
#include <sunlinsol/sunlinsol_dense.h> /* access to dense SUNLinearSolver */

extern "C"
{
    int SUN_dynrhs(realtype t, N_Vector Y, N_Vector Yd, void *user_data);
    int SUN_dynrhspar(realtype t, N_Vector Y, N_Vector Yd, void *user_data);
    int SUN_dynjac(realtype t, N_Vector Y, N_Vector Yd, SUNMatrix J, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
    int SUN_dynjacpar(realtype t, N_Vector Y, N_Vector Yd, SUNMatrix J, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
    int SUN_dyncb(realtype t, int iFlag, N_Vector N_VectorY, void *user_data);
    int SUN_dynevent(realtype t, N_Vector Y, realtype *gout, void *user_data);
    int SUN_dyneventpar(realtype t, N_Vector Y, realtype *gout, void *user_data);
}

typedef void(*dynlibFunPtr)();

class SUNDIALS_EXPORT CVODEManager final : public OdeManager
{
public :

    CVODEManager(const std::wstring& callerName, const std::wstring& solverName, CVODEManager* prevManager = NULL) : OdeManager(callerName, solverName)
    {
        m_prevManager = prevManager;
        m_odeIsExtension = (prevManager != NULL);
        m_staticFunctionMap[L"SUN_dynrhs"] = (dynlibFunPtr)SUN_dynrhs;
        m_staticFunctionMap[L"SUN_dynrhspar"] = (dynlibFunPtr)SUN_dynrhspar;
        m_staticFunctionMap[L"SUN_dynjac"] = (dynlibFunPtr)SUN_dynjac;
        m_staticFunctionMap[L"SUN_dynjacpar"] = (dynlibFunPtr)SUN_dynjacpar;
        m_staticFunctionMap[L"SUN_dyncb"] = (dynlibFunPtr)SUN_dyncb;
        m_staticFunctionMap[L"SUN_dynevent"] = (dynlibFunPtr)SUN_dynevent;
        m_staticFunctionMap[L"SUN_dyneventpar"] = (dynlibFunPtr)SUN_dyneventpar;

        setUserData = CVodeSetUserData;
        setInitStep = CVodeSetInitStep;
        setMinStep = CVodeSetMinStep;
        setMaxStep = CVodeSetMaxStep;
        setMaxNumSteps = CVodeSetMaxNumSteps;
        setStopTime = CVodeSetStopTime;
        setMaxOrd = CVodeSetMaxOrd;
        getCurrentTime = CVodeGetCurrentTime;
        getCurrentStep = CVodeGetCurrentStep;
        getLastStep = CVodeGetLastStep;
        getRootInfo = CVodeGetRootInfo;
        setConstraints = CVodeSetConstraints;
        setVTolerances = CVodeSVtolerances;
        setErrHandlerFn = CVodeSetErrHandlerFn;
        getReturnFlagName = CVodeGetReturnFlagName;
        getDky = CVodeGetDky;
        getSens = CVodeGetSens;
        getSensDky = CVodeGetSensDky;
        LsATimes = cvLsATimes;

        toODEReturn.emplace(CV_SUCCESS, ODE_SUCCESS);
        toODEReturn.emplace(CV_TSTOP_RETURN, ODE_TSTOP_RETURN);
        toODEReturn.emplace(CV_ROOT_RETURN, ODE_ROOT_RETURN);
        toODEReturn.emplace(CV_CONV_FAILURE, ODE_CONV_FAILURE);
        toODEReturn.emplace(CV_TOO_MUCH_WORK, ODE_TOO_MUCH_WORK);
        toODEReturn.emplace(CV_REPTD_RHSFUNC_ERR, ODE_REPTD_RHSFUNC_ERR);
        toODEReturn.emplace(CV_WARNING, ODE_WARNING);

        fromODEReturn.emplace(ODE_SUCCESS, CV_SUCCESS);
        fromODEReturn.emplace(ODE_TSTOP_RETURN, CV_TSTOP_RETURN );
        fromODEReturn.emplace(ODE_ROOT_RETURN, CV_ROOT_RETURN);
        fromODEReturn.emplace(ODE_CONV_FAILURE, CV_CONV_FAILURE);
        fromODEReturn.emplace(ODE_TOO_MUCH_WORK, CV_TOO_MUCH_WORK);
        fromODEReturn.emplace(ODE_REPTD_RHSFUNC_ERR, CV_REPTD_RHSFUNC_ERR);
        fromODEReturn.emplace(ODE_WARNING, CV_WARNING);
    }

    ~CVODEManager()
    {
        if (m_prob_mem != NULL)
        {
            CVodeFree(&m_prob_mem);
        }
        m_prob_mem = NULL;
        if (m_NVArraySens != NULL)
        {
            for (int i=0; i<getNbSensPar(); i++)
            {
                N_VDestroy_Serial(m_NVArraySens[i]);
            }
            //N_VDestroyVectorArray_Serial(m_NVArraySens, getNbSensPar());
            m_NVArraySens = NULL;
        }
        SUNDIALSMANAGER_KILLME(m_pDblSensPar);
        SUNDIALSMANAGER_KILLME(m_pDblSens0);
    };

    OdeManager *getPreviousManager()
    {
        return m_prevManager;
    }

    virtual bool isODE()
    {
        return true;
    }

    types::Double *getSOut()
    {
        // sensitivity at user prescribed timesteps or at each internal step of the method
        return getArrayFromVectors(m_pDblSens0, m_vecSOut, m_dblVecTOut.size());
    }

    types::Double *getSEvent()
    {
        return getArrayFromVectors(m_pDblSens0, m_dblVecSEvent, m_dblVecEventTime.size());
    }

    std::vector<std::pair<std::wstring,types::Double *>> getAdditionalFields();
    std::vector<std::pair<std::wstring,types::Double *>> getAdditionalEventFields();
    void saveAdditionalStates();
    void saveAdditionalStates(double dblTime);
    void saveAdditionalEventStates(double dblTime);

    void parseMethodAndOrder(types::optional_list &opt);
    std::wstring getDefaultNonLinSolver();
    std::vector<std::wstring> getAvailableNonLinSolvers();
    bool create();
    bool initialize(char *);
    // void errHandler(int error_code, const char *module, const char *function, char *msg);
    bool setMaxOrder();
    bool setEventFunction();
    bool setSolverAndJacobian(char *errorMsg);
    int getInterpBasisSize();
    solverReturnCode doStep(double dblFinalTime, double *pdblTime, solverTaskCode iKind);
    void saveInterpBasisVectors();
    void getInterpVectors(double *pdblNS, int iOrderPlusOne, int iIndex, double dblt0, double dblTUser, double dblStep, double *pdblVect, double *pdblVectd);
    bool initSensitivity(char *errorMsg);

    int DQJtimes(realtype tt, N_Vector yy, N_Vector yp, N_Vector rr,
                  N_Vector v, N_Vector Jv, realtype c_j,
                  N_Vector work1, N_Vector work2);

    types::Struct *getStats();

    std::vector<std::wstring> getAvailableMethods()
    {
        std::vector<std::wstring> availableMethods = {};
        if (hasJacobian() == false && m_bHas[PROJ] == false)
        {
            availableMethods.push_back(L"ADAMS")  ;
        }
        availableMethods.push_back(L"BDF");
        return availableMethods;
    }

    int getMaxMethodOrder(std::wstring wstrMethod)
    {
        return wstrMethod == L"ADAMS" ? 12 : 5;
    }

    bool computeSens()
    {
        return m_pDblSensPar != NULL;
    }
    int getNbSensPar()
    {
        return m_pDblSensPar == NULL ? 0 : (m_iVecSensParIndex.size()==0 ? m_pDblSensPar->getSize() : m_iVecSensParIndex.size());
    }

    bool hasBandPrec()
    {
        return true;
    }
private :

    CVODEManager* m_prevManager;

    types::Double *m_pDblSensPar = NULL;
    types::Double *m_pDblSens0 = NULL;

    N_Vector *m_NVArraySens = NULL;

    std::vector<std::vector<double>> m_vecSOut;
    std::vector<std::vector<double>> m_dblVecSEvent;

    long int m_incStat[9] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
};

#endif

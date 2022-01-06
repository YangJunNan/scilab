//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef _SUNDIALSBRIDGE_HXX_
#define _SUNDIALSBRIDGE_HXX_

int SUNDIALSEvent(realtype t, N_Vector y, realtype *gout, void *pManager);
int SUNDIALSImplEvent(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, realtype *pdblOut, void *pManager);
int SUNDIALSIntCb(realtype t, int iFlag, N_Vector N_VectorY, N_Vector N_VectorYp, void *pManager);

int SUNDIALSFun(realtype t, N_Vector y, N_Vector ydot, void *pManager);
int SUNDIALSFunStiff(realtype t, N_Vector y, N_Vector ydot, void *pManager);
int SUNDIALSJac(realtype t, N_Vector y, N_Vector fy, SUNMatrix J, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
int SUNDIALSMass(realtype t, SUNMatrix M, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
int SUNDIALSProj(realtype t, N_Vector N_VectorY, N_Vector N_VectorCorr, realtype epsProj, N_Vector N_VectorErr, void *pmanager);
int SUNDIALSSensRhs(int Ns, realtype t, N_Vector N_VectorY, N_Vector ydot, N_Vector *yS, N_Vector *ySdot, void *pmanager, N_Vector tmp1, N_Vector tmp2);

int SUNDIALSRes(realtype t, N_Vector y, N_Vector ydot, N_Vector res, void *pManager);
int SUNDIALSJacRes(realtype t, realtype c, N_Vector y, N_Vector yp, N_Vector r, SUNMatrix J, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);

int SUNDIALSColPackJac(realtype t, realtype c, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector N_VectorR,
    SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);

int CVODEColPackJac(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
int ARKODEColPackJac(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
int IDAColPackJac(realtype t, realtype c, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector N_VectorR, 
    SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);

typedef void (*SUNDIALSErrHandlerType)(int error_code, const char *module, const char *function, char *msg, void *pManager);
void SUNDIALSErrHandler(int error_code, const char *module, const char *function, char *msg, void *pManager);

typedef int (*SUN_DynFun)(realtype t, N_Vector y, N_Vector ydot, void *pManager);
typedef int (*SUN_DynJacFun)(realtype t, N_Vector y, N_Vector fy, SUNMatrix J, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
typedef int (*SUN_DynRes)(realtype t, N_Vector y, N_Vector ydot, N_Vector res, void *pManager);
typedef int (*SUN_DynJacRes)(realtype t, realtype c, N_Vector y, N_Vector yp, N_Vector r, SUNMatrix J, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
typedef int (*SUN_DynMass)(realtype t, SUNMatrix M, void *user_data, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3);
typedef int (*SUN_DynProj)(realtype t, N_Vector N_VectorY, N_Vector N_VectorCorr, realtype epsProj, N_Vector N_VectorErr, void *pmanager);
typedef int (*SUN_DynEvent)(realtype t, N_Vector y, realtype *gout, void *pManager);
typedef int (*SUN_DynSensRhs)(int Ns, realtype t, N_Vector N_VectorY, N_Vector ydot, N_Vector *yS, N_Vector *ySdot, void *pmanager, N_Vector tmp1, N_Vector tmp2);
typedef int (*SUN_DynImplEvent)(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, realtype *pdblOut, void *pManager);
typedef int (*SUN_DynCallBack)(realtype t, int iFlag, N_Vector N_VectorY, void *pManager);
typedef int (*SUN_DynImplCallBack)(realtype t, int iFlag, N_Vector N_VectorY, N_Vector N_VectorYp, void *pManager);


static std::map<int, std::wstring> wstrCbState = {{-1,L"init"}, {0,L"step"}, {1,L"event"}, {2,L"done"}};

#endif

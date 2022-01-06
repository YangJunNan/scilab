//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "complexHelpers.hxx"
#include "KINSOLManager.hxx"
#include "KINSOLBridge.hxx"

void KINSOLIntCb(const char *module, const char *function, char *msg, void *pManager)
{
    // Unlike the ODE callback, we stop the solver by triggering a failing code
    // returned by the equation system user function, by means of manager->setUserStop(true)

    int iRet = 0;
    int iNonLinIt = 0;
    char errorMsg[256];
    KINSOLManager *manager = static_cast<KINSOLManager *>(pManager);
    KINSOLManager::functionKind what = KINSOLManager::INTCB;
    KINSOLManager::functionAPI fAPI = manager->getFunctionAPI(what);
    std::string strMsg(msg);
    std::string strFunc(function);

    std::map<std::wstring,int> mapStateFlag = {{L"init",-1},{L"iter",0},{L"done",1}};

    if (manager->getState() == L"init" && manager->getDisplay() == L"iter")
    {
        sciprint("  Iter    Fcall            norm(F)         norm(step)    bt \n");
        return;
    }

    N_Vector U = manager->getMem()->kin_uu;
    sscanf(strMsg.c_str(),"nni = %d",&iNonLinIt);
    // first callback call is done before KINSol first call
    // hence we replace current iterate by Y0
    if (U == NULL)
    {
        U = manager->getY();
    }

    if (strMsg.find("nni =") != std::string::npos)
    {
        if (manager->getDisplay() == L"iter" && manager->getState() == L"iter")
        {
            char msg[256];
            void* mem = manager->getmem();
            long int iFuncEval = 0;
            long int iFuncEvalFD = 0;
            long int iBt = 0;
            double dblNorm = 0.0;
            double dblStep = 0.0;

            KINGetNumFuncEvals(mem, &iFuncEval);
            if (manager->getNonLinSol()==L"Newton" || manager->getNonLinSol()==L"lineSearch")
            {
                KINGetNumLinFuncEvals(mem, &iFuncEvalFD);                
                KINGetStepLength(mem, &dblStep);
                KINGetNumBacktrackOps(mem, &iBt);
            }
            KINGetFuncNorm(mem, &dblNorm);
            sprintf(msg,"%6d   %6d     %13.8e     %13.8e   %3d",iNonLinIt,iFuncEval+iFuncEvalFD,dblNorm,dblStep,iBt);
            sciprint("%s\n",msg);
        }
    }

    // Display callback
    if (fAPI == KINSOLManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        types::typed_list out;
        bool bTerm;
        manager->callOpening(what, in, NV_DATA_S(U));
        in.push_back(new types::String(manager->getState().c_str()));
        in.push_back(manager->getStats());        
        manager->callClosing(what, in, {1}, out);
        // Scalar boolean expected
        if (out[0]->isBool() == false || out[0]->getAs<types::Bool>()->getSize() != 1)
        {
            sprintf(errorMsg, _("%s: Wrong type for output argument #%d: scalar boolean expected.\n"), manager->getFunctionName(what), 1);
            throw ast::InternalError(errorMsg);
        }
        manager->setUserStop(out[0]->getAs<types::Bool>()->get(0));        
        
        out[0]->DecreaseRef();
        out[0]->killMe();
    }
    else if (fAPI == KINSOLManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        iRet = ((KIN_DynCallback)pFunc)(mapStateFlag[manager->getState()], U, manager->getPdblSinglePar(what));
        manager->setUserStop(iRet == 1); 
    }

    if (manager->getUserStop())
    {
        sprintf(errorMsg,"iterations have been interrupted by user callback.\n");
        throw ast::InternalError(errorMsg);
    }

}

int KINSOLFun(N_Vector N_VectorY, N_Vector N_VectorF, void *pManager)
{
    char errorMsg[256];
    KINSOLManager *manager = static_cast<KINSOLManager *>(pManager);
    KINSOLManager::functionKind what = KINSOLManager::RHS;
    KINSOLManager::functionAPI fAPI = manager->getFunctionAPI(what);
    double *pdbl =  NV_DATA_S(N_VectorF);
    
    if (fAPI == KINSOLManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, NV_DATA_S(N_VectorY));
        manager->computeFunction(in, what, NV_DATA_S(N_VectorF));            
    }
    else if (fAPI == KINSOLManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(KINSOLManager::RHS);
        return ((KIN_DynFun)pFunc)(N_VectorY, N_VectorF, (void *)manager->getPdblSinglePar(what));
    }
    for (int k = 0; k < NV_LENGTH_S(N_VectorF); k++, pdbl++)
    {
        if (!std::isfinite(*pdbl))
        {
            // return a SUNDIALS recoverable error
            return 1;
        }
    }       
 
    return 0;
}

int KINSOLJac(N_Vector N_VectorY, N_Vector N_VectorF, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2)
{
    KINSOLManager *manager = static_cast<KINSOLManager *>(pManager);
    KINSOLManager::functionKind what = KINSOLManager::JACY;
    KINSOLManager::functionAPI fAPI = manager->getFunctionAPI(what);

    if (fAPI == KINSOLManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, NV_DATA_S(N_VectorY));
        manager->computeMatrix(in, what, SUNMat_J);
    }
    else if (fAPI == KINSOLManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((KIN_DynJacFun)pFunc)(N_VectorY, N_VectorF, SUNMat_J, manager->getPdblSinglePar(what), tmp1, tmp2);
    }
    else if (fAPI == KINSOLManager::CONSTANT)
    {
        copyMatrixToSUNMatrix(manager->getConstantFunction(what), SUNMat_J, manager->getNEq(), manager->isComplex());
    }
    return 0;
}

int KINSOLColPackJac(N_Vector N_VectorY, N_Vector N_VectorF, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2)
{
     return SUNDIALSColPackJac(0,0,N_VectorY,N_VectorF,NULL,SUNMat_J,pManager,tmp1,tmp2,NULL);
}

void KINSOLErrHandler(int error_code, const char *module, const char *function, char *msg, void *pManager)
{
    KINSOLManager *manager = static_cast<KINSOLManager *>(pManager);
    if (manager->getDisplay() != L"none")
    {
        sciprint(_("\n%ls: %s \n"), manager->getCallerName().c_str(), msg);         
    }
}
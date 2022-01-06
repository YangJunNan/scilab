//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021-2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "complexHelpers.hxx"
#include "OdeManager.hxx"
#include "SUNDIALSBridge.hxx"

int SUNDIALSRhsHelper(OdeManager::functionKind what, realtype t, N_Vector N_VectorY, N_Vector N_VectorYDot, void *pManager);

int SUNDIALSEvent(realtype t, N_Vector N_VectorY, realtype *pdblOut, void *pManager)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::EVENTS;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY));
        manager->computeFunction(in, what, pdblOut);
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return  ((SUN_DynEvent)pFunc)(t, N_VectorY, pdblOut, manager->getPdblSinglePar(what));
    }
    return 0;
}

int SUNDIALSImplEvent(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, realtype *pdblOut, void *pManager)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::EVENTS;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY), NV_DATA_S(N_VectorYp));
        manager->computeFunction(in, what, pdblOut);
    }
    else  if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return  ((SUN_DynImplEvent)pFunc)(t, N_VectorY, N_VectorYp, pdblOut, manager->getPdblSinglePar(what));
    }
    return 0;
}

int SUNDIALSIntCb(realtype t, int iFlag, N_Vector N_VectorY, N_Vector N_VectorYp, void *pManager)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::INTCB;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);
    char errorMsg[256];

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        types::typed_list out;
        bool bTerm;
     
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY), manager->isDAE() ? NV_DATA_S(N_VectorYp) : NULL);
        in.push_back(new types::String(wstrCbState[iFlag].c_str()));
        in.push_back(manager->getStats());        
        manager->callClosing(what, in, {1}, out);
        // Scalar boolean expected
        if (out[0]->isBool() == false || out[0]->getAs<types::Bool>()->getSize() != 1)
        {
            sprintf(errorMsg, _("%s: Wrong type for output argument #%d: scalar boolean expected.\n"), manager->getFunctionName(what), 1);
            throw ast::InternalError(errorMsg);
        }
        bTerm = out[0]->getAs<types::Bool>()->get(0);
        out[0]->DecreaseRef();
        out[0]->killMe();

        return (int) bTerm;
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        if (manager->isDAE())
        {
            return ((SUN_DynImplCallBack)pFunc)(t, iFlag, N_VectorY, N_VectorYp, manager->getPdblSinglePar(what));
        }
        else
        {
            return ((SUN_DynCallBack)pFunc)(t, iFlag, N_VectorY, manager->getPdblSinglePar(what));     
        }
    }
    return 0;
}

void SUNDIALSErrHandler(int error_code, const char *module, const char *function, char *msg, void *pManager)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    manager->errHandler(error_code, module, function, msg);
}

int SUNDIALSFun(realtype t, N_Vector N_VectorY, N_Vector N_VectorYDot, void *pManager)
{
    return SUNDIALSRhsHelper(OdeManager::RHS, t, N_VectorY, N_VectorYDot, pManager);
}

int SUNDIALSFunStiff(realtype t, N_Vector N_VectorY, N_Vector N_VectorYDot, void *pManager)
{
    return SUNDIALSRhsHelper(OdeManager::SRHS, t, N_VectorY, N_VectorYDot, pManager);
}

int SUNDIALSRhsHelper(OdeManager::functionKind what, realtype t, N_Vector N_VectorY, N_Vector N_VectorYDot, void *pManager)
{
    char errorMsg[256];
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);
    double *pdbl = NV_DATA_S(N_VectorYDot);

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY));
        manager->computeFunction(in, what, NV_DATA_S(N_VectorYDot));
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((SUN_DynFun)pFunc)(t, N_VectorY, N_VectorYDot, (void *)manager->getPdblSinglePar(what));
    }
    for (int k = 0; k < NV_LENGTH_S(N_VectorYDot); k++, pdbl++)
    {
        if (!std::isfinite(*pdbl))
        {
            // return a SUNDIALS recoverable error
            return 1;
        }
    }
    return 0;
}

int SUNDIALSProj(realtype t, N_Vector N_VectorY, N_Vector N_VectorCorr, realtype epsProj, N_Vector N_VectorErr, void *pManager)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::PROJ;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);
    double *pdblErr =  N_VectorErr == NULL ? NULL : NV_DATA_S(N_VectorErr);
    
    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY), pdblErr);
        if (pdblErr == NULL)
        {
            in.push_back(types::Double::Empty());
        }
        manager->computeFunction(in, what, NV_DATA_S(N_VectorCorr), pdblErr);
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        ((SUN_DynProj)pFunc)(t, N_VectorY, N_VectorCorr, epsProj, N_VectorErr, manager->getPdblSinglePar(what));
    }
    return 0;
}

int SUNDIALSJac(realtype t, N_Vector N_VectorY, N_Vector N_VectorFy, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::JACY;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY));
        manager->computeMatrix(in, what, SUNMat_J);        
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((SUN_DynJacFun)pFunc)(t, N_VectorY, N_VectorFy, SUNMat_J, manager->getPdblSinglePar(what), tmp1, tmp2, tmp3);
    }
    else if (fAPI == OdeManager::CONSTANT)
    {
        copyMatrixToSUNMatrix(manager->getConstantFunction(what), SUNMat_J, manager->getNEq(), manager->isComplex());
    }
    return 0;
}

int SUNDIALSMass(realtype t, SUNMatrix SUNMat_M, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::MASS;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        in.push_back(new types::Double(t));
        manager->computeMatrix(in, what, SUNMat_M);
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((SUN_DynMass)pFunc)(t, SUNMat_M, manager->getPdblSinglePar(what), tmp1, tmp2, tmp3);
    }
    else if (fAPI == OdeManager::CONSTANT)
    {
        copyMatrixToSUNMatrix(manager->getConstantFunction(what), SUNMat_M, manager->getNEq(), manager->isComplex());
    }
    return 0;
}

int SUNDIALSRes(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector N_VectorRes, void *pManager)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::RES;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);
    double *pdbl = NV_DATA_S(N_VectorRes);

    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY), NV_DATA_S(N_VectorYp));
        manager->computeFunction(in, what, NV_DATA_S(N_VectorRes));
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((SUN_DynRes)pFunc)(t, N_VectorY, N_VectorYp, N_VectorRes, manager->getPdblSinglePar(what));
    }
    for (int k = 0; k < NV_LENGTH_S(N_VectorRes); k++, pdbl++)
    {
        if (!std::isfinite(*pdbl))
        {
            // return a SUNDIALS recoverable error
            return 1;
        }
    }
    return 0;
}

int SUNDIALSJacRes(realtype t, realtype c, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector N_VectorR,
                   SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::JACYYP;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);
    
    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY), NV_DATA_S(N_VectorYp));
        in.push_back(new types::Double(c));
        manager->computeMatrix(in, what, SUNMat_J);
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((SUN_DynJacRes)pFunc)(t, c, N_VectorY, N_VectorYp, N_VectorR, SUNMat_J, manager->getPdblSinglePar(what), tmp1, tmp2, tmp3);
    }
    else if (fAPI == OdeManager::CONSTANT)
    {
        types::InternalType *pIJY = manager->getConstantFunction(OdeManager::JACY);
        types::InternalType *pIJYYP = manager->getConstantFunction(what);
        // manager->getTempSUNMatrix() is supposed to contain pIJY converted to SUNMatrix
        // below we set SUNMat_J to dR/dy + c*dR/dyp
        copyMatrixToSUNMatrix(pIJYYP, SUNMat_J, manager->getNEq(), manager->isComplex());
        SUNMatScaleAdd(c, SUNMat_J, manager->getTempSunMatrix());        
    }
    return 0;
}

int SUNDIALSSensRhs(int Ns, realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector *yS, N_Vector *ySdot, void *pManager, N_Vector tmp1, N_Vector tmp2)
{
    // we cannot use computeFunction or computeMatrix methods because sensitivity matrix
    // is given as an array of NVector
    char errorMsg[256];

    OdeManager *manager = static_cast<OdeManager *>(pManager);
    OdeManager::functionKind what = OdeManager::SENSRHS;
    OdeManager::functionAPI fAPI = manager->getFunctionAPI(what);
    int iNbEq = manager->getNEq();
    
    if (fAPI == OdeManager::SCILAB_CALLABLE)
    {
        types::typed_list in;
        types::typed_list out;

        manager->callOpening(what, in, t, NV_DATA_S(N_VectorY));
        // copy each ySdot[j] in column j of S matrix, j=0...getNbSensPar()-1
        types::Double *pDblS = new types::Double(iNbEq,manager->getNbSensPar(),manager->isComplex());
        for (int j=0; j<manager->getNbSensPar(); j++)
        {
            // pDblS->getImg()+j*m_iNbEq with pDblS->getImg()==NULL is not used when m_odeIsComplex == false !
            copyComplexVectorToDouble(NV_DATA_S(yS[j]), pDblS->get()+j*iNbEq, pDblS->getImg()+j*iNbEq, iNbEq, manager->isComplex());            
        }
        in.push_back(pDblS);
        manager->callClosing(what, in, {1}, out);
        // test if out is a double matrix of correct size then copy in ySdot
        if (out[0]->isDouble() == false)
        {
            sprintf(errorMsg, _("%s: Wrong type for output argument #%d: double expected.\n"), manager->getFunctionName(what), 1);
            throw ast::InternalError(errorMsg);
        }
        types::Double *pDblOut = out[0]->getAs<types::Double>();
        if (pDblOut->getSize() !=  manager->getSizeOfInput(what))
        {
            sprintf(errorMsg, _("%s: Wrong size for output argument #%d: expecting %d.\n"), manager->getFunctionName(what), 1, manager->getSizeOfInput(what));
            throw ast::InternalError(errorMsg);
        }
        // copy each column of S matrix in ySdot[j], j=0...getNbSensPar()-1
        for (int j=0; j<manager->getNbSensPar(); j++)
        {
            copyRealImgToComplexVector(pDblOut->get()+j*iNbEq, pDblOut->getImg()+j*iNbEq, NV_DATA_S(ySdot[j]), iNbEq, manager->isComplex());
        }
        out[0]->DecreaseRef();
        out[0]->killMe();
    }
    else if (fAPI == OdeManager::SUNDIALS_DLL)
    {
        dynlibFunPtr pFunc = manager->getEntryPointFunction(what);
        return ((SUN_DynSensRhs)pFunc)(Ns, t, N_VectorY, N_VectorYp, yS, ySdot, manager->getPdblSinglePar(what), tmp1, tmp2);
    }
    return 0;
}

int SUNDIALSColPackJac(realtype t, realtype c, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector N_VectorR,
                   SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    // compute Sparse Jacobian approximation using ColPack
    SUNDIALSManager *manager = static_cast<SUNDIALSManager *>(pManager);
    spCompJacobian *spJacEngine = manager->getColPackEngine();

    double **ppdblProd = spJacEngine->getProducts();

    for (int j=0; j < spJacEngine->getNbSeeds(); j++)
    {
        // Does Jac(Y)*seed[j] -> tmp1 using internal SUNDIALS kinsol engine
        manager->DQJtimes(t, N_VectorY, N_VectorYp, N_VectorR, manager->getNVectorSeeds()[j], tmp1, c, tmp2, tmp3);
        // copy tmp1 in ppdblProd ColPack array (array of pointers on lines)
        for (int i=0; i<manager->getNRealEq(); i++)
        {
           ppdblProd[i][j] =  NV_Ith_S(tmp1,i); 
        }
    }

    // recover Jacobian from Jac(Y)*seed[j] products
    spJacEngine->recover();

    // copy template to output Jacobian SUNMat_J (only index terms matter here)
    SUNMatCopy(manager->getSUNMATPattern(),SUNMat_J);
    // copy nonzero terms
    spJacEngine->recoverMatrix(SM_DATA_S(SUNMat_J));
    // double *pdbl = SM_DATA_S(SUNMat_J);
    // for (int i=0; i<SM_NNZ_S(SUNMat_J); i++)
    // {
    //     sciprint("%g\n",pdbl[i]);
    // }

    return 0;                      
}

int CVODEColPackJac(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    return SUNDIALSColPackJac(t, 0, N_VectorY, N_VectorYp, NULL, SUNMat_J, pManager, tmp1, tmp2, tmp3);
}
int ARKODEColPackJac(realtype t, N_Vector N_VectorY, N_Vector N_VectorYp, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    return SUNDIALSColPackJac(t, 0, N_VectorY, N_VectorYp, NULL, SUNMat_J, pManager, tmp1, tmp2, tmp3);
}
int IDAColPackJac(realtype t, realtype c, N_Vector N_VectorY, N_Vector N_VectorYp, N_Vector N_VectorR, SUNMatrix SUNMat_J, void *pManager, N_Vector tmp1, N_Vector tmp2, N_Vector tmp3)
{
    return SUNDIALSColPackJac(t, c, N_VectorY, N_VectorYp, N_VectorR, SUNMat_J, pManager, tmp1, tmp2, tmp3);
}































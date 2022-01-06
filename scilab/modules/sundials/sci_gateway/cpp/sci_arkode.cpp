//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2021 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#include "sundials_gw.hxx"

#include "function.hxx"
#include "double.hxx"
#include "string.hxx"
#include "list.hxx"
#include "mlist.hxx"
#include "pointer.hxx"
#include "struct.hxx"
#include "callable.hxx"
#include "runvisitor.hxx"
#include "context.hxx"

#include "ARKODEManager.hxx"
#include "odeparameters.hxx"

extern "C"
{
#include "localization.h"
#include "Scierror.h"
#include "sciprint.h"
    
void C2F(ARKODE_dynrhs)(int *n,double *t,double *y,double *ydot);
void C2F(ARKODE_dynrhspar)(int *n,double *t,double *y,double *ydot,double *mu);
void C2F(ARKODE_dynjac)(int *n,double *t,double *y,double *ydot, double *J);
void C2F(ARKODE_dynjacpar)(int *n,double *t,double *y,double *ydot, double *J, double *mu);
int C2F(ARKODE_dyncb)(int *n,double *t,double *y, int *flag);
void C2F(ARKODE_dynevent)(int *n,double *t,double *y, int *ng, double *g, int *term, int *dir);
void C2F(ARKODE_dyneventpar)(int *n,double *t,double *y, int *ng, double *g, int *term, int *dir, double *par);
}

static
types::Function::ReturnValue sci_arkode_extend(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out);

types::Function::ReturnValue sci_arkode(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out)
{
    ARKODEManager *manager = NULL;
    ARKODEManager *prevManager = NULL;
    char errorMsg[256];
    int iStart = 0;

    if (in.size() != 2 && in.size() != 3)
    {
        Scierror(999, _("%s: Wrong number of input argument(s): %d or %d expected.\n"), "arkode", 2, 3);
        return types::Function::Error;
    }
    if (_iRetCount > 5)
    {
        sprintf(errorMsg, _("%s: Wrong number of output argument(s): %d to %d expected.\n"), "arkode", 1, 5);
        throw ast::InternalError(errorMsg);
    }

    if (in[0]->isMList() && in[0]->getAs<types::MList>()->getTypeStr() == L"_odeSolution")
    {
        return sci_arkode_extend(in, opt, _iRetCount, out);
    }

    manager = new ARKODEManager(L"arkode", L"arkode");

    manager->setIretCount(_iRetCount);

    try
    {
        manager->parseMatrices(in);
        // sciprint("parseMatrices\n");
        manager->parseFunction(in[iStart], OdeManager::RHS);
        // sciprint("parseFunction\n");
        manager->parseOptions(opt);
        // sciprint("parseOptions\n");
        manager->init();
        // sciprint("init\n");
        manager->solve();
        // sciprint("solve\n");
    }
    catch (ast::InternalError& ie)
    {
        delete manager;
        return types::Function::Error;
    }
    catch (ast::InternalAbort& ia)
    {
        delete manager;
        throw (ia);
    }

    if (_iRetCount > 1)
    {
        out.push_back(manager->getTOut());
        out.push_back(manager->getYOut());
        if (manager->getNbEvents() > 0)
        {
            out.push_back(manager->getTEvent());
            out.push_back(manager->getYEvent());
            out.push_back(manager->getIndexEvent());
        }
        manager->createSolutionOutput(out);
        delete manager;        
    } else if (_iRetCount == 1) 
    {
        manager->createSolutionOutput(out);
    }
    else // _iRetCount == 0
    {
        delete manager;
    }

    return types::Function::OK;
}

types::Function::ReturnValue sci_arkode_extend(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out)
{
    ARKODEManager *manager = NULL;
    ARKODEManager *prevManager = NULL;
    char errorMsg[256];

    if (in.size() != 2)
    {
        Scierror(999, _("%s: Wrong number of input argument(s): 2 expected.\n"), "arkode_extend", 2);
        return types::Function::Error;
    }
    if (_iRetCount > 1)
    {
        sprintf(errorMsg, _("%s: Wrong number of output argument(s): %d expected.\n"), "arkode_extend", 1);
        throw ast::InternalError(errorMsg);
    }
    if (in[0]->isMList() == false || in[0]->getAs<types::MList>()->getTypeStr() != L"_odeSolution")
    {
        sprintf(errorMsg, _("%s: Wrong type of input argument #%d: %s expected.\n"), "arkode_extend", 1, "_odeSolution");
        throw ast::InternalError(errorMsg);
    }
    types::InternalType *pI;
    types::MList *pObj = in[0]->getAs<types::MList>();
    if (pObj->extract(L"manager", pI) && pI->isPointer())
    {
        OdeManager *p = static_cast<OdeManager *>(pI->getAs<types::Pointer>()->get());
        if (p->getSolverName() != L"arkode")
        {
            sprintf(errorMsg, _("%s: wrong solver \"%ls\" in solution to be extended.\n"), "arkode_extend", p->getSolverName().c_str());
            throw ast::InternalError(errorMsg);
        }
        prevManager = static_cast<ARKODEManager *>(pI->getAs<types::Pointer>()->get());
    }

    manager = new ARKODEManager(L"arkode_extend", L"arkode", prevManager);

    manager->setIretCount(1);

    try
    {
        manager->parseMatrices(in);
        manager->parseOptions(opt);
        manager->init();
        manager->solve();
    }
    catch (ast::InternalError& ie)
    {
        delete manager;
        return types::Function::Error;
    }
    catch (ast::InternalAbort& ia)
    {
        delete manager;
        throw (ia);
    }

    manager->createSolutionOutput(out);

    return types::Function::OK;
}




















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

#include "IDAManager.hxx"
#include "odeparameters.hxx"

extern "C"
{
#include "localization.h"
#include "Scierror.h"
#include "sciprint.h"
}

static
types::Function::ReturnValue sci_ida_extend(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out);

types::Function::ReturnValue sci_ida(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out)
{
    IDAManager *manager = NULL;
    IDAManager *prevManager = NULL;
    char errorMsg[256];
    int iStart = 0;

    if (in.size() != 2 && in.size() != 4)
    {
        Scierror(999, _("%s: Wrong number of input argument(s): %d or %d expected.\n"), "ida", 2, 4);
        return types::Function::Error;
    }
    if (_iRetCount > 7)
    {
        sprintf(errorMsg, _("%s: Wrong number of output argument(s): %d to %d expected.\n"), "ida", 1, 7);
        throw ast::InternalError(errorMsg);
    }

    if (in[0]->isMList() && in[0]->getAs<types::MList>()->getTypeStr() == L"_odeSolution")
    {
        return sci_ida_extend(in, opt, _iRetCount, out);
    }

    manager = new IDAManager(L"ida_solve", L"ida");

    manager->setIretCount(_iRetCount);

    try
    {
        manager->parseMatrices(in);
        // sciprint("parseMatrices\n");
        manager->parseFunction(in[iStart], OdeManager::RES);
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
        out.push_back(manager->getYpOut());
        if (manager->getNbEvents() > 0)
        {
            out.push_back(manager->getTEvent());
            out.push_back(manager->getYEvent());
            out.push_back(manager->getYpEvent());
            out.push_back(manager->getIndexEvent());
        }
        manager->createSolutionOutput(out);
        delete manager;    
    }   
    else if (_iRetCount = 1)
    {
        manager->createSolutionOutput(out);
    }
    else
    {
        delete manager;    
    }

    return types::Function::OK;
}

types::Function::ReturnValue sci_ida_extend(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out)
{
    IDAManager *manager = NULL;
    IDAManager *prevManager = NULL;
    char errorMsg[256];
    int iStart = 0;

    if (in.size() != 2)
    {
        Scierror(999, _("%s: Wrong number of input argument(s): 2 expected.\n"), "ida_extend", 2);
        return types::Function::Error;
    }
    if (_iRetCount > 1)
    {
        sprintf(errorMsg, _("%s: Wrong number of output argument(s): %d expected.\n"), "ida_extend", 1);
        throw ast::InternalError(errorMsg);
    }
    if (in[0]->isMList() == false || in[0]->getAs<types::MList>()->getTypeStr() != L"_odeSolution")
    {
        sprintf(errorMsg, _("%s: Wrong type of input argument #%d: %s expected.\n"), "ida_extend", 1, "_odeSolution");
        throw ast::InternalError(errorMsg);
    }
    types::InternalType *pI;
    types::MList *pObj = in[0]->getAs<types::MList>();
    if (pObj->extract(L"manager", pI) && pI->isPointer())
    {
        OdeManager *p = static_cast<OdeManager *>(pI->getAs<types::Pointer>()->get());
        if (p->getSolverName() != L"ida")
        {
            sprintf(errorMsg, _("%s: wrong solver \"%ls\" in solution to be extended.\n"), "ida_extend", p->getSolverName().c_str());
            throw ast::InternalError(errorMsg);
        }
        prevManager = static_cast<IDAManager *>(pI->getAs<types::Pointer>()->get());
    }

    manager = new IDAManager(L"ida_extend", L"ida", prevManager);

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

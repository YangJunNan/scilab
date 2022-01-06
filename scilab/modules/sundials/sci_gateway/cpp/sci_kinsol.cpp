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

#include "KINSOLManager.hxx"

extern "C"
{
#include "localization.h"
#include "Scierror.h"
#include "sciprint.h"
}

types::Function::ReturnValue sci_kinsol(types::typed_list &in, types::optional_list &opt, int _iRetCount, types::typed_list &out)
{
    KINSOLManager *manager = NULL;
    char errorMsg[256];
    int iStart = 0;

    if (in.size() != 2)
    {
        Scierror(999, _("%s: Wrong number of input argument(s): %d expected.\n"), "kinsol", 2);
        return types::Function::Error;
    }
    if (_iRetCount > 4)
    {
        sprintf(errorMsg, _("%s: Wrong number of output argument(s): %d to %d expected.\n"), "kinsol", 1, 4);
        throw ast::InternalError(errorMsg);
    }

    manager = new KINSOLManager(L"kinsol", L"kinsol");
    manager->setIretCount(_iRetCount);

    try
    {
        manager->parseMatrices(in);
        // sciprint("parseMatrices\n");
        manager->parseFunction(in[0], KINSOLManager::RHS);
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
        if (manager->getUserStop() == false)
        {
            delete manager;
            return types::Function::Error;            
        }
        else if (manager->getDisplay() != L"none")
        {
            sciprint("\n%s: %ls", "kinsol", ie.GetErrorMessage().c_str());
        }
    }
    catch (ast::InternalAbort& ia)
    {
        delete manager;
        throw (ia);
    }

    out.push_back(manager->getYOut());
    
    if (_iRetCount > 1)
    {
        out.push_back(manager->getFOut());
    }
    if (_iRetCount > 2)
    {
        out.push_back(manager->getExitCode());
    }
    if (_iRetCount > 3)
    {
        manager->createSolutionOutput(out);
    }

    delete manager;
    return types::Function::OK;
}

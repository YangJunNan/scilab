/*
 * Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
 * Copyright (C) 2006 - INRIA - Fabrice Leray
 * Copyright (C) 2006 - INRIA - Jean-Baptiste Silvy
 * Copyright (C) 2011 - Scilab Enterprises - Bruno JOFRET
 * Copyright (C) 2013 - Scilab Enterprises - Cedric Delamarre
 *
 * Copyright (C) 2012 - 2016 - Scilab Enterprises
 *
 * This file is hereby licensed under the terms of the GNU GPL v2.0,
 * pursuant to article 5.3.4 of the CeCILL v.2.1.
 * This file was originally licensed under the terms of the CeCILL v2.1,
 * and continues to be available under such terms.
 * For more information, see the COPYING file which you should have received
 * along with this program.
 *
 */

/*------------------------------------------------------------------------*/
/* file: sci_xget.cpp                                                       */
/* desc : interface for xget routine                                      */
/*------------------------------------------------------------------------*/

#include "graphics_gw.hxx"
#include "function.hxx"
#include "double.hxx"
#include "configgraphicvariable.hxx"
#include "overload.hxx"
#include "string.hxx"

extern "C"
{
#include <string.h>
#include "GetProperty.h"
#include "Scierror.h"
#include "localization.h"
#include "returnProperty.h"
#include "HandleManagement.h"
#include "CurrentSubwin.h"
#include "getGraphicObjectProperty.h"
#include "graphicObjectProperties.h"
#include "BuildObjects.h"
#include "sci_malloc.h"
#include "getHandleProperty.h"
#include "CurrentFigure.h"
#include "Sciwarning.h"
}
/*--------------------------------------------------------------------------*/
types::Function::ReturnValue sci_xget(types::typed_list &in, int _iRetCount, types::typed_list &out)
{
    double dValue = 0;
    wchar_t* pwcsWhat = NULL;
    void* pvApiCtx = NULL;

    if (in.size() == 0)
    {
        return Overload::call(L"%_xget", in, _iRetCount, out);
    }

    Sciwarning(_("%s: %s will be permanently removed in Scilab %s\n\n"), _("Warning"), "xget()", "2024.0.0");

    if (in.size() > 2)
    {
        Scierror(77, _("%s: Wrong number of input argument(s): %d to %d expected.\n"), "xget", 1, 2);
        return types::Function::Error;
    }

    if (_iRetCount > 1)
    {
        Scierror(78, _("%s: Wrong number of output argument(s): %d expected.\n"), "xget", 1);
        return types::Function::Error;
    }

    if (in[0]->isString() == false)
    {
        Scierror(999, _("%s: Wrong type for input argument #%d: A single string expected.\n"), "xget", 1);
        return types::Function::Error;
    }

    types::String* pStr = in[0]->getAs<types::String>();

    if (pStr->isScalar() == false)
    {
        Scierror(999, _("%s: Wrong type for input argument #%d: A single string expected.\n"), "xget", 1);
        return types::Function::Error;
    }

    pwcsWhat = pStr->get(0);

    if (ConfigGraphicVariable::bPropertyFound(pwcsWhat) == false)
    {
        char* pstWhat = wide_string_to_UTF8(pwcsWhat);
        Scierror(999, _("%s: Unrecognized input argument: '%s'.\n"), "xget", pstWhat);
        FREE(pstWhat);
        return types::Function::Error;
    }

    if (in.size() == 2)
    {
        if (in[1]->isDouble() == false)
        {
            Scierror(202, _("%s: Wrong type for argument #%d: A real expected.\n"), "xget", 2);
            return types::Function::Error;
        }

        types::Double* pDbl = in[1]->getAs<types::Double>();

        //CheckScalar
        if (pDbl->isScalar())
        {
            Scierror(999, _("%s: Wrong size for input argument #%d: A real scalar expected.\n"), "xget", 2);
            return types::Function::Error;
        }

        dValue = pDbl->get(0);
    }

    switch (ConfigGraphicVariable::getPropertyValue(pwcsWhat))
    {
        case 15 : // fpf
        {
            out.push_back(new types::String(ConfigGraphicVariable::getFPF().c_str()));
        }
        break;
        default :
        {
            char* pstWhat = wide_string_to_UTF8(pwcsWhat);
            Scierror(999, _("%s: Unrecognized input argument: '%s'.\n"), "xget", pstWhat);
            FREE(pstWhat);
            return types::Function::Error;
        }
    }

    return types::Function::OK;
}
/*--------------------------------------------------------------------------*/

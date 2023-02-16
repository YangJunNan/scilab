/*
* Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
* Copyright (C) 2006 - INRIA - Fabrice Leray
* Copyright (C) 2006 - INRIA - Jean-Baptiste Silvy
* Copyright (C) 2012 - Scilab Enterprises - Bruno JOFRET
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
/* file: sci_xset.cpp                                                      */
/* desc : interface for xset routine                                      */
/*------------------------------------------------------------------------*/
#include "graphics_gw.hxx"
#include "function.hxx"
#include "double.hxx"
#include "configvariable.hxx"
#include "configgraphicvariable.hxx"
#include "overload.hxx"
#include "internal.hxx"
#include "string.hxx"

extern "C"
{
#include "GetProperty.h"
#include "SetProperty.h"
#include "DrawObjects.h"
#include "localization.h"
#include "Scierror.h"
#include "HandleManagement.h"

#include "createGraphicObject.h"
#include "BuildObjects.h"
#include "graphicObjectProperties.h"
#include "setGraphicObjectProperty.h"
#include "FigureList.h"
#include "CurrentFigure.h"
#include "CurrentSubwin.h"
#include "AxesModel.h"
#include "getGraphicObjectProperty.h"
#include "deleteGraphicObject.h"
#include "configvariable_interface.h"
#include "sciprint.h"
}
/*--------------------------------------------------------------------------*/
types::Function::ReturnValue sci_xset(types::typed_list &in, int _iRetCount, types::typed_list &out)
{
    wchar_t* pwcsWhat = NULL;
    std::list<types::Double*> lpDblInputs;
    int iSubwinUID = 0;

    if (in.size() == 0)
    {
        return Overload::call(L"%_xset", in, _iRetCount, out);
    }

    if (in.size() > 6)
    {
        Scierror(77, _("%s: Wrong number of input argument(s): %d to %d expected.\n"), "xset", 1, 6);
        return types::Function::Error;
    }

    if (_iRetCount > 1)
    {
        Scierror(78, _("%s: Wrong number of output argument(s): %d expected.\n"), "xset", 1);
        return types::Function::Error;
    }

    if (in[0]->isString() == false)
    {
        Scierror(999, _("%s: Wrong type for input argument #%d: A single string expected.\n"), "xset", 1);
        return types::Function::Error;
    }

    types::String* pStr = in[0]->getAs<types::String>();

    if (pStr->isScalar() == false)
    {
        Scierror(999, _("%s: Wrong type for input argument #%d: A single string expected.\n"), "xset", 1);
        return types::Function::Error;
    }

    pwcsWhat = pStr->get(0);

    if (ConfigGraphicVariable::bPropertyFound(pwcsWhat) == false)
    {
        char* pstWhat = wide_string_to_UTF8(pwcsWhat);
        Scierror(999, _("%s: Unrecognized input argument: '%s'.\n"), "xset", pstWhat);
        FREE(pstWhat);
        return types::Function::Error;
    }

    // Only in case of "fpf" and "auto clear", the second argument is a string
    // Only "default" case have one input argument
    if (ConfigGraphicVariable::getPropertyValue(pwcsWhat) != 15 && // fpf
            ConfigGraphicVariable::getPropertyValue(pwcsWhat) != 2  && // auto clear
            ConfigGraphicVariable::getPropertyValue(pwcsWhat) != 10)   // default
    {
        for (unsigned int i = 1 ; i < in.size() ; i++)
        {
            if (in[i]->isDouble() == false)
            {
                Scierror(202, _("%s: Wrong type for argument #%d: A real expected.\n"), "xset", i + 1);
            }
        }
    }

    switch (ConfigGraphicVariable::getPropertyValue(pwcsWhat))
    {
        case 15 : // fpf
        {
            if (in.size() != 2)
            {
                Scierror(77, _("%s: Wrong number of input arguments: %d expected.\n"), "xset", 2);
                return types::Function::Error;
            }

            if (in[1]->isString() == false)
            {
                Scierror(999, _("%s: Wrong type for input argument #%d: A single string expected.\n"), "xset", 2);
                return types::Function::Error;
            }

            types::String* pStrValue = in[1]->getAs<types::String>();
            if (pStrValue->isScalar() == false)
            {
                Scierror(999, _("%s: Wrong type for input argument #%d: A single string expected.\n"), "xset", 2);
                return types::Function::Error;
            }

            ConfigGraphicVariable::setFPF(pStrValue->get(0));
        }
        break;
        default :
        {
            char* pstWhat = wide_string_to_UTF8(pwcsWhat);
            Scierror(999, _("%s: Unrecognized input argument: '%s'.\n"), "xset", pstWhat);
            FREE(pstWhat);
            return types::Function::Error;
        }
    }

    return types::Function::OK;
}
/*--------------------------------------------------------------------------*/

/*
 *  Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
 *  Copyright (C) 2014-2015 - Scilab Enterprises - Calixte DENIZET
 *
 *  This file must be used under the terms of the CeCILL.
 *  This source file is licensed as described in the file COPYING, which
 *  you should have received as part of this distribution.  The terms
 *  are also available at
 *  http://www.cecill.info/licences/Licence_CeCILL_V2-en.txt
 *
 */

// This file has been generated, so don't modify it by hand !!

#include "checkers/Checkers.hxx"

namespace analysis
{
    TIType Checkers::check_____unaryminus____(GVN & gvn, const TIType & in0)
    {
        switch (in0.type)
        {
        case TIType::EMPTY :
        {
            return in0;
        }
        case TIType::COMPLEX :
        {
            return in0;
        }
        case TIType::DOUBLE :
        {
            return in0;
        }
        case TIType::INT16 :
        {
            return in0;
        }
        case TIType::INT32 :
        {
            return in0;
        }
        case TIType::INT64 :
        {
            return in0;
        }
        case TIType::INT8 :
        {
            return in0;
        }
        case TIType::UINT16 :
        {
            return in0;
        }
        case TIType::UINT32 :
        {
            return in0;
        }
        case TIType::UINT64 :
        {
            return in0;
        }
        case TIType::UINT8 :
        {
            return in0;
        }
        default :
            return TIType(gvn);
        }
    }

} // namespace analysis
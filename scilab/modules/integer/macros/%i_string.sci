// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) INRIA -
// Copyright (C) 2012 - 2016 - Scilab Enterprises
// Copyright (C) 2023 - Samuel GOUGEON
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function str = %i_string(i)
    mw = format()
    format("v",22)
    str = string(i)
    if or(inttype(i)==[8 18])
        //pause
        k = abs(i) > 2^52
        if or(k)
            i = i(k)
            kneg = i < 0
            i = abs(i)
            q = i / 10000
             // manages integer round-off
            tmp = i - q*10000
            k2 = tmp < 0 | tmp > i
            if or(k2)
                q(k2) = q(k2) - 1
            end
            //
            tmp = string(q)
            tmp = tmp + string(i - q.*iconvert(10000, inttype(i)))
            if or(kneg)
                tmp(kneg) = "-" + tmp(kneg)
            end
            //
            str(k) = tmp
        end
    end
    format(mw([2 1]))
endfunction

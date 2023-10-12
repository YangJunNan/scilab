// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2019 - 2020 - Samuel GOUGEON
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function t = %st_string(s)
    recursive = 0
    tmp = xmlGetValues("//general/body/environment","container_disp_max_depth")
    maxDisplayDepth = evstr(tmp)
    consoleWidth = lines()(1)
    //l_p_compacity = "";   // "" vspacing of blocks
    l_p_compacity = [];      // for compact display
    t = %l_string_inc(s, "st")
endfunction

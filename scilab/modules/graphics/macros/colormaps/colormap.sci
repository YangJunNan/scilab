// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function cmap = colormap(cmapName, cmapSize)
    cmap = [];

    if ~isdef("cmapName") then
        cmapName = "jet"
    else if typeof(cmapName) <> "string" & typeof(cmapName) <> "function" then
             error(msprintf(gettext("%s: Wrong type for input argument #%d: a string or a function expected.\n"), "colormap", 1));
        end
    end
    
    if ~isdef("cmapSize") then
        cmapSize = 128
    else if typeof(cmapSize) <> "constant" || size(cmapSize, '*') <> 1 then
            error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "colormap", 2))
        end
    end
    
    if typeof(cmapName) == "string" then
        ierr = execstr("cmap="+cmapName+"(cmapSize)", "errcatch");
        if ierr <> 0 then
            error(msprintf(gettext("%s: Error while generating a colormap using ''%s'':\n%s"), "colormap", cmapName, lasterror()))
        end
    else // function
        cmap=cmapName(cmapSize);
    end

    if size(cmap, 2) <> 3 then
        error(msprintf(gettext("%s: Wrong number of columns for generated colormap: 3 expected but got %d.\n"), "colormap", size(cmap, 2)))
    end
endfunction

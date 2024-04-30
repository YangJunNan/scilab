//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

function cmap = colormap(cmapName, cmapSize)
    cmap = [];

    if ~isdef("cmapName") then
        cmapName = "jet"
    else if typeof(cmapName) <> "string" then
             error(msprintf(gettext("%s: Wrong type for input argument #%d: a string expected.\n"), "colormap", 1));
        end
    end
    
    if ~isdef("cmapSize") then
        cmapSize = 128
    else if typeof(cmapSize) <> "constant" || size(cmapSize, '*') <> 1 then
            error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "colormap", 2))
        end
    end
    
    if ~isdef(cmapName+"colormap") then
        error(" Unable to find " + cmapName + " colormap")
    end
    execstr("__colormap="+cmapName+"colormap");
    
    cmap=__colormap(cmapSize);
endfunction

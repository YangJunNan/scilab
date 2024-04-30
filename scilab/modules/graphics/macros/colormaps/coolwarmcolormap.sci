//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap generated from 
// http://www.kennethmoreland.com/color-maps/CoolWarmFloat257.csv
//
function cmap=coolwarmcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "coolwarmcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "coolwarmcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "coolwarmcolormap", 1));
    end
    
    
    indexes = [0, 74, 128, 176, 255];
    red = [0.230, 0.607, 0.865, 0.97, 0.706];
    green = [0.299, 0.735, 0.865, 0.694, 0.016];
    blue = [0.754, 0.999, 0.865, 0.579, 0.150];
    pIndexes = indexes/255 * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
            interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
            interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction

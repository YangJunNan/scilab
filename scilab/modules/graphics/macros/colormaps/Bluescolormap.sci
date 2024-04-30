//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=Bluescolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "Bluescolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "Bluescolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "Bluescolormap", 1));
    end
    _Blues_data = [
    247,251,255
    222,235,247
    198,219,239
    158,202,225
    107,174,214
    66,146,198
    33,113,181
    8,81,156
    8,48,107
    ] / 255;
    indexes = 0:(size(_Blues_data, 'r') - 1);
    red = _Blues_data(:,1)';
    green = _Blues_data(:,2)';
    blue = _Blues_data(:,3)';
    pIndexes = indexes/(size(_Blues_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction


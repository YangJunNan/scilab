//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=PRGncolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "PRGncolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "PRGncolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "PRGncolormap", 1));
    end
    _PRGn_data = [
    64,0,75
    118,42,131
    153,112,171
    194,165,207
    231,212,232
    247,247,247
    217,240,211
    166,219,160
    90,174,97
    27,120,55
    0,68,27
    ] / 255;
    indexes = 0:(size(_PRGn_data, 'r') - 1);
    red = _PRGn_data(:,1)';
    green = _PRGn_data(:,2)';
    blue = _PRGn_data(:,3)';
    pIndexes = indexes/(size(_PRGn_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction


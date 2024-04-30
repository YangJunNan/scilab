//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=GnBucolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "GnBucolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "GnBucolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "GnBucolormap", 1));
    end

    _GnBu_data = [
    247,252,240
    224,243,219
    204,235,197
    168,221,181
    123,204,196
    78,179,211
    43,140,190
    8,104,172
    8,64,129
    ] / 255;
    indexes = 0:(size(_GnBu_data, 'r') - 1);
    red = _GnBu_data(:,1)';
    green = _GnBu_data(:,2)';
    blue = _GnBu_data(:,3)';
    pIndexes = indexes/(size(_GnBu_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction

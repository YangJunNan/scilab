//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=Purplescolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "Purplescolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "Purplescolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "Purplescolormap", 1));
    end
    _Purples_data = [
    252,251,253
    239,237,245
    218,218,235
    188,189,220
    158,154,200
    128,125,186
    106,81,163
    84,39,143
    63,0,125
    ] / 255;
    indexes = 0:(size(_Purples_data, 'r') - 1);
    red = _Purples_data(:,1)';
    green = _Purples_data(:,2)';
    blue = _Purples_data(:,3)';
    pIndexes = indexes/(size(_Purples_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction


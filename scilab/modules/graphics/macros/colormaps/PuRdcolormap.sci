//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=PuRdcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "PuRdcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "PuRdcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "PuRdcolormap", 1));
    end
    _PuRd_data = [
    247,244,249
    231,225,239
    212,185,218
    201,148,199
    223,101,176
    231,41,138
    206,18,86
    152,0,67
    103,0,31
    ] / 255;
    indexes = 0:(size(_PuRd_data, 'r') - 1);
    red = _PuRd_data(:,1)';
    green = _PuRd_data(:,2)';
    blue = _PuRd_data(:,3)';
    pIndexes = indexes/(size(_PuRd_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


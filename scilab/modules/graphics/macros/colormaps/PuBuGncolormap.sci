//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=PuBuGncolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "PuBuGncolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "PuBuGncolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "PuBuGncolormap", 1));
    end
    _PuBuGn_data = [
    255,247,251
    236,226,240
    208,209,230
    166,189,219
    103,169,207
    54,144,192
    2,129,138
    1,108,89
    1,70,54
    ] / 255;
    indexes = 0:(size(_PuBuGn_data, 'r') - 1);
    red = _PuBuGn_data(:,1)';
    green = _PuBuGn_data(:,2)';
    blue = _PuBuGn_data(:,3)';
    pIndexes = indexes/(size(_PuBuGn_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=PuOrcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "PuOrcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "PuOrcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "PuOrcolormap", 1));
    end
    _PuOr_data = [
    179,88,6
    224,130,20
    253,184,99
    254,224,182
    247,247,247
    216,218,235
    178,171,210
    128,115,172
    84,39,136
    ] / 255;
    indexes = 0:(size(_PuOr_data, 'r') - 1);
    red = _PuOr_data(:,1)';
    green = _PuOr_data(:,2)';
    blue = _PuOr_data(:,3)';
    pIndexes = indexes/(size(_PuOr_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


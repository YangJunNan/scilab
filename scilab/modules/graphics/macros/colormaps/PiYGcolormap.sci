//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=PiYGcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "PiYGcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "PiYGcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "PiYGcolormap", 1));
    end
    _PiYG_data = [
    142,1,82
    197,27,125
    222,119,174
    241,182,218
    253,224,239
    247,247,247
    230,245,208
    184,225,134
    127,188,65
    77,146,33
    39,100,25
    ] / 255;
    indexes = 0:(size(_PiYG_data, 'r') - 1);
    red = _PiYG_data(:,1)';
    green = _PiYG_data(:,2)';
    blue = _PiYG_data(:,3)';
    pIndexes = indexes/(size(_PiYG_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


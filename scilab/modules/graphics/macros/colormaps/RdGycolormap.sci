//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=RdGycolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "RdGycolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "RdGycolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "RdGycolormap", 1));
    end
    _RdGy_data = [
    103,0,31
    178,24,43
    214,96,77
    244,165,130
    253,219,199
    255,255,255
    224,224,224
    186,186,186
    135,135,135
    77,77,77
    26,26,26
    ] / 255;
    indexes = 0:(size(_RdGy_data, 'r') - 1);
    red = _RdGy_data(:,1)';
    green = _RdGy_data(:,2)';
    blue = _RdGy_data(:,3)';
    pIndexes = indexes/(size(_RdGy_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


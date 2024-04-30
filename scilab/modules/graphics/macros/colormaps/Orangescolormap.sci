//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=Orangescolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "Orangescolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "Orangescolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "Orangescolormap", 1));
    end
    _Oranges_data = [
    255,245,235
    254,230,206
    253,208,162
    253,174,107
    253,141,60
    241,105,19
    217,72,1
    166,54,3
    127,39,4
    ] / 255;
    indexes = 0:(size(_Oranges_data, 'r') - 1);
    red = _Oranges_data(:,1)';
    green = _Oranges_data(:,2)';
    blue = _Oranges_data(:,3)';
    pIndexes = indexes/(size(_Oranges_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


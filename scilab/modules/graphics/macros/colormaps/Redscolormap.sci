//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=Redscolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "Redscolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "Redscolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "Redscolormap", 1));
    end
    _Reds_data = [
    255,245,240
    254,224,210
    252,187,161
    252,146,114
    251,106,74
    239,59,44
    203,24,29
    165,15,21
    103,0,13
    ] / 255;
    indexes = 0:(size(_Reds_data, 'r') - 1);
    red = _Reds_data(:,1)';
    green = _Reds_data(:,2)';
    blue = _Reds_data(:,3)';
    pIndexes = indexes/(size(_Reds_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


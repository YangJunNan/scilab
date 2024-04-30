//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=YlGncolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "YlGncolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "YlGncolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "YlGncolormap", 1));
    end
    _YlGn_data = [
    255,255,229
    247,252,185
    217,240,163
    173,221,142
    120,198,121
    65,171,93
    35,132,67
    0,104,55
    0,69,41
    ] / 255;
    indexes = 0:(size(_YlGn_data, 'r') - 1);
    red = _YlGn_data(:,1)';
    green = _YlGn_data(:,2)';
    blue = _YlGn_data(:,3)';
    pIndexes = indexes/(size(_YlGn_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


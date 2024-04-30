//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=YlGnBucolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "YlGnBucolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "YlGnBucolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "YlGnBucolormap", 1));
    end
    _YlGnBu_data = [
    255,255,217
    237,248,177
    199,233,180
    127,205,187
    65,182,196
    29,145,192
    34,94,168
    37,52,148
    8,29,88
    ] / 255;
    indexes = 0:(size(_YlGnBu_data, 'r') - 1);
    red = _YlGnBu_data(:,1)';
    green = _YlGnBu_data(:,2)';
    blue = _YlGnBu_data(:,3)';
    pIndexes = indexes/(size(_YlGnBu_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


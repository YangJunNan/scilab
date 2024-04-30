//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=YlOrRdcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "YlOrRdcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "YlOrRdcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "YlOrRdcolormap", 1));
    end
    _YlOrRd_data = [
    255,255,204
    255,237,160
    254,217,118
    254,178,76
    253,141,60
    252,78,42
    227,26,28
    189,0,38
    128,0,38
    ] / 255;
    indexes = 0:(size(_YlOrRd_data, 'r') - 1);
    red = _YlOrRd_data(:,1)';
    green = _YlOrRd_data(:,2)';
    blue = _YlOrRd_data(:,3)';
    pIndexes = indexes/(size(_YlOrRd_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


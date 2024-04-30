//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=YlOrBrcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "YlOrBrcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "YlOrBrcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "YlOrBrcolormap", 1));
    end
    _YlOrBr_data = [
    255,255,229
    255,247,188
    254,227,145
    254,196,79
    254,153,41
    236,112,20
    204,76,2
    153,52,4
    102,37,6
    ] / 255;
    indexes = 0:(size(_YlOrBr_data, 'r') - 1);
    red = _YlOrBr_data(:,1)';
    green = _YlOrBr_data(:,2)';
    blue = _YlOrBr_data(:,3)';
    pIndexes = indexes/(size(_YlOrBr_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction


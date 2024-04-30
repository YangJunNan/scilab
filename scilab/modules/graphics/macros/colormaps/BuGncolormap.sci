//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=BuGncolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "BuGncolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "BuGncolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "BuGncolormap", 1));
    end
    _BuGn_data = [
    247,252,253
    229,245,249
    204,236,230
    153,216,201
    102,194,164
    65,174,118
    35,139,69
    0,109,44
    0,68,27
    ] / 255;
    indexes = 0:(size(_BuGn_data, 'r') - 1);
    red = _BuGn_data(:,1)';
    green = _BuGn_data(:,2)';
    blue = _BuGn_data(:,3)';
    pIndexes = indexes/(size(_BuGn_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


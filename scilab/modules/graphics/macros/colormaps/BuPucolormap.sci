//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=BuPucolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "BuPucolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "BuPucolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "BuPucolormap", 1));
    end
    _BuPu_data = [
    247,252,253
    224,236,244
    191,211,230
    158,188,218
    140,150,198
    140,107,177
    136,65,157
    129,15,124
    77,0,75
    ] / 255;
    indexes = 0:(size(_BuPu_data, 'r') - 1);
    red = _BuPu_data(:,1)';
    green = _BuPu_data(:,2)';
    blue = _BuPu_data(:,3)';
    pIndexes = indexes/(size(_BuPu_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


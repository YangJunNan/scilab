//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=RdPucolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "RdPucolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "RdPucolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "RdPucolormap", 1));
    end
    _RdPu_data = [
    255,247,243
    253,224,221
    252,197,192
    250,159,181
    247,104,161
    221,52,151
    174,1,126
    122,1,119
    73,0,106
    ] / 255;
    indexes = 0:(size(_RdPu_data, 'r') - 1);
    red = _RdPu_data(:,1)';
    green = _RdPu_data(:,2)';
    blue = _RdPu_data(:,3)';
    pIndexes = indexes/(size(_RdPu_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


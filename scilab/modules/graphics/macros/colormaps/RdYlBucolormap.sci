//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=RdYlBucolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "RdYlBucolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "RdYlBucolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "RdYlBucolormap", 1));
    end
    _RdYlBu_data = [
    165,0,38
    215,48,39
    244,109,67
    253,174,97
    254,224,144
    255,255,191
    224,243,248
    171,217,233
    116,173,209
    69,117,180
    49,54,149
    ] / 255;
    indexes = 0:(size(_RdYlBu_data, 'r') - 1);
    red = _RdYlBu_data(:,1)';
    green = _RdYlBu_data(:,2)';
    blue = _RdYlBu_data(:,3)';
    pIndexes = indexes/(size(_RdYlBu_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


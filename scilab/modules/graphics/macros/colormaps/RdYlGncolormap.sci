//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=RdYlGncolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "RdYlGncolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "RdYlGncolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "RdYlGncolormap", 1));
    end
    _RdYlGn_data = [
    165,0,38
    215,48,39
    244,109,67
    253,174,97
    254,224,139
    255,255,191
    217,239,139
    166,217,106
    102,189,99
    26,152,80
    0,104,55
    ] / 255;
    indexes = 0:(size(_RdYlGn_data, 'r') - 1);
    red = _RdYlGn_data(:,1)';
    green = _RdYlGn_data(:,2)';
    blue = _RdYlGn_data(:,3)';
    pIndexes = indexes/(size(_RdYlGn_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=Spectralcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "Spectralcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "Spectralcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "Spectralcolormap", 1));
    end
    _Spectral_data = [
    158,1,66
    213,62,79
    244,109,67
    253,174,97
    254,224,139
    255,255,191
    230,245,152
    171,221,164
    102,194,165
    50,136,189
    94,79,162
    ] / 255;
    indexes = 0:(size(_Spectral_data, 'r') - 1);
    red = _Spectral_data(:,1)';
    green = _Spectral_data(:,2)';
    blue = _Spectral_data(:,3)';
    pIndexes = indexes/(size(_Spectral_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


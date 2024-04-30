//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//

//
// Colormap inspired from https://colorbrewer2.org/
//
function cmap=BrBGcolormap(varargin)
    // Check number of input argument
    if size(varargin)<>1 then
        error(msprintf(gettext("%s: Wrong number of input argument(s): %d expected.\n"), "BrBGcolormap", 1));
    end
    cmapSize=varargin(1);

    // Check type of input argument
    // Check if input argument is real
    if typeof(cmapSize)<>"constant" | ~isreal(cmapSize) then
        error(msprintf(gettext("%s: Wrong type for input argument #%d: a real scalar expected.\n"), "BrBGcolormap", 1));
    end

    // Check size of input argument
    if size(cmapSize,"*")<>1 then
        error(msprintf(gettext("%s: Wrong size for input argument #%d: a real scalar expected.\n"), "BrBGcolormap", 1));
    end
    _BrBG_data = [
    84,48,5
    140,81,10
    191,129,45
    223,194,125
    246,232,195
    245,245,245
    199,234,229
    128,205,193
    53,151,143
    1,102,94
    0,60,48
    ] / 255;
    indexes = 0:(size(_BrBG_data, 'r') - 1);
    red = _BrBG_data(:,1)';
    green = _BrBG_data(:,2)';
    blue = _BrBG_data(:,3)';
    pIndexes = indexes/(size(_BrBG_data, 'r') - 1) * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, green, 0:(cmapSize - 1), "linear")', ...
    interp1(pIndexes, blue, 0:(cmapSize - 1), "linear")'];
endfunction


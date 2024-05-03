// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function cmap = coolwarm(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap generated from http://www.kennethmoreland.com/color-maps/CoolWarmFloat257.csv
    indexes = [0, 74, 128, 176, 255];
    red = [0.230, 0.607, 0.865, 0.97, 0.706];
    green = [0.299, 0.735, 0.865, 0.694, 0.016];
    blue = [0.754, 0.999, 0.865, 0.579, 0.150];
    pIndexes = indexes/255 * cmapSize;
    cmap = [interp1(pIndexes, red, 0:(cmapSize - 1), "spline")', ...
            interp1(pIndexes, green, 0:(cmapSize - 1), "spline")', ...
            interp1(pIndexes, blue, 0:(cmapSize - 1), "spline")'];
endfunction

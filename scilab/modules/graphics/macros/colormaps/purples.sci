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

function cmap = purples(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    purplesData = [
        252,251,253
        239,237,245
        218,218,235
        188,189,220
        158,154,200
        128,125,186
        106,81,163
        84,39,143
        63,0,125
    ] / 255;

    cmap = %_InterpolatedColormap(purplesData, cmapSize, "spline");
endfunction

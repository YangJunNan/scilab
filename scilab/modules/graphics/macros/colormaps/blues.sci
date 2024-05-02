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

function cmap = blues(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    bluesData = [
        247,251,255
        222,235,247
        198,219,239
        158,202,225
        107,174,214
        66,146,198
        33,113,181
        8,81,156
        8,48,107
    ] / 255;

    cmap = %_InterpolatedColormap(bluesData, cmapSize, "spline");
endfunction

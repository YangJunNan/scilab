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

function cmap = GnBu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    GnBu_Data = [
        247,252,240
        224,243,219
        204,235,197
        168,221,181
        123,204,196
        78,179,211
        43,140,190
        8,104,172
        8,64,129
    ] / 255;

    cmap = %_InterpolatedColormap(GnBu_Data, cmapSize, "spline");
endfunction

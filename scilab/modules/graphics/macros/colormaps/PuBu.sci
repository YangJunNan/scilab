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

function cmap = PuBu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    PuBu_Data = [
        255,247,251
        236,231,242
        208,209,230
        166,189,219
        116,169,207
        54,144,192
        5,112,176
        4,90,141
        2,56,88
    ] / 255;

    cmap = %_InterpolatedColormap(PuBu_Data, cmapSize, "spline");
endfunction

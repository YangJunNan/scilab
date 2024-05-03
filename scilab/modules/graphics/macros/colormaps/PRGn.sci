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

function cmap = PRGn(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    PRGn_Data = [
        64,0,75
        118,42,131
        153,112,171
        194,165,207
        231,212,232
        247,247,247
        217,240,211
        166,219,160
        90,174,97
        27,120,55
        0,68,27
    ] / 255;

    cmap = %_InterpolatedColormap(PRGn_Data, cmapSize, "spline");
endfunction

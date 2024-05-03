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

function cmap = YlOrBr(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    YlOrBr_Data = [
        255,255,229
        255,247,188
        254,227,145
        254,196,79
        254,153,41
        236,112,20
        204,76,2
        153,52,4
        102,37,6
    ] / 255;

    cmap = %_InterpolatedColormap(YlOrBr_Data, cmapSize, "spline");
endfunction

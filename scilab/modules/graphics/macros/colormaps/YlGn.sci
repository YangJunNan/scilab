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

function cmap = YlGn(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    YlGn_Data = [
        255,255,229
        247,252,185
        217,240,163
        173,221,142
        120,198,121
        65,171,93
        35,132,67
        0,104,55
        0,69,41
    ] / 255;

    cmap = %_InterpolatedColormap(YlGn_Data, cmapSize, "linear");
endfunction

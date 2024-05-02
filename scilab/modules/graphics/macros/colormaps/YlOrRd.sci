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

function cmap = YlOrRd(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    YlOrRd_Data = [
        255,255,204
        255,237,160
        254,217,118
        254,178,76
        253,141,60
        252,78,42
        227,26,28
        189,0,38
        128,0,38
    ] / 255;

    cmap = %_InterpolatedColormap(YlOrRd_Data, cmapSize, "linear");
endfunction

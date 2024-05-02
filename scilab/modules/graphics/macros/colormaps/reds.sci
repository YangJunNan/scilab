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

function cmap = reds(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    redsData = [
        255,245,240
        254,224,210
        252,187,161
        252,146,114
        251,106,74
        239,59,44
        203,24,29
        165,15,21
        103,0,13
    ] / 255;

    cmap = %_InterpolatedColormap(redsData, cmapSize, "linear");
endfunction

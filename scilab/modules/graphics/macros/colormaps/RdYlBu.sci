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

function cmap = RdYlBu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    RdYlBu_Data = [
        165,0,38
        215,48,39
        244,109,67
        253,174,97
        254,224,144
        255,255,191
        224,243,248
        171,217,233
        116,173,209
        69,117,180
        49,54,149
    ] / 255;

    cmap = %_InterpolatedColormap(RdYlBu_Data, cmapSize, "linear");
endfunction

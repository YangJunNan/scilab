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

function cmap = RdYlGn(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    RdYlGn_Data = [
        165,0,38
        215,48,39
        244,109,67
        253,174,97
        254,224,139
        255,255,191
        217,239,139
        166,217,106
        102,189,99
        26,152,80
        0,104,55
    ] / 255;

    cmap = %_InterpolatedColormap(RdYlGn, cmapSize, "linear");
endfunction

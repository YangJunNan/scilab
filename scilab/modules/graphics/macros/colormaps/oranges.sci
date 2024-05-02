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

function cmap = oranges(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    orangesData = [
        255,245,235
        254,230,206
        253,208,162
        253,174,107
        253,141,60
        241,105,19
        217,72,1
        166,54,3
        127,39,4
    ] / 255;

    cmap = %_InterpolatedColormap(orangesData, cmapSize, "linear");
endfunction

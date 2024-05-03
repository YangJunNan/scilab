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

function cmap = BrBG(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    BrBG_Data = [
        84,48,5
        140,81,10
        191,129,45
        223,194,125
        246,232,195
        245,245,245
        199,234,229
        128,205,193
        53,151,143
        1,102,94
        0,60,48
    ] / 255;

    cmap = %_InterpolatedColormap(BrBG_Data, cmapSize, "linear");
endfunction

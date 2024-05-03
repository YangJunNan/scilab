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

function cmap = RdBu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    RdBu_Data = [
        103,0,31
        178,24,43
        214,96,77
        244,165,130
        253,219,199
        247,247,247
        209,229,240
        146,197,222
        67,147,195
        33,102,172
        5,48,97
    ] / 255;

    cmap = %_InterpolatedColormap(RdBu_Data, cmapSize, "linear");
endfunction

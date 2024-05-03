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

function cmap = BuPu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    BuPu_Data = [
        247,252,253
        224,236,244
        191,211,230
        158,188,218
        140,150,198
        140,107,177
        136,65,157
        129,15,124
        77,0,75
    ] / 255;

    cmap = %_InterpolatedColormap(BuPu_Data, cmapSize, "linear");
endfunction

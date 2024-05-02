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

function cmap = BuGn(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    BuGn_Data = [
        247,252,253
        229,245,249
        204,236,230
        153,216,201
        102,194,164
        65,174,118
        35,139,69
        0,109,44
        0,68,27
    ] / 255;

    cmap = %_InterpolatedColormap(BuGn_Data, cmapSize, "linear");
endfunction

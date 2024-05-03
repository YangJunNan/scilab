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

function cmap = greens(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    greensData = [
        247,252,245
        229,245,224
        199,233,192
        161,217,155
        116,196,118
        65,171,93
        35,139,69
        0,109,44
        0,68,27
    ] / 255;

    cmap = %_InterpolatedColormap(greensData, cmapSize, "linear");
endfunction

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

function cmap = PuOr(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    PuOr_Data = [
        179,88,6
        224,130,20
        253,184,99
        254,224,182
        247,247,247
        216,218,235
        178,171,210
        128,115,172
        84,39,136
    ] / 255;

    cmap = %_InterpolatedColormap(PuOr_Data, cmapSize, "linear");
endfunction

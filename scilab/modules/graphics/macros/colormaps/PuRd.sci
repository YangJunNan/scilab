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

function cmap = PuRd(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    PuRd_Data = [
        247,244,249
        231,225,239
        212,185,218
        201,148,199
        223,101,176
        231,41,138
        206,18,86
        152,0,67
        103,0,31
    ] / 255;

    cmap = %_InterpolatedColormap(PuRd_Data, cmapSize, "linear");
endfunction

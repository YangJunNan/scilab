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

function cmap = PiYG(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    PiYG_Data = [
        142,1,82
        197,27,125
        222,119,174
        241,182,218
        253,224,239
        247,247,247
        230,245,208
        184,225,134
        127,188,65
        77,146,33
        39,100,25
    ] / 255;

    cmap = %_InterpolatedColormap(PiYG_Data, cmapSize, "linear");
endfunction
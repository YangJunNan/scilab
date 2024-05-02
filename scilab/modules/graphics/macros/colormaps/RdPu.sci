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

function cmap = RdPu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    RdPu_Data = [
        255,247,243
        253,224,221
        252,197,192
        250,159,181
        247,104,161
        221,52,151
        174,1,126
        122,1,119
        73,0,106
    ] / 255;

    cmap = %_InterpolatedColormap(RdPu_Data, cmapSize, "linear");
endfunction

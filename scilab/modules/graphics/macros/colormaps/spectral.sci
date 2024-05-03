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

function cmap = spectral(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    spectralData = [
        158,1,66
        213,62,79
        244,109,67
        253,174,97
        254,224,139
        255,255,191
        230,245,152
        171,221,164
        102,194,165
        50,136,189
        94,79,162
    ] / 255;

    cmap = %_InterpolatedColormap(spectralData, cmapSize, "linear");
endfunction

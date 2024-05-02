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

function cmap = YlGnBu(cmapSize)
    arguments
        cmapSize (1,1) double {mustBeReal} = 32
    end

    // Colormap data inspired from https://colorbrewer2.org/
    YlGnBu_Data = [
        255,255,217
        237,248,177
        199,233,180
        127,205,187
        65,182,196
        29,145,192
        34,94,168
        37,52,148
        8,29,88
    ] / 255;

    cmap = %_InterpolatedColormap(YlGnBu_Data, cmapSize, "linear");
endfunction

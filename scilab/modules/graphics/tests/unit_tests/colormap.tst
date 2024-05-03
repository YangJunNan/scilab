// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2024 - 3DS - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->

cmapFunctions = [
    "blues", "BrBG", "BuGn", "BuPu", ...
    "coolwarm", ...
    "GnBu", "greens", "greys", ...
    "oranges", "OrRd", ...
    "PiYG", "PRGn", "PuBu", "PuBuGn", "PuOr", "PuRd", "purples", ...
    "RdBu", "RdGy", "RdPu", "RdYlBu", "RdYlGn", "reds", ...
    "spectral", ...
    "YlGn", "YlGnBu", "YlOrBr", "YlOrRd"];

for cmapFun = cmapFunctions

    // Call function directly
    execstr("cmap1 = " + cmapFun + "(42);");
    assert_checkequal(size(cmap1), [42, 3]);

    // Use colormap function with a string
    execstr("cmap2 = colormap(""" + cmapFun + """, 42);");
    assert_checkequal(size(cmap2), [42, 3]);

    assert_checkequal(cmap1, cmap2);

    // Use colormap function with a function
    execstr("cmap3 = colormap(" + cmapFun + ", 42);");
    assert_checkequal(size(cmap3), [42, 3]);

    assert_checkequal(cmap1, cmap3);
    
end

// Check that obsolete functions can still be called until removed
cmapFunctions = ["autumn", "bone", "cool", "copper", "gray", "hot", "hsv", "jet", ...
                 "ocean", "parula", "pink", "rainbow", "spring", "summer", "white", "winter"];

for cmapFun = cmapFunctions
    cmap = [];
    execstr("cmap = " + cmapFun + "colormap(42);");
    assert_checkequal(size(cmap), [42, 3]);
end

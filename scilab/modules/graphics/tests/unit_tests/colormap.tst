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
    // Default size
    execstr("cmap = " + cmapFun + "()");
    assert_checkequal(size(cmap), [32, 3]);
    // Given size
    execstr("cmap = " + cmapFun + "(42)");
    assert_checkequal(size(cmap), [42, 3]);

end

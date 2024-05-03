// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("hsv(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "hsv", 1);

assert_checkerror("hsv(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "hsv", 1);

assert_checkerror("hsv(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "hsv", 1);

assert_checkerror("hsv([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "hsv", 1);

assert_checkequal(hsv(0), []);

assert_checkequal(hsv(1), [1 0 0]);

assert_checkequal(hsv(2), [1 0 0;0 1 1]);

assert_checkequal(hsv(3), [1 0 0;0 1 0;0 0 1]);

// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("cool(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "cool", 1);

assert_checkerror("cool(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "cool", 1);

assert_checkerror("cool(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "cool", 1);

assert_checkerror("cool([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "cool", 1);

assert_checkequal(cool(0), []);

assert_checkequal(cool(1), [0 1 1]);

assert_checkequal(cool(2), [0 1 1;1 0 1]);

assert_checkequal(cool(3), [0 1 1;0.5 0.5 1;1 0 1]);

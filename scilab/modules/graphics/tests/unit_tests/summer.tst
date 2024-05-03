// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("summer(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "summer", 1);

assert_checkerror("summer(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "summer", 1);

assert_checkerror("summer(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "summer", 1);

assert_checkerror("summer([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "summer", 1);

assert_checkequal(summer(0), []);

assert_checkequal(summer(1), [0 0.5 0.4]);

assert_checkequal(summer(2), [0 0.5 0.4;1 1 0.4]);

assert_checkequal(summer(3), [0 0.5 0.4;0.5 0.75 0.4;1 1 0.4]);

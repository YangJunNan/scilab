// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("white(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "white", 1);

assert_checkerror("white(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "white", 1);

assert_checkerror("white(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "white", 1);

assert_checkerror("white([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "white", 1);

assert_checkequal(white(0), []);

assert_checkequal(white(1), ones(1,3));

assert_checkequal(white(2), ones(2,3));

assert_checkequal(white(3), ones(3,3));

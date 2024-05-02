// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("spring(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "spring", 1);

assert_checkerror("spring(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "spring", 1);

assert_checkerror("spring(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "spring", 1);

assert_checkerror("spring([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "spring", 1);

assert_checkequal(spring(0), []);

assert_checkequal(spring(1), [1 0 1]);

assert_checkequal(spring(2), [1 0 1;1 1 0]);

assert_checkequal(spring(3), [1 0 1;1 0.5 0.5;1 1 0]);

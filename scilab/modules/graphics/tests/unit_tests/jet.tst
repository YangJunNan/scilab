// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("jet(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "jet", 1);

assert_checkerror("jet(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "jet", 1);

assert_checkerror("jet(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "jet", 1);

assert_checkerror("jet([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "jet", 1);

assert_checkequal(jet(0), []);

assert_checkequal(jet(1), [0.5 1 0.5]);

assert_checkequal(jet(2), [0 0.5 1;1 0.5 0]);

assert_checkalmostequal(jet(3), [0 1/6 1;0.5 1 0.5;1 1/6 0]);

// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("rainbow(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "rainbow", 1);

assert_checkerror("rainbow(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "rainbow", 1);

assert_checkerror("rainbow(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "rainbow", 1);

assert_checkerror("rainbow([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "rainbow", 1);

assert_checkequal(rainbow(0), []);

assert_checkequal(rainbow(1), [0,1,0.5]);

assert_checkequal(rainbow(2), [0.75,1,0;0,0.25,1]);

assert_checkalmostequal(rainbow(3), [1,5/6,0;0,1,0.5;1/6,0,1]);

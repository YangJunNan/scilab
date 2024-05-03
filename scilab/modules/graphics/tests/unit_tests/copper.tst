// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("copper(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "copper", 1);

assert_checkerror("copper(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "copper", 1);

assert_checkerror("copper(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "copper", 1);

assert_checkerror("copper([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "copper", 1);

assert_checkequal(copper(0), []);

assert_checkequal(copper(1), [1 0.8 0.5]);

assert_checkequal(copper(2), [0 0 0;1 0.8 0.5]);

assert_checkequal(copper(3), [0 0 0;0.625 0.4 0.25;1 0.8 0.5]);

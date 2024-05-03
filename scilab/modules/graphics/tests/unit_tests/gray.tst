// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2011 - DIGITEO - Vincent COUVERT
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

assert_checkerror("gray(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "gray", 1);

assert_checkerror("gray(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "gray", 1);

assert_checkerror("gray(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "gray", 1);

assert_checkerror("gray([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "gray", 1);

assert_checkequal(gray(0), []);

assert_checkequal(gray(1), [0 0 0]);

assert_checkequal(gray(2), [0 0 0;1 1 1]);

assert_checkequal(gray(3), [0 0 0;0.5 0.5 0.5;1 1 1]);

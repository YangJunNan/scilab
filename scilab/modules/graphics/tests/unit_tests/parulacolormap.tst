// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) Scilab Enterprises - 2015 - Juergen Koch <juergen.koch@hs-esslingen.de>
// 
// This file must be used under the terms of the CeCILL.
// This source file is licensed as described in the file COPYING, which
// you should have received as part of this distribution.  The terms
// are also available at    
// http://www.cecill.info/licences/Licence_CeCILL_V2.1-en.txt

// <-- TEST WITH GRAPHIC -->

assert_checkerror("parulacolormap(0,1,2,3)", "%s: Wrong number of input argument(s): %d expected.\n", 10000, "parulacolormap", 1);

assert_checkerror("parulacolormap(%t)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "parulacolormap", 1);

assert_checkerror("parulacolormap(%i)", "%s: Wrong type for input argument #%d: a real scalar expected.\n", 10000, "parulacolormap", 1);

assert_checkerror("parulacolormap([0 1 2 3])", "%s: Wrong size for input argument #%d: a real scalar expected.\n", 10000, "parulacolormap", 1);

assert_checkequal(parulacolormap(0), []);
// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2022-2023 - UTC - Stéphane MOTTELET
//
// This file must be used under the terms of GPL License
// This source file is licensed as described in the file COPYING, which
// you should have received as part of this distribution.  The terms
// are also available at
// https://www.gnu.org/licenses/gpl-3.0.txt

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

source = fullfile(SCI,"modules","differential_equations","tests","unit_tests","cvRoberts_klu.c")
SUN_Clink(["sunRhs","sunJac"],source,load=%t);

y0 = [1;0;0];
tspan = [0 4*10^[-1:6]];
[t,y] = cvode("sunRhs",tspan,y0,jacNonZeros=9,jacobian="sunJac",rtol=1e-4,atol=[1e-8,1e-14,1e-6]);
assert_checktrue(max(abs(y(:,$)-[5.16810230841373936D-04
   2.06829700402541268D-09
   9.99483187700861198D-01]))<1e-6)

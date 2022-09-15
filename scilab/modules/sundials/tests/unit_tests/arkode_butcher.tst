// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2022 - Stéphane Mottelet
//
// This file must be used under the terms of GPL License
// This source file is licensed as described in the file COPYING, which
// you should have received as part of this distribution.  The terms
// are also available at
// https://www.gnu.org/licenses/gpl-3.0.txt

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// check that internal tableau match custom version
A = [1 0; -1 1];
c = [1; 0];
b = [0.5 0.5];
d = [1 0];
q = 2;
p = 1;
[t1,y1] = arkode(%SUN_vdp1,[1 10],[2;1], DIRKButcherTableau=[c A;q b;p d]);
[t2,y2] = arkode(%SUN_vdp1,[1 10],[2;1], method="DIRK_2");
assert_checkequal(t1,t2)
assert_checkequal(y1,y2)

// check that internal tableau match custom version
A = [0 0; 1 0];
c = [0; 1];
b = [0.5 0.5];
d = [1 0];
q = 2;
p = 1;
[t1,y1] = arkode(%SUN_vdp1,[1 10],[2;1], ERKButcherTableau=[c A;q b;p d]);
[t2,y2] = arkode(%SUN_vdp1,[1 10],[2;1], method="ERK_2");
assert_checkequal(t1,t2)
assert_checkequal(y1,y2)

// test predefined custom tableaux
s=arkode(%SUN_vdp1,1:10,[2;1],ERKButcherTableau=%SUN_Tsitouras5());
assert_checkequal(s.method,"USER_ERK_7_4_5");
assert_checkequal(s.stats.nSteps,50);
s=arkode(%SUN_vdp1,1:10,[2;1],ERKButcherTableau=%SUN_DormandPrince6());
assert_checkequal(s.method,"USER_ERK_8_5_6");
assert_checkequal(s.stats.nSteps,38);
s=arkode(%SUN_vdp1,1:10,[2;1],ERKButcherTableau=%SUN_DormandPrince8());
assert_checkequal(s.method,"USER_ERK_13_7_8");
assert_checkequal(s.stats.nSteps,26);

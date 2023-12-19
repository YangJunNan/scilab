// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2006-2008 - INRIA - Serge STEER <serge.steer@inria.fr>
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// <-- Non-regression test for bug 2284 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/2284
//
// <-- Short Description -->
//    Numerical error when carrying out a particular calculation using the
//    complex exp function.  E.g.
//
//    -->20 * exp(%i * 2 * %pi / 3)
//     ans  =
//
//      -11. + 17.320508i
//
//    This is the wrong result!!

s1 = -9.999999999;
s2 = 0.999999999999;

print(TMPDIR+"/bug2284",s1,s2);
txt = mgetl(TMPDIR+"/bug2284");
if or(txt <> ["" ; "   1.0000000" ; "" ; "  -10.000000" ; ""]) then pause,end
mdelete(TMPDIR+"/bug2284");

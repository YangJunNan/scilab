// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stéphane MOTTELET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->
//
// <-- Non-regression test for bug 16029 -->
//
// <-- Bugzilla URL -->
// http://bugzilla.scilab.org/16029
//
// <-- Short Description -->
// plot2d([1 2]*1e-14): Y-axis extending out of its range for small Y values

t=linspace(1e-200,1e-30,100);
plot(t,sin(t))
xs2gif(0,"bug_16029_1.gif")
gca().tight_limits="on"
xs2gif(0,"bug_16029_2.gif")

fp = mopen("bug_16029_1.gif");
hash1 = hash(fp,"sha256")
mclose(fp)
assert_checkequal(hash1,"073b8fd88dc7d44d2212f203d99e36c343975308c7927de0d7c588e6c27d9238")

fp = mopen("bug_16029_2.gif");
hash1 = hash(fp,"sha256")
mclose(fp)
assert_checkequal(hash1,"958f8831a654a0fcf5cc11ce4bde32e2d02f3f6441a8f2d5af6db2fd53fa9b5a")

// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2013 - Scilab Enterprises - Charlotte HECQUET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- TEST WITH GRAPHIC -->
// unit test for typeof()

// handle
plot();
f=gcf();
assert_checkequal(typeof(f),"handle");
a=gca();
assert_checkequal(typeof(a),"handle");
e=gce();
assert_checkequal(typeof(e),"handle");
assert_checkequal(typeof(a.children(1)),"handle");
close

// uitree
l1 = uiCreateNode("CONST_m","default","");
assert_checkequal(typeof(l1),"uitree");
tree = uiCreateTree(l1);
assert_checkequal(typeof(tree),"uitree");
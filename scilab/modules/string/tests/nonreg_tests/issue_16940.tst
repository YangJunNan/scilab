// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2023 - 3DS - Antoine ELIAS
//
// <-- NO CHECK REF -->

// <-- Non-regression test for bug 16940 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/16940
//
// <-- Short Description -->
// string of cell, struct, list does not call overload
// -------------------------------------------------------------

assert_checkequal(string({}), "{}");
assert_checkequal(string(list()), []);
assert_checkequal(string(struct()), "0x0 struct with no field");
plot();
assert_checkequal(string({gce(),gce().children(1)}), ["[1x1 handle]","[1x1 handle]"]);

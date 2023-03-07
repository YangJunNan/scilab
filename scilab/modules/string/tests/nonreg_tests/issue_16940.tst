// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2023 - 3DS - Antoine ELIAS
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// <-- Non-regression test for bug 16940 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/16940
//
// <-- Short Description -->
// string of cell, struct, list does not call overload
// -------------------------------------------------------------

assert_checktrue(execstr("string({})", "errcatch") <> 0);
assert_checktrue(execstr("string(list())", "errcatch") <> 0);
assert_checktrue(execstr("string(struct())", "errcatch") <> 0);

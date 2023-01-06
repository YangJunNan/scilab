// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2013 - Scilab Enterprises- Charlotte HECQUET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
//
// <-- Non-regression test for bug 12639 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/12639
//
// <-- Short Description -->
// justify([], position) returns an error instead of ""

assert_checkequal(justify([], "l"), []);
assert_checkequal(justify([], "r"), []);
assert_checkequal(justify([], "c"), []);

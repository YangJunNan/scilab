// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2006-2008 - INRIA - Serge STEER <serge.steer@inria.fr>
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
// <-- CLI SHELL MODE -->
// <-- ENGLISH IMPOSED -->
// <-- NO CHECK REF -->
// <-- Non-regression test for bug 950 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/950
//
// <-- Short Description -->
//    extra character in "select" line crashes Scilab instead of 
//    issuing a "syntax error" message.

execstr([
	"function [] = Select (Type)"
		"select Type, n"
			"case 1 then"
				"disp (""1"")"
			"case 2 then"
				"disp (""2"")"
		"end;"
	"endfunction;"], "errcatch");
msg = lasterror(%t)
assert_checktrue(grep(msg, "syntax error") <> []);
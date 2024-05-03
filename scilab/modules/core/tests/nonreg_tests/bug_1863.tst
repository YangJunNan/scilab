// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2005-2008 - INRIA - Pierre MARECHAL <pierre.marechal@inria.fr>
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// <-- Non-regression test for bug 1863 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/1863
//
// <-- Short Description -->
//Incomplete if while select (missing first expression are not well handled
ierr = execstr([
  "function foo"
    "if"
    "end"
  "endfunction"], "errcatch");
msg = lasterror(%t)
assert_checktrue(ierr <> 0);
assert_checktrue(grep(msg, "syntax error") <> []);

ierr = execstr([
  "function foo1"
    "while"
    "end"
  "endfunction"], "errcatch");
msg = lasterror(%t)
assert_checktrue(ierr <> 0);
assert_checktrue(grep(msg, "syntax error") <> []);
  
ierr = execstr([
  "function foo2"
    "select"
    "end"
  "endfunction"], "errcatch");
msg = lasterror(%t)
assert_checktrue(ierr <> 0);
assert_checktrue(grep(msg, "syntax error") <> []);
  

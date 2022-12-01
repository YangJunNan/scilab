// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Cedric DELAMARRE
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- Non-regression test for bug 16911 -->
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// <-- Short Description -->
// Wrong line number in callstack

// test scrit
script=["[linn, mac] = where();", ...
        "assert_checkequal(linn, [1; 2; 47]);", ...
        "assert_checkequal(mac, [""exec""; ""bug_16911""; ""exec""]);"];

// create a script file
mputl(script, TMPDIR+"/issue_16911_script.sce");

// execute it
function bug_16911()
    exec(TMPDIR+"/issue_16911_script.sce");
end

bug_16911();
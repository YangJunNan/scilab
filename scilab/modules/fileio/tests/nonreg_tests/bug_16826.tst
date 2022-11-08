// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stéphane MOTTELET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// <-- Non-regression test for bug 9917 -->
//
// <-- Bugzilla URL -->
// http://bugzilla.scilab.org/show_bug.cgi?id=16826
//
// <-- Short Description -->
//file() or file(fid) could yield outdated relative paths
//

cd(TMPDIR);
d = pwd();
fid = file("open","test.txt","unknown");
[?, ?, filepath] = file(fid);
assert_checkequal(fullfile(d,"test.txt"),filepath);

cd ..
[?, ?, filepath] = file(fid);
assert_checkequal(fullfile(d,"test.txt"),filepath);

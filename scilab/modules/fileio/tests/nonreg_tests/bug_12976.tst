// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2013 - Scilab Enterprises
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- CLI SHELL MODE -->

// <-- Non-regression test for bug 12976 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/12976
//
// <-- Short Description -->
// getURL() returns a file name instead of a file path

curdir = pwd();
cd(TMPDIR);

filepath = getURL("https://www.scilab.org");
assert_checkequal(filepath, fullfile(TMPDIR, "index.html"));
deletefile(filepath);

filepath = getURL("https://www.scilab.org", fullfile(TMPDIR, "scilab_homepage.html"));
assert_checkequal(filepath, fullfile(TMPDIR, "scilab_homepage.html"));
deletefile(filepath);

cd(curdir);

// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2017 - Scilab Enteprises - Clement DAVID
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/14636
//
// <-- Short Description -->
// A crash occurred after read()-ing an empty file

fd = mopen(TMPDIR+"/empty", "w");
assert_checkequal(mclose(fd), 0);

l = read(TMPDIR+"/empty",-1,1,"(a)");

deletefile(TMPDIR+"/empty");


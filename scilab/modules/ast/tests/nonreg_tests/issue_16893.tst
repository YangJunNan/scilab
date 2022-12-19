// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Dassault Systemes - Cedric DELAMARRE
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// <-- Non-regression test for issue 16893-->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/16893
//
// <-- Short Description -->
// "exec" instruction crashes Scilab.
//

fname = fullfile(TMPDIR, "issue_19893.sce");
txt = [ "1;//"; ";"; ";"];
mputl(txt, fname);
exec(fname, -1)
deletefile(fname)
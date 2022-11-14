// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stéphane MOTTELET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// <-- Non-regression test for bug 16822 -->
//
// <-- Bugzilla URL -->
// http://bugzilla.scilab.org/show_bug.cgi?id=16822
//
// <-- Short Description -->
// getrelativefilename returns incorrect value in case of same beginning of directory names


if getos() == "Windows"
    relpath = getrelativefilename('scilab\bin', 'scilabX\modules\helptools\readme.txt');
    assert_checkequal(relpath,"..\..\scilabX\modules\helptools\readme.txt")
else
    relpath = getrelativefilename('scilab/bin', 'scilabX/modules/helptools/readme.txt');
    assert_checkequal(relpath,"../../scilabX/modules/helptools/readme.txt")
end
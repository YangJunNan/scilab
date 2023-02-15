// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2020 - Stéphane MOTTELET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// <-- Non-regression test for bug 16708 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/16708
//
// <-- Short Description -->
// mgetl cannot read from stdin

if (getos() <> "Windows") & ~isfile(SCI+"/bin/scilab") then
    SCI_BIN = strsubst(SCI,"|/share/scilab/?$|","","r") + "/bin/scilab";
else
    SCI_BIN = pathconvert(SCI)+"bin\scilab";
end

cmd = msprintf("echo success| %s -ns -nwni -nb -e %s", SCI_BIN, """str=mgetl(%io(1));mprintf(str)""");
result = unix_g(cmd);
assert_checkequal(result,"success");
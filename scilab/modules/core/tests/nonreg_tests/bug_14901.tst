// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2017 - ESI - Antoine ELIAS
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- Non-regression test for bug 14901 -->
// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->
//
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/14901
//
// <-- Short Description -->

if getos() == "Windows"
    sciBin = WSCI + "\bin\scilex";
else
    sciBin = strsplit(SCI, "share/scilab")(1) + "/bin/scilab-cli";
end

txt = [...
"import java.io.IOException;"
"import java.lang.InterruptedException;"
""
"public class Test_Exec_Scilab {"
"    public static void main(String[] args) throws IOException, InterruptedException {"
"    String cmd = """ + sciBin + " -e a=string(1:10);mputl(a,''"" + args[0] + ""'');quit"";"
"    Process p = Runtime.getRuntime().exec(cmd);"
"    p.waitFor();"
"    }"
"}"];

f = fullfile(TMPDIR, "/scilab.out");

j = jcompile("Test_Exec_Scilab", txt);
j.main(f);

v = mgetl(f);
assert_checkequal(v, string(1:10)');


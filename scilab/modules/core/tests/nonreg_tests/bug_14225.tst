// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2015 - Scilab Enterprises - Cedric Delamarre
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
// <-- NO CHECK ERROR OUTPUT -->
//
// <-- Non-regression test for bug 14225 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/14225
//
// <-- Short Description -->
// command-line option "-quit" should set the processs Exit status

//scilab path
if (getos() <> "Windows") & ~isfile(SCI+"/bin/scilab") then
    scilabBin = WSCI + "\bin\scilex ";
else
    scilabBin = strsplit(SCI, "share/scilab")(1) + "/bin/scilab-cli ";
end

//With -quit argument
err = unix(scilabBin + "-e ""exit()"" -quit");
assert_checkequal(err, 0);
err = unix(scilabBin + "-e ""1+1;"" -quit");
assert_checkequal(err, 0);
err = unix(scilabBin + "-e ""1+1; exit(12)"" -quit");
assert_checkequal(err, 12);
err = unix(scilabBin + "-e ""error(\""error_test\"");"" -quit");
assert_checktrue(err <> 0);
err = unix(scilabBin + "-e ""error(\""error_test\"");exit(12)"" -quit");
assert_checktrue(err <> 12 && err <> 0);
err = unix(scilabBin + "-e ""try, error(\""error_test\""); catch, disp(lasterror()),end"" -quit");
assert_checkequal(err, 0);
err = unix(scilabBin + "-e ""try, error(\""error_test\""); catch,disp(lasterror());exit(12), end"" -quit");
assert_checkequal(err, 12);

//Without -quit argument
err = unix(scilabBin + "-e ""exit()""");
assert_checkequal(err, 0);
err = unix(scilabBin + "-e ""1+1; exit(12)""");
assert_checkequal(err, 12);
err = unix(scilabBin + "-e ""try, error(\""error_test\""); catch,disp(lasterror());exit(12), end""");
assert_checkequal(err, 12);


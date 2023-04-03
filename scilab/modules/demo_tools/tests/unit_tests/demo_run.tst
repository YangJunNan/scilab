//=============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2023 - Samuel GOUGEON
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// DESCRIPTION
// Unitary test of demo_run()

// Init
scriptPath = fullfile(WSCI, "modules/demo_tools/tests/unit_tests/demo_run.sce");
envFuns = list(format, ieee, mode, lines, polyDisplay)

// Ref
envIn = list()
for f = envFuns
    envIn($+1) = f()
end

var_A = 123.4

// Run
demo_run(scriptPath);

// Check
for i = 1:length(envFuns)
    f = envFuns(i)
    assert_checkequal(f(), envIn(i));
end
assert_checkequal(var_A, 123.4);

// ERRORS
refmsg = _("%s: Wrong number of input arguments: %d or %d expected.\n");
refmsg = msprintf(refmsg, "demo_run", 1, 2);
assert_checkerror("demo_run()", refmsg);
assert_checkerror("demo_run(''test.sce'',1,2)", refmsg);

refmsg = msprintf(_("%s: Argument #%d: ''%s'' expected.\n"), "demo_run", 2, "needCompiler")
assert_checkerror("demo_run(''test.tst'', ''compiler'')", refmsg);

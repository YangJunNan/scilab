// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- NO CHECK REF -->
// <-- LONG TIME EXECUTION -->

// This tests runs all idempotence test on all Scilab macroFiles
// Do not activate CLI SHELL MODE for this test since we want to check all Scilab macros
// To be used when modifying the parser.
// Run this test using: test_run("ast", "parser_idempotence", "enable_lt")

function create_module_test(moduleName);
    template = mgetl("SCI/modules/ast/tests/unit_tests/parser_idempotence.template");
    template = strsubst(template, "<MODULENAME>", moduleName)

    testDir = fullfile(SCI, "modules", moduleName, "tests", "unit_tests")
    if ~isdir(testDir) then // Create test directory if it does not exist
        mkdir(fullfile(SCI, "modules", moduleName, "tests"), "unit_tests")
    end

    mputl(template, fullfile(testDir, "parser_idempotence_" + moduleName + ".tst"))
endfunction

exec("SCI/modules/ast/tests/unit_tests/parser_idempotence.sci", -1);
allModules = gsort(ls("SCI/modules/"), "r", "i");
for moduleName = allModules'
    if isdir(fullfile(SCI, "modules", moduleName)) then
        if isfile(fullfile(SCI, "modules", moduleName, "macros", "lib")) then // This module has macros
            create_module_test(moduleName) // Deloying template
            assert_checktrue(test_run(moduleName, "parser_idempotence_" + moduleName)); // Run test
        end
    end
end

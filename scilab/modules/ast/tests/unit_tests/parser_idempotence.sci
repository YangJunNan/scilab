// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2023 - Dassault Systemes - Bruno JOFRET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
function parser_idempotence(moduleName)
    macroFiles = []
    macrosDirPath = fullfile(SCI, "modules", moduleName)
    macroFiles = ls(fullfile(macrosDirPath, "*.sci"));
    dirContents = ls(macrosDirPath);
    for j = 1:size(dirContents, "*")
        fullPath = fullfile(macrosDirPath, dirContents(j));
        if isdir(fullPath) then
            macroFiles = [macroFiles; ls(fullfile(fullPath, "*.sci"))]
        end
    end

    prettyPrint1 = fullfile(TMPDIR, "prettyPrint1.sci")
    prettyPrint2 = fullfile(TMPDIR, "prettyPrint2.sci")
    for file = macroFiles'
        printf("%s\n", file)
        
        unix_g(pathconvert(SCI + "/bin/scilab", %F) + " -nwni -nb --pretty-print --parse-file " + file + " > " + prettyPrint1);
        unix_g(pathconvert(SCI + "/bin/scilab", %F) + " -nwni -nb --pretty-print --parse-file " + prettyPrint1 + " > " + prettyPrint2);

        txt1 = mgetl(prettyPrint1);
        txt2 = mgetl(prettyPrint2);

        assert_checkequal(txt1, txt2);
    end
endfunction
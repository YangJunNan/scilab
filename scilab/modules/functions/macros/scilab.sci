// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2024 - 3DS - Antoine ELIAS

function [err, stdout, stderr] = scilab(code, file, mode, quit, args)
    if isdef("code", "l") && isdef("file", "l") then
        error(sprintf(_("%s: code and file cannot both be defined."), "scilab"));
    end

    if ~isdef("code", "l") && ~isdef("file", "l") then
        error(sprintf(_("%s: code or file must be defined."), "scilab"));
    end

    if ~isdef("code", "l") then
        code = [];
    end

    if ~isdef("file", "l") then
        file = [];
    else
        if isfile(file) == %f then
            error(sprintf(_("%s: file ""%s"" must exist."), "scilab", file));
        end

        if getos() == "Windows" then
            file = sprintf("""%s""", file);
        end
    end

    if ~isdef("mode", "l") then
        mode = "nw";
    else
        if ~or(mode == ["nw" "nwni"])then
            error(sprintf(_("%s: mode must be in [""nw"", ""nwni""]."), "scilab"));
        end
    end

    if ~isdef("quit", "l") then
        quit = "-quit";
    else
        if type(quit) <> 4 then
            error(sprintf(_("%s: quit must be a boolean."), "scilab"));
        end

        if quit then
            quit = "-quit";
        else
            quit = "";
        end
    end

    if ~isdef("args", "l") then
        args = "";
    end

    if getos() == "Windows" then
        if mode == "nwni" then
            bin = "scilex"
        else
            bin = "wscilex-cli"
        end
    else
        if mode == "nwni" then
            bin = "scilab-cli";
        else
            bin = "scilab-adv-cli";
        end
    end

    if code <> [] then
        code = strsubst(code, """", "\""");
        code = strsubst(code, "''", "\''");
        cmd = sprintf("%s -nb %s -e ""%s"" %s", fullfile(SCI, "bin", bin), quit, code, args);
    else
        cmd = sprintf("%s -nb %s -f %s %s", fullfile(SCI, "bin", bin), quit, file, args);
    end

    [stdout, err, stderr] = unix_g(cmd);
endfunction
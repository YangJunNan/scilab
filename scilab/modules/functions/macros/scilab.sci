// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2024 - 3DS - Antoine ELIAS

function varargout = scilab(code, file, mode, quit, args, background)
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
            error(sprintf(_("%s: ''%s'' must be a boolean."), "scilab", "quit"));
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

    if ~isdef("background", "l") then
        background = %f;
    else
        if type(background) <> 4 then
            error(sprintf(_("%s: ''%s'' must be a boolean."), "scilab", "background"));
        end
    end

    start = "";
    if getos() == "Windows" then
        if background then
            start = "start /B "
        end

        if mode == "nwni" then
            bin = "scilex"
        else
            bin = "wscilex-cli"
        end
    else
        if background then
            args = args + " &";
        end

        if mode == "nwni" then
            bin = "scilab-cli";
        else
            bin = "scilab-adv-cli";
        end
    end

    if code <> [] then
        code = strsubst(code, """", "\""");
        code = strsubst(code, "''", "\''");
        cmd = sprintf("%s%s -nb %s -e ""%s"" %s", start, fullfile(SCI, "bin", bin), quit, code, args);
    else
        cmd = sprintf("%s%s -nb %s -f %s %s", start, fullfile(SCI, "bin", bin), quit, file, args);
    end

    printf("cmd: ""%s""\n", cmd);
    [varargout(2), varargout(1), varargout(3)] = unix_g(cmd);

    if background then
        varargout = list();
    end
endfunction
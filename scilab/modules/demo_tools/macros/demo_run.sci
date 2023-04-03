// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2007-2008 - INRIA - Ghislain HELIOT
// Copyright (C) 2012 - 2016 - Scilab Enterprises
// Copyright (C) 2023 - Samuel GOUGEON
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function demo_run(demoFile, needCompiler, varargin)

    rhs = argn(2)
    if rhs<1 | rhs>2
        msg = _("%s: Wrong number of input arguments: %d or %d expected.\n")
        error(msprintf(msg, "demo_run", 1, 2))
    end
    if  ~isdef("needCompiler","l")
        needCompiler = []
    else
        if type(needCompiler) <> 10 | size(needCompiler,"*") <> 1 | ..
            convstr(needCompiler) <> "needcompiler"
            msg = _("%s: Argument #%d: ''%s'' expected.\n")
            error(msprintf(msg, "demo_run", 2, "needCompiler"))
        end
    end

    // Check for a compiler when required
    if needCompiler <> [] then
        if ~haveacompiler() then
            msg = gettext(["Required C compiler not found." ; "This demo is disabled."])
            if or(getscilabmode()==["STD" "NW"])
                messagebox(msg, "modal")
            else
                demoFile = strsubst(demoFile, WSCI+filesep(), "WSCI"+filesep())
                demoFile = strsubst(demoFile, TMPDIR+filesep(), "TMPDIR"+filesep())
                mprintf("%s\n", [demoFile ; msg])
            end
            return
        end
    end

    // Save the environment
    envFuns_## = list(format, ieee, mode, lines, polyDisplay)
    envIn_## = list()
    tmp = mgetl(demoFile);
    if grep(tmp, "demo_begin")==[] then
        for f = envFuns_##
            envIn_##($+1) = f()
        end
        // format( https://gitlab.com/scilab/scilab/-/issues/15237 )
        tmp = envIn_##(1); envIn_##(1) = tmp([2 1]);
    end

    // Execute the demo
    exec(demoFile);

    // Restore the environment
    if envIn_## <> list() then
        for i = 1:length(envFuns_##)
            envFuns_##(i)(envIn_##(i))
        end
    end
endfunction

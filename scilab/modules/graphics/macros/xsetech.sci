//
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2012-2012 - Scilab Enterprises - Bruno JOFRET
// Copyright (C) 2012 - 2016 - Scilab Enterprises
// Copyright (C) 2021 - Samuel GOUGEON
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.
//
//
function xsetech(axes_bounds, data_bounds, logflag, margins)

    fname = "xsetech"

    // CHECK INPUT ARGUMENTS
    // ---------------------
    // 1 <= RHS <= 4
    if argn(2) > 4 | argn(2) < 1 then
        error(msprintf(_("%s: Wrong number of input argument(s): %d to %d expected."), fname, 1, 4));
    end

    // For compatibility with Scilab < 6.1.2 about named arguments
    // We do not warn the user for code upgrade.
    if isdef("wrect","l") then
        axes_bounds = wrect
    end
    if isdef("frect","l") then
        data_bounds = frect
    end
    if isdef("arect","l") then
        margins = arect
    end

    // Check axes_bounds
    if ~isdef("axes_bounds", "local")
        axes_bounds = [];
    elseif type(axes_bounds) <> 1 | ~isreal(axes_bounds) | length(axes_bounds)<>4
        error(msprintf(_("%s: Wrong value given for %s."), fname, "axes_bounds"));
    end

    // Check data_bounds
    if ~exists("data_bounds", "local")
        data_bounds = [];
    elseif type(data_bounds) <> 1 | ~isreal(data_bounds) | length(data_bounds)<>4
            error(msprintf(_("%s: Wrong value given for %s."), fname, "data_bounds"));
    end

    // check logflag
    if ~exists("logflag", "local")
        logflag = [];
    elseif type(logflag) <> 10 | ~or(logflag == ["ll" "nn" "nl" "ln"]) then
        error(msprintf(_("%s: Wrong value given for %s."), fname, "logflag"));
    end

    // Check margins
    if ~exists("margins", "local")
        margins = []
    elseif type(margins) <> 1 | ~isreal(margins) | length(margins)<>4 then
            error(msprintf(_("%s: Wrong value given for %s."), fname, "margins"));
    end

    // Determine the figure or frame substrate according to gce()
    // ----------------------------------------------------------
    e = gce();
    if e.type=="Figure" | (e.type=="uicontrol" & e.style=="frame") then
        curParent = e
    else
        tmp = e.parent
        while tmp.type<>"Figure" & (tmp.type<>"uicontrol" | tmp.style<>"frame")
            tmp = tmp.parent
        end
        curParent = tmp
    end

    // Check if an existing axes matches axes_bounds
    // ---------------------------------------------
    allAxes = curParent.children;
    tmp = axes_bounds <> axes_bounds // %nan
    axes_bounds(tmp) = gda().axes_bounds(tmp)
    found = %F;
    for kAxes = 1:size(allAxes, "*")
        if allAxes(kAxes).type == "Axes" & and(allAxes(kAxes).axes_bounds(:)==axes_bounds(:))
            a = sca(allAxes(kAxes));
            found = %T;
            break
        end
    end

    if ~found then
        a = newaxes(curParent);
        if axes_bounds <> [] then
            a.axes_bounds = axes_bounds
        end
    end

    if data_bounds <> [] then
        tmp = data_bounds <> data_bounds // %nan
        data_bounds(tmp) = gda().data_bounds([1 3 2 4])(tmp)
        a.data_bounds = data_bounds([1 3 2 4])
    end
    if logflag <> [] then
        a.log_flags = logflag;
    end
    if ~isempty(margins) then
        tmp = margins <> margins // %nan
        margins(tmp) = gda().margins(tmp)
        a.margins = margins;
    end
    set("current_entity", a)
endfunction

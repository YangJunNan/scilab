// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - 3DS - Adeline CARNIS
// Copyright (C) 2022 - 3DS - Antoine ELIAS
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function [fmt, typ] = detectFormatDatetime(txt)
    // yyyy-M-D "/([0-9]{1,4})-([0-9]{1,2})-([0-9]{1,2})/"
    // d/M/yyyy d/M/yy M/d/yyyy "/([0-9]{1,2})\/([0-9]{1,2})\/([0-9]{1,4})/"
    // d.M.yyyy "/([0-9]{1,2})\.([0-9]{1,2})\.([0-9]{1,4})/"
    // yyyyMMdd "/([0-9]{4})([0-9]{2})([0-9]{2})/"
    // dd MMM yy dd-MMM-yy "/([0-9]{1,2})([\s-])([a-zA-Z]{3})([\s-])([0-9]{2,4})/"
    // MMM d yyyy MMM d, yyyy "/([a-zA-Z]{3})([\s])([0-9]{1,2})([,\s]+)([0-9]{4})/"
    l = list(...
        "/([0-9]{1,4})-([0-9]{1,2})-([0-9]{1,2})/", ... // yyyy-M-D
        "/([0-9]{1,2})\/([0-9]{1,2})\/([0-9]{1,4})/", ... // d/M/yyyy d/M/yy M/d/yyyy
        "/([0-9]{1,2})\.([0-9]{1,2})\.([0-9]{1,4})/", ... //d.M.yyyy 
        "/([0-9]{4})([0-9]{2})([0-9]{2})/", ...//yyyyMMdd 
        "/([0-9]{1,2})([\s-])([a-zA-Z]{3})([\s-])([0-9]{2,4})/", ...//dd MMM yy dd-MMM-yy 
        "/([a-zA-Z]{3})\s([0-9]{1,2})([,\s]+)([0-9]{4})/"); // MMM d yyyy MMM d, yyyy 

    
    fmt = "";
    typ = "";
    
    while txt(1) == "" 
        txt(1) = [];
    end

    // date
    for i = 1:size(l)
        [a,b,c,d] = regexp(txt(1), l(i));
        if d <> "" & c == part(txt(1), 1:b) then
            typ = "datetime"
            select i
            case 1
                if length(d(1)) == 4 then
                    fmt = "yyyy-M-d";
                else
                    fmt = "yy-M-d";
                end
            case 2
                if length(d(3)) == 4 then
                    fmt = "yyyy"
                else
                    fmt = "yy"
                end
                t = part(txt, 4:5);
                t = strtod(t);
                if or(t> 12) then
                    fmt = "M/d/" + fmt; 
                else
                    fmt = "d/M/" + fmt;
                end
            case 3
                if length(d(3)) == 4 then
                    fmt = "d.M.yyyy";
                else
                    fmt = "d.M.yy";
                end
            case 4
                fmt = "yyyyMMdd";
            case 5
                if length(d(5)) == 4 then
                    fmt = "yyyy"
                else
                    fmt = "yy"
                end
                if d(2) == "-" then
                    fmt = "d-MMM-" + fmt;
                else
                    fmt = "d MMM " + fmt;
                end
            case 6
                if length(d(4)) == 4 then
                    fmt = "yyyy"
                else
                    fmt = "yy"
                end
                if d(3) == "," then
                    fmt = "MMM d, " + fmt;
                else
                    fmt = "MMM d " + fmt;
                end
            end
            break;
        end
    end

    
    // time
    [_,_,_,d] = regexp(txt(1), "/([0-9]{1,2}):([0-9]{2}):?([0-9]{2})? ?([aApP][mM])?/"); //?.?([0-9]{3})
    t = "";
    if or(d <> "") then
        if fmt <> "" then
            if grep(txt(1), "T") then
                fmt = fmt + "T";
            else
                fmt = fmt + " ";
            end
        end
        select size(d(d<>""), "*")
        case 2
            fmt = fmt + "H:mm";
            t = "duration";
        case 3
            if d(3) <> "" then
                fmt = fmt + "H:mm:ss"; 
                t = "duration";
            elseif d(4) <> "" then
                fmt = fmt + "h:mm a";
            end
        case 4 
            fmt = fmt + "h:mm:ss a";
        end
    end

    
    if grep(txt(1), "Z") then
        fmt = fmt + "Z";
    end

    if typ == "" && t == "duration" then
        typ = t;
        fmt = "hh" + part(fmt, 2:length(fmt));
    end

    if fmt == "yyyyMMdd" && length(txt(1)) <> 8 then
        typ = "";
        fmt = "";
    end

    if typ <> "" then
        select typ
        case "datetime"
            try
                d = datetime(txt, "InputFormat", fmt)
            catch
                fmt = "";
                typ = "";
            end
        case "duration"
            try
                d = duration(txt, "InputFormat", fmt)
            catch
                fmt = "";
                typ = "";
            end
        end
    end

    if fmt == "" then
        if and(isnum(txt)) then
            typ = "double";
        // elseif ...  %T %f ? true false ? 0 1 ?
        //     typ = "boolean";
        else
            typ = "string";
        end
    end
endfunction

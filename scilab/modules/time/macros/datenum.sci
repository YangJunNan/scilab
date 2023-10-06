//------------------------------------------------------------------------
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) INRIA - Pierre MARECHAL
//
// Copyright (C) 2012 - 2016 - Scilab Enterprises
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

//
// Convert to serial date number
//------------------------------------------------------------------------

function n=datenum(varargin)
    rhs = argn(2);

    select rhs
    case 0
        Date = getdate();
        n = %datenum(Date(1), Date(2), Date(6), Date(7), Date(8), Date(9))

    case 1
        DateIn = varargin(1);
        l = list();
        for i = 1:size(DateIn, 2)
            l(i) = DateIn(:, i)
        end

        n = %datenum(l(:))

    case 3
        n = %datenum(varargin(:));

    case 6
        y  = varargin(1);
        m = varargin(2);
        d   = varargin(3);
        h  = varargin(4);
        mn   = varargin(5);
        s   = varargin(6);

        n = %datenum(y, m, d, h, mn, s);
    else
        error(msprintf(gettext("%s: Wrong number of input argument.\n"),"datenum"));
    end

endfunction

function n = %datenum(y, m, d, h, mn, s)
    arguments
        y {mustBeA(y, "double")}
        m {mustBeA(m, "double"), mustBeInRange(m, 1, 12)}
        d {mustBeA(d, "double"), mustBeInRange(d, 1, 31)}
        h {mustBeA(h, "double"),  mustBeInRange(h, 0, 23)} = 0
        mn {mustBeA(mn, "double"),  mustBeInRange(mn, 0, 59)} = 0
        s {mustBeA(s, "double"), mustBeInRange(s, 0, 60)} = 0
    end

    vecSize = [size(y); size(m); size(d); size(h); size(mn); size(s)]
    sizeMax = max(vecSize, "r");
    if ~(and((sizeMax(1) == vecSize(:, 1) & sizeMax(2) == vecSize(:, 2)) | (vecSize(:,1) == 1 & vecSize(:,2) == 1))) then
        error(msprintf(gettext("%s: Wrong size for input arguments: Same size expected.\n"),"datenum"));
    end

    decimal_part = (((s / 60 + mn) / 60) + h) / 24;

    // convert of month and day
    integer_part = d + floor((m * 3057 - 3007) / 100);

    // On retranche 1 si le mois est au dela de février
    integer_part = integer_part + ((m < 3) - 1);

    isLY = isLeapYear(y);

    // On retranche encore 1 si le mois est au dela de février et année non bissextile
    integer_part = integer_part + (((m < 3)|(isLY)) -1);

    // Convertion des année
    leap_year_case     = y * 365 + (y / 4) - floor(y / 100) + floor(y / 400);
    not_leap_year_case = y * 365 + floor(y/4) + 1 - floor(y / 100) + floor(y / 400);

    leap_year_case(~isLY)    = 0;
    not_leap_year_case(isLY) = 0;

    integer_part       = integer_part + leap_year_case + not_leap_year_case;

    n = integer_part + decimal_part;
endfunction



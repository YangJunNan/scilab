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

function out = %datetime_a_calendarDuration(dt, cd1)
    if size(dt, "*") <> 1 && size(cd1, "*") <> 1 && or(size(dt) <> size(cd1)) then
        error(msprintf(_("%s: Wrong size for input arguments #%d and #%d: Same size expected.\n"), "%datetime_a_calendarDuration", 1, 2))
    end

    // "1950-11-25" + 80d
    day1 = 24*60*60*1000;

    ref_size = [1 1];
    if size(dt, "*") <> [0 1] then
        ref_size = size(dt);
    else
        ref_size = size(cd1);
    end

    //adjust dimensions
    scale = ones(ref_size(1), ref_size(2));
    cd1.y = cd1.y .* scale;
    cd1.m = cd1.m .* scale;
    cd1.d = cd1.d .* scale;
    cd1.t.duration = cd1.t.duration .* scale;

    dt.date = dt.date .* scale;
    dt.time = dt.time .* scale;

    out_t =  dt.time*1000 + cd1.t.duration;
    hours_days = floor(out_t / day1);
    out_t = modulo(out_t, day1);
    dv = datevec(dt.date);
    d1 = matrix(dv(:, 1), ref_size);
    d2 = matrix(dv(:, 2), ref_size);
    out_d = matrix(dv(:,3), ref_size);
    
    out_y = d1 + cd1.y;
    out_m = d2 - 1 + cd1.m;

    out_y = out_y + floor(out_m / 12);
    out_m = modulo(out_m, 12);

    dd = cd1.d + hours_days;

    out_d(isnan(out_d)) = -1
    out_d(dt.date == -1) = -1;

    y = ceil(dd / 365.2425);
    idx = find(y > 1);
    for i = 1:length(idx)
        index = idx(i);
        yy = out_y(index) - 1 + (1:y(index))
        Days = 365 + isLeapYear(yy);
        Days = cumsum(Days);
        if Days(1) == 366 then
            jdx = find((Days - dd(index)) > 0) - 1;
        else
            jdx = find((Days - dd(index)) >= 0) - 1;
        end
        out_y(index) = out_y(index) + jdx(1);
        dd(index) = dd(index) - Days(jdx(1));
    end

    m = ceil(dd / 29);
    mdx = find(m > 1);
    for i = 1:length(mdx)
        index = mdx(i);
        tmp = [out_m(index) - 1 + (1:m(index))]';
        months = [out_y(index) * ones(tmp) tmp];
        idx = find(tmp > 11);
        if idx <> [] then
            months(idx, 2) = months(idx, 2) - 12;
            months(idx, 1) = months(idx, 1) + 1;
        end
        months = eomday(months(:, 1), months(:,2)+1);
        months = cumsum(months);
        idx = find((months - dd(index)) > 0) - 1;

        out_m(index) = out_m(index) + idx(idx<>0)(1)
        if out_m(index) > 11 then
            out_m(index) = out_m(index) - 12;
            out_y(index) = out_y(index) + 1;
        end
        dd(index) = dd(index) - months(idx(idx<>0)(1));
    end

    day_current_m = eomday(out_y, out_m + 1);
    out_d = min(out_d, day_current_m);

    while or(dd + out_d > day_current_m)
        index = find((dd + out_d) > day_current_m)
        out_m(index) = out_m(index) + 1;
        idx = out_m == 12;
        if or(idx) then
            out_m(idx) = 0;
            out_y(idx) = out_y(idx) + 1;
        end

        dd(index) = dd(index) - day_current_m(index);
        day_current_m(index) = eomday(out_y(index), out_m(index) + 1);
    end

    out_d = out_d + dd;



    // for i = 1:size(dt, "*")
    //     if isnan(out_d(i)) then
    //         out_d(i) = -1;
    //         continue;
    //     end

    //     if dt.date(i) == -1 then
    //         out_d(i) = -1;
    //         continue;
    //     end

    //     d = dd(i)
    //     y = ceil(d / 365.2425);
    //     if y > 1 then
    //         y = out_y(i) - 1 + (1:y);
    //         days = 365 + datetime_utils_leap_year(y);
    //         days = cumsum(days);
    //         if days(1) == 366 then
    //             idx = find((days-d) > 0) - 1;
    //         else
    //             idx = find((days-d) >= 0) - 1;
    //         end
    //         out_y(i) = out_y(i) + idx(1);
    //         d = d - days(idx(1));
    //     end

    //     m = ceil(d / 29);
    //     if m > 1 then
    //         tmp = [out_m(i) - 1 + (1:m)]';
    //         months = [out_y(i) * ones(tmp) tmp];
    //         idx = find(tmp > 11);
    //         if idx <> [] then
    //             months(idx, 2) = months(idx, 2) - 12;
    //             months(idx, 1) = months(idx, 1) + 1;
    //         end
    //         months = datetime_utils_eom(months(:, 1), months(:,2)+1);
    //         months = cumsum(months);
    //         idx = find((months - d) > 0) - 1;

    //         out_m(i) = out_m(i) + idx(idx<>0)(1)//idx(1);
    //         if out_m(i) > 11 then
    //             out_m(i) = out_m(i) - 12;
    //             out_y(i) = out_y(i) + 1;
    //         end
    //         d = d - months(idx(idx<>0)(1));//months(idx(1));
    //     end

        
    //     day_current_m = datetime_utils_eom(out_y(i), out_m(i) + 1);
    //     out_d(i) = min(out_d(i), day_current_m);

    //     while d + out_d(i) > day_current_m
    //         out_m(i) = out_m(i) + 1;
    //         if out_m(i) == 12 then
    //             out_m(i) = 0;
    //             out_y(i) = out_y(i) + 1;
    //         end

    //         d = d - day_current_m;
    //         day_current_m = datetime_utils_eom(out_y(i), out_m(i) + 1);
    //     end

    //     out_d(i) = out_d(i) + d;////potentially negative to ajust date
    // end

    // //propagate NaT
    // manage edges of out_d
    index0 = find(out_d == 0);
    out_d(index0) = 1;
    d = datenum(out_y, out_m+1, out_d);
    if index0 <> [] then
        d(index0) = d(index0) - 1;
    end
    idx = find(out_y == -1);    
    d(idx) = -1;
    out = mlist(["datetime", "date", "time", "format"], d, out_t / 1000, dt.format);
endfunction

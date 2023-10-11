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

function out = %datetime_s_calendarDuration(dt, cd1)
    if size(dt, "*") <> 1 && size(cd1, "*") <> 1 && or(size(dt) <> size(cd1)) then
        error(msprintf(_("%s: Wrong size for input arguments #%d and #%d: Same size expected.\n"), "%datetime_s_calendarDuration", 1, 2))
    end

    // "1950-11-25" - 80d
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

    out_y = cd1.y;
    out_m = cd1.m;
    out_d = cd1.d;

    out_t =  dt.time*1000 - cd1.t.duration;
    hours_days = fix(out_t / day1);
    out_t = modulo(out_t, day1);
    dv = datevec(dt.date);

    test = isnan(out_d);
    out_d(test) = -1;

    out_y(dt.date == -1) = -1;
    out_y = matrix(dv(:,1), ref_size) - cd1.y;
    out_m = matrix(dv(:,2), ref_size) - 1 - cd1.m;

    year = floor(out_m / 12);
    out_y = out_y + year;
    out_m = out_m + year * -12;

    previous_m = out_m - 1;
    previous_m(previous_m < 0) = 11;

    day_current_m = eomday(out_y, previous_m + 1);

    out_d = matrix(dv(:,3), ref_size);
    dd = cd1.d + hours_days;
    
    while or((out_d - dd) < 1)
        index = find((out_d - dd) < 1);
        out_m(index) = out_m(index) - 1;
        idx = out_m < 0;
        if or(idx) then
            out_y(idx) = out_y(idx) - 1;
            out_m(idx) = 11;
        end

        dd(index) = dd(index) - day_current_m(index);
        day_current_m(index) = eomday(out_y(index), out_m(index) + 1);
    end

    out_d = out_d - dd;
    // for i = 1:size(dt, "*")
    //     // if isnan(out_d(i)) then
    //     //     out_d(i) = -1;
    //     //     continue;
    //     // end

    //     // if dt.date(i) == -1 then
    //     //     out_y(i) = -1;
    //     //     continue;
    //     // end

    //     // d1 = dv(i,:); //datevec(dt.date(i));
    //     // out_y(i) = d1(1) - cd1.y(i);
    //     // out_m(i) = d1(2)-1 - cd1.m(i);

    //     // year = floor(out_m(i) / 12);
    //     // out_y(i) = out_y(i) + year;
    //     // out_m(i) = out_m(i) + year * -12;

    //     // previous_m = out_m(i) - 1;
    //     // if previous_m < 0 then
    //     //     previous_m = 11;
    //     // end

    //     // day_current_m = eomday(out_y(i), previous_m + 1);

    //     // out_d(i) = d1(3);
    //     // d = cd1.d(i) + hours_days(i);

    //     day_current_m = dcm(i);
    //     d = dd(i);
    //     while out_d(i) - d < 1
    //         out_m(i) = out_m(i) - 1;
    //         if out_m(i) < 0 then
    //             out_m(i) = 11;
    //             out_y(i) = out_y(i) - 1;
    //         end

    //         d = d - day_current_m;
    //         day_current_m = eomday(out_y(i), out_m(i) + 1);
    //     end

    //     out_d(i) = out_d(i) - d;//potentially negative to ajust date
    // end

    //propagate NaT
    idx = find(out_y == -1);
    d = datenum(out_y, out_m+1, out_d);
    d(idx) = -1;
    out = mlist(["datetime", "date", "time", "format"], d, out_t / 1000, dt.format);
endfunction

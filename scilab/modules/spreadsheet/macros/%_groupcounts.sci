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

function [val, count, vindex, uniqueVal] = %_groupcounts(t, groupvars, groupbins, includeEmpty)
    sizeGroupbins = size(groupbins, "*")
    sizeGroupvars = size(groupvars, "*");
    val = list();
    count = 0;
    vindex = 0;
    uniqueVal = list();

    if sizeGroupvars == 1 then
        if type(groupbins) == 1 then
            // for example: groupbins = [0 3 6 9]
            minbounds = groupbins(1:$-1);
            maxbounds = groupbins(2:$);
            
            val = [minbounds' maxbounds'];

            d = t.vars(groupvars).data
            count = zeros(size(val, 1), 1);
            vindex = zeros(size(d, 1), 1);

            for i = 1:size(val, 1)
                index = %t;
                if val(i,2) == max(val)
                    f = d >= val(i,1) & d <= val(i,2);
                else
                    f = d >= val(i,1) & d < val(i,2);
                end
                index = index & f;
                count(i) = sum(index);
                vindex = vindex + index * i;
            end

            // transform val to print
            str = "[" + string(val(:,1))+ ", "+ string(val(:,2)) + ")";
            str($) = strsubst(str($), ")", "]");   
            val = str;

            if ~includeEmpty then
                idx = count == 0;
                val(idx) = [];
                count(idx) = [];
            end

            val = list(val);
        else
            if typeof(groupbins) == "ce" then
                groupbins = groupbins{1};
            end

            [val, tmp1, vindex, count] = unique(t.vars(groupvars).data);

            d = t.vars(groupvars).data;
            if groupbins <> "none" then
                // for example: groupbins = ["second", "minute", "hour", "day", "month", "year", "dayname", "monthname"])
                d = groupBinsCheck(groupbins, d);
            end

            [val, ki] = gsort(d, "g", "i");
            tmp = val(2:$) == val(1:$-1);
            vindex(ki) = cumsum(~[%f; tmp]);
            count = [0; find(~tmp)'; size(val, "*")];
            count = count(2:$) - count(1:$-1);
            tmp = find(tmp);
            if tmp <> [] then tmp = tmp + 1; end
            val(tmp) = [];
            ki(tmp) = [];
            if and(groupbins <> ["none", "dayname"]) then
                [ki, kk] = gsort(ki, "g", "i");
                val = val(kk);
                count = count(kk);
            end
            // if groupbins == "none" then
            //     val(tmp) = [];
            //     ki(tmp) = [];
            // else
            //     tmp = find(tmp);
            //     if tmp <> [] then tmp = tmp + 1; end
            //     val(tmp) = [];
            //     ki(tmp) = [];
            //     if groupbins <> "dayname" then
            //         [ki, kk] = gsort(ki, "g", "i");
            //         val = val(kk);
            //         count = count(kk);
            //     end
            // end
            val = list(val);
            uniqueVal = val;
        end
    else

        // groupvars can be scalar or vector
        // groupbins will be applied on all groupvars
        if type(groupbins) == 1 then
            // for example: groupbins = [0 3 6 9]
            minbounds = groupbins(1:$-1);
            maxbounds = groupbins(2:$);
            mat = [minbounds' maxbounds'];

            s = size(mat, 1) * ones(sizeGroupvars, 1);
            p = prod(s);

            for i = 1:sizeGroupvars
                select i
                case 1
                    val(i) = gsort(repmat(mat, prod(s(i+1:$)), 1), "lr", "i");
                case sizeGroupvars
                    val(i) = repmat(mat, prod(s(1:sizeGroupvars-1)), 1);
                else
                    val(i) = repmat(gsort(repmat(mat, prod(s(i+1:$)), 1), "lr", "i"), prod(s(1:i-1)), 1);
                end
            end

            count = zeros(size(mat, 1) * sizeGroupvars, 1);
            vindex = zeros(size(t, 1), 1)

            for i = 1:p
                index = %t;
                for j = 1:sizeGroupvars
                    d = t.vars(groupvars(j)).data;
                    if val(j)(i,2) == max(val(j))
                        f = d >= val(j)(i,1) & d <= val(j)(i,2);
                    else
                        f = d >= val(j)(i,1) & d < val(j)(i,2);
                    end
                    index = index & f;
                end
                count(i) = sum(index);
                vindex = vindex + index * i;
            end

            // transform val to print
            l = list();
            for i = 1:sizeGroupvars
                v = val(i);
                a = [];
                for j = 1:p
                    if val(i)(j,2) == max(val(i))
                        str = "]";
                    else
                        str = ")";
                    end
                    a = [a; "[" + string(v(j, 1)) + ", "+ string(v(j, 2)) + str];
                end
                l(i) = a
                uniqueVal(i) = a(count <> 0)
            end
            val = l;    

            if ~includeEmpty then
                idx = count == 0;
                for i = 1:sizeGroupvars
                    val(i)(idx) = [];
                end
                count(idx) = [];
            end

        else
            if sizeGroupbins == 1 then
                V = zeros(size(t, 1), sizeGroupvars);
                kmd = list();
                if groupbins == "none" || groupbins == {"none"} then
                    for i = 1:sizeGroupvars
                        d = t.vars(groupvars(i)).data
                        [uniqueVal(i), kmd(i), V(:,i), nb] = unique(d)
                    end
                else
                    // for example: groupbins = ["second", "minute", "hour", "day", "month", "year", "dayname", "monthname"])
                    for i = 1:sizeGroupvars
                        d = t.vars(groupvars(i)).data;
                        d = groupBinsCheck(groupbins, d)
                        [uniqueVal(i), kmd(i), V(:,i), nb] = unique(d)
                    end
                end  
                    
                [rV, km, vindex, nbV] = unique(V, "r");

                if includeEmpty then
                    [val, b] = %_allCombinations(uniqueVal, V, kmd)
                    count = zeros(size(b, 1), 1);
                    [res, kmres, index, nbres] = unique([b; rV], "r");
                    count(nbres == 2) = nbV;
                else
                    count = nbV
                    val = list();
                    for i = 1:sizeGroupvars
                        val(i) = uniqueVal(i)(rV(:,i))
                    end
                end

            else
                // matrix of groupbins (same type) or cell
                // groupbins has the same size as groupvars
                // one groupbins for one groupvars
                V = zeros(size(t, 1), sizeGroupbins);
                kmd = list();
                if type(groupbins) == 10 then
                    // possible cases: ["none", "month"], ["month", "year"], ["year", "none"]
                    for k = 1:sizeGroupbins
                        bins = groupbins(k)
                        d = t.vars(groupvars(k)).data;

                        if bins == "none" then
                            [uniqueVal(k), kmd(k), V(:,k), nb] = unique(d)
                        else
                            d = groupBinsCheck(bins, d)
                            [uniqueVal(k), kmd(k), V(:,k), nb] = unique(d)
                        end
                    end

                elseif type(groupbins) == 17 then
                    // possible cases: ["none", "month"], ["month", "year"], ["year", "none"]
                    for k = 1:sizeGroupbins
                        bins = groupbins{k}
                        d = t.vars(groupvars(k)).data;
                        if type(bins) == 1 then
                            minbounds = bins(1:$-1);
                            maxbounds = bins(2:$);
                            km = [];
                            
                            bins = [minbounds' maxbounds'];
                            str = "[" + string(bins(:,1))+ ", "+ string(bins(:,2)) + ")";
                            str($) = strsubst(str($), ")", "]");
                            mat = "<undefined>" + emptystr(d);

                            for i = 1:size(bins, 1)
                                if i == size(bins, 1) then
                                    test = d>=bins(i,1) & d <= bins(i,2);
                                else
                                    test = d>=bins(i,1) & d < bins(i,2);
                                end
                                mat(test) = str(i)
                                V(:,k) = V(:,k) + test*i;
                                km(i) = find(test, 1)
                            end

                            idx = find(mat == "<undefined>")
                            if idx <> [] then
                                str = [str; "<undefined>"];
                                V(idx,k) = size(str, "*");
                                km($+1) = idx(1);
                            end

                            uniqueVal(k) = str;
                            kmd(k) = km;
                        else
                            if bins == "none" then
                                [uniqueVal(k), kmd(k), V(:,k), nb] = unique(d)
                            else
                                d = groupBinsCheck(bins, d)
                                [uniqueVal(k), kmd(k), V(:,k), nb] = unique(d)
                            end
                        end
                    end
                end

                [rV, km, vindex, nbV] = unique(V, "r");

                if includeEmpty then
                    [val, b] = %_allCombinations(uniqueVal, V, kmd)
                    count = zeros(size(b, 1), 1);
                    [res, km, index, nbres] = unique([b; rV], "r", "keepOrder");
                    count(nbres == 2) = nbV;
                    
                else
                    val = list();
                    for k = 1:sizeGroupbins
                        val(k) = uniqueVal(k)(rV(:,k))
                    end
                    count = nbV
                end
            end
        end
    end
endfunction

function d = groupBinsCheck(bins, d)
    select bins
    case "year"
        if isdatetime(d) then
            d = d.Year;
        else
            d = years(floor(years(d)));
        end
    case "month"
        if isduration(d) then
            error(msprintf(_("groupbins must be used with datetime data.\n")));
        end
        d.date = d.date - d.Day + 1;
        d.time = zeros(d.time);
        // d.Day = 1;
        // d.Hour = 0;
        // d.Minute = 0;
        // d.Second = 0;
        d.format = "MMM-yyyy";
    case "monthname"
        if isduration(d) then
            error(msprintf(_("groupbins must be used with datetime data.\n")));
        end
        y = d.Year(1);
        d.date = d.date - d.Year + y;
        d.date = d.date - d.Day + 1;
        d.time = zeros(d.time);
        // d.Year = d.Year(1);
        // d.Day = 1;
        // d.Hour = 0;
        // d.Minute = 0;
        // d.Second = 0;
        d.format = "MMMM";
    case "day"
        if isdatetime(d) then
            d.time = zeros(d.time);
            // d.Hour = 0;
            // d.Minute = 0;
            // d.Second = 0;
            d.format = "dd-MMM-yyyy"
        else
            d = days(floor(days(d)));
        end
    case "dayname"
        if isduration(d) then
            error(msprintf(_("groupbins must be used with datetime data.\n")));
        end
        d.format = "eeee";
        d = string(d);
    case "hour"
        if isdatetime(d) then
            d.time = d.time - d.Minute*60 - d.Second;
            // d.Minute = 0;
            // d.Second = 0;
            d.format = "dd-MMM-yyyy HH:mm:ss";
        else
            d = hours(floor(hours(d)));
        end
    case "minute"
        if isdatetime(d) then
            d.time = d.time - d.Second;
            // d.Second = 0;
            d.format = "dd-MMM-yyyy HH:mm:ss";
        else
            d = minutes(floor(minutes(d)));
        end
    case "second"
        if isdatetime(d) then
            d.format = "dd-MMM-yyyy HH:mm:ss";
        else
            d = seconds(floor(seconds(d)));
        end
    end
endfunction

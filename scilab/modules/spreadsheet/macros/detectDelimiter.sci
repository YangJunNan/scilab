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

function delim = detectDelimiter(str, delimiters)
    if nargin == 1 then
        delimiters = [";", ",", "|", ":", "\s", "\t"];    
    end
    r = size(str, "r");
    if r > 20 then
        r = 20
    end
    tab = zeros(r, 6);
    delim = [];
    newdelimiters = [];
    count = zeros(delimiters);

    //tmp = strsubst(str(c), "/"".*?""/g", "", "r");
    //split = strsplit(strsubst(tmp, "/[""a-zA-Z0-9\.]+/g", "", "r"))
    //newdelimiters = unique([newdelimiters; split], "keepOrder")

    tmp = strsubst(str(1:r), "/"".*?""/g", "", "r");
    tmp = strsubst(tmp, "/[""a-zA-Z0-9\.\-\+]+/g", "", "r");
    split = list()
    for i = 1:r
        split(i) = strsplit(tmp(i));
        newdelimiters = unique([newdelimiters; split(i)], "keepOrder")
    end

    for d = delimiters
        for c = 1:r
            if d == "\t"
                splittab = strsplit(str(c), d)
                if size(splittab, "*") > 1 then 
                    delim = d;
                    break
                end
            else
                // tmp = strsubst(str(c), "/"".*?""/g", "", "r");
                // split = strsplit(strsubst(tmp, "/[""a-zA-Z0-9\.]+/g", "", "r"))
                // newdelimiters = unique([newdelimiters; split], "keepOrder")
                // if find(split == d) <> [] then
                //     if find(delim <> d) then
                //         delim = [delim, d];
                //     end
                //     count(delimiters == d) = count(delimiters == d) + length(find(split == d));
                //     tab(c, delimiters == d) = length(find(split == d))
                // end
                idx = find(split(c) == d)
                if idx <> [] then
                    if find(delim <> d) then
                        delim = [delim, d];
                    end
                    count(delimiters == d) = count(delimiters == d) + length(idx);
                    tab(c, delimiters == d) = length(idx)
                end
            end
        end
    end

    if delim == [] then
        delim = detectDelimiter(str, newdelimiters');
    else
        nb = sum(bool2s(tab>0), "r");
        if modulo(max(nb), r) == 0 then
            delim = delimiters(nb == max(nb))(1);
        else
            [m, k] = max(count);
            delim = delimiters(k)
        end
    end
endfunction

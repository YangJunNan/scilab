// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2023 - 3DS - Antoine ELIAS
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// pursuant to article 5.3.4 of the CeCILL v.2.1.
// This file was originally licensed under the terms of the CeCILL v2.1,
// and continues to be available under such terms.
// For more information, see the COPYING file which you should have received
// along with this program.

function %ce_p(ce)
    if size(ce, "*") == 0 then
        str = "{}";
    else
        str = emptystr(ce);
        for i = 1:size(ce, "*")
            val = ce{i};
            t = type(val)
            select t
            case 13 //macro
                str(i) = "function";
            case 14 //lib
                str(i) = "lib";
            case 15 //list
                str(i) = sprintf("list of %d items");
            case 16 //tlist
                str(i) = typeof(val);
            case 17 //mlist
                select typeof(val)
                case "st"
                    str(i) = sprintf("[%dx%d struct]", size(val, 1), size(val, 2));
                case "ce"
                    str(i) = sprintf("{%dx%d cell}", size(val, 1), size(val, 2));
                else
                    str(i) = typeof(val);
                end
            case 128 //pointer
                str(i) = typeof(val);
            case 130 //builtin
                str(i) = "function";
            else
                [n1, m1] = size(val);
                if n1 == 0 && m1 == 0 then
                    str(i) = "[]";
                elseif n1 == 1 then
                    x = sci2exp(val);
                    if size(x, "*") <> 1 || length(x) > 15 then
                        str(i) = sprintf("[%dx%d %s]", size(val, 1), size(val, 2), typeof(val));
                    else
                        str(i) = x;
                    end
                else
                    str(i) = sprintf("[%dx%d %s]", size(val, 1), size(val, 2), typeof(val));
                end
            end
        end
    end

    s = max(length(str), "r");

    for j = 1:size(str, 2)
        f = sprintf("%%%ds\n", -s(j));
        for i = 1:size(str, 1)
            str(i, j) = sprintf(f, str(i, j))
        end
    end

    //disp(str);
    //disp following lines limit
    maxL = lines()(1);

    //[12 14 15 18 21 8 43]
    listcol = list(1);
    nb = 2

    for i = 1:size(s, "*")
        if s(i) + nb > maxL then
            listcol($+1) = i-1;
            nb = 2 + s(i) + 4;
        else
            nb = nb + s(i) + 4;
        end
    end

    listcol($+1) = size(s, "*") + 1;
    //disp(listcol, s, maxL);

    if length(listcol) > 2 then
        for i = 2:length(listcol)
            if listcol(i-1) == listcol(i)-1 then
                printf("\n         column %d\n\n", listcol(i)-1);
            else
                printf("         column %d to %d\n\n", listcol(i-1), listcol(i)-1);
            end

            tmp = "  " + strcat(str(:, listcol(i-1):listcol(i)-1), "    ", "c");
            printf("%s\n", tmp);
            printf("\n");
        end
    else
        tmp = "  " + strcat(str, "    ", "c");
        printf("%s\n", tmp);
    end

endfunction

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

    str = %ce_string(ce);
    s = max(length(str), "r");

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

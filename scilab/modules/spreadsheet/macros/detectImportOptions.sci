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

function opts = detectImportOptions(filename)
    opts = struct();

    fname = "detectImportOptions";
    if nargin > 1 then
        error(msprintf(_("%s: Wrong number of input arguments: %d to %d expected.\n"), fname, 1));
    end

    if type(filename) <> 10 then
        error(msprintf(_("%s: Wrong size for input argument #%d: A string expected.\n"), fname, 1));
    end

    if isscalar(filename) then
        if ~isfile(filename) then
            error(msprintf(_("%s: Wrong size for input argument #%d: A filename expected.\n"), fname, 1));
        end
        // get extension from the filename
        extension = fileext(filename);
        // .txt, .dat or .csv for delimited text files
        if or(extension == [".txt", ".dat", ".csv"]) then
            f = mgetl(filename);
        else
            return
        end
    else
        f = filename;
    end

    while f($) == ""
        f($) = [];
    end

    // detect header
    [header, c , l] = detectHeader(f);

    // detect delimiter
    datalines = [1 size(f, "r")];
    if l <> [] then
        f(l) = [];
        datalines(1) = l($) + 1;
    end
    headlines = [1 size(f, "r")];

    delim = detectDelimiter(f);

    // detect variable names and type
    test = csvTextScan(f(1), delim);
    variableNames = ["Time", "Var" + string(1:size(test, "*")-1)];
    index = [];
    if and(isnan(test)) then
        variableNames = csvTextScan(f(1), delim, [], "string");
        //variableNames = strsubst(variableNames, "/", "_")
        index = find(variableNames == "");
        datalines(1) = datalines(1) + 1;
        headlines(1) = headlines(1) + 1;
    end

    f(1) = [];
    variableTypes = emptystr(variableNames);
    inputFormat = [];

    // csvTextScan on all the file
    // h = csvTextScan(f(headlines(1):headlines(2)), delim, [], "string");
    h = csvTextScan(f, delim, [], "string");

    for i = 1:size(variableNames, '*')
        // types managed : datetime, double, string
        if h(1, i) == "" then
            variableTypes(i) = "string";
            inputFormat(1,i) = "";
            mat = h(:, i);
            idx = mat <> "";
            if or(idx) then
                [infmt, _typ] = detectFormatDatetime(mat(idx)(1))
                variableTypes(i) = _typ;
                inputFormat(1,i) = infmt;
            end
        else
            [infmt, _typ] = detectFormatDatetime(h(1, i))
            variableTypes(i) = _typ;
            inputFormat(1,i) = infmt
        end
    end

    // idx = grep(variableTypes, ["datetime"]);
    // //pause
    // if idx <> [] then
    //     tic()
    //     data = head(headlines(1)+1:headlines(2))
    //     mat = csvTextScan(head(headlines(1)+1), delim, [], "string");
    //     disp("after csvTextScan: " + string(toc()))
    //     tic()
    //     for k = idx
    //         [infmt, _typ] = detectFormatDatetime(mat(:,k));
    //         inputFormat(1,k) = infmt
    //         variableTypes(1,k) = _typ;
    //     end
    //     disp("VariableTypes: " + string(toc()))
    // end

    variableNames(index) = [];
    variableTypes(index) = [];
    inputFormat(index) = [];

    opts.variableNames = variableNames;
    opts.variableTypes = variableTypes;
    opts.delimiter = delim;
    opts.datalines = datalines;
    opts.header = header;
    opts.inputFormat = inputFormat;
    opts.emptyCol = index;
    
endfunction

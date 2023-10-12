// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2023 - 3DS - Adeline CARNIS adeline.carnis@3ds.com
// Copyright (C) 2023 - 3DS - Antoine ELIAS antoine.elias@3ds.com
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// unit tests for groupsummary function
// =============================================================================

rand("seed", 0)
x1 = floor(rand(5,1)*5)-1.5;
x2 = -floor(rand(5,1)*5)+0.5;
A = table(["a"; "b"; "b"; "c"; "a"], x1, x2, "VariableNames", ["x", "x1", "x2"]);

G = groupsummary(A, "x");
expected = ["a" "2"; "b" "2"; "c" "1"];
assert_checkequal(G.Properties.VariableNames, ["x", "GroupCount"]);
assert_checkequal(string(G), expected);


expected = ["a" "2" "1" "-2"; "b" "2" "0" "-6"; "c" "1" "-0.5" "-3.5"];
varnames = ["x", "GroupCount", "fun_x1", "fun_x2"];
G = groupsummary(A, "x", sum);
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

varnames = ["x", "GroupCount", "sum_x1", "sum_x2"];
G = groupsummary(A, "x", "sum");
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);


varnames = ["x", "GroupCount", "fun1_x1", "fun1_x2", "fun2_x1", "fun2_x2"];
expected = ["a" "2" "1" "-2" "1.5" "0.5"; ...
            "b" "2" "0" "-6" "1.5" "-2.5"; ...
            "c" "1" "-0.5" "-3.5" "-0.5" "-3.5"];

G = groupsummary(A, "x", {sum, max});
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", {"sum", "max"});
varnames = ["x", "GroupCount", "sum_x1", "sum_x2", "max_x1", "max_x2"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", {sum, "max"});
varnames = ["x", "GroupCount", "fun1_x1", "fun1_x2", "max_x1", "max_x2"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", {"sum", max});
varnames = ["x", "GroupCount", "sum_x1", "sum_x2", "fun2_x1", "fun2_x2"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);


expected = ["a" "2" "1"; "b" "2" "0"; "c" "1" "-0.5"];
varnames = ["x", "GroupCount", "fun_x1"];

G = groupsummary(A, "x", sum, "x1");
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", "sum", "x1");
varnames = ["x", "GroupCount", "sum_x1"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);


varnames = ["x", "GroupCount", "fun1_x1", "fun2_x1"];
expected = ["a" "2" "1" "1.5"; ...
            "b" "2" "0" "1.5"; ...
            "c" "1" "-0.5" "-0.5"];

G = groupsummary(A, "x", {sum, max}, "x1");
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", {"sum", "max"}, "x1");
varnames = ["x", "GroupCount", "sum_x1", "max_x1"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", {sum, "max"}, "x1");
varnames = ["x", "GroupCount", "fun1_x1", "max_x1"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x", {"sum", max}, "x1");
varnames = ["x", "GroupCount", "sum_x1", "fun2_x1"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);


G = groupsummary(A, "x1", [-3 -1 1 3]);
varnames = ["disc_x1", "GroupCount"];
expected = ["[-3, -1)" "1"; "[-1, 1)" "2"; "[1, 3]" "2"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x1", [-3 -1 1 3], sum, "x2");
varnames = ["disc_x1", "GroupCount", "fun_x2"];
expected = ["[-3, -1)" "1" "-2.5"; "[-1, 1)" "2" "-6"; "[1, 3]" "2" "-3"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, ["x1", "x2"], [-5 0 5]);
varnames = ["disc_x1", "disc_x2", "GroupCount"];
expected = ["[-5, 0)" "[-5, 0)" "3"; "[0, 5]" "[-5, 0)" "1"; "[0, 5]" "[0, 5]" "1"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

// With IncludedEdge - right
G = groupsummary(A, "x1", [-1.5 -0.5 0.5 1.5], "IncludedEdge", "right");
varnames = ["disc_x1", "GroupCount"];
expected = ["[-1.5, -0.5]" "3"; "(0.5, 1.5]" "2"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, "x1", [-1.5 -0.5 0.5 1.5], sum, "x2", "IncludedEdge", "right");
varnames = ["disc_x1", "GroupCount", "fun_x2"];
expected = ["[-1.5, -0.5]" "3" "-8.5"; "(0.5, 1.5]" "2" "-3"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);

G = groupsummary(A, ["x1", "x2"], {[-1.5 -0.5 0.5 1.5], [-4 -1.5 0 1.5]}, "IncludedEdge", "right");
varnames = ["disc_x1", "disc_x2", "GroupCount"];
expected = ["[-1.5, -0.5]" "[-4, -1.5]" "3"; "(0.5, 1.5]" "[-4, -1.5]" "1"; "(0.5, 1.5]" "(0, 1.5]" "1"];
assert_checkequal(G.Properties.VariableNames, varnames);
assert_checkequal(string(G), expected);


timestamp = hours([1 3 2 2 3])';
A = timeseries(timestamp, x1, x2, "VariableNames", ["hours", "x1", "x2"]);

G = groupsummary(A, "hours", sum);
expected = [string(hours(1:3))' string([1;2;2]), string([-0.5;-2; 3]), string([-2.5; -6; -3])];
assert_checkequal(G.Properties.VariableNames, ["hours", "GroupCount", "fun_x1", "fun_x2"]);
assert_checkequal(string(G), expected);


// -----------------------------------------------------------------------------
// Data from www.historique-meteo.net
T = readtable(fullfile(SCI, "modules", "spreadsheet", "tests", "unit_tests","meteo_data_bordeaux.csv"));

G = groupsummary(T, "OPINION", {max, mean}, ["MAX_TEMPERATURE_C", "MIN_TEMPERATURE_C", "SUNHOUR"]);

expected = ["météo correcte" "7" "25" "19" "13.5" "23" "17.714286" "12.371429"; ...
            "météo défavorable" "3" "26" "18" "11.5" "23" "17.333333" "10.233333"; ...
            "météo favorable" "10" "31" "19" "14.5" "25.6" "17.5" "13.3"; ...
            "météo idéale" "10" "31" "19" "14.5" "26.7" "17.8" "14.2"];
assert_checkequal(G.Properties.VariableNames, ["OPINION" "GroupCount", "fun1_MAX_TEMPERATURE_C", "fun1_MIN_TEMPERATURE_C", "fun1_SUNHOUR", "fun2_MAX_TEMPERATURE_C", "fun2_MIN_TEMPERATURE_C", "fun2_SUNHOUR"]);
assert_checkequal(string(G), expected);

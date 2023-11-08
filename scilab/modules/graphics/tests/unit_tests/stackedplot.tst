// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - 3DS - Adeline CARNIS adeline.carnis@3ds.com
// Copyright (C) 2022 - 3DS - Antoine ELIAS antoine.elias@3ds.com
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

n = 100;
t = datetime(2022, 1, 1) + caldays(1:n);
v = floor(10 * rand(n, 4)) + 50;
w = floor(10 * rand(n, 4)) + 50;

ts1 = timeseries(t, v(:, 1), v(:, 2), v(:, 3), v(:, 4), "VariableNames", ["Time", "res1", "res2", "res3", "res4"]);
ts2 = timeseries(t, w(:, 1), w(:, 2), w(:, 3), w(:, 4), "VariableNames", ["Time", "res1", "res2", "res3", "res4"]);

stackedplot(ts1);
f = gcf();
a = f.children;
c = a.children.children;
assert_checkequal(size(a, "*"), 4);
assert_checkequal(a.y_label.text, ["res4"; "res3"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(4, 1));
assert_checkequal(c.line_style, ones(4, 1));
assert_checkequal(c.foreground, 33 * ones(4, 1));


stackedplot(ts2);
f = gcf();
a = f.children;
c = a.children.children;
assert_checkequal(size(a, "*"), 4);
assert_checkequal(a.y_label.text, ["res4"; "res3"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(4, 1));
assert_checkequal(c.line_style, ones(4, 1));
assert_checkequal(c.foreground, 33 * ones(4, 1));


stackedplot(ts1, ts2);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 4);
assert_checkequal(a.y_label.text, ["res4"; "res3"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(8, 1));
assert_checkequal(c.line_style, ones(8, 1));
assert_checkequal(c.foreground, [34; 33; 34; 33; 34; 33; 34; 33]);
assert_checkequal(l(1).text, ["res4"; "res4"]);


stackedplot(ts2, ts1);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 4);
assert_checkequal(a.y_label.text, ["res4"; "res3"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(8, 1));
assert_checkequal(c.line_style, ones(8, 1));
assert_checkequal(c.foreground, [34; 33; 34; 33; 34; 33; 34; 33]);
assert_checkequal(l(1).text, ["res4"; "res4"]);


stackedplot(ts1, ts2, "res1");
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 1);
assert_checkequal(a.y_label.text, ["res1"]);
assert_checkequal(a.x_label.text, ["Time"]);
assert_checkequal(a.axes_visible(:, 1), "on");
assert_checkequal(c.thickness, [2; 2]);
assert_checkequal(c.line_style, [1; 1]);
assert_checkequal(c.foreground, [34; 33]);
assert_checkequal(l(1).text, ["res1"; "res1"]);


stackedplot(ts1, ts2, "res1", "CombineMatchingNames", %f);
f = gcf();
a = f.children;
c = a.children.children;
assert_checkequal(size(a, "*"), 2);
assert_checkequal(a.y_label.text, ["res1"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"]);
assert_checkequal(c.thickness, [2; 2]);
assert_checkequal(c.line_style, [1; 1]);
assert_checkequal(c.foreground, [34; 33]);


stackedplot(ts1, ts2, ["res1", "res3"]);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 2);
assert_checkequal(a.y_label.text, ["res3"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"]);
assert_checkequal(c.thickness, [2; 2; 2; 2]);
assert_checkequal(c.line_style, [1; 1; 1; 1]);
assert_checkequal(c.foreground, [34; 33; 34; 33]);
assert_checkequal(l(1).text, ["res3"; "res3"]);


stackedplot(ts1, ts2, [1 3]);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 2);
assert_checkequal(a.y_label.text, ["res3"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"]);
assert_checkequal(c.thickness, [2; 2; 2; 2]);
assert_checkequal(c.line_style, [1; 1; 1; 1]);
assert_checkequal(c.foreground, [34; 33; 34; 33]);
assert_checkequal(l(1).text, ["res3"; "res3"]);


stackedplot(ts1, ts2, {"res1", "res2", ["res3", "res4"]});
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 3);
assert_checkequal(a.y_label.text, ["res3"; "res4"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(8,1));
assert_checkequal(c.line_style, [2; 1; 2; 1; 1; 1; 1; 1]);
assert_checkequal(c.foreground, [34; 34; 33; 33; 34; 33; 34; 33]);
assert_checkequal(size(l, "*"), 3);
assert_checkequal(l(1).text, ["res3"; "res4";"res3"; "res4"]);

stackedplot(ts1, ts2, "LegendLabels", ["Results ts1", "Results ts2"]);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 4);
assert_checkequal(a.y_label.text, ["res4"; "res3"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(8, 1));
assert_checkequal(c.line_style, ones(8, 1));
assert_checkequal(c.foreground, [34; 33; 34; 33; 34; 33; 34; 33]);
assert_checkequal(l(1).text, ["Results ts1 - res4"; "Results ts2 - res4"]);


vars = {"res1", "res2", ["res3", "res4"]};
stackedplot(ts1, ts2, "--or", "LegendLabels", ["Results ts1", "Results ts2"], vars);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 3);
assert_checkequal(a.y_label.text, ["res3"; "res4"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""]);
assert_checkequal(a.axes_visible(:, 1), ["on"; "off"; "off"]);
assert_checkequal(c.thickness, 2 * ones(8,1));
assert_checkequal(c.line_style, 2 * ones(8,1));
assert_checkequal(c.foreground, 5 * ones(8,1));
assert_checkequal(size(l, "*"), 3);
assert_checkequal(l(1).text, ["Results ts1 - res3"; "Results ts1 - res4";"Results ts2 - res3"; "Results ts2 - res4"]);

stackedplot(ts1, ts2, ["--or", "*b"], "LegendLabels", ["Results ts1", "Results ts2"], vars);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 3);
assert_checkequal(a.y_label.text, ["res3"; "res4"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""]);
assert_checkequal(c.thickness, 2 * ones(8,1));
assert_checkequal(c.line_style, [1; 1; 2; 2; 1; 2; 1; 2]);
assert_checkequal(c.foreground, [1; 1; 5; 5; 1; 5; 1; 5]);
assert_checkequal(size(l, "*"), 3);
assert_checkequal(l(1).text, ["Results ts1 - res3"; "Results ts1 - res4";"Results ts2 - res3"; "Results ts2 - res4"]);

stackedplot(ts1, "marker", "o", "markersize", 3, vars);
f = gcf();
a = f.children;
c = a.children.children;
l = a.children(a.children.type == "Legend");
assert_checkequal(size(a, "*"), 3);
assert_checkequal(a.y_label.text, ["res3"; "res4"; "res2"; "res1"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""]);
assert_checkequal(c.thickness, 2 * ones(4,1));
assert_checkequal(c.line_style, [1; 1; 1; 1]);
assert_checkequal(c.foreground, [34; 33; 33; 33]);
assert_checkequal(c.mark_size, [3; 3; 3; 3]);
assert_checkequal(c.mark_style, [9; 9; 9; 9]);
assert_checkequal(size(l, "*"), 1);
assert_checkequal(l(1).text, ["res3"; "res4"]);

stackedplot(ts1, "Title", "Stackedplot graph test");
f = gcf();
a = f.children;
assert_checkequal(a($).title.text, "Stackedplot graph test");

stackedplot(ts1, ts2, ["res2", "res4"], "DisplayLabels", ["graph - res2", "graph - res4"]);
f = gcf();
a = f.children;
assert_checkequal(size(a, "*"), 2);
assert_checkequal(a.y_label.text, ["graph - res4"; "graph - res2"]);

stackedplot(ts1, ts2, "DisplayLabels", ["r1", "r2", "r3", "r4"]);
f = gcf();
a = f.children;
assert_checkequal(size(a, "*"), 4);
assert_checkequal(a.y_label.text, ["r4"; "r3"; "r2"; "r1"]);

stackedplot(ts1, ts2, "DisplayLabels", ["r1", "r2", "r3", "r4"], "CombineMatchingNames", %f);
f = gcf();
a = f.children;
assert_checkequal(size(a, "*"), 8);
assert_checkequal(a.y_label.text, ["r4"; "r3"; "r2"; "r1"; "r4"; "r3"; "r2"; "r1"]);

// res2 is drawned in two graphs
vars = {["res1", "res2"], ["res2", "res3"], "res4"};
f = stackedplot(ts1, vars);
a = f.children;
assert_checkequal(size(a, "*"), 3);
assert_checkequal(a.y_label.text, ["res4"; "res2"; "res3"; "res1"; "res2"]);
assert_checkequal(a.x_label.text, ["Time"; ""; ""]);

// error
msg = msprintf(_("%s: Wrong type for input argument #%d: boolean expected.\n"), "stackedplot", 4);
assert_checkerror("stackedplot(ts1, ts2, ""CombineMatchingNames"", 1)", msg);
msg = msprintf(_("%s: Wrong type for input argument #%d: string expected.\n"), "stackedplot", 4);
assert_checkerror("stackedplot(ts1, ts2, ""LegendLabels"", 1)", msg);
msg = msprintf(_("%s: Wrong size for input argument #%d: Must be the same size as the number of timeseries.\n"), "stackedplot", 4);
assert_checkerror("stackedplot(ts1, ts2, ""LegendLabels"", ""toto"")", msg);
msg = msprintf(_("%s: The number of Linespec must be equal to the number of timeseries in input.\n"), "stackedplot");
assert_checkerror("stackedplot(ts1, ts2, [""--or"", ""*b"", "".g""])", msg);
msg = msprintf(_("%s: Wrong type for input argument #%d: string expected.\n"), "stackedplot", 4);
assert_checkerror("stackedplot(ts1, ts2, ""Title"", 1)", msg);
msg = msprintf(_("%s: Wrong type for input argument #%d: string expected.\n"), "stackedplot", 4);
assert_checkerror("stackedplot(ts1, ts2, ""DisplayLabels"", 1)", msg);
msg = msprintf(_("%s: DisplayLabels must be the same size as the number of variables.\n"), "stackedplot");
assert_checkerror("stackedplot(ts1, ts2, ""DisplayLabels"", [""r1"", ""r2"", ""r3""])", msg);
msg = msprintf(_("%s: Wrong value for input argument #%d: a valid LineSpec or VariableName expected.\n"), "stackedplot", 2);
assert_checkerror("stackedplot(ts1, ""o+-"")", msg);
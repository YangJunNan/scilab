// ========================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2012 - Scilab Enterprises - Bruno JOFRET
// Copyright (C) 2021 - Samuel GOUGEON
//
//  This file is distributed under the same license as the Scilab package.
// ========================================================================
//
// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->
//
// =======================
// xsetech() unitary tests
// =======================

clf reset
f = gcf();
a1 = gca();

// Assert axes fill all figure
assert_checkequal(a1.axes_bounds, [0 0 1 1]);
// Assert figure only has 1 child
assert_checkequal(size(f.children), [1 1]);
assert_checkequal(f.children(1).type, "Axes");

// xsetech(axes_bounds)
// ....................
xsetech([0,0,0.1,0.1]);
a2 = gca();
// Assert figure has two children
assert_checkequal(size(f.children), [2 1]);
assert_checkequal(a2.axes_bounds, [0 0 0.1 0.1]);
// a2 == a1: simply check on axes bounds
assert_checkequal(a1.axes_bounds, [0 0 1 1]);

xsetech([0.9 0.9 0.1 0.1])
a3 = gca();
// Assert figure has three children now
assert_checkequal(size(f.children), [3 1]);
assert_checkequal(a1.axes_bounds, [0 0 1 1]);
assert_checkequal(a2.axes_bounds, [0 0 0.1 0.1]);
assert_checkequal(a3.axes_bounds, [0.9 0.9 0.1 0.1]);

// %nan keeps the current or default value
// ---------------------------------------
clf reset
xsetech([0.1 0.1 0.8 %nan],[10 %nan 20 %nan],,[%nan 0.07 0.07 %nan])
a = gca();
assert_checkequal(a.axes_bounds(1:3), [0.1 0.1 0.8]);
assert_checkequal(a.axes_bounds(4), gda().axes_bounds(4));
assert_checkequal(a.data_bounds(1:2), [10 20]);
assert_checkequal(a.data_bounds([3 4]), gda().data_bounds([3 4]));
assert_checkequal(a.margins([2 3]), [0.07 0.07]);
assert_checkequal(a.margins([1 4]), gda().margins([1 4]));


// ---------
// on frames
// ---------
clf reset
f = gcf();
a = gca();
fr1 = uicontrol(f, "style", "frame","units","normalized","position",[0 0 0.7 0.7]);
assert_checkequal(f.children.type, ["uicontrol" "Axes"]');
set("current_entity", fr1)
newaxes(fr1);
x = linspace(-1,10,500);
y = sin(x)+rand(x)*0.1;
plot(x,y)
xsetech([0.62 0.57 0.25 0.25]);
k = find(x>5 & x<5.5);
plot(x(k), y(k))

sca(a); // useless when https://gitlab.com/scilab/scilab/-/merge_requests/192 will be merged
set("current_entity",f);
subplot(2,3,3)
plot(x,y)

assert_checkequal(f.children.type,["Axes" "uicontrol" "Axes"]');
assert_checkequal(f.children(2).children.type,["Axes" "Axes"]');
assert_checkequal(f.children(2).children(2).axes_bounds, [0 0 1 1]);
assert_checkequal(f.children(2).children(1).axes_bounds, [0.62 0.57 0.25 0.25]);

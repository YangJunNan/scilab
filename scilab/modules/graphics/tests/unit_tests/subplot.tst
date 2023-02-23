// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2012 - Scilab Enterprises - Bruno JOFRET
// Copyright (C) 2021 - Samuel GOUGEON
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

// =======================
// subplot() unitary tests
// =======================

// Check each current figure property
clf reset
f = gcf()
a1 = gca();

// Assert axes fill all figure
assert_checkequal(a1.axes_bounds, [0 0 1 1]);
// Assert figure only has 1 child
assert_checkequal(size(f.children), [1 1]);
assert_checkequal(f.children(1).type, "Axes");

subplot(10,10,1);
a2 = gca();
// Assert figure has still one child
assert_checkequal(size(f.children), [1 1]);
assert_checkequal(a2.axes_bounds, [0 0 0.1 0.1]);
// a2 == a1: simply check on axes bounds
assert_checkequal(a1.axes_bounds, [0 0 0.1 0.1]);

subplot(10,10,100);
a3 = gca();
// Assert figure has two children now
assert_checkequal(size(f.children), [2 1]);
assert_checkequal(a1.axes_bounds, [0 0 0.1 0.1]);
assert_checkequal(a3.axes_bounds, [0.9 0.9 0.1 0.1]);

subplot(10,10,10);
a4 = gca();
// Assert figure has three children now
assert_checkequal(size(f.children), [3 1]);
assert_checkequal(a1.axes_bounds, [0 0 0.1 0.1]);
assert_checkequal(a3.axes_bounds, [0.9 0.9 0.1 0.1]);
assert_checkequal(a4.axes_bounds, [0.9 0 0.1 0.1]);

subplot(10,10,91);
a5 = gca();
// Assert figure has four children now
assert_checkequal(size(f.children), [4 1]);
assert_checkequal(a1.axes_bounds, [0 0 0.1 0.1]);
assert_checkequal(a3.axes_bounds, [0.9 0.9 0.1 0.1]);
assert_checkequal(a4.axes_bounds, [0.9 0 0.1 0.1]);
assert_checkequal(a5.axes_bounds, [0 0.9 0.1 0.1]);

// subplot can't use the default axes if it's not clean:
// https://www.mail-archive.com/users@lists.scilab.org/msg10455.html
clf reset
f = gcf();
title  "The  overall  title"  fontsize  4
subplot(1,2,1)
plot(1:10)
assert_checkequal(length(f.children), 2);
assert_checkequal(f.children(2).title.text, "The  overall  title");

// ---------
// on frames
// ---------
clf reset
f = gcf();
// Frame #1
fr1 = uicontrol(f, "style", "frame","units","normalized","position",[0.05 0.1 0.4 0.8]);
assert_checkequal(f.children.type, ["uicontrol" "Axes"]')
set("current_entity", fr1)
subplot(3,2,1)
plot(1:10), title "Top left"
subplot(3,2,2)
plot(1:10), title "Top right"
subplot(3,1,2)
plot(1:10), title "plot #1"
subplot(3,1,3)
plot(1:10), title "plot #2"

assert_checkequal(length(fr1.children), 4);
assert_checktrue(and(fr1.children.type=="Axes"));
ref = ["plot #2"
       "plot #1"
       "Top right"
       "Top left"
       ];
assert_checkequal(fr1.children.title.text, ref);

// Frame #2
fr2 = uicontrol(f, "style", "frame","units","normalized","position",[0.5 0.5 0.5 0.5]);
assert_checkequal(f.children.type, ["uicontrol" "uicontrol" "Axes"]')
set('current_entity', fr2)
subplot(1,2,1)
plot(1:10), title "Title #1"
subplot(1,2,2)
plot(1:10), title "Title #2"
assert_checktrue(and(fr2.children.type=="Axes"));
ref = ["Title #2"
       "Title #1"];
assert_checkequal(fr2.children.title.text, ref);

// Figure
set("current_entity", f)
subplot(2,2,4)
plot2d()
title "Back to the figure substrate"

assert_checkequal(f.children.type, ["Axes" "uicontrol" "uicontrol" "Axes"]')

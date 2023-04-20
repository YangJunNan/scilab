// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2018, 2019 - Samuel GOUGEON
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- TEST WITH GRAPHIC -->
// <-- NO CHECK REF -->

// Unitary tests of color_input()

// Names
assert_checkequal(color_input([]), []);
assert_checkequal(color_input("red"), [1 0 0]);
assert_checkequal(color_input("red", "a"), [1 0 0]);
assert_checkequal(color_input("red", "1"), [%nan %nan %nan]);
assert_checkequal(color_input("red", "."), [%nan %nan %nan]);
assert_checkequal(color_input("red", "#"), [%nan %nan %nan]);
assert_checkequal(color_input("orange"), [255 165 0]/255);
assert_checkequal(color_input("OrAngE"), [255 165 0]/255);
assert_checkequal(color_input("Scilab Blue2"), [0 0 208]/255);
cnames = ["r" "g" "GRE" "b" "c" "m" "ma" "y" "Yel" "w" "k"];
ref =     [1.  0.   0.   0.  0.  1.  1.   1.   1.   1.   0.
           0.  1.   1.   0.  1.  0.  0.   1.   1.   1.   0.
           0.  0.   0.   1.  1.  1.  1.   0.   0.   1.   0.
           ]';
assert_checkequal(color_input(cnames), ref);

// #RRGGBB
assert_checkequal(color_input("#123456"), [18 52 86]/255);
assert_checkequal(color_input("#123456"), [18 52 86]/255);
assert_checkequal(color_input("#abcdef"), [171 205 239]/255);
assert_checkequal(color_input("#ABcDeF"), [171 205 239]/255);
assert_checkequal(color_input("#12345G"), [%nan %nan %nan]);
assert_checkequal(color_input("#1234"),   [%nan %nan %nan]);

// Mixed names + #RRGGBB
assert_checkequal(color_input(["#abcdef" "orange"]), [171 205 239 ; 255 165 0]/255);

// Indices
sdf();
assert_checkequal(color_input([-1 -2]), [-1 ; -2]); // special indices
assert_checkequal(color_input(0), %nan);
assert_checkequal(color_input([-1 -2 0]), [-1 -2 %nan]');
assert_checkequal(color_input(1.5), %nan);
assert_checkequal(color_input(4), 4);
assert_checkequal(color_input(4, "a"), %nan);
assert_checkequal(color_input(4, "."), %nan);
assert_checkequal(color_input(4, "#"), %nan);
assert_checkequal(color_input(100), %nan);  // too big for the default CM
assert_checkequal(color_input(1:2), (1:2)');
assert_checkequal(color_input(1:3), (1:3)');

f = scf(123);
f.color_map = jetcolormap(64);
assert_checkequal(color_input([1 7 4 3]), [1 7 4 3]');
assert_checkequal(color_input(65), %nan);
delete(f)

// [r g b]
assert_checkequal(color_input([-0.1 .2 .3]), [%nan %nan %nan]);
assert_checkequal(color_input([0.1 .2  3]), [%nan %nan %nan]);
assert_checkequal(color_input([0.1 .2 .3]), [0.1 0.2 0.3]);
assert_checkequal(color_input([0.1 .2 .3], "a"), %nan*ones(1,3));
assert_checkequal(color_input([0.1 .2 .3], "#"), %nan*ones(1,3));
assert_checkequal(color_input([0.1 .2 .3], "1"), %nan*ones(1,3));
assert_checkequal(color_input([0.1 .2 .3], "1."), [.1 .2 .3]);
assert_checkequal(color_input([0.1 .2 .3 .4]), %nan*ones(4,1));
m = rand(10,3);
assert_checkequal(color_input(m), m);


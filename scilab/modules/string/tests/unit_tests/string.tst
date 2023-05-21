// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2007-2008 - INRIA
// Copyright (C) 2016-2023 - Samuel GOUGEON
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

//===============================
// unit tests string
//===============================
assert_checkequal(string(1), "1");
//===============================
assert_checkequal(string(1.5), "1.5");
//===============================
// Special display cases :
assert_checkequal(string(0+%i), "%i");
assert_checkequal(string(0-%i), "-%i");
assert_checkequal(string(0+0*%i), "0");
assert_checkequal(string(-1+%i), "-1+%i");
assert_checkequal(string(-1-%i), "-1-%i");
assert_checkequal(string(0+2*%i), "%i*2");
assert_checkequal(string(0-2*%i), "-%i*2");
assert_checkequal(string(-2+2*%i), "-2+%i*2");
assert_checkequal(string(-2-2*%i), "-2-%i*2");
// https://gitlab.com/scilab/scilab/-/issues/10082 :
assert_checkequal(string(1+%i), "1+%i");
assert_checkequal(string(2+3.5*%i), "2+%i*3.5");
assert_checkequal(string(3.4-2*%i), "3.4-%i*2");
assert_checkequal(string(complex(3.4,-%nan)), "3.4+%i*Nan");
assert_checkequal(string(complex(3.4,%inf)), "3.4+%i*Inf");
assert_checkequal(string(complex(%nan,0)), "Nan");
assert_checkequal(string(complex(0,%nan)), "%i*Nan");
assert_checkequal(string(complex(-%inf,-%nan)), "-Inf+%i*Nan");
//===============================
assert_checkequal(string([]), []);
//===============================
assert_checkequal(string(""), "");
//===============================
assert_checkequal(string(1:3), ["1","2","3"]);
//===============================
assert_checkequal(string([1;2;3]), ["1";"2";"3"]);
//===============================
assert_checkequal(string("foo"), "foo");
//===============================
deff("y = mymacro(x)", "y = x + 1");
[out, in, text] = string(mymacro);
assert_checkequal(out, "y");
assert_checkequal(in, "x");
assert_checkequal(text, [" "; "y = x + 1"; " "]);
//===============================
clear mymacro
deff("y = mymacro(x)", "y = x + 1");
[out, in, text]=string(mymacro);
assert_checkequal(out, "y");
assert_checkequal(in, "x");
assert_checkequal(text, [" "; "y = x + 1"; " "]);
//===============================
R = string(corelib);
assert_checkequal(strsubst(R(1),"\","/"), "SCI/modules/core/macros/");

//===============================
//          INTEGERS
//===============================
// https://gitlab.com/scilab/scilab/-/issues/15488
funs_s = list(int8, int16, int32, int64);
funs_u = list(uint8, uint16, uint32, uint64);
nbd = [2, 4, 9, 19];    // max number of digits (for mantissa up to 9##..##)
for m = 1:9     // repeated mantissa digit
    // Build the full ref
    Ref = [];
    for i = 1:19
        Ref = [Ref ; part(msprintf("%d\n",m), ones(1,i))];
    end
    // Tests
    for i = 1:4
        nums = [];
        [uf, sf] = (funs_u(i), funs_s(i));
        Max = uf(%inf);
        for j = 1:nbd(i)
            num = sum(uf(10)^(0:j-1).*uf(ones(1,j)*m));
            if num < Max
                nums = [nums ; num];
            end
        end
        // unsigned
        assert_checkequal(%i_string(nums), Ref(1:nbd(i)));
        // signed
        tmp = -sf(nums);
        k = tmp < 0;
        tmp = tmp(k);
        assert_checkequal(%i_string(tmp), "-"+Ref(1:nbd(i))(k));
    end
end

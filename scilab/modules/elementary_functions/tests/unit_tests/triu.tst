// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Samuel Gougeon
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
// Unitary tests of triu()
// -----------------------------------------------------------------------------
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// []
// --
assert_checkequal(triu([]), []);
assert_checkequal(triu([], -1), []);
assert_checkequal(triu([],  1), []);

// Input scalars
// -------------
// k = 0
objects = list(%t,%f, %pi,1+%i, %z,%z+%i, "a", int8(-2),uint8(2),int16(-2),uint16(2),int32(-2),uint32(2),int64(-2),uint64(2));
for o = objects
    assert_checkequal(triu(o), o);
end
// k = 1
assert_checkequal(triu(%t,1), %f);
assert_checkequal(triu(%pi,1), 0);
assert_checkequal(triu(%i,1), 0+0*%i);
assert_checkequal(triu(%z,1), 0*%z);
assert_checkequal(triu(%z+%i,1), 0*%z+0*%i);
assert_checkequal(triu("a",1), "");
assert_checkequal(triu(int8(-2),1), int8(0));
assert_checkequal(triu(uint8(2),1), uint8(0));
assert_checkequal(triu(int16(-2),1), int16(0));
assert_checkequal(triu(uint16(2),1), uint16(0));
assert_checkequal(triu(int32(-2),1), int32(0));
assert_checkequal(triu(uint32(2),1), uint32(0));
assert_checkequal(triu(int64(-2),1), int64(0));
assert_checkequal(triu(uint64(2),1), uint64(0));

// MATRICES
// --------
cases = list(ones(4,4), ones(4,6));
// Input square matrix: reference answers
sq1 = [1,1,1,1 ; 0,1,1,1 ; 0,0,1,1 ; 0,0,0,1];
sq2 = [1,1,1,1 ; 1,1,1,1 ; 0,1,1,1 ; 0,0,1,1];
sq3 = [0,1,1,1 ; 0,0,1,1 ; 0,0,0,1 ; 0,0,0,0];

// Input non-square matrix: reference answers
rec1 = [1,1,1,1,1,1 ; 0,1,1,1,1,1 ; 0,0,1,1,1,1 ; 0,0,0,1,1,1];
rec2 = [1,1,1,1,1,1 ; 1,1,1,1,1,1 ; 0,1,1,1,1,1 ; 0,0,1,1,1,1];
rec3 = [0,1,1,1,1,1 ; 0,0,1,1,1,1 ; 0,0,0,1,1,1 ; 0,0,0,0,1,1];

refs = list(list(sq1,sq2,sq3), list(rec1,rec2,rec3));
for i = 1:2
    A = cases(i);
    [r1,r2,r3] = (refs(i)(:));

    assert_checkequal(triu(A==1)   , r1==1);
    assert_checkequal(triu(A==1,-1), r2==1);
    assert_checkequal(triu(A==1,1) , r3==1);

    assert_checkequal(triu(int8(A))   , int8(r1));
    assert_checkequal(triu(int8(A),-1), int8(r2));
    assert_checkequal(triu(int8(A), 1), int8(r3));

    assert_checkequal(triu(A)   , r1);
    assert_checkequal(triu(A,-1), r2);
    assert_checkequal(triu(A, 1), r3);

    assert_checkequal(triu(A*%i)   , r1*%i);
    assert_checkequal(triu(A*%i,-1), r2*%i);
    assert_checkequal(triu(A*%i, 1), r3*%i);

    assert_checkequal(triu(A*%z)   , r1*%z);
    assert_checkequal(triu(A*%z,-1), r2*%z);
    assert_checkequal(triu(A*%z, 1), r3*%z);

    assert_checkequal(triu(1./(A*%z))   , r1/%z);
    assert_checkequal(triu(1./(A*%z),-1), r2/%z);
    assert_checkequal(triu(1./(A*%z), 1), r3/%z);

    assert_checkequal(triu(string(A))   , strsubst(string(r1),"0",""));
    assert_checkequal(triu(string(A),-1), strsubst(string(r2),"0",""));
    assert_checkequal(triu(string(A), 1), strsubst(string(r3),"0",""));
end

// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Samuel Gougeon
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
// Unitary tests of tril()
// -----------------------------------------------------------------------------
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

// []
// --
assert_checkequal(tril([]), []);
assert_checkequal(tril([], -1), []);
assert_checkequal(tril([],  1), []);

// Input scalars
// -------------
// k = 0
objects = list(%t,%f, %pi,1+%i, %z,%z+%i, "a", int8(-2),uint8(2),int16(-2),uint16(2),int32(-2),uint32(2),int64(-2),uint64(2));
for o = objects
    assert_checkequal(tril(o), o);
end

// k = -1
assert_checkequal(tril(%t,-1), %f);
assert_checkequal(tril(%pi,-1), 0);
assert_checkequal(tril(%i,-1), 0+0*%i);
assert_checkequal(tril(%z,-1), 0*%z);
assert_checkequal(tril(%z+%i,-1), 0*%z+0*%i);
assert_checkequal(tril("a",-1), "");
assert_checkequal(tril(int8(-2),-1), int8(0));
assert_checkequal(tril(uint8(2),-1), uint8(0));
assert_checkequal(tril(int16(-2),-1), int16(0));
assert_checkequal(tril(uint16(2),-1), uint16(0));
assert_checkequal(tril(int32(-2),-1), int32(0));
assert_checkequal(tril(uint32(2),-1), uint32(0));
assert_checkequal(tril(int64(-2),-1), int64(0));
assert_checkequal(tril(uint64(2),-1), uint64(0));

// MATRICES
// --------
cases = list(ones(4,4), ones(4,6));
// Input square matrix: reference answers
sq1 = [1,0,0,0 ; 1,1,0,0 ; 1,1,1,0 ; 1,1,1,1];
sq2 = [0,0,0,0 ; 1,0,0,0 ; 1,1,0,0 ; 1,1,1,0];
sq3 = [1,1,0,0 ; 1,1,1,0 ; 1,1,1,1 ; 1,1,1,1];

// Input non-square matrix: reference answers
rec1 = [1,0,0,0,0,0 ; 1,1,0,0,0,0 ; 1,1,1,0,0,0 ; 1,1,1,1,0,0];
rec2 = [0,0,0,0,0,0 ; 1,0,0,0,0,0 ; 1,1,0,0,0,0 ; 1,1,1,0,0,0];
rec3 = [1,1,0,0,0,0 ; 1,1,1,0,0,0 ; 1,1,1,1,0,0 ; 1,1,1,1,1,0];

refs = list(list(sq1,sq2,sq3), list(rec1,rec2,rec3));
for i = 1:2
    A = cases(i);
    [r1,r2,r3] = (refs(i)(:));

    assert_checkequal(tril(A==1)   , r1==1);
    assert_checkequal(tril(A==1,-1), r2==1);
    assert_checkequal(tril(A==1,1) , r3==1);

    assert_checkequal(tril(int8(A))   , int8(r1));
    assert_checkequal(tril(int8(A),-1), int8(r2));
    assert_checkequal(tril(int8(A), 1), int8(r3));

    assert_checkequal(tril(A)   , r1);
    assert_checkequal(tril(A,-1), r2);
    assert_checkequal(tril(A, 1), r3);

    assert_checkequal(tril(A*%i)   , r1*%i);
    assert_checkequal(tril(A*%i,-1), r2*%i);
    assert_checkequal(tril(A*%i, 1), r3*%i);

    assert_checkequal(tril(A*%z)   , r1*%z);
    assert_checkequal(tril(A*%z,-1), r2*%z);
    assert_checkequal(tril(A*%z, 1), r3*%z);

    assert_checkequal(tril(1./(A*%z))   , r1/%z);
    assert_checkequal(tril(1./(A*%z),-1), r2/%z);
    assert_checkequal(tril(1./(A*%z), 1), r3/%z);

    assert_checkequal(tril(string(A))   , strsubst(string(r1),"0",""));
    assert_checkequal(tril(string(A),-1), strsubst(string(r2),"0",""));
    assert_checkequal(tril(string(A), 1), strsubst(string(r3),"0",""));
end

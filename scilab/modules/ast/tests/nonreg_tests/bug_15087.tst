// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2019 - Stéphane MOTTELET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->
//
// <-- Non-regression test for bug 15087 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/15087
//
// <-- Short Description -->
// Deleting rows or columns from a matrix is slow

X = rand(1e5,5);
tic();
X(:,3)=[];
T1 = toc();

tic();
X(:)=[];
T2 = toc();

assert_checkalmostequal(T1, T2, 1E-4, 1E-3);


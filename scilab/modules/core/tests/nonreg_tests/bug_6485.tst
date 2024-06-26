// =============================================================================
// Scilab ( https://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2010 - DIGITEO - Allan CORNET
//
//  This file is distributed under the same license as the Scilab package.
// =============================================================================
//
// <-- CLI SHELL MODE -->
// <-- LONG TIME EXECUTION -->
//
// <-- Non-regression test for bug 6485 -->
//
// <-- GitLab URL -->
// https://gitlab.com/scilab/scilab/-/issues/6485
//
// <-- Short Description -->
// We lost available memory from Scilab-5.2.0 to Scilab master nighty build.
// version with bug never published

// <-- CLI SHELL MODE -->
//
timer();a=rand(3000,3000);b=a*a';[c,d]=lu(b);inv(a);[u,s,v]=svd(a);timer();

// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2021 - Stéphane Mottelet
//
// This file must be used under the terms of GPL License
// This source file is licensed as described in the file COPYING, which
// you should have received as part of this distribution.  The terms
// are also available at
// https://www.gnu.org/licenses/gpl-3.0.txt

// <-- CLI SHELL MODE -->
// <-- NO CHECK REF -->

mputl([
"#include <nvector/nvector_serial.h>"
"int sunRhs(realtype t, N_Vector N_VectorY, N_Vector N_VectorYd, void *pManager)"
"{"
"double *y = NV_DATA_S(N_VectorY);"
"double *ydot = NV_DATA_S(N_VectorYd);"
"ydot[0] = y[1];"
"ydot[1] = (1-y[0]*y[0])*y[1]-y[0];"
"return 0;"
"}"
],"code.c")
SUN_Clink("sunRhs","code.c",load=%t);

[t,y] = cvode("sunRhs",[0 1],[0;2])
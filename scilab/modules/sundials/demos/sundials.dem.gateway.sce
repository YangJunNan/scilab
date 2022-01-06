// =============================================================================
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
//
// Copyright (C) 2022 - Stéphane Mottelet
//
// This file must be used under the terms of GPL License
// This source file is licensed as described in the file COPYING, which
// you should have received as part of this distribution.  The terms
// are also available at
// https://www.gnu.org/licenses/gpl-3.0.txt

function subdemolist = demo_gateway()
    demopath = get_absolute_file_path("sundials.dem.gateway.sce");
    add_demo("SUNDIALS", demopath + "sundials.dem.gateway.sce");

    subdemolist = [_("Minimal surface"), "minimal.dem.sce"
                  [_("Lorenz attractor"), "lorenz.dem.sce"]]

    subdemolist(:,2) = demopath + subdemolist(:,2);
endfunction

subdemolist = demo_gateway();
clear demo_gateway;

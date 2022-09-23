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

demopath = get_absolute_file_path("lagrangian.dem.gateway.sce");

subdemolist = ["Single pendulum" ,"lagrangian/demo_single_pendulum.sce"
               "Double pendulum","lagrangian/demo_double_pendulum.sce"
               "Cardioid sliding pendulum","lagrangian/demo_cardioid_pendulum.sce"
               "N-pendulum","lagrangian/demo_npend.sce"
               "Collapsing chain","lagrangian/demo_chain.sce"]

subdemolist(:,2) = demopath + subdemolist(:,2);
clear demopath;

//  Scicos
//
//  Copyright (C) DIGITEO - 2009 - Allan CORNET
//  Copyright (C) ESI Group - 2018 - Clement DAVID
//
// This program is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
//
// See the file ./license.txt
//

cd SCI/modules/scicos_blocks/src/c;

BLOCK_C_SOURCES = gsort(ls("*.c"));

NON_BLOCK_C_SOURCES = ["scoGetProperty.c",
"scoSetProperty.c",
"scoMisc.c",
"scoMemoryScope.c",
"scoWindowScope.c",
"DllmainScicos_blocks.c",
"scicos_evalhermite.c",
"scicos_indexfinder.c"];

NON_BLOCK_CPP_SOURCES = ["scoUtils.cpp",
"HelpersJNI.cpp",
"HelpersCLI.cpp"];

BLOCK_C_SOURCES(grep(BLOCK_C_SOURCES,NON_BLOCK_C_SOURCES)) = [];
BLOCKS_C = strsubst(BLOCK_C_SOURCES,".c","");

cd SCI/modules/scicos_blocks/src/fortran;

BLOCK_FORTRAN_SOURCES = gsort(ls("*.f"));
BLOCKS_FORTRAN = strsubst(BLOCK_FORTRAN_SOURCES,".f","");

cd SCI/modules/scicos_blocks/src/cpp;

BLOCK_CPP_SOURCES = gsort(ls("*.cpp"));
BLOCK_CPP_SOURCES(grep(BLOCK_CPP_SOURCES,NON_BLOCK_CPP_SOURCES)) = [];
BLOCKS_CPP = strsubst(BLOCK_CPP_SOURCES,".cpp","");

BLOCKS_H = [
"";
"/*  Scicos";
"*";
"*  Copyright (C) INRIA - METALAU Project <scicos@inria.fr>";
"*  Copyright (C) DIGITEO - 2010-2011";
"*";
"* This program is free software; you can redistribute it and/or modify";
"* it under the terms of the GNU General Public License as published by";
"* the Free Software Foundation; either version 2 of the License, or";
"* (at your option) any later version.";
"*";
"* This program is distributed in the hope that it will be useful,";
"* but WITHOUT ANY WARRANTY; without even the implied warranty of";
"* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the";
"* GNU General Public License for more details.";
"*";
"* You should have received a copy of the GNU General Public License";
"* along with this program; if not, write to the Free Software";
"* Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.";
"*";
"* See the file ./license.txt";
"*/";
"#ifndef __SCICOS_BLOCKS_H__";
"#define __SCICOS_BLOCKS_H__";
"";
"#include ""machine.h""";
"#include ""dynlib_scicos_blocks.h""";
"#include ""scicos.h""";
"";
"/******* Please do not edit *************/";
""];

BLOCKS_H = [BLOCKS_H;
"SCICOS_BLOCKS_IMPEXP void C2F(" + BLOCKS_FORTRAN + ")(ARGS_scicos);" ;
"SCICOS_BLOCKS_IMPEXP void " + BLOCKS_C + "(ARGS_scicos);" ;
"SCICOS_BLOCKS_IMPEXP void " + BLOCKS_CPP + "(ARGS_scicos);" ;
""];

BLOCKS_H = [BLOCKS_H;
"OpTab tabsim[] = {"];

BLOCKS_H = [BLOCKS_H;
"{""" + BLOCKS_FORTRAN + """, C2F(" + BLOCKS_FORTRAN + ")}," ;
"{""" + BLOCKS_C + """, " + BLOCKS_C + "}," ;
"{""" + BLOCKS_CPP + """, " + BLOCKS_CPP + "}," ;
"{(char *) 0, (ScicosF) 0}};" ;
"#endif /* __SCICOS_BLOCKS_H__ */" ;
"/****************************************/" ;
""];


mputl(BLOCKS_H, SCI + "/modules/scicos_blocks/includes/blocks.h.vc");
mputl(BLOCKS_H, SCI + "/modules/scicos_blocks/includes/blocks.h");

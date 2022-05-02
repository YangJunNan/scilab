//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v2.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------


/*--------------------------------------------------------------------------*/
#ifndef __DYNLIB_COLPACK_H__
#define  __DYNLIB_COLPACK_H__

#ifdef _MSC_VER
#ifdef COLPACK_EXPORTS
#define COLPACK_IMPEXP __declspec(dllexport)
#else
#define COLPACK_IMPEXP __declspec(dllimport)
#endif
#else
#define COLPACK_IMPEXP
#endif

#endif /*  __DYNLIB_COLPACK_H__ */
/*--------------------------------------------------------------------------*/

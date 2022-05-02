//
// Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
// Copyright (C) 2022 - Stephane MOTTELET
//
// This file is hereby licensed under the terms of the GNU GPL v3.0,
// For more information, see the COPYING file which you should have received
//
//--------------------------------------------------------------------------

#ifndef __COLPACK_GW_HXX__
#define __COLPACK_GW_HXX__

#include "cpp_gateway_prototype.hxx"

#include "dynlib_colpack_gw.h"

CPP_OPT_GATEWAY_PROTOTYPE_EXPORT(sci_spCompJacobian, COLPACK_GW_IMPEXP);
CPP_OPT_GATEWAY_PROTOTYPE_EXPORT(sci_spCompHessian, COLPACK_GW_IMPEXP);
CPP_GATEWAY_PROTOTYPE_EXPORT(sci_percent_spCompGeneric_clear, COLPACK_GW_IMPEXP);
CPP_GATEWAY_PROTOTYPE_EXPORT(sci_percent_spCompGeneric_e, COLPACK_GW_IMPEXP);

#endif /* __COLPACK_GW_HXX__ */



# Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
# Copyright (C) 2022 - Stéphane MOTTELET
#
# This file is distributed under the same license as the Scilab package.

SUNDIALS_C_SOURCES = \
    src/c/externals_for_tests.c

SUNDIALS_CPP_SOURCES = \
    src/cpp/SUNDIALSManager.cpp \
    src/cpp/SUNDIALSBridge.cpp \
    src/cpp/KINSOLBridge.cpp \
    src/cpp/CVODEManager.cpp \
    src/cpp/KINSOLManager.cpp \
    src/cpp/IDAManager.cpp \
    src/cpp/ARKODEManager.cpp \
    src/cpp/OdeManagerInit.cpp \
    src/cpp/OdeManagerCompute.cpp \
    src/cpp/OdeManagerParse.cpp \
    src/cpp/OdeManagerHelpers.cpp \
    src/cpp/OdeManagerSolve.cpp \
    src/cpp/odeparameters.cpp \
    src/cpp/complexHelpers.cpp
    

GATEWAY_CPP_SOURCES = \
    sci_gateway/cpp/sci_cvode.cpp \
    sci_gateway/cpp/sci_ida.cpp \
    sci_gateway/cpp/sci_arkode.cpp \
    sci_gateway/cpp/sci_kinsol.cpp \
    sci_gateway/cpp/sci_percent_odeSolution.cpp

libscisundials_la_CPPFLAGS= \
    -I$(srcdir)/includes/ \
    -I$(srcdir)/src/cpp/ \
    -I$(srcdir)/src/c/ \
    -I$(srcdir)/src/patched_sundials/include/ \
    -I$(srcdir)/src/patched_sundials/src/ \
    -I$(srcdir)/src/patched_sundials/src/sundials \
    -I$(top_srcdir)/modules/colpack/includes/ \
    -I$(top_srcdir)/modules/colpack/src/ColPack/include/ \
    -I$(top_srcdir)/modules/colpack/src/ColPack/src/Utilities/ \
    -I$(top_srcdir)/modules/colpack/src/ColPack/src/Recovery/ \
    -I$(top_srcdir)/modules/colpack/src/ColPack/src/GeneralGraphColoring \
    -I$(top_srcdir)/modules/colpack/src/ColPack/src/BipartiteGraphPartialColoring \
    -I$(top_srcdir)/modules/colpack/src/ColPack/src/BipartiteGraphBicoloring \
    -I$(top_srcdir)/modules/ast/includes/ast/ \
    -I$(top_srcdir)/modules/ast/includes/exps/ \
    -I$(top_srcdir)/modules/ast/includes/operations/ \
    -I$(top_srcdir)/modules/ast/includes/parse/ \
    -I$(top_srcdir)/modules/ast/includes/symbol/ \
    -I$(top_srcdir)/modules/ast/includes/system_env/ \
    -I$(top_srcdir)/modules/ast/includes/types/ \
    -I$(top_srcdir)/modules/ast/includes/analysis/ \
    -I$(top_srcdir)/modules/dynamic_link/includes \
    -I$(top_srcdir)/modules/localization/includes/ \
    -I$(top_srcdir)/modules/output_stream/includes/ \
    -I$(top_srcdir)/modules/api_scilab/includes/ \
    -I$(top_srcdir)/modules/console/includes/ \
    -I$(top_srcdir)/modules/threads/includes/ \
    -I$(top_srcdir)/modules/string/includes/ \
    -I$(top_srcdir)/modules/elementary_functions/includes/ \
    $(KLU_CFLAGS) \
    $(EIGEN_CPPFLAGS) \
    $(AM_CPPFLAGS)
    
SUNDIALS_SOURCES = src/patched_sundials/src/cvodes/cvodes.c \
    src/patched_sundials/src/cvodes/cvodes_direct.c \
    src/patched_sundials/src/cvodes/cvodes_io.c \
    src/patched_sundials/src/cvodes/cvodes_ls.c \
    src/patched_sundials/src/cvodes/cvodes_nls.c \
    src/patched_sundials/src/cvodes/cvodes_proj.c \
    src/patched_sundials/src/cvodes/cvodes_nls_sim.c \
    src/patched_sundials/src/cvodes/cvodes_nls_stg.c \
    src/patched_sundials/src/cvodes/cvodes_nls_stg1.c \
    src/patched_sundials/src/cvodes/cvodea.c \
    src/patched_sundials/src/cvodes/cvodea_io.c \
    src/patched_sundials/src/cvodes/cvodes_bandpre.c \
    src/patched_sundials/src/ida/ida.c \
    src/patched_sundials/src/ida/ida_direct.c \
    src/patched_sundials/src/ida/ida_ic.c \
    src/patched_sundials/src/ida/ida_io.c \
    src/patched_sundials/src/ida/ida_ls.c \
    src/patched_sundials/src/ida/ida_nls.c \
    src/patched_sundials/src/arkode/arkode.c \
    src/patched_sundials/src/arkode/arkode_io.c \
    src/patched_sundials/src/arkode/arkode_ls.c \
    src/patched_sundials/src/arkode/arkode_root.c \
    src/patched_sundials/src/arkode/arkode_interp.c \
    src/patched_sundials/src/arkode/arkode_adapt.c \
    src/patched_sundials/src/arkode/arkode_butcher.c \
    src/patched_sundials/src/arkode/arkode_butcher_erk.c \
    src/patched_sundials/src/arkode/arkode_butcher_dirk.c \
    src/patched_sundials/src/arkode/arkode_arkstep.c \
    src/patched_sundials/src/arkode/arkode_arkstep_io.c \
    src/patched_sundials/src/arkode/arkode_arkstep_nls.c \
    src/patched_sundials/src/arkode/arkode_bandpre.c \
    src/patched_sundials/src/kinsol/kinsol.c \
    src/patched_sundials/src/kinsol/kinsol_direct.c \
    src/patched_sundials/src/kinsol/kinsol_io.c \
    src/patched_sundials/src/kinsol/kinsol_ls.c \
    src/patched_sundials/src/nvector/serial/nvector_serial.c \
    src/patched_sundials/src/sunmatrix/dense/sunmatrix_dense.c \
    src/patched_sundials/src/sunmatrix/band/sunmatrix_band.c \
    src/patched_sundials/src/sunmatrix/sparse/sunmatrix_sparse.c \
    src/patched_sundials/src/sundials/sundials_context.c \
    src/patched_sundials/src/sundials/sundials_logger.c \
    src/patched_sundials/src/sundials/sundials_dense.c \
    src/patched_sundials/src/sundials/sundials_direct.c \
    src/patched_sundials/src/sundials/sundials_band.c \
    src/patched_sundials/src/sundials/sundials_math.c \
    src/patched_sundials/src/sundials/sundials_nvector.c \
    src/patched_sundials/src/sundials/sundials_memory.c \
    src/patched_sundials/src/sundials/sundials_matrix.c \
    src/patched_sundials/src/sundials/sundials_linearsolver.c \
    src/patched_sundials/src/sundials/sundials_iterative.c \
    src/patched_sundials/src/sundials/sundials_nonlinearsolver.c \
    src/patched_sundials/src/sundials/sundials_extension.c \
    src/patched_sundials/src/sundials/sundials_nvector_senswrapper.c \
    src/patched_sundials/src/sunlinsol/dense/sunlinsol_dense.c \
    src/patched_sundials/src/sunlinsol/lapackdense/sunlinsol_lapackdense.c \
    src/patched_sundials/src/sunlinsol/band/sunlinsol_band.c \
    src/patched_sundials/src/sunlinsol/lapackband/sunlinsol_lapackband.c \
    src/patched_sundials/src/sunlinsol/klu/sunlinsol_klu.c \
    src/patched_sundials/src/sunlinsol/pcg/sunlinsol_pcg.c \
    src/patched_sundials/src/sunlinsol/spbcgs/sunlinsol_spbcgs.c \
    src/patched_sundials/src/sunlinsol/spgmr/sunlinsol_spgmr.c \
    src/patched_sundials/src/sunlinsol/spfgmr/sunlinsol_spfgmr.c \
    src/patched_sundials/src/sunlinsol/sptfqmr/sunlinsol_sptfqmr.c \
    src/patched_sundials/src/sunnonlinsol/newton/sunnonlinsol_newton.c \
    src/patched_sundials/src/sunnonlinsol/fixedpoint/sunnonlinsol_fixedpoint.c

libscisundials_la_CFLAGS = -I$(top_srcdir)/modules/sundials/src/patched_sundials/include \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/cvode \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/ida \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/arkode \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/kinsol \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/nvec_ser \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/sundials \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/sunmatrix \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/sunlinsol \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/include/sunnonlinsol \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/src/cvode \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/src/ida \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/src/arkode \
    -I$(top_srcdir)/modules/sundials/src/patched_sundials/src/kinsol

pkglib_LTLIBRARIES = libscisundials.la
noinst_LTLIBRARIES = libscisundials-algo.la

libscisundials_algo_la_LDFLAGS = $(AM_LDFLAGS)
libscisundials_la_LDFLAGS = $(AM_LDFLAGS)

libscisundials_algo_la_SOURCES = $(SUNDIALS_C_SOURCES) $(SUNDIALS_CPP_SOURCES) $(SUNDIALS_SOURCES)
libscisundials_la_SOURCES = $(GATEWAY_CPP_SOURCES)
libscisundials_algo_la_CPPFLAGS = $(libscisundials_la_CPPFLAGS)

# For the code check (splint)
CHECK_SRC= $(SUNDIALS_CPP_SOURCES)
INCLUDE_FLAGS = $(libscisundials_la_CPPFLAGS)

libscisundials_la_LIBADD = libscisundials-algo.la \
        $(FLIBS)

# Needed for klu
libscisundials_la_LIBADD += $(KLU_LIB)

#### Target ######
modulename=sundials

#### sundials : Conf files ####
libscisundials_la_rootdir = $(mydatadir)
libscisundials_la_root_DATA =  license.txt

#### sundials : init scripts ####
libscisundials_la_etcdir = $(mydatadir)/etc
libscisundials_la_etc_DATA = etc/sundials.quit etc/sundials.start

#### sundials : include files ####
# find src/patched_sundials/include  -type f -name '*.h' -or -name '*.hxx' -or -name '*.hpp' | sort |xargs printf '%s \\\n'

libscisundials_arkode_la_includedir=$(pkgincludedir)/arkode/
libscisundials_arkode_la_include_HEADERS = \
src/patched_sundials/include/arkode/arkode.h \
src/patched_sundials/include/arkode/arkode_arkstep.h \
src/patched_sundials/include/arkode/arkode_bandpre.h \
src/patched_sundials/include/arkode/arkode_bbdpre.h \
src/patched_sundials/include/arkode/arkode_butcher.h \
src/patched_sundials/include/arkode/arkode_butcher_dirk.h \
src/patched_sundials/include/arkode/arkode_butcher_erk.h \
src/patched_sundials/include/arkode/arkode_erkstep.h \
src/patched_sundials/include/arkode/arkode_ls.h \
src/patched_sundials/include/arkode/arkode_mristep.h \
src/patched_sundials/include/arkode/arkode_xbraid.h

libscisundials_cvode_la_includedir=$(pkgincludedir)/cvode/
libscisundials_cvode_la_include_HEADERS = \
src/patched_sundials/include/cvode/cvode.h \
src/patched_sundials/include/cvode/cvode_direct.h \
src/patched_sundials/include/cvode/cvode_ls.h \
src/patched_sundials/include/cvode/cvode_proj.h \
src/patched_sundials/include/cvode/cvode_spils.h \
src/patched_sundials/include/cvodes/cvodes.h \
src/patched_sundials/include/cvodes/cvodes_direct.h \
src/patched_sundials/include/cvodes/cvodes_ls.h

libscisundials_ida_la_includedir=$(pkgincludedir)/ida/
libscisundials_ida_la_include_HEADERS = \
src/patched_sundials/include/ida/ida.h \
src/patched_sundials/include/ida/ida_bbdpre.h \
src/patched_sundials/include/ida/ida_direct.h \
src/patched_sundials/include/ida/ida_ls.h \
src/patched_sundials/include/ida/ida_spils.h

libscisundials_kinsol_la_includedir=$(pkgincludedir)/kinsol/
libscisundials_kinsol_la_include_HEADERS = \
src/patched_sundials/include/kinsol/kinsol.h \
src/patched_sundials/include/kinsol/kinsol_bbdpre.h \
src/patched_sundials/include/kinsol/kinsol_direct.h \
src/patched_sundials/include/kinsol/kinsol_ls.h \
src/patched_sundials/include/kinsol/kinsol_spils.h

libscisundials_nvector_la_includedir=$(pkgincludedir)/nvector/
libscisundials_nvector_la_include_HEADERS = \
src/patched_sundials/include/nvector/nvector_serial.h

libscisundials_sundials_la_includedir=$(pkgincludedir)/sundials/
libscisundials_sundials_la_include_HEADERS = \
src/patched_sundials/include/sundials/sundials_band.h \
src/patched_sundials/include/sundials/sundials_config.h \
src/patched_sundials/include/sundials/sundials_dense.h \
src/patched_sundials/include/sundials/sundials_direct.h \
src/patched_sundials/include/sundials/sundials_export.h \
src/patched_sundials/include/sundials/sundials_extension.h \
src/patched_sundials/include/sundials/sundials_iterative.h \
src/patched_sundials/include/sundials/sundials_lapack.h \
src/patched_sundials/include/sundials/sundials_linearsolver.h \
src/patched_sundials/include/sundials/sundials_math.h \
src/patched_sundials/include/sundials/sundials_matrix.h \
src/patched_sundials/include/sundials/sundials_memory.h \
src/patched_sundials/include/sundials/sundials_nonlinearsolver.h \
src/patched_sundials/include/sundials/sundials_nvector.h \
src/patched_sundials/include/sundials/sundials_nvector_senswrapper.h \
src/patched_sundials/include/sundials/sundials_types.h \
src/patched_sundials/include/sundials/sundials_version.h

libscisundials_sunlinsol_la_includedir=$(pkgincludedir)/sunlinsol/
libscisundials_sunlinsol_la_include_HEADERS = \
src/patched_sundials/include/sunlinsol/sunlinsol_band.h \
src/patched_sundials/include/sunlinsol/sunlinsol_dense.h \
src/patched_sundials/include/sunlinsol/sunlinsol_klu.h \
src/patched_sundials/include/sunlinsol/sunlinsol_lapackband.h \
src/patched_sundials/include/sunlinsol/sunlinsol_lapackdense.h

libscisundials_sunmatrix_la_includedir=$(pkgincludedir)/sunmatrix/
libscisundials_sunmatrix_la_include_HEADERS = \
src/patched_sundials/include/sunmatrix/sunmatrix_band.h \
src/patched_sundials/include/sunmatrix/sunmatrix_dense.h \
src/patched_sundials/include/sunmatrix/sunmatrix_sparse.h

libscisundials_sunnonlinsol_la_includedir=$(pkgincludedir)/sunnonlinsol/
libscisundials_sunnonlinsol_la_include_HEADERS = \
src/patched_sundials/include/sunnonlinsol/sunnonlinsol_fixedpoint.h \
src/patched_sundials/include/sunnonlinsol/sunnonlinsol_newton.h

#### sundials : gateway declaration ####
libscisundials_la_sci_gatewaydir = $(mydatadir)/sci_gateway
libscisundials_la_sci_gateway_DATA = sci_gateway/sundials_gateway.xml

include $(top_srcdir)/Makefile.incl.am

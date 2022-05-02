# Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
# Copyright (C) 2022 - Stéphane MOTTELET
#
# This file is distributed under the same license as the Scilab package.

COLPACK_CPP_SOURCES = \
    src/ColPack/src/Utilities/CoutLock.cpp \
    src/ColPack/src/Utilities/DisjointSets.cpp \
    src/ColPack/src/Utilities/File.cpp \
    src/ColPack/src/Utilities/MatrixDeallocation.cpp \
    src/ColPack/src/Utilities/Pause.cpp \
    src/ColPack/src/Utilities/StringTokenizer.cpp \
    src/ColPack/src/Utilities/Timer.cpp \
    src/ColPack/src/Utilities/command_line_parameter_processor.cpp \
    src/ColPack/src/Utilities/current_time.cpp \
    src/ColPack/src/Utilities/extra.cpp \
    src/ColPack/src/Utilities/mmio.cpp \
    src/ColPack/src/Utilities/stat.cpp \
    src/ColPack/src/BipartiteGraphBicoloring/BipartiteGraphBicoloring.cpp \
    src/ColPack/src/BipartiteGraphBicoloring/BipartiteGraphBicoloringInterface.cpp \
    src/ColPack/src/BipartiteGraphBicoloring/BipartiteGraphCore.cpp \
    src/ColPack/src/BipartiteGraphBicoloring/BipartiteGraphInputOutput.cpp \
    src/ColPack/src/BipartiteGraphBicoloring/BipartiteGraphOrdering.cpp \
    src/ColPack/src/BipartiteGraphBicoloring/BipartiteGraphVertexCover.cpp \
    src/ColPack/src/BipartiteGraphPartialColoring/BipartiteGraphPartialColoring.cpp \
    src/ColPack/src/BipartiteGraphPartialColoring/BipartiteGraphPartialColoringInterface.cpp \
    src/ColPack/src/BipartiteGraphPartialColoring/BipartiteGraphPartialOrdering.cpp \
    src/ColPack/src/GeneralGraphColoring/GraphColoring.cpp \
    src/ColPack/src/GeneralGraphColoring/GraphColoringInterface.cpp \
    src/ColPack/src/GeneralGraphColoring/GraphCore.cpp \
    src/ColPack/src/GeneralGraphColoring/GraphInputOutput.cpp \
    src/ColPack/src/GeneralGraphColoring/GraphOrdering.cpp \
    src/ColPack/src/Recovery/HessianRecovery.cpp \
    src/ColPack/src/Recovery/JacobianRecovery1D.cpp \
    src/ColPack/src/Recovery/JacobianRecovery2D.cpp \
    src/ColPack/src/Recovery/RecoveryCore.cpp \
    src/cpp/spCompGeneric.cpp \
    src/cpp/spCompJacobian.cpp \
    src/cpp/spCompHessian.cpp

GATEWAY_CPP_SOURCES = \
    sci_gateway/cpp/sci_percent_spCompGeneric_clear.cpp \
    sci_gateway/cpp/sci_percent_spCompGeneric_e.cpp \
    sci_gateway/cpp/sci_spCompHessian.cpp \
    sci_gateway/cpp/sci_spCompJacobian.cpp

libscicolpack_la_CPPFLAGS= \
    -I$(srcdir)/includes/ \
    -I$(srcdir)/src/cpp/ \
    -I$(srcdir)/src/ColPack/include/ \
    -I$(srcdir)/src/ColPack/src/Utilities/ \
    -I$(srcdir)/src/ColPack/src/Recovery/ \
    -I$(srcdir)/src/ColPack/src/GeneralGraphColoring \
    -I$(srcdir)/src/ColPack/src/BipartiteGraphPartialColoring \
    -I$(srcdir)/src/ColPack/src/BipartiteGraphBicoloring \
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
    $(EIGEN_CPPFLAGS) \
    $(AM_CPPFLAGS)

pkglib_LTLIBRARIES = libscicolpack.la
noinst_LTLIBRARIES = libscicolpack-algo.la

libscicolpack_algo_la_LDFLAGS = $(AM_LDFLAGS)
libscicolpack_la_LDFLAGS = $(AM_LDFLAGS)

libscicolpack_algo_la_SOURCES = $(COLPACK_CPP_SOURCES) $(COLPACK_SOURCES)
libscicolpack_la_SOURCES = $(GATEWAY_CPP_SOURCES)
libscicolpack_algo_la_CPPFLAGS = $(libscicolpack_la_CPPFLAGS)

# For the code check (splint)
CHECK_SRC= $(COLPACK_CPP_SOURCES)
INCLUDE_FLAGS = $(libscicolpack_la_CPPFLAGS)

libscicolpack_la_LIBADD = libscicolpack-algo.la \
        $(FLIBS)

#### Target ######
modulename=colpack

#### colpack : Conf files ####
libscicolpack_la_rootdir = $(mydatadir)
libscicolpack_la_root_DATA =  license.txt

#### colpack : init scripts ####
libscicolpack_la_etcdir = $(mydatadir)/etc
libscicolpack_la_etc_DATA = etc/colpack.quit etc/colpack.start

#### colpack : gateway declaration ####
libscicolpack_la_sci_gatewaydir = $(mydatadir)/sci_gateway
libscicolpack_la_sci_gateway_DATA = sci_gateway/colpack_gateway.xml

include $(top_srcdir)/Makefile.incl.am

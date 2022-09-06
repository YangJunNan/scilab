#!/bin/sh

set -e

svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/trunk/Dev-Tools/SE/Prerequirements/linux_x64/ scilab

# configure & make
cd scilab
./configure --prefix=''
make -j
make install DESTDIR=scilab-branch-"${CI_COMMIT_REF_NAME}"-"${CI_COMMIT_TIMESTAMP}"

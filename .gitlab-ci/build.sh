#!/bin/sh

svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/trunk/Dev-Tools/SE/Prerequirements/linux_x64/ scilab

# configure & make
cd scilab
./configure --prefix=''
# use silent to avoid hitting the log limit
make --silent --jobs >/dev/null
make --silent install DESTDIR=scilab-branch-"${CI_COMMIT_REF_NAME}"-"${CI_COMMIT_TIMESTAMP}"  >/dev/null

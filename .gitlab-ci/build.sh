#!/bin/sh

svn checkout \
    --username anonymous --password Scilab \
    svn://svn.scilab.org/scilab/trunk/Dev-Tools/SE/Prerequirements/linux_x64/ scilab \
    |tee -a log.txt |tail --lines=1

# configure & make
cd scilab
./configure --prefix='' |tee -a log.txt
# use silent to avoid hitting the log limit
make --jobs |tee -a log.txt |tail --lines=50
make install DESTDIR=scilab-branch-"${CI_COMMIT_REF_NAME}"-"${CI_COMMIT_TIMESTAMP}" |tee -a log.txt |tail --lines=10

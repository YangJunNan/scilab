#!/bin/sh

# log all commands to to avoid hitting Gitlab log limit

svn checkout \
    --username anonymous --password Scilab \
    svn://svn.scilab.org/scilab/trunk/Dev-Tools/SE/Prerequirements/linux_x64/ scilab \
    |tee -a log.txt |tail --lines=1

# configure & make
cd scilab ||exit
./configure --prefix='' |tee -a ../log.txt
# nproc jobs limits memory usage
make --jobs="$(nproc)" |tee -a ../log.txt |tail --lines=50
make install DESTDIR=scilab-branch-"${CI_COMMIT_REF_NAME}"-"${CI_COMMIT_TIMESTAMP}" |tee -a ../log.txt |tail --lines=10

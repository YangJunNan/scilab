#!/bin/env bash

# NOTE: log all commands to log.txt to avoid hitting Gitlab log limit
# NOTE: nproc is used to limit memory usage

# get current build machine architecture
ARCH=$(cc -dumpmachine)

# checkout pre-requirements
svn checkout \
    --username anonymous --password Scilab \
    "svn://svn.scilab.org/scilab/${PREREQUIREMENTS_BRANCH}/Dev-Tools/SE/Prerequirements/linux_x64/" scilab \
    >log_svn.txt ||(tail --lines=100 log_svn.txt; exit 1)
# display svn revision
tail -n 1 log_svn.txt
# revert local modification
svn revert -R scilab >>log_svn.txt

# define NOW as Gitlab display ISO 8601 timestamp
date +"%s" >timestamp
NOW=$(cat timestamp)
# patch version numbers
sed -i \
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"scilab-branch-${CI_COMMIT_BRANCH}\"/" \
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"scilab-branch-${CI_COMMIT_BRANCH}\"/" \
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"${CI_COMMIT_SHA}\"/" \
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP ${NOW}/" \
 scilab/modules/core/includes/version.h.in

# predefined env
LD_LIBRARY_PATH=$(pwd)/usr/lib/ && export LD_LIBRARY_PATH
DISPLAY=:0.0 && export DISPLAY

# FIXME: workaround to only have minimal dependencies set
# otherwise, libcurl will require libopenssl which will likely be system dependent
export SCILIBS_LDFLAGS="-Wl,--allow-shlib-undefined"

# configure (with reconfigure for up to date info)
cd scilab ||exit 1
aclocal >../log.txt
autoconf >>../log.txt
automake >>../log.txt
./configure --prefix='' |tee -a ../log.txt

# make 
make --jobs="$(nproc)" all &>>../log.txt ||(tail --lines=100 ../log.txt; exit 1)
make doc &>../log_doc.txt ||(tail --lines=100 ../log_doc.txt; exit 1)

# install to tmpdir
make install DESTDIR="${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}" &>>../log_install.txt ||(tail --lines=100 ../log_install.txt; exit 1)

# copy extra files
cp -a ACKNOWLEDGEMENTS "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/"
cp -a CHANGES.md "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/"
cp -a COPYING "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/"
cp -a README.md "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/"

# copy thirdparties
cp -a lib/thirdparty "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/lib/"
cp -a thirdparty "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/"
cp -a java/jdk*-jre "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/thirdparty/java"

# Update the classpath
sed -i "s#$(pwd)#\$SCILAB/../../#g" "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/share/scilab/etc/classpath.xml"

# Update the rpath and ELF NEEDED
cd "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/" ||exit
patchelf --set-rpath '$ORIGIN:$ORIGIN/../lib/scilab:$ORIGIN/../lib/thirdparty:$ORIGIN/../lib/thirdparty/redist' \
					bin/scilab-cli-bin bin/scilab-bin
find lib/scilab/*.so* -type f -exec patchelf --set-rpath '$ORIGIN:$ORIGIN/../thirdparty:$ORIGIN/../thirdparty/redist' {} \;
readelf -d bin/scilab-cli-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab-cli.so"}' |sh -
readelf -d bin/scilab-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab.so"}' |sh -
cd "${CI_PROJECT_DIR}" ||exit

# package as a tar gz file
tar -czf "scilab-branch-${CI_COMMIT_BRANCH}-${NOW}.bin.${ARCH}.tar.gz" -C "${CI_PROJECT_DIR}" "scilab-branch-${CI_COMMIT_BRANCH}-${NOW}"
rm -fr "${CI_PROJECT_DIR}/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}"

#!/bin/env bash

# NOTE: log all commands to log.txt to avoid hitting Gitlab log limit
# NOTE: nproc is used to limit memory usage

# checkout pre-requirements
svn checkout \
    --username anonymous --password Scilab \
    "svn://svn.scilab.org/scilab/${PREREQUIREMENTS_BRANCH}/Dev-Tools/SE/Prerequirements/linux_x64/" scilab \
    >log.txt ||(tail --lines=100 log.txt; exit 1)
# display svn revision
tail -n 1 log.txt
# revert local modification
svn revert -R scilab >>log.txt

# patch version numbers
date +"%s" >timestamp
NOW=$(cat timestamp)
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
aclocal >>../log.txt
autoconf >>../log.txt
automake >>../log.txt
./configure --prefix='' |tee -a ../log.txt

# make 
make --jobs="$(nproc)" all &>>../log.txt ||(tail --lines=100 ../log.txt; exit 1)

# install to tmpdir
make install DESTDIR="/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}" &>>../log.txt ||(tail --lines=100 ../log.txt; exit 1)

# copy thirdparties
cp -a lib/thirdparty "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/lib/"
cp -a thirdparty "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/"
mkdir --parents "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/thirdparty/java/"
cp -a java/jre "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/thirdparty/java/"
cp -a lib/thirdparty/libgluegen2-rt.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/bin/"
cp -a lib/thirdparty/libnativewindow_awt.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/bin/"
cp -a lib/thirdparty/libnativewindow_x11.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/bin/"
cp -a lib/thirdparty/libnativewindow_x11.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/bin/"

# Update the classpath
sed -i "s#$(pwd)#\$SCILAB/../../#g" "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/share/scilab/etc/classpath.xml"

# Update the rpath and ELF NEEDED
cd "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}/" ||exit
patchelf --set-rpath '$ORIGIN:$ORIGIN/../lib/scilab:$ORIGIN/../lib/thirdparty:$ORIGIN/../lib/thirdparty/redist' \
					bin/scilab-cli-bin bin/scilab-bin
find lib/scilab/*.so* -type f -exec patchelf --set-rpath '$ORIGIN:$ORIGIN/../thirdparty:$ORIGIN/../thirdparty/redist' {} \;
readelf -d bin/scilab-cli-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab-cli.so"}' |sh -
readelf -d bin/scilab-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab.so"}' |sh -
cd "${CI_PROJECT_DIR}" ||exit

# package as a tar gz file
tar -czf "scilab-branch-${CI_COMMIT_BRANCH}-${NOW}.tar.gz" -C /tmp "scilab-branch-${CI_COMMIT_BRANCH}-${NOW}"
rm -fr "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${NOW}"
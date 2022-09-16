#!/bin/env bash

# NOTE: log all commands to log.txt to avoid hitting Gitlab log limit
# NOTE: nproc is used to limit memory usage

# Remove install dir older than 3 days and TMPDIRs older than 1 day
find "/tmp/scilab-branch*" -maxdepth 1 -mtime +2 -print0 |\
while IFS= read -r -d '' i ; do
  chmod -R +w "$i" && rm -rf "$i";
done
find /tmp -maxdepth 1 -mtime +0 -name "SCI_TMP*" -type d |\
while IFS= read -r -d '' i ; do
  [ -w "$i" ] && rm -rf "$i";
done

# checkout pre-requirements
svn checkout \
    --username anonymous --password Scilab \
    "svn://svn.scilab.org/scilab/${PREREQUIREMENTS_BRANCH}/Dev-Tools/SE/Prerequirements/linux_x64/" scilab \
    >log.txt ||(tail --lines=100 log.txt; exit 1)

# patch version numbers
date +"%s" >timestamp
NOW=$(cat timestamp)
sed -i \
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"scilab-branch-${CI_COMMIT_BRANCH}\"/" \
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"scilab-branch-${CI_COMMIT_BRANCH}\"/" \
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"${CI_COMMIT_SHA}\"/" \
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP ${NOW}/" \
 modules/core/includes/version.h.in

# predefined env
LD_LIBRARY_PATH=$(pwd)/usr/lib/ && export LD_LIBRARY_PATH
DISPLAY=:0.0 && export DISPLAY

# configure
cd scilab ||exit 1
./configure --prefix='' |tee -a ../log.txt

# make 
make --jobs="$(nproc)" &>>../log.txt ||(tail --lines=100 ../log.txt; exit 1)

# install to tmpdir
make install DESTDIR="/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}" &>>../log.txt ||(tail --lines=100 ../log.txt; exit 1)

# copy thirdparties
cp -a lib/thirdparty "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/lib/"
cp -a thirdparty "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/"
cp -a java/jre "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/thirdparty/java/"
cp -a lib/thirdparty/libgluegen2-rt.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/bin/"
cp -a lib/thirdparty/libnativewindow_awt.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/bin/"
cp -a lib/thirdparty/libnativewindow_x11.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/bin/"
cp -a lib/thirdparty/libnativewindow_x11.so "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/bin/"

# Update the classpath
sed -i "s#$(pwd)#\$SCILAB/../../#g" "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/share/scilab/etc/classpath.xml"

# Update the rpath and ELF NEEDED
cd "/tmp/scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}/" ||exit
patchelf --set-rpath '$ORIGIN:$ORIGIN/../lib/scilab:$ORIGIN/../lib/thirdparty:$ORIGIN/../lib/thirdparty/redist' \
					bin/scilab-cli-bin bin/scilab-bin
find lib/scilab/*.so* -type f -exec patchelf --set-rpath '$ORIGIN:$ORIGIN/../thirdparty:$ORIGIN/../thirdparty/redist' {} \;
readelf -d bin/scilab-cli-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab-cli.so"}' |sh -
readelf -d bin/scilab-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab.so"}' |sh -
cd "${CI_PROJECT_DIR}" ||exit

# package as a tar gz file
tar -xzf "scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}.tar.gz" -C /tmp "scilab-branch-${CI_COMMIT_BRANCH}-${CI_COMMIT_TIMESTAMP}"

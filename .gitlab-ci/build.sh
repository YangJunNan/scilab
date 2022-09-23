#!/bin/env bash
# Builder script for building linux version
#
# NOTE: log all commands to log.txt to avoid hitting Gitlab log limit
# NOTE: nproc is used to limit memory usage

# checkout pre-requirements
svn checkout \
    --username anonymous --password Scilab \
    "svn://svn.scilab.org/scilab/${PREREQUIREMENTS_BRANCH}/Dev-Tools/SE/Prerequirements/linux_x64/" scilab \
    >log_svn.txt ||(tail --lines=100 log_svn.txt; exit 1)
# display svn revision
tail -n 1 log_svn.txt
# revert local modification
svn revert -R scilab >>log_svn.txt

# patch version numbers
sed -i \
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"${SCI_VERSION_STRING}\"/" \
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"${SCI_VERSION_STRING}\"/" \
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"${CI_COMMIT_SHA}\"/" \
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP ${SCI_VERSION_TIMESTAMP}/" \
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
make install DESTDIR="${CI_PROJECT_DIR}/${SCI_VERSION_STRING}" &>>../log_install.txt ||(tail --lines=100 ../log_install.txt; exit 1)

# copy extra files
cp -a ACKNOWLEDGEMENTS "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/"
cp -a CHANGES.md "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/"
cp -a COPYING "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/"
cp -a README.md "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/"

# copy thirdparties
cp -a lib/thirdparty "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/lib/"
cp -a thirdparty "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/"
cp -a java/jdk*-jre "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/thirdparty/java"

# Update the classpath
sed -i "s#$(pwd)#\$SCILAB/../../#g" "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/share/scilab/etc/classpath.xml"

# Update the rpath and ELF NEEDED
cd "${CI_PROJECT_DIR}/${SCI_VERSION_STRING}/" ||exit
patchelf --set-rpath '$ORIGIN:$ORIGIN/../lib/scilab:$ORIGIN/../lib/thirdparty:$ORIGIN/../lib/thirdparty/redist' \
					bin/scilab-cli-bin bin/scilab-bin
find lib/scilab/*.so* -type f -exec patchelf --set-rpath '$ORIGIN:$ORIGIN/../thirdparty:$ORIGIN/../thirdparty/redist' {} \;
readelf -d bin/scilab-cli-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab-cli.so"}' |sh -
readelf -d bin/scilab-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab.so"}' |sh -
cd "${CI_PROJECT_DIR}" ||exit

# package as a tar gz file
tar -czf "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz" -C "${CI_PROJECT_DIR}" "${SCI_VERSION_STRING}"
rm -fr "${CI_PROJECT_DIR}/${SCI_VERSION_STRING:?}"

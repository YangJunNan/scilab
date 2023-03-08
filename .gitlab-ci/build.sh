#!/usr/bin/env bash
#
# Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
# Copyright (C) Dassault Systemes - 2022 - Clement DAVID
#
#
# Builder script for building linux version.
#
# NOTE: log all commands to log.txt to avoid hitting Gitlab log limit
# NOTE: nproc is used to limit memory usage

LOG_PATH=$SCI_VERSION_STRING
[ ! -d "$LOG_PATH" ] && mkdir "$LOG_PATH"

# checkout pre-requirements
echo -e "\e[0Ksection_start:$(date +%s):prerequirements\r\e[0KGetting prerequirements"
curl -k -z prereq.tar.xz -o prereq.tar.xz https://oos.eu-west-2.outscale.com/scilab-releases-dev/prerequirements/prerequirements-scilab-${PREREQUIREMENTS_BRANCH}-linux_x64.tar.xz
tar -xvf prereq.tar.xz -C scilab > ${LOG_PATH}/log_prereq_${CI_COMMIT_SHORT_SHA}.txt
# display svn revision
cat scilab/svn-info.txt || exit 1
echo -e "\e[0Ksection_end:$(date +%s):prerequirements\r\e[0K"

# patch version numbers
sed -i \
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"${SCI_VERSION_STRING}\"/" \
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"${SCI_VERSION_STRING}\"/" \
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"${CI_COMMIT_SHA}\"/" \
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP ${SCI_VERSION_TIMESTAMP}/" \
 scilab/modules/core/includes/version.h.in
echo SCIVERSION=${SCI_VERSION_STRING} >scilab/Version.incl


# predefined env
LD_LIBRARY_PATH=$(pwd)/usr/lib/ && export LD_LIBRARY_PATH
DISPLAY=:0.0 && export DISPLAY

# FIXME: workaround to only have minimal dependencies set
# otherwise, libcurl will require libopenssl which will likely be system dependent
export SCILIBS_LDFLAGS="-Wl,--allow-shlib-undefined"

# configure (with reconfigure for up to date info)
echo -e "\e[0Ksection_start:$(date +%s):configure[collapsed=true]\r\e[0KConfigure"
cd scilab ||exit 1
aclocal  >  ../${LOG_PATH}/log_autoreconf_${CI_COMMIT_SHORT_SHA}.txt
autoconf >> ../${LOG_PATH}/log_autoreconf_${CI_COMMIT_SHORT_SHA}.txt
automake >> ../${LOG_PATH}/log_autoreconf_${CI_COMMIT_SHORT_SHA}.txt
./configure --prefix='' |tee -a ../${LOG_PATH}/log_configure_${CI_COMMIT_SHORT_SHA}.txt
echo -e "\e[0Ksection_end:$(date +%s):configure\r\e[0K"

# make 
echo -e "\e[0Ksection_start:$(date +%s):make\r\e[0KMake"
make --jobs="$(nproc)" all &>>../${LOG_PATH}/log_build_${CI_COMMIT_SHORT_SHA}.txt ||(tail --lines=100 ../${LOG_PATH}/log_build_${CI_COMMIT_SHORT_SHA}.txt; exit 1)
make doc &>../${LOG_PATH}/log_doc_${CI_COMMIT_SHORT_SHA}.txt ||(tail --lines=100 ../$LOG_PATH/log_doc_${CI_COMMIT_SHORT_SHA}.txt; exit 1)
echo -e "\e[0Ksection_end:$(date +%s):make\r\e[0K"

# install to tmpdir
echo -e "\e[0Ksection_start:$(date +%s):install\r\e[0KInstall"
make install DESTDIR="/${SCI_VERSION_STRING}" &>>../${LOG_PATH}/log_install_${CI_COMMIT_SHORT_SHA}.txt ||(tail --lines=100 ../$LOG_PATH/log_install_${CI_COMMIT_SHORT_SHA}.txt; exit 1)
echo -e "\e[0Ksection_end:$(date +%s):install\r\e[0K"

echo -e "\e[0Ksection_start:$(date +%s):patch[collapsed=true]\r\e[0KPatch binary"
# copy extra files
cp -a ACKNOWLEDGEMENTS "/${SCI_VERSION_STRING}/"
cp -a CHANGES.md "/${SCI_VERSION_STRING}/"
cp -a COPYING "/${SCI_VERSION_STRING}/"
cp -a README.md "/${SCI_VERSION_STRING}/"

# copy thirdparties
cp -a lib/thirdparty "/${SCI_VERSION_STRING}/lib/"
cp -a thirdparty "/${SCI_VERSION_STRING}/"
cp -a java/jdk*-jre "/${SCI_VERSION_STRING}/thirdparty/java"

# Update the classpath
sed -i "s#$(pwd)#\$SCILAB/../../#g" "/${SCI_VERSION_STRING}/share/scilab/etc/classpath.xml"

# Update the rpath and ELF NEEDED
cd "/${SCI_VERSION_STRING}/" ||exit
patchelf --set-rpath '$ORIGIN:$ORIGIN/../lib/scilab:$ORIGIN/../lib/thirdparty:$ORIGIN/../lib/thirdparty/redist' \
					bin/scilab-cli-bin bin/scilab-bin
find lib/scilab/*.so* -type f -exec patchelf --set-rpath '$ORIGIN:$ORIGIN/../thirdparty:$ORIGIN/../thirdparty/redist' {} \;
readelf -d bin/scilab-cli-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab-cli.so"}' |sh -
readelf -d bin/scilab-bin |awk '/NEEDED/{gsub(/\[/,""); gsub(/\]/,""); print "patchelf --add-needed "$NF" lib/scilab/libscilab.so"}' |sh -
cd "${CI_PROJECT_DIR}" ||exit

echo -e "\e[0Ksection_end:$(date +%s):patch\r\e[0K"

# package as a tar xz file
echo -e "\e[0Ksection_start:$(date +%s):package\r\e[0KPackage"
tar -cJf "${SCI_VERSION_STRING}.bin.${ARCH}.tar.xz" -C "/" "${SCI_VERSION_STRING}"
echo -e "\e[0Ksection_end:$(date +%s):package\r\e[0K"

# error if artifact does not exist
du -h "${SCI_VERSION_STRING}.bin.${ARCH}.tar.xz"

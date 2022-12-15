#!/usr/bin/env bash
#
# Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
# Copyright (C) Dassault Systemes - 2022 - Clement DAVID
#
#
# Execute module tests for a module name ${TEST}, download and install
# latest build if needed.
#

# install if not exist
echo -e "\e[0Ksection_start:$(date +%s):install\r\e[0KInstall Scilab binary"
if [ ! -d "../../${SCI_VERSION_STRING}" ]; then
    tar -xJf "../../${SCI_VERSION_STRING}.bin.${ARCH}.tar.xz"
fi
[ ! -d "../../${SCI_VERSION_STRING}" ] && exit 1
echo -e "\e[0Ksection_end:$(date +%s):install\r\e[0K"

LOG_PATH=logs_$CI_COMMIT_SHORT_SHA
[ ! -d "$LOG_PATH" ] && mkdir "$LOG_PATH"

SCIHOME=$(mktemp --tmpdir ../../ -d SCI_TMP_HOME_XXXXXXX)

echo -e "\e[0Ksection_start:$(date +%s):test\r\e[0KTesting $TEST"
"../../${SCI_VERSION_STRING}/bin/scilab" -nwni -scihome "$SCIHOME" -quit -e 'test_run("'"${TEST}"'",[],[],"'"${LOG_PATH}/${ARCH}_${TEST}.xml"'")'
echo -e "\e[0Ksection_end:$(date +%s):test\r\e[0K"

rm -fr "${SCIHOME}"

# fail without xml report
[ ! -f "${LOG_PATH}/${ARCH}_${TEST}.xml" ] && exit 1

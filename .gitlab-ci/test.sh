#!/usr/bin/env bash
#
# Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
# Copyright (C) Dassault Systemes - 2022 - Clement DAVID
# Copyright (C) Dassault Systemes - 2023 - Cedric DELAMARRE
#
#
# Execute module tests for a module name ${TEST}, download and install
# latest build if needed.
#

# install
echo -e "\e[0Ksection_start:$(date +%s):install\r\e[0KInstall Scilab binary"
tar -xJf "${SCI_VERSION_STRING}.bin.${ARCH}.tar.xz" -C /

echo -e "\e[0Ksection_end:$(date +%s):install\r\e[0K"

LOG_PATH=logs_$CI_COMMIT_SHORT_SHA
[ ! -d "$LOG_PATH" ] && mkdir "$LOG_PATH"

echo -e "\e[0Ksection_start:$(date +%s):test\r\e[0KTesting $TEST"
"/${SCI_VERSION_STRING}/bin/scilab" -nwni -quit -e 'test_run("'"${TEST}"'",[],[],"'"${LOG_PATH}/${ARCH}_${TEST}.xml"'")'
echo -e "\e[0Ksection_end:$(date +%s):test\r\e[0K"

# fail without xml report
du -h "${LOG_PATH}/${ARCH}_${TEST}.xml"

#!/bin/env bash
# Execute module tests for a module name ${TEST}, download and install latest build if needed

# always install
tar -xJf "${SCI_VERSION_STRING}.bin.${ARCH}tar.xz"

SCIHOME=$(mktemp --tmpdir -d SCI_TMP_HOME_XXXXXXX)

"${SCI_VERSION_STRING}/bin/scilab" -nwni -scihome "$SCIHOME" -quit -e 'test_run("'"${TEST}"'",[],[],"'"${TEST}.xml"'")'

rm -fr "${SCIHOME}"

#!/bin/env bash
# Execute module tests for a module name ${TEST}, download and install latest build if needed

# Download if needed, install if needed
if [ ! -f "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz" ]; then
    curl --output "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz" --location --header "PRIVATE-TOKEN: $CI_JOB_TOKEN" \
        "https://gitlab.com/${CI_PROJECT_NAMESPACE}/${CI_PROJECT_NAME}/jobs/artifacts/${CI_COMMIT_REF_NAME}/raw/${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz?job=${ARCH}_build_branch";
fi
if [ ! -d "${SCI_VERSION_STRING}" ]; then
    tar -xzf "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz"
fi

SCIHOME=$(mktemp --tmpdir -d SCI_TMP_HOME_XXXXXXX)

"${SCI_VERSION_STRING}/bin/scilab" -nwni -scihome "$SCIHOME" -quit -e 'test_run("'"${TEST}"'",[],[],"'"${TEST}.xml"'")'

rm -fr "${SCIHOME}"

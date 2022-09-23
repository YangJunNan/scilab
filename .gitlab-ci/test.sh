#!/bin/env bash
# Execute module tests for a module name ${TEST}, download and install latest build if needed

# Download if needed, install if needed
if [ ! -d "${SCI_VERSION_STRING}" ]; then
    if [ ! -f "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz" ]; then
        curl --output "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz" --header "JOB-TOKEN: $CI_JOB_TOKEN" \
            "https://gitlab.com/${CI_PROJECT_NAMESPACE}/${CI_PROJECT_NAME}/builds/artifacts/${CI_COMMIT_REF_NAME}/raw/${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz?job=build_${ARCH}_branch";
    fi
    tar -xzf "${SCI_VERSION_STRING}.bin.${ARCH}.tar.gz"
fi

"${SCI_VERSION_STRING}/bin/scilab" -nwni -quit -e 'test_run("'"${TEST}"'",[],[],"'"${TEST}.xml"'")'

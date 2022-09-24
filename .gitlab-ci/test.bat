REM Execute module test for a module named %TEST%, download and install latest build if needed

REM Download if needed, install if needed
if exist "%SCI_VERSION_STRING%"\ goto :test
if exist "%SCI_VERSION_STRING%_%ARCH%.exe" goto :install

:download
curl --output "%SCI_VERSION_STRING%_%ARCH%.exe" --header "JOB-TOKEN: $CI_JOB_TOKEN" \
            "https://gitlab.com/${CI_PROJECT_NAMESPACE}/${CI_PROJECT_NAME}/builds/artifacts/${CI_COMMIT_REF_NAME}/raw/%SCI_VERSION_STRING%_%ARCH%.exe?job=build_%ARCH%_windows_branch";

:install
.\%SCI_VERSION_STRING%_%ARCH%.exe /SUPPRESSMSGBOXES /SILENT /SP- /DIR=%SCI_VERSION_STRING%

:test
.\%SCI_VERSION_STRING%\bin\scilab -nwni -quit -e 'test_run("'%TEST%'",[],[],"'%TEST%.xml'")'

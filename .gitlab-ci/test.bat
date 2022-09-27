REM Execute module test for a module named %TEST%, download and install latest build if needed

echo on
REM Always install
"%CI_PROJECT_DIR%\%SCI_VERSION_STRING%_%ARCH%.exe" /SUPPRESSMSGBOXES /SILENT /SP- /DIR="%CI_PROJECT_DIR%\%SCI_VERSION_STRING%"
dir "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%"

@echo on
setlocal EnableExtensions

rem get unique SCIHOME 
:uniqLoop
set "SCIHOME=%tmp%\SCI_TMP_HOME~%RANDOM%"
if exist -d "%SCIHOME%\" goto :uniqLoop
mkdir "%SCIHOME%"

call %CI_PROJECT_DIR%\%SCI_VERSION_STRING%\bin\scilab.bat -nwni -scihome "%SCIHOME%" -quit -e 'test_run("'%TEST%'",[],[],"'%TEST%.xml'")'

rmdir /s /q "%SCIHOME%"

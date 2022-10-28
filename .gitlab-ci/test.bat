REM Execute module test for a module named %TEST%, download and install latest build if needed

@echo on
REM Install if not exist
if exist "%SCI_VERSION_STRING%\" goto :installed
call "%SCI_VERSION_STRING%.bin.%ARCH%.exe" /TASKS=!desktopicon /SUPPRESSMSGBOXES /SILENT /SP-^
  /DIR="%CI_PROJECT_DIR%\%SCI_VERSION_STRING%"
if not exist "%SCI_VERSION_STRING%\" exit 1

:installed

@echo on
setlocal EnableExtensions

rem get unique SCIHOME 
:uniqLoop
set "SCIHOME=%tmp%\SCI_TMP_HOME~%RANDOM%"
if exist -d "%SCIHOME%\" goto :uniqLoop
mkdir "%SCIHOME%"
if errorlevel 1  goto :uniqLoop

@echo on
call "%SCI_VERSION_STRING%\bin\scilab.bat" -nwni -scihome "%SCIHOME%" -quit -e "test_run('%TEST%',[],[],'%ARCH%_%TEST%.xml')"

rmdir /s /q "%SCIHOME%"

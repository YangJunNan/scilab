REM Execute module test for a module named %TEST%, download and install latest build if needed

@echo on
REM Install if not exist
if exist "%SCI_VERSION_STRING%\" goto :installed
call "%SCI_VERSION_STRING%.bin.%ARCH%.exe" /TASKS=!desktopicon,!AssociateSCESCI,!AssociateTSTDEM,!AssociateSCICOS,!AssociateSOD ^
  /NOICONS /SUPPRESSMSGBOXES /SILENT /SP- ^
  /DIR="%CI_PROJECT_DIR%\..\..\%SCI_VERSION_STRING%"
if not exist "..\..\%SCI_VERSION_STRING%\" exit 1

:installed

REM Create log folder
set LOG_PATH=logs_%CI_COMMIT_SHORT_SHA%
if not exist %LOG_PATH% mkdir %LOG_PATH%

@echo on
setlocal EnableExtensions

rem get unique SCIHOME 
:uniqLoop
set "SCIHOME=%CI_PROJECT_DIR%\..\..\SCI_TMP_HOME~%RANDOM%"
if exist -d "%SCIHOME%\" goto :uniqLoop
mkdir "%SCIHOME%"
if errorlevel 1  goto :uniqLoop

@echo on
call "..\..\%SCI_VERSION_STRING%\bin\scilab.bat" -nwni -scihome "%SCIHOME%" -quit -e "test_run('%TEST%',[],[],'%LOG_PATH%\%ARCH%_%TEST%.xml')"

rmdir /s /q "%SCIHOME%"

rem fail without xml report
dir /s "%LOG_PATH%\%ARCH%_%TEST%.xml"

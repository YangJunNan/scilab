REM Execute module test for a module named %TEST%, download and install latest build if needed

@echo on
REM Install if not exist
if exist "%SCI_VERSION_STRING%\" goto :installed
start /W "%SCI_VERSION_STRING%_%ARCH%.exe" /SUPPRESSMSGBOXES /SILENT /SP-^
  /DIR="%CI_PROJECT_DIR%\%SCI_VERSION_STRING%"
if not exist "%SCI_VERSION_STRING%\" exit 1

:installed

@echo on
REM FIXME copy intel redistribuables as thirdparties are not up to date
robocopy /e /copy:DAT "%IFORT_COMPILER22%\redist\intel64_win\compiler\1033" "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%\bin\1033"
robocopy /e /copy:DAT "%IFORT_COMPILER22%\redist\intel64_win\compiler" "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%\bin" ^
libifcoremd.dll ^
libifcorert.dll ^
libifcorertd.dll ^
libiomp5md.dll ^
libmmd.dll ^
svml_dispmd.dll

@echo on
setlocal EnableExtensions

rem get unique SCIHOME 
:uniqLoop
set "SCIHOME=%tmp%\SCI_TMP_HOME~%RANDOM%"
if exist -d "%SCIHOME%\" goto :uniqLoop
mkdir "%SCIHOME%"
if errorlevel 1  goto :uniqLoop

@echo on
call "%SCI_VERSION_STRING%\bin\scilab.bat" -nwni -scihome "%SCIHOME%" -quit -e "test_run('%TEST%',[],[],'%TEST%.xml')"

rmdir /s /q "%SCIHOME%"

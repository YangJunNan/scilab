REM Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
REM Copyright (C) Dassault Systemes - 2022 - Clement DAVID
REM Copyright (C) Dassault Systemes - 2022 - Cedric DELAMARRE
REM
REM Builder script for building Scilab on Windows
REM
REM NOTE: log all commands to log files to avoid hitting Gitlab log limit

call "%VS2017INSTALLDIR%\Common7\Tools\VsDevCmd.bat"
@REM call "C:\Program Files (x86)\Microsoft Visual Studio\2017\Professional\Common7\Tools\VsDevCmd.bat"
echo on


REM Create log folder
set LOG_PATH=logs_%CI_COMMIT_SHORT_SHA%
if not exist %LOG_PATH% mkdir %LOG_PATH%

curl -k -z prereq.zip -o prereq.zip https://oos.eu-west-2.outscale.com/scilab-releases-dev/prerequirements/prerequirements-scilab-branch-6.1-windows_x64.zip
unzip -o prereq.zip -d scilab > %LOG_PATH%\log_prereq_%CI_COMMIT_SHORT_SHA%.txt
@REM svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/%PREREQUIREMENTS_BRANCH%/Dev-Tools/SE/Prerequirements/Windows_x64/ scilab > %LOG_PATH%\log_svn_%CI_COMMIT_SHORT_SHA%.txt
@REM if errorlevel 1 tail --lines=20 %LOG_PATH%\log_svn_%CI_COMMIT_SHORT_SHA%.txt 1>&2 & exit 1
@REM REM display svn revision
@REM tail -n 1 %LOG_PATH%\log_svn_%CI_COMMIT_SHORT_SHA%.txt
@REM REM revert local modification
@REM svn revert -R scilab >> %LOG_PATH%\log_svn_%CI_COMMIT_SHORT_SHA%.txt

REM Define environment variables
set SCILAB_JDK64=%JAVA_HOME%

cd scilab

REM patch version numbers
sed -i ^
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"%SCI_VERSION_STRING%\"/" ^
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"%SCI_VERSION_STRING%\"/" ^
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"%CI_COMMIT_SHA%\"/" ^
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP %SCI_VERSION_TIMESTAMP%/" ^
 modules\core\includes\version.h.vc
if exist modules\core\includes\version.h sed -i ^
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"%SCI_VERSION_STRING%\"/" ^
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"%SCI_VERSION_STRING%\"/" ^
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"%CI_COMMIT_SHA%\"/" ^
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP %SCI_VERSION_TIMESTAMP%/" ^
 modules\core\includes\version.h

REM build with Visual Studio and Intel compilers
devenv Scilab.sln /build "Release|x64" > ..\%LOG_PATH%\log_build_%CI_COMMIT_SHORT_SHA%.txt
if errorlevel 1 tail --lines=20 ..\%LOG_PATH%\log_build_%CI_COMMIT_SHORT_SHA%.txt 1>&2 & exit 1
devenv Scilab.sln /build "Release|x64" /project buildhelp > ..\%LOG_PATH%\log_buildhelp_%CI_COMMIT_SHORT_SHA%.txt
devenv Scilab.sln /build "Release|x64" /project buildjavadoc > ..\%LOG_PATH%\log_buildjavadoc_%CI_COMMIT_SHORT_SHA%.txt

REM Package with Inno Setup 6
if exist "Scilab.iss" del /f "Scilab.iss"
bin\WScilex-cli.exe -nb -f "tools\innosetup\Create_ISS.sce" > ..\%LOG_PATH%\log_iss_%CI_COMMIT_SHORT_SHA%.txt
if errorlevel 1 tail --lines=20 ..\%LOG_PATH%\log_iss_%CI_COMMIT_SHORT_SHA%.txt 1>&2 & exit 1
if not exist "Scilab.iss" exit 1
"C:\Program Files (x86)\Inno Setup 6\iscc.exe" Scilab.iss >> ..\%LOG_PATH%\log_iss_%CI_COMMIT_SHORT_SHA%.txt
if errorlevel 1 tail --lines=20 ..\%LOG_PATH%\log_iss_%CI_COMMIT_SHORT_SHA%.txt 1>&2 & exit 1

move ".\Output\%SCI_VERSION_STRING%_%ARCH%.exe" "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%.bin.%ARCH%.exe"
if errorlevel 1 exit 1

REM error if artifact does not exist
dir /s "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%.bin.%ARCH%.exe"

exit 0

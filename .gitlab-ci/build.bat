REM Scilab ( http://www.scilab.org/ ) - This file is part of Scilab
REM Copyright (C) Dassault Systemes - 2022 - Clement DAVID
REM
REM Builder script for building Scilab on Windows
REM
REM NOTE: log all commands to log.txt to avoid hitting Gitlab log limit

svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/%PREREQUIREMENTS_BRANCH%/Dev-Tools/SE/Prerequirements/Windows_x64/ scilab >log_svn.txt
if errorlevel 1 (tail --lines=100 ..\log_svn.txt 1>&2 & exit 1)
REM display svn revision
tail -n 1 log_svn.txt
REM revert local modification
svn revert -R scilab >>log_svn.txt

REM Define environment variables
call "%VS2017INSTALLDIR%\Common7\Tools\VsDevCmd.bat"

set SCILAB_JDK64=%JAVA_HOME%

cd scilab
del /q modules\core\includes\version.h

REM patch version numbers
sed -i ^
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING \"%SCI_VERSION_STRING%\"/" ^
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L\"%SCI_VERSION_STRING%\"/" ^
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION \"%CI_COMMIT_SHA%\"/" ^
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP %SCI_VERSION_TIMESTAMP%/" ^
 modules\core\includes\version.h.vc

@REM REM FIXME copy intel redistribuables as thirdparties are not up to date
@REM robocopy /e /copy:DAT "%IFORT_COMPILER22%\redist\intel64_win\compiler\1033" "%CI_PROJECT_DIR%\scilab\bin\1033"
@REM robocopy /e /copy:DAT "%IFORT_COMPILER22%\redist\intel64_win\compiler" "%CI_PROJECT_DIR%\scilab\bin" ^
@REM libifcoremd.dll ^
@REM libifcorert.dll ^
@REM libifcorertd.dll ^
@REM libiomp5md.dll ^
@REM libmmd.dll ^
@REM svml_dispmd.dll

REM build with Visual Studio and Intel compilers
devenv Scilab.sln /build "Release|x64" > ..\log_build.txt
if errorlevel 1 (tail --lines=100 ..\log_build.txt 1>&2 & exit 1)
devenv Scilab.sln /build "Release|x64" /project buildhelp >..\log_buildhelp.txt |cmd /c ""
if errorlevel 1 (tail --lines=100 ..\log_buildhelp.txt 1>&2 & exit 1)
devenv Scilab.sln /build "Release|x64" /project buildjavadoc >..\log_buildjavadoc.txt |cmd /c ""
if errorlevel 1 (tail --lines=100 ..\log_buildjavadoc.txt 1>&2 & exit 1)

REM Package with Inno Setup 6
bin\WScilex.exe -nb -f "tools\innosetup\Create_ISS.sce" >..\log_iss.txt
if errorlevel 1 (tail --lines=100 ..\log_iss.txt 1>&2 & exit 1)
"C:\Program Files (x86)\Inno Setup 6\iscc.exe" Scilab.iss >>..\log_iss.txt
if errorlevel 1 (tail --lines=100 ..\log_iss.txt 1>&2 & exit 1)

move ".\Output\%SCI_VERSION_STRING%_%ARCH%.exe" "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%_%ARCH%.exe"
if "%ERRORLEVEL%" NEQ 0 exit 1

REM error if artifact does not exist
dir /s "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%_%ARCH%.exe"

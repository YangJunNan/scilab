REM Builder script for building Scilab on Windows

REM NOTE: log all commands to log.txt to avoid hitting Gitlab log limit

echo on
svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/%PREREQUIREMENTS_BRANCH%/Dev-Tools/SE/Prerequirements/Windows_x64/ scilab >log.txt
if errorlevel 1 tail.exe --lines=100 log.txt & exit 1
REM display svn revision
tail.exe -n 1 log.txt
REM revert local modification
svn revert -R scilab >>log.txt

REM Define environment variables
call "%VS2017INSTALLDIR%\VC\Auxiliary\Build\vcvarsall.bat" x64
echo on
REM call "%ONEAPI_ROOT%\setvars.bat" intel64 vs2017
echo on
if not defined SCILAB_JDK64 call scilab\java\set_scilab_jdk64.bat
set JAVA_HOME="%SCILAB_JDK64%"

cd scilab

REM patch version numbers
"c:\Program Files\ds_shell\code\bin\ds_shell\date.exe" +"%%s" >timestamp
set /p NOW=<timestamp
sed -i ^
 -e 's/SCI_VERSION_STRING .*/SCI_VERSION_STRING ^"scilab-branch-%CI_COMMIT_BRANCH%^"/' ^
 -e 's/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L^"scilab-branch-%CI_COMMIT_BRANCH%^"/' ^
 -e 's/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION ^"%CI_COMMIT_SHA%^"/' ^
 -e 's/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP %NOW%/' ^
 modules\core\includes\version.h.vc

REM build with Visual Studio and Intel compilers
echo on
devenv.com Scilab.sln /build "Release|x64" >>..\log.txt
if errorlevel 1 tail.exe --lines=100 ..\log.txt & exit 1
devenv.com Scilab.sln /build "Release|x64" /project buildhelp >>..\log.txt
if errorlevel 1 tail.exe --lines=100 ..\log.txt & exit 1
devenv.com Scilab.sln /build "Release|x64" /project buildjavadoc >>..\log.txt
if errorlevel 1 tail.exe --lines=100 ..\log.txt & exit 1

REM Package with Inno Setup 6
echo on
call bin\scilab.bat -nw -f tools\innosetup\Create_ISS.sce
if errorlevel 1 exit 1
"C:\Program Files (x86)\Inno Setup 6\iscc.exe" tools\innosetup\Scilab.iss
REM TODO: how to sign ? was:
REM call d:\signtool_password.bat
REM "C:\Program Files (x86)\Windows Kits\8.1\bin\x64\signtool.exe" sign /f D:\\ESIGroupCERT.pfx /p "%SIGNPASS%" /t http://timestamp.sectigo.com /v .\Output\scilab-branch-6.1_x64.exe
move .\Output\scilab-branch-6.1_x64.exe scilab-branch-%CI_COMMIT_BRANCH%-%CI_COMMIT_TIMESTAMP%.exe
if errorlevel 1 exit 1

REM Builder script for building Scilab on Windows
REM
REM NOTE: log all commands to log.txt to avoid hitting Gitlab log limit

REM define NOW as Gitlab display ISO 8601 timestamp
"c:\Program Files\ds_shell\code\bin\ds_shell\date.exe" +"%%s" >timestamp
set /p NOW=<timestamp

REM export useful variables
echo ARCH="%ARCH%"                              >build.env
echo SCI_VERSION_STRING="%SCI_VERSION_STRING%" >>build.env
echo SCI_VERSION_TIMESTAMP="%NOW%"             >>build.env

echo on
svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/%PREREQUIREMENTS_BRANCH%/Dev-Tools/SE/Prerequirements/Windows_x64/ scilab >log_svn.txt
if errorlevel 1 tail.exe --lines=100 log_svn.txt & exit 1
REM display svn revision
tail.exe -n 1 log_svn.txt
REM revert local modification
svn revert -R scilab >>log_svn.txt

REM Define environment variables
call "%VS2017INSTALLDIR%\VC\Auxiliary\Build\vcvarsall.bat" x64
echo on
REM call "%ONEAPI_ROOT%\setvars.bat" intel64 vs2017
echo on
if not defined SCILAB_JDK64 call scilab\java\set_scilab_jdk64.bat
set JAVA_HOME="%SCILAB_JDK64%"

cd scilab

REM patch version numbers
sed -i ^
 -e 's/SCI_VERSION_STRING .*/SCI_VERSION_STRING ^"%SCI_VERSION_STRING%^"/' ^
 -e 's/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L^"%SCI_VERSION_STRING%^"/' ^
 -e 's/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION ^"%CI_COMMIT_SHA%^"/' ^
 -e 's/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP %NOW%/' ^
 modules\core\includes\version.h.vc

REM build with Visual Studio and Intel compilers
echo on
devenv.com Scilab.sln /build "Release|x64" >..\log.txt
if errorlevel 1 tail.exe --lines=100 ..\log.txt & exit 1
devenv.com Scilab.sln /build "Release|x64" /project buildhelp >..\log_buildhelp.txt |cmd /c ""
if errorlevel 1 tail.exe --lines=100 ..\log_buildhelp.txt & exit 1
devenv.com Scilab.sln /build "Release|x64" /project buildjavadoc >..\log_buildjavadoc.txt |cmd /c ""
if errorlevel 1 tail.exe --lines=100 ..\log_buildjavadoc.txt & exit 1

REM Package with Inno Setup 6
echo on
bin\WScilex-cli.exe -nb -f "tools\innosetup\Create_ISS.sce" >..\log_iss.txt
if errorlevel 1 tail.exe --lines=100 ..\log_iss.txt & exit 1
"C:\Program Files (x86)\Inno Setup 6\iscc.exe" Scilab.iss >>..\log_iss.txt
if errorlevel 1 tail.exe --lines=100 ..\log_iss.txt & exit 1
REM TODO: how to sign ? was:
REM call d:\signtool_password.bat
REM "C:\Program Files (x86)\Windows Kits\8.1\bin\x64\signtool.exe" sign /f D:\\ESIGroupCERT.pfx /p "%SIGNPASS%" /t http://timestamp.sectigo.com /v .\Output\scilab-branch-6.1_x64.exe
move .\Output\scilab-*.exe %CI_PROJECT_DIR%\%SCI_VERSION_STRING%_%ARCH%.exe
if errorlevel 1 exit 1

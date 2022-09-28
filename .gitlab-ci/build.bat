REM Builder script for building Scilab on Windows
REM
REM NOTE: log all commands to log.txt to avoid hitting Gitlab log limit

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
 -e "s/SCI_VERSION_STRING .*/SCI_VERSION_STRING ^"%SCI_VERSION_STRING%^"/" ^
 -e "s/SCI_VERSION_WIDE_STRING .*/SCI_VERSION_WIDE_STRING L^"%SCI_VERSION_STRING%^"/" ^
 -e "s/SCI_VERSION_REVISION .*/SCI_VERSION_REVISION ^"%CI_COMMIT_SHA%^"/" ^
 -e "s/SCI_VERSION_TIMESTAMP .*/SCI_VERSION_TIMESTAMP %SCI_VERSION_TIMESTAMP%/" ^
 modules\core\includes\version.h.vc

REM FIXME copy intel redistribuables as thirdparties are not up to date
robocopy /e /copy:DAT "%IFORT_COMPILER22%\redist\intel64_win\compiler" "%CI_PROJECT_DIR%\scilab\bin" ^
1033\ ^
libifcoremd.dll ^
libifcoremdd.dll ^
libifcorert.dll ^
libifcorertd.dll ^
libiomp5md.dll ^
libmmd.dll ^
libmmdd.dll ^
svml_dispmd.dll

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

move ".\Output\scilab-*.exe" "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%_%ARCH%.exe"
if errorlevel 1 exit 1

REM error if artifact does not exist
dir /s "%CI_PROJECT_DIR%\%SCI_VERSION_STRING%_%ARCH%.exe"

REM Builder script for building Scilab on Windows

svn checkout --username anonymous --password Scilab svn://svn.scilab.org/scilab/trunk/Dev-Tools/SE/Prerequirements/Windows_x64/ scilab >log.txt
if errorlevel 1 exit 1

cd scilab

REM Define environment variables
call "%VS2017INSTALLDIR%\VC\Auxiliary\Build\vcvarsall.bat" x64
call "%ONEAPI_ROOT%\setvars.bat" intel64 vs2017
setx SCILAB_JDK64 %JAVA_HOME%
env

REM build with Visual Studio and Intel compilers
devenv.com Scilab.sln /Build Release /Project WScilex /ProjectConfig "Release|x64" /out ..\log.txt
if errorlevel 1 exit 1

REM Package with innosetups
call bin\scilab.bat -f tools\innosetup\Create_ISS.sce
if errorlevel 1 exit 1
"C:\Program Files (x86)\Inno Setup 6\iscc.exe" tools\innosetup\Scilab.iss
if errorlevel 1 exit 1
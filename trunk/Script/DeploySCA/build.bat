@ECHO OFF

SETLOCAL

call ./set-env.bat

ant -logfile attipBuild.log -buildfile attip-sca-build.xml buildAll -Dbasedir=%ORACLE_HOME%\jdeveloper\bin

ENDLOCAL
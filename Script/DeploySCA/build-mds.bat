@ECHO OFF

SETLOCAL

call ./set-env.bat

ant -logfile attipBuildMDS.log -buildfile attip-sca-build.xml buildMDS -Dbasedir=%ORACLE_HOME%\jdeveloper\bin

ENDLOCAL
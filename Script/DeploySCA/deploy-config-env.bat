@ECHO OFF

SETLOCAL

call ./set-env.bat

ant -logfile attipConfig.log -buildfile attip-sca-deploy.xml configEnvironment -Dbasedir=%ORACLE_HOME%\jdeveloper\bin

ENDLOCAL
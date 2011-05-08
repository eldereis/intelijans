@ECHO OFF

SETLOCAL

call ./set-env.bat

ant -logfile attipDeploy.log -buildfile attip-sca-deploy.xml deployAll -Dbasedir=%ORACLE_HOME%\jdeveloper\bin

ENDLOCAL
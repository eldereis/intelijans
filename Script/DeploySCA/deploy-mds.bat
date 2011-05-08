@ECHO OFF

SETLOCAL

call ./set-env.bat

ant -logfile attipDeployMDS.log -buildfile attip-sca-deploy.xml deployMDS -Dbasedir=%ORACLE_HOME%\jdeveloper\bin


ENDLOCAL
@ECHO OFF

SETLOCAL

call ./set-env.bat

ant -buildfile attip-sca-deploy.xml undeployMDS -Dbasedir=%ORACLE_HOME%\jdeveloper\bin

ENDLOCAL
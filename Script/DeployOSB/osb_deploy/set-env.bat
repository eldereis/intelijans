
set OSBHOME=C:\Oracle\Middleware\OSB_10gR3

call C:\Oracle\Middleware\OSB_10gR3\osb_10.3\samples\domains\servicebus\bin\setDomainEnv.cmd

set CLASSPATH=%CLASSPATH%;%OSBHOME%\modules\com.bea.common.configfwk_1.2.1.0.jar;%ALSB_HOME%\lib\sb-kernel-api.jar

echo %CLASSPATH%

cd c:\SRC\Utilities\Script\DeployOSB\osb_deploy

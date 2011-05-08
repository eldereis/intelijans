set SOA_HOME=C:\Oracle\Middleware\Home_11gR1
set JAVA_HOME=C:\Oracle\Middleware\Home_11gR1\jdk160_14_R27.6.5-32
set CURRENT_FOLDER=%CD%

call %SOA_HOME%\wlserver_10.3\server\bin\setWLSEnv.cmd

set ABPATH=C:\SRC\Utilities\Script\DeployJMS_HUB\LogProcessor\deployLogProcessor\build\log_processor.ear
set APPNAME=log_processor.ear
set ADMURL=t3://localhost:7004

cd %CURRENT_FOLDER%

echo " deploy " %APPNAME%" version " %ADMURL%

call java weblogic.Deployer -adminurl %ADMURL% -user weblogic -password soawlps1 -deploy %ABPATH% -targets wls_log1


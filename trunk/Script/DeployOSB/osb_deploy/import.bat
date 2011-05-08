set OSB_HOME=C:\Oracle\Middleware\OSB_10gR3
set JAVA_HOME=C:\Oracle\Middleware\OSB_10gR3\jdk160_05
set CURRENT_FOLDER=%CD%

call %OSB_HOME%\user_projects\domains\soadomain\bin\setDomainEnv.cmd

set CLASSPATH=%CLASSPATH%;%OSB_HOME%\osb_10.3\lib\alsb.jar;%OSB_HOME%\osb_10.3\lib\sb-kernel-impl.jar;%OSB_HOME%\osb_10.3\lib\sb-kernel-api.jar;%OSB_HOME%\modules\com.bea.common.configfwk_1.2.1.0.jar

cd C:\SRC\Utilities\Script\DeployOSB\osb_deploy

call ant

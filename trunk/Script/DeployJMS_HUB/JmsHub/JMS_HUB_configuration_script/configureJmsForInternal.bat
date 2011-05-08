set OSB_HOME=C:\Oracle\Middleware\OSB_10gR3
set JAVA_HOME=C:\Oracle\Middleware\OSB_10gR3\jdk160_05
set CURRENT_FOLDER=%CD%

call %OSB_HOME%\wlserver_10.3\common\bin\wlst.cmd configureJmsForInternal.py

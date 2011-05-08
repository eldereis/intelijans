@ECHO off

set OSB_HOME=C:\Oracle\Middleware\OSB_10gR3
set JAVA_HOME=C:\Oracle\Middleware\OSB_10gR3\jdk160_05
set CURRENT_FOLDER=%CD%

REM %OSB_HOME%\wlserver_10.3\common\bin\wslt.cmd

REM SET Host=
REM SET Port=
REM SET User=
REM SET Pwd=
REM SET ServerJMS=
REM SET Queue=
IF "%1"==""  GOTO missing
SET WSLTexe=%1
CLS
SET  /p Host="Specify the host name or IP for WLS server -> [%Host%] "
IF "%Host%"==""  GOTO missing2
SET /p Port="Specify the PORT for WLS server            -> [%Port%] "
IF "%Port%"==""  GOTO missing2
SET /p User="Specify the Username for WLS server        -> [%User%] "
IF "%User%"==""  GOTO missing2
SET /p Pwd="Specify the Password for WLS server        -> [%Pwd%] "
IF "%Pwd%"==""  GOTO missing2
SET /p ServerJMS="Specify the JMS Runtime                    -> [%ServerJMS%] "
IF "%ServerJMS%"==""  GOTO missing2
SET /p Queue="Specify the name or partial name of queue  -> [%Queue%] "
IF "%Queue%"==""  GOTO missing2
REM c:\test.py -u weblogic -c weblogic!1 -h ttsvint1 -p 7004 -s wls_jms1.jms -q manageServiceOrder.OSB_to_SOA
SET  cmd_int=%WSLTexe% c:\test.py -u %User% -c %Pwd% -h %Host% -p %port% -s %ServerJMS% -q %Queue% -t c
echo.
echo.
echo.
IF "%2"=="debug" %cmd_int% | FIND "debug:"
IF "%2"=="" %cmd_int% | FIND "INFO:"

GOTO exit
:missing
SET s=Usage: %0 wslt file
echo.
ECHO %s%
ECHO Es: %0 %OSB_HOME%\wlserver_10.3\common\bin\wslt.cmd
echo.
GOTO exit
:missing2
:exit
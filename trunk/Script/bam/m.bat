@echo off
FOR /F "tokens=1-4 skip=7delims=	 " %%I in ('DIR /-C %1') do call :process %%J %%K %%L 


goto :EOF


:process
rem if /I "%1" == "File(s)" goto :eof
rem if /I "%1" == "Dir(s)" goto :eof
echo size of %3 = %2 bytes
if %2==0  echo %3 on esportato
goto :eof

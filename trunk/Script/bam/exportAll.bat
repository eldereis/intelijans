@echo off
cls

call envbam.bat

set lista=`type list_exp.lst`
for /f %%i in (list_exp.lst) do call:todo %%i

goto:eof

:todo
set m=%~1
SET STRING=%m:~0,1%
SET STRING2=%m:~1%
rem icommand -cmd export -name /public/Report/DemoBam/%STRING2% -type report -file exp_report_parent/%STRING2%.xml 
rem icommand -cmd export -name /public/Report/DemoBam/Dashboard/%STRING2% -type report -file exp_report_child/%STRING2%.xml 
if "%STRING%"=="*" (
	echo.
	echo Exporting parent -%STRING2%-
	%BAM_HOME%/bin/icommand -cmd export -name /public/Report/DemoBam/%STRING2% -type report -file exp_report_parent\%STRING2%.xml>nul	
	for %%R in (exp_report_parent\%STRING2%.xml) do call:process %%~zR	
) else (
	if "%STRING%"=="#" (
		echo.
		echo Skipping -%STRING2%-
	) else (
		if NOT "%STRING%"=="*" (
			echo.
			echo Exporting child -%m%-
			%BAM_HOME%/bin/icommand -cmd export -name /public/Report/DemoBam/Dashboard/%m% -type report -file exp_report_child\%m%.xml>nul			
			for %%R in (exp_report_child\%m%.xml) do call:process %%~zR
		)	
	)
)

goto:eof

:process
if %~1 GTR 0 (
	echo                  - %~1 exported
) else ( 
	echo                  - %~1 NOT exported
)
goto:eof

:end


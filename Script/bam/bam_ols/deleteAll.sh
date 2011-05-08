. ./envbam.sh

list=`cat list_del.lst`
y=2

k="\033[$4;60H"
warn="\033[1;33m"
error="\033[1;31m"
success="\033[1;32m"
tipo=n

export PATH=$BAM_HOME/bin:$PATH

clear

function Checkresult 
{	
	#k="\033[${4};60H"
	
	if [[ $3 = "0" ]]; then
		echo "$ky$error$tipo not deleted\033[m"
	else
		echo "$ky$success$tipo deleted \033[m in $PATH_TO_EXPORT"
	fi
}

echo Delete all Reports
echo
for i in $list
do	
	c=`expr substr $i 1 1`
	y=`echo $y + 1 | bc`	
	ky="\033[$y;60H"	
	if [[ $c != "#" ]]; then
		if [[ $c = "*" ]]; then
		    PATH_TO_EXPORT=$PATH_TO_EXPORT_PARENT
			l=$(expr length $i)
			f=$PATH_TO_EXPORT/$(expr substr $i 2 $l).xml
			tipo=Parent
			PATH_TIPO=/public/Report/DemoBam
			i=$(expr substr $i 2 $l)
		else
		    PATH_TO_EXPORT=$PATH_TO_EXPORT_CHILD
			f=$PATH_TO_EXPORT/$i.xml	
			tipo=Child
			PATH_TIPO=/public/Report/DemoBam/Dashboard
		fi
		echo "$i$ky\c"
		#f=$PATH_TO_EXPORT/$i.xml		
		icommand -cmd delete -name $PATH_TIPO/$i -type report >/dev/null;

		res=$(ls -l $PATH_TO_EXPORT/$i.xml | awk '{ print $5}')		
		
		Checkresult $f $i.xml $res ${ky}
	else	
		my="\033[$y;1H"
		echo $my$i
		echo "$ky$warn Skipped\033[m"
	fi
done
echo
echo Script terminated.
exit
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/AverageTimeToCloseFaultDaily -type report -file $PATH_TO_EXPORT/AverageTimeToCloseFaultDaily.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/AverageTimeToCloseFaultMonthly -type report -file $PATH_TO_EXPORT/AverageTimeToCloseFaultMonthly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/AverageTimeToCloseFaultWeekly -type report -file $PATH_TO_EXPORT/AverageTimeToCloseFaultWeekly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/CompletionTimeDaily -type report -file $PATH_TO_EXPORT/CompletionTimeDaily.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/CompletionTimeList -type report -file $PATH_TO_EXPORT/CompletionTimeList.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/CompletionTimeMonthly -type report -file $PATH_TO_EXPORT/CompletionTimeMonthly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/CompletionTimeWeekly -type report -file $PATH_TO_EXPORT/CompletionTimeWeekly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyDaily -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyDaily.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyList -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyList.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyMonthly -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyMonthly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyWeekly -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyWeekly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/PendingError -type report -file $PATH_TO_EXPORT/PendingError.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ProcessStatusDaily -type report -file $PATH_TO_EXPORT/ProcessStatusDaily.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ProcessStatusMonthly -type report -file $PATH_TO_EXPORT/ProcessStatusMonthly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ProcessStatusOverallDaily -type report -file $PATH_TO_EXPORT/ProcessStatusOverallDaily.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ProcessStatusOverallMonthly -type report -file $PATH_TO_EXPORT/ProcessStatusOverallMonthly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ProcessStatusOverallWeekly -type report -file $PATH_TO_EXPORT/ProcessStatusOverallWeekly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ProcessStatusWeekly -type report -file $PATH_TO_EXPORT/ProcessStatusWeekly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyDailyIF -type report -file $PATH_TO_EXPORT/ServiceEfficiencyDailyIF.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyDailyTSSN -type report -file $PATH_TO_EXPORT/ServiceEfficiencyDailyTSSN.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyMonthlyCE -type report -file $PATH_TO_EXPORT/ServiceEfficiencyMonthlyCE.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyMonthlyIF -type report -file $PATH_TO_EXPORT/ServiceEfficiencyMonthlyIF.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyMonthlyTSSN -type report -file $PATH_TO_EXPORT/ServiceEfficiencyMonthlyTSSN.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyWeeklyCE -type report -file $PATH_TO_EXPORT/ServiceEfficiencyWeeklyCE.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyWeeklyIF -type report -file $PATH_TO_EXPORT/ServiceEfficiencyWeeklyIF.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServiceEfficiencyWeeklyTSSN -type report -file $PATH_TO_EXPORT/ServiceEfficiencyWeeklyTSSN.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServicesEfficiencyDaily -type report -file $PATH_TO_EXPORT/ServicesEfficiencyDaily.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServicesEfficiencyMonthly -type report -file $PATH_TO_EXPORT/ServicesEfficiencyMonthly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServicesEfficiencyOverall -type report -file $PATH_TO_EXPORT/ServicesEfficiencyOverall.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServicesEfficiencyWeekly -type report -file $PATH_TO_EXPORT/ServicesEfficiencyWeekly.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/ServicetEfficiencyDailyCE -type report -file $PATH_TO_EXPORT/ServicetEfficiencyDailyCE.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyDailyCE -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyDailyCE.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyDailyIF -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyDailyIF.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyDailyTSSN -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyDailyTSSN.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyMonthlyCE -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyMonthlyCE.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyMonthlyIF -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyMonthlyIF.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyMonthlyTSSN -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyMonthlyTSSN.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyWeeklyCE -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyWeeklyCE.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyWeeklyIF -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyWeeklyIF.xml
#icommand -cmd export -name /public/Report/DemoBam/Dashboard/FaultManagementEfficiencyWeeklyTSSN -type report -file $PATH_TO_EXPORT/FaultManagementEfficiencyWeeklyTSSN.xml

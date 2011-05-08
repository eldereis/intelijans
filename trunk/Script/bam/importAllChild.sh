. ./envbam.sh

export PATH=$BAM_HOME/bin:$PATH
PATH_FROM_IMPORT=$PATH_FROM_IMPORT_CHILD
list=`ls -l $PATH_FROM_IMPORT/*.xml| awk '{ print $9}'`
warn="\033[1;33m"
error="\033[1;31m"
success="\033[1;32m"
k="\033[1;2H"
y=2

clear
function GetFilename
{
	IFS='/' 
	set -A arr $1	
	t=${#arr[@]}		
	r=${arr[$t-1]}
	echo ${r}
}

function CheckError
{	
	if [[ "${1}" = @(*ErrorID=*) ]] ; then	   
	   if [[ "${1}" = @(*Import.Report.Exists*) ]] ; then	   
			echo $error$2"Report Exists\033[m"
		else
			echo ${1}
		fi
	else
	   echo $2$success"Imported\033[m"
	fi;
}

echo Importing Reports
echo

for i in $list
do	
	y=`echo $y + 1 | bc`
	ky="\033[$y;60H"	
	r=$(GetFilename "$i")	
	my="\033[$y;1H"	
	echo "$my Importing \033[m\"$r\"$ky\c"
	f=$PATH_FROM_IMPORT/$r
	res=`icommand -cmd import -file $f`	
	CheckError "${res}" $ky
done
echo
echo Script terminated.
exit
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/AverageTimeToCloseFaultDaily.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/AverageTimeToCloseFaultList.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/AverageTimeToCloseFaultMonthly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/AverageTimeToCloseFaultWeekly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/CompletionTimeDaily.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/CompletionTimeList.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/CompletionTimeMonthly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/CompletionTimeWeekly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/FaultManagementEfficiencyDaily.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/FaultManagementEfficiencyList.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/FaultManagementEfficiencyMonthly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/FaultManagementEfficiencyWeekly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/MessageResubmitter.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/OverallSMSDaily.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/OverallSMSMonthly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/OverallSMSWeekly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/SendSMSDaily.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/SendSMSMonthly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/SendSMSWeekly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ServicesEfficiencyDaily.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ServicesEfficiencyMonthly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ServicesEfficiencyOverall.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ServicesEfficiencyWeekly.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/AverageTimeToCloseFault.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/CompletionTime.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/FaultManagementEfficiency.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/FaultManagementEfficiency2List.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ProcessStatus.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ServicesEfficiency.xml
#icommand -cmd import -file /product/SCRIPTS/soa/bam/export/ServicesEfficiencyOverall2.xml
#
#

#!/usr/bin/ksh

clear

LdrError=""
FILESQL="PGM1_INT_ARCHIVE_EVENTS.sql"
LOGDIR="."
DBSID="<SID>"
DBUSER="<username>"
DBPWD="<password>"
PARTITIONNAME=$1
NEWPARTITIONDATE=$2
SIZEMOVING=$3

if [ "x$#" != "x2" ] 
then
	  echo "###############################################################################"
	  echo "#                                                                             #" 
	  echo "# ERROR: Parameters wrong or missing!                                         #"
	  echo "# Example:                                                                    #"
	  echo "#						                              #"
	  echo "# STEP1-Launch_Moving_Events.sh <PartitionName> <NewPartitionDate> <SizeMove> #"
	  echo "#                                                                             #"
	  echo "#                                                                             #" 
	  echo "###############################################################################"		
	  echo
	  echo	
	  exit 1
fi	  

echo Configuration:
echo
echo "LOG FOLDER                  = $LOGDIR"
echo "FILESQL                     = $FILESQL"
echo "DBSID                       = $DBSID"
echo "DBUSER                      = $DBUSER"
echo "Partition to rejuvenate     = $PARTITIONNAME"
echo "New date                    = $NEWPARTITIONDATE"
echo "Number of events            = ${SIZEMOVING}"
echo

# Launch Moving Events
before="$(date +%s)"

	#--------------------------#
	# Execution SQL statements #
	#--------------------------#
	echo "+------------------------------------------+"
	echo "|                                          |"
	echo "|           Execution SQL statements       |"
	echo "|                                          |"
	echo "+------------------------------------------+"
        echo
	f=`echo ${FILESQL} | sed 's/.sql//g'`
	nf=`echo ${f} |  cut -d "/" -f2`

	LOGTIME=`date -u +%y%m%d%H%M%S` 
	
	FILE_LOG_LDR=${LOGDIR}/${nf}_${LOGTIME}.log
	
	echo "Execution SQLPLUS for $FILESQL ..."
	echo 
	echo "LOG file = ${FILE_LOG_LDR}"
	echo
	echo "Status --> "

	DATA=`sqlplus -S ${DBUSER}/${DBPWD}@${DBSID} @${FILESQL} ${FILE_LOG_LDR} ${PARTITIONNAME} ${NEWPARTITIONDATE} 0${SIZEMOVING} >> ${FILE_LOG_LDR} 2>>${FILE_LOG_LDR}`				
        ERRORCODE=`grep "ORA-[0-9]\{1,99\}" ${FILE_LOG_LDR}`
	
	# -----------------------------
	#  Managed Error SQLPLUS - 
	# -----------------------------

        #echo "ErrorCode --> $ERRORCODE"

	
	if [ "x$ERRORCODE" != "x" ]
	then
		echo "KO"
		echo
		echo "SQLPLUS error number : $ERRORCODE"
		echo "check log file : ${FILE_LOG_LDR}"
		echo 
		exit 1
	else
		echo "OK"
		echo
		echo "Execution COMPLETED"
		echo
	fi	

after="$(date +%s)"

echo "--> SQL PLUS COMPLETED IN \c" 
elapsed_seconds="$(expr $after - $before)"
echo $elapsed_seconds seconds
echo
echo

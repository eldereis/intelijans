#!/bin/sh
l=$1
p=$2
s=$3

function GetFilename
{
	IFS='/' 
	set -A arr $1	
	t=${#arr[@]}		
	r=${arr[$t-1]}
	echo ${r}
}

#list=`ls -l soa/*.sh| awk '{ print $9}'`
list=`ls -l soa/*.sh| awk '{for (i=1;i<=8;i++){$i=""};print}'`

echo $list
echo
for i in $list
do
	echo $i $p/$s$(GetFilename "$i")
done

echo Finished.
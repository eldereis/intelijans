#OSB_HOME=/product/BEA
OSB_HOME=/data/app/oracle/home/oracle/osb
#JAVA_HOME=/data/app/oracle/home/oracle/osb/jdk160_05
#JAVA_HOME=/opt/java6

CLASSPATH=${OSB_HOME}/osb_10.3/lib/alsb.jar:${OSB_HOME}/osb_10.3/lib/sb-kernel-impl.jar:${OSB_HOME}/osb_10.3/lib/sb-kernel-api.jar:${OSB_HOME}/modules/com.bea.common.configfwk_1.2.1.0.jar

echo
echo CLASSPATH=${CLASSPATH}

. ${OSB_HOME}/wlserver_10.3/server/bin/setWLSEnv.sh $*


ANT_HOME=${OSB_HOME}/modules/org.apache.ant_1.6.5
PATH=${ANT_HOME}\bin:${PATH}


ant

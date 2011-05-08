#!/bin/sh
. /product/Middleware/wlserver_10.3/server/bin/setWLSEnv.sh
## EAR ##


ABPATH=/product/SCRIPTS/logProcessor/deployLogProcessor/build/log_processor.ear
APPNAME=log_processor.ear
ADMURL=t3://localhost:7004


echo " deploy " $APPNAME" verso " $ADMURL
java weblogic.Deployer -adminurl $ADMURL -user weblogic -password weblogic!1 -deploy $ABPATH -targets wls_log1



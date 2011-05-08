#c:\test.py -u weblogic -c weblogic!1 -h ttsvint1 -p 7004 -s wls_jms1.jms -j jms_server1 -q manageServiceOrder.OSB_to_SOA -t c

#redirect('c:/wlst.log')
#connect('weblogic','weblogic!1','t3://ttsvint1:9004')
#serverRuntime()
#cd('JMSRuntime/wls_jms1.jms/JMSServers/jms_server1/Destinations')
#print 1'

import sys
import os
import traceback
from java.lang import System 

import getopt

def usage():
    print "Usage:"
    print "SearchQueue [-n] -u user -c credential -h host -p port -s serverName -j jmsServerName -q queueName -t type"

def GetQueues(queue):
	print queue.lower()
	print queueName.lower()

def esci():
	stopRedirect()
	disconnect()		

def formatExceptionInfo(maxTBlevel=5):
	 cla, exc, trbk = sys.exc_info()
	 excName = cla.__name__
	 try:
		 excArgs = exc.__dict__["args"]
	 except KeyError:
		 excArgs = "<no args>"
	 excTb = traceback.format_tb(trbk, maxTBlevel)
	 return (excName, excArgs, excTb)

print "                    *******************************************"
print "                    *     Accenture Technology Solutions      *"
print "                    *                SOA Team                 *"
print "                    *                Dec 2010                 *"
print "                    *                                         *"
print "                    *          JMS Queues monitoring          *"
print "                    *******************************************"
print '\n'
try:	
#nu:c:h:p:s:m:d:j:	
    opts, args    = getopt.getopt(sys.argv[1:], "nu:c:h:p:s:d:j:q:t:l:",
                                  ["user=", "credential=", "host=", "port=",
                                   "targetServerName=", "jmsServerName=",
								   "queueName","type=","log="])
except getopt.GetoptError, err:
    print str(err)
    usage()
    sys.exit(2)

reallyDoIt  = true
user        = ''
credential  = ''
host        = ''
port        = ''
queueName		= ''
log 		= "_log.log"
targetServerName  = ''
moduleName  = ''
subDeploymentName   = 'DeployToJMSServer'
jmsServerName   = ''
flag = ''

for opt, arg in opts:
    if opt == "-n":
        reallyDoIt  = false
    elif opt == "-u":
        user        = arg
    elif opt == "-c":
        credential  = arg
    elif opt == "-h":
        host        = arg
    elif opt == "-p":
        port        = arg
    elif opt == "-s":
        targetServerName  	= arg    
    elif opt == "-j":
        jmsServerName   	= arg
    elif opt == "-q":
		queueName			= arg
    elif opt == "-t":
		flag				= arg
    elif opt == "-l":
		log					= arg
if user == "":
    print "Missing \"-u user\" parameter."
    usage()
    sys.exit(2)
elif queueName == "":
	print "Missing \"-q queueName\" parameter."
	usage()
	sys.exit(2)
elif credential == "":
    print "Missing \"-c credential\" parameter."
    usage()
    sys.exit(2)
elif host == "":
    print "Missing \"-h host\" parameter."
    usage()
    sys.exit(2)
elif port == "":
    print "Missing \"-p port\" parameter."
    usage()
    sys.exit(2)
elif targetServerName == "":
    print "Missing \"-s serverName\" parameter."
    usage()
    sys.exit(2)
elif jmsServerName == "":
    print "Missing \"-j jmsServerName\" parameter."
    usage()
    sys.exit(2)
elif flag == "":
    flag='c'

#redirect('c:/wlst.log',false)	
print "Host      : t3//"+host+":"+port
print "JMSServer : "+targetServerName
print "Log File  : "+log
print "Queue     : "+queueName
print "\n"

redirect(log)
connect(user,credential,'t3://'+host+':'+port)
serverRuntime()
qs=ls('JMSRuntime/'+targetServerName+'.jms/Connections',returnMap='true')
cont=0

for q in qs:
	cont=cont+1
	print str(cont)+"/"+str(qs.size())+" connections"
	a=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/HostAddress')
	sessCount=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/SessionsCurrentCount')	
	if sessCount>0:		
		ss=ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions',returnMap='true')
		#for s in ss:
		if flag=='c':			
			try:
				cc=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/ConsumersCurrentCount')			
				if cc>0:					
					cons=ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Consumers',returnMap='true')	
					#ls('JMSRuntime/wls_jms1.jms/Connections/'+q+'/Sessions/'+s)			
					for c in cons:			
						#print "JMSRuntime/"+targetServerName+".jms/Connections/"+q+"/Sessions/"+ss[0]+"/Consumers/"+c+"/DestinationName"
						d=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Consumers/'+c+'/DestinationName')						
						if d.find(queueName)>-1:
							res='FIND_QUEUE_CONSUMER:'+q+' -> '+a+' -> '+ss[0]+'('+str(ss.size())+') -> '+d
							print res
							#print str(ss[0]+'('+str(ss.size())+')->'+d)	
				else:
					print "No cunsumers"
			except:
				print ""			
		elif flag=='a':
			try:
				cc=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/ConsumersCurrentCount')			
				if cc>0:
					cons=ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Consumers',returnMap='true')				
					#ls('JMSRuntime/wls_jms1.jms/Connections/'+q+'/Sessions/'+s)			
					for c in cons:			
						#print "JMSRuntime/"+targetServerName+".jms/Connections/"+q+"/Sessions/"+ss[0]+"/Consumers/"+c+"/DestinationName"
						d=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Consumers/'+c+'/DestinationName')				
						if d.find(queueName)>-1:
							res='FIND_QUEUE_CONSUMER:'+q+' -> '+a+' -> '+ss[0]+'('+str(ss.size())+') -> '+d
							print res
				else:
					print "No cunsumers"
			except:
				print ""			
		if flag=='p':
			try:
				cc=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/ProducersCurrentCount')
				if cc>0:					
					prod=ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Producers',returnMap='true')
					for p in prod:
						print "Producer info:"
						#d=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Producers/'+p+'/DestinationName')
						ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Producers/'+p)
						print "End producer info"
				else:
					print "No producers"
			except:
				print ""			
		elif flag=='a':
			try:
				cc=get('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/ProducersCurrentCount')
				if cc>0:					
					prod=ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Producers',returnMap='true')
					for p in prod:
						print "Producer info:"
						ls('JMSRuntime/'+targetServerName+'.jms/Connections/'+q+'/Sessions/'+ss[0]+'/Producers/'+p)
						print "End producer info"
				else:
					print "No producers"
			except:
				print ""		
#except:
#	print formatExceptionInfo()

stopRedirect()
disconnect()

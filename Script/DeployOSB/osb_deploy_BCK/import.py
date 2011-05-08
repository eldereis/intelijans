from java.util import HashMap
from java.util import HashSet
from java.util import Map
from java.util import Set
from java.util.Map import Entry
from java.util import ArrayList
from java.util import Hashtable
from java.lang import System
from java.io import FileInputStream

from weblogic.management.mbeanservers.domainruntime import DomainRuntimeServiceMBean
from javax.management.remote import JMXConnector

from weblogic.management.jmx import MBeanServerInvocationHandler
from com.bea.wli.sb.management.configuration import ALSBConfigurationMBean
from com.bea.wli.sb.management.configuration import SessionManagementMBean
from com.bea.wli.config.customization import Customization
from javax.management import ObjectName;
from com.bea.wli.config.resource import Diagnostics
from javax.management.remote import JMXConnectorFactory
from javax.management.remote import JMXServiceURL
from javax.naming import Context
from com.bea.wli.config import Ref
from com.bea.wli.sb.management.importexport import ALSBImportPlan
from com.bea.wli.sb.management.importexport import ALSBImportOperation

import sys
#=======================================================================================
# Entry function to deploy project configuration and resources
# into a OSB domain
#=======================================================================================

def importToALSBDomain(importConfigFile):
	try:
		print 'Loading Deployment config from :', importConfigFile
		exportConfigProp = loadProps(importConfigFile)

		host = exportConfigProp.get("host")
		port = exportConfigProp.get("port")
		intPort = int(port)
		print "Connecting to: " + host + ":" + port
		importUser = exportConfigProp.get("importUser")
		importPassword = exportConfigProp.get("importPassword")

		importJar = exportConfigProp.get("importJar")
		customFile = exportConfigProp.get("customizationFile")

# passphrase = exportConfigProp.get("passphrase")
# project = exportConfigProp.get("project")

		print "Initiate Connection"
		conn = initConnection(host, intPort, importUser, importPassword)
		print "Connection successful"

		mbconn = conn.getMBeanServerConnection()
		obname = DomainRuntimeServiceMBean.OBJECT_NAME
		domainService = MBeanServerInvocationHandler.newProxyInstance(mbconn, ObjectName(obname))
		name = SessionManagementMBean.NAME
		type = SessionManagementMBean.TYPE
		sm = domainService.findService(name, type, None)
		bytes = readBinaryFile(importJar)
		sessionName = "ScriptImport"
		print "sessionName: ", sessionName

		sm.createSession(sessionName)
		alsbSession = domainService.findService(ALSBConfigurationMBean.NAME + "." + sessionName, ALSBConfigurationMBean.TYPE, None)

		alsbSession.uploadJarFile(bytes)
		jarInfo = alsbSession.getImportJarInfo()
		importPlan = jarInfo.getDefaultImportPlan()
		result = alsbSession.importUploaded(importPlan);

		# list of created references
		createdRef = ArrayList()
		operationMap = importPlan.getOperations()
		set = operationMap.entrySet()
		for entry in set:
			ref = entry.getKey()
			createdRef.add(ref)
		# Print out status and build a list of created references. Will be used for customization
		if result.getImported().size() > 0:
			print "The following resources have been imported: "
			for successEntry in result.getImported():
				print successEntry.toString()
		# Check for error and discard session in any resource fails
			failCount = result.getFailed().size()
			if failCount > 0:
				print ""
				print "Failed for: " + failCount + " resources"
#	 print "The following resources failed to import"
#	 for entry in result.getFailed().entrySet():
#	 ref = entry.getKey()
#	 diagnostics = entry.getValue().toString()
#	 print ref + " Reason: " + diagnostics
#	 abort = true
#	 raise

#=================================================
# Apply Customizations
#=================================================
#customize if a customization file is specified
#affects only the created resources
		if customFile != None :
			print "Loading customization File: " + customFile
			print "Customization applied to the created resources only" + createdRef.toString()
			iStream = FileInputStream(customFile)
			customizationList = Customization.fromXML(iStream)
			filteredCustomizationList = ArrayList()
			setRef = HashSet(createdRef)

# apply a filter to all the customizations to narrow the target to the created resources
			for customization in customizationList:
				newcustomization = customization.clone(setRef)
				filteredCustomizationList.add(newcustomization)

			alsbSession.customize(filteredCustomizationList)
#=========================
# Activate Session
#=========================
		sm.activateSession(sessionName, "Imported Configuration")
		print "Project imported"
		conn.close()
	except:
		print "Unexpected error:", sys.exc_info()[0]
		print "Discarding the session."
		sm.discardSession(sessionName)
		conn.close()
		raise

#==================================================
# Utility function for initiating connection
#================================================
def initConnection(hostname, port, username, password):
	serviceURL = JMXServiceURL("t3", hostname, port,"/jndi/" + DomainRuntimeServiceMBean.MBEANSERVER_JNDI_NAME)
	h=Hashtable()
	h.put(Context.SECURITY_PRINCIPAL, username)
	h.put(Context.SECURITY_CREDENTIALS, password)
	h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote")
	return JMXConnectorFactory.connect(serviceURL, h)

#=======================================================================================
# Utility function to print the list of operations
#=======================================================================================
def printOpMap(map):
	set = map.entrySet()
	for entry in set:
		op = entry.getValue()
		print op.getOperation(),
		ref = entry.getKey()
		print ref
	print

#=======================================================================================
# Utility function to print the diagnostics
#=======================================================================================
def printDiagMap(map):
	set = map.entrySet()
	for entry in set:
		diag = entry.getValue().toString()
		print diag
	print

#=======================================================================================
# Utility function to load properties from a config file
#=======================================================================================

def loadProps(configPropFile):
	propInputStream = FileInputStream(configPropFile)
	configProps = Properties()
	configProps.load(propInputStream)
	return configProps

#=======================================================================================
# Connect to the Admin Server
#=======================================================================================

def connectToServer(username, password, url):
	connect(username, password, url)
	domainRuntime()

#=======================================================================================
# Utility function to read a binary file
#=======================================================================================
def readBinaryFile(fileName):
	file = open(fileName, 'rb')
	bytes = file.read()
	return bytes

#=======================================================================================
# Utility function to create an arbitrary session name
#=======================================================================================
def createSessionName():
	sessionName = String("SessionScript"+Long(System.currentTimeMillis()).toString())
	return sessionName

#=======================================================================================
# Utility function to load a session MBeans
#=======================================================================================
def getSessionMBean(sessionName):
	SessionMBean = findService("Session","com.bea.wli.config.mbeans.SessionMBean")
	SessionMBean.createSession(sessionName)
	return SessionMBean

# IMPORT script init
try:
# import the service bus configuration
# argv[1] is the export config properties file
	importToALSBDomain(sys.argv[1])

except:
	print "Unexpected error: ", sys.exc_info()[0]
	dumpStack()
	raise
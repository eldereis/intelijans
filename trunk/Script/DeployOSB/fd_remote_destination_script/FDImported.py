def createRemoteDestination(fdModuleName, foreignServer, foreignDestination):
	cd('/')
	mb = getMBean('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/ForeignServers/'+foreignServer+'/ForeignDestinations/'+foreignDestination)
	if mb:
		print foreignDestination + " already exists"
		return
	cd('/')
	cd('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/ForeignServers/'+foreignServer)
	cmo.createForeignDestination(foreignDestination)
	cd('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/ForeignServers/'+foreignServer+'/ForeignDestinations/'+foreignDestination)
	cmo.setLocalJNDIName(foreignDestination)
	cmo.setRemoteJNDIName(foreignDestination)

def createRemoteCF(fdModuleName, foreignServer, foreignCF):
	mb = getMBean('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/ForeignServers/'+foreignServer+'/ForeignConnectionFactories/'+foreignCF)
	if mb:
		print foreignCF+ " already exists"
		return

	cd('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/ForeignServers/'+foreignServer)
	cmo.createForeignConnectionFactory(foreignCF)
	cd('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/ForeignServers/'+foreignServer+'/ForeignConnectionFactories/'+foreignCF)
	cmo.setLocalJNDIName(foreignCF)
	cmo.setRemoteJNDIName(foreignCF)
  

try:
	loadProperties('ForeignDestination.properties')  
	connect(wls_username, wls_password, wls_url)
	edit()
	startEdit()
	fileInput = open("fdConfig.txt",'r')
	fileLines = fileInput.readlines()
	fileInput.close()
	for line in fileLines:
		line = line.rstrip()
		opts = line.split(" ")
		fdModuleName = opts[0]
		foreignServer = opts[1]
		foreignDestination = opts[2]
		foreignCF = opts[3]
		createRD = [4]
 		if createRD:
			createRemoteDestination(fdModuleName, foreignServer, foreignDestination)
			createRemoteCF(fdModuleName, foreignServer, foreignCF)
      
	save()
	activate(block="true")
	disconnect()  
except:
		dumpStack()
		print "Unexpected error:", sys.exc_info()
		cancelEdit()
		raise 


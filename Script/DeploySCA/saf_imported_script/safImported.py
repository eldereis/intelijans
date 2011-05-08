def createSafImported(fdModuleName, nomeCodaLocale, jndiCoda):
	mb = getMBean('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/SAFImportedDestinations/JmsHubSAFImportedDestinations/SAFQueues/'+nomeCodaLocale)
	if mb:
		print nomeCodaLocale + " already exists"
		return
	cd('/')
	cd('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/SAFImportedDestinations/JmsHubSAFImportedDestinations')
	cmo.createSAFQueue(nomeCodaLocale)
	cd('/JMSSystemResources/'+fdModuleName+'/JMSResource/'+fdModuleName+'/SAFImportedDestinations/JmsHubSAFImportedDestinations/SAFQueues/'+nomeCodaLocale)
	cmo.setRemoteJNDIName(jndiCoda)
try:
	loadProperties('safImported.properties')  
	connect(wls_username, wls_password, wls_url)
	edit()
	startEdit()
	fileInput = open("SafConfig.txt",'r')
	fileLines = fileInput.readlines()
	fileInput.close()
	for line in fileLines:
		line = line.rstrip()
		opts = line.split(" ")
		fdModuleName = opts[0]
		nomeCodaLocale = opts[1]
		jndiCoda = opts[2]
		createSAF = [3]
		if createSAF:
			createSafImported(fdModuleName, nomeCodaLocale, jndiCoda)    
	save()
	activate(block="true")
	disconnect()  
except:
		dumpStack()
		print "Unexpected error:", sys.exc_info()
		cancelEdit()
		raise 
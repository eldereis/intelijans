loadProperties('safProperties.properties')

try:
  connect(wls_username, wls_password, wls_url) 
  
  edit()
  startEdit()
  cd('/')
  cmo.createFileStore('JMS_HUB_LOG_FILESTORE_1')
  cd('/Deployments/JMS_HUB_LOG_FILESTORE_1')
  cmo.setDirectory('OSB_SAF_FS1')
  set('Targets',jarray.array([ObjectName('com.bea:Name=WLS_OSB1,Type=Server')], ObjectName))
  cd('/')
  cmo.createFileStore('JMS_HUB_LOG_FILESTORE_2')
  cd('/Deployments/JMS_HUB_LOG_FILESTORE_2')
  cmo.setDirectory('OSB_SAF_FS2')
  set('Targets',jarray.array([ObjectName('com.bea:Name=WLS_OSB2,Type=Server')], ObjectName))
  cd('/')
  cmo.createSAFAgent('JMS_HUB_SAF_1')
  cd('/SAFAgents/JMS_HUB_SAF_1')
  cmo.setStore(getMBean('/Deployments/JMS_HUB_LOG_FILESTORE_1'))
  set('Targets',jarray.array([ObjectName('com.bea:Name=WLS_OSB1,Type=Server')], ObjectName))
  cmo.setServiceType('Sending-only')
  cd('/')
  cmo.createSAFAgent('JMS_HUB_SAF_2')
  cd('/SAFAgents/JMS_HUB_SAF_2')
  cmo.setStore(getMBean('/Deployments/JMS_HUB_LOG_FILESTORE_2'))
  set('Targets',jarray.array([ObjectName('com.bea:Name=WLS_OSB2,Type=Server')], ObjectName))
  cmo.setServiceType('Sending-only')
  save()
  activate(block="true") 
  disconnect()
except:
  dumpStack();
  print "Unexpected error:", sys.exc_info()
  cancelEdit();
  raise
loadProperties('safProperties.properties')

try:
  connect(wls_username, wls_password, wls_url) 
  
  edit()
  startEdit()
  cd('/')
  cmo.createFileStore('JMS_HUB_LOG_FILESTORE1')
  cd('/Deployments/JMS_HUB_LOG_FILESTORE1')
  cmo.setDirectory('OSB_SAF_FS')
  set('Targets',jarray.array([ObjectName('com.bea:Name=wls_osb1,Type=Server')], ObjectName))
  cd('/')
  cmo.createSAFAgent('JMS_HUB_SAF1')
  cd('/SAFAgents/JMS_HUB_SAF1')
  cmo.setStore(getMBean('/Deployments/JMS_HUB_LOG_FILESTORE1'))
  set('Targets',jarray.array([ObjectName('com.bea:Name=wls_osb1,Type=Server')], ObjectName))
  cmo.setServiceType('Sending-only')
  save()
  activate(block="true") 
  disconnect()
except:
  dumpStack();
  print "Unexpected error:", sys.exc_info()
  cancelEdit();
  raise

def createUdq(jmsModule, qName, qJndiName, qSubdeploymentName, redeliveryLimit, redeliveryDelay, errorDest):
  mb = getMBean("/JMSSystemResources/" + jmsModuleName + "/JMSResource/" + jmsModuleName + "/UniformDistributedQueues/" + qName)
  if mb:
    print qName + " already exists"
    return
    
  if errorDest:
    errorQName=qName + "_error"
    errorQJndiName=qJndiName + "_error"
    eUdq = jmsModule.createUniformDistributedQueue(errorQName)
    eUdq.setJNDIName(errorQJndiName)
    eUdq.setSubDeploymentName(qSubdeploymentName)
    eUdq.setForwardDelay(1)  
  udq = jmsModule.createUniformDistributedQueue(qName)
  udq.setJNDIName(qJndiName)
  udq.setForwardDelay(1)
  dfp = udq.getDeliveryFailureParams() 
  if errorDest:
    dfp.setErrorDestination(eUdq)
    dfp.setExpirationPolicy('Redirect')
    dfp.setRedeliveryLimit(int(redeliveryLimit))
  dpo = udq.getDeliveryParamsOverrides()
  dpo.setRedeliveryDelay(long(redeliveryDelay))
  udq.setSubDeploymentName(qSubdeploymentName)  

def createErrorQueue(jmsModule, errorJndi, qSubdeploymentName, redeliveryDelay):
	mb = getMBean("/JMSSystemResources/" + jmsModuleName + "/JMSResource/" + jmsModuleName + "/UniformDistributedQueues/" + errorJndi)
	if mb:
		print errorJndi + " already exists"
		return
	udq = jmsModule.createUniformDistributedQueue(errorJndi)
	udq.setJNDIName(errorJndi)
	udq.setForwardDelay(1)
	dpo = udq.getDeliveryParamsOverrides()
	dpo.setRedeliveryDelay(long(redeliveryDelay))
	udq.setSubDeploymentName(qSubdeploymentName)
	

def createConnectionFactory(jmsModule, cluster, cfName, cfJndiName, isXa):
  mb = getMBean("/JMSSystemResources/" + jmsModuleName + "/JMSResource/" + jmsModuleName + "/ConnectionFactories/" + cfName)
  if mb:
    print cfName + " already exists"
    return
    
  factory = jmsModule.createConnectionFactory(cfName)
  factory.setJNDIName(cfJndiName)
  factory.setSubDeploymentName("clusterSubdeployment")
  trn = factory.getTransactionParams()
  if isXa:
    trn.setXAConnectionFactoryEnabled(true)
  lb = factory.getLoadBalancingParams()
  lb.setServerAffinityEnabled(true)

try:
  loadProperties('wls.properties')
  loadProperties('queue.properties')
  
  connect(username,password,url)
  edit()
  startEdit()

  
  cluster = getMBean("Clusters/jms_cluster1")
  jmsModule = getMBean("JMSSystemResources/" + jmsModuleName) 
  jmsResource = jmsModule.getJMSResource()

  fileInput = open("queueConfig.txt",'r')
  fileLines = fileInput.readlines()
  fileInput.close()
  
  for line in fileLines:
    line = line.rstrip()
    opts = line.split(" ")
    systemId = opts[0]
    createInboundRequest = int(opts[1])
    createInboundResponse = int(opts[2])
    createOutboundRequest = int(opts[3])
    createOutboundResponse = int(opts[4])
    createXaCf = int(opts[5])
    createNonXaCf = int(opts[6])
    createErrorDestinations = int(opts[7])
    createEntityCf = int(opts[8])
    createEntityXaCf = int(opts[9])
    createExtErrorDestinations = int(opts[10])
    entityId = opts[11]
    
    cfName = "attip.jms." + systemId + ".cf"
    xaCfName = "attip.jms." + systemId + ".xacf"
    entityCfName = "attip.jms." + entityId + ".cf"
    entityXaCfName = "attip.jms." + entityId + ".xacf"
    ireq = "attip.jms." + systemId + "." + entityId + "_to_aTTIP_request"
    ires = "attip.jms." + systemId + "." + entityId + "_to_aTTIP_response"
    oreq = "attip.jms." + systemId + ".aTTIP_to_" + entityId + "_request"
    ores = "attip.jms." + systemId + ".aTTIP_to_" + entityId + "_response"
    errorJndi = "attip.jms." + systemId  + "." + entityId + "_to_aTTIP_error"
 
    if createXaCf:
      createConnectionFactory(jmsResource, cluster, xaCfName, xaCfName, true)
    
    if createNonXaCf:
      createConnectionFactory(jmsResource, cluster, cfName, cfName, false)
   
    if createInboundRequest:
      createUdq(jmsResource, ireq, ireq, subName, redeliveryLimit, redeliverDelay, createErrorDestinations)
      
    if createInboundResponse:
      createUdq(jmsResource, ires, ires, subName, redeliveryLimit, redeliverDelay, createErrorDestinations)
      
    if createOutboundRequest:
      createUdq(jmsResource, oreq, oreq, subName, redeliveryLimit, redeliverDelay, createErrorDestinations)
    
    if createOutboundResponse:
      createUdq(jmsResource, ores, ores, subName, redeliveryLimit, redeliverDelay, createErrorDestinations)

    if createEntityCf:
      createConnectionFactory(jmsResource, cluster, entityCfName, entityCfName, false)
    
    if createEntityXaCf:
	createConnectionFactory(jmsResource, cluster, entityXaCfName, entityXaCfName, false)
		
    if createExtErrorDestinations:
	createErrorQueue(jmsResource, errorJndi, subName, redeliverDelay)
      
  save()
  activate(block="true")
  disconnect()  
except:
    dumpStack()
    print "Unexpected error:", sys.exc_info()
    cancelEdit()
    raise 
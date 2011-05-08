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

  
  cluster = getMBean("Clusters/jms_cluster")
  jmsModule = getMBean("JMSSystemResources/" + jmsModuleName) 
  jmsResource = jmsModule.getJMSResource()

  fileInput = open("queueConfigInternal.txt",'r')
  fileLines = fileInput.readlines()
  fileInput.close()
  
  for line in fileLines:
    line = line.rstrip()
    opts = line.split(" ")
    systemId = opts[0]
    print systemId + " systemId "
    createInboundRequest = int(opts[1])
    print opts[1]+ " createInboundRequest "
    createInboundResponse = int(opts[2])
    print opts[2]+ " createInboundResponse "
    createOutboundRequest = int(opts[3])
    print opts[3]+ " createOutboundRequest "
    createOutboundResponse = int(opts[4])
    print opts[4]+ " createOutboundResponse "
    createXaCf = int(opts[5])
    print opts[5]+ " createXaCf "
    createNonXaCf = int(opts[6])
    print opts[6]+ " createNonXaCf "
    createErrorDestinations = int(opts[7])
    print opts[7]+ " createErrorDestinations "
    
    cfName = "internal." + systemId + ".cf"
    xaCfName = "internal." + systemId + ".xacf"
    ireq = "internal." + systemId + "." + "SOA_to_OSB.request"
    ires = "internal." + systemId + "." + "SOA_to_OSB.response"
    oreq = "internal." + systemId + "." + "OSB_to_SOA.request"
    ores = "internal." + systemId + "." + "OSB_to_SOA.response"
 
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
      
  save()
  activate(block="true")
  disconnect()  
except:
    dumpStack()
    print "Unexpected error:", sys.exc_info()
    cancelEdit()
    raise 
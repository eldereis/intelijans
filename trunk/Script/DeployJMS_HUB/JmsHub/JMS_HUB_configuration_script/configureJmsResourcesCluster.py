def createJmsModule(moduleName, cluster):
  cd('/')
  jmsModule=cmo.createJMSSystemResource('aTTIP_JmsModule')
  jmsModule.addTarget(cluster)
  return jmsModule
	
def createClusterSubdeployment(jmsModule, cluster):
  sub = jmsModule.createSubDeployment("clusterSubdeployment")
  jmsModule.addTarget(cluster)
  
def createSubdeployment(jmsModule, subName):
  sub = jmsModule.createSubDeployment(subName)
  jmsServer=getMBean("JMSServers/jms_server1")
  sub.addTarget(jmsServer)
#  jmsServer=getMBean("JMSServers/jms_server2")
#  sub.addTarget(jmsServer)
	
def createConnectionFactory(jmsModule, cluster, cfName, cfJndiName):
  factory = jmsModule.createConnectionFactory(cfName)
  factory.setJNDIName(cfJndiName)
  factory.setSubDeploymentName("clusterSubdeployment")
  trn = factory.getTransactionParams()
  trn.setXAConnectionFactoryEnabled(true)
  lb = factory.getLoadBalancingParams()
  lb.setServerAffinityEnabled(true)

try:
  loadProperties('wls.properties')
  connect(username,password,url)
  edit()
  startEdit()

  cluster = getMBean("Clusters/jms_cluster1")

  jmsModule = createJmsModule("aTTIP_JmsModule", cluster)  
  createSubdeployment(jmsModule, subName)
  createClusterSubdeployment(jmsModule, cluster)
  jmsResource = jmsModule.getJMSResource()
  createConnectionFactory(jmsResource, cluster, "aTTIP_xaCf", "attip/jmshub/xacf")
  
  save()
  activate(block="true")
  disconnect()  
except:
    dumpStack()
    print "Unexpected error:", sys.exc_info()
    cancelEdit()
    raise 


print('************************************')
print('*                                  *')
print('* Delete MDS Metadata              *')
print('*                                  *')
print('************************************')

connect('weblogic', 'weblogic!1', 't3://ttsvint1:7001')

svrs = cmo.getServers() 
print 'Servers in the domain are' 
for x in svrs: print x.getName()

deleteMetadata(application='soa-infra', server='wls_soa1', docs='/apps/**')


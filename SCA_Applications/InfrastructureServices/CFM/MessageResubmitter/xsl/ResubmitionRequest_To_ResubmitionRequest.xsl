<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="WSDL">
      <schema location="../PickFromOSBJMS.wsdl"/>
      <rootElement name="ResubmitionRequest" namespace="http://www.turktelekom.com.tr/aTTIP/Schemas/InfrastructureServices/CFM/MessageResubmitter/1.0"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="WSDL">
      <schema location="../ResubmiterProcess.wsdl"/>
      <rootElement name="ResubmitionRequest" namespace="http://www.turktelekom.com.tr/aTTIP/Schemas/InfrastructureServices/CFM/MessageResubmitter/1.0"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.3.0(build 100415.2045.2557) AT [THU SEP 09 15:07:34 CEST 2010]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:imp1="http://www.turktelekom.com.tr/aTTIP/Schemas/Utilities/CentralizedFaultManagement/MessageResubmitter/1.0"
                xmlns:bpel2="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:ns1="http://www.turktelekom.com.tr/aTTIP/Schemas/InfrastructureServices/CFM/MessageResubmitter/1.0"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:plt="http://schemas.xmlsoap.org/ws/2003/05/partner-link/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ns0="http://xmlns.oracle.com/pcbpel/adapter/jms/CFM/MessageResubmitter/PickFromOSBJMS"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:tns="http://xmlns.oracle.com/pcbpel/adapter/jms/SOA_Application/MessageResubmitter/OSBFaultHandlingRequestQueueJMSIn"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:client="http://xmlns.oracle.com/SOA_Application_jws/MessageResubmitter/ResubmiterProcess"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl ns1 plt wsdl ns0 xsd client xp20 bpws bpel2 bpm ora socket mhdr oraext dvm hwf med ids xdk xref ldap">
  <xsl:template match="/">
    <ns1:ResubmitionRequest>
      <ns1:RoutingInfo>
        <ns1:DestinationQueueJNDI>
          <xsl:value-of select="/ns1:ResubmitionRequest/ns1:RoutingInfo/ns1:DestinationQueueJNDI"/>
        </ns1:DestinationQueueJNDI>
        <ns1:ProxyService>
          <xsl:value-of select="/ns1:ResubmitionRequest/ns1:RoutingInfo/ns1:ProxyService"/>
        </ns1:ProxyService>
        <ns1:BusinessService>
          <xsl:value-of select="/ns1:ResubmitionRequest/ns1:RoutingInfo/ns1:BusinessService"/>
        </ns1:BusinessService>
        <ns1:JmsProperties>
          <xsl:for-each select="/ns1:ResubmitionRequest/ns1:RoutingInfo/ns1:JmsProperties/ns1:JmsProperty">
            <ns1:JmsProperty>
              <ns1:Name>
                <xsl:value-of select="ns1:Name"/>
              </ns1:Name>
              <ns1:Value>
                <xsl:value-of select="ns1:Value"/>
              </ns1:Value>
            </ns1:JmsProperty>
          </xsl:for-each>
          <imp1:JmsProperty>
            <imp1:Name>
              <xsl:text disable-output-escaping="no">Composite Instance Id</xsl:text>
            </imp1:Name>
            <imp1:Value>
              <xsl:value-of select='mhdr:getProperty("in.property.tracking.compositeInstanceId")'/>
            </imp1:Value>
          </imp1:JmsProperty>
        </ns1:JmsProperties>
      </ns1:RoutingInfo>
      <xsl:copy-of select="/ns1:ResubmitionRequest/ns1:OriginalMessage">
        <?oracle-xsl-mapper-position ns1:OriginalMessage?>
      </xsl:copy-of>
      <xsl:copy-of select="/ns1:ResubmitionRequest/ns1:OriginalFault">
        <?oracle-xsl-mapper-position ns1:OriginalFault?>
      </xsl:copy-of>
      <ns1:Timestamp>
        <xsl:value-of select="/ns1:ResubmitionRequest/ns1:Timestamp"/>
      </ns1:Timestamp>
      <ns1:ServiceName>
        <xsl:value-of select="/ns1:ResubmitionRequest/ns1:ServiceName"/>
      </ns1:ServiceName>
      <ns1:SourceSystem>
        <xsl:value-of select="/ns1:ResubmitionRequest/ns1:SourceSystem"/>
      </ns1:SourceSystem>
      <ns1:Typology>
        <xsl:value-of select="/ns1:ResubmitionRequest/ns1:Typology"/>
      </ns1:Typology>
      <ns1:CompositeInstanceID>
        <xsl:value-of select="/ns1:ResubmitionRequest/ns1:CompositeInstanceID"/>
      </ns1:CompositeInstanceID>
    </ns1:ResubmitionRequest>
  </xsl:template>
</xsl:stylesheet>
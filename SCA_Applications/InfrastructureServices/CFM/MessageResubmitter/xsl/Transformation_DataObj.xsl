<?xml version="1.0" encoding="UTF-8" ?>
<?oracle-xsl-mapper
  <!-- SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY. -->
  <mapSources>
    <source type="XSD">
      <schema location="oramds:/apps/InfrastructureServices/CFM/Shared/1.0/MessageResubmitter.xsd"/>
      <rootElement name="ResubmitionRequest" namespace="http://www.turktelekom.com.tr/aTTIP/Schemas/InfrastructureServices/CFM/MessageResubmitter/1.0"/>
    </source>
  </mapSources>
  <mapTargets>
    <target type="XSD">
      <schema location="oramds:/apps/UtilityServices/BAM/v1/BAMDataObject.xsd"/>
      <rootElement name="BAMDataObject" namespace="http://www.turktelekom.com.tr/aTTIP/Utilities/BAMDataObject"/>
    </target>
  </mapTargets>
  <!-- GENERATED BY ORACLE XSL MAPPER 11.1.1.3.0(build 100415.2045.2557) AT [WED JAN 19 12:30:31 CET 2011]. -->
?>
<xsl:stylesheet version="1.0"
                xmlns:bpws="http://schemas.xmlsoap.org/ws/2003/03/business-process/"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:bpel2="http://docs.oasis-open.org/wsbpel/2.0/process/executable"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:bam="http://www.turktelekom.com.tr/aTTIP/Utilities/BAMDataObject"
                xmlns:hwf="http://xmlns.oracle.com/bpel/workflow/xpath"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:med="http://schemas.oracle.com/mediator/xpath"
                xmlns:mr="http://www.turktelekom.com.tr/aTTIP/Schemas/InfrastructureServices/CFM/MessageResubmitter/1.0"
                xmlns:ids="http://xmlns.oracle.com/bpel/services/IdentityService/xpath"
                xmlns:bpm="http://xmlns.oracle.com/bpmn20/extensions"
                xmlns:xdk="http://schemas.oracle.com/bpel/extension/xpath/function/xdk"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema"
                xmlns:ora="http://schemas.oracle.com/xpath/extension"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:ldap="http://schemas.oracle.com/xpath/extension/ldap"
                exclude-result-prefixes="xsi xsl mr xsd bam bpws xp20 mhdr bpel2 oraext dvm hwf med ids bpm xdk xref ora socket ldap">
  <xsl:template match="/">
    <bam:BAMDataObject>
      <bam:IntegrationFlow>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:IntegrationFlow>
      <bam:ServiceName>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:ServiceName>
      <bam:Type>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:Type>
      <bam:SubType>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:SubType>
      <bam:Status>
        <xsl:text disable-output-escaping="no">Error</xsl:text>
      </bam:Status>
      <bam:CreationDate>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:CreationDate>
      <bam:LastUpdate>
        <xsl:value-of select="xp20:current-dateTime()"/>
      </bam:LastUpdate>
      <bam:System>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:System>
      <bam:InstanceID>
        <xsl:value-of select='concat(/mr:ResubmitionRequest/mr:RoutingInfo/mr:JmsProperties/mr:JmsProperty[mr:Name = "businessID"]/mr:Value,":",/mr:ResubmitionRequest/mr:RoutingInfo/mr:JmsProperties/mr:JmsProperty[mr:Name = "conversationID"]/mr:Value)'/>
      </bam:InstanceID>
      <bam:ErrorCD>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:ErrorCD>
      <bam:ErrorFD>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:ErrorFD>
      <bam:TypeError>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:TypeError>
      <bam:CodeError>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:CodeError>
      <bam:TypeOfService>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:TypeOfService>
      <bam:FlagExistError>
        <xsl:text disable-output-escaping="no"></xsl:text>
      </bam:FlagExistError>
    </bam:BAMDataObject>
  </xsl:template>
</xsl:stylesheet>

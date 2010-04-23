<?xml version='1.0'?>
<xsl:stylesheet version='1.0'
    xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>
<xsl:output method="html"/>

<xsl:template match="/">
 <xsl:variable name="CompactCount" select="count(//DATA)"/>
 <xsl:variable name="AgentCount" select="count(//REAgent)"/>
 <xsl:if test="$AgentCount > 0">
 <table border="1">
  <tr>
    <td>
    <b>Name</b>
   </td>
    <td>
    <b>Agent ID</b>
   </td>
    <td>
    <b>Office ID</b>
   </td>
   <td>
    <b>Office Phone</b>
   </td>
   <td>
    <b>Home Phone</b>
   </td>
   <td>
    <b>Street Name</b>
   </td>
   <td>
    <b>City</b>
   </td>
   <td>
    <b>State</b>
   </td>
   <td>
    <b>Zip</b>
   </td>
  </tr>
   <xsl:apply-templates select="//REAgent"/>
 </table>
 </xsl:if>
 <xsl:if test="$CompactCount > 0">
   <table border="1">
      COMPACT FORMAT
      <xsl:apply-templates select="//COLUMNS"/>
      <xsl:apply-templates select="//DATA"/>
   </table>
 </xsl:if>	
 <xsl:if test="$AgentCount &lt; 1">
    <xsl:if test="$CompactCount &lt; 1"> 
       <b>No Properties Found</b>
    </xsl:if>	
 </xsl:if>	
</xsl:template>

<xsl:template match="COLUMNS">
    <tr>
       <font face="Bold" size="4">
       <xsl:for-each select='c'>
       
          <td><xsl:value-of select = "." /></td>
       </xsl:for-each>
       </font>
   </tr>
</xsl:template>
<xsl:template match="DATA">
    <tr>
       <xsl:for-each select='d'>
       
          <td><xsl:value-of select = "." />
          <xsl:if test=". = ''">
              <xsl:text disable-output-escaping="no">_</xsl:text>
          </xsl:if>
          
          </td>
          
       </xsl:for-each>
   </tr>
</xsl:template>



<xsl:template match="REAgent">
  <tr>
    <td>
		<a><xsl:attribute name="href">searchPropertyAction.jsp?searchQuery=%28ListAgentAgentID%3D<xsl:value-of select="AgentID"/>%29&amp;queryType=DMQL</xsl:attribute><xsl:value-of select="LastName"/>, <xsl:value-of select="FirstName"/></a>
   </td>
    <td>
    <xsl:value-of select="AgentID"/> 
   </td>
    <td>
		<!-- NRDSMemberID is really not the office id, just used it because agent does not have an office ID??? -->
		<a><xsl:attribute name="href">searchOfficeAction.jsp?searchQuery=%28OfficeID%3D<xsl:value-of select="NRDSMemberID"/>%29&amp;queryType=DMQL</xsl:attribute><xsl:value-of select="NRDSMemberID"/></a>
   </td>
   <td>
    <xsl:value-of select="ContactInformation/OfficePhone"/>
   </td>
    <td>
    <xsl:value-of select="ContactInformation/HomePhone"/>
   </td>
    <td>
    <xsl:value-of select="StreetAddress/StreetName"/>
   </td>
    <td>
    <xsl:value-of select="StreetAddress/City"/>
   </td>
    <td>
    <xsl:value-of select="StreetAddress/StateOrProvince"/>
   </td>
    <td>
    <xsl:value-of select="StreetAddress/PostalCode"/>
   </td>
  </tr>
</xsl:template>

</xsl:stylesheet>

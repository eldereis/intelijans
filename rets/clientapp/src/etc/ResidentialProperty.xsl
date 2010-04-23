<?xml version='1.0'?>

<xsl:stylesheet version='1.0'

    xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

<xsl:output method="html"/>
<xsl:param name="version" select="'RETS/1.0'" />
<xsl:template match="/">

 <xsl:variable name="PropertyCount" select="count(//ResidentialProperty)"/>
 <xsl:variable name="CompactCount" select="count(//DATA)"/>
 <xsl:if test="$PropertyCount > 0">
   <table border="1">
    <tr>
     <td>
      <b>Listing ID</b>
     </td>
     <td>
      <b>Listing Agent ID</b>
     </td>
      <td>
      <b>Price</b>
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
     <td>
      <b>Photos</b>
     </td>
      <td>
      	<b>Update</b>
      </td>
    </tr>
     <xsl:apply-templates select="//ResidentialProperty"/>
   </table>
 </xsl:if>
 <xsl:if test="$CompactCount > 0">
   <table border="1">
      <xsl:apply-templates select="//COLUMNS"/>
      <xsl:apply-templates select="//DATA"/>
   </table>
 </xsl:if>	
 <xsl:if test="$PropertyCount &lt; 1">
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


<xsl:template match="ResidentialProperty">
  <tr>
    <td>
    <xsl:value-of select="Listing/ListingID"/>
   </td>
    <td>
<a><xsl:attribute name="href">searchAgentAction.jsp?searchQuery=%28ListAgentAgentID%3D<xsl:value-of select="Listing/ListingData/REAgent/AgentID"/>%29&amp;QueryType=DMQL&amp;searchStandardNames=1</xsl:attribute><xsl:value-of select="Listing/ListingData/REAgent/AgentID"/></a>
   </td>
   <td>
    $<xsl:value-of select="Listing/ListingData/ListPrice"/>
   </td>

    <td>

    <xsl:value-of select="Listing/StreetAddress/StreetNumber"/><xsl:value-of select="Listing/StreetAddress/StreetName"/>

   </td>

    <td>

    <xsl:value-of select="Listing/StreetAddress/City"/>

   </td>

    <td>

    <xsl:value-of select="Listing/StreetAddress/StateOrProvince"/>

   </td>

    <td>

    <a><xsl:attribute name="href">searchPropertyAction.jsp?searchQuery=%28PostalCode%3D<xsl:value-of select="Listing/StreetAddress/PostalCode"/>%29&amp;QueryType=DMQL&amp;searchLimit=20&amp;searchClass=ResidentialProperty&amp;searchStandardNames=1</xsl:attribute><xsl:value-of select="Listing/StreetAddress/PostalCode"/></a>

   </td>

    <td>
       <a><xsl:attribute name="href">getObjectAction.jsp?resource=Property&amp;type=Photo&amp;ID=<xsl:value-of select="Listing/ListingID"/>:*</xsl:attribute>Photo</a>		  
   </td>
   <td>
   		<a><xsl:attribute name="href">update.jsp?id=<xsl:value-of select="Listing/ListingID"/>&amp;searchClass=ResidentialProperty</xsl:attribute>Update</a>
   	</td>

  </tr>

</xsl:template>



</xsl:stylesheet>


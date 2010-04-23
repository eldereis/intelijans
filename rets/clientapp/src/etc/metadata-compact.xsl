<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

 <!-- <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/> -->

<xsl:output method="xml" version="1.0" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>

<xsl:param name="depth" select="'*'"/>
<xsl:param name="delimiter" select="'|'"/>

<xsl:strip-space elements="*"/>

<!-- identity transformation -->
<xsl:template match="@*|node()" mode="ident">
  <xsl:copy>
    <xsl:apply-templates select="@*|node()" mode="ident"/>
  </xsl:copy>
</xsl:template>

<xsl:template name="dumpall">
    <xsl:if test="$depth = '*'">
           <xsl:for-each select="//METADATA-SYSTEM|//METADATA-RESOURCE|//METADATA-FOREIGN_KEY|//METADATA-CLASS|//METADATA-TABLE|//METADATA-UPDATE|//METADATA-UPDATE_TYPE|//METADATA-OBJECT|//METADATA-SEARCH_HELP|//METADATA-LOOKUP|//METADATA-LOOKUP_TYPE|//METADATA-VALIDATION_LOOKUP|//METADATA-VALIDATION_LOOKUP_TYPE|//METADATA-VALIDATION_EXTERNAL|//METADATA-VALIDATION_EXTERNAL_TYPE|//METADATA-VALIDATION_EXPRESSION|//METADATA-EDITMASK|//METADATA-UPDATE_HELP">
               <xsl:call-template name="dumpone"/>
           </xsl:for-each>
    </xsl:if>
</xsl:template>

<xsl:template match="METADATA-SYSTEM|METADATA-RESOURCE|METADATA-FOREIGN_KEY|METADATA-CLASS|METADATA-TABLE|METADATA-UPDATE|METADATA-UPDATE_TYPE|METADATA-OBJECT|METADATA-SEARCH_HELP|METADATA-LOOKUP|METADATA-LOOKUP_TYPE|METADATA-VALIDATION_LOOKUP|METADATA-VALIDATION_LOOKUP_TYPE|METADATA-VALIDATION_EXTERNAL|METADATA-VALIDATION_EXTERNAL_TYPE|METADATA-VALIDATION_EXPRESSION|METADATA-EDITMASK|METADATA-UPDATE_HELP">
    <xsl:call-template name="dumpone"/>
    <xsl:if test="$depth = '*'">
        <xsl:call-template name="dumpall"/>
    </xsl:if>

</xsl:template>

<xsl:template name="dumpone" match="node()" mode="dump">
           <xsl:choose>
            <!--  name is different in compact-->
            <xsl:when test="name() = 'METADATA-FOREIGN_KEY'">
                  <xsl:element name="METADATA-FOREIGNKEYS">
                    <xsl:apply-templates select="@Version" mode="ident"/>
                    <xsl:apply-templates select="@Date" mode="ident"/>
                    <xsl:apply-templates select="*[position() = 1]" mode="columns"/>
                     <xsl:apply-templates select="node()" mode="data"/>
                 </xsl:element>
            </xsl:when>
           <!-- METADATA-SYSTEM's format is different from others in Compact -->
            <xsl:when test="name() = 'METADATA-SYSTEM'">
                  <xsl:copy>
                    <xsl:apply-templates select="@Version" mode="ident"/>
                    <xsl:apply-templates select="@Date" mode="ident"/>
                    <!-- System tag is Uppercase in Compact -->
                    <xsl:element name="SYSTEM">
                        <xsl:attribute name="SystemID">
                            <xsl:value-of select="System/SystemID"/>
                        </xsl:attribute>
                        <xsl:attribute name="SystemDescription">
                            <xsl:value-of select="System/SystemDescription"/>
                        </xsl:attribute>
                    </xsl:element>
                    <!-- Comments tag is Uppercase in Compact -->
                    <xsl:element name="COMMENTS">
                        <xsl:value-of select="System/Comments"/>
                    </xsl:element>
                  </xsl:copy>
            </xsl:when>
            <!-- in all othercases, only display certain attributes -->
            <xsl:otherwise>
              <xsl:copy>
                 <xsl:apply-templates select="@Resource" mode="ident"/>
                 <xsl:apply-templates select="@Class" mode="ident"/>
                 <xsl:apply-templates select="@Update" mode="ident"/>
                 <xsl:apply-templates select="@Version" mode="ident"/>
                 <xsl:apply-templates select="@Date" mode="ident"/>
                 <xsl:apply-templates select="*[position() = 1]" mode="columns"/>
                 <xsl:apply-templates select="node()" mode="data"/>
              </xsl:copy>
            </xsl:otherwise>
        </xsl:choose>
</xsl:template>

<!-- display COLUMNS and DATA -->
   <xsl:template match="node()" mode="columns">
       <COLUMNS><xsl:value-of select="$delimiter"/> <xsl:apply-templates select="node()" mode="names"/></COLUMNS>
   </xsl:template>

   <xsl:template match="node()" mode="data">
       <DATA><xsl:value-of select="$delimiter"/> <xsl:apply-templates select="node()" mode="values"/></DATA>
   </xsl:template>


<!-- skip any METADATA-*  in various modes-->
<xsl:template match="METADATA-SYSTEM|METADATA-RESOURCE|METADATA-FOREIGN_KEY|METADATA-CLASS|METADATA-TABLE|METADATA-UPDATE|METADATA-UPDATE_TYPE|METADATA-OBJECT|METADATA-SEARCH_HELP|METADATA-LOOKUP|METADATA-LOOKUP_TYPE|METADATA-VALIDATION_LOOKUP|METADATA-VALIDATION_LOOKUP_TYPE|METADATA-VALIDATION_EXTERNAL|METADATA-VALIDATION_EXTERNAL_TYPE|METADATA-VALIDATION_EXPRESSION|METADATA-EDITMASK|METADATA-UPDATE_HELP" mode="data">
</xsl:template>
<xsl:template match="METADATA-SYSTEM|METADATA-RESOURCE|METADATA-FOREIGN_KEY|METADATA-CLASS|METADATA-TABLE|METADATA-UPDATE|METADATA-UPDATE_TYPE|METADATA-OBJECT|METADATA-SEARCH_HELP|METADATA-LOOKUP|METADATA-LOOKUP_TYPE|METADATA-VALIDATION_LOOKUP|METADATA-VALIDATION_LOOKUP_TYPE|METADATA-VALIDATION_EXTERNAL|METADATA-VALIDATION_EXTERNAL_TYPE|METADATA-VALIDATION_EXPRESSION|METADATA-EDITMASK|METADATA-UPDATE_HELP" mode="names">
</xsl:template>
<xsl:template match="METADATA-SYSTEM|METADATA-RESOURCE|METADATA-FOREIGN_KEY|METADATA-CLASS|METADATA-TABLE|METADATA-UPDATE|METADATA-UPDATE_TYPE|METADATA-OBJECT|METADATA-SEARCH_HELP|METADATA-LOOKUP|METADATA-LOOKUP_TYPE|METADATA-VALIDATION_LOOKUP|METADATA-VALIDATION_LOOKUP_TYPE|METADATA-VALIDATION_EXTERNAL|METADATA-VALIDATION_EXTERNAL_TYPE|METADATA-VALIDATION_EXPRESSION|METADATA-EDITMASK|METADATA-UPDATE_HELP" mode="values">
</xsl:template>


<!-- display column name -->
   <xsl:template match="node()" mode="names">
     <xsl:value-of select="name()"/><xsl:value-of select="$delimiter"/>
   </xsl:template>

<!-- display  value -->
   <xsl:template match="node()" mode="values">
     <xsl:value-of select="."/><xsl:value-of select="$delimiter"/>
   </xsl:template>

</xsl:stylesheet>


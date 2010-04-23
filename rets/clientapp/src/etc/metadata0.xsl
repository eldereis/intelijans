<?xml version="1.0" encoding="UTF-8"?> 

<xsl:stylesheet
	version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

 <!-- <xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/> -->

   <xsl:output method="xml" version="1.0" encoding="UTF-8" omit-xml-declaration="yes" indent="yes"/>



<!-- identity transformation -->
   <xsl:template match="@*|node()">
      <xsl:copy>
      	<xsl:apply-templates select="@*|node()"/>
      </xsl:copy>
    </xsl:template>
   
<!-- display root element -->
   <xsl:template match="METADATA-SYSTEM|METADATA-RESOURCE|METADATA-FOREIGN_KEY|METADATA-CLASS|METADATA-TABLE|METADATA-UPDATE|METADATA-UPDATE_TYPE|METADATA-OBJECT|METADATA-SEARCH_HELP|METADATA-LOOKUP|METADATA-LOOKUP_TYPE|METADATA-VALIDATION_LOOKUP|METADATA-VALIDATION_LOOKUP_TYPE|METADATA-VALIDATION_EXTERNAL|METADATA-VALIDATION_EXTERNAL_TYPE|METADATA-VALIDATION_EXPRESSION|METADATA-EDITMASK|METADATA-UPDATE_HELP">
      <xsl:copy>
         <xsl:apply-templates select="@*|node()" mode='suppress'/>
      </xsl:copy>
   </xsl:template>

<!-- MODE=SUPPRESS suppress METADATA- elements -->
   <xsl:template match="METADATA-SYSTEM|METADATA-RESOURCE|METADATA-FOREIGN_KEY|METADATA-CLASS|METADATA-TABLE|METADATA-UPDATE|METADATA-UPDATE_TYPE|METADATA-OBJECT|METADATA-SEARCH_HELP|METADATA-LOOKUP|METADATA-LOOKUP_TYPE|METADATA-VALIDATION_LOOKUP|METADATA-VALIDATION_LOOKUP_TYPE|METADATA-VALIDATION_EXTERNAL|METADATA-VALIDATION_EXTERNAL_TYPE|METADATA-VALIDATION_EXPRESSION|METADATA-EDITMASK|METADATA-UPDATE_HELP" mode='suppress'>
            <!--<xsl:text>&lt;METADATA-SUPPRESSED/&gt;</xsl:text>-->
   </xsl:template>

<!-- MODE=SUPPRESS display non-METADATA- elements -->
   <xsl:template match="@*|node()" mode='suppress'>
      <xsl:copy>
      	<xsl:apply-templates select="@*|node()" mode='suppress'/>
      </xsl:copy>
   </xsl:template>

</xsl:stylesheet>
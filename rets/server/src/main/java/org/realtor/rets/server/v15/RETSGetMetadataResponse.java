// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v15/RETSGetMetadataResponse.java,v 1.2 2005/03/22 20:14:07 ekovach Exp $
package org.realtor.rets.server.v15;

import java.util.Map;
import org.apache.log4j.Category;


////////////////////////////////////////////////////////////////////////

/**
 *        RETSGetMetadataResponse generates the Metadata response.
 *
 *        @author        jbrush
 *        @version 1.0
 */
public class RETSGetMetadataResponse
    extends org.realtor.rets.server.v10.RETSGetMetadataResponse {
    /** Log4J Category object*/
    static Category cat = Category.getInstance(RETSGetMetadataResponse.class);

    public RETSGetMetadataResponse(Map m) {
        super(m);
    }
    
    /**
     	Get the name of the Metadata file.
    	@return The name of the Metadata file.
    */
    protected String getMetadataFile() {
    	return "RETSMetadata15.xml";
    }
}

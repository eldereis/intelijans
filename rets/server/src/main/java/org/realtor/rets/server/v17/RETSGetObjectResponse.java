//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v17/RETSGetObjectResponse.java,v 1.21 2005/03/15 16:37:44 ekovach Exp $
package org.realtor.rets.server.v17;

import org.apache.log4j.*;

import java.io.File;
import java.util.*;
import org.realtor.rets.server.ResponseException;

/**
 *        Generate the Get Object Response
 *
 *        @author        ekovach
 *        @version 1.0
 */
public class RETSGetObjectResponse extends org.realtor.rets.server.v15.RETSGetObjectResponse {
	
	public RETSGetObjectResponse(Map m, String accept) {
		super(m, accept);
	}
	
    /**
	    Get whether or not this RETSGetObjectResponse is multipart.  Override of superclass
	    method to return true if a wildcard was used in the request.
	 */
	public boolean isMultipartResponse() {
		return isMultipartRequest();
	}
	
	/**
	    Perform any necessary operations for an "object not found" error.
	 */
    protected void setNoObjectFoundStatus() {
    	setStatus("404");
    }
    
	/**
	 	Perform any necessary operations for an "invalid MIME type" error.
    */
    protected void setInvalidMimeTypeStatus() throws ResponseException {
    	setStatus("406");
    }
}

//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/RETSGetObjectResponseFactory.java,v 1.6 2005/03/03 20:39:14 ekovach Exp $1
package org.realtor.rets.server;

import org.apache.log4j.Category;
import org.realtor.rets.server.v10.RETSGetObjectResponse;
import java.util.Map;

/**
 *        Class to obtain a RETSGetObjectResponse object.
 *
 *        @author        ekovach
 *        @version 1.0
 */
public class RETSGetObjectResponseFactory {
    static Category cat = Category.getInstance(RETSGetObjectResponseFactory.class);
    
	/**
	    Return a new instance of a RETSGetObjectResponse object based on the RETS version.
	    @param m The Map from which to read the RETS version.
	    @param retsVersion The RETS-Version header String.
	    @param accept The Accept header String.
	    @return A new instance of a RETSGetObjectResponse object or null if no
	    corresponding object could be found for the specified RETS version.
	 */
	public static RETSGetObjectResponse getInstance(Map m, String retsVersion, String accept) {
		cat.debug("RETS-Version: " + retsVersion);
		cat.debug("Accept: " + accept);
		
		if (retsVersion.equals("RETS/1.0")) {
			return new org.realtor.rets.server.v10.RETSGetObjectResponse(m, accept);
		}
		else if (retsVersion.equals("RETS/1.5")) {
			return new org.realtor.rets.server.v15.RETSGetObjectResponse(m, accept);
		}
		else if (retsVersion.equals("RETS/1.7")) {
			return new org.realtor.rets.server.v17.RETSGetObjectResponse(m, accept);
		}
		else {
			return null;
		}
	}
}

//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/ResponseException.java,v 1.3 2005/02/18 21:09:14 ekovach Exp $
package org.realtor.rets.server;

import org.apache.log4j.Category;
import org.realtor.rets.util.RETSReplyCodes;

/**
    Exception class to pass around RETS error codes.
 */
public class ResponseException extends Exception {
	
    /** log4j object */
    static Category cat = Category.getInstance(ResponseException.class);

    private int code;

	public ResponseException(int code) {
		super(RETSReplyCodes.get(code));
		this.code = code;
		cat.debug("ResponseException (code " + code + "): " + getMessage());
	}
	
	public int getCode() {
		return code;
	}
}

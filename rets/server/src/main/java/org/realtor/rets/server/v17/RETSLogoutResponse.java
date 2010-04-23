//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v17/RETSLogoutResponse.java,v 1.1 2005/03/03 18:31:32 ekovach Exp $
package org.realtor.rets.server.v17;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;
import org.realtor.rets.server.*;

import java.io.*;

import java.util.*;


/**
 *        RETSLogoutResponse  Generates logout response
 *
 *        @author        ekovach
 *        @version 1.0
 */
public class RETSLogoutResponse extends org.realtor.rets.server.v10.RETSLogoutResponse {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSLogoutResponse.class);
    
    private boolean isLoggedIn;

    /** Creates new RETSLogoutResponse populating the requestMap */
    public RETSLogoutResponse(Map m, boolean isLoggedIn) {
    	super(m);
    	if (isLoggedIn) {
    		setReplyCode(REPLY_CODE_SUCCESS);
    	}
    	else {
    		setReplyCode(REPLY_CODE_NOT_LOGGED_IN);
    	}
    }
}

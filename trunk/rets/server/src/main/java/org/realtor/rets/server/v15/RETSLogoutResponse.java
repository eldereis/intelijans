// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v15/RETSLogoutResponse.java,v 1.1.1.1 2003/11/21 16:20:24 rsegelman Exp $
package org.realtor.rets.server.v15;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;
import org.realtor.rets.server.*;

import java.io.*;

import java.util.*;


/**
 *        RETSLogoutResponse  Generates logout response
 *
 *        @author        jbrush
 *        @version 1.0
 */
public class RETSLogoutResponse
    extends org.realtor.rets.server.v10.RETSLogoutResponse {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSLogoutResponse.class);

    /** Creates new RETSLogoutResponse populating the requestMap */
    public RETSLogoutResponse(Map m) {
        super(m);
    }
}

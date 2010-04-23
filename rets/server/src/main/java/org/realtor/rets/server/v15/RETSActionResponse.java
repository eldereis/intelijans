// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v15/RETSActionResponse.java,v 1.1.1.1 2003/11/21 16:20:24 rsegelman Exp $
package org.realtor.rets.server.v15;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;
import org.realtor.rets.server.*;

import java.io.*;

import java.util.*;


/**
 *        RETSActionResponse handles the response to the Action transaction.
 *
 *        @author                $Author: rsegelman $
 *        @version        $Revision: 1.1.1.1 $
 */
public class RETSActionResponse
    extends org.realtor.rets.server.v10.RETSActionResponse {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSActionResponse.class);

    /** Create a new RETSActionResponse populating the request parameters.
     *
     *  @param m map containing the request key/value pairs
     */
    public RETSActionResponse(Map m) {
        super(m);
    }
}

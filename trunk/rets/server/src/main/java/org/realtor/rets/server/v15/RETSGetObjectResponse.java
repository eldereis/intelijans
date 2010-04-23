// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v15/RETSGetObjectResponse.java,v 1.2 2005/03/03 20:39:14 ekovach Exp $
package org.realtor.rets.server.v15;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;
import org.realtor.rets.server.*;

import java.io.*;

import java.util.*;

import javax.servlet.ServletContext;


/**
 *        Generate the Get Object Response
 *
 *        @author        jbrush
 *        @version 1.0
 */
public class RETSGetObjectResponse
    extends org.realtor.rets.server.v10.RETSGetObjectResponse {
    /** log4j object */
    static Category cat = Category.getInstance(RETSGetObjectResponse.class);

    public RETSGetObjectResponse(Map m, String accept) {
        super(m, accept);
    }
}

// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v15/RETSSearchResponse.java,v 1.1.1.1 2003/11/21 16:20:24 rsegelman Exp $
package org.realtor.rets.server.v15;

import org.apache.log4j.Category;

import java.util.Map;


/**
 *        RETSSearchResponse
 *      Processes RETS Search Transaction Request and generates a response
 *
 *        @author        jbrush
 *        @version 1.0
 */
public abstract class RETSSearchResponse
    extends org.realtor.rets.server.v10.RETSSearchResponse {
    static Category cat = Category.getInstance(RETSSearchResponse.class);

    /**
     *  Creates new RETSSearchResponse
     *
     *  @param m map of transaction attributes and associated values.
     */
    public RETSSearchResponse(Map m) {
        super(m);
    }
}

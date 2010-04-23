// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/RETSServerResponse.java,v 1.3 2005/03/10 14:47:03 ekovach Exp $
package org.realtor.rets.server;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;

import java.io.*;

import java.util.*;


/**
 *  RETSServerResponse handles the RETs respsonses which occur prior to the execution of RETS Transactions
 *  (i.e., bad request headers and the like not handled by the Http Status codes)
 *  @author     $Author: ekovach $
 *  @version    $Revision: 1.3 $
 */
public class RETSServerResponse extends RETSResponse {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSServerResponse.class);

    /** Properties object */
    Properties prop = null;

    /** Create a new RETSServerResponse populating the request parameters.
     *
     *  @param m map containing the request key/value pairs
     */
    public RETSServerResponse() {
        super();
    }

    public RETSServerResponse(Map m) {
        super(m);
    }

    /**
     *  Builds the framework of the response
     *  body.
     */
    protected void buildResponse() {
        boolean isError = false;

        appendResponse("<RETS ReplyCode=\"");
        appendResponse(replyCode);
        appendResponse("\" ReplyText=\"");
        appendResponse(replyText);
        appendResponse("\"");

        appendResponse(" >\n");

        appendResponse("</RETS>\r\n");

        cat.debug("RESPONSE ::" + this.response.toString());
    }
}

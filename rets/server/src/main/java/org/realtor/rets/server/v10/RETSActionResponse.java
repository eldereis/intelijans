// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v10/RETSActionResponse.java,v 1.2 2005/02/18 16:17:08 ekovach Exp $
package org.realtor.rets.server.v10;

import org.apache.log4j.*;

import org.realtor.rets.persistence.*;
import org.realtor.rets.server.*;

import java.io.*;

import java.util.*;


/**
 *        RETSActionResponse handles the response to the Action transaction.
 *
 *        @author                $Author: ekovach $
 *        @version        $Revision: 1.2 $
 */
public class RETSActionResponse extends RETSResponse {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSActionResponse.class);

    /** Create a new RETSActionResponse populating the request parameters.
     *
     *  @param m map containing the request key/value pairs
     */
    public RETSActionResponse(Map m) {
        super(m);
    }

    /**
     *  Builds the framework of the response and calls fillContent to add the
     *  body.
     */
    protected void buildResponse() {
        boolean isError = false;

        replyCode = REPLY_CODE_SUCCESS;
        appendResponse("<RETS ReplyCode=\"");
        appendResponse(replyCode);
        appendResponse("\" ReplyText=\"");
        appendResponse(replyText);
        appendResponse("\"");

        if (isError) {
            cat.debug("*****ERROR");
            appendResponse(" />");
        } else {
            appendResponse(" >\n");

            fillContent();

            appendResponse("</RETS>\r\n");
        }

        cat.debug("RESPONSE ::" + this.response.toString());
    }

    /** fills in the body of the response using appendResponse */
    void fillContent() {
        appendResponse(prop.getProperty("ActionMessage"));
    }
}

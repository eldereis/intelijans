// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v10/RETSLogoutResponse.java,v 1.6 2005/03/10 14:47:03 ekovach Exp $
package org.realtor.rets.server.v10;

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
public class RETSLogoutResponse extends RETSResponse {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSLogoutResponse.class);

    /** Creates new RETSLogoutResponse populating the requestMap */
    public RETSLogoutResponse(Map m) {
        super(m);
        setReplyCode(REPLY_CODE_SUCCESS);
    }

    /**
     *  Builds the framework of the response and calls fillContent to add the
     *  body.
     */
    protected void buildResponse() {
        appendResponse("<?xml version=\"1.0\" standalone=\"no\"?>\r\n");
        appendResponse("<!DOCTYPE RETS SYSTEM \"RETS-20021015.dtd\">\r\n");
        appendResponse("<RETS ReplyCode=\"");
        appendResponse(replyCode);
        appendResponse("\" ReplyText=\"");
        appendResponse(replyText);
        appendResponse("\"");

        if (getReplyCode() != REPLY_CODE_SUCCESS) {
            cat.debug("*****ERROR");
            appendResponse(" />");
        } else {
            appendResponse(" >\n");

            fillContent();

            appendResponse("</RETS>\r\n");
        }

        cat.debug("RESPONSE ::" + this.response.toString());
    }

    /**
     *  Fills in the response content.
     *
     */
    protected void fillContent() {
        appendResponse("ConnectTime=");
        appendResponse(getConnectTime());
        appendResponse("\n");
        appendResponse("Billing=");
        appendResponse(getBilling());
        appendResponse("\n");
        appendResponse("SignOffMessage=");
        appendResponse(getSignOffMessage());
        appendResponse("\n");
    }

    /**
     * TODO just retuns null for now
     *
     */
    String getConnectTime() {
        return null;
    }

    /**
     *  TODO just returns null for now
     *
     */
    String getBilling() {
        return null;
    }

    /**
     * TODO just retuns null for now
     *
     */
    String getSignOffMessage() {
        return null;
    }
}

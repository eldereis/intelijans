// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v15/RETSLoginResponse.java,v 1.5 2005/02/18 21:09:14 ekovach Exp $
package org.realtor.rets.server.v15;

import java.util.Map;

import org.apache.log4j.Category;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.server.RETSBroker;


/**
 *        RETSLoginResponse generate the Login Response
 *
 *        @author        jbrush
 *        @version 1.0
 */
public class RETSLoginResponse
    extends org.realtor.rets.server.v10.RETSLoginResponse {
    /** log4J Category object */
    static Category cat = Category.getInstance(org.realtor.rets.server.v15.RETSLoginResponse.class);

    public RETSLoginResponse(Map m) {
        super(m);
    }

    public RETSLoginResponse(Agent myUser, int timeout) {
        super(myUser, timeout);
    }

    protected void buildResponse() {
        setReplyCode(REPLY_CODE_SUCCESS);
        appendResponse("<RETS ReplyCode=\"");
        appendResponse(replyCode);
        appendResponse("\" ReplyText=\"");
        appendResponse(replyText);
        appendResponse("\"");

        if (getReplyCode() != REPLY_CODE_SUCCESS) {
            cat.debug("*****ERROR");
            appendResponse(" />");
            setStatus("failure");
        } else {
            appendResponse(" >\n");

            if (getReplyCode() == REPLY_CODE_BROKER_CODE_REQUIRED)
             {
                cat.debug("*****Multibroker");

                StringBuffer buf = new StringBuffer(64);
                RETSBroker[] list = agent.getBrokerList();

                // format broker list
                int len = list.length;

                for (int i = 0; i < len; i++) {
                    buf.append("Broker=").append(list[i].code);

                    if (list[i].branch != null) {
                        buf.append(",").append(list[i].branch);
                    }

                    buf.append("\r\n");
                }

                appendResponse(buf.toString());
            } else { // all good
                cat.debug("All good");
                appendResponse("<RETS-RESPONSE>\r\n");
                appendResponse(getMemberNameTag());
                appendResponse(getUserInfoTag());
                appendResponse(getBrokerTag());
                appendResponse(getMetadataVerTag());
                appendResponse(getMinMetadataVerTag());

                appendResponse(getOfficeListTag());
                appendResponse(getBalanceTag());
                appendResponse(getTimeoutTag());
                appendResponse(getPwdExpireTag());
                appendResponse(getCapabilityURLList());
                appendResponse("</RETS-RESPONSE>\r\n");
            }

            appendResponse("</RETS>\r\n");
            setStatus("success");
        }

        cat.debug("RESPONSE ::" + this.response.toString());
    }
}

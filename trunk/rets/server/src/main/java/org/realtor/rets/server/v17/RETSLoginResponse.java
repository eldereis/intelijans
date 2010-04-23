//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v17/RETSLoginResponse.java,v 1.2 2005/03/04 19:56:54 ekovach Exp $
package org.realtor.rets.server.v17;

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
    extends org.realtor.rets.server.v15.RETSLoginResponse {
    /** log4J Category object */
    static Category cat = Category.getInstance(org.realtor.rets.server.v15.RETSLoginResponse.class);

    public RETSLoginResponse(Map m) {
        super(m);
    }

    public RETSLoginResponse(Agent myUser, int timeout) {
        super(myUser, timeout);
    }

    /** returns the value for the $lt;MetadataTimestamp> tag */
    protected String getMetadataTimestampKey() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("MetadataTimestampKey=")
           .append(prop.getProperty("MetadataTimestampKey")).append("\r\n");

        return buf.toString();
    }

    /** returns the value for the $lt;MinMetadataTimestamp> tag */
    protected String getMinMetadataTimestampKey() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("MinMetadataTimestampKey=")
           .append(prop.getProperty("MinMetadataTimestampKey")).append("\r\n");

        return buf.toString();
    }
    
    /** returns the value of the RETS-Request-ID if necessary. */
    private String getRetsRequestID() {
    	StringBuffer buf = new StringBuffer();
    	String retsRequestId = (String) requestMap.get("RETS-Request-ID");
        if (retsRequestId != null) {
            buf.append("RETS-Request-ID=")
	           .append(retsRequestId).append("\r\n");
        }
        return buf.toString();
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
                appendResponse(getMetadataTimestampKey());
                appendResponse(getMinMetadataTimestampKey());

                appendResponse(getOfficeListTag());
                appendResponse(getBalanceTag());
                appendResponse(getTimeoutTag());
                appendResponse(getPwdExpireTag());
                appendResponse(getCapabilityURLList());
                
                appendResponse(getRetsRequestID());
                
                appendResponse("</RETS-RESPONSE>\r\n");
            }

            appendResponse("</RETS>\r\n");
            setStatus("success");
        }

        cat.debug("RESPONSE ::" + this.response.toString());
    }
}

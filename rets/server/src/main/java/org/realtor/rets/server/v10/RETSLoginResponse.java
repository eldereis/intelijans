// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v10/RETSLoginResponse.java,v 1.6 2005/04/01 19:50:09 ekovach Exp $
package org.realtor.rets.server.v10;

import java.util.Map;

import org.apache.log4j.Category;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.server.RETSBroker;
import org.realtor.rets.server.RETSResponse;


/**
 *  RETSLoginResponse generate the Login Response
 *
 *  @author jbrush
 *  @version 1.0
 */
public class RETSLoginResponse extends RETSResponse {
    /** log4J Category object */
    static Category cat = Category.getInstance(org.realtor.rets.server.v10.RETSLoginResponse.class);

    /** capablities list */
    protected static String[] capList = {
        "Action", "ChangePassword", "GetObject", "Login", "LoginComplete",
        "Logout", "Search", "GetMetadata", "Update", "ServerInformation"
    };

    /** user/agent logging in */
//    protected RetsAgentDAO agent = null;
    protected Agent agent = null;

    /** session timeout in seconds */
    protected int timeout = -1;

    public RETSLoginResponse(Map m) {
        super(m);
    }
    /** Creates a login reponse for a given user
     *  @param myUser the user tring to log in.
     */
    public RETSLoginResponse(Agent myUser, int timeout) {
        super();
        setAgent(myUser);
        setTimeout(timeout);
    }
    public void setAgent(Agent myUser){
        agent = myUser;
    }
    public void setTimeout( int timeout){
        this.timeout = timeout;
    }

    /**
     *  Builds the response body.
     */
    protected void buildResponse() {
        setReplyCode(REPLY_CODE_SUCCESS);
        appendResponse("<RETS ReplyCode=\"");
        appendResponse(replyCode);
        appendResponse("\" ReplyText=\"");
        appendResponse(replyText);
        appendResponse("\"");

        if (getReplyCode() != REPLY_CODE_SUCCESS) {
            cat.error("*****ERROR:" + getReplyCode());
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
            } else // all good
             {
                cat.debug("Successful Login");
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
            }

            appendResponse("</RETS>\r\n");
            setStatus("success");
        }

        //cat.debug("RESPONSE ::"+this.response.toString());
    }

    /** returns the value for the $lt;MemberName> tag */
    protected String getMemberNameTag() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("MemberName=").append(agent.getMemberName()).append("\r\n");

        return buf.toString();
    }

    /** returns the value for the $lt;UserInfo> tag */
    protected String getUserInfoTag() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("User=").append(agent.getID()).append(",");
        buf.append(agent.getLevel()).append(",");
        buf.append(agent.getUserClass()).append(",");
        buf.append(agent.getAgentCode()).append("\r\n");

        return buf.toString();
    }

    /** returns the value for the $lt;Broker> tag */
    protected String getBrokerTag() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("Broker=").append(agent.getBrokerCode());

        String branch = agent.getBrokerBranch();

        if (branch != null) {
            buf.append(",").append(branch);
        }

        buf.append("\r\n");

        return buf.toString();
    }

    /** returns the value for the $lt;MetadataVersion> tag */
    protected String getMetadataVerTag() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("MetadataVersion=")
           .append(prop.getProperty("MetadataVersion")).append("\r\n");

        return buf.toString();
    }

    /** returns the value for the $lt;MinMetadataVersion> tag */
    protected String getMinMetadataVerTag() {
        StringBuffer buf = new StringBuffer(64);

        buf.append("MinMetadataVersion=")
           .append(prop.getProperty("MinMetadataVersion")).append("\r\n");

        return buf.toString();
    }

    /** TODO returns the value for the $lt;OfficeList> tag
     *  Currently just returns null.
     */
    protected String getOfficeListTag() {
        return null;
    }

    /** TODO returns the value for the $lt;Balance> tag
     *  Currently just returns null.
     */
    protected String getBalanceTag() {
        return null;
    }

    /** returns the value for the $lt;Timeout> tag
     *
     */
    protected String getTimeoutTag() {
        StringBuffer buf = new StringBuffer(64);

        if (timeout >= 0) {
            buf.append("TimeoutSeconds=").append(timeout).append("\r\n");
        }

        return buf.toString();
    }

    /** TODO returns the value for the $lt;PwdExpire> tag
     *  Currently just returns null.
     */
    protected String getPwdExpireTag() {
        return null;
    }

    /** returns the value for the $lt;CapabilityURLList> tag
     */
    protected String getCapabilityURLList() {
        StringBuffer buf = new StringBuffer(128);
        String capURL = null;
        int len = capList.length;

        for (int i = 0; i < len; i++) {
            capURL = prop.getProperty("CapabilityURL." + capList[i]);

            if (capURL != null) {
                buf.append(capList[i]).append("=").append(capURL).append("\r\n");
            }
        }

        return buf.toString();
    }
}

// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/RETSResponse.java,v 1.13 2005/04/01 22:32:10 ekovach Exp $
package org.realtor.rets.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Category;
import org.realtor.rets.util.PropertiesLocator;
import org.realtor.rets.util.PropertiesNotFoundException;
import org.realtor.rets.util.RETSReplyCodes;


/**
 *        Abstract class, generic RETSResponse, extended for each transaction type.
 *
 *        @author        jbrush
 *        @version 1.0
 */
public abstract class RETSResponse {

    public static final int REPLY_CODE_SUCCESS = 0;
    protected static final int REPLY_CODE_BROKER_CODE_REQUIRED = 20012;
    protected static final int REPLY_CODE_MISCELLANEOUS_LOGIN_ERROR = 20036;
    protected static final int REPLY_CODE_INSECURE_PASSWORD = 20140;
    protected static final int REPLY_CODE_SAME_AS_PREVIOUS_PASSWORD = 20141;
    protected static final int REPLY_CODE_ENCRYPTED_USERNAME_INVALID = 20142;
    protected static final int REPLY_CODE_UNKNOWN_QUERY_FIELD = 20200;
    protected static final int REPLY_CODE_NO_RECORDS_FOUND = 20201;
    protected static final int REPLY_CODE_INVALID_SELECT = 20202;
    protected static final int REPLY_CODE_MISC_SEARCH_ERROR = 20203;
    public static final int REPLY_CODE_INVALID_QUERY_SYNTAX = 20206;
    public static final int REPLY_CODE_INVALID_PARAMETER = 20301;
    protected static final int REPLY_CODE_UNABLE_TO_SAVE_RECORD_ON_SERVER = 20302;
    protected static final int REPLY_CODE_MISC_UPDATE = 20303;
    protected static final int REPLY_CODE_WARNING_RESPONSE_2 = 20311;
    protected static final int REPLY_CODE_WARNING_RESPONSE_0 = 20312;
    protected static final int REPLY_CODE_INVALID_RESOURCE = 20400;
    protected static final int REPLY_CODE_INVALID_TYPE = 20401;
    protected static final int REPLY_CODE_INVALID_IDENTIFIER = 20402;
    protected static final int REPLY_CODE_NO_OBJECT_FOUND = 20403;
    protected static final int REPLY_CODE_UNRECOGNIZED_MIME_TYPE = 20406;
    protected static final int RESPONSE_ERROR_MISCELLANEOUS = 20413;
    protected static final int REPLY_CODE_GETMETADATA_INVALID_RESOURCE = 20500;
    protected static final int REPLY_CODE_GETMETADATA_INVALID_TYPE = 20501;
    protected static final int REPLY_CODE_NO_METADATA_FOUND = 20503;
    protected static final int REPLY_CODE_MISC_ERROR = 20513;
    protected static final int REPLY_CODE_DTD_UNAVAILABLE = 20514;
    protected static final int REPLY_CODE_SERVERINFORESPONSE_NOT_SUPPORTED = 20601;
    protected static final int REPLY_CODE_SERVERINFORESPONSE_MISC_ERROR = 20602;
    protected static final int REPLY_CODE_NOT_LOGGED_IN = 20701;

    /** log4j Category object */
    protected static Category cat = Category.getInstance(RETSResponse.class);
    protected int replyCode = REPLY_CODE_SUCCESS;
    protected String replyText = null;
    protected String statusReplyCode = null; // Optional
    protected String statusReplyText = null; // Optional
    protected StringBuffer response = new StringBuffer();
    protected Properties prop;
    private String status = null;
    private String version = null;

    /** map containing the key/value pairs for a given transaction request*/
    public Map requestMap = null;
    public Map responseMap = new HashMap();

    /** Creates a new RETSResponse */
    public RETSResponse() {
        super();

        try {
            prop = PropertiesLocator.locateProperties("RETSServer.properties");
        } catch (PropertiesNotFoundException e) {
            // TODO Auto-generated catch block
            cat.error(e.getMessage(), e);
        }
    }

    /** Create a RETSResponse object with the requestMap populated */
    public RETSResponse(Map m) {
        this();
        requestMap = m;
    }

    /** Populate the response, creates response content and should use
     *  appendResponse(string) to populate the response.
     */
    abstract protected void buildResponse();

    /**
     * returns the string value of the response.
     */
    public String getResponse() {
        this.buildResponse();
        cat.debug("RESPONSE(RETSResponse) :" + response.toString());

        return response.toString();
    }

    /**
     *  Appends integer passed in to the response object.
     *  @param str string to add to the response object.
     */
    protected RETSResponse appendResponse(int value) {
    	return appendResponse("" + value);
    }

    /**
     *  Appends string passed in to the response object.
     *  @param str string to add to the response object.
     */
    protected RETSResponse appendResponse(String str) {
        if (str != null) {
            cat.debug("Appending : " + str);
            response.append(str);
        }

        return this;
    }

    /**
     *  erase anything already populated in the response object.
     */
    protected void clearResponse() {
        response.setLength(0);
    }

    /**
     * sets the response status
     * @param responseStatus status of the response.
     */
    protected void setStatus(String responseStatus) {
        status = responseStatus;
    }

    /**
     * Returns the response status.
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * sets the reply code
     * @param code status of the reply.
     */
    protected void setReplyCode(int code) {
        replyCode = code;

        setReplyText(RETSReplyCodes.get(code));
    }

    /**
     * Returns the reply code.
     *
     */
    public int getReplyCode() {
        return replyCode;
    }

    /**
     * sets the reply text
     * @param text reply message.
     */
    protected void setReplyText(String text) {
        replyText = text;
    }

    /**
     * Returns the reply text.
     *
     */
    public String getReplyText() {
        return replyText;
    }
    /**
     * @return Returns the version.
     */
    public String getVersion() {
        return version;
    }
    /**
     * @param version The version to set.
     */
    public void setVersion(String version) {
        this.version = version;
    }
    /**
     * @return Returns the prop.
     */
    public Properties getProp() {
        return prop;
    }
    /**
     * @param prop The prop to set.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }
}

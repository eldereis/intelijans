/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v10/RETSUpdateResponse.java,v 1.17 2005/04/08 23:12:23 ekovach Exp $  */
package org.realtor.rets.server.v10;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.log4j.Category;
import org.realtor.rets.database.dao.AgentsDAO;
import org.realtor.rets.database.dao.ListingDAO;
import org.realtor.rets.database.dao.OfficeDAO;
import org.realtor.rets.database.dao.ResidentialPropertyDAO;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.dataobjects.Listing;
import org.realtor.rets.dataobjects.Office;
import org.realtor.rets.dataobjects.ResidentialProperty;
import org.realtor.rets.mapping.SystemNamesToDataObjectMapping;
import org.realtor.rets.mapping.WarningDescription;
import org.realtor.rets.server.RETSResponse;
import org.realtor.rets.server.RETSServerApp;


/**
 *  RETSUpdateResponse.java Created Jul 28, 2003
 *
 *
 *  Copyright 2003, Avantia inc.
 *  @version $Revision: 1.17 $
 *  @author ekovach
 */
public class RETSUpdateResponse extends RETSResponse {
    protected static final String VALIDATE = "Validate";
    protected static final String TYPE = "Type";
    protected static final String DELIMITER = "Delimiter";
    protected static final String RECORD = "Record";
    protected static final String RESOURCE = "Resource";
    protected static final String CLASS_NAME = "ClassName";
    static Category cat = Category.getInstance(RETSUpdateResponse.class);
    protected char delimiter = '\t';
    private String delimiterString = "09";
    private StringBuffer response;
    private HashMap recordHash;
    protected ArrayList warningArrayList;
    protected Exception exception;

    public RETSUpdateResponse(Map m) {
        super(m);
    }

    /**
     *
     */
    private void doUpdate() {
        warningArrayList = new ArrayList();
        HashMap reqHash = this.getRequestHash();
        if (reqHash.get(DELIMITER) != null) {
            delimiterString = (String) reqHash.get(DELIMITER);
            // delimiter is a 2 digit HEX value
			delimiter = (char) Integer.parseInt(delimiterString.trim(), 16);

        }

        String record = (String) reqHash.get(RECORD);

        parseRecord(record,delimiter);

        String resource  = (String) reqHash.get(RESOURCE);
        if (! resource.equals("Property")) {
            setReplyCode(REPLY_CODE_INVALID_PARAMETER);
        }
        
        String className = (String) reqHash.get(CLASS_NAME);
        
        try {
            // get the update{className}(Map, String) method and invoke it
        	Method updateMethod = this.getClass().getMethod("update" + className, new Class [] {Map.class});
        	updateMethod.invoke(this, new Object [] {recordHash});
    	}
        catch (Exception e) {
            setReplyCode(REPLY_CODE_INVALID_PARAMETER);
        }
    }

    private void parseRecord(String record,char delim) {
        StringTokenizer st = new StringTokenizer(record, String.valueOf(delim), false);
        recordHash = new HashMap();

        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();

            if (nextToken.indexOf("=") > 0) {
                int equalsLoc = nextToken.indexOf("=");
                String name = nextToken.substring(0, equalsLoc);
                String val = ((equalsLoc == nextToken.length()) ? ""
                                                                : nextToken.substring(equalsLoc +
                        1));
                recordHash.put(name, val);
            }
        }
    }

    public void updateResidentialProperty(Map values) {
        String mlsNumber = (String) values.get("id");
        ResidentialProperty toUpdate = null;
        ResidentialPropertyDAO residentialPropertyDAO = RETSServerApp.getResidentialPropertyDAO();

        try {
            if (mlsNumber != null) {
	      		toUpdate = residentialPropertyDAO.findByMlsNumber(mlsNumber);
            } else {
                toUpdate = new ResidentialProperty();
            }

            SystemNamesToDataObjectMapping mapping =
                    SystemNamesToDataObjectMapping.getInstance();
            List returnWarnings = mapping.fill("ResidentialProperty", toUpdate, values);
            warningArrayList.addAll(returnWarnings);
        } catch (Exception e) {
            this.setReplyCode(RETSResponse.REPLY_CODE_INVALID_PARAMETER);
            this.exception = e;
        }
        try {
            if (! isWarningLevelTwo()) {
                residentialPropertyDAO.saveOrUpdate(toUpdate);
            }
        } catch (Exception e) {
            cat.error(e);
            this.setReplyCode(RETSResponse.REPLY_CODE_MISC_UPDATE);
            this.exception = e;
        }
    }
    
    public void updateListing(Map values) {
        String uid = (String) values.get("MLS_NUM");
        Listing toUpdate = null;
        ListingDAO listingDAO = RETSServerApp.getListingDAO();

        try {
            if (uid != null) {
	      		toUpdate = listingDAO.findByUid(uid);
            } else {
                toUpdate = new Listing();
            }

            SystemNamesToDataObjectMapping mapping =
                    SystemNamesToDataObjectMapping.getInstance();
            List returnWarnings = mapping.fill("Listing", toUpdate, values);
            listingDAO.saveOrUpdate(toUpdate);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    // updates an agent to the database using the data objects.
    public void updateAgent(Map values) {
        String uid = (String) values.get("PUBID");
        Agent toUpdate;
        AgentsDAO agentsDAO = RETSServerApp.getAgentsDAO();

        try {
            if (uid != null) {
                toUpdate = agentsDAO.findByUid(uid);
            } else {
                toUpdate = new Agent();
            }

            SystemNamesToDataObjectMapping mapping = SystemNamesToDataObjectMapping.getInstance();
            List returnWarnings = mapping.fill("Agent", toUpdate, values);
            agentsDAO.saveOrUpdate(toUpdate);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    // updates an office to the database using the data objects.
    public void updateOffice(Map values) {
        String uid = (String) values.get("UID");
        Office toUpdate;
        OfficeDAO officeDAO = RETSServerApp.getOfficeDAO();
        System.out.println("Storing an office with uid " + uid);

        try {
            if (uid != null) {
                toUpdate = officeDAO.findByUid(uid);
            } else {
                toUpdate = new Office();
            }

            SystemNamesToDataObjectMapping mapping = SystemNamesToDataObjectMapping.getInstance();
            List returnWarnings = mapping.fill("Office", toUpdate, values);
            officeDAO.saveOrUpdate(toUpdate);
        } catch (Exception e) {
            this.exception = e;
        }
    }
    
    /**
        Check the warning level on all the warnings and return true if any
        have a level of "2" to prevent saving data to the database. 
        @return True if any warnings have a level of "2", false otherwise.
     */
    protected boolean isWarningLevelTwo() {
        // return false for RETS 1.0
        return false;
    }

    protected void appendErrorXml() {
        if (! warningArrayList.isEmpty()) {
            appendResponse("<ERRORBLOCK>\r\n");
	        Iterator iterator = warningArrayList.iterator();
	        while (iterator.hasNext()) {
	            WarningDescription wd = (WarningDescription) iterator.next();
	            appendResponse("<ERRORDATA>");
	            appendResponse("" + delimiter);
	            appendResponse(exception.getMessage());
	            appendResponse("</ERRORDATA>\r\n");
	        }
	        appendResponse("</ERRORBLOCK>\r\n");
        }
    }
    
    /**
     * Append the warning XML.
     */
    protected void appendWarningXml() {
        // do nothing for RETS 1.0
    }

    /* (non-Javadoc)
     * @see org.realtor.rets.server.RETSResponse#buildResponse()
     */
    protected void buildResponse() {
        doUpdate();
        appendResponse("<RETS ReplyCode=\"");
        appendResponse(getReplyCode());
        appendResponse("\" ReplyText=\"");

        appendResponse(getReplyText());
        appendResponse("\">\r\n");
        fillContent();
        if (this.exception == null) {
            appendWarningXml();
        }
        else {
            appendErrorXml();
        }
        appendResponse("</RETS>\r\n");
    }

    /**
     *  fills in the compact response for the update.
     */
    private void fillContent() {
        Iterator iter = recordHash.keySet().iterator();

        appendResponse("<TRANSACTIONID>");
		appendResponse(String.valueOf(new Date().getTime()));
        appendResponse("</TRANSACTIONID>\r\n");

        appendResponse("<DELIMITER value=\""+delimiterString+"\"/>\r\n");

        appendResponse("<COLUMNS>");
        appendResponse("" + delimiter);
        StringBuffer values = new StringBuffer();
        values.append(delimiter);
        while (iter.hasNext()) {
            String nextKey = (String) iter.next();
            appendResponse(nextKey);
            appendResponse("" + delimiter);

            if (recordHash.get(nextKey) != null) {
                values.append(recordHash.get(nextKey));
            }

            values.append(delimiter);
        }

        appendResponse("</COLUMNS>\r\n");
        appendResponse("<DATA>");
        appendResponse(values.toString());
        appendResponse("</DATA>\r\n");
    }

    protected HashMap getRequestHash() {
        HashMap retHash = new HashMap();
        addHashItem(retHash, RESOURCE);
        addHashItem(retHash, CLASS_NAME);
        addHashItem(retHash, VALIDATE);
        addHashItem(retHash, TYPE);
        addHashItem(retHash, DELIMITER);
        addHashItem(retHash, RECORD);

        return retHash;
    }

    private void addHashItem(HashMap hash, String itemName) {
        String[] item = (String[]) requestMap.get(itemName);

        if (item != null) {
            cat.debug(itemName + "={" + item[0] + "}");

            if (item[0].length() > 0) {
                hash.put(itemName, item[0]);
            }
        } else {
            cat.debug(itemName + " is null");
            hash.put(itemName, null);
        }
    }
}

/*
 * Created on Apr 4, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.v17;

import java.util.Iterator;
import java.util.Map;

import org.realtor.rets.mapping.WarningDescription;

/**
 * @author ekovach
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RETSUpdateResponse extends org.realtor.rets.server.v15.RETSUpdateResponse {
    public RETSUpdateResponse(Map m) {
        super(m);
    }
    
    /**
     	Check the warning level on all the warnings and return true if any
    	have a level of "2" to prevent saving data to the database. 
    	@return True if any warnings have a level of "2", false otherwise.
    */
    protected boolean isWarningLevelTwo() {
	    // check the warning levels
	    Iterator iterator = warningArrayList.iterator();
	    while (iterator.hasNext()) {
	        WarningDescription wd = (WarningDescription) iterator.next();
	        if (wd.getLevel() == 2) {
	            setReplyCode(REPLY_CODE_UNABLE_TO_SAVE_RECORD_ON_SERVER);
	            return true;
	        }
	    }
	    return false;
	}
    
    /**
     * Append the warning XML.
     */
    protected void appendWarningXml() {
        if (! warningArrayList.isEmpty()) {
            appendResponse("<WARNINGBLOCK>\r\n");
	        Iterator iterator = warningArrayList.iterator();
	        while (iterator.hasNext()) {
	            WarningDescription wd = (WarningDescription) iterator.next();
	            appendResponse("<WARNINGDATA>");
	            appendResponse("" + delimiter);
	            appendResponse(wd.getFieldName());
	            appendResponse("" + delimiter);
	            appendResponse(wd.getCode());
	            appendResponse("" + delimiter);
	            appendResponse(wd.getOffset());
	            appendResponse("" + delimiter);
	            appendResponse(wd.getDescription());
	            appendResponse("" + delimiter);
	            appendResponse(wd.getLevel());
	            appendResponse("" + delimiter);
	            appendResponse("</WARNINGDATA>\r\n");
	        }
	        appendResponse("</WARNINGBLOCK>\r\n");
        }
    }
}

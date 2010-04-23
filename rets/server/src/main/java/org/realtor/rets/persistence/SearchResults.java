/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.persistence;

import java.util.ArrayList;
import java.util.List;
import org.realtor.rets.server.RETSResponse;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchResults {

    private List rows = new ArrayList();
    private List columnNames = new ArrayList();
    private int replyCode = RETSResponse.REPLY_CODE_SUCCESS;
    private String replyText = "";
    
    public SearchResults() {
        //Default Constructor
    }
    
    public SearchResults(List rows, List columnNames) {
        this.rows = rows;
        this.columnNames = columnNames;
    }
    /**
     * @return Returns the columnNames.
     */
    public List getColumnNames() {
        return columnNames;
    }
    /**
     * @return Returns the rows.
     */
    public List getRows() {
        return rows;
    }
    /**
     * @param columnNames The columnNames to set.
     */
    public void setColumnNames(List columnNames) {
        this.columnNames = columnNames;
    }
    /**
     * @param rows The rows to set.
     */
    public void setRows(List rows) {
        this.rows = rows;
    }

    /**
     * @return
     */
    public int getReplyCode() {
        // TODO Auto-generated method stub
        return replyCode;
    }

    /**
     * @return
     */
    public String getReplyText() {
        // TODO Auto-generated method stub
        return replyText;
    }

    /**
     * @return
     */
    public boolean isOk() {
        
        return this.replyCode == RETSResponse.REPLY_CODE_SUCCESS;
    }
    
    /**
     * @param replyCode The replyCode to set.
     */
    public void setReplyCode(int replyCode) {
        this.replyCode = replyCode;
    }

    /**
     * @param replyText The replyText to set.
     */
    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public String toString() {
        return getReplyText() + " [" + getReplyCode() + "]";
    }
}

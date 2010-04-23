/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/database/PersistenceException.java,v 1.4 2005/03/10 14:47:03 ekovach Exp $  */
package org.realtor.rets.database;

/**
 *  PersistenceException.java Created May 19, 2004
 *   
 * 
 *  Copyright 2004, Avantia inc.
 *  @version $Revision: 1.4 $
 *  @author scohen
 */
public class PersistenceException extends Exception {

    public static final int INVALID_SELECT_FIELD =  1;
    public static final int NO_RECORDS_FOUND =  2;

    private int errorCode = 0;

    public PersistenceException(String s){
		super(s);
	}
	
	public PersistenceException(Exception parent){
		super(parent);
	}

    public PersistenceException(Exception parent, int errorCode){
		super(parent);
        this.errorCode = errorCode;
	}

    public PersistenceException(int errorCode){
		super();
        this.errorCode = errorCode;
	}

    public PersistenceException(String message, int errorCode){
		super(message);
        this.errorCode = errorCode;
	}

    public PersistenceException(String message, Exception parent, int errorCode){
    	super(message, parent);
        this.errorCode = errorCode;
	}
    
	public PersistenceException(String message, Exception parent){
		super(message, parent);
	}

    public boolean isErrorCode(int i) {
        if ( errorCode == i ) return true;
        return false;
    }
    
    public int getErrorCode() {
    	return errorCode;
    }
}

/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.persistence;

import java.util.Map;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.server.SearchQuery;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface QueryEngine {
    public static final String SEARCHCOUNT = "Count";
    public static final String SEARCHFORMAT = "Format";
    public static final String SEARCHLIMIT = "Limit";
    public static final String SEARCHOFFSET = "Offset";
    public static final String SEARCHSELECT = "Select";

    /** 
     * Execute a search against a sql database and return results.
     * @param query
     * @param parameters
     * @param decode True to decode lookup values, false otherwise.
     */
    public SearchResults execute(SearchQuery query, Map parameters, boolean decode) throws PersistenceException;
    
}

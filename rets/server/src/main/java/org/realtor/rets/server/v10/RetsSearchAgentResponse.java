/*
 * Created on Jan 25, 2005
 *
 */
package org.realtor.rets.server.v10;

import java.util.Map;

import org.realtor.rets.persistence.QueryEngine;
import org.realtor.rets.persistence.SqlQueryEngine;

/**
 * @author jmiller
 *
 */
public class RetsSearchAgentResponse extends RETSSearchResponse {

    /** Creates a new RETSNewSearchResponse */
    public RetsSearchAgentResponse() {
        super();
    }

    /** Create a RETSNewSearchResponse object with the requestMap populated */
    public RetsSearchAgentResponse(Map m) {
        this();
        requestMap = m;
    }
    
    protected String getTableSubstitutionName() {
        return "a";
    }
}

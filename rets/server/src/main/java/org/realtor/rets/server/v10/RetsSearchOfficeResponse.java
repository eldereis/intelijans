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
public class RetsSearchOfficeResponse extends RETSSearchResponse {

    /** Creates a new RETSNewSearchResponse */
    public RetsSearchOfficeResponse() {
        super();
    }

    /** Create a RETSNewSearchResponse object with the requestMap populated */
    public RetsSearchOfficeResponse(Map m) {
        this();
        requestMap = m;
    }

    /**
        Get the table substitition name.
        @return the table substitition name.
     */
    protected String getTableSubstitutionName() {
        return "o";
    }
}

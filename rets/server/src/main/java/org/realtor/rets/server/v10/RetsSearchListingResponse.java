/*
 * Created on Jan 25, 2005
 *
 */
package org.realtor.rets.server.v10;

import java.util.Map;
import java.util.StringTokenizer;

import org.realtor.rets.persistence.QueryEngine;
import org.realtor.rets.persistence.SqlQueryEngine;
import org.realtor.rets.server.ResponseException;
import org.realtor.rets.server.decoder.FieldDescription;
import org.realtor.rets.server.decoder.StaticTableDescriptions;
import org.realtor.rets.server.decoder.TableDescription;
import org.realtor.rets.server.decoder.Vocabulary;

/**
 * @author jmiller
 *
 */
public class RetsSearchListingResponse extends RETSSearchResponse {

    /** Creates a new RETSNewSearchResponse */
    public RetsSearchListingResponse() {
        super();
    }

    /** Create a RETSNewSearchResponse object with the requestMap populated */
    public RetsSearchListingResponse(Map m) {
        this();
        requestMap = m;
    }

    /**
     	Get the table substitition name.
     	@return the table substitition name.
     */
    protected String getTableSubstitutionName() {
        return "p";
    }
}

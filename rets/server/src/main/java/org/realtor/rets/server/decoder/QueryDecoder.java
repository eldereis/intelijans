/*
 * Created on Jan 19, 2005
 */
package org.realtor.rets.server.decoder;

import org.realtor.rets.server.SearchQuery;

/**
 * @author jmiller
 *
 */
public interface QueryDecoder {

    public SearchQuery decode(String query) throws ParseException;
}

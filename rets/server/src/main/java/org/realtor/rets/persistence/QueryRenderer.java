/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.persistence;

import org.realtor.rets.server.SearchQuery;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface QueryRenderer {

        public String renderQuery(SearchQuery query);
}

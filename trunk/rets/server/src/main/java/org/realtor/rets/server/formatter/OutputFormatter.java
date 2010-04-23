/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.formatter;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.realtor.rets.persistence.SearchResults;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface OutputFormatter {

    public void output(SearchResults results, Map parameters, Writer outputBuffer, int namespace) throws IOException;
    
}

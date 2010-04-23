/*
 * Created on Jan 21, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.formatter;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.realtor.rets.persistence.SearchResults;
import org.realtor.rets.server.decoder.Vocabulary;

import org.apache.log4j.Category;
/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CompactXmlFormatter implements OutputFormatter {

    protected static final String SEARCHCOUNT = "Count";
    protected static final String SEARCHLIMIT = "Limit";
    protected static final String SEARCHDELIMITER = "DELIMITER";


    static Category cat = Category.getInstance(CompactXmlFormatter.class);

    /* (non-Javadoc)
     * @see org.realtor.rets.server.formatter.OutputFormatter#output(org.realtor.rets.persistence.SearchResults, java.util.Map, java.io.Writer)
     */
    public void output(SearchResults results, Map parameters, Writer outputBuffer, int namespace) throws IOException {
		String searchCount = (String) parameters.get(SEARCHCOUNT);


        outputBuffer.write("<RETS ReplyCode=\"");
        outputBuffer.write("" + results.getReplyCode());
        outputBuffer.write("\" ReplyText=\"");
        outputBuffer.write(results.getReplyText());
        outputBuffer.write("\"");

		cat.debug ("results size = "+results.getRows().size());

        if (! results.isOk()) {
            outputBuffer.write(" />\r\n");
        } else {
			outputBuffer.write(" >\r\n");
			if (includeCount(searchCount)){
				outputBuffer.write("<COUNT Records=\"" + results.getRows().size() +
				"\" />\r\n");

				if (searchCount.equals("1")) {
					fillContent(results, parameters, outputBuffer, namespace);
				} else {
					outputBuffer.write("</RETS>\r\n");
				}
			} else {



            fillContent(results, parameters, outputBuffer, namespace);
            outputBuffer.write("</RETS>\r\n");
			}
        }
        outputBuffer.flush();
    }
    protected boolean includeCount(String searchCount) {
		    if (searchCount != null) {
	            if ( ("1".equals(searchCount))||("2".equals(searchCount)) ) {
	                return true;
	            }
			}
	    	return false;
	 }

    /**
     * @param results
     * @param parameters
     * @param outputBuffer
     */
    protected void fillContent(SearchResults results, Map parameters, Writer outputBuffer, int namespace) {
        //        Document doc = null;
        StringBuffer sb = new StringBuffer();

        HashMap fm = Vocabulary.getNameHash((String) parameters.get("Class"), namespace);
        cat.debug("query class is "+(String) parameters.get("Class"));

        HashMap nameLookup = this.invertMap(fm);
        // FIXME need real delimiter
        char delimChar = (char) '\t';

        //String delimiter = (String) parameters.get(SEARCHDELIMITER);

        // delimiter is a 2 digit HEX value
        String delimiter = Integer.toHexString(delimChar);
        if (delimiter.length() < 2) {
            // add a leading zero
            delimiter = "0".concat(delimiter);
        }

        try {
            outputBuffer.write("<DELIMITER value=\"" + delimiter.trim() + "\"/>\r\n");
            try {
                // delimiter is a 2 digit HEX value
                delimChar = (char) Integer.parseInt(delimiter.trim(), 16);
            } catch (Exception e) {
                delimChar = '\t';
            }

            if (results.getRows().size() > 0) {
	            StringBuffer columnBuffer = new StringBuffer(delimChar);
                for (Iterator i = results.getColumnNames().iterator(); i.hasNext(); ) {
                    String columnName = (String) i.next();
                    String convertedName = (String) nameLookup.get(columnName.toUpperCase());

                    if (convertedName != null) {
                        columnBuffer.append(convertedName);
						columnBuffer.append(delimChar);
                    }

                }
                outputBuffer.write("<COLUMNS>"+delimChar);
                outputBuffer.write(columnBuffer.toString());
                outputBuffer.write("</COLUMNS>\r\n");

                Iterator itr = results.getRows().iterator();
                while (itr.hasNext()) {
                    HashMap row = (HashMap) itr.next();
                    List values = (List) row.get("VALUES");
                    StringBuffer dataBuffer= new StringBuffer(delimChar);

                    for (Iterator i = results.getColumnNames().iterator(); i.hasNext(); ) {
                        String columnName = (String) i.next();
                        String convertedName = (String) nameLookup.get(columnName.toUpperCase());

						  if (convertedName != null) {
                        		String val = (String) row.get(columnName.toLowerCase());
                        			if (val == null) {
                            		val = "";
								}
                        		dataBuffer = dataBuffer.append(val).append(delimChar);
							}

                        }

                    outputBuffer.write("<DATA>"+delimChar);
					outputBuffer.write(filterString(dataBuffer.toString()));
                    outputBuffer.write("</DATA>\r\n");
               }



            }
        } catch (Exception e) {
			cat.error(e);
        }

    }

    /**
     * @param fm
     * @return
     */
    private HashMap invertMap(HashMap mapToInvert) {
        HashMap invertedMap = new HashMap();
        if (mapToInvert != null) {
            for (Iterator iter = mapToInvert.keySet().iterator(); iter.hasNext();) {
                String key = (String) iter.next();
                String value = (String) mapToInvert.get(key);
                value = value.toUpperCase();
                invertedMap.put(value, key);
            }
        }

        return invertedMap;
    }

    protected String filterString(String s) {
		String filter = "&";
		String replace = "and";
        String filteredString = s.replaceAll(filter, replace);
        return filteredString;
    }
}

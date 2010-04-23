/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.v10;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.persistence.QueryEngine;
import org.realtor.rets.persistence.SearchResults;
import org.realtor.rets.persistence.SqlQueryEngine;
import org.realtor.rets.server.RETSResponse;
import org.realtor.rets.server.ResponseException;
import org.realtor.rets.server.SearchQuery;
import org.realtor.rets.server.decoder.FieldDescription;
import org.realtor.rets.server.decoder.ParseException;
import org.realtor.rets.server.decoder.QueryDecoder;
import org.realtor.rets.server.decoder.QueryDecoderFactory;
import org.realtor.rets.server.decoder.StaticTableDescriptions;
import org.realtor.rets.server.decoder.TableDescription;
import org.realtor.rets.server.decoder.Vocabulary;
import org.realtor.rets.server.formatter.OutputFormatter;
import org.realtor.rets.server.formatter.OutputFormatterFactory;

/**
 * @author jmiller
 *
 */
public abstract class RETSSearchResponse extends RETSResponse {

    /**
        Map to change the ListingStatus element Status attribute values
        into descriptive string values.
     */
    private static Map listingStatusMap = new HashMap();

    private static final List ACCEPTABLE_SEARCH_DTD_LIST = Arrays.asList(new String [] {
            "RETS-20021015.dtd",
            "RETS-20001001.dtd",
            "RETS-20041001.dtd"});

    static {
        listingStatusMap.put("Contingent/Accept Backup", "Pending");
        listingStatusMap.put("Pending", "Pending");
        listingStatusMap.put("Sold", "Closed");
        listingStatusMap.put("Active", "Active");
        listingStatusMap.put("New", "Active");
        listingStatusMap.put("Change Price", "Active");
        listingStatusMap.put("Back on Market", "Active");
        listingStatusMap.put("Change", "Active");
        listingStatusMap.put("Contingent/First Refusal", "Pending");
        listingStatusMap.put("Release From Showing", "Withdrawn");
        listingStatusMap.put("Reissue", "Active");
        listingStatusMap.put("Expired", "Expired");
        listingStatusMap.put("Cancelled", "Cancelled");
        listingStatusMap.put("Conditional Cancellation", "Withdrawn");
        listingStatusMap.put("Relist", "Active");
        listingStatusMap.put("Rented", "Closed");
    }

    /** Creates a new RETSNewSearchResponse */
    public RETSSearchResponse() {
        super();
    }

    /** Create a RETSNewSearchResponse object with the requestMap populated */
    public RETSSearchResponse(Map m) {
        this();
        requestMap = m;
    }

    /**
     *  Builds the framework of the response and calls fillContent to add the
     *  body.
     */
    protected void buildResponse() {
        HashMap parameterMap = new HashMap();
        for (Iterator itr = requestMap.keySet().iterator(); itr.hasNext();) {
            String key = (String) itr.next();
            String[] value = (String[]) requestMap.get(key);
            if (value != null && value.length > 0) {
                parameterMap.put(key, value[0]);
            }
        }
        String queryType = (String) parameterMap.get("QueryType");
        String retsQueryString = (String) parameterMap.get("Query");
        String className = (String) parameterMap.get("Class");
        int namespace = Vocabulary.NAMESPACE_SYSTEM;
        if ("1".equals(parameterMap.get("StandardNames"))) {
            namespace = Vocabulary.NAMESPACE_STANDARD;
        }

        String outputFormat = (String) parameterMap.get("Format");
        if (outputFormat == null || outputFormat.equals("")) {
            outputFormat = "STANDARD-XML";  // default output format
        }

        //decode query...
        QueryDecoder decoder = QueryDecoderFactory.getDecoder(queryType, className, namespace);
        SearchQuery query = null;
        SearchResults results = null;
        if (decoder == null) {
            results = new SearchResults();
            setReplyCode(REPLY_CODE_MISC_SEARCH_ERROR);
            setReplyText("Invalid Query Type.");
        }

        try {
            if (decoder != null) {
                query = decoder.decode(retsQueryString);
            }

            cat.debug("retsQueryString:"+retsQueryString);
        } catch (ParseException pe) {
            cat.debug(pe);


            if (results == null) {
                results = new SearchResults();
            }
            switch(pe.getExceptionCode()) {
            case ParseException.FIELD_NOT_FOUND:
                setReplyCode(REPLY_CODE_UNKNOWN_QUERY_FIELD);
                setReplyText("Unknown Query Field");
                break;
            default:
                setReplyCode(REPLY_CODE_INVALID_QUERY_SYNTAX);
                setReplyText(pe.getMessage());
            }
        }

        //get search results
        if (results == null) {
    		results = new SearchResults();
        	try {
        	    // decode lookup values for all output formats except COMPACT
        	    boolean decode = ! outputFormat.equals("COMPACT");
        		results = this.getEngine().execute(query, parameterMap, decode);
        	}
        	catch (ResponseException e) {
        	    setReplyCode(e.getCode());
        	    setReplyText(e.getMessage());
        	}
        	catch (PersistenceException e) {
                results.setReplyText(e.getMessage());
        		if (e.getErrorCode() == PersistenceException.NO_RECORDS_FOUND) {
                    setReplyCode(REPLY_CODE_NO_RECORDS_FOUND);
        		}
        		else if (e.getErrorCode() == PersistenceException.INVALID_SELECT_FIELD) {
                    setReplyCode(REPLY_CODE_INVALID_SELECT);
        		}
        	}
        }

        if (results != null && results.getRows().size() == 0 && getReplyCode() == 0) {
            setReplyCode(REPLY_CODE_NO_RECORDS_FOUND);
            setReplyText("No Records Found");
        }

        // include a map to change the ListingStatus Status attribute
        parameterMap.put("ListingStatusMap", listingStatusMap);

        if (outputFormat.startsWith("STANDARD-XML:")) {
            String dtdString = outputFormat.substring(outputFormat.indexOf(":") + 1);
            if (! ACCEPTABLE_SEARCH_DTD_LIST.contains(dtdString)) {
                setReplyCode(REPLY_CODE_DTD_UNAVAILABLE);
            }
        }

        //write results to output
        if (getReplyCode() == REPLY_CODE_SUCCESS) {
	        OutputFormatter formatter = OutputFormatterFactory.createFormatter(outputFormat, parameterMap, getVersion());
	        try {
	            if (formatter != null) {
	                StringWriter outputWriter = new StringWriter();
	                formatter.output(results, parameterMap, outputWriter, namespace);
	                response.append(outputWriter.toString());
	            }
	        } catch (IOException ioe) {
	            //Error writing response to client... write error to log....
	            cat.error("Error writing response to client.", ioe);
	        }
        }
        else {
            appendResponse("<RETS ReplyCode=\"");
            appendResponse(getReplyCode());
            appendResponse("\" ReplyText=\"");
            appendResponse(getReplyText());
            appendResponse("\"");
            appendResponse(" />");
        }

    }

    /**
     	Get the table substitition name.
     	@return the table substitition name.
     */
    protected abstract String getTableSubstitutionName();

    protected QueryEngine getEngine() throws ResponseException {
        SqlQueryEngine engine = new SqlQueryEngine();
        String [] classes = (String []) requestMap.get("Class");
        String propertyName = "Table" + classes[0];
        StringBuffer queryBuffer = new StringBuffer("select ");

        // use specified columns if a Select is specified, otherwise use "*"
        String [] select = (String []) requestMap.get("Select");
        if (select == null) {
            queryBuffer.append("* ");
        }
        else {
            boolean isStandardNames = false;
            String [] standardNames = (String []) requestMap.get("StandardNames");
            isStandardNames = (standardNames != null) && (standardNames.length > 0) && standardNames[0].equals("1");
            StringTokenizer st = new StringTokenizer(select[0], ",");
            boolean isFirst = true;
            while (st.hasMoreTokens()) {
                String columnName = st.nextToken().trim();
                int namespace = isStandardNames ? Vocabulary.NAMESPACE_STANDARD : Vocabulary.NAMESPACE_SYSTEM;
                TableDescription td = StaticTableDescriptions.getTableDescription(classes[0], namespace);
                FieldDescription fd = td.getField(columnName);
                if (fd == null) {
                    throw new ResponseException(REPLY_CODE_INVALID_SELECT);
                }
                if (isStandardNames) {
                    columnName = fd.getSQLName();
                }
                if (! isFirst) {
                    queryBuffer.append(", ");
                }
                queryBuffer.append(columnName);
                isFirst = false;
            }
        }
        queryBuffer.append(" from ");
        queryBuffer.append(prop.getProperty(propertyName));
        queryBuffer.append(" ");
        queryBuffer.append(getTableSubstitutionName());

        engine.init(queryBuffer.toString());

        return engine;
    }

}

/*
 * Created on Jan 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.decoder;

import java.util.HashMap;
import org.apache.log4j.Category;

/**
 * @author jmiller, ekovach
 *
 * Class to fetch a QueryDecoder object for a specified query type and class name.
 */
public class QueryDecoderFactory {

    private static HashMap registeredDecoders = new HashMap();
	static Category cat = Category.getInstance(QueryDecoderFactory.class);
    /**
        HashMap of query types to decoder classes.
     */
    private static HashMap decoderClassMap = new HashMap();

    static {
    	// initialize the decoderClassMap
    	decoderClassMap.put("DMQL", DmqlDecoder.class);
    	decoderClassMap.put("DMQL2", DmqlDecoder.class);
    }

    /**
     *  Get a QueryDecoder object for a specified query type and class name.
     *  @param queryType
     *  @param className
     */
    private static QueryDecoder createQueryDecoder(String queryType, String className, int namespace) {
    	Class clazz = (Class) decoderClassMap.get(queryType);
    	if (clazz == null) {
    		// TODO: handle illegal query types?
    		return null;
    	}
    	try {
    		QueryDecoder qd = (QueryDecoder) clazz.newInstance();
    		TableDescription table = StaticTableDescriptions.getTableDescription(className, namespace);
    		// TODO: move this into a general "initialize" method for all QueryDecoders?
    		if (qd instanceof DmqlDecoder) {
    			((DmqlDecoder) qd).setFTable(table);
    		}
    		return qd;
    	}
    	catch (Exception e) {
    		// TODO: cannot instantiate new QueryDecoder object
    		cat.error(e);
    	}
    	return null;
    }

    /**
        Get the decoder for the specified query type and class name.
        @param queryType
        @param className
        @return The decoder for the specified query type and class name.
     */
    public static QueryDecoder getDecoder(String queryType, String className, int namespace) {
    	String key = queryType + "/" + className + "/" + namespace;
    	QueryDecoder qd = (QueryDecoder) registeredDecoders.get(key);
    	if (qd == null) {
    		qd = createQueryDecoder(queryType, className, namespace);
    		registeredDecoders.put(key, qd);
    	}
    	return qd;
    }
}

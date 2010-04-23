/*
 * Vocabulary.java
 *
 * Created on September 27, 2002, 12:21 PM
 */
package org.realtor.rets.server.decoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Category;
import org.realtor.rets.util.PropertiesLocator;
import org.realtor.rets.util.PropertiesNotFoundException;


/**
 * Class to resolve standard/system vocabularies.
 *
 * @author  tweber, ekovach
 */
public class Vocabulary {
	
	// namespace constants
	public static final int NAMESPACE_SYSTEM = 0;
	public static final int NAMESPACE_STANDARD = 1;
	
    private static Category cat = Category.getInstance(Vocabulary.class);
    
    /**
        A cache of properties.
     */
    private static HashMap propertiesHashMap = new HashMap();

    private static Properties getObjProperties(String type, int namespace) {
    	String key = type + "/" + namespace;
    	Properties properties = (Properties) propertiesHashMap.get(key);
    	if (properties == null) {
	    	String postfix = "SystemNames.properties";
    		switch (namespace) {
    			case NAMESPACE_STANDARD:
    		    	postfix = "StandardNames.properties";
    				break;
    		}
	    	try {
	    		String filename = type + postfix;
	    		cat.debug("Reading properties file: "+ filename);
	    		properties = PropertiesLocator.locateProperties(filename);
	    		propertiesHashMap.put(key, properties);
	    		return properties;
	    	}
	    	catch (PropertiesNotFoundException e) {
	    		// do nothing...return null
	    	}
    	}
    	return properties;
    }

    public static HashMap getNameHash(String type, int namespace) {
        Properties names = getObjProperties(type, namespace);

        if (names == null) {
            return null;
        }

        Iterator itr = names.keySet().iterator();
        HashMap fields = new HashMap();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            fields.put(key, (String) names.get(key));
        }

        return fields;
    }

    public static HashMap getNamesHash(String type, String[] fieldNames, int namespace) {
        Properties names = getObjProperties(type, namespace);

        if (names == null) {
            return null;
        }

        HashMap fields = new HashMap();

        for (int i = 0; i < fieldNames.length; i++) {
            String key = fieldNames[i];
            fields.put(key, (String) names.get(key));
        }

        return fields;
    }

    public static String getNameMapping(String type, String fieldName, int namespace) {
        Properties names = getObjProperties(type, namespace);

        if (names == null) {
            return null;
        }

        return (String) names.getProperty(fieldName);
    }
}

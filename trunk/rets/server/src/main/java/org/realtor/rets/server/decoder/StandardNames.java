/*
 * StandardNames.java
 *
 * Created on September 27, 2002, 12:21 PM
 */
package org.realtor.rets.server.decoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.realtor.rets.util.PropertiesLocator;

import org.apache.log4j.Category;


/**
 *
 * @author  tweber
 */
public class StandardNames {
    private static Properties listingStdNames = null;
    private static Properties officeStdNames = null;
    private static Properties agentStdNames = null;
    public static String LISTING = "listing";
    public static String OFFICE = "office";
    public static String AGENT = "agent";

	static Category cat = Category.getInstance(StandardNames.class);

    /** Creates a new instance of StandardNames */
    public StandardNames() {
    }

    private static Properties getObjProperties(String type) {
        //System.out.println("The type is :"+type);
        setupProperties();

        if (type.equalsIgnoreCase(LISTING)) {
            return listingStdNames;
        } else if (type.equalsIgnoreCase(OFFICE)) {
            return officeStdNames;
        } else if (type.equalsIgnoreCase(AGENT)) {
            return agentStdNames;
        } else {
            return null;
        }
    }

    public static HashMap getStandardNameHash(String type) {
        Properties stdNames = getObjProperties(type);

        if (stdNames == null) {
            return null;
        }

        Iterator itr = stdNames.keySet().iterator();
        HashMap fields = new HashMap();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            fields.put(key, (String) stdNames.get(key));
        }

        return fields;
    }

    public static HashMap getStandardNamesHash(String type, String[] fieldNames) {
        Properties stdNames = getObjProperties(type);

        if (stdNames == null) {
            return null;
        }

        HashMap fields = new HashMap();

        for (int i = 0; i < fieldNames.length; i++) {
            String key = fieldNames[i];
            fields.put(key, (String) stdNames.get(key));
        }

        return fields;
    }

    public static String getStandardNameMapping(String type, String fieldName) {
        Properties stdNames = getObjProperties(type);

        if (stdNames == null) {
            return null;
        }

        return (String) stdNames.getProperty(fieldName);
    }

    private static void setupProperties() {
        if (listingStdNames != null) {
            return;
        }

        try {
            listingStdNames = PropertiesLocator.locateProperties(
                    "StandardNames.properties");
            officeStdNames = PropertiesLocator.locateProperties(
                    "OfficeStandardNames.properties");
            agentStdNames = PropertiesLocator.locateProperties(
                    "AgentStandardNames.properties");
        } catch (Exception e) {
            cat.error(e);
        }
    }
}

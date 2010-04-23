/*
 * StaticTableDescriptions.java
 *
 * Created on October 17, 2002, 10:28 AM
 */
package org.realtor.rets.server.decoder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.mapping.Column;
import net.sf.hibernate.mapping.PersistentClass;
import net.sf.hibernate.mapping.Property;
import net.sf.hibernate.type.CalendarType;
import net.sf.hibernate.type.CharacterType;
import net.sf.hibernate.type.DateType;
import net.sf.hibernate.type.IntegerType;
import net.sf.hibernate.type.LongType;
import net.sf.hibernate.type.ManyToOneType;
import net.sf.hibernate.type.StringType;

import org.apache.log4j.Category;
import org.realtor.rets.server.RETSServerApp;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This class builds and stores static TableDescription objects for
 * DMQL parser impls.
 *
 * @author  tweber
 */
public class StaticTableDescriptions {
    private static Category cat = Category.getInstance(StaticTableDescriptions.class);

    /**
        Cache of table types to TableDescription objects.
     */
    private static HashMap tableDescriptionsMap = new HashMap();

    /**
        Get The TableDescription for the specified table type.
        @param tableType
        @param useStandardNames
        @return The TableDescription for the specified table type.
     */
    public static TableDescription getTableDescription(String tableType, int namespace) {
    	String key = tableType + "/" + namespace;

    	TableDescription td = (TableDescription) tableDescriptionsMap.get(key);
    	if (td == null) {
    		td = setupTable(tableType, namespace);
    		tableDescriptionsMap.put(key, td);
    	}

    	return td;
    }

    private static TableDescription setupTable(String objType, int namespace) {
        cat.debug("Loading Table Description for :" + objType);

        SQLTableDescription table = new SQLTableDescription();

        //HashMap fm = buildFieldMappings(objType);
        Map fm = Vocabulary.getNameHash(objType, namespace);
        AttributeList al = null;
        String tablePrefix = "";
    	Class dataobjectClass = null;
        try {
        	dataobjectClass = Class.forName("org.realtor.rets.dataobjects." + objType);
        }
        catch (ClassNotFoundException e) {
        	// TODO: what to do if an illegal object type is used?
        	cat.error("Class " + objType + " not found");
        }
        Map columnNameMap = getColumnNameMap(dataobjectClass, namespace);

        Iterator itr = fm.keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            String value = (String) fm.get(key);
            int periodPos = (value).indexOf(".");
            String dbField = value.substring(periodPos + 1);
            String mapField = null;
            String dbFieldType = (String) columnNameMap.get(dbField.toUpperCase());

            mapField = Vocabulary.getNameMapping(objType, key, namespace);

            if (mapField != null) {
                table.addField(new SQLFieldDescription(key,
                        SQLTypeToDMQLType(dbFieldType), dbFieldType, false,
                        mapField));
            }
        }

        return table;
    }

    private static Map getColumnNameMap(Class classToMap, int namespace) {
        Configuration c  = RETSServerApp.getHibernateUtil().getConfiguration();
        Map attributeMap = new HashMap();
        if (c != null) {
        	cat.debug("Class to map: " + classToMap);
	        PersistentClass pc = c.getClassMapping(classToMap);

	        // add class identifier
	        Property p = pc.getIdentifierProperty();
	        String type = findDataType(p, namespace);
	        attributeMap.put(p.getName().toUpperCase(), type);
	        //cat.debug("type for "+classToMap.getName()+"."+p.getName()+":"+p.getType()+" set to "+attributeMap.get(p.getName()));

	        // add class properties
	        Iterator itr = pc.getPropertyIterator();
	        while (itr.hasNext()) {
	            p = (Property) itr.next();
	            type = findDataType(p, namespace);

//	            attributeMap.put(p.getName(), type);
//	            cat.debug("type for "+classToMap.getName()+"."+p.getName()+":"+p.getType()+" set to "+attributeMap.get(p.getName()));
		        Iterator columnIterator = p.getColumnIterator();
		        while (columnIterator.hasNext()) {
		            Column column = (Column) columnIterator.next();
		            attributeMap.put(column.getName().toUpperCase(), type);
		            cat.debug("type for "+classToMap.getName()+"."+column.getName()+":"+p.getType()+" set to "+attributeMap.get(column.getName()));
		        }

	        }
        }
        return attributeMap;
    }

    /**
     * @param p
     * @return
     */
    private static String findDataType(Property p, int namespace) {
        String type = null;
        if (p.getType() instanceof ManyToOneType) {
            type = "Character";

            // TODO: use the ManyToOneType relationship to find the type
            // in the associated class
//            // get the class name of the ManyToOneType's associated class
//            String temp = ((ManyToOneType) p.getType()).getAssociatedClass().getName();
//            String className = temp.substring(temp.lastIndexOf('.') + 1);
//            tableDescriptionsMap.get(className);
//        	TableDescription td = getTableDescription(className, namespace);
//        	return td.getField(p.getName()).getDataType();
        }
        if (p.getType() instanceof StringType ||
            p.getType() instanceof CharacterType) {
                type = "Character";
        } else if (p.getType() instanceof IntegerType ||
                p.getType() instanceof LongType) {
            type = "Number";
        } else if (p.getType() instanceof DateType ||
                p.getType() instanceof CalendarType) {
            type="Date";
        }else{
            cat.error("unknown type for "+p.getName()+":"+p.getType());
        }
        return type;
    }

    /**
     *  This private method is used by buildFieldMappings to parse an xml
     *  template and return a hash map of elementName to sqlFieldName mappings.
     *
     *  @param node root node for the xml template
     */
    private static HashMap getRETSMappings(Node node) {
        try {
            HashMap retHash = new HashMap();
            NodeList kids = node.getChildNodes();

            if (kids != null) {
                for (int i = 0; i < kids.getLength(); i++) {
                    HashMap tmpHash = getRETSMappings(kids.item(i));

                    if (tmpHash != null) {
                        retHash.putAll(tmpHash);
                    }
                }
            }

            if ((node.getNodeType() == Node.CDATA_SECTION_NODE) ||
                    (node.getNodeType() == Node.TEXT_NODE)) {
                String code = node.getNodeValue();

                // this code is specific to the simple xml mapping files
                Node parent = node.getParentNode();

                if ((code != null) && code.startsWith("OBJECT:")) {
                    String object = code.substring(code.indexOf(':') + 1,
                            code.indexOf(';'));
                    String attribute = code.substring(code.lastIndexOf(':') +
                            1);
                    retHash.put(parent.getNodeName(), attribute);
                }
            }

            return retHash;
        } catch (Exception e) {
            cat.error(e);
        }

        return null;
    }

    /**
     *  Converts SQL datatypes to DMQL datatypes.  This is specific to your sql
     *  implementation.
     *  @param inType sql data type
     */
    public static String SQLTypeToDMQLType(String inType) {
        if (inType == null) {
            return "";
        }

        if (inType.equalsIgnoreCase("varchar") ||
                inType.equalsIgnoreCase("char")) {
            return "Character";
        }

        if (inType.equalsIgnoreCase("decimal") ||
                inType.equalsIgnoreCase("double") ||
                inType.equalsIgnoreCase("integer")) {
            return "Number";
        }

        if (inType.equalsIgnoreCase("date")) {
            return "Date";
        }

        return inType;
    }
}

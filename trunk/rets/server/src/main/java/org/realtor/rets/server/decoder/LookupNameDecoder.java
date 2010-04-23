/*
 * LookupNameDecoder
 *
 * Created on Mar 24, 2005, 1:22 PM
 */
package org.realtor.rets.server.decoder;

import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Category;
import org.realtor.rets.persistence.SqlQueryEngine;
import org.realtor.rets.util.ResourceLocator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *  Tool to convert system field values to decoded lookup values.
 *
 *        @author         $Author: ekovach $
 *        @version        $Revision: 1.4 $
 */
public class LookupNameDecoder {
	
    protected static Category cat = Category.getInstance(LookupNameDecoder.class);
    
    /**
        The name of the MetaData file that contains the field and lookup information.
     */
    private static final String METADATA_FILE = "RETSMetadata15.xml";
    
	/**
	    A HashMap of system fields to lookup names.
	 */
	public static HashMap systemLookupNameHashMap = null;
	
	/**
	    A HashMap of system fields to lookup names.
	 */
	public static HashMap standardLookupNameHashMap = null;
	
	/**
	    A HashMap of lookup names to a HashMap of mapped values.
	 */
	public static HashMap lookupValueHashMap = null;
	
	/**
	    A HashMap of lookup names to a HashMap of reverse-mapped values.
    */
	public static HashMap reverseLookupValueHashMap = null;

	/**
	    Initialize the internal data maps.
	 */
	private static void initialize() {
		try {
		    systemLookupNameHashMap = new HashMap();
		    standardLookupNameHashMap = new HashMap();
		    lookupValueHashMap = new HashMap();
		    reverseLookupValueHashMap = new HashMap();
			initialize(ResourceLocator.locate(METADATA_FILE));
		}
		catch (Exception e) {
		    cat.error(e);
		}
	}
	
	/**
	    Initialize the internal data maps with the MetaData file specified by the path.
	    @param metaDataFilePath The file path to the MetaData file.
	 */
	private static void initialize(String metaDataFilePath) throws IOException, ParserConfigurationException, SAXException {
	    cat.debug("Initializing LookupNameDecoder with metadata file: " + metaDataFilePath);
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(metaDataFilePath);
        Node retsNode = document.getDocumentElement();
        Node metadataNode = getChildNode(retsNode, "METADATA");
        Node metadatasystemNode = getChildNode(metadataNode, "METADATA-SYSTEM");
        Node systemNode = getChildNode(metadatasystemNode, "System");
        Node metadataresourceNode = getChildNode(systemNode, "METADATA-RESOURCE");

        NodeList resourceNodeList = metadataresourceNode.getChildNodes();
        for (int resourceCounter = 0; resourceCounter < resourceNodeList.getLength(); resourceCounter++) {
            Node resourceNode = resourceNodeList.item(resourceCounter);
            Node metadataclassNode = getChildNode(resourceNode, "METADATA-CLASS");
            if (metadataclassNode == null) {
                continue;
            }

            NodeList nl = metadataclassNode.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node classNode = nl.item(i);
                if (classNode.getNodeName().equalsIgnoreCase("Class")) {
                    String className = getChildNode(classNode, "ClassName").getFirstChild().getNodeValue();
                    Node metadatatableNode = getChildNode(classNode, "METADATA-TABLE");
                    NodeList fieldNodeList = metadatatableNode.getChildNodes();
                    for (int j = 0; j < fieldNodeList.getLength(); j++) {
                        Node fieldNode = fieldNodeList.item(j);
                        if (fieldNode.getNodeName().equalsIgnoreCase("Field")) {
                            Node lookupNameNode = getChildNode(fieldNode, "LookupName");
                            if (lookupNameNode != null) {
                                Node lookupNameNodeChildNode = lookupNameNode.getFirstChild();
                                if (lookupNameNodeChildNode != null) {
                                    String lookupName = lookupNameNodeChildNode.getNodeValue();
                                    
                                    Node standardNameNode = getChildNode(fieldNode, "StandardName");
                                    if (standardNameNode != null) {
                                        Node standardChildNode = standardNameNode.getFirstChild();
                                        if (standardChildNode != null) {
                                            String standardName = standardChildNode.getNodeValue();
                                            standardLookupNameHashMap.put(standardName.toUpperCase(), lookupName);
                                        }
                                    }
                                    
                                    Node systemNameNode = getChildNode(fieldNode, "SystemName");
                                    if (systemNameNode != null) {
                                        Node systemChildNode = systemNameNode.getFirstChild();
                                        if (systemChildNode != null) {
                                            String systemName = systemChildNode.getNodeValue();
                                            systemLookupNameHashMap.put(systemName.toUpperCase(), lookupName);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Node metadatalookupNode = getChildNode(resourceNode, "METADATA-LOOKUP");
            if (metadatalookupNode == null) {
                continue;
            }
            nl = metadatalookupNode.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node lookupTypeNode = nl.item(i);
                if (lookupTypeNode.getNodeName().equalsIgnoreCase("LookupType")) {
                    Node lookupNameNode = getChildNode(lookupTypeNode, "LookupName");
                    String lookupName = lookupNameNode.getFirstChild().getNodeValue();
                    Node metadatalookuptypeNode = getChildNode(lookupTypeNode, "METADATA-LOOKUP_TYPE");
                    NodeList lookupNodeList = metadatalookuptypeNode.getChildNodes();
                    for (int j = 0; j < lookupNodeList.getLength(); j++) {
                        Node lookupNode = lookupNodeList.item(j);
                        if (lookupNode.getNodeName().equalsIgnoreCase("Lookup")) {
                            Node valueNode = getChildNode(lookupNode, "Value");
                            Node longValueNode = getChildNode(lookupNode, "LongValue");
                            String value = "";
                            if (valueNode.getFirstChild() != null) {
                                value = valueNode.getFirstChild().getNodeValue();
                            }
                            String longValue = "";
                            if (longValueNode.getFirstChild() != null) {
                                longValue = longValueNode.getFirstChild().getNodeValue();
                            }

                            HashMap map = (HashMap) lookupValueHashMap.get(lookupName.toUpperCase());
                            if (map == null) {
                                map = new HashMap();
                            }
                            HashMap reverseMap = (HashMap) reverseLookupValueHashMap.get(lookupName.toUpperCase());
                            if (reverseMap == null) {
                                reverseMap = new HashMap();
                            }
                            map.put(value.trim().toUpperCase(), longValue);
                            reverseMap.put(longValue, value.trim());
                            lookupValueHashMap.put(lookupName.toUpperCase(), map);
                            reverseLookupValueHashMap.put(lookupName.toUpperCase(), reverseMap);
                        }
                    }
                }
            }
        }
        cat.debug("LookupNameDecoder initialization successful (" + systemLookupNameHashMap.size() + " SystemNames with LookupNames, " + lookupValueHashMap.keySet().size() + " mappings)");
	}
	
	
	/**
	    Get the first child of the specified parent node with the specified name.
	    @return the first child of the specified parent node with the specified name or null
	    if no such child exists.
	 */
	private static Node getChildNode(Node parentNode, String childName) {
		NodeList nl = parentNode.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node.getNodeName().equalsIgnoreCase(childName)) {
				return node;
			}
		}
		return null;
	}
	/**
	    Get the encoded value for the specified standard field name and value.
	    @param fieldStandardName
	    @param value
	    @return The encoded value for the specified standard field name and value.
	 */
	public static String encodeStandardValue(String fieldStandardName, String value) {
	    if (lookupValueHashMap == null) {
	        initialize();
	    }
	    
		String returnValue = value;
		String lookupName = (String) standardLookupNameHashMap.get(fieldStandardName.toUpperCase());
		if (lookupName != null) {
			HashMap valueMap = (HashMap) reverseLookupValueHashMap.get(lookupName.toUpperCase());
			if (valueMap != null) {
				String tempValue = (String) valueMap.get(value);
				if (tempValue != null) {
				    returnValue = tempValue;
				    cat.debug("Encoded " + fieldStandardName.toUpperCase() + " [" + value + "] to [" + returnValue + "]");
				}
			}
		}
		return returnValue;
	}
	
	/**
	    Get the decoded value for the specified system field name and value.
	    @param fieldSystemName
	    @param value
	    @return The decoded value for the specified system field name and value.
	 */
	public static String decodeSystemValue(String fieldSystemName, String value) {
	    if (lookupValueHashMap == null) {
	        initialize();
	    }
	    
		String returnValue = value;
		String lookupName = (String) systemLookupNameHashMap.get(fieldSystemName.toUpperCase());
		if (lookupName != null) {
			HashMap valueMap = (HashMap) lookupValueHashMap.get(lookupName.toUpperCase());
			if (valueMap != null) {
				String tempValue = (String) valueMap.get(value);
				if (tempValue != null) {
				    returnValue = tempValue;
				    cat.debug("Decoded " + fieldSystemName.toUpperCase() + " [" + value + "] to [" + returnValue + "]");
				}
			}
		}
		return returnValue;
	}
}

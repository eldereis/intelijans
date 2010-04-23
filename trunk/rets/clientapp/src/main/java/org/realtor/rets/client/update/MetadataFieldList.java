/* $Header: /usr/local/cvsroot/rets/clientapp/src/main/java/org/realtor/rets/client/update/MetadataFieldList.java,v 1.8 2005/05/02 15:41:15 ekovach Exp $  */
package org.realtor.rets.client.update;

import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Category;
import org.apache.xpath.XPathAPI;
import org.realtor.rets.util.XMLUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;


/**
 *  MetadataFieldList.java Created Oct 6, 2003
 *
 *  Copyright 2003, Avantia inc.
 *  @version $Revision: 1.8 $
 *  @author ekovach
 */
public class MetadataFieldList {
    static Category cat = Category.getInstance(MetadataFieldList.class);
    
    private Document metaData;
    private Vector addFields;
    private Vector changeFields;
    private String resource;
    private String classID;
    private String [] systemNames = null;
    private String [] standardNames = null;

    public MetadataFieldList(String metadataString, String resource, String classID) throws IOException, ParserConfigurationException, SAXException {
        this(XMLUtils.stringToDocument(metadataString), resource, classID);
    }
    
    public MetadataFieldList(Document meta) {
        metaData = meta;
    }

    public MetadataFieldList(Document meta, String resource, String classID) {
        this(meta);
        this.resource = resource;
        this.classID = classID;
    }
    
    /**
        Set the internal resource value.
     */
    public void setResource(String resource) {
        this.resource = resource;
    }
    
    /**
     	Set the internal class ID value.
    */
    public void setClassID(String classID) {
        this.classID = classID;
    }
    
    public Vector getAddFields() {
        if (addFields == null) {
            addFields = parseAddFieldsXML();
        }
        return addFields;
    }

    public Vector getChangeFields() {
        if (changeFields == null) {
            changeFields = parseChangeFieldsXML();
        }
        return changeFields;
    }
    
    /**
        Get an array of all the system names for the specified resource and classID..
     */
    public String [] getSystemNameList(String resource, String classID) {
        if (systemNames == null) {
            systemNames = getList(resource, classID, "SystemName");
        }
        return systemNames;
    }
    
    /**
     	Get an array of all the system names.
    */
    public String [] getSystemNameList() {
        return getSystemNameList(this.resource, this.classID);
    }
    
    /**
	    Get an array of all the standard names for the specified resource and classID.
	 */
	public String [] getStandardNameList(String resource, String classID) {
        if (systemNames == null) {
            systemNames = getList(resource, classID, "StandardName");
        }
        return systemNames;
	}
	
    /**
     	Get an array of all the standard names.
    */
	public String [] getStandardNameList() {
	    return getStandardNameList(this.resource, this.classID);
	}

	/**
	 	Get the class IDs for the specified resource.
    */
	public String [] getClassIDs(String resource) {
	    TreeSet returnSet = new TreeSet();
	    
	    String query = "//METADATA-RESOURCE/Resource[ResourceID=\"" +
	    	resource + "\"]/METADATA-CLASS/Class/ClassName";
	    return getChildNodeValues(query);
	}
	
	/**
	    Get the class IDs for the current resource.
	 */
	public String [] getClassIDs() {
	    return getClassIDs(this.resource);
	}
	
	/**
	    Get a list of the system or standard names.
	    @param elementName The element name ("SystemName" or "StandardName").
	    @return The list of the system or standard names.
	 */
	private String [] getList(String resource, String classID, String elementName) {
	    TreeSet returnSet = new TreeSet();
	    
	    String query = "//METADATA-RESOURCE/Resource[ResourceID=\"" +
	    	resource + "\"]/METADATA-CLASS/Class[ClassName=\"" + classID +
	    	"\"]/METADATA-TABLE/Field/" + elementName;
	    return getChildNodeValues(query);
	}
	
	/**
	    Get a list of child node values for the specified XPath query.
	    @return a list of child node values for the specified XPath query.
	 */
	private String [] getChildNodeValues(String query) {
	    TreeSet returnSet = new TreeSet();
	    
	    try {
	        NodeIterator iterator = XPathAPI.selectNodeIterator(metaData, query);
	        do {
	            Node node = iterator.nextNode();
	            if (node == null) {
	                break;
	            }
	            returnSet.add(node.getFirstChild().getNodeValue());
	        }
	        while (true);
	    }
	    catch (TransformerException e) {
	        cat.error(e);
	    }
	    
	    return (String []) returnSet.toArray(new String[returnSet.size()]);
	}
    
    /**
        Get the system name for the specified standard name.
        @param standardName
        @return The system name for the specified standard name.
     */
    public String getSystemName(String standardName) {
        String systemName = null;
        
        String query = "//METADATA-RESOURCE/Resource[ResourceID=\"" +
        	resource + "\"]/METADATA-CLASS/Class[ClassName=\"" + classID +
        	"\"]/METADATA-TABLE/Field[StandardName=\"" + standardName + "\"]/SystemName";
        try {
            Node systemNameNode = XPathAPI.selectSingleNode(metaData, query);
            systemName = systemNameNode.getFirstChild().getNodeValue();
            cat.debug("Resolved standard name [" + standardName + "] to system name [" + systemName + "]");
        }
        catch (TransformerException e) {
            cat.error(e);
        }
        
        return systemName;
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
     *
     */
    private Vector parseAddFieldsXML() {
        Vector vector = new Vector();

        String addQuery = getAddOrUpdateQuery("Add");
        
        try {
            NodeList list = XPathAPI.selectNodeList(metaData, addQuery);

            for (int i = 0; i < list.getLength(); i++) {
                Node current = list.item(i);
                vector.add(current.getFirstChild().getNodeValue());
            }
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Collections.sort(vector);
        return vector;
    }
    
    /**
    *
    */
    private Vector parseChangeFieldsXML() {
       Vector vector = new Vector();
       String changeQuery = getAddOrUpdateQuery("Chg");
       try {
           NodeList list = XPathAPI.selectNodeList(metaData, changeQuery);
           for (int i = 0; i < list.getLength(); i++) {
               Node current = list.item(i);
               vector.add(current.getFirstChild().getNodeValue());
           }
       } catch (TransformerException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
       Collections.sort(vector);
       return vector;
   }
    
    private String getAddOrUpdateQuery(String updateName) {
        return "//METADATA-RESOURCE/Resource[ResourceID=\"" +
        resource + "\"]/METADATA-CLASS/Class[ClassName=\"" + classID +
        "\"]/METADATA-UPDATE/UpdateType[UpdateName=\"" + updateName + "\"]/METADATA-UPDATE_TYPE/UpdateField/SystemName";
    }
}

/*
 * Created on Jan 21, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.realtor.rets.server.formatter;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.realtor.rets.persistence.SearchResults;
import org.realtor.rets.util.ResourceLocator;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author jmiller
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class StandardXmlFormatter implements OutputFormatter {

    protected static final String DOCTYPE = "<!DOCTYPE RETS SYSTEM \"RETS-20021015.dtd\">";
    protected static final String SEARCHCOUNT = "Count";
    protected static final String SEARCHLIMIT = "Limit";
    protected static final String SEARCHDELIMITER = "DELIMITER";
    protected static final String SEARCHTYPE = "SearchType";

    protected HashMap templates = new HashMap();
    protected DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    protected DocumentBuilder db = null;

    public StandardXmlFormatter() {
        dbf.setNamespaceAware(true);
        try {
            this.db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            // FIXME correct Error Checking
        }

        String qualifiedFilename = ResourceLocator.locate("ResidentialProperty.xml");
        templates.put(qualifiedFilename, this.loadDocument(qualifiedFilename));
    }
    
    private Document loadDocument(String filename) {
        //FIXME workaround
        String cleanFilename = filename.replace('/', '\\');
        cleanFilename = cleanFilename.replaceAll("%20", " ");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        DocumentBuilder db;
        Document returnDocument = null;
        try {
            //get template
            returnDocument = this.db.parse(new File(cleanFilename));
        } catch (SAXException e) {
        } catch (IOException e) {
        }
        return returnDocument;
    }
    /* (non-Javadoc)
     * @see org.realtor.rets.server.formatter.OutputFormatter#output(org.realtor.rets.persistence.SearchResults, java.util.Map, java.io.Writer)
     */
    public void output(SearchResults results, Map parameters, Writer outputBuffer, int namespace) throws IOException {

        outputBuffer.write("<?xml version=\"1.0\" standalone=\"no\"?>\r\n");
        outputBuffer.write(DOCTYPE + "\r\n");
        outputBuffer.write("<RETS ReplyCode=\"");
        outputBuffer.write(results.getReplyCode());
        outputBuffer.write("\" ReplyText=\"");
        outputBuffer.write(results.getReplyText());
        outputBuffer.write("\"");

        if (! results.isOk()) {
            outputBuffer.write(" />\r\n");
        } else {
            outputBuffer.write(" >\r\n");
            fillContent(results, parameters, outputBuffer);
            outputBuffer.write("</RETS>\r\n");
        }
        outputBuffer.flush();
    }
    
    private void fillContent(SearchResults results, Map properties, Writer outputBuffer) throws IOException {
        boolean maxRows = false;
        boolean countOnly = false;
        boolean countAndData = false;

        Integer countLimit = new Integer(700);

        if (properties.get(SEARCHLIMIT) != null) {
            String cntStr = (String) properties.get(SEARCHLIMIT);

            if (!"None".equalsIgnoreCase(cntStr)) {
                countLimit = new Integer(cntStr);
            }
        }
        
        String searchCount = (String) properties.get(SEARCHCOUNT);
        if (searchCount != null) {
            if ("1".equals(searchCount)) {
                countAndData = true;
            } else if ("2".equals(searchCount)) {
                countOnly = true;
            }
        }
        
        if (searchCount != null) {
            if (countOnly || countAndData) {
                outputBuffer.write("<COUNT Records=\"" + results.getRows().size() +
                    "\" />\r\n");
            }
        }

        Document doc = null;
        String compact = null;
        if (!countOnly) {
            if (results.getRows().size() > countLimit.intValue()) {
                maxRows = true;
            }
            
           buildSearchReply(results, outputBuffer, properties);

           if (maxRows) {
                outputBuffer.write("<MAXROWS/>\r\n");
            }            
        }

    }

    /**
     * @param results
     * @return
     */
    private Document buildSearchReply(SearchResults results, Writer outputBuffer, Map properties) {
        String xmlTemplate = ResourceLocator.locate("ResidentialProperty.xml");
        String objectType = "Property";
        String containerName = "REProperties";
        String elementName = "ResidentialProperty";

        String searchType = (String) properties.get(StandardXmlFormatter.SEARCHTYPE);
        if ("agent".equals(searchType)) {
            objectType = "Agent";
            xmlTemplate = ResourceLocator.locate("REAgent.xml");
            containerName = "REAgents";
            elementName = "REAgent";
        } else if ("office".equals(searchType)) {
            xmlTemplate = ResourceLocator.locate("REOffice.xml");
            objectType = "Office";
            containerName = "REOffices";
            elementName = "REOffice";            
        } 

        return buildXmlSearchReply(objectType, containerName, elementName,
            xmlTemplate, results, outputBuffer);
    }

    /**
     * @param objectType
     * @param containerName
     * @param elementName
     * @param xmlTemplate
     * @param results
     * @return
     */
    private Document buildXmlSearchReply(String objectType, String containerName, String elementName, 
            String xmlTemplate, SearchResults results, Writer outputBuffer) {
        Document doc = null;

        try {
            
            outputBuffer.write("<REData>\r\n");
            outputBuffer.write("<" + containerName + ">\r\n");
            Document docTemplate = (Document) templates.get(xmlTemplate);
            NodeList nList = docTemplate.getElementsByTagName(elementName);
            HashMap nodeMap = this.buildNodeMap(nList.item(0), objectType);
            //add elements to target document
            Iterator itr = results.getRows().iterator();
            while (itr.hasNext()) {
                HashMap attrList = (HashMap) itr.next();
                for (Iterator nodeItr  = nodeMap.keySet().iterator(); nodeItr.hasNext(); ) {
                    String attribute = (String) nodeItr.next();
                    Node currentNode = (Node) nodeMap.get(attribute);
                    String attrValue = (String) attrList.get(attribute);

                    if (attrValue == null) {
                        currentNode.setNodeValue("");
                    } else {
                        currentNode.setNodeValue(attrValue);
                    }
                }
                this.printNode(nList.item(0), "\t", outputBuffer);
                
            }
            outputBuffer.write("</" + containerName + ">\r\n");
            outputBuffer.write("</REData>\r\n");
            
            
        } catch (Exception e) {
            doc = null;
        }

        return doc;
    }
    
    public void printNode(Node node, String indent, Writer outputBuffer) throws IOException {
        String nodeName = node.getNodeName();

        if (nodeName.equals("#text")) {
            String nodeText = node.getNodeValue();

            if ((nodeText != null) && (nodeText.trim().length() > 0) && ! nodeText.trim().equals("\n")) {
                outputBuffer.write(indent);
                outputBuffer.write(nodeText.trim() + "\r\n");
            }
        } else {
            outputBuffer.write(indent);
            outputBuffer.write("<" + nodeName + " ");
        }


        if (!nodeName.equals("#text")) {
            NamedNodeMap attrs = node.getAttributes();

            if (attrs != null) {
                for (int i = 0; i < attrs.getLength(); i++) {
                    Node attr = attrs.item(i);
                    outputBuffer.write(attr.getNodeName() + "=\"" +
                        attr.getNodeValue() + "\" ");
                }
            }
            outputBuffer.write(">\r\n");
        }

        NodeList children = node.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {
            printNode(children.item(i), indent + "\t", outputBuffer);
        }
        
        if (!nodeName.equals("#text")) {
            outputBuffer.write(indent + "</" + nodeName + ">\r\n");
        }
    }
    

    private HashMap buildNodeMap(Node node, String listType) {
        HashMap nodeMap = new HashMap();
        
        try {
            NodeList kids = node.getChildNodes();

            if (kids != null) {
                for (int i = 0; i < kids.getLength(); i++) {
                    nodeMap.putAll(buildNodeMap(kids.item(i), listType));
                }
            }

            if ((node.getNodeType() == Node.CDATA_SECTION_NODE) ||
                    (node.getNodeType() == Node.TEXT_NODE)) {
                String code = node.getNodeValue();

                // this code is specific to the simple xml mapping files
                if ((code != null) && code.startsWith("OBJECT:")) {
                    String objectPrefix = "";
                    String object = code.substring(code.indexOf(':') + 1,
                            code.indexOf(';'));
                    String attribute = code.substring(code.lastIndexOf(':') +
                            1).toLowerCase();

                    if (object.startsWith("P")) {
                        objectPrefix = "p.";
                    } else if (object.startsWith("A")) {
                        objectPrefix = "la.";
                    } else if (object.startsWith("O")) {
                        objectPrefix = "lo.";
                    }
                    
                    if (object.equalsIgnoreCase(listType)) {
                        nodeMap.put(objectPrefix + attribute, node);

                    }
                }
            }
        } catch (Exception e) {
            //FIXME need real error checking here
        }
        
        return nodeMap;
    }
    
}

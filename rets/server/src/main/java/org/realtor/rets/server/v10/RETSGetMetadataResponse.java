// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v10/RETSGetMetadataResponse.java,v 1.6 2005/04/05 20:49:59 ekovach Exp $
package org.realtor.rets.server.v10;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Category;
import org.realtor.rets.server.RETSResponse;
import org.realtor.rets.util.ResourceLocator;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 *  RETSGetMetadataResponse generates the Metadata response.
 *
 *  @author jbrush
 *  @version 1.0
 */
public class RETSGetMetadataResponse extends RETSResponse {
    /** Log4J Category object*/
    static Category cat = Category.getInstance(RETSGetMetadataResponse.class);
//    protected static final String METADATA_FILE = "RETSMetadata.xml";
    protected static final String METADATAFORMAT = "Format";

    /** object to syncronize against */
    protected static Object syncObj = new Object();

    /** Document to hold metadata.xml */
    protected static Document metadataDoc = null;
    String format = null;
    
    private static final List ACCEPTABLE_METADATA_DTD_LIST = Arrays.asList(new String [] {
            "RETS-METADATA-20041001.dtd",
            "RETS-METADATA-20021015.dtd",
            "RETS-METADATA-20001001.dtd"});

    /** Create a new RETSGetMetadataResponse populating the request parameters.
     *
     *  @param m map containing the request key/value pairs
     */
    public RETSGetMetadataResponse(Map m) {
        super(m);

        String[] item = (String[]) m.get(METADATAFORMAT);

        if (item != null) {
            format = item[0];
        } else {
            format = "STANDARD-XML";
        }
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     *  Builds the framework of the response and calls fillContent to add the
     *  body.
     */
    protected void buildResponse() {
        String[] typeList = (String[]) requestMap.get("Type");
        responseMap.put("metadataComponent", typeList);

        String resource = null;
        String resourceClass = null;

        String[] idList = (String[]) requestMap.get("ID");

        setReplyCode(REPLY_CODE_SUCCESS);

        if (idList == null) {
            cat.error("ID not set");
        } else {
            int idx = idList[0].indexOf(":");

            if (idx == -1) // no secondary id set
             {
                resource = idList[0];
            } else {
                resource = idList[0].substring(0, idx);
                resourceClass = idList[0].substring(idx + 1);
            }

            cat.debug("resource=[" + resource + "]");
            cat.debug("resourceClass=[" + resourceClass + "]");
        }

        cat.debug("type=" + typeList[0] + " id=" + resource + ":" +
            resourceClass);
        
        if (isStdXml() && format.endsWith(".dtd")) {
            String dtdString = format.substring(format.indexOf(":") + 1);
            if (! ACCEPTABLE_METADATA_DTD_LIST.contains(dtdString)) {
                setReplyCode(REPLY_CODE_DTD_UNAVAILABLE);
            }
        }

        if (isStdXml()) {
            appendResponse("<?xml version=\"1.0\" ?>\r\n");

            //appendResponse("<!DOCTYPE RETS SYSTEM \"RETS-METADATA-20021015.dtd\">\r\n");
        }

        appendResponse("<RETS ReplyCode=\"");
        appendResponse(getReplyCode());
        appendResponse("\" ReplyText=\"");
        appendResponse(getReplyText());
        appendResponse("\"");

        if (getReplyCode() != REPLY_CODE_SUCCESS) {
            cat.error("*****isERROR");
            appendResponse(" />");
        } else {
            appendResponse(" >\r\n");

            if (isStdXml()) {
                appendResponse("<METADATA>\r\n");
            }

            fillContent(typeList[0], resource, resourceClass);

            if (isStdXml()) {
                appendResponse("</METADATA>\r\n");
            }

            if (getReplyCode() != REPLY_CODE_SUCCESS) {
                appendResponse("<RETS-STATUS ReplyCode=\"");
                appendResponse(getReplyCode());
                appendResponse("\" ReplyText=\"");
                appendResponse(getReplyText());
                appendResponse("\" />\r\n");
            }

            appendResponse("</RETS>\r\n");
        }

        //cat.debug ("RESPONSE ::"+this.response.toString());
    }

    ////////////////////////////////////////////////////////////////////////

    /**
     *  Fills in the body of the response.
     */
    void fillContent(String type, String resource, String resourceClass) {
        Node node = null;
        String xmlString = null;

        boolean recurse = false;
        boolean allSiblings = false;
        boolean resourceFound = false;
        boolean metadataFound = false;

        if ("*".equals(resource) || "*".equals(resourceClass)) {
            recurse = true;
        } else if ("0".equals(resource) || "0".equals(resourceClass)) {
            allSiblings = true;
        }

        // Get the list of resource elements in the Metadata DOM
        NodeList list = getMetadataDocument().getElementsByTagName(type);

        int len = list.getLength();
        if (len == 0) {
            setReplyCode(REPLY_CODE_GETMETADATA_INVALID_TYPE);
            return;
        }
        cat.debug("NodeList length=" + len);

        if (len == 0) {
            setReplyCode(REPLY_CODE_NO_METADATA_FOUND);

            return;
        }

        for (int i = 0; i < len; i++) {
            node = list.item(i);

            cat.debug("node[" + i + "].name=" + node.getNodeName());

            if ("*".equals(resource) || "0".equals(resource)) {
                xmlString = transform(node, recurse);
                appendResponse(xmlString);
                metadataFound = true;
                resourceFound = true;

                continue;
            } else // find specific resource
             {
                NamedNodeMap map = node.getAttributes();

                cat.debug("NamedNodeMap map=" + map.toString());

                Node curResourceNode = map.getNamedItem("Resource");

                if (curResourceNode != null) {

                    String curResource = curResourceNode.getNodeValue();

                    cat.debug("curResourceNode.name=" +
                        curResourceNode.getNodeName());
                    cat.debug("curResourceNode.type=" +
                        curResourceNode.getNodeType());
                    cat.debug("curResourceNode.value=" +
                        curResourceNode.getNodeValue());

                    cat.debug("curResource=" + curResource);

                    if (curResource.equals(resource)) {
                        resourceFound = true;
                        cat.debug("resource = " + resource + " FOUND");

                        if ("*".equals(resourceClass) ||
                                "0".equals(resourceClass) ||
                                (resourceClass == null)) {
                            xmlString = transform(node, recurse);
                            appendResponse(xmlString);
                            metadataFound = true;

                            continue;
                        } else // find specific class or lookup  or "ValidationLookup" attribute
                         {
                            Node curResourceClassNode = map.getNamedItem(
                                    "Class");

                            if (curResourceClassNode == null) // if no 'Class' try 'Lookup'
                             {
                                curResourceClassNode = map.getNamedItem(
                                        "Lookup");

                                if (curResourceClassNode == null) // if no 'Class' or 'Lookup' try "ValidationLookup"
                                 {
                                    curResourceClassNode = map.getNamedItem(
                                            "ValidationLookup");
                                }
                            }

                            if (curResourceClassNode != null) {
                                String curResourceClass = curResourceClassNode.getNodeValue();

                                cat.debug("curResourceClass=" +
                                    curResourceClass);

                                if ((resourceClass == null) ||
                                        (curResourceClass == null) ||
                                        curResourceClass.equals(resourceClass)) {
                                    cat.debug("resourceClass = " +
                                        resourceClass + " FOUND");
                                    xmlString = transform(node, recurse);
                                    appendResponse(xmlString);
                                    metadataFound = true;

                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (!resourceFound) {
            setReplyCode(REPLY_CODE_GETMETADATA_INVALID_RESOURCE);
        } else if (!metadataFound) {
            setReplyCode(REPLY_CODE_NO_METADATA_FOUND);
        }
    }

    /**
     *  Performs the XSL transformation starting at <code>node</code>
     *  @param  node    starting node of tree
     *  @param  recurse if true, follow METADATA sub-types
     */
    private String transform(Node node, boolean recurse) {
        /** stream for xslt template */
        Source xsltSource = null;
        StringWriter sw = new StringWriter();

        try {
            // Use a Transformer for output
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = null;

            if (isStdXml()) {
                if (recurse) {
                    cat.debug("transform: identity transform");
                    transformer = tFactory.newTransformer(); //identity transformation
                    transformer.setOutputProperty("omit-xml-declaration", "yes");
                } else {
                    cat.debug("transform: identity transform");
                    xsltSource = new StreamSource(new File(
                                ResourceLocator.locate("metadata0.xsl")));
                    transformer = tFactory.newTransformer(xsltSource); // skip METADATA-
                    transformer.setOutputProperty("omit-xml-declaration", "yes");
                }
            } else {
                String depth = (recurse) ? "*" : "x";
                String delimiter = "\t";
                cat.debug("transform: COMPACT " + depth);
                xsltSource = new StreamSource(new File(ResourceLocator.locate(
                                "metadata-compact.xsl")));

                transformer = tFactory.newTransformer(xsltSource);
                transformer.setOutputProperty("omit-xml-declaration", "yes");

                transformer.setParameter("depth", depth);
                transformer.setParameter("delimiter", delimiter);
            }

            Source xmlSource = new DOMSource(node);
            Result result = new StreamResult(sw);
            transformer.transform(xmlSource, result);
        } catch (TransformerConfigurationException tce) {
            // Error generated by the parser
            // Use the contained exception, if any
            Throwable x = tce;

            if (tce.getException() != null) {
                x = tce.getException();
            }

            cat.error("** Transformer Factory error   " + tce.getMessage(), x);
        } catch (TransformerException te) {
            // Error generated by the parser
            // Use the contained exception, if any
            Throwable x = te;

            if (te.getException() != null) {
                x = te.getException();
            }

            cat.error("** Transformation error   " + te.getMessage(), x);
        }

        return sw.toString();
    }

    private boolean isStdXml() {
        return format.startsWith("STANDARD-XML");
    }

    private Document getMetadataDocument() {
        if (metadataDoc == null) // build DOM document
         {
            synchronized (syncObj) {
                if (metadataDoc == null) {
                    try {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

                        //factory.setValidating(true);
                        //factory.setNamespaceAware(true);
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        File metadataFile = new File(ResourceLocator.locate(getMetadataFile()));
                        cat.debug("Reading metadata from file " + metadataFile);
                        metadataDoc = builder.parse(metadataFile);
                    } catch (SAXException sxe) {
                        // Error generated during parsing)
                        Exception e = sxe;

                        if (sxe.getException() != null) {
                            e = sxe.getException();
                        }

                        cat.error("Error generated during parsing", e);
                    } catch (ParserConfigurationException pce) {
                        // Parser with specified options can't be built
                        cat.error("Parser with specified options can't be built",
                            pce);
                    } catch (IOException ioe) {
                        // I/O error
                        cat.error("I/O error", ioe);
                    }
                }
            }
        }

        return metadataDoc;
    }
    
    /**
        Get the name of the Metadata file.
        @return The name of the Metadata file.
     */
    protected String getMetadataFile() {
    	return "RETSMetadata.xml";
    }
}

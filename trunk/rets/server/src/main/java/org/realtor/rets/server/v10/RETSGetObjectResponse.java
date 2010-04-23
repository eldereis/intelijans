//$Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/v10/RETSGetObjectResponse.java,v 1.17 2005/03/17 13:40:09 ekovach Exp $
package org.realtor.rets.server.v10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletContext;

import org.apache.log4j.Category;
import org.realtor.rets.server.RETSResponse;
import org.realtor.rets.server.ResponseException;

/**
 *        Generate the Get Object Response
 *
 *        @author        ekovach
 *        @version 1.0
 *
 *  Assumes files are organized as images/<resource>/<type>/<resource-entity>_<object_id>.<extension>
 */
public class RETSGetObjectResponse extends RETSResponse {

    /** log4j object */
    static Category cat = Category.getInstance(RETSGetObjectResponse.class);

	/**
	   Map of MIME type Strings to Lists of acceptable file extensions.
	 */
	private static HashMap mimeTypeHashMap = new HashMap();

	/**
	   The Accept MIME type list.
	 */
	private String accept;

    /** ServletContext object */
    protected ServletContext context = null;

    /**
        Whether or not the RETSGetObject request is multipart.
     */
    private boolean isMultipartRequest = false;

    /**
        The ArrayList of response items.
     */
    private ArrayList responseList;

    /**
        The list of valid Resources.  Set to null to force initial reading from properties.
     */
    private List validResourceList = null;

    /**
     	The list of valid Types.  Set to null to force initial reading from properties.
    */
    private List validTypeList = null;

	static {
		mimeTypeHashMap.put("image/jpeg", Arrays.asList(new String [] {".jpg", ".jpeg"}));
		mimeTypeHashMap.put("image/gif", Arrays.asList(new String [] {".gif"}));
		mimeTypeHashMap.put("image/tiff", Arrays.asList(new String [] {".tif", ".tiff"}));
	}

    public RETSGetObjectResponse(Map m, String accept) {
        super(m);
        this.accept = accept;

        // default the accept to use .gif files if not specified
        if (this.accept == null) {
        	this.accept = "images/gif";
        }
    }

    /**
     *  Sets the ServletContext from the servlet to be used to get the real path
     *  for processing the get all objects request
     *
     *  @param newContext ServletContext from servlet to be used to get real path
     */
    public void setContext(ServletContext newContext) {
        context = newContext;
    }

    /**
        Get whether or not this RETSGetObjectResponse is multipart.
     */
    public boolean isMultipartResponse() {
    	return responseList.size() > 1;
    }

    /**
        Get whether or not this is a multipart request.
     */
    public boolean isMultipartRequest() {
    	return this.isMultipartRequest;
    }

    /**
        Get whether or not the specified resource is valid.
     */
    public boolean isValidResource(String resource) {
    	if (validResourceList == null) {
    		String resourceList = prop.getProperty("GetObjectResources");
    		if (resourceList == null) {
    			// default to "Property" if GetObjectResources property is missing
    			validResourceList = Arrays.asList(new String [] {"Property"});    		}
    		else {
    			validResourceList = new ArrayList();
    			StringTokenizer st = new StringTokenizer(resourceList, ",");
    			while (st.hasMoreTokens()) {
    				validResourceList.add(st.nextToken());
    			}
    		}
    	}
    	return validResourceList.contains(resource);
    }

    /**
	    Get whether or not the specified resource is valid.
	 */
	public boolean isValidType(String type) {
    	if (validTypeList == null) {
    		String typeList = prop.getProperty("GetObjectTypes");
    		if (typeList == null) {
    			// default to "Photo" if GetObjectTypes property is missing
    			validTypeList = Arrays.asList(new String [] {"Photo"});    		}
    		else {
    			validTypeList = new ArrayList();
    			StringTokenizer st = new StringTokenizer(typeList, ",");
    			while (st.hasMoreTokens()) {
    				validTypeList.add(st.nextToken());
    			}
    		}
    	}
		return validTypeList.contains(type);
	}

    /**
     *  Builds the response, putting the results in the responseMap (see RETSResponse)
     */
    protected void buildResponse() {
    	responseList = new ArrayList();

        // get the prioritized list of file extensions from the Accept header
        Collection fileExtensionCollection = null;
        try {
        	fileExtensionCollection = parseFileExtensions(accept);
        }
        catch (ResponseException e) {
    		responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_NO_OBJECT_FOUND)));
    		return;
        }

        String [] resource = ((String[]) requestMap.get("Resource"));
        String [] id = ((String[]) requestMap.get("ID"));
        if ((id == null) || (id.length < 1)) {
        	responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_INVALID_IDENTIFIER)));
        	return;
        }
		isMultipartRequest = (id[0].indexOf('*') >= 0) || (id[0].indexOf(',') >= 0);

		if ((resource != null) && (resource.length > 0) && isValidResource(resource[0])) {
	        String [] type = ((String[]) requestMap.get("Type"));
			if ((type != null) && (type.length > 0) && isValidType(type[0])) {
		        StringTokenizer idTokenizer = new StringTokenizer(id[0], ",");
		        while (idTokenizer.hasMoreTokens()) {
		            String resourceSet = idTokenizer.nextToken().trim();

		            StringTokenizer idItemTokenizer = new StringTokenizer(resourceSet, ":");

		            String resourceEntity = idItemTokenizer.nextToken();

		            // change the resourceEntity into a "test name" for sample image set
					resourceEntity = getTestResourceEntity(resourceEntity);

		            while (idItemTokenizer.hasMoreTokens()) {
		                String objectId = idItemTokenizer.nextToken().trim();
		                addToResponseList(responseList, fileExtensionCollection, type[0], resource[0], resourceEntity, objectId);
		            }
		        }

		        if (responseList.size() == 0) {
		        	responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_INVALID_IDENTIFIER)));
		        }
			}
			else {
				responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_INVALID_TYPE)));
			}
		}
		else {
			responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_INVALID_RESOURCE)));
		}

		responseMap.put("responseDescriptorList", responseList.toArray(new RETSObjectResponseDescriptor[responseList.size()]));
    }

    /**
     * Change the specified resourceEntity to return a valid test image
     * resource entity.
	 * @param resourceEntity
	 */
	private String getTestResourceEntity(String resourceEntity) {
		String map = "abcdefghijk";
		try {
		    resourceEntity = String.valueOf(map.charAt(
		                Integer.parseInt(resourceEntity) % map.length()));
		} catch (NumberFormatException e) {
		    resourceEntity = "a";
		}
		return resourceEntity;
	}

	/**
	 * @param responseList The ArrayList to which to add the response object(s).
	 * @param fileExtensionCollection The Collection of prioritized file extensions.
	 * @param type
	 * @param resource
	 * @param resourceEntity
	 * @param objectId
	 */
	private void addToResponseList(ArrayList responseList, Collection fileExtensionCollection, String type, String resource, String resourceEntity, String objectId) {
		String [] objectIds = null;

		if ("*".equals(objectId)) {
			try {
				objectIds = getWildcardObjectIds(resource, type, resourceEntity);
			}
			catch (ResponseException e) {
				responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_NO_OBJECT_FOUND)));
			}
		}
		else {
			objectIds = new String[] {objectId};
		}

		// for each resource name, find the file and add it to the file list
		for (int i = 0; i < objectIds.length; i++) {
			try {
				String filename = mapToFile(resource, type,
						resourceEntity, objectIds[i], fileExtensionCollection);
				responseList.add(new RETSObjectResponseDescriptor(filename, resourceEntity));
			}
			catch (ResponseException e) {
				responseList.add(new RETSObjectResponseDescriptor(new ResponseException(REPLY_CODE_NO_OBJECT_FOUND)));
			}
		}
	}

	/**
        Get the String list of wildcard object ids.
        @param resource
        @param type
        @param resourceEntity
        @return the String list of wildcard resources.
        @throws ResponseException Thrown if either the corresponding resource or type
        directories are not found.
      */
    private String [] getWildcardObjectIds(String resource, String type, String resourceEntity) throws ResponseException {

    	TreeSet resourceTreeSet = new TreeSet();
        if (context != null) {
        	File pathFile = new File(getPath(resource, type));

        	// get a TreeSet of the files without extensions
        	String [] list = pathFile.list();
            for (int fileCounter = 0; fileCounter < list.length; fileCounter++) {
            	String filename = list[fileCounter];
            	if (filename.startsWith(resourceEntity + "_")) {
            		int extensionDelimiterIndex = filename.lastIndexOf('.');
            		if (extensionDelimiterIndex > 0) {
            			String resourceSet = filename.substring(0, extensionDelimiterIndex);
            			resourceSet = resourceSet.substring(resourceSet.indexOf("_") + 1);
            			resourceTreeSet.add(resourceSet);
            		}
            	}
            }
        }
        cat.debug("Total matching wildcard object ids: " + resourceTreeSet);

        // return the list of resources
        return (String []) resourceTreeSet.toArray(new String[resourceTreeSet.size()]);
    }

    /**
	    Get the local file system path for the specified resource and type.
	    @return the local file system path for the specified resource and type.
	    @throws ResponseException Thrown if either the corresponding resource or type
	    directories are not found.
	 */
	private String getPath(String resource, String type) throws ResponseException {
	    String path = "images/" + resource + "/" + type + "/";
        File realPath = new File(path);
        if (context != null) {
        	realPath = new File(context.getRealPath(path));
        	cat.debug("Resolved resource/type " + resource + "/" + type +
        			" to path " + realPath.getAbsolutePath());
        }
       	return realPath.getAbsolutePath();
	}

    /**
     	Get the file mapping.
     	@param resource
    	@param type
    	@param resourceEntity
    	@param objectId
    	@param fileExtensionCollection
    */
    private String mapToFile(String resource, String type,
        String resourceEntity, String objectId, Collection fileExtensionCollection) throws ResponseException {

    	// get a path to where items of the resource and type are stored
    	String path = getPath(resource, type);

    	String filename = null;

        // find the highest-priority file + extension that exists
        boolean fileFound = false;
        Iterator iterator = fileExtensionCollection.iterator();
        while (iterator.hasNext() && (!fileFound)) {
        	Iterator fileExtensionsIterator = ((List) iterator.next()).iterator();
            while (fileExtensionsIterator.hasNext()) {
            	String fileExtension = (String) fileExtensionsIterator.next();
            	filename = path + File.separator + resourceEntity + "_" + objectId + fileExtension;
                cat.debug("Looking for object file " + filename);
            	if (new File(filename).exists()) {
            		cat.debug("Object file " + filename + " found");

            		// try opening the file to see if it is readable
                    try {
                        InputStream is = new FileInputStream(filename);
                        is.close();
                		cat.debug("Object file " + filename + " is readable");
                		fileFound = true;
                    }
                    catch (IOException e){
                		cat.debug("Object file " + filename + " is not readable");
                		// don't throw an error...just try the next available file
                    }
            		break;
            	}
            }
        }
        if (!fileFound) {
        	setNoObjectFoundStatus();
        	throw new ResponseException(REPLY_CODE_NO_OBJECT_FOUND);
        }

        cat.debug("Using file:" + filename);

        return filename;
    }

	/**
	 	Perform any necessary operations for an "object not found" error.
	 */
	protected void setNoObjectFoundStatus() {
		// do nothing for this RETS version
	}

	/**
	 	Perform any necessary operations for an "invalid MIME type" error.
	*/
	protected void setInvalidMimeTypeStatus() throws ResponseException {
		// do nothing for this RETS version
	}

    /**
        Return a Collection of String arrays of priority-ordered file extension groups based
        on the given accept value String's MIME types and qvalues.
        @return The requested Collection or null if an unsupported MIME type is referenced.
     */
    private Collection parseFileExtensions(String accept) throws ResponseException {
		TreeMap extensionTreeMap = new TreeMap();

		if (accept.equals("*/*")) {
			List allExtensionsList = new ArrayList();
			// add all the possible extensions to the extensionsTreeMap with equal qvalues
			Iterator iterator = mimeTypeHashMap.values().iterator();
			while (iterator.hasNext()) {
				Iterator extensionsIterator = ((List) iterator.next()).iterator();
				while (extensionsIterator.hasNext()) {
					allExtensionsList.add(extensionsIterator.next());
				}
			}
			extensionTreeMap.put(new ReverseSortedDouble(1.0), allExtensionsList);
		}
		else {
			StringTokenizer acceptTokenizer = new StringTokenizer(accept, ",");
			while (acceptTokenizer.hasMoreTokens()) {
				String token = acceptTokenizer.nextToken();
				StringTokenizer acceptItemTokenizer = new StringTokenizer(token, ";");
				String mimeType = acceptItemTokenizer.nextToken().trim();
				Object extensionsList = mimeTypeHashMap.get(mimeType);
				if (extensionsList == null) {
					setInvalidMimeTypeStatus();
					throw new ResponseException(REPLY_CODE_UNRECOGNIZED_MIME_TYPE);
				}

				// read the qvalue if it's specified
				double qvalue = 1.0;
				if (acceptItemTokenizer.hasMoreTokens()) {
					StringTokenizer qvalueTokenizer = new StringTokenizer(acceptItemTokenizer.nextToken(), "=");
					if (qvalueTokenizer.nextToken().equals("q") && qvalueTokenizer.hasMoreTokens()) {
						try {
							qvalue = Double.parseDouble(qvalueTokenizer.nextToken());
							cat.debug("MIME type " + mimeType + " has qvalue of " + qvalue);
						}
						catch (Exception e) {
							// default to 1.0 for an illegal or unspecified qvalue number
						}
					}
				}

				// add the qvalue/extension pair to the extensionTreeMap
				extensionTreeMap.put(new ReverseSortedDouble(qvalue), extensionsList);
			}
		}

        cat.debug("Accept: " + accept + " -> extension priority: " + extensionTreeMap);

		// return the list of extensions
		return extensionTreeMap.values();
    }

	/**
	    Comparable implementation to reverse-sort double values.  Used for qvalue reverse
	    sorting.
	 */
	private static class ReverseSortedDouble implements Comparable {
		private Double valueDouble;

		public ReverseSortedDouble(double value) {
			valueDouble = new Double(value);
		}

		public Double getValueDouble() {
			return valueDouble;
		}

		public int compareTo(Object object) {
			if (object instanceof ReverseSortedDouble) {
				ReverseSortedDouble rsd = (ReverseSortedDouble) object;
				// return the OPPOSITE compareTo value (x.compareTo(this) instead of this.compareTo(x))
				return rsd.getValueDouble().compareTo(getValueDouble());
			}
			else {
				throw new UnsupportedOperationException();
			}
		}

		public String toString() {
			return valueDouble.toString();
		}
	}

	/**
	 	A description of a RETS get object response.
	 */
	public static class RETSObjectResponseDescriptor {
		private String filename = null;

		private ResponseException exception;

		private String contentId = null;

		private String description = null;

		/**
		 	Construct a RETSObjectResponseDescriptor with a filename, a content ID, and a description.
	    */
		public RETSObjectResponseDescriptor(String filename, String contentId, String description) {
			this.filename = filename;
			this.contentId = contentId;
			this.description = description;
		}

		/**
		 	Construct a RETSObjectResponseDescriptor with a filename and a content ID.  Automatically
		 	sets a description based on the contentId.
	    */
		public RETSObjectResponseDescriptor(String filename, String contentId) {
			this(filename, contentId, contentId);
		}

		public RETSObjectResponseDescriptor(ResponseException e) {
			this.exception = e;
			this.description = e.getMessage();
		}

		public boolean isSuccessful() {
			return exception == null;
		}

		public String getFilename() {
			return this.filename;
		}

		public int getErrorCode() {
			if (exception == null) {
				return REPLY_CODE_SUCCESS;
			}
			else {
				return exception.getCode();
			}
		}

		public String getContentId() {
			return this.contentId;
		}

		public String getDescription() {
			return this.description;
		}
	}
}

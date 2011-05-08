  import java.net.*;
import java.io.*;
import org.w3c.dom.*;
import org.apache.xerces.dom.*;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.*;
import org.apache.xml.serialize.*;
import org.xml.sax.InputSource; 
import java.util.Properties;
    import java.io.*;
    import java.io.StringReader;
    import java.net.MalformedURLException;
    import java.net.URL;
    import java.rmi.RemoteException;
    import java.util.Calendar;
    import javax.xml.parsers.ParserConfigurationException;
    import javax.xml.parsers.SAXParser;
    import javax.xml.parsers.SAXParserFactory;
    import javax.xml.rpc.ServiceException;
    import javax.activation.DataHandler;
    import javax.mail.internet.MimeMultipart;
    import org.apache.xerces.*;
    import org.xml.sax.InputSource;
    import org.xml.sax.SAXException;
    import org.xml.sax.SAXParseException;
    import org.xml.sax.helpers.DefaultHandler;
    import com.flashline.registry.openapi.base.OpenAPIException;
    import com.flashline.registry.openapi.entity.AuthToken;
    import com.flashline.registry.openapi.service.v300.FlashlineRegistry;
    import com.flashline.registry.openapi.service.v300.FlashlineRegistryServiceLocator;
    import com.flashline.registry.openapi.entity.Asset;
    import com.flashline.registry.openapi.entity.*;

    import com.flashline.registry.openapi.entity.Categorization;
    import com.flashline.registry.openapi.entity.CategorizationType;
    import com.flashline.registry.openapi.query.*;

import java.util.StringTokenizer;

public class OERLoader  {
    static com.flashline.registry.openapi.service.v300.FlashlineRegistryServiceTestCase t;
    static String fileAssets=null;
    static String fileRelationships=null;
    static boolean flagCategIDs = false;
    static String user;
    static String pwd;
    static MyAsset[] assets = new MyAsset[0];
    static MyAsset curMYA= null;
    static MyRelationship[] relationships = new MyRelationship[0];
    static MyRelationship curREL= null;
    static URL lURL = null;
    
    public static void main(String pArgs[]) throws ServiceException, ParserConfigurationException, SAXException, IOException {
        String SCHEMA_LANGUAGE ="http://java.sun.com/xml/jaxp/properties/schemaLanguage";
        String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
        String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
        SAXParserFactory lSaxParserFactory = null;
        SAXParser lSaxParser = null;
        TabBean[] lTabBeans = null;
        try {
            ///////////////////////////////////////////////////////////
            // Connect to Oracle Enterprise Repository
            ///////////////////////////////////////////////////////////
            System.out.println("Example command execution for Asset and Relationships - java.exe OERLoader http://ip_address:port/oer/services/FlashlineRegistry?WSDL admin admin1 -fileAsset Asset.xml -fileRel Relationships.xml");
            System.out.println("Example command execution for getIDs - java.exe OERLoader http://ip_address:port/oer/services/FlashlineRegistry?WSDL admin admin1 -getIDs");
            //URL lURL = null;
            lURL = new URL(pArgs[0]);
            user = pArgs[1];
            pwd = pArgs[2];            
            // -fileAsset Assets.xml
            if (pArgs[3].equalsIgnoreCase("-getIDs")){
                System.out.println("WARNING - You are in mode GET-IDS!");
                flagCategIDs=true;
            }
            if (pArgs[3].equalsIgnoreCase("-fileAsset")) fileAssets = pArgs[4];
            if (pArgs[3].equalsIgnoreCase("-fileRel")) fileRelationships = pArgs[4];
            
            if (pArgs.length >5){
                if (pArgs[5].equalsIgnoreCase("-fileAsset")) fileAssets = pArgs[6];
                if (pArgs[5].equalsIgnoreCase("-fileRel")) fileRelationships = pArgs[6];
            }
            
            System.out.println("CONFIGURATION FILEs - Assets:"+fileAssets+", Relations:"+fileRelationships);
            
            if (fileAssets== null && fileRelationships == null && flagCategIDs==false){ 
                System.out.println("ERROR: Doesn't provided configuration files!");
                return;
            }

            if (fileAssets!= null ){ 
                System.out.println("Loading XML Assets...");
                getXML(fileAssets);
                System.out.println("XML asset loaded!");
            }

            if (fileRelationships!= null ){ 
                System.out.println("Loading XML Relationships...");
                getXMLRelationships(fileRelationships);
                System.out.println("XML Relationships loaded!");
            }

            // UPDATE RELATIONSHIPS
             /*         for (int idxRel = 0; idxRel < relationships.length; idxRel++)
                        {
                            System.out.println("Pre-Relationships "+idxRel);
                            updateRelationships(relationships[idxRel]);
                            System.out.println("Post-Relationships "+idxRel);
                        }   
                        if (true) return;
            */
          FlashlineRegistry repository = new FlashlineRegistryServiceLocator().getFlashlineRegistry(lURL);
          ///////////////////////////////////
          // Login to OER
          ///////////////////////////////////
          AuthToken authToken = repository.authTokenCreate(pArgs[1],pArgs[2]);
          com.flashline.registry.openapi.entity.Asset assetRes = null;
          // Anonymous class to handle validation errors
          DefaultHandler lDefaultHandler = new DefaultHandler() {
            public void error(SAXParseException exception) throws SAXException {
              throw exception;
            }
            public void fatalError(SAXParseException exception) throws SAXException {
              throw exception;
            }
          };
          
          if (flagCategIDs) {
            listCategorizations(repository,authToken,"aTTIP");
            listCategorizations(repository,authToken,"AssetLifecycleStage");
            return;
          }
          
          //////////////////////////////////////////////////////////////////////
          // Define the asset you want to create in XML
          //////////////////////////////////////////////////////////////////////
          // This is the XML of the asset we're creating. Typically it would
          // come from a GUI or other asset creation mechanism. It is hard
          // coded for this example.
          /////////////////////////////////////////////////////////////////////
            
          // Create/Update Assets
          for (int idxAsset = 0; idxAsset < assets.length; idxAsset++)
          {
              curMYA= assets[idxAsset];
              if (!(curMYA.prop.getProperty("action").equalsIgnoreCase("DELETE")
                || curMYA.prop.getProperty("action").equalsIgnoreCase("UPDATE") || curMYA.prop.getProperty("action").equalsIgnoreCase("ADD"))){
                    System.out.println("ASSET ("+curMYA.prop.getProperty("Name")+") with wrong action: "+curMYA.prop.getProperty("action"));
                    break;
                }
              if (curMYA.prop.getProperty("action").equalsIgnoreCase("DELETE") 
                || curMYA.prop.getProperty("action").equalsIgnoreCase("UPDATE")) {
                  Asset curAsset = getAssetByName(curMYA.prop.getProperty("Name"),curMYA.prop.getProperty("Version"), repository,authToken);
                  if (curAsset == null){
                        System.out.println("NOT FOUND Name:"+curMYA.prop.getProperty("Name")+", "+curMYA.prop.getProperty("Version"));
                    }else{
                        repository.assetDelete(authToken, curAsset.getID());
                        System.out.println("DELETED Asset.GetID = " + curAsset.getID()+", Name:"+curAsset.getName());
                  }
              }              
              // CREATE ASSET
              if (curMYA.prop.getProperty("action").equalsIgnoreCase("ADD") 
                  || curMYA.prop.getProperty("action").equalsIgnoreCase("UPDATE")) {
                  String pieceDoc ="<custom-data><documentation><document><document-name>Design Document</document-name><document-url/>	<document-approved>false</document-approved></document>"
			+"<document><document-name>Development Coding Guidelines</document-name><document-url/>	<document-approved>false</document-approved></document>"
			+"<document><document-name>Installation Guidelines</document-name><document-url/>	<document-approved>false</document-approved></document>"
			+"<document><document-name>Maintenance Instructions</document-name><document-url/>	<document-approved>false</document-approved></document>"
                      +"</documentation></custom-data>";
                  
                  String pieceDocWsdl ="<custom-data>" + 
                  "    <comments/>" + 
                  "    <location>linklocation</location>" + 
                  "    <expiration-date/> "+
                  "  <documentation><document><document-name>Link to SharePoint</document-name><document-url/>  <document-approved>false</document-approved></document>"
                  +"<document><document-name>Link to SVN Repository</document-name><document-url/>      <document-approved>false</document-approved></document>"
                  +"</documentation>"+
                  "  </custom-data>";
                  
                  String assetXML = "<asset id=\"0\">"
                      + "           <asset-type id=\"AssetTypeID\" icon=\"component.gif\" lastSavedDate=\""+Calendar.getInstance().getTimeInMillis()+"\">Component</asset-type>"
                      + "           <mandatory-data>"
                      + "               <name>"+curMYA.prop.getProperty("Name")+"</name>"
                      + "               <version>"+curMYA.prop.getProperty("Version")+"</version>"
                      + "               <description><![CDATA["+curMYA.prop.getProperty("Description")+"]]></description>"
                      + "               <keywords></keywords>"
                      + "               <notification-email>"+curMYA.prop.getProperty("notif-email")+"</notification-email>"
                      + "               <applied-policies/>"
                      + "               <vendor id=\"0\"/>"
                      + "               <file-informations/>"
                      + "               <hash-informations/>"
                      + "               <producing-projects/>"
                      + "               <submission-files/>"
                      + "               <applied-compliance-templates/>"
                      + "               <contacts/>"
                      + "               <relationships/>"
                      + "               <categorization-types/>"
                      + "           </mandatory-data>"
                      + "REPLACEDOCUMENT"           
                      + "  <admin-data>"
                      + "           </admin-data>"
                      + "       </asset>";
                  
                  assetXML=assetXML.replaceFirst("AssetTypeID", curMYA.prop.getProperty("AssetTypeID"));
                  if (curMYA.prop.getProperty("AssetTypeID").equalsIgnoreCase("154")){  // Service (154)
                    assetXML=assetXML.replaceFirst("REPLACEDOCUMENT", pieceDoc);
                  }
                  if ((curMYA.prop.getProperty("AssetTypeID").equalsIgnoreCase("170")) || (curMYA.prop.getProperty("AssetTypeID").equalsIgnoreCase("195"))){ // WSDL (170) or XSWD (195)
                    assetXML=assetXML.replaceFirst("REPLACEDOCUMENT", pieceDocWsdl);
                  }
                  //System.out.println("Asset XML=" + assetXML);
                  //////////////////////////////////////////////////////////////////////
                  // This returns the Schema for the asset type of the asset we're
                  // creating
                  //////////////////////////////////////////////////////////////////////
                  String schema = repository.assetTypeSchemaRead(authToken, 144);
                    //System.out.println("schema = " + schema);
                  //////////////////////////////////////////////////////////////////////
                  // This block of code shows validating the asset XML against
                  // the schema
                  //////////////////////////////////////////////////////////////////////
                  lSaxParserFactory = SAXParserFactory.newInstance();
                  lSaxParserFactory.setNamespaceAware(true);
                  lSaxParserFactory.setValidating(true);
                  lSaxParser = lSaxParserFactory.newSAXParser();
                  lSaxParser.setProperty(SCHEMA_LANGUAGE, XML_SCHEMA);
                  lSaxParser.setProperty(SCHEMA_SOURCE, new InputSource(new StringReader(
                      schema)));
                  lSaxParser.parse(new InputSource(new StringReader(assetXML)),
                      lDefaultHandler);
                  //////////////////////////////////////////////////////////////////////
                  // If no exception was thrown the asset XML validates and
                  // the creation should not fail due to XML formatting errors.
                  //////////////////////////////////////////////////////////////////////
              
                  assetRes = repository.assetCreateFromXML(authToken, assetXML);
                  System.out.println("Asset.GetID = " + assetRes.getID());
                
                  // Submit, Accept and Register  
                  repository.assetSubmit(authToken,assetRes.getID()); 
                  repository.assetAccept(authToken,assetRes.getID());
                  repository.assetRegister(authToken, assetRes.getID());
                  
                  // Approve Tabs
                    lTabBeans = repository.assetTabsRead(authToken, assetRes.getID());
                    for (TabBean item : lTabBeans) {
                        System.out.println("Name Item: " + item.getName());
                        repository.assetTabApprove(authToken, assetRes.getID(), item.getId());  // Id del tab   
                    }
                    System.out.println("Pre-Categorization "+idxAsset+" Name:"+assetRes.getName());
                    updateAsset(repository,assetRes,authToken,curMYA);
                    System.out.println("Post-Categorization "+idxAsset+" Name:"+assetRes.getName());
                }  
            } // for on ASSETS
            
            // Update Relationships
            for (int idxRel = 0; idxRel < relationships.length; idxRel++){
                   System.out.println("Pre-Relationships "+idxRel);
                   updateRelationships(relationships[idxRel]);
                   System.out.println("Post-Relationships "+idxRel);
            }
        } catch (OpenAPIException lEx) {
          System.out.println("ServerCode = " + lEx.getServerErrorCode());
          System.out.println("Message    = " + lEx.getMessage());
          System.out.println("StackTrace:");
          lEx.printStackTrace();
        } catch (RemoteException lEx) {
          lEx.printStackTrace();
        } catch (ServiceException lEx) {
          lEx.printStackTrace();
        } catch (MalformedURLException lEx) {
          lEx.printStackTrace();
        }
      }
    
    public static Asset getAssetByName(String name,String version, FlashlineRegistry repository, com.flashline.registry.openapi.entity.AuthToken authToken) throws java.rmi.RemoteException,OpenAPIException {
        SearchTerm[] searchTermArray = new SearchTerm[2];
        SearchTerm term = new SearchTerm();
        term.setKey("/asset/mandatory-data/name");
        term.setValue(name);
        searchTermArray[0] = term;
        term = new SearchTerm();
        term.setKey("/asset/mandatory-data/version");
        term.setValue(version);
        searchTermArray[1] = term;
        AssetCriteria criteria = new AssetCriteria();
        criteria.setSearchTerms(searchTermArray);

        AssetSummary[] assets = repository.assetQuerySummary(authToken, criteria);
        
        if (assets != null && assets.length>0) return repository.assetRead(authToken, assets[0].getID());
        else return null;
    }
    
    public static void updateRelationships(MyRelationship myRel) throws java.rmi.RemoteException,OpenAPIException {
        try {
            FlashlineRegistry repository = new FlashlineRegistryServiceLocator().getFlashlineRegistry(lURL);
            AuthToken authToken = repository.authTokenCreate(user, pwd);
            System.out.println("Asset1:" +myRel.prop.getProperty("Name")+"("+myRel.prop.getProperty("Version")+") - Name2:"+myRel.prop.getProperty("Name2")+"("+myRel.prop.getProperty("Version2")+")");
            Asset firstAsset = getAssetByName(myRel.prop.getProperty("Name"),myRel.prop.getProperty("Version"), repository,authToken);
            
            if (firstAsset == null){ 
                System.out.println("RELATIONSHIPS - First Asset NOT FOUND ("+myRel.prop.getProperty("Name")+","+myRel.prop.getProperty("Version")+")");
                return;
            }
            //RelationshipType[] allRelationshipTypes = getAllRelationshipTypes(repository, authToken);
            RelationshipType[] allRelationshipTypes = firstAsset.getRelationshipTypes();
            
            for (int i = 0; i < allRelationshipTypes.length; i++) {
                if (allRelationshipTypes[i].getName().equals(myRel.prop.getProperty("displayName"))) {  // ReferencedAssets
                    //This is the relationship type, modify the assets that are related using it
                    RelationshipType myRelationshipType = allRelationshipTypes[i];
                    Asset secondAsset = null;
                    
                    if (!myRel.prop.getProperty("action").equalsIgnoreCase("DELETEALL")){
                        secondAsset = getAssetByName(myRel.prop.getProperty("Name2"),myRel.prop.getProperty("Version2"), repository,authToken);
                        if (secondAsset == null){ 
                            System.out.println("RELATIONSHIPS - Second Asset NOT FOUND ("+myRel.prop.getProperty("Name2")+","+myRel.prop.getProperty("Version2")+")");
                            return;
                        }
                    } 
                    //569= MY_OTHER_ASSET_ID
                    //MY_OTHER_ASSET_ID should be an integer and should be  the id of an asset in the repository add this asset to the list of related assets
                    if (myRelationshipType.getDisplaySecondary().toString().equals(myRel.prop.getProperty("display"))){
                        long[] oldSecondaryIDs = myRelationshipType.getSecondaryIDs();
                        long[] newSecondaryIDs =  new long[oldSecondaryIDs.length + 1];
                        
                        if (myRel.prop.getProperty("action").equalsIgnoreCase("ADD")){
                            // Adding relationship
                            for (int j = 0; j < oldSecondaryIDs.length; j++) {
                                newSecondaryIDs[j] = oldSecondaryIDs[j];
                            }
                            newSecondaryIDs[newSecondaryIDs.length - 1] = secondAsset.getID();                            
                        }else{
                            if (myRel.prop.getProperty("action").equalsIgnoreCase("DELETEALL")){
                                // DELETEALL relationship for this type
                                newSecondaryIDs =  new long[0];                            
                            }else{
                                if (myRel.prop.getProperty("action").equalsIgnoreCase("DELETE")){
                                    // DELETE relationship
                                    int len=oldSecondaryIDs.length;
                                    int idx=0;
                                    //newSecondaryIDs =  new long[len];
                                    for (int j = 0; j < oldSecondaryIDs.length; j++) {
                                        if (secondAsset.getID()==oldSecondaryIDs[j]){
                                             oldSecondaryIDs[j] = 0l;
                                             len = len-1;
                                         }
                                    }
                                    newSecondaryIDs =  new long[len];
                                    idx=0;
                                    for (int j = 0; j < oldSecondaryIDs.length; j++) {
                                        if (oldSecondaryIDs[j]!=0l){
                                            newSecondaryIDs[idx] = oldSecondaryIDs[j];
                                            idx++;
                                        }
                                    }
                                }
                            }
                        }
                        myRelationshipType.setSecondaryIDs(newSecondaryIDs);
                    }else{ // primary invert relationship
                        long[] oldPrimaryIDs = myRelationshipType.getPrimaryIDs();
                        long[] newPrimaryIDs =  new long[oldPrimaryIDs.length + 1];
                        
                        /*
                        for (int j = 0; j < oldPrimaryIDs.length; j++) {
                            newPrimaryIDs[j] = oldPrimaryIDs[j];
                        }
                        newPrimaryIDs[newPrimaryIDs.length - 1] = secondAsset.getID();
                        */
                        if (myRel.prop.getProperty("action").equalsIgnoreCase("ADD")){
                            // Adding relationship
                            for (int j = 0; j < oldPrimaryIDs.length; j++) {
                                newPrimaryIDs[j] = oldPrimaryIDs[j];
                            }
                            newPrimaryIDs[newPrimaryIDs.length - 1] = secondAsset.getID();                            
                        }else{
                            if (myRel.prop.getProperty("action").equalsIgnoreCase("DELETEALL")){
                                // DELETEALL relationship for this type
                                newPrimaryIDs =  new long[0];                            
                            }else{
                                if (myRel.prop.getProperty("action").equalsIgnoreCase("DELETE")){
                                    // DELETE relationship
                                    int len=oldPrimaryIDs.length;
                                    int idx=0;
                                    //newSecondaryIDs =  new long[len];
                                    for (int j = 0; j < oldPrimaryIDs.length; j++) {
                                        if (secondAsset.getID()==oldPrimaryIDs[j]){
                                             oldPrimaryIDs[j] = 0l;
                                             len = len-1;
                                         }
                                    }
                                    newPrimaryIDs =  new long[len];
                                    idx=0;
                                    for (int j = 0; j < oldPrimaryIDs.length; j++) {
                                        if (oldPrimaryIDs[j]!=0l){
                                            newPrimaryIDs[idx] = oldPrimaryIDs[j];
                                            idx++;
                                        }
                                    }
                                }
                            }
                        }

                        myRelationshipType.setPrimaryIDs(newPrimaryIDs);
                    }
                    break; // close loop on relationships
                }
            }
            firstAsset.setRelationshipTypes(allRelationshipTypes);
            repository.assetUpdate(authToken, firstAsset);
        } catch (OpenAPIException lEx) {
            System.out.println("ServerCode = " + lEx.getServerErrorCode());
            System.out.println("Message = " + lEx.getMessage());
            System.out.println("StackTrace:");
            lEx.printStackTrace();
        } catch (RemoteException lEx) {
            lEx.printStackTrace();
        } catch (ServiceException lEx) {
            lEx.printStackTrace();
        }
    }

    public static void updateAsset(FlashlineRegistry repository, Asset myAsset,com.flashline.registry.openapi.entity.AuthToken authToken, MyAsset mya) throws ServiceException,
                                            ParserConfigurationException, SAXException, IOException {
        try{
            myAsset.setDescription(mya.prop.getProperty("Description"));
            myAsset.setNotificationEmail(mya.prop.getProperty("notif-email"));
            String[] arrKeys = new String[1];
            arrKeys[0]= mya.prop.getProperty("keywords");
            myAsset.setKeywords(arrKeys);
            
            MyCategorizations aTTIPcats= null;
            MyCategorizations ALScats= null;
            
            //readCategorizations(repository,authToken,"AssetLifecycleStage");
            //aTTIPcats = updateCategorizations(myAsset,mya,repository,authToken,"aTTIP");

            aTTIPcats = updateCategorizations2(myAsset,mya,repository,authToken,"aTTIP");
            ALScats = updateCategorizations(myAsset,mya,repository,authToken,"AssetLifecycleStage");            
            
            aTTIPcats.mergeTo(ALScats);

            myAsset.setCategorizations(aTTIPcats.cats);
            myAsset.setCategorizationTypes(aTTIPcats.catTypes);

            ////////////////////////////////////////////////////////////
            // Modify the custom access settings for the asset
            ///////////////////////////////////////////////////////////
            String[] lCasTypes = repository.customAccessSettingTypesGet(authToken);
            String[] lCustomAccessSettings = null;
            if (lCasTypes!=null && lCasTypes.length>0) {
              lCustomAccessSettings = repository.customAccessSettingNamesGet(authToken,lCasTypes[0]);
            }
            if (lCustomAccessSettings!=null && lCustomAccessSettings.length>0) {
              String[] myCustomAccessSettings = { lCustomAccessSettings[0] };
              myAsset.setCustomAccessSettings(myCustomAccessSettings);
            }
            ////////////////////////////////////////////////////////////
            // Add producing projects to the asset
            ////////////////////////////////////////////////////////////
            long[] producingProjectsIDs = new long[1];
            producingProjectsIDs[0] = 50001; //aTTIP Project
            myAsset.setProducingProjectsIDs(producingProjectsIDs);
            ////////////////////////////////////////////////////////////
            // save the modifications
            ////////////////////////////////////////////////////////////
            repository.assetUpdate(authToken, myAsset);
            repository.assetUpdateCustomDataString(authToken, myAsset.getID(),"attip-serviceid",mya.prop.getProperty("attip-serviceid"));
            repository.assetUpdateCustomDataString(authToken, myAsset.getID(),"documentation/document[document-name='Design Document']/document-url",mya.prop.getProperty("design_doc"));
            repository.assetUpdateCustomDataString(authToken, myAsset.getID(),"documentation/document[document-name='Link to SharePoint']/document-url",mya.prop.getProperty("Link_to_Sharepoint")); // only for WSDL and XSD
            repository.assetUpdateCustomDataString(authToken, myAsset.getID(),"documentation/document[document-name='Link to SVN Repository']/document-url",mya.prop.getProperty("Link_to_SVN"));  // only for WSDL and XSD
            repository.assetUpdateCustomDataString(authToken, myAsset.getID(),"service-type",mya.prop.getProperty("service-type"));
                 
        } catch (OpenAPIException lEx) {
            System.out.println("ServerCode = " + lEx.getServerErrorCode());
            System.out.println("Message    = " + lEx.getMessage());
            System.out.println("StackTrace:");
            lEx.printStackTrace();
        } catch (RemoteException lEx) {
            lEx.printStackTrace();
        }        
    }

    public static void listCategorizations(FlashlineRegistry repository, com.flashline.registry.openapi.entity.AuthToken authToken,String criteria)
                                throws ServiceException,ParserConfigurationException, SAXException, IOException{
        CategorizationType[] lCatTypes =null; 
        Categorization[] lCats =null; 
        CategorizationType[] pAllCatTypes =null; 
        Categorization[] pAllCats = null; 
            ////////////////////////////////////////////////////////////
            // Search for all categorizations that are asset assignable
            ////////////////////////////////////////////////////////////
        CategorizationTypeCriteria categorizationTypeCriteria = new CategorizationTypeCriteria(); 
        categorizationTypeCriteria.setNameCriteria(criteria);
        pAllCatTypes = repository.categorizationTypeQuery(authToken,categorizationTypeCriteria);
        ////////////////////////////////////////////////////////////
        // Find all the categorizations to be assigned to the asset
        ////////////////////////////////////////////////////////////
        lCatTypes=new CategorizationType[pAllCatTypes.length];
        lCats=new Categorization[pAllCatTypes.length];
        
        for (int i = 0; i < pAllCatTypes.length; i++) {
            String valueCat;
            System.out.println("Name Categorization:" + pAllCatTypes[i].getName()+";"+pAllCatTypes[i].getID());
            CategorizationType lCatType = repository.categorizationTypeRead(authToken, pAllCatTypes[i].getID());
            pAllCats = repository.categorizationReadByType(authToken,lCatType, true, true);
            for (Categorization item : pAllCats) {
                System.out.println("Name cats: '" + item.getName()+ "', ID:"+ item.getID());
            }
        }
    }
    
    public static MyCategorizations updateCategorizations(Asset curAsset,MyAsset mya, FlashlineRegistry repository, com.flashline.registry.openapi.entity.AuthToken authToken,String criteria)
                                throws ServiceException,ParserConfigurationException, SAXException, IOException{
        CategorizationType[] lCatTypes =null; 
        Categorization[] lCats =null; 
        CategorizationType[] pAllCatTypes =null; 
        Categorization[] pAllCats = null; 
            ////////////////////////////////////////////////////////////
            // Search for all categorizations that are asset assignable
            ////////////////////////////////////////////////////////////
        CategorizationTypeCriteria categorizationTypeCriteria = new CategorizationTypeCriteria(); 
        categorizationTypeCriteria.setNameCriteria(criteria);
        pAllCatTypes = repository.categorizationTypeQuery(authToken,categorizationTypeCriteria);
        ////////////////////////////////////////////////////////////
        // Find all the categorizations to be assigned to the asset
        ////////////////////////////////////////////////////////////
        lCatTypes=new CategorizationType[pAllCatTypes.length];
        lCats=new Categorization[pAllCatTypes.length];
        
        for (int i = 0; i < pAllCatTypes.length; i++) {
            String valueCat;
            System.out.println("Name Categorization:" + pAllCatTypes[i].getName()+",flag:"+mya.prop.containsKey(pAllCatTypes[i].getName()));
            if (mya.prop.containsKey(pAllCatTypes[i].getName())){
                CategorizationType lCatType = repository.categorizationTypeRead(authToken, pAllCatTypes[i].getID());
                lCatTypes[i] = lCatType;
                // when we find the first one, use it
                // break;
                pAllCats = repository.categorizationReadByType(authToken,lCatType, true, true);
                valueCat= mya.prop.getProperty(pAllCatTypes[i].getName());
                for (Categorization item : pAllCats) {
                    System.out.println("Name cats: '" + item.getName()+ "', ID:"+ item.getID()+", valcat:'"+valueCat+"'");
                    
                    StringTokenizer tokenizer = new StringTokenizer(valueCat, ";");
                    while (tokenizer.hasMoreTokens()){
                        String s=tokenizer.nextToken();
                        //System.out.println(s);
                        if (item.getName().equals(s)) {
                            lCats[i] = item; 
                            System.out.println(" Categorization identified: " + item.getName());
                            //break;
                        }
                    }
                }
            }
            //if (lAllCats.length > 0){
        }
        //lCats[0] = lAllCats[0];
        ////////////////////////////////////////////////////////////
        // Modify the asset to use the categorizations
        ////////////////////////////////////////////////////////////
        
        MyCategorizations myc = new MyCategorizations(lCatTypes,lCats);
        return myc;
        //curAsset.setCategorizations(lCats);
        //curAsset.setCategorizationTypes(lCatTypes);
        //repository.assetUpdate(authToken, curAsset);
    }
    
    public static MyCategorizations updateCategorizations2(Asset curAsset,MyAsset mya, FlashlineRegistry repository, com.flashline.registry.openapi.entity.AuthToken authToken,String criteria)
                                throws ServiceException,ParserConfigurationException, SAXException, IOException{
        CategorizationType[] lCatTypes =null; 
        Categorization[] lCats =null; 
        CategorizationType[] pAllCatTypes =null; 
        Categorization[] pAllCats = null; 
            ////////////////////////////////////////////////////////////
            // Search for all categorizations that are asset assignable
            ////////////////////////////////////////////////////////////
        CategorizationTypeCriteria categorizationTypeCriteria = new CategorizationTypeCriteria(); 
        categorizationTypeCriteria.setNameCriteria(criteria);
        pAllCatTypes = repository.categorizationTypeQuery(authToken,categorizationTypeCriteria);
        ////////////////////////////////////////////////////////////
        // Find all the categorizations to be assigned to the asset
        ////////////////////////////////////////////////////////////
        lCatTypes=new CategorizationType[0]; //pAllCatTypes.length];
        lCats=new Categorization[0]; //pAllCatTypes.length];
        
        int ii=-1;
        for (int i = 0; i < pAllCatTypes.length; i++) {
            String valueCat;
            System.out.println("Name Categorization:" + pAllCatTypes[i].getName()+",flag:"+mya.prop.containsKey(pAllCatTypes[i].getName()));
            if (mya.prop.containsKey(pAllCatTypes[i].getName())){
                CategorizationType lCatType = repository.categorizationTypeRead(authToken, pAllCatTypes[i].getID());
                
                // lCatTypes[i] = lCatType;

                // when we find the first one, use it
                // break;
                pAllCats = repository.categorizationReadByType(authToken,lCatType, true, true);
                valueCat= mya.prop.getProperty(pAllCatTypes[i].getName());
                for (Categorization item : pAllCats) {
                    System.out.println("Name cats: '" + item.getName()+ "', ID:"+ item.getID()+", valcat:'"+valueCat+"'");
                    
                    StringTokenizer tokenizer = new StringTokenizer(valueCat, ";");
                    while (tokenizer.hasMoreTokens()){
                        String s=tokenizer.nextToken();
                        //System.out.println(s);
                        if (item.getName().equals(s)) {
                            ii++;
                            lCatTypes = extendArrayCatT(lCatTypes,lCatType,ii);  // lCatTypes[i] = lCatType;
                            lCats = extendArrayCat(lCats,item,ii); // lCats[i] = item; 
                            System.out.println(" Categorization identified: " + item.getName());
                            //break;
                        }
                    }
                }
            }
            //if (lAllCats.length > 0){
        }
        //lCats[0] = lAllCats[0];
        ////////////////////////////////////////////////////////////
        // Modify the asset to use the categorizations
        ////////////////////////////////////////////////////////////
        
        MyCategorizations myc = new MyCategorizations(lCatTypes,lCats);
        return myc;
        //curAsset.setCategorizations(lCats);
        //curAsset.setCategorizationTypes(lCatTypes);
        //repository.assetUpdate(authToken, curAsset);
    }
    static public CategorizationType[] extendArrayCatT(CategorizationType[] A, CategorizationType obj, int pos) {
       int curpos;
       CategorizationType[] C= new CategorizationType[A.length+1];
       CategorizationType[] B= new CategorizationType[1];
       B[0] = obj;
       if (pos>C.length){pos = C.length; }
       if (pos>0)System.arraycopy(A, 0, C, 0, pos);
       System.arraycopy(B, 0, C, pos, 1);
       System.arraycopy(A, pos, C, pos+1, A.length-pos);
       return C;
    }
    static public Categorization[] extendArrayCat(Categorization[] A, Categorization obj, int pos) {
       int curpos;
       Categorization[] C= new Categorization[A.length+1];
       Categorization[] B= new Categorization[1];
       B[0] = obj;
       if (pos>C.length){pos = C.length; }
       if (pos>0)System.arraycopy(A, 0, C, 0, pos);
       System.arraycopy(B, 0, C, pos, 1);
       System.arraycopy(A, pos, C, pos+1, A.length-pos);
       return C;
    }    
    public static void readCategorizations(FlashlineRegistry repository, com.flashline.registry.openapi.entity.AuthToken authToken,String criteria)
                                throws ServiceException,ParserConfigurationException, SAXException, IOException{
            CategorizationType[] lAllCatTypes = null;
            Categorization[] lAllCats = null;
            CategorizationType[] lCatTypes =null; 
            Categorization[] lCats =null; 
            ////////////////////////////////////////////////////////////
            // Search for all categorizations that are asset assignable
            ////////////////////////////////////////////////////////////
            CategorizationTypeCriteria categorizationTypeCriteria = new CategorizationTypeCriteria(); 
            categorizationTypeCriteria.setNameCriteria(criteria);
            lAllCatTypes = repository.categorizationTypeQuery(authToken,categorizationTypeCriteria);
            ////////////////////////////////////////////////////////////
            // Find all the categorizations to be assigned to the asset
            ////////////////////////////////////////////////////////////
            lCatTypes=new CategorizationType[lAllCatTypes.length];
            lCats=new Categorization[lAllCatTypes.length];

            for (int i = 0; i < lAllCatTypes.length; i++) {
                System.out.println("Name Categorization:" + lAllCatTypes[i].getName());
                CategorizationType lCatType = repository.categorizationTypeRead(authToken, lAllCatTypes[i].getID());
                lCatTypes[i] = lCatType;
                lAllCats = repository.categorizationReadByType(authToken,lCatType, true, true);
                for (Categorization item : lAllCats) {
                    System.out.println("Name cats: '" + item.getName()+ "', ID:"+ item.getID());
                }
                //if (lAllCats.length > 0){
            }
    }
    
    public static void getXML(String fileAssets) {        
      try {
        // Read the response
        DOMParser parser = new DOMParser();
        InputStream in = new FileInputStream(fileAssets);
        InputSource source = new InputSource(in);
        parser.parse(source);
        in.close();

        Document doc = parser.getDocument();
        //System.out.println ("Root element :" + doc.getDocumentElement().getNodeName());
        //writeDocumentToOutput(doc.getDocumentElement(),0);

            NodeList nodes = doc.getElementsByTagName("Asset");
            assets = new MyAsset[nodes.getLength()];
          
            for (int i = 0; i < nodes.getLength(); i++) {
                Node item = nodes.item(i);
                curMYA= new MyAsset();
                extractAsset(item);
                assets[i]= curMYA;
                curMYA= null;
                //writeDocumentToOutput(item);
            }
        
      }
      catch (Exception e) {
        System.err.println(e); 
      }
    }

    public static void extractAsset(Node nodeAsset) {
        // get element name
        String nodeName = nodeAsset.getNodeName();
        // get element value
        String nodeValue = getElementValue(nodeAsset);

        //System.out.println("NodeNameEA: " + nodeName + ", NodeValueEA: " + nodeValue);
        curMYA.prop.setProperty(nodeName, nodeValue);
        
        // FIX to correct wrong configuration of OER on Dev for two categorizations
        if ( nodeName.equalsIgnoreCase("aTTIP_System")) curMYA.prop.setProperty("aTTIP_Systems", nodeValue);
        if (nodeName.equalsIgnoreCase("aTTIP_SystemsReferTo")) curMYA.prop.setProperty("aTTIP_SystemsRefto", nodeValue);
                                                             
        // write all child nodes recursively
        NodeList children = nodeAsset.getChildNodes();
        {
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    extractAsset(child);
                }
            }
        }
    }
 
    public static void getXMLRelationships(String fileRelationships) {        
      try {
        // Read the response
        DOMParser parser = new DOMParser();
        InputStream in = new FileInputStream(fileRelationships);
        InputSource source = new InputSource(in);
        parser.parse(source);
        in.close();
        Document doc = parser.getDocument();
        //System.out.println ("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nodes = doc.getElementsByTagName("Relationship");
            relationships = new MyRelationship[nodes.getLength()];
          
            for (int i = 0; i < nodes.getLength(); i++) {
                Node item = nodes.item(i);
                curREL= new MyRelationship();
                extractRelationship(item);
                relationships[i]= curREL;
                curREL= null;
                //writeDocumentToOutput(item);
            }
      }
      catch (Exception e) {
        System.err.println(e); 
      }
    }

    public static void extractRelationship(Node nodeRel) {
        // get element name
        String nodeName = nodeRel.getNodeName();
        // get element value
        String nodeValue = getElementValue(nodeRel);

        //System.out.println("NodeNameEA: " + nodeName + ", NodeValueEA: " + nodeValue);
        curREL.prop.setProperty(nodeName, nodeValue);
        // write all child nodes recursively
        NodeList children = nodeRel.getChildNodes();
        {
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    extractRelationship(child);
                }
            }
        }
    }
    
    public static class MyRelationship{
        public Properties prop;
        public MyRelationship(){
            this.prop = new Properties();    
        }
    }
    
    public static class MyAsset{
        public Properties prop;
        public MyAsset(){
            this.prop = new Properties();    
        }
    }
    
    public static class MyCategorizations{
        public CategorizationType[] catTypes; 
        public Categorization[] cats; 
        public MyCategorizations(){  
        }
        public MyCategorizations(CategorizationType[] catTypes, Categorization[] cats){
            if (cats != null){
                this.cats= new Categorization[cats.length];
                System.arraycopy(cats, 0, this.cats, 0, cats.length);
            }
            if (catTypes != null){
                this.catTypes= new CategorizationType[catTypes.length];
                System.arraycopy(catTypes, 0, this.catTypes, 0, catTypes.length);
            }        
        }
        public void mergeTo(MyCategorizations src){
            this.catTypes =this.concat(this.catTypes,src.catTypes);
            this.cats =this.concat(this.cats,src.cats);
        } 

        private Categorization[] concat(Categorization[] A, Categorization[] B) {
           Categorization[] C= new Categorization[A.length+B.length];
           System.arraycopy(A, 0, C, 0, A.length);
           System.arraycopy(B, 0, C, A.length, B.length);
           return C;
        }
        private CategorizationType[] concat(CategorizationType[] A, CategorizationType[] B) {
           CategorizationType[] C= new CategorizationType[A.length+B.length];
           System.arraycopy(A, 0, C, 0, A.length);
           System.arraycopy(B, 0, C, A.length, B.length);
           return C;
        }
    }
    
         public final static String getElementValue( Node elem ) {
             Node kid;
             if( elem != null){
                 if (elem.hasChildNodes()){
                     for( kid = elem.getFirstChild(); kid != null; kid = kid.getNextSibling() ){
                         if( kid.getNodeType() == Node.TEXT_NODE  ){
                             return kid.getNodeValue();
                         }
                     }
                 }
             }
             return "";
         }  
         
    /*    private static String getIndentSpaces(int indent) {
             StringBuffer buffer = new StringBuffer();
             for (int i = 0; i < indent; i++) {
                 buffer.append(" ");
             }
             return buffer.toString();
         } */
        public static void writeDocumentToOutput(Node node) {
            // get element name
             String nodeName = node.getNodeName();
             // get element value
             String nodeValue = getElementValue(node);
             // get attributes of element
             NamedNodeMap attributes = node.getAttributes();
             System.out.println( "NodeName: " + nodeName + ", NodeValue: " + nodeValue);

             for (int i = 0; i < attributes.getLength(); i++) {
                 Node attribute = attributes.item(i);
                 System.out.println( "AttributeName: " + attribute.getNodeName() + ", attributeValue: " + attribute.getNodeValue());
             }
             // write all child nodes recursively
            NodeList children = node.getChildNodes();
             for (int i = 0; i < children.getLength(); i++) {
                 Node child = children.item(i);
                 if (child.getNodeType() == Node.ELEMENT_NODE){
                     writeDocumentToOutput(child);
                 }
             }
         }

    public static void UpdateAssetCustData() throws OpenAPIException,RemoteException, ServiceException {
        try {
            ///////////////////////////////////////////////////////////
            // Connect to Oracle Enterprise Repository
            ///////////////////////////////////////////////////////////
            FlashlineRegistry repository =
                new FlashlineRegistryServiceLocator().getFlashlineRegistry(lURL);
            ///////////////////////////////////////////////////////////
            // Login to OER
            ///////////////////////////////////////////////////////////
            AuthToken authToken =
                repository.authTokenCreate(user,pwd);
            ///////////////////////////////////////////////////////////
            // create a criteria object searching for all assets with a
            // custom-data element for test-frequency equal to 'DAILY'
            ///////////////////////////////////////////////////////////
            SearchTerm[] searchTermArray = new SearchTerm[1];
            SearchTerm term = new SearchTerm();
            term.setKey("/asset/mandatory-data/name");
            term.setValue("Name3");
            searchTermArray[0] = term;
            AssetCriteria criteria = new AssetCriteria();
            criteria.setSearchTerms(searchTermArray);
            ///////////////////////////////////////////////////////////
            // perform search, getting back summary objects. loop through
            // objects and perform an action on each one
            ///////////////////////////////////////////////////////////
            AssetSummary[] assets =
                repository.assetQuerySummary(authToken, criteria);
            ///////////////////////////////////////////////////////////
            // Loop through search results
            ///////////////////////////////////////////////////////////
            for (int i = 0; i < assets.length; i++) {
                long assetID = assets[i].getID();
                String testResult = "100";
                String res;
                ///////////////////////////////////////////////////////////
                // Update value in the asset
                ///////////////////////////////////////////////////////////
                res=repository.assetReadCustomDataString(authToken, assetID,"documentation/document[document-name='Design Document']/document-url");
                System.out.println("Res:"+res);
                repository.assetUpdateCustomDataString(authToken, assetID,"documentation/document[document-name='Design Document']/document-url","Url Design");
                
            }
        } catch (OpenAPIException lEx) {
            System.out.println("ServerCode = " + lEx.getServerErrorCode());
            System.out.println("Message = " + lEx.getMessage());
            System.out.println("StackTrace:");
            lEx.printStackTrace();
        } catch (RemoteException lEx) {
            lEx.printStackTrace();
        } catch (ServiceException lEx) {
            lEx.printStackTrace();
        }
    }

    public static void FindRelationshipTypeAndUseInAsset() throws java.rmi.RemoteException,OpenAPIException {
        try {
            FlashlineRegistry repository = new FlashlineRegistryServiceLocator().getFlashlineRegistry(lURL);
            AuthToken authToken = repository.authTokenCreate(user, pwd);

            Asset myAsset = repository.assetRead(authToken, 50374);
            //MY_OTHER_ASSET_ID should be an integer and should be the id of an asset in the repository
            //RelationshipType[] allRelationshipTypes = getAllRelationshipTypes(repository, authToken);
            RelationshipType[] allRelationshipTypes = myAsset.getRelationshipTypes();
            
            for (int i = 0; i < allRelationshipTypes.length; i++) {
                if (allRelationshipTypes[i].getName().equals("ReferencedAssets")) {
                    //This is the relationship type, modify the assets that are related using it
                    RelationshipType myRelationshipType = allRelationshipTypes[i];
                    Asset otherAsset = repository.assetRead(authToken, 50379);
                    //569= MY_OTHER_ASSET_ID
                    //MY_OTHER_ASSET_ID should be an integer and should be  the id of an asset in the repository add this asset to the list of related assets
                    long[] oldSecondaryIDs = myRelationshipType.getSecondaryIDs();
                    long[] newSecondaryIDs =  new long[oldSecondaryIDs.length + 1];
                    for (int j = 0; j < oldSecondaryIDs.length; j++) {
                        newSecondaryIDs[j] = oldSecondaryIDs[j];
                    }
                    newSecondaryIDs[newSecondaryIDs.length - 1] = otherAsset.getID();
                    myRelationshipType.setSecondaryIDs(newSecondaryIDs);
                }
            }
            myAsset.setRelationshipTypes(allRelationshipTypes);
            repository.assetUpdate(authToken, myAsset);
        } catch (OpenAPIException lEx) {
            System.out.println("ServerCode = " + lEx.getServerErrorCode());
            System.out.println("Message = " + lEx.getMessage());
            System.out.println("StackTrace:");
            lEx.printStackTrace();
        } catch (RemoteException lEx) {
            lEx.printStackTrace();
        } catch (ServiceException lEx) {
            lEx.printStackTrace();
        }
    }

    /**
     * This method returns every relationship type in the repository
     * @param repository
     * @param authToken
     * @return
     * @throws RemoteException
     */
    public static RelationshipType[] getAllRelationshipTypes(FlashlineRegistry repository, AuthToken authToken) throws RemoteException {
        //Create an empty relationship type criteria object
        RelationshipTypeCriteria criteria = new RelationshipTypeCriteria();
        criteria.setNameCriteria("ReferencedAssets");
        RelationshipType[] allRelationshipTypes =  repository.relationshipTypeQuery(authToken, criteria);
        return allRelationshipTypes;
    }
}





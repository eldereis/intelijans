/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/mapping/SystemNamesToDataObjectMapping.java,v 1.3 2005/04/04 17:43:14 ekovach Exp $  */
package org.realtor.rets.mapping;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Category;
import org.realtor.rets.server.RETSServerApp;
import org.realtor.rets.util.PropertiesLocator;
import org.realtor.rets.util.PropertiesNotFoundException;


/**
 *  SystemNamesToDataObjectMapping Created Aug 4, 2003
 *  This object can map data from compact format to org.realtor.rets.dataobjects format. In order to successfully process
 *  this mapping, a Map must be created that has name value pairs, where the name is the Standard Name, and the value
 *  is the correct value for that System Name. <br>
 *  This object then looks at StandardNames.properties to determine to which database column each standard name maps.
 *  Then, it looks at repository.xml to figure out the java field names for each column, then it processes the mapping from
 *  Standard Names to java objects. Type conversions are handled by BeanUtils, so all mappings can be Strings. Dates
 *  must be in YYYY-MM-DD format.
 *
 *  Copyright 2003, Avantia inc.
 *  @version $Revision: 1.3 $
 *  @author ekovach
 */
public class SystemNamesToDataObjectMapping {
    static Category cat = Category.getInstance(SystemNamesToDataObjectMapping.class);
    
    /**
        A map of system names to an ArrayList of WarningDescriptions for that system name.
     */
    private static HashMap warningHashMap;
    
    private static SystemNamesToDataObjectMapping instance;
    
    /**
       A HashMap of object types to HashMaps of column names to property names.
     */
    private static HashMap hibernateMap = new HashMap();
    
    public static SystemNamesToDataObjectMapping getInstance() {
        if (instance == null) {
            instance = new SystemNamesToDataObjectMapping();
            initializeWarnings();
        }

        return instance;
    }

    /**
     * Fills an object based on the mappings in the map passed in. These mappings must take the form
     * System Name --> value, where Standard Name is a RETS Standard Name and the value is a String value for that
     * variable. Values are converted by BeanUtils, and dates should be in the format YYYY-MM-DD.
     * @param toFill The listing to fill
     * @param mappings A map containing key value mappings of the form System Name--> value
     * @return A List of WarningDescription objects.
     */
    public List fill(String objectType, Object toFill, Map mappings) throws Exception {
        // get a map of system (column) names to Hibernate names
        Map hibernateMap = RETSServerApp.getClassToNameMap(Class.forName("org.realtor.rets.dataobjects." + objectType));
        
        Iterator iter = mappings.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();

            String hibernateName = (String) hibernateMap.get(key);

            if (hibernateName != null) {
                return fillField(toFill, hibernateName, key, (String) mappings.get(key));
            } else {
                throw new Exception("Key " + key + " doesn't exist");
            }
        }
        
        return new ArrayList();
    }

    private List fillField(Object toFill, String fieldName, String fieldSystemName, String fieldValue) {
        try {
            BeanUtils.setProperty(toFill, fieldName, fieldValue);
        } catch (IllegalAccessException e) {
            // not much we can do here.
        } catch (InvocationTargetException e) {
        } catch (IllegalArgumentException iae) {
            // we've failed on the conversion... try to see if it's a date;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date d = sdf.parse(fieldValue);
                BeanUtils.setProperty(toFill, fieldName, d);
            } catch (Exception ex) {
                // there's nothing we can really do.
            }
        }
        return checkWarning(fieldSystemName, fieldValue);
    }
    
    /**
        Initialize the warningHashMap.
     */
    private static void initializeWarnings() {
        warningHashMap = new HashMap();
        try {
            Properties prop = PropertiesLocator.locateProperties("RETSWarnings.properties");
            
            Iterator iterator = prop.keySet().iterator();
            while (iterator.hasNext()) {
                String code = (String) iterator.next();
                String temp = (String) prop.get(code);
                StringTokenizer st = new StringTokenizer(temp, ",");
                try {
                    WarningDescription wd = new WarningDescription();
                    wd.setCode(code);
                    wd.setFieldName(st.nextToken());
                    wd.setLevel(Integer.parseInt(st.nextToken()));
                    wd.setExpression(st.nextToken());
                    wd.setDescription(st.nextToken());
                    
                    ArrayList warningArrayList = (ArrayList) warningHashMap.get(wd.getFieldName());
                    if (warningArrayList == null) {
                        warningArrayList = new ArrayList();
                    }
                    warningArrayList.add(wd);
                    warningHashMap.put(wd.getFieldName(), warningArrayList);
                }
                catch (NoSuchElementException e) {
                    cat.error("Bad rets warnings line for RETSWarning.properties code " + code + ": " + temp);
                }
                catch (NumberFormatException e) {
                    cat.error("Bad level value for RETSWarning.properties code " + code + ": " + temp);
                }
            }
        }
        catch (PropertiesNotFoundException e) {
            cat.error("RETS Warning file not found: "+ e);
        }
    }
    
    /**
        Return a WarningDescription for the specified system name and value or an empty array
        if no warnings are found.
     */
    private static List checkWarning(String fieldSystemName, String fieldValue) {
        ArrayList returnArrayList = new ArrayList();
        ArrayList warningDescriptionList = (ArrayList) warningHashMap.get(fieldSystemName);
        if (warningDescriptionList != null) {
            cat.debug("Checking warnings for field " + fieldSystemName);
            Iterator iterator = warningDescriptionList.iterator();
            while (iterator.hasNext()) {
                WarningDescription wd = (WarningDescription) iterator.next();
                if (wd.evaluate(fieldValue)) {
                    cat.debug("Declaring warning " + wd);
                    returnArrayList.add(wd);
                }
            }
        }
        return returnArrayList;
    }
}

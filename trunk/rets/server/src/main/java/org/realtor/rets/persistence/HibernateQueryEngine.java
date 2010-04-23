/*
 * Created on Jan 24, 2005
 *
 */
package org.realtor.rets.persistence;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

import org.realtor.rets.database.Agents;
import org.realtor.rets.database.Offices;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.Properties;
import org.realtor.rets.server.RETSServerApp;
import org.realtor.rets.server.SearchQuery;
import org.realtor.rets.server.decoder.Expression;

/**
 * @author jmiller
 *
 */
public class HibernateQueryEngine extends SqlQueryEngine {

    private static List propertyFields = getFields(Properties.class);
    private static List officeFields = getFields(Offices.class);
    private static List agentFields = getFields(Agents.class);
    private static HashMap methodMap = new HashMap();
    
    public void  init() {
        this.addMethods(propertyFields, new Properties(), "property.");
        this.addMethods(agentFields, new Agents(), "agent.");
        this.addMethods(officeFields, new Offices(), "office.");
    }
    
    public void addMethods(List thePropertyFields, Object value, String prefix) {
        for (Iterator itr = thePropertyFields.iterator(); itr.hasNext(); ) {
            Field currentField = (Field) itr.next();
            String currentValue = null;
            try {
                currentValue = (String) (currentField.get(value));
                String methodName = "get" + currentValue.substring(0,1).toUpperCase() + currentValue.substring(1);
                Class objectClass = value.getClass();
                Method getMethod = objectClass.getMethod(methodName, new Class[] {});
                methodMap.put(prefix + currentValue, getMethod);
            } catch (IllegalArgumentException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get method names from database classes", e);
            } catch (IllegalAccessException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get method names from database classes", e);
            } catch (SecurityException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get method names from database classes", e);
            } catch (NoSuchMethodException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get method names from database classes", e);
            }
        }
    }
    
    /* (non-Javadoc)
     * @see org.realtor.rets.persistence.QueryEngine#execute(org.realtor.rets.server.SearchQuery)
     */
    public SearchResults execute(SearchQuery query, Map parameters) throws PersistenceException {
        SearchResults results = new SearchResults();
        List columnNames = new ArrayList();
        Session s = null;
        Collection props = null;
        String limitClause = "";
        String searchOffset = (String) parameters.get(SEARCHOFFSET);
        Integer offset = new Integer(0);

        if (searchOffset != null) {
            offset = new Integer(searchOffset);
        }
        Integer countLimit = new Integer(700);

        if (parameters.get(SEARCHLIMIT) != null) {
            String cntStr = (String) parameters.get(SEARCHLIMIT);

            if (!"None".equalsIgnoreCase(cntStr)) {
                countLimit = new Integer(cntStr);
            }
        }

        limitClause = " limit " + offset + ',' + countLimit;

        String whereClause = this.createWhereClause(query);
        try {
            s = RETSServerApp.getHibernateSession();
            props = s.createSQLQuery("select {Properties.*}, {Agents.*}, {Offices.*} from properties  left join agents on properties.agentlist = agents.uid left join offices on properties.officelist = offices.uid " + 
                    whereClause + limitClause,
                    new String[] {"Properties", "Agents", "Offices"},
                    new Class[] {Properties.class, Agents.class, Offices.class}).list();
            
            //convert objects to results
            List rows = this.getRowsFromResults(props, propertyFields, officeFields, agentFields);
            columnNames.addAll(this.getColumnNames(propertyFields, new Properties()));
            columnNames.addAll(this.getColumnNames(agentFields, new Agents()));
            columnNames.addAll(this.getColumnNames(officeFields, new Offices()));
            results.setColumnNames(columnNames);
            results.setRows(rows);
        } catch (HibernateException e) {
        	throw new PersistenceException("Error performing search request.  Database unavailable.", e, 20203);
        }

        return results;
    }
    
    /**
     * @param officeFields
     * @return
     */
    private List getColumnNames(List fieldList, Object dataValue) {
        List columnNames = new ArrayList();
        for (Iterator itr = fieldList.iterator(); itr.hasNext(); ) {
            Field currentField = (Field) itr.next();
            String currentValue = "";
            try {
                currentValue = (String) (currentField.get(dataValue));
            } catch (IllegalArgumentException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get column names from database classes", e);
            } catch (IllegalAccessException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get column names from database classes", e);
            }
            columnNames.add(currentValue);
        }
        
        return columnNames;
    }

    /**
     * @param results
     * @param propertyFields
     * @param officeFields
     * @param agentFields
     * @return
     */
    private List getRowsFromResults(Collection results, List propertyFields, List officeFields, List agentFields) {
        List returningRows = new ArrayList();
        
        for (Iterator itr = results.iterator(); itr.hasNext(); ) {
            Object[] row = (Object[]) itr.next();
            Properties property = (Properties) row[0];
            Agents agent = (Agents) row[1];
            Offices office = (Offices) row[2];
            HashMap values = this.getColumnValueHash(propertyFields, property, null, "property.");
            values = this.getColumnValueHash(agentFields, agent, values, "agent.");
            values = this.getColumnValueHash(officeFields, office, values, "office.");
            returningRows.add(values);
        }
        
        return returningRows;
    }

    /**
     * @param propertyFields
     * @param property
     * @return
     */
    private HashMap getColumnValueHash(List propertyFields, Object value, HashMap values, String prefix) {
        List valuesList = new ArrayList();
        HashMap valueMap = new HashMap();
        
        if (values != null) {
            valueMap = new HashMap(values);
            valuesList = (List) values.get("VALUES");
        }
        
        for (Iterator itr = propertyFields.iterator(); itr.hasNext(); ) {
            Field currentField = (Field) itr.next();
            String currentValue = null;
            String dataValue = "";
            try {
                currentValue = (String) (currentField.get(value));
                Method getMethod = (Method) methodMap.get(prefix + currentValue);
                Object getValue = getMethod.invoke(value, new Object[] {});
                if (getValue != null) {
                    dataValue = getValue.toString();
                }
            } catch (IllegalArgumentException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get values from the database", e);
            } catch (IllegalAccessException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get values from the database", e);
            } catch (SecurityException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get values from the database", e);
            } catch (InvocationTargetException e) {
                // do nothing... but log the problem.  A developer should know this
                cat.error("Error has occured in get values from the database", e);
            }
            valueMap.put(currentValue.toLowerCase(), dataValue);
            valuesList.add(dataValue);
        }
        valueMap.put("VALUES", valuesList);
        
        return valueMap;
    }

    /**
     * @param class1
     * @return
     */
    private static List getFields(Class dataClass) {
        List columnFields = new ArrayList();
        
        Field[] fields =  dataClass.getFields();
        for (int i= 0; i < fields.length; i++) {
            columnFields.add(fields[i]);
        }
        return columnFields;
    }

    /**
     * @param query
     * @return
     */
    protected String createWhereClause(SearchQuery query) {
        StringBuffer whereClause = new StringBuffer(" where properties.agentlist = agents.uid and properties.officelist = offices.uid and ");
        Expression criteria = query.getQueryExpression();
        
        whereClause.append(this.evaluateExpression(criteria));
        
        return whereClause.toString();
    }

    /**
     * @param string
     * @return
     */
    protected String convertName(String fieldName) {
        String convertedString  = fieldName;
        
        convertedString = convertedString.replaceFirst("p.", "properties.");
        convertedString = convertedString.replaceFirst("la.", "agents.");
        convertedString = convertedString.replaceFirst("lo.", "offices.");

        return convertedString;
    }


}

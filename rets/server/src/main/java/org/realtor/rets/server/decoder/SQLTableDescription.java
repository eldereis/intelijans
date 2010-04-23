/*
 * SQLTableDescription.java
 *
 * Created on October 9, 2002, 11:42 AM
 */
package org.realtor.rets.server.decoder;

import java.util.*;


/**
 *
 * @author  tweber
 */
/**
 *  Table that holds field definitions that define the mappings for
 *  converting between DMQL and SQL queries
 */
public class SQLTableDescription implements TableDescription {
    Hashtable fFieldList = null;

    public SQLTableDescription() {
        fFieldList = new Hashtable();
    }

    public FieldDescription getField(String fieldname) {
        return (FieldDescription) fFieldList.get(fieldname);
    }

    public void addField(FieldDescription aField) {
        fFieldList.put(aField.getName(), aField);
    }
}

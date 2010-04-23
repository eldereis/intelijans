/*
 * SQLFieldDescription.java
 *
 * Created on October 9, 2002, 11:41 AM
 */
package org.realtor.rets.persistence;


/**
 *
 * @author  tweber
 */
/**
 *  This inner class is taken directly from Bruce Toback's example class
 *  DMQLtoSQLTest.  Provides field definitions for the SQLTableDescription class.
 */
public class SQLFieldDescription
    implements org.realtor.rets.persistence.FieldDescription {
    protected String fFieldName;
    protected String fDataType;
    protected String fInterpretation;
    protected boolean fUpshiftFlag;
    protected String fSQLName;

    public SQLFieldDescription(String name, String dataType,
        String interpretation, boolean upshiftFlag, String sqlName) {
        fFieldName = name;
        fDataType = dataType;
        fInterpretation = interpretation;
        fUpshiftFlag = upshiftFlag;
        fSQLName = sqlName;
    }

    public String getName() {
        return fFieldName;
    }

    public String getDataType() {
        return fDataType;
    }

    public String getInterpretation() {
        return fInterpretation;
    }

    public boolean getUpshiftFlag() {
        return fUpshiftFlag;
    }

    public String getSQLName() {
        if (fSQLName == null) {
            return fFieldName;
        }

        return fSQLName;
    }
}

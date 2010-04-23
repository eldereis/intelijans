package org.realtor.rets.persistence;


// RETSMetadata
//
// A subset of the OPTC.COM RETS metadata package

/**
 * FieldDescription provides information about a field. Only enough
 * of the field is exposed here to allow parsing a DMQL query;
 * see the full package for an implementation of Field.
 */
public interface FieldDescription {
    /**
     * Returns the name of the field as seen by a RETS protocol client.
     */
    public abstract String getName();

    /**
     * Returns the field's data type as a string. The string must
     * be one of those specified in the RETS 1.0 specification,
     * Table 11-4.
     */
    public abstract String getDataType();

    /**
     * Returns the interpretation of the field as a string. The
     * string must be one of those specified in the RETS 1.0 specification,
     * Table 11-4.
     */
    public abstract String getInterpretation();

    /**
     * Returns a flag that states whether data values should be
     * upshifted for a search. This is not part of the RETS metadata
     * because it's a server implementation detail, but the server
     * library needs to know this in order to generate suitable
     * SQL.
     */
    public abstract boolean getUpshiftFlag();

    /**
     * Returns a string containing the name of the field as it appears
     * in the SQL database. Again, this is not part of the metadata, but
     * is required by the server library in order to generate correct
     * SQL. The implementation in the library simply returns the field
     * name by default.
     */
    public abstract String getSQLName();
}

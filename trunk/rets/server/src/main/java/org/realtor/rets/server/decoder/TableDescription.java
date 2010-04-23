package org.realtor.rets.server.decoder;


// RETSMetadata
//
// A subset of the OPTC.COM RETS metadata package

/**
 * TableDescription provides information about a RETS table. The
 * abbreviated interface for the test scaffolding only provides
 * a way to search for and retrieve fields.
 */
public interface TableDescription {
    /**
     * Retrieves an object that can provide information about a
     * named field.
     *
     * @param fieldName The RETS name of the field to be retrieved.
     *
     * @return An object implementing the FieldDescription interface
     *         that can provide information about the named field.
     */
    public abstract FieldDescription getField(String fieldname);
}

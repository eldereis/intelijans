package org.realtor.rets.database;

import org.realtor.rets.database.base.BaseProperties;

/**
 * This is the object class that relates to the properties table.
 * Any customizations belong here.
 */
public class Properties extends BaseProperties {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Properties () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Properties (java.lang.Long _oid) {
		super(_oid);
	}

/*[CONSTRUCTOR MARKER END]*/
}
package org.realtor.rets.database;

import org.realtor.rets.database.base.BaseOffices;

/**
 * This is the object class that relates to the offices table.
 * Any customizations belong here.
 */
public class Offices extends BaseOffices {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Offices () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Offices (java.lang.Long _oid) {
		super(_oid);
	}

/*[CONSTRUCTOR MARKER END]*/
}
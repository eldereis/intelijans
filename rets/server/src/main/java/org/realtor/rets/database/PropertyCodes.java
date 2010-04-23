package org.realtor.rets.database;

import org.realtor.rets.database.base.BasePropertyCodes;

/**
 * This is the object class that relates to the property_codes table.
 * Any customizations belong here.
 */
public class PropertyCodes extends BasePropertyCodes {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PropertyCodes () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PropertyCodes (org.realtor.rets.database.PropertyCodesPK _id) {
		super(_id);
	}

/*[CONSTRUCTOR MARKER END]*/
}
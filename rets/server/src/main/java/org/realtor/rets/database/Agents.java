package org.realtor.rets.database;

import org.realtor.rets.database.base.BaseAgents;

/**
 * This is the object class that relates to the agents table.
 * Any customizations belong here.
 */
public class Agents extends BaseAgents {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Agents () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Agents (java.lang.Long _oid) {
		super(_oid);
	}

/*[CONSTRUCTOR MARKER END]*/
}
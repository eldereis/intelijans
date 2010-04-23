// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/RETSBroker.java,v 1.1.1.1 2003/11/21 16:20:24 rsegelman Exp $
package org.realtor.rets.server;

import org.apache.log4j.*;


/**
 *        holder for information about a broker.
 *
 *        @author        jbrush
 *        @version 1.0
 */
public class RETSBroker {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSBroker.class);

    /** holds the branch code */
    public String code;

    /** holds the branch Name */
    public String branch;
}

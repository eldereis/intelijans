// $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/server/RETSResponseFactory.java,v 1.3 2005/03/10 14:47:03 ekovach Exp $
package org.realtor.rets.server;

import org.apache.log4j.Category;

import org.realtor.rets.util.PropertiesLocator;

import java.lang.reflect.Constructor;

import java.util.Map;
import java.util.Properties;
import java.util.*;



/**
 *        RETSResponseFactory
 *
 *
 *        @author        pobrien
 *        @version 1.0
 */
public class RETSResponseFactory {
    private static Properties prop = null;
    static Category cat = Category.getInstance(RETSResponseFactory.class);
    protected static final String SEARCHTYPE = "SearchType";

    /**
     *  Uses factory to generate appropriate instance of Response classes dependent on Client's RETS Server version and action
     *
     *  @param action RETS Client requested action
     *  @param version RETS Client version
     *  @param m Map object from servlet request object getParameter() method
     */
    public RETSResponseFactory() {
        // do nothing
    }

    public static void getProperties() {
        if (prop != null) {
            return;
        }

        try {
            prop = PropertiesLocator.locateProperties("RETSServer.properties");
        } catch (Exception e) {
            cat.error("Error loading file: RETSServer.properties", e);
        }
    }

    public static RETSResponse getResponse(String action, String retsVersion, Map m) {
        getProperties();


        StringTokenizer versionTokenizer = new StringTokenizer(retsVersion,
                "/");
        String version = null;

        while (versionTokenizer.hasMoreTokens()) {
            version = versionTokenizer.nextToken();
        }

        if ("search".equalsIgnoreCase(action)) {
            String[] searchType = (String[]) m.get(SEARCHTYPE);

            if (searchType != null) {
                cat.debug(SEARCHTYPE + "={" + searchType[0] + "}");
                action = searchType[0].trim() + action;
            } else {
                cat.error(SEARCHTYPE + " is missing.");
            }
        }

        String tranType = prop.getProperty(action.toUpperCase() + version);

        RETSResponse resp = null;

        try {
            Class c = Class.forName(tranType);
            Class[] conArgs = new Class[1];
            conArgs[0] = Map.class;

            Object[] conVals = new Object[1];
            conVals[0] = m;

            Constructor con = c.getConstructor(conArgs);
            resp = (RETSResponse) con.newInstance(conVals);
        } catch (Exception e) {
            cat.error("Error creating instance of class:" + tranType, e);
        }

        if (resp != null) {
            resp.setVersion(version);
            resp.setProp(prop);
        }

        return resp;
    }
}

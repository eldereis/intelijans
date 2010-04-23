/*
 * AttributeList.java
 *
 * Created on December 7, 2001, 4:05 PM
 */
package org.realtor.rets.server.decoder;

import java.util.Set;


/**
 * Simple interface implemented by objects that are made up of a list of
 * attributes.  getAttribute(attributeName) returns the string value of the
 * named attribute.
 *
 * @author  tweber
 * @version 1.0
 */
public interface AttributeList {
    String getAttribute(String attributeName);

    String getAttributeType(String attributeName);

    Set getAttributeKeys();
}

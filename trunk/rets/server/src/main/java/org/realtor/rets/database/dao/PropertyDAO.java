/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.Property;

/**
 * @author jthomas
 *
 */
public interface PropertyDAO {
    Property findByUid(String uid) throws PersistenceException;
    void saveOrUpdate(Property agent) throws PersistenceException;
}

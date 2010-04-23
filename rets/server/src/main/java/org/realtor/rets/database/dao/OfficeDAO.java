/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.Office;

/**
 * @author jthomas
 *
 */
public interface OfficeDAO {
    Office findByUid(String uid) throws PersistenceException;
    void saveOrUpdate(Office office) throws PersistenceException;
}

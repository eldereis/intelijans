/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.LotsAndLand;

/**
 * @author jthomas
 *
 */
public interface LotsAndLandDAO {
    LotsAndLand findByUid(String uid) throws PersistenceException;
    void saveOrUpdate(LotsAndLand lot) throws PersistenceException;
}

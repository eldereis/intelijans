/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.MobileHome;

/**
 * @author jthomas
 *
 */
public interface MobileHomeDAO {
    public MobileHome findByUid(String uid) throws PersistenceException;
    public void saveOrUpdate(MobileHome op) throws PersistenceException;
}

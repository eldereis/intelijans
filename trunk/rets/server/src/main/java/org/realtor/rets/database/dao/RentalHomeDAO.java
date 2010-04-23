/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.RentalHome;

/**
 * @author jthomas
 *
 */
public interface RentalHomeDAO {
    public RentalHome findByUid(String uid) throws PersistenceException;
    public void saveOrUpdate(RentalHome prop) throws PersistenceException;
}

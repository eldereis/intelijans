/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.CommercialProperty;

/**
 * @author jthomas
 *
 */
public interface CommercialPropertyDAO {
    public CommercialProperty findByUid(String uid) throws PersistenceException;
    public void saveOrUpdate(CommercialProperty op) throws PersistenceException;
}

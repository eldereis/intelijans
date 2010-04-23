/*
 * Created on Feb 16, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.ResidentialProperty;

/**
 * @author jthomas
 *
 */
public interface ResidentialPropertyDAO {
    public ResidentialProperty findByUid(String uid) throws PersistenceException;
    public ResidentialProperty findByMlsNumber(String mlsNumber) throws PersistenceException;
    public void saveOrUpdate(ResidentialProperty prop) throws PersistenceException;
}

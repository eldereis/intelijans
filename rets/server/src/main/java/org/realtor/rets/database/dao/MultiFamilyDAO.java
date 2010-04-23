/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.MultiFamily;

/**
 * @author jthomas
 *
 */
public interface MultiFamilyDAO {
    public MultiFamily findByUid(String uid) throws PersistenceException;
    public void saveOrUpdate(MultiFamily office) throws PersistenceException;
}

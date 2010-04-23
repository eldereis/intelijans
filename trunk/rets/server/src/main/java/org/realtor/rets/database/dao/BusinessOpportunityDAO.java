/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.BusinessOpportunity;

/**
 * @author jthomas
 *
 */
public interface BusinessOpportunityDAO {
    public BusinessOpportunity findByUid(String uid) throws PersistenceException;
    public void saveOrUpdate(BusinessOpportunity op) throws PersistenceException;
}

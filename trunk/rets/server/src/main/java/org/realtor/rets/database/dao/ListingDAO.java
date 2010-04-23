/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.Listing;

/**
 * @author jthomas
 *
 */
public interface ListingDAO {
    Listing findByUid(String uid) throws PersistenceException;
    void saveOrUpdate(Listing listing) throws PersistenceException;
}

/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.ListingDAO;
import org.realtor.rets.dataobjects.Listing;

/**
 * @author jthomas
 *
 */
public class HibernateListingDAO implements ListingDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateListingDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public Listing findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("uid", new Double(uid));
  		return (Listing) hibernateUtil.loadOne(Listing.class, crit);
    }

    public void saveOrUpdate(Listing listing) throws PersistenceException {
        hibernateUtil.saveOrUpdate(listing);
    }
}

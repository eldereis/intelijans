/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.RentalHomeDAO;
import org.realtor.rets.dataobjects.RentalHome;

/**
 * @author jthomas
 *
 */
public class HibernateRentalHomeDAO implements RentalHomeDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateRentalHomeDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public RentalHome findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (RentalHome) hibernateUtil.loadOne(RentalHome.class, crit);
    }

    public void saveOrUpdate(RentalHome prop) throws PersistenceException {
        if (prop.getOid() == -1) {
            hibernateUtil.save(prop);
        } else {
            hibernateUtil.update(prop);
        }
    }
}

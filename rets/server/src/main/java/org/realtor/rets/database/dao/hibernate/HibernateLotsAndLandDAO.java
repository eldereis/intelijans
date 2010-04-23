/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.LotsAndLandDAO;
import org.realtor.rets.dataobjects.LotsAndLand;

/**
 * @author jthomas
 *
 */
public class HibernateLotsAndLandDAO implements LotsAndLandDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateLotsAndLandDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public LotsAndLand findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (LotsAndLand) hibernateUtil.loadOne(LotsAndLand.class, crit);
    }

    public void saveOrUpdate(LotsAndLand lot) throws PersistenceException {
        if (lot.getOid() == -1) {
            hibernateUtil.save(lot);
        } else {
            hibernateUtil.update(lot);
        }
    }
}

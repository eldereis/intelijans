/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.BusinessOpportunityDAO;
import org.realtor.rets.dataobjects.BusinessOpportunity;

/**
 * @author jthomas
 *
 */
public class HibernateBusinessOpportunityDAO implements BusinessOpportunityDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateBusinessOpportunityDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public BusinessOpportunity findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (BusinessOpportunity) hibernateUtil.loadOne(BusinessOpportunity.class, crit);
    }

    public void saveOrUpdate(BusinessOpportunity op) throws PersistenceException {
        if (op.getOid() == -1) {
            hibernateUtil.save(op);
        } else {
            hibernateUtil.update(op);
        }
    }
}

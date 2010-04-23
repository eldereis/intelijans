/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.CommercialPropertyDAO;
import org.realtor.rets.dataobjects.CommercialProperty;

/**
 * @author jthomas
 *
 */
public class HibernateCommercialPropertyDAO implements CommercialPropertyDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateCommercialPropertyDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public CommercialProperty findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (CommercialProperty) hibernateUtil.loadOne(CommercialProperty.class, crit);
    }

    public void saveOrUpdate(CommercialProperty prop) throws PersistenceException {
        if (prop.getOid() == -1) {
            hibernateUtil.save(prop);
        } else {
            hibernateUtil.update(prop);
        }
    }
}

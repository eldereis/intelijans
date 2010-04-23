/*
 * Created on Feb 16, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.ResidentialPropertyDAO;
import org.realtor.rets.dataobjects.ResidentialProperty;

/**
 * @author jthomas
 *
 */
public class HibernateResidentialPropertyDAO implements ResidentialPropertyDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateResidentialPropertyDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }

    public ResidentialProperty findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (ResidentialProperty) hibernateUtil.loadOne(ResidentialProperty.class, crit);
    }

    public ResidentialProperty findByMlsNumber(String mlsNumber) throws PersistenceException {
  		Criterion crit = Expression.eq("mlsNumber", mlsNumber);
  		return (ResidentialProperty) hibernateUtil.loadOne(ResidentialProperty.class, crit);
    }
    
    public void saveOrUpdate(ResidentialProperty prop) throws PersistenceException {
        if (prop.getOid() == -1) {
            hibernateUtil.save(prop);
        } else {
            hibernateUtil.update(prop);
        }
    }
}

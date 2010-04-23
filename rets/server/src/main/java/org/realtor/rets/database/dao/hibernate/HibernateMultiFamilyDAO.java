/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.MultiFamilyDAO;
import org.realtor.rets.dataobjects.MultiFamily;

/**
 * @author jthomas
 *
 */
public class HibernateMultiFamilyDAO implements MultiFamilyDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateMultiFamilyDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public MultiFamily findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (MultiFamily) hibernateUtil.loadOne(MultiFamily.class, crit);
    }

    public void saveOrUpdate(MultiFamily multi) throws PersistenceException {
        if (multi.getOid() == -1) {
            hibernateUtil.save(multi);
        } else {
            hibernateUtil.update(multi);
        }
    }
}

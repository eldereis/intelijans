/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.MobileHomeDAO;
import org.realtor.rets.dataobjects.MobileHome;

/**
 * @author jthomas
 *
 */
public class HibernateMobileHomeDAO implements MobileHomeDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateMobileHomeDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public MobileHome findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (MobileHome) hibernateUtil.loadOne(MobileHome.class, crit);
    }

    public void saveOrUpdate(MobileHome home) throws PersistenceException {
        if (home.getOid() == -1) {
            hibernateUtil.save(home);
        } else {
            hibernateUtil.update(home);
        }
    }
}

/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.OfficeDAO;
import org.realtor.rets.dataobjects.Office;

/**
 * @author jthomas
 *
 */
public class HibernateOfficeDAO implements OfficeDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateOfficeDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public Office findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (Office) hibernateUtil.loadOne(Office.class, crit);
    }

    public void saveOrUpdate(Office office) throws PersistenceException {
        hibernateUtil.saveOrUpdate(office);
    }
}

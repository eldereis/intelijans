/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.PropertyDAO;
import org.realtor.rets.dataobjects.Property;

/**
 * @author jthomas
 *
 */
public class HibernatePropertyDAO implements PropertyDAO {
    HibernateUtil hibernateUtil;
    
    public HibernatePropertyDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public Property findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("UID", uid);
  		return (Property) hibernateUtil.loadOne(Property.class, crit);
    }

    public void saveOrUpdate(Property prop) throws PersistenceException {
        if (prop.getOid() == -1) {
            hibernateUtil.save(prop);
        } else {
            hibernateUtil.update(prop);
        }
    }
}

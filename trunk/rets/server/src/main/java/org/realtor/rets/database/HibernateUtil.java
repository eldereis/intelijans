package org.realtor.rets.database;

import java.io.Serializable;
import java.util.List;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;
import net.sf.hibernate.expression.Criterion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HibernateUtil {
    private Configuration configuration;

    private Log logger = LogFactory.getLog(HibernateUtil.class);
    private SessionFactory sessionFactory;

    public HibernateUtil() throws HibernateException {
        configuration = new Configuration();

        // let Hibernate bind it to JNDI:
        sessionFactory = configuration.configure().buildSessionFactory();
    }
    
    public HibernateUtil(String file) throws HibernateException {
        configuration = new Configuration();

        // let Hibernate bind it to JNDI:
        sessionFactory = configuration.configure(file).buildSessionFactory();
    }
    
    public void delete(Object o) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
            	if (session != null) {
            		session.close();
            	}
            } catch (Exception e) {
            	logger.error(e);
           	}
        }
    }

    public void delete(String o) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
            	if (session != null) {
            		session.close();
            	}
            } catch (Exception e) {
            	logger.error(e);
           	}
        }
    }

    public List find(String query) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            return session.find(query);
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
            	if (session != null) {
            		session.close();
            	}
            } catch (Exception e) {
            	logger.error(e);
            }
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public Session getSession()
        throws HibernateException {
        return sessionFactory.openSession();
    }

    public Object load(Class clazz, Serializable id) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            return session.load(clazz, id);
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }

    public List loadList(Class clazz, Criterion where) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Criteria crit = session.createCriteria(clazz);
            crit.add(where);
            return crit.list();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }


    public Object loadOne(Class clazz, Criterion where) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Criteria crit = session.createCriteria(clazz);
            crit.add(where);
            return crit.uniqueResult();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }

    public Object loadOne(Class clazz, Criterion crit1, Criterion crit2) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Criteria crit = session.createCriteria(clazz);
            crit.add(crit1);
            crit.add(crit2);
            return crit.uniqueResult();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }

    public void save(Object o) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            session.save(o);
            tx.commit();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }

    public void saveOrUpdate(Object o) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(o);
            tx.commit();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }

    public void update(Object o) throws PersistenceException {
        Session session = null;
        try {
            session = getSession();
            Transaction tx = session.beginTransaction();
            session.update(o);
            tx.commit();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (Exception e) {}
        }
    }
}

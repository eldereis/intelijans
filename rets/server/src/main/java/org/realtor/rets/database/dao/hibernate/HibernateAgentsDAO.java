/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.database.dao.hibernate;

import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.AgentsDAO;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.dataobjects.Office;
import org.realtor.rets.server.RETSServerApp;

/**
 * @author jthomas
 *
 */
public class HibernateAgentsDAO implements AgentsDAO {
    HibernateUtil hibernateUtil;
    
    public HibernateAgentsDAO(HibernateUtil hibUtil) {
        hibernateUtil = hibUtil;
    }
    
    public Agent findByUid(String uid) throws PersistenceException {
  		Criterion crit = Expression.eq("uid", uid);
  		return loadAgent(crit);
    }

    public void saveOrUpdate(Agent agent) throws PersistenceException {
        hibernateUtil.saveOrUpdate(agent);
    }

    public Agent findByUsername(String username) throws PersistenceException {
  		Criterion crit = Expression.eq("login", username);
  		return loadAgent(crit);
    }
    
    private Agent loadAgent(Criterion crit) throws PersistenceException {
		Agent agent = (Agent) hibernateUtil.loadOne(Agent.class, crit);
		Office agentOffice = RETSServerApp.getOfficeDAO().findByUid(agent.getUidOffice());
		agent.setOffice(agentOffice);
		return agent;
    }
}

/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.database.dao;

import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.dataobjects.Agent;

/**
 * @author jthomas
 *
 */
public interface AgentsDAO {
    Agent findByUid(String uid) throws PersistenceException;
    Agent findByUsername(String username) throws PersistenceException;
    void saveOrUpdate(Agent agent) throws PersistenceException;
}

/*
 * Created on Jan 27, 2005
 *
 */
package org.realtor.rets.server;

import java.util.HashMap;
import java.util.Iterator;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.mapping.Column;
import net.sf.hibernate.mapping.PersistentClass;
import net.sf.hibernate.mapping.Property;

import org.apache.log4j.Category;
import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.dao.AgentsDAO;
import org.realtor.rets.database.dao.BusinessOpportunityDAO;
import org.realtor.rets.database.dao.CommercialPropertyDAO;
import org.realtor.rets.database.dao.ListingDAO;
import org.realtor.rets.database.dao.LotsAndLandDAO;
import org.realtor.rets.database.dao.MobileHomeDAO;
import org.realtor.rets.database.dao.MultiFamilyDAO;
import org.realtor.rets.database.dao.OfficeDAO;
import org.realtor.rets.database.dao.PropertyDAO;
import org.realtor.rets.database.dao.RentalHomeDAO;
import org.realtor.rets.database.dao.ResidentialPropertyDAO;
import org.realtor.rets.database.dao.hibernate.HibernateAgentsDAO;
import org.realtor.rets.database.dao.hibernate.HibernateBusinessOpportunityDAO;
import org.realtor.rets.database.dao.hibernate.HibernateCommercialPropertyDAO;
import org.realtor.rets.database.dao.hibernate.HibernateListingDAO;
import org.realtor.rets.database.dao.hibernate.HibernateLotsAndLandDAO;
import org.realtor.rets.database.dao.hibernate.HibernateMobileHomeDAO;
import org.realtor.rets.database.dao.hibernate.HibernateMultiFamilyDAO;
import org.realtor.rets.database.dao.hibernate.HibernateOfficeDAO;
import org.realtor.rets.database.dao.hibernate.HibernatePropertyDAO;
import org.realtor.rets.database.dao.hibernate.HibernateRentalHomeDAO;
import org.realtor.rets.database.dao.hibernate.HibernateResidentialPropertyDAO;

/**
 * @author jthomas
 *
 */
public class RETSServerApp {
    /** log4j Category object */
    static Category cat = Category.getInstance(RETSServerApp.class);

    static HibernateUtil universalHibernateUtil = null;
    static {
	    try {
	    	cat.debug("Initializing HibernateUtil");
	        universalHibernateUtil = new HibernateUtil("/rets_universal.cfg.xml");
	    } catch (HibernateException e) {

	    	cat.debug("Error initializing HibernateUtil:" + e);
	        throw new ExceptionInInitializerError(e);
	    } catch (Throwable e) {

	    	cat.debug("Error initializing HibernateUtil:" + e);
	        throw new ExceptionInInitializerError(e);
	    }
    }
    static AgentsDAO agentsDAO = new HibernateAgentsDAO(universalHibernateUtil);
    static ListingDAO listingDAO = new HibernateListingDAO(universalHibernateUtil);
    static OfficeDAO officeDAO = new HibernateOfficeDAO(universalHibernateUtil);
    static PropertyDAO propertyDAO = new HibernatePropertyDAO(universalHibernateUtil);
    static BusinessOpportunityDAO businessOpportunityDAO = new HibernateBusinessOpportunityDAO(universalHibernateUtil);
    static CommercialPropertyDAO commercialPropertyDAO = new HibernateCommercialPropertyDAO(universalHibernateUtil);
    static LotsAndLandDAO lotsAndLandDAO = new HibernateLotsAndLandDAO(universalHibernateUtil);
    static MobileHomeDAO mobileHomeDAO = new HibernateMobileHomeDAO(universalHibernateUtil);
    static MultiFamilyDAO multiFamilyDAO = new HibernateMultiFamilyDAO(universalHibernateUtil);
    static RentalHomeDAO rentalHomeDAO = new HibernateRentalHomeDAO(universalHibernateUtil);
    static ResidentialPropertyDAO residentialPropertyDAO = new HibernateResidentialPropertyDAO(universalHibernateUtil);

    static public AgentsDAO getAgentsDAO() {
        return agentsDAO;
    }

    static public ListingDAO getListingDAO() {
        return listingDAO;
    }

    static public OfficeDAO getOfficeDAO() {
        return officeDAO;
    }

    static public PropertyDAO getPropertyDAO() {
        return propertyDAO;
    }

    static public BusinessOpportunityDAO getBusinessOpportunityDAO() {
        return businessOpportunityDAO;
    }

    static public CommercialPropertyDAO getCommercialPropertyDAO() {
        return commercialPropertyDAO;
    }

    static public LotsAndLandDAO getLotsAndLandDAO() {
        return lotsAndLandDAO;
    }

    static public MobileHomeDAO getMobileHomeDAO() {
        return mobileHomeDAO;
    }

    static public MultiFamilyDAO getMultiFamilyDAO() {
        return multiFamilyDAO;
    }

    static public RentalHomeDAO getRentalHomeDAO() {
        return rentalHomeDAO;
    }

    static public ResidentialPropertyDAO getResidentialPropertyDAO() {
        return residentialPropertyDAO;
    }

    static public Session getHibernateSession() throws HibernateException {
        return universalHibernateUtil.getSession();
    }

    /**
        Get a HashMap of column names to Hibernate names for the specified class.
        @param classToMap The Hibernate class for which to obtain the map.
        @return A HashMap of column names to Hibernate names for the specified class.
     */
    public static HashMap getClassToNameMap(Class classToMap) {
        HashMap attributeMap = new HashMap();
        PersistentClass pc = getHibernateUtil().getConfiguration().getClassMapping(classToMap);
        Iterator itr = pc.getPropertyIterator();
        while (itr.hasNext()) {
            Property p = (Property) itr.next();
            Iterator iterator = p.getValue().getColumnIterator();
            while (iterator.hasNext()) {
                Column column = (Column) iterator.next();
                attributeMap.put(column.getName(), p.getName());
            }
        }
        return attributeMap;
    }

    public static HibernateUtil getHibernateUtil() {
        return universalHibernateUtil;
    }
}

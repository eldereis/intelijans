/*
 * Created on Jan 20, 2005
 *
 */
package test.org.realtor.rets.database;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import net.sf.hibernate.expression.Criterion;
import net.sf.hibernate.expression.Expression;

import org.realtor.rets.database.HibernateUtil;
import org.realtor.rets.database.PersistenceException;
import org.realtor.rets.database.dao.BusinessOpportunityDAO;
import org.realtor.rets.database.dao.CommercialPropertyDAO;
import org.realtor.rets.database.dao.MobileHomeDAO;
import org.realtor.rets.database.dao.MultiFamilyDAO;
import org.realtor.rets.database.dao.PropertyDAO;
import org.realtor.rets.database.dao.RentalHomeDAO;
import org.realtor.rets.database.dao.ResidentialPropertyDAO;
import org.realtor.rets.dataobjects.Agent;
import org.realtor.rets.dataobjects.BusinessOpportunity;
import org.realtor.rets.dataobjects.CommercialProperty;
import org.realtor.rets.dataobjects.Listing;
import org.realtor.rets.dataobjects.MobileHome;
import org.realtor.rets.dataobjects.MultiFamily;
import org.realtor.rets.dataobjects.Office;
import org.realtor.rets.dataobjects.Property;
import org.realtor.rets.dataobjects.RentalHome;
import org.realtor.rets.dataobjects.ResidentialProperty;
import org.realtor.rets.server.RETSServerApp;

/**
 * @author jthomas
 *
 */
public class TestDAOs extends TestCase {
    HibernateUtil hibernateUtil;
    
    protected void setUp() throws Exception {
        hibernateUtil = new HibernateUtil();
    }
    
    public void testLoadListingByUID() throws Exception {
  		Criterion crit = Expression.eq("uid", new Double("12040480"));
  		Listing listing = (Listing) hibernateUtil.loadOne(Listing.class, crit);
        assertEquals(1.2056110, 1.20, 1.21);
    }

    public void testLoadListing() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        Listing listing = (Listing) hibernateUtil.load(Listing.class, new Long(1));
        assertTrue(listing.getOid() == 1.0);
        assertTrue(listing.getAcres() == 0.0);
        assertTrue(listing.getAmenities() == null || listing.getAmenities().trim().length() == 0);
        assertTrue(listing.getListingAgent().equals("254"));
        assertTrue(listing.getSellingAgent() == null);
        assertTrue(listing.getListingCompany() == null);
        assertTrue(listing.getSellingCompany() == null);
        assertTrue(listing.getArea() == 702.0);
        assertTrue(!listing.isAuction());
        assertTrue(listing.getFullBaths() == 2);
        assertTrue(listing.getHalfBaths() == 0);
        assertTrue(listing.getTotalBaths() == 2);
        assertTrue(listing.getBedrooms() == 3);
        assertTrue(listing.getCity().equals("MEDINA"));
        assertTrue(listing.getClosedBy() == null || listing.getClosedBy().trim().length() == 0);
        assertTrue(listing.getClosedDate() == null || dateFormat.format(listing.getClosedDate()).equals("0000-00-00"));
        assertTrue(listing.getComparableBuyPrice() == 2.5);
        assertTrue(listing.getComparableSellPrice() == 0.0);
        assertTrue(listing.getOtherCompensation().equals("N"));
        assertTrue(listing.getContingency() == null || listing.getContingency().trim().length() == 0);
        assertTrue(listing.getCoolingSystem().equals("\"3,Y\""));
        assertTrue(listing.getCounty().equals("MED"));
        assertTrue(listing.getDaysOnMarket() == 149);
        
        listing.setAcres(1.0f);
        hibernateUtil.update(listing);
        listing = (Listing) hibernateUtil.load(Listing.class, new Long(1));
        assertTrue(listing.getAcres() == 1.0);
        listing.setAcres(0.0);
        hibernateUtil.update(listing);
    }

    public void testLoadAgent() throws Exception {
        Agent agent = RETSServerApp.getAgentsDAO().findByUid("MDMS");
        assertTrue(agent.getAddress1().startsWith("100"));
        
        /*RetsAgentDAO agentDAO = new RetsAgentDAO("MDMS"); 
        assertTrue(agent.getFirstName().equals(agentDAO.getFirstName()));
        assertTrue(agent.getUid().equals(agentDAO.getID()));
        assertTrue(agent.getAgentCode().equals(agentDAO.getAgentCode()));
        assertTrue(agent.getMemberName().equals(agentDAO.getMemberName()));
        assertTrue(agent.getLevel().equals(agentDAO.getLevel()));
        assertTrue(agent.getUserClass().equals(agentDAO.getUserClass()));

        
        System.out.println(agent.getBrokerCode());
        System.out.println(agentDAO.getBrokerCode());
        System.out.println(agent.getBrokerBranch());
        System.out.println(agentDAO.getBrokerBranch());
        
        assertTrue(agent.getBrokerCode().equals(agentDAO.getBrokerCode()));
        assertTrue(agent.getBrokerBranch().equals(agentDAO.getBrokerBranch()));*/

    }

    public void testLoadOffice() throws Exception {
        Office office = (Office) hibernateUtil.load(Office.class, new Long(1));
        assertTrue(office.getOid() == 1.0);
    } 
    
    public void testLoadOfficeByUid() throws Exception {
		Criterion crit = Expression.eq("UID", "2004");
		Office office = (Office) hibernateUtil.loadOne(Office.class, crit);
        assertTrue(office.getUID().equals("2004"));
    } 
    
    public void testProperty() throws PersistenceException {
        PropertyDAO dao = RETSServerApp.getPropertyDAO();
        Property prop = new Property();
        dao.saveOrUpdate(prop);
    }
    
    public void testBusinessOpportunity() throws PersistenceException {
        BusinessOpportunityDAO dao = RETSServerApp.getBusinessOpportunityDAO();
        BusinessOpportunity op = new BusinessOpportunity();
        dao.saveOrUpdate(op);
    }
    
    public void testCommercialProperty() throws PersistenceException {
        CommercialPropertyDAO dao = RETSServerApp.getCommercialPropertyDAO();
        CommercialProperty op = new CommercialProperty();
        dao.saveOrUpdate(op);
    }
    
    public void testResidentialProperty() throws PersistenceException {
        ResidentialPropertyDAO dao = RETSServerApp.getResidentialPropertyDAO();
        ResidentialProperty op = new ResidentialProperty();
        dao.saveOrUpdate(op);
    }
    
    public void testMobileHome() throws PersistenceException {
        MobileHomeDAO dao = RETSServerApp.getMobileHomeDAO();
        MobileHome op = new MobileHome();
        dao.saveOrUpdate(op);
    }

    public void testMultiFamily() throws PersistenceException {
        MultiFamilyDAO dao = RETSServerApp.getMultiFamilyDAO();
        MultiFamily op = new MultiFamily();
        dao.saveOrUpdate(op);
    }

    public void testRentalHome() throws PersistenceException {
        RentalHomeDAO dao = RETSServerApp.getRentalHomeDAO();
        RentalHome op = new RentalHome();
        dao.saveOrUpdate(op);
    }
}

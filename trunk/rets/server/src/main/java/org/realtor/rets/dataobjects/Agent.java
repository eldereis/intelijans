/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/dataobjects/Agent.java,v 1.5 2005/03/18 15:26:01 ekovach Exp $ */
package org.realtor.rets.dataobjects;

import java.util.Date;
import java.util.Vector;

import org.realtor.rets.server.RETSBroker;


/**
 *  Agent.java Created Jul 18, 2003
 *
 * Copyright 2003, Avantia inc.
 * @author scohen
 */
public class Agent {
    // address info
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String zipExtension;

    //internet info
    private String email;
    private String webAddress;
    private String login;
    private String firstName;
    private String lastName;
    private String fullName;
    private String middleName;
    private String gender;
    private String homeFax;
    private String homePhone;
    private String licenseNumber;
    private String memberType;
    private String mobilePhone;
    private Date lastModified;
    private String onlineStatus;
    private String pagerNumber;
    private String title;
    private String preferredFaxNumber;
    private String preferredPhoneNumber;
    private String publicID;
    private String UID;
    private String uidOffice;
    private Vector listings;

    private String password;
    private long oid;
    
    private Office office;
    
    /**
     * @return Returns the oid.
     */
    public long getOid() {
        return oid;
    }
    /**
     * @param oid The oid to set.
     */
    public void setOid(long oid) {
        this.oid = oid;
    }
    public Agent() {
    }

    /**
     * @return
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @return
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return
     */
    public String getHomeFax() {
        return homeFax;
    }

    /**
     * @return
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * @return
     */
    public Date getLastModified() {
        return lastModified;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * @return
     */
    public String getMemberType() {
        return memberType;
    }

    /**
     * @return
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @return
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @return
     */
    public String getOnlineStatus() {
        return onlineStatus;
    }

    /**
     * @return
     */
    public String getPagerNumber() {
        return pagerNumber;
    }

    /**
     * @return
     */
    public String getPreferredFaxNumber() {
        return preferredFaxNumber;
    }

    /**
     * @return
     */
    public String getPreferredPhoneNumber() {
        return preferredPhoneNumber;
    }

    /**
     * @return
     */
    public String getPublicID() {
        return publicID;
    }

    /**
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return
     */
    public String getUID() {
        return UID;
    }

    /**
     * @return
     */
    public String getUidOffice() {
        return uidOffice;
    }

    /**
     * @return
     */
    public String getWebAddress() {
        return webAddress;
    }

    /**
     * @return
     */
    public String getZip() {
        return zip;
    }

    /**
     * @return
     */
    public String getZipExtension() {
        return zipExtension;
    }

    /**
     * @param string
     */
    public void setAddress1(String string) {
        address1 = string;
    }

    /**
     * @param string
     */
    public void setAddress2(String string) {
        address2 = string;
    }

    /**
     * @param string
     */
    public void setCity(String string) {
        city = string;
    }

    /**
     * @param string
     */
    public void setEmail(String string) {
        email = string;
    }

    /**
     * @param string
     */
    public void setFirstName(String string) {
        firstName = string;
    }

    /**
     * @param string
     */
    public void setFullName(String string) {
        fullName = string;
    }

    /**
     * @param string
     */
    public void setGender(String string) {
        gender = string;
    }

    /**
     * @param string
     */
    public void setHomeFax(String string) {
        homeFax = string;
    }

    /**
     * @param string
     */
    public void setHomePhone(String string) {
        homePhone = string;
    }

    /**
     * @param date
     */
    public void setLastModified(Date date) {
        lastModified = date;
    }

    /**
     * @param string
     */
    public void setLastName(String string) {
        lastName = string;
    }

    /**
     * @param string
     */
    public void setLicenseNumber(String string) {
        licenseNumber = string;
    }

    /**
     * @param string
     */
    public void setLogin(String string) {
        login = string;
    }

    /**
     * @param string
     */
    public void setMemberType(String string) {
        memberType = string;
    }

    /**
     * @param string
     */
    public void setMiddleName(String string) {
        middleName = string;
    }

    /**
     * @param string
     */
    public void setMobilePhone(String string) {
        mobilePhone = string;
    }

    /**
     * @param string
     */
    public void setOnlineStatus(String string) {
        onlineStatus = string;
    }

    /**
     * @param string
     */
    public void setPagerNumber(String string) {
        pagerNumber = string;
    }

    /**
     * @param string
     */
    public void setPreferredFaxNumber(String string) {
        preferredFaxNumber = string;
    }

    /**
     * @param string
     */
    public void setPreferredPhoneNumber(String string) {
        preferredPhoneNumber = string;
    }

    /**
     * @param string
     */
    public void setPublicID(String string) {
        publicID = string;
    }

    /**
     * @param string
     */
    public void setState(String string) {
        state = string;
    }

    /**
     * @param string
     */
    public void setTitle(String string) {
        title = string;
    }

    /**
     * @param string
     */
    public void setUID(String string) {
    	UID = string;
    }

    /**
     * @param string
     */
    public void setUidOffice(String string) {
        uidOffice = string;
    }

    /**
     * @param string
     */
    public void setWebAddress(String string) {
        webAddress = string;
    }

    /**
     * @param string
     */
    public void setZip(String string) {
        zip = string;
    }

    /**
     * @param string
     */
    public void setZipExtension(String string) {
        zipExtension = string;
    }

    /**
     * @return
     */
    public Vector getListings() {
        return listings;
    }

    /**
     * @param vector
     */
    public void setListings(Vector vector) {
        listings = vector;
    }
    /**
     * @return Returns the password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getID() {
        return getUID();
    }
    
    public String getAgentCode() {
        return getUID();
    }
    
    public String getMemberName() {
        return getFirstName() + " " + getLastName();
    }
    
    public String getLevel() {
        return "NULL";
    }

    public String getUserClass() {
        return "NULL";
    }
    
    public RETSBroker[] getBrokerList() {
        RETSBroker broker = new RETSBroker();
        broker.code = getBrokerCode();
        broker.branch = getBrokerBranch();

        return new RETSBroker[] { broker };
    }

    public String getBrokerCode() {
    	if (office == null) {
    		return null;
    	}
        return office.getUidCompany();
    }

    public String getBrokerBranch() {
    	if (office == null) {
    		return null;
    	}
        return office.getUID();
    }
    /**
     * @return Returns the office.
     */
    public Office getOffice() {
        return office;
    }
    /**
     * @param office The office to set.
     */
    public void setOffice(Office office) {
        this.office = office;
    }
}

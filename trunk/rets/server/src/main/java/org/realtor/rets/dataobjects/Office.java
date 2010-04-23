/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/dataobjects/Office.java,v 1.3 2005/02/09 18:54:37 jthomas Exp $
 *
 *
 */
package org.realtor.rets.dataobjects;

import java.util.Date;
import java.util.Vector;


/**
 *  Office.java Created Jul 18, 2003
 *
 * Copyright 2003, Avantia inc.
 * @author scohen
 */
public class Office {
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String faxNumber;
    private Date lastModified;
    private String officeMail;
    private String id;
    private String officeName;
    private String officeStatus;
    private String optinFlag;
    private String phone;
    private String UID;
    private String uidCompany;
    private String webAddress;
    private String zip;
    private String zipExtension;
    private Vector agents;
    private long oid;
    
    private Agent agent;
    
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
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * @return
     */
    public String getId() {
        return id;
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
    public String getOfficeMail() {
        return officeMail;
    }

    /**
     * @return
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * @return
     */
    public String getOfficeStatus() {
        return officeStatus;
    }

    /**
     * @return
     */
    public String getPhone() {
        return phone;
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
    public String getUID() {
        return UID;
    }

    /**
     * @return
     */
    public String getUidCompany() {
        return uidCompany;
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
    public void setFaxNumber(String string) {
        faxNumber = string;
    }

    /**
     * @param string
     */
    public void setId(String string) {
        id = string;
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
    public void setOfficeMail(String string) {
        officeMail = string;
    }

    /**
     * @param string
     */
    public void setOfficeName(String string) {
        officeName = string;
    }

    /**
     * @param string
     */
    public void setOfficeStatus(String string) {
        officeStatus = string;
    }

    /**
     * @param string
     */
    public void setPhone(String string) {
        phone = string;
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
    public void setUID(String string) {
        UID = string;
    }

    /**
     * @param string
     */
    public void setUidCompany(String string) {
        uidCompany = string;
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
    public String getOptinFlag() {
        return optinFlag;
    }

    /**
     * @param string
     */
    public void setOptinFlag(String string) {
        optinFlag = string;
    }

    /**
     * @return
     */
    public Vector getAgents() {
        return agents;
    }

    public void addAgent(Agent a) {
        if (agents == null) {
            agents = new Vector();
        }

        agents.add(a);
    }

    /**
     * @param vector
     */
    public void setAgents(Vector vector) {
        agents = vector;
    }
    /**
     * @return Returns the agent.
     */
    public Agent getAgent() {
        return agent;
    }
    /**
     * @param agent The agent to set.
     */
    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}

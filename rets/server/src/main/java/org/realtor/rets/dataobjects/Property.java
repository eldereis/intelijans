/*
 * Created on Feb 13, 2005
 *
 */
package org.realtor.rets.dataobjects;

import java.util.Date;

/**
 * @author jthomas
 *
 */
public class Property {
    private long oid = -1;
    
    private String mlsNumber;
    private int streetNumber;
    private String streetDirection;
    private String streetName;
    private String streetType;
    private String addressUnit;
    private String city;
    private int zipCode;
    private String county;
    private String board;
    private String exclusiveRight;
    private String thomasGuide;
    private String area;
    private String apn;
    private int blocksNorthSouth;
    private String directionNorthSouth;
    private String streetNameNorthSouth;
    private int blocksEastWest;
    private String directionEastWest;
    private String streetNameEastWest;
    private long listPrice;
    private long originalPrice;
    private Date listDate;
    private int daysOnMarket;
    private Date expirationDate;
    private String idxOk;
    private String publicRemarks;
    private String privateRemarks;
    private String listingOfficeFirmNumber;
    private String listingOfficePhone;
    private String listingOfficePhoneExtension;
    private String listingOfficeName;
    private String listingOfficeAddress;
    private String listingOfficeCity;
    private int listingOfficeZip;
    private String listingAgent1Name;
    private String listingAgent1Phone1;
    private String listingAgent1Phone1Type;
    private String listingAgent1Phone2;
    private long listingAgent1MemberNumber;
    private String agentEMailAddress;
    private String listingAgent2Name;
    private String listingAgent2Phone1;
    private String listingAgent2Phone1Type;
    private String listingAgent2Phone2;
    private long listingAgent2MemberNumber;
    private String status;
    private boolean active;
    private long salePrice;
    private Date saleDate;
    private Date coeDate;
    private String salesOfficeNumber;
    private String saleDownPayment;
    private String saleFinanceTypeCode;
    private String sellingAgentMemberNumber;
    private String saleTypeCode;
    private int pictures;
    private float sellingOfficeCommission;
    private String commissionType;
    private int assrSquareFeet;
    private long assrLotSquareFeet;
    private int assrYearBuilt;
    private String assrLotDimensions;
    private String assrZoning;
    private long assrApn;
    private int assrBathrooms;
    private int assrLastSalePrice;
    private int assrBedrooms;
    private Date assrLastSaleDate;
    private String assrLegalTractNumber;
    private boolean burbank;
    private boolean conejoValley;
    private boolean santaClaritaValley;
    private boolean sanFernandoValley;
    private boolean simiValleyMoorpark;
    private boolean vanNuys;
    private boolean outOfArea;
    private boolean ST_ACT;
    private boolean ST_BOM;
    private boolean ST_CAN;
    private boolean ST_CHG;
    private boolean ST_CHP;
    private boolean ST_CON;
    private boolean ST_CYB;
    private boolean ST_CYR;
    private boolean ST_EXP;
    private boolean ST_NEW;
    private boolean ST_PEN;
    private boolean ST_REI;
    private boolean ST_RFS;
    private boolean ST_SLD;
    private boolean ST_SHW;
    private boolean ST_OFF;
    private boolean ST_REL;
    private int latitude;
    private String listingAgent;
    private String listingFirm;
    private String sellingAgent;
    private String sellingFirm;
    
    /**
     * @return Returns the active.
     */
    public boolean isActive() {
        return active;
    }
    /**
     * @param active The active to set.
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    /**
     * @return Returns the addressUnit.
     */
    public String getAddressUnit() {
        return addressUnit;
    }
    /**
     * @param addressUnit The addressUnit to set.
     */
    public void setAddressUnit(String addressUnit) {
        this.addressUnit = addressUnit;
    }
    /**
     * @return Returns the agentEMailAddress.
     */
    public String getAgentEMailAddress() {
        return agentEMailAddress;
    }
    /**
     * @param agentEMailAddress The agentEMailAddress to set.
     */
    public void setAgentEMailAddress(String agentEMailAddress) {
        this.agentEMailAddress = agentEMailAddress;
    }
    /**
     * @return Returns the apn.
     */
    public String getApn() {
        return apn;
    }
    /**
     * @param apn The apn to set.
     */
    public void setApn(String apn) {
        this.apn = apn;
    }
    /**
     * @return Returns the area.
     */
    public String getArea() {
        return area;
    }
    /**
     * @param area The area to set.
     */
    public void setArea(String area) {
        this.area = area;
    }
    /**
     * @return Returns the assrApn.
     */
    public long getAssrApn() {
        return assrApn;
    }
    /**
     * @param assrApn The assrApn to set.
     */
    public void setAssrApn(long assrApn) {
        this.assrApn = assrApn;
    }
    /**
     * @return Returns the assrBathrooms.
     */
    public int getAssrBathrooms() {
        return assrBathrooms;
    }
    /**
     * @param assrBathrooms The assrBathrooms to set.
     */
    public void setAssrBathrooms(int assrBathrooms) {
        this.assrBathrooms = assrBathrooms;
    }
    /**
     * @return Returns the assrBedrooms.
     */
    public int getAssrBedrooms() {
        return assrBedrooms;
    }
    /**
     * @param assrBedrooms The assrBedrooms to set.
     */
    public void setAssrBedrooms(int assrBedrooms) {
        this.assrBedrooms = assrBedrooms;
    }
    /**
     * @return Returns the assrLastSaleDate.
     */
    public Date getAssrLastSaleDate() {
        return assrLastSaleDate;
    }
    /**
     * @param assrLastSaleDate The assrLastSaleDate to set.
     */
    public void setAssrLastSaleDate(Date assrLastSaleDate) {
        this.assrLastSaleDate = assrLastSaleDate;
    }
    /**
     * @return Returns the assrLastSalePrice.
     */
    public int getAssrLastSalePrice() {
        return assrLastSalePrice;
    }
    /**
     * @param assrLastSalePrice The assrLastSalePrice to set.
     */
    public void setAssrLastSalePrice(int assrLastSalePrice) {
        this.assrLastSalePrice = assrLastSalePrice;
    }
    /**
     * @return Returns the assrLegalTractNumber.
     */
    public String getAssrLegalTractNumber() {
        return assrLegalTractNumber;
    }
    /**
     * @param assrLegalTractNumber The assrLegalTractNumber to set.
     */
    public void setAssrLegalTractNumber(String assrLegalTractNumber) {
        this.assrLegalTractNumber = assrLegalTractNumber;
    }
    /**
     * @return Returns the assrLotDimensions.
     */
    public String getAssrLotDimensions() {
        return assrLotDimensions;
    }
    /**
     * @param assrLotDimensions The assrLotDimensions to set.
     */
    public void setAssrLotDimensions(String assrLotDimensions) {
        this.assrLotDimensions = assrLotDimensions;
    }
    /**
     * @return Returns the assrLotSquareFeet.
     */
    public long getAssrLotSquareFeet() {
        return assrLotSquareFeet;
    }
    /**
     * @param assrLotSquareFeet The assrLotSquareFeet to set.
     */
    public void setAssrLotSquareFeet(long assrLotSquareFeet) {
        this.assrLotSquareFeet = assrLotSquareFeet;
    }
    /**
     * @return Returns the assrSquareFeet.
     */
    public int getAssrSquareFeet() {
        return assrSquareFeet;
    }
    /**
     * @param assrSquareFeet The assrSquareFeet to set.
     */
    public void setAssrSquareFeet(int assrSquareFeet) {
        this.assrSquareFeet = assrSquareFeet;
    }
    /**
     * @return Returns the assrYearBuilt.
     */
    public int getAssrYearBuilt() {
        return assrYearBuilt;
    }
    /**
     * @param assrYearBuilt The assrYearBuilt to set.
     */
    public void setAssrYearBuilt(int assrYearBuilt) {
        this.assrYearBuilt = assrYearBuilt;
    }
    /**
     * @return Returns the assrZoning.
     */
    public String getAssrZoning() {
        return assrZoning;
    }
    /**
     * @param assrZoning The assrZoning to set.
     */
    public void setAssrZoning(String assrZoning) {
        this.assrZoning = assrZoning;
    }
    /**
     * @return Returns the blocksEastWest.
     */
    public int getBlocksEastWest() {
        return blocksEastWest;
    }
    /**
     * @param blocksEastWest The blocksEastWest to set.
     */
    public void setBlocksEastWest(int blocksEastWest) {
        this.blocksEastWest = blocksEastWest;
    }
    /**
     * @return Returns the blocksNorthSouth.
     */
    public int getBlocksNorthSouth() {
        return blocksNorthSouth;
    }
    /**
     * @param blocksNorthSouth The blocksNorthSouth to set.
     */
    public void setBlocksNorthSouth(int blocksNorthSouth) {
        this.blocksNorthSouth = blocksNorthSouth;
    }
    /**
     * @return Returns the board.
     */
    public String getBoard() {
        return board;
    }
    /**
     * @param board The board to set.
     */
    public void setBoard(String board) {
        this.board = board;
    }
    /**
     * @return Returns the burbank.
     */
    public boolean isBurbank() {
        return burbank;
    }
    /**
     * @param burbank The burbank to set.
     */
    public void setBurbank(boolean burbank) {
        this.burbank = burbank;
    }
    /**
     * @return Returns the city.
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city The city to set.
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return Returns the coeDate.
     */
    public Date getCoeDate() {
        return coeDate;
    }
    /**
     * @param coeDate The coeDate to set.
     */
    public void setCoeDate(Date coeDate) {
        this.coeDate = coeDate;
    }
    /**
     * @return Returns the commissionType.
     */
    public String getCommissionType() {
        return commissionType;
    }
    /**
     * @param commissionType The commissionType to set.
     */
    public void setCommissionType(String commissionType) {
        this.commissionType = commissionType;
    }
    /**
     * @return Returns the conejoValley.
     */
    public boolean isConejoValley() {
        return conejoValley;
    }
    /**
     * @param conejoValley The conejoValley to set.
     */
    public void setConejoValley(boolean conejoValley) {
        this.conejoValley = conejoValley;
    }
    /**
     * @return Returns the county.
     */
    public String getCounty() {
        return county;
    }
    /**
     * @param county The county to set.
     */
    public void setCounty(String county) {
        this.county = county;
    }
    /**
     * @return Returns the daysOnMarket.
     */
    public int getDaysOnMarket() {
        return daysOnMarket;
    }
    /**
     * @param daysOnMarket The daysOnMarket to set.
     */
    public void setDaysOnMarket(int daysOnMarket) {
        this.daysOnMarket = daysOnMarket;
    }
    /**
     * @return Returns the directionEastWest.
     */
    public String getDirectionEastWest() {
        return directionEastWest;
    }
    /**
     * @param directionEastWest The directionEastWest to set.
     */
    public void setDirectionEastWest(String directionEastWest) {
        this.directionEastWest = directionEastWest;
    }
    /**
     * @return Returns the directionNorthSouth.
     */
    public String getDirectionNorthSouth() {
        return directionNorthSouth;
    }
    /**
     * @param directionNorthSouth The directionNorthSouth to set.
     */
    public void setDirectionNorthSouth(String directionNorthSouth) {
        this.directionNorthSouth = directionNorthSouth;
    }
    /**
     * @return Returns the exclusiveRight.
     */
    public String getExclusiveRight() {
        return exclusiveRight;
    }
    /**
     * @param exclusiveRight The exclusiveRight to set.
     */
    public void setExclusiveRight(String exclusiveRight) {
        this.exclusiveRight = exclusiveRight;
    }
    /**
     * @return Returns the expirationDate.
     */
    public Date getExpirationDate() {
        return expirationDate;
    }
    /**
     * @param expirationDate The expirationDate to set.
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    /**
     * @return Returns the idxOk.
     */
    public String getIdxOk() {
        return idxOk;
    }
    /**
     * @param idxOk The idxOk to set.
     */
    public void setIdxOk(String idxOk) {
        this.idxOk = idxOk;
    }
    /**
     * @return Returns the latitude.
     */
    public int getLatitude() {
        return latitude;
    }
    /**
     * @param latitude The latitude to set.
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }
    /**
     * @return Returns the listDate.
     */
    public Date getListDate() {
        return listDate;
    }
    /**
     * @param listDate The listDate to set.
     */
    public void setListDate(Date listDate) {
        this.listDate = listDate;
    }
    /**
     * @return Returns the listingAgent.
     */
    public String getListingAgent() {
        return listingAgent;
    }
    /**
     * @param listingAgent The listingAgent to set.
     */
    public void setListingAgent(String listingAgent) {
        this.listingAgent = listingAgent;
    }
    /**
     * @return Returns the listingAgent1MemberNumber.
     */
    public long getListingAgent1MemberNumber() {
        return listingAgent1MemberNumber;
    }
    /**
     * @param listingAgent1MemberNumber The listingAgent1MemberNumber to set.
     */
    public void setListingAgent1MemberNumber(long listingAgent1MemberNumber) {
        this.listingAgent1MemberNumber = listingAgent1MemberNumber;
    }
    /**
     * @return Returns the listingAgent1Name.
     */
    public String getListingAgent1Name() {
        return listingAgent1Name;
    }
    /**
     * @param listingAgent1Name The listingAgent1Name to set.
     */
    public void setListingAgent1Name(String listingAgent1Name) {
        this.listingAgent1Name = listingAgent1Name;
    }
    /**
     * @return Returns the listingAgent1Phone1.
     */
    public String getListingAgent1Phone1() {
        return listingAgent1Phone1;
    }
    /**
     * @param listingAgent1Phone1 The listingAgent1Phone1 to set.
     */
    public void setListingAgent1Phone1(String listingAgent1Phone1) {
        this.listingAgent1Phone1 = listingAgent1Phone1;
    }
    /**
     * @return Returns the listingAgent1Phone1Type.
     */
    public String getListingAgent1Phone1Type() {
        return listingAgent1Phone1Type;
    }
    /**
     * @param listingAgent1Phone1Type The listingAgent1Phone1Type to set.
     */
    public void setListingAgent1Phone1Type(String listingAgent1Phone1Type) {
        this.listingAgent1Phone1Type = listingAgent1Phone1Type;
    }
    /**
     * @return Returns the listingAgent1Phone2.
     */
    public String getListingAgent1Phone2() {
        return listingAgent1Phone2;
    }
    /**
     * @param listingAgent1Phone2 The listingAgent1Phone2 to set.
     */
    public void setListingAgent1Phone2(String listingAgent1Phone2) {
        this.listingAgent1Phone2 = listingAgent1Phone2;
    }
    /**
     * @return Returns the listingAgent2MemberNumber.
     */
    public long getListingAgent2MemberNumber() {
        return listingAgent2MemberNumber;
    }
    /**
     * @param listingAgent2MemberNumber The listingAgent2MemberNumber to set.
     */
    public void setListingAgent2MemberNumber(long listingAgent2MemberNumber) {
        this.listingAgent2MemberNumber = listingAgent2MemberNumber;
    }
    /**
     * @return Returns the listingAgent2Name.
     */
    public String getListingAgent2Name() {
        return listingAgent2Name;
    }
    /**
     * @param listingAgent2Name The listingAgent2Name to set.
     */
    public void setListingAgent2Name(String listingAgent2Name) {
        this.listingAgent2Name = listingAgent2Name;
    }
    /**
     * @return Returns the listingAgent2Phone1.
     */
    public String getListingAgent2Phone1() {
        return listingAgent2Phone1;
    }
    /**
     * @param listingAgent2Phone1 The listingAgent2Phone1 to set.
     */
    public void setListingAgent2Phone1(String listingAgent2Phone1) {
        this.listingAgent2Phone1 = listingAgent2Phone1;
    }
    /**
     * @return Returns the listingAgent2Phone1Type.
     */
    public String getListingAgent2Phone1Type() {
        return listingAgent2Phone1Type;
    }
    /**
     * @param listingAgent2Phone1Type The listingAgent2Phone1Type to set.
     */
    public void setListingAgent2Phone1Type(String listingAgent2Phone1Type) {
        this.listingAgent2Phone1Type = listingAgent2Phone1Type;
    }
    /**
     * @return Returns the listingAgent2Phone2.
     */
    public String getListingAgent2Phone2() {
        return listingAgent2Phone2;
    }
    /**
     * @param listingAgent2Phone2 The listingAgent2Phone2 to set.
     */
    public void setListingAgent2Phone2(String listingAgent2Phone2) {
        this.listingAgent2Phone2 = listingAgent2Phone2;
    }
    /**
     * @return Returns the listingFirm.
     */
    public String getListingFirm() {
        return listingFirm;
    }
    /**
     * @param listingFirm The listingFirm to set.
     */
    public void setListingFirm(String listingFirm) {
        this.listingFirm = listingFirm;
    }
    /**
     * @return Returns the listingOfficeAddress.
     */
    public String getListingOfficeAddress() {
        return listingOfficeAddress;
    }
    /**
     * @param listingOfficeAddress The listingOfficeAddress to set.
     */
    public void setListingOfficeAddress(String listingOfficeAddress) {
        this.listingOfficeAddress = listingOfficeAddress;
    }
    /**
     * @return Returns the listingOfficeCity.
     */
    public String getListingOfficeCity() {
        return listingOfficeCity;
    }
    /**
     * @param listingOfficeCity The listingOfficeCity to set.
     */
    public void setListingOfficeCity(String listingOfficeCity) {
        this.listingOfficeCity = listingOfficeCity;
    }
    /**
     * @return Returns the listingOfficeFirmNumber.
     */
    public String getListingOfficeFirmNumber() {
        return listingOfficeFirmNumber;
    }
    /**
     * @param listingOfficeFirmNumber The listingOfficeFirmNumber to set.
     */
    public void setListingOfficeFirmNumber(String listingOfficeFirmNumber) {
        this.listingOfficeFirmNumber = listingOfficeFirmNumber;
    }
    /**
     * @return Returns the listingOfficeName.
     */
    public String getListingOfficeName() {
        return listingOfficeName;
    }
    /**
     * @param listingOfficeName The listingOfficeName to set.
     */
    public void setListingOfficeName(String listingOfficeName) {
        this.listingOfficeName = listingOfficeName;
    }
    /**
     * @return Returns the listingOfficePhone.
     */
    public String getListingOfficePhone() {
        return listingOfficePhone;
    }
    /**
     * @param listingOfficePhone The listingOfficePhone to set.
     */
    public void setListingOfficePhone(String listingOfficePhone) {
        this.listingOfficePhone = listingOfficePhone;
    }
    /**
     * @return Returns the listingOfficePhoneExtension.
     */
    public String getListingOfficePhoneExtension() {
        return listingOfficePhoneExtension;
    }
    /**
     * @param listingOfficePhoneExtension The listingOfficePhoneExtension to set.
     */
    public void setListingOfficePhoneExtension(
            String listingOfficePhoneExtension) {
        this.listingOfficePhoneExtension = listingOfficePhoneExtension;
    }
    /**
     * @return Returns the listingOfficeZip.
     */
    public int getListingOfficeZip() {
        return listingOfficeZip;
    }
    /**
     * @param listingOfficeZip The listingOfficeZip to set.
     */
    public void setListingOfficeZip(int listingOfficeZip) {
        this.listingOfficeZip = listingOfficeZip;
    }
    /**
     * @return Returns the listPrice.
     */
    public long getListPrice() {
        return listPrice;
    }
    /**
     * @param listPrice The listPrice to set.
     */
    public void setListPrice(long listPrice) {
        this.listPrice = listPrice;
    }
    /**
     * @return Returns the mlsNumber.
     */
    public String getMlsNumber() {
        return mlsNumber;
    }
    /**
     * @param mlsNumber The mlsNumber to set.
     */
    public void setMlsNumber(String mlsNumber) {
        this.mlsNumber = mlsNumber;
    }
    /**
     * @return Returns the originalPrice.
     */
    public long getOriginalPrice() {
        return originalPrice;
    }
    /**
     * @param originalPrice The originalPrice to set.
     */
    public void setOriginalPrice(long originalPrice) {
        this.originalPrice = originalPrice;
    }
    /**
     * @return Returns the outOfArea.
     */
    public boolean isOutOfArea() {
        return outOfArea;
    }
    /**
     * @param outOfArea The outOfArea to set.
     */
    public void setOutOfArea(boolean outOfArea) {
        this.outOfArea = outOfArea;
    }
    /**
     * @return Returns the pictures.
     */
    public int getPictures() {
        return pictures;
    }
    /**
     * @param pictures The pictures to set.
     */
    public void setPictures(int pictures) {
        this.pictures = pictures;
    }
    /**
     * @return Returns the privateRemarks.
     */
    public String getPrivateRemarks() {
        return privateRemarks;
    }
    /**
     * @param privateRemarks The privateRemarks to set.
     */
    public void setPrivateRemarks(String privateRemarks) {
        this.privateRemarks = privateRemarks;
    }
    /**
     * @return Returns the publicRemarks.
     */
    public String getPublicRemarks() {
        return publicRemarks;
    }
    /**
     * @param publicRemarks The publicRemarks to set.
     */
    public void setPublicRemarks(String publicRemarks) {
        this.publicRemarks = publicRemarks;
    }
    /**
     * @return Returns the saleDate.
     */
    public Date getSaleDate() {
        return saleDate;
    }
    /**
     * @param saleDate The saleDate to set.
     */
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
    /**
     * @return Returns the saleDownPayment.
     */
    public String getSaleDownPayment() {
        return saleDownPayment;
    }
    /**
     * @param saleDownPayment The saleDownPayment to set.
     */
    public void setSaleDownPayment(String saleDownPayment) {
        this.saleDownPayment = saleDownPayment;
    }
    /**
     * @return Returns the saleFinanceTypeCode.
     */
    public String getSaleFinanceTypeCode() {
        return saleFinanceTypeCode;
    }
    /**
     * @param saleFinanceTypeCode The saleFinanceTypeCode to set.
     */
    public void setSaleFinanceTypeCode(String saleFinanceTypeCode) {
        this.saleFinanceTypeCode = saleFinanceTypeCode;
    }
    /**
     * @return Returns the salePrice.
     */
    public long getSalePrice() {
        return salePrice;
    }
    /**
     * @param salePrice The salePrice to set.
     */
    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }
    /**
     * @return Returns the salesOfficeNumber.
     */
    public String getSalesOfficeNumber() {
        return salesOfficeNumber;
    }
    /**
     * @param salesOfficeNumber The salesOfficeNumber to set.
     */
    public void setSalesOfficeNumber(String salesOfficeNumber) {
        this.salesOfficeNumber = salesOfficeNumber;
    }
    /**
     * @return Returns the saleTypeCode.
     */
    public String getSaleTypeCode() {
        return saleTypeCode;
    }
    /**
     * @param saleTypeCode The saleTypeCode to set.
     */
    public void setSaleTypeCode(String saleTypeCode) {
        this.saleTypeCode = saleTypeCode;
    }
    /**
     * @return Returns the sanFernandoValley.
     */
    public boolean isSanFernandoValley() {
        return sanFernandoValley;
    }
    /**
     * @param sanFernandoValley The sanFernandoValley to set.
     */
    public void setSanFernandoValley(boolean sanFernandoValley) {
        this.sanFernandoValley = sanFernandoValley;
    }
    /**
     * @return Returns the santaClaritaValley.
     */
    public boolean isSantaClaritaValley() {
        return santaClaritaValley;
    }
    /**
     * @param santaClaritaValley The santaClaritaValley to set.
     */
    public void setSantaClaritaValley(boolean santaClaritaValley) {
        this.santaClaritaValley = santaClaritaValley;
    }
    /**
     * @return Returns the sellingAgent.
     */
    public String getSellingAgent() {
        return sellingAgent;
    }
    /**
     * @param sellingAgent The sellingAgent to set.
     */
    public void setSellingAgent(String sellingAgent) {
        this.sellingAgent = sellingAgent;
    }
    /**
     * @return Returns the sellingAgentMemberNumber.
     */
    public String getSellingAgentMemberNumber() {
        return sellingAgentMemberNumber;
    }
    /**
     * @param sellingAgentMemberNumber The sellingAgentMemberNumber to set.
     */
    public void setSellingAgentMemberNumber(String sellingAgentMemberNumber) {
        this.sellingAgentMemberNumber = sellingAgentMemberNumber;
    }
    /**
     * @return Returns the sellingFirm.
     */
    public String getSellingFirm() {
        return sellingFirm;
    }
    /**
     * @param sellingFirm The sellingFirm to set.
     */
    public void setSellingFirm(String sellingFirm) {
        this.sellingFirm = sellingFirm;
    }
    /**
     * @return Returns the sellingOfficeCommission.
     */
    public float getSellingOfficeCommission() {
        return sellingOfficeCommission;
    }
    /**
     * @param sellingOfficeCommission The sellingOfficeCommission to set.
     */
    public void setSellingOfficeCommission(float sellingOfficeCommission) {
        this.sellingOfficeCommission = sellingOfficeCommission;
    }
    /**
     * @return Returns the simiValleyMoorpark.
     */
    public boolean isSimiValleyMoorpark() {
        return simiValleyMoorpark;
    }
    /**
     * @param simiValleyMoorpark The simiValleyMoorpark to set.
     */
    public void setSimiValleyMoorpark(boolean simiValleyMoorpark) {
        this.simiValleyMoorpark = simiValleyMoorpark;
    }
    /**
     * @return Returns the sT_ACT.
     */
    public boolean isST_ACT() {
        return ST_ACT;
    }
    /**
     * @param st_act The sT_ACT to set.
     */
    public void setST_ACT(boolean st_act) {
        ST_ACT = st_act;
    }
    /**
     * @return Returns the sT_BOM.
     */
    public boolean isST_BOM() {
        return ST_BOM;
    }
    /**
     * @param st_bom The sT_BOM to set.
     */
    public void setST_BOM(boolean st_bom) {
        ST_BOM = st_bom;
    }
    /**
     * @return Returns the sT_CAN.
     */
    public boolean isST_CAN() {
        return ST_CAN;
    }
    /**
     * @param st_can The sT_CAN to set.
     */
    public void setST_CAN(boolean st_can) {
        ST_CAN = st_can;
    }
    /**
     * @return Returns the sT_CHG.
     */
    public boolean isST_CHG() {
        return ST_CHG;
    }
    /**
     * @param st_chg The sT_CHG to set.
     */
    public void setST_CHG(boolean st_chg) {
        ST_CHG = st_chg;
    }
    /**
     * @return Returns the sT_CHP.
     */
    public boolean isST_CHP() {
        return ST_CHP;
    }
    /**
     * @param st_chp The sT_CHP to set.
     */
    public void setST_CHP(boolean st_chp) {
        ST_CHP = st_chp;
    }
    /**
     * @return Returns the sT_CON.
     */
    public boolean isST_CON() {
        return ST_CON;
    }
    /**
     * @param st_con The sT_CON to set.
     */
    public void setST_CON(boolean st_con) {
        ST_CON = st_con;
    }
    /**
     * @return Returns the sT_CYB.
     */
    public boolean isST_CYB() {
        return ST_CYB;
    }
    /**
     * @param st_cyb The sT_CYB to set.
     */
    public void setST_CYB(boolean st_cyb) {
        ST_CYB = st_cyb;
    }
    /**
     * @return Returns the sT_CYR.
     */
    public boolean isST_CYR() {
        return ST_CYR;
    }
    /**
     * @param st_cyr The sT_CYR to set.
     */
    public void setST_CYR(boolean st_cyr) {
        ST_CYR = st_cyr;
    }
    /**
     * @return Returns the sT_EXP.
     */
    public boolean isST_EXP() {
        return ST_EXP;
    }
    /**
     * @param st_exp The sT_EXP to set.
     */
    public void setST_EXP(boolean st_exp) {
        ST_EXP = st_exp;
    }
    /**
     * @return Returns the sT_NEW.
     */
    public boolean isST_NEW() {
        return ST_NEW;
    }
    /**
     * @param st_new The sT_NEW to set.
     */
    public void setST_NEW(boolean st_new) {
        ST_NEW = st_new;
    }
    /**
     * @return Returns the sT_OFF.
     */
    public boolean isST_OFF() {
        return ST_OFF;
    }
    /**
     * @param st_off The sT_OFF to set.
     */
    public void setST_OFF(boolean st_off) {
        ST_OFF = st_off;
    }
    /**
     * @return Returns the sT_PEN.
     */
    public boolean isST_PEN() {
        return ST_PEN;
    }
    /**
     * @param st_pen The sT_PEN to set.
     */
    public void setST_PEN(boolean st_pen) {
        ST_PEN = st_pen;
    }
    /**
     * @return Returns the sT_REI.
     */
    public boolean isST_REI() {
        return ST_REI;
    }
    /**
     * @param st_rei The sT_REI to set.
     */
    public void setST_REI(boolean st_rei) {
        ST_REI = st_rei;
    }
    /**
     * @return Returns the sT_REL.
     */
    public boolean isST_REL() {
        return ST_REL;
    }
    /**
     * @param st_rel The sT_REL to set.
     */
    public void setST_REL(boolean st_rel) {
        ST_REL = st_rel;
    }
    /**
     * @return Returns the sT_RFS.
     */
    public boolean isST_RFS() {
        return ST_RFS;
    }
    /**
     * @param st_rfs The sT_RFS to set.
     */
    public void setST_RFS(boolean st_rfs) {
        ST_RFS = st_rfs;
    }
    /**
     * @return Returns the sT_SHW.
     */
    public boolean isST_SHW() {
        return ST_SHW;
    }
    /**
     * @param st_shw The sT_SHW to set.
     */
    public void setST_SHW(boolean st_shw) {
        ST_SHW = st_shw;
    }
    /**
     * @return Returns the sT_SLD.
     */
    public boolean isST_SLD() {
        return ST_SLD;
    }
    /**
     * @param st_sld The sT_SLD to set.
     */
    public void setST_SLD(boolean st_sld) {
        ST_SLD = st_sld;
    }
    /**
     * @return Returns the status.
     */
    public String getStatus() {
        return status;
    }
    /**
     * @param status The status to set.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * @return Returns the streetDirection.
     */
    public String getStreetDirection() {
        return streetDirection;
    }
    /**
     * @param streetDirection The streetDirection to set.
     */
    public void setStreetDirection(String streetDirection) {
        this.streetDirection = streetDirection;
    }
    /**
     * @return Returns the streetName.
     */
    public String getStreetName() {
        return streetName;
    }
    /**
     * @param streetName The streetName to set.
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    /**
     * @return Returns the streetNameEastWest.
     */
    public String getStreetNameEastWest() {
        return streetNameEastWest;
    }
    /**
     * @param streetNameEastWest The streetNameEastWest to set.
     */
    public void setStreetNameEastWest(String streetNameEastWest) {
        this.streetNameEastWest = streetNameEastWest;
    }
    /**
     * @return Returns the streetNameNorthSouth.
     */
    public String getStreetNameNorthSouth() {
        return streetNameNorthSouth;
    }
    /**
     * @param streetNameNorthSouth The streetNameNorthSouth to set.
     */
    public void setStreetNameNorthSouth(String streetNameNorthSouth) {
        this.streetNameNorthSouth = streetNameNorthSouth;
    }
    /**
     * @return Returns the streetNumber.
     */
    public int getStreetNumber() {
        return streetNumber;
    }
    /**
     * @param streetNumber The streetNumber to set.
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }
    /**
     * @return Returns the streetType.
     */
    public String getStreetType() {
        return streetType;
    }
    /**
     * @param streetType The streetType to set.
     */
    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }
    /**
     * @return Returns the thomasGuide.
     */
    public String getThomasGuide() {
        return thomasGuide;
    }
    /**
     * @param thomasGuide The thomasGuide to set.
     */
    public void setThomasGuide(String thomasGuide) {
        this.thomasGuide = thomasGuide;
    }
    /**
     * @return Returns the vanNuys.
     */
    public boolean isVanNuys() {
        return vanNuys;
    }
    /**
     * @param vanNuys The vanNuys to set.
     */
    public void setVanNuys(boolean vanNuys) {
        this.vanNuys = vanNuys;
    }
    /**
     * @return Returns the zipCode.
     */
    public int getZipCode() {
        return zipCode;
    }
    /**
     * @param zipCode The zipCode to set.
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
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
}

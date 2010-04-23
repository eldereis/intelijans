/* $Header: /usr/local/cvsroot/rets/server/src/main/java/org/realtor/rets/dataobjects/Listing.java,v 1.3 2005/02/09 18:54:37 jthomas Exp $
 *
 *
 */
package org.realtor.rets.dataobjects;

import java.util.Date;

/**
 * RealEstateProperty.java Created Jul 18, 2003
 * 
 * Copyright 2003, Avantia inc.
 * 
 * @author scohen
 */
public class Listing {
    private String acceptableFinances;

    private double acres;

    private String amenities;

    private String appliances;

    private double area;

    private double associateFee;

    private String associateFeePaid;

    private boolean auction;

    private String basement;

    private String bedroomFiveDescription;

    private String bedroomFiveDimensions;

    private String bedroomFiveLevel;

    private String bedroomFourDescription;

    private String bedroomFourDimensions;

    private String bedroomFourLevel;

    private int bedrooms;

    private String bedroomThreeDescription;

    private String bedroomThreeDimensions;

    private String bedroomThreeLevel;

    private String bedroomTwoDescription;

    private String bedroomTwoDimensions;

    private String bedroomTwoLevel;

    private String city;

    private String closedBy;

    private Date closedDate;

    private double comparableBuyPrice;

    private double comparableSellPrice;

    private String contingency;

    private String coolingSystem;

    private String county;

    private int coveredParking;

    private int daysOnMarket;

    private String denDescription;

    private String denDimensions;

    private String denLevel;

    private String diningRoomDescription;

    private String diningRoomDimensions;

    private String diningRoomLevel;

    private String directions;

    private String displaySchoolDistrict;

    private String displayStreetNumber;

    private Date expireDate;

    private String exterior;

    private String familyRoomDescription;

    private String familyRoomDimensions;

    private String familyRoomLevel;

    private String fence;

    private String financeCode;

    private int finishedSquareFeet;

    private String fireplaces;

    private String floorNumberUnit;

    private int frontageFeet;

    private int fullBaths;

    private String garageDescription;

    private int halfBaths;

    private boolean handicapAccessible;

    private String heatingSystem;

    private String heatSource;

    private String highSchool;

    private String homeOwnersAssociation;

    private boolean internetListing;

    private String kitchenDescription;

    private String kitchenDimensions;

    private String kitchenLevel;

    private Date lastModified;

    private double latitude;

    private String listingAgent;

    private String listingCompany;

    private Date listingDate;

    private Date listingDateReceived;

    private String listingOffice;

    private double listingPrice;

    private String listStatus;

    private String listType;

    private String livingRoomDescription;

    private String livingRoomDimensions;

    private String livingRoomLevel;

    private String lockBoxDescription;

    private double longitude;

    private String lotDescription;

    private String lotDimensions;

    private String lotNumber;

    private String lotRent;

    private double maintenanceFee;

    private String maintenanceFeeIncludes;

    private String map;

    private String mapCounty;

    private int mapPage;

    private String masterBedroomDescription;

    private String masterBedroomDimensions;

    private String masterBedroomLevel;

    private String mlsCrossReference;

    private String mlsNumber;

    private String mlsNumber_CRIS;

    private String mlsType;

    private double monthlyGas;

    private double monthlyWater;

    private double montlyElectric;

    private String multiplePin;

    private String newConstruction;

    private int numberOfFloors;

    private String occupied;

    private Date offMarketDate;

    private long oid;

    private double originalListPrice;

    private String otherCompensation;

    private String otherRoom;

    private String otherRoom1Description;

    private String otherRoom1Dimensions;

    private String otherRoom1Level;

    private String otherRoom1Name;

    private String otherRoom2Description;

    private String otherRoom2Dimensions;

    private String otherRoom2Level;

    private String otherRoom2Name;

    private String otherRoom3Description;

    private String otherRoom3Dimensions;

    private String otherRoom3Level;

    private String otherRoom3Name;

    private String ownerAgent;

    private Date pendingDate;

    private String photoCode;

    private int photoCount;

    private Date photoDate;

    private String photoInstructions;

    private String posession;

    private String propertySubtype;

    private String prototype;

    private String publicTransportation;

    private String realRemarks;

    private int recreationFee;

    private String remarks;

    private String restrictions;

    private String roof;

    private int rooms;

    private double salesPrice;

    private String schoolDistrict;

    private int sellerPoints;

    private String sellingAgent;

    private String sellingCompany;

    private String sellingOffice;

    private String showingInstructions;

    private String siding;

    private String squareFootSource;

    private String state;

    private int stories;

    private String streetDirectional;

    private String streetName;

    private String streetNumber;

    private String style;

    private String subdivision;

    private double taxAmount;

    private String taxParcel;

    private Date tempOffMarketDate;

    private int totalBaths;

    private double totalSquareFeet;

    private double uid;

    private int unfinishedSquareFeet;

    private String viewDescription;

    private String warranty;

    private String water;

    private Date withdrawnDate;

    private int yearBuilt;

    private int zip;

    private int zipExtension;

    private String zoning;

    public Listing() {
    }

    /**
     * @param string
     */
    public void addAppliance(String string) {
        appliances = string;
    }

    /**
     * @return
     */
    public String getAcceptableFinances() {
        return acceptableFinances;
    }

    /**
     * @return
     */
    public double getAcres() {
        return acres;
    }

    /**
     * @return Returns the amenities.
     */
    public String getAmenities() {
        return amenities;
    }

    /**
     * @return
     */
    public String getAppliances() {
        return appliances;
    }

    /**
     * @return
     */
    public double getArea() {
        return area;
    }

    /**
     * @return
     */
    public double getAssociateFee() {
        return associateFee;
    }

    /**
     * @return
     */
    public String getAssociateFeePaid() {
        return associateFeePaid;
    }

    /**
     * @return
     */
    public String getBasement() {
        return basement;
    }

    /**
     * @return
     */
    public String getBedroomFiveDescription() {
        return bedroomFiveDescription;
    }

    /**
     * @return
     */
    public String getBedroomFiveDimensions() {
        return bedroomFiveDimensions;
    }

    /**
     * @return
     */
    public String getBedroomFiveLevel() {
        return bedroomFiveLevel;
    }

    /**
     * @return
     */
    public String getBedroomFourDescription() {
        return bedroomFourDescription;
    }

    /**
     * @return
     */
    public String getBedroomFourDimensions() {
        return bedroomFourDimensions;
    }

    /**
     * @return
     */
    public String getBedroomFourLevel() {
        return bedroomFourLevel;
    }

    /**
     * @return
     */
    public int getBedrooms() {
        return bedrooms;
    }

    /**
     * @return
     */
    public String getBedroomThreeDescription() {
        return bedroomThreeDescription;
    }

    /**
     * @return
     */
    public String getBedroomThreeDimensions() {
        return bedroomThreeDimensions;
    }

    /**
     * @return
     */
    public String getBedroomThreeLevel() {
        return bedroomThreeLevel;
    }

    /**
     * @return
     */
    public String getBedroomTwoDescription() {
        return bedroomTwoDescription;
    }

    /**
     * @return
     */
    public String getBedroomTwoDimensions() {
        return bedroomTwoDimensions;
    }

    /**
     * @return
     */
    public String getBedroomTwoLevel() {
        return bedroomTwoLevel;
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
    public String getClosedBy() {
        return closedBy;
    }

    /**
     * @return
     */
    public Date getClosedDate() {
        return closedDate;
    }

    /**
     * @return
     */
    public double getComparableBuyPrice() {
        return comparableBuyPrice;
    }

    /**
     * @return
     */
    public double getComparableSellPrice() {
        return comparableSellPrice;
    }

    /**
     * @return
     */
    public String getContingency() {
        return contingency;
    }

    /**
     * @return
     */
    public String getCoolingSystem() {
        return coolingSystem;
    }

    /**
     * @return
     */
    public String getCounty() {
        return county;
    }

    /**
     * @return
     */
    public int getCoveredParking() {
        return coveredParking;
    }

    /**
     * @return
     */
    public int getDaysOnMarket() {
        return daysOnMarket;
    }

    /**
     * @return
     */
    public String getDenDescription() {
        return denDescription;
    }

    /**
     * @return
     */
    public String getDenDimensions() {
        return denDimensions;
    }

    /**
     * @return
     */
    public String getDenLevel() {
        return denLevel;
    }

    /**
     * @return
     */
    public String getDiningRoomDescription() {
        return diningRoomDescription;
    }

    /**
     * @return
     */
    public String getDiningRoomDimensions() {
        return diningRoomDimensions;
    }

    /**
     * @return
     */
    public String getDiningRoomLevel() {
        return diningRoomLevel;
    }

    /**
     * @return
     */
    public String getDirections() {
        return directions;
    }

    /**
     * @return
     */
    public String getDisplaySchoolDistrict() {
        return displaySchoolDistrict;
    }

    /**
     * @return
     */
    public String getDisplayStreetNumber() {
        return displayStreetNumber;
    }

    /**
     * @return
     */
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * Returns exterior features of this lising. These might include porches,
     * decks or pools.
     * 
     * @return
     */
    public String getExterior() {
        return exterior;
    }

    /**
     * @return
     */
    public String getFamilyRoomDescription() {
        return familyRoomDescription;
    }

    /**
     * @return
     */
    public String getFamilyRoomDimensions() {
        return familyRoomDimensions;
    }

    /**
     * @return
     */
    public String getFamilyRoomLevel() {
        return familyRoomLevel;
    }

    /**
     * @return
     */
    public String getFence() {
        return fence;
    }

    /**
     * @return
     */
    public String getFinanceCode() {
        return financeCode;
    }

    /**
     * @return
     */
    public int getFinishedSquareFeet() {
        return finishedSquareFeet;
    }

    /**
     * @return
     */
    public String getFireplaces() {
        return fireplaces;
    }

    /**
     * @return
     */
    public String getFloorNumberUnit() {
        return floorNumberUnit;
    }

    /**
     * @return
     */
    public int getFrontageFeet() {
        return frontageFeet;
    }

    /**
     * @return
     */
    public int getFullBaths() {
        return fullBaths;
    }

    /**
     * @return
     */
    public String getGarageDescription() {
        return garageDescription;
    }

    /**
     * @return
     */
    public int getHalfBaths() {
        return halfBaths;
    }

    /**
     * @return
     */
    public String getHeatingSystem() {
        return heatingSystem;
    }

    /**
     * @return
     */
    public String getHeatSource() {
        return heatSource;
    }

    /**
     * @return
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * @return
     */
    public String getHomeOwnersAssociation() {
        return homeOwnersAssociation;
    }

    /**
     * @return
     */
    public String getKitchenDescription() {
        return kitchenDescription;
    }

    /**
     * @return
     */
    public String getKitchenDimensions() {
        return kitchenDimensions;
    }

    /**
     * @return
     */
    public String getKitchenLevel() {
        return kitchenLevel;
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
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return
     */
    public String getListingAgent() {
        return listingAgent;
    }

    /**
     * @return
     */
    public String getListingCompany() {
        return listingCompany;
    }

    /**
     * @return
     */
    public Date getListingDate() {
        return listingDate;
    }

    /**
     * @return
     */
    public Date getListingDateReceived() {
        return listingDateReceived;
    }

    /**
     * @return
     */
    public String getListingOffice() {
        return listingOffice;
    }

    /**
     * @return
     */
    public double getListingPrice() {
        return listingPrice;
    }

    /**
     * @return
     */
    public String getListStatus() {
        return listStatus;
    }

    /**
     * @return
     */
    public String getListType() {
        return listType;
    }

    /**
     * @return
     */
    public String getLivingRoomDescription() {
        return livingRoomDescription;
    }

    /**
     * @return
     */
    public String getLivingRoomDimensions() {
        return livingRoomDimensions;
    }

    /**
     * @return
     */
    public String getLivingRoomLevel() {
        return livingRoomLevel;
    }

    /**
     * @return
     */
    public String getLockBoxDescription() {
        return lockBoxDescription;
    }

    /**
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return
     */
    public String getLotDescription() {
        return lotDescription;
    }

    /**
     * @return
     */
    public String getLotDimensions() {
        return lotDimensions;
    }

    /**
     * @return
     */
    public String getLotNumber() {
        return lotNumber;
    }

    /**
     * @return
     */
    public String getLotRent() {
        return lotRent;
    }

    /**
     * @return
     */
    public double getMaintenanceFee() {
        return maintenanceFee;
    }

    /**
     * @return
     */
    public String getMaintenanceFeeIncludes() {
        return maintenanceFeeIncludes;
    }

    /**
     * @return
     */
    public String getMap() {
        return map;
    }

    /**
     * @return
     */
    public String getMapCounty() {
        return mapCounty;
    }

    /**
     * @return
     */
    public int getMapPage() {
        return mapPage;
    }

    /**
     * @return
     */
    public String getMasterBedroomDescription() {
        return masterBedroomDescription;
    }

    /**
     * @return
     */
    public String getMasterBedroomDimensions() {
        return masterBedroomDimensions;
    }

    /**
     * @return
     */
    public String getMasterBedroomLevel() {
        return masterBedroomLevel;
    }

    /**
     * @return
     */
    public String getMlsCrossReference() {
        return mlsCrossReference;
    }

    /**
     * @return
     */
    public String getMlsNumber() {
        return mlsNumber;
    }

    /**
     * @return
     */
    public String getMlsNumber_CRIS() {
        return mlsNumber_CRIS;
    }

    /**
     * @return
     */
    public String getMlsType() {
        return mlsType;
    }

    /**
     * @return
     */
    public double getMonthlyGas() {
        return monthlyGas;
    }

    /**
     * @return
     */
    public double getMonthlyWater() {
        return monthlyWater;
    }

    /**
     * @return
     */
    public double getMontlyElectric() {
        return montlyElectric;
    }

    /**
     * @return
     */
    public String getMultiplePin() {
        return multiplePin;
    }

    /**
     * @return
     */
    public String getNewConstruction() {
        return newConstruction;
    }

    /**
     * @return
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * @return
     */
    public String getOccupied() {
        return occupied;
    }

    /**
     * @return
     */
    public Date getOffMarketDate() {
        return offMarketDate;
    }

    /**
     * @return Returns the oid.
     */
    public long getOid() {
        return oid;
    }

    /**
     * @return
     */
    public double getOriginalListPrice() {
        return originalListPrice;
    }

    /**
     * @return Returns the otherCompensation.
     */
    public String getOtherCompensation() {
        return otherCompensation;
    }

    /**
     * @return
     */
    public String getOtherRoom() {
        return otherRoom;
    }

    /**
     * @return
     */
    public String getOtherRoom1Description() {
        return otherRoom1Description;
    }

    /**
     * @return
     */
    public String getOtherRoom1Dimensions() {
        return otherRoom1Dimensions;
    }

    /**
     * @return
     */
    public String getOtherRoom1Level() {
        return otherRoom1Level;
    }

    /**
     * @return
     */
    public String getOtherRoom1Name() {
        return otherRoom1Name;
    }

    /**
     * @return
     */
    public String getOtherRoom2Description() {
        return otherRoom2Description;
    }

    /**
     * @return
     */
    public String getOtherRoom2Dimensions() {
        return otherRoom2Dimensions;
    }

    /**
     * @return
     */
    public String getOtherRoom2Level() {
        return otherRoom2Level;
    }

    /**
     * @return
     */
    public String getOtherRoom2Name() {
        return otherRoom2Name;
    }

    /**
     * @return
     */
    public String getOtherRoom3Description() {
        return otherRoom3Description;
    }

    /**
     * @return
     */
    public String getOtherRoom3Dimensions() {
        return otherRoom3Dimensions;
    }

    /**
     * @return
     */
    public String getOtherRoom3Level() {
        return otherRoom3Level;
    }

    /**
     * @return
     */
    public String getOtherRoom3Name() {
        return otherRoom3Name;
    }

    /**
     * @return
     */
    public String getOwnerAgent() {
        return ownerAgent;
    }

    /**
     * @return
     */
    public Date getPendingDate() {
        return pendingDate;
    }

    /**
     * @return
     */
    public String getPhotoCode() {
        return photoCode;
    }

    /**
     * @return
     */
    public int getPhotoCount() {
        return photoCount;
    }

    /**
     * @return
     */
    public Date getPhotoDate() {
        return photoDate;
    }

    /**
     * @return
     */
    public String getPhotoInstructions() {
        return photoInstructions;
    }

    /**
     * @return
     */
    public String getPosession() {
        return posession;
    }

    /**
     * @return
     */
    public String getPropertySubtype() {
        return propertySubtype;
    }

    /**
     * @return
     */
    public String getPrototype() {
        return prototype;
    }

    /**
     * @return
     */
    public String getPublicTransportation() {
        return publicTransportation;
    }

    /**
     * @return
     */
    public String getRealRemarks() {
        return realRemarks;
    }

    /**
     * @return
     */
    public int getRecreationFee() {
        return recreationFee;
    }

    /**
     * @return
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @return
     */
    public String getRestrictions() {
        return restrictions;
    }

    /**
     * @return
     */
    public String getRoof() {
        return roof;
    }

    /**
     * @return
     */
    public int getRooms() {
        return rooms;
    }

    /**
     * @return
     */
    public double getSalesPrice() {
        return salesPrice;
    }

    /**
     * @return
     */
    public String getSchoolDistrict() {
        return schoolDistrict;
    }

    /**
     * @return
     */
    public int getSellerPoints() {
        return sellerPoints;
    }

    /**
     * @return
     */
    public String getSellingAgent() {
        return sellingAgent;
    }

    /**
     * @return
     */
    public String getSellingCompany() {
        return sellingCompany;
    }

    /**
     * @return
     */
    public String getSellingOffice() {
        return sellingOffice;
    }

    /**
     * @return
     */
    public String getShowingInstructions() {
        return showingInstructions;
    }

    /**
     * @return
     */
    public String getSiding() {
        return siding;
    }

    /**
     * @return
     */
    public String getSquareFootSource() {
        return squareFootSource;
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
    public int getStories() {
        return stories;
    }

    /**
     * @return
     */
    public String getStreetDirectional() {
        return streetDirectional;
    }

    /**
     * @return
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * @return
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * @return
     */
    public String getStyle() {
        return style;
    }

    /**
     * @return
     */
    public String getSubdivision() {
        return subdivision;
    }

    /**
     * @return
     */
    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     * @return
     */
    public String getTaxParcel() {
        return taxParcel;
    }

    /**
     * @return
     */
    public Date getTempOffMarketDate() {
        return tempOffMarketDate;
    }

    /**
     * @return
     */
    public int getTotalBaths() {
        return totalBaths;
    }

    /**
     * @return
     */
    public double getTotalSquareFeet() {
        return totalSquareFeet;
    }

    /**
     * @return
     */
    public double getUid() {
        return uid;
    }

    /**
     * @return
     */
    public int getUnfinishedSquareFeet() {
        return unfinishedSquareFeet;
    }

    /**
     * @return
     */
    public String getViewDescription() {
        return viewDescription;
    }

    /**
     * @return
     */
    public String getWarranty() {
        return warranty;
    }

    /**
     * @return
     */
    public String getWater() {
        return water;
    }

    /**
     * @return
     */
    public Date getWithdrawnDate() {
        return withdrawnDate;
    }

    /**
     * @return
     */
    public int getYearBuilt() {
        return yearBuilt;
    }

    /**
     * @return
     */
    public int getZip() {
        return zip;
    }

    /**
     * @return
     */
    public int getZipExtension() {
        return zipExtension;
    }

    /**
     * @return
     */
    public String getZoning() {
        return zoning;
    }

    /**
     * @return
     */
    public boolean isAuction() {
        return auction;
    }

    /**
     * @return
     */
    public boolean isHandicapAccessible() {
        return handicapAccessible;
    }

    /**
     * @return
     */
    public boolean isInternetListing() {
        return internetListing;
    }

    /**
     * @param string
     */
    public void setAcceptableFinances(String string) {
        acceptableFinances = string;
    }

    /**
     * @param d
     */
    public void setAcres(double d) {
        acres = d;
    }

    /**
     * @param amenities
     *            The amenities to set.
     */
    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    /**
     * @param appliances
     *            The appliances to set.
     */
    public void setAppliances(String appliances) {
        this.appliances = appliances;
    }

    /**
     * @param d
     */
    public void setArea(double d) {
        area = d;
    }

    /**
     * @param l
     */
    public void setAssociateFee(double l) {
        associateFee = l;
    }

    /**
     * @param string
     */
    public void setAssociateFeePaid(String string) {
        associateFeePaid = string;
    }

    /**
     * @param b
     */
    public void setAuction(boolean b) {
        auction = b;
    }

    /**
     * @param string
     */
    public void setBasement(String string) {
        basement = string;
    }

    /**
     * @param bedroomFiveDescription
     *            The bedroomFiveDescription to set.
     */
    public void setBedroomFiveDescription(String bedroomFiveDescription) {
        this.bedroomFiveDescription = bedroomFiveDescription;
    }

    /**
     * @param string
     */
    public void setBedroomFiveDimensions(String string) {
        bedroomFiveDimensions = string;
    }

    /**
     * @param string
     */
    public void setBedroomFiveLevel(String string) {
        bedroomFiveLevel = string;
    }

    /**
     * @param bedroomFourDescription
     *            The bedroomFourDescription to set.
     */
    public void setBedroomFourDescription(String bedroomFourDescription) {
        this.bedroomFourDescription = bedroomFourDescription;
    }

    /**
     * @param string
     */
    public void setBedroomFourDimensions(String string) {
        bedroomFourDimensions = string;
    }

    /**
     * @param string
     */
    public void setBedroomFourLevel(String string) {
        bedroomFourLevel = string;
    }

    /**
     * @param i
     */
    public void setBedrooms(int i) {
        bedrooms = i;
    }

    /**
     * @param bedroomThreeDescription
     *            The bedroomThreeDescription to set.
     */
    public void setBedroomThreeDescription(String bedroomThreeDescription) {
        this.bedroomThreeDescription = bedroomThreeDescription;
    }

    /**
     * @param string
     */
    public void setBedroomThreeDimensions(String string) {
        bedroomThreeDimensions = string;
    }

    /**
     * @param string
     */
    public void setBedroomThreeLevel(String string) {
        bedroomThreeLevel = string;
    }

    /**
     * @param bedroomTwoDescription
     *            The bedroomTwoDescription to set.
     */
    public void setBedroomTwoDescription(String bedroomTwoDescription) {
        this.bedroomTwoDescription = bedroomTwoDescription;
    }

    /**
     * @param string
     */
    public void setBedroomTwoDimensions(String string) {
        bedroomTwoDimensions = string;
    }

    /**
     * @param string
     */
    public void setBedroomTwoLevel(String string) {
        bedroomTwoLevel = string;
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
    public void setClosedBy(String string) {
        closedBy = string;
    }

    /**
     * @param date
     */
    public void setClosedDate(Date date) {
        closedDate = date;
    }

    /**
     * @param l
     */
    public void setComparableBuyPrice(double l) {
        comparableBuyPrice = l;
    }

    /**
     * @param l
     */
    public void setComparableSellPrice(double l) {
        comparableSellPrice = l;
    }

    /**
     * @param string
     */
    public void setContingency(String string) {
        contingency = string;
    }

    /**
     * @param string
     */
    public void setCoolingSystem(String string) {
        coolingSystem = string;
    }

    /**
     * @param string
     */
    public void setCounty(String string) {
        county = string;
    }

    /**
     * @param i
     */
    public void setCoveredParking(int i) {
        coveredParking = i;
    }

    /**
     * @param i
     */
    public void setDaysOnMarket(int i) {
        daysOnMarket = i;
    }

    /**
     * @param denDescription
     *            The denDescription to set.
     */
    public void setDenDescription(String denDescription) {
        this.denDescription = denDescription;
    }

    /**
     * @param string
     */
    public void setDenDimensions(String string) {
        denDimensions = string;
    }

    /**
     * @param string
     */
    public void setDenLevel(String string) {
        denLevel = string;
    }

    /**
     * @param diningRoomDescription
     *            The diningRoomDescription to set.
     */
    public void setDiningRoomDescription(String diningRoomDescription) {
        this.diningRoomDescription = diningRoomDescription;
    }

    /**
     * @param string
     */
    public void setDiningRoomDimensions(String string) {
        diningRoomDimensions = string;
    }

    /**
     * @param string
     */
    public void setDiningRoomLevel(String string) {
        diningRoomLevel = string;
    }

    /**
     * @param string
     */
    public void setDirections(String string) {
        directions = string;
    }

    /**
     * @param string
     */
    public void setDisplaySchoolDistrict(String string) {
        displaySchoolDistrict = string;
    }

    /**
     * @param string
     */
    public void setDisplayStreetNumber(String string) {
        displayStreetNumber = string;
    }

    /**
     * @param date
     */
    public void setExpireDate(Date date) {
        expireDate = date;
    }

    /**
     * @param exterior
     *            The exterior to set.
     */
    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    /**
     * @param familyRoomDescription
     *            The familyRoomDescription to set.
     */
    public void setFamilyRoomDescription(String familyRoomDescription) {
        this.familyRoomDescription = familyRoomDescription;
    }

    /**
     * @param string
     */
    public void setFamilyRoomDimensions(String string) {
        familyRoomDimensions = string;
    }

    /**
     * @param string
     */
    public void setFamilyRoomLevel(String string) {
        familyRoomLevel = string;
    }

    /**
     * @param b
     */
    public void setFence(String f) {
        fence = f;
    }

    /**
     * @param string
     */
    public void setFinanceCode(String string) {
        financeCode = string;
    }

    /**
     * @param i
     */
    public void setFinishedSquareFeet(int i) {
        finishedSquareFeet = i;
    }

    /**
     * @param string
     */
    public void setFireplaces(String string) {
        fireplaces = string;
    }

    /**
     * @param string
     */
    public void setFloorNumberUnit(String string) {
        floorNumberUnit = string;
    }

    /**
     * @param i
     */
    public void setFrontageFeet(int i) {
        frontageFeet = i;
    }

    /**
     * @param i
     */
    public void setFullBaths(int i) {
        fullBaths = i;
    }

    /**
     * @param garageDescription
     *            The garageDescription to set.
     */
    public void setGarageDescription(String garageDescription) {
        this.garageDescription = garageDescription;
    }

    /**
     * @param i
     */
    public void setHalfBaths(int i) {
        halfBaths = i;
    }

    /**
     * @param b
     */
    public void setHandicapAccessible(boolean b) {
        handicapAccessible = b;
    }

    /**
     * @param heatingSystem
     *            The heatingSystem to set.
     */
    public void setHeatingSystem(String heatingSystem) {
        this.heatingSystem = heatingSystem;
    }

    /**
     * @param string
     */
    public void setHeatSource(String string) {
        heatSource = string;
    }

    /**
     * @param string
     */
    public void setHighSchool(String string) {
        highSchool = string;
    }

    /**
     * @param string
     */
    public void setHomeOwnersAssociation(String string) {
        homeOwnersAssociation = string;
    }

    /**
     * @param b
     */
    public void setInternetListing(boolean b) {
        internetListing = b;
    }

    /**
     * @param kitchenDescription
     *            The kitchenDescription to set.
     */
    public void setKitchenDescription(String kitchenDescription) {
        this.kitchenDescription = kitchenDescription;
    }

    /**
     * @param string
     */
    public void setKitchenDimensions(String string) {
        kitchenDimensions = string;
    }

    /**
     * @param string
     */
    public void setKitchenLevel(String string) {
        kitchenLevel = string;
    }

    /**
     * @param date
     */
    public void setLastModified(Date date) {
        lastModified = date;
    }

    /**
     * @param l
     */
    public void setLatitude(double l) {
        latitude = l;
    }

    /**
     * @param string
     */
    public void setListingAgent(String string) {
        listingAgent = string;
    }

    /**
     * @param string
     */
    public void setListingCompany(String string) {
        listingCompany = string;
    }

    /**
     * @param date
     */
    public void setListingDate(Date date) {
        listingDate = date;
    }

    /**
     * @param date
     */
    public void setListingDateReceived(Date date) {
        listingDateReceived = date;
    }

    /**
     * @param string
     */
    public void setListingOffice(String string) {
        listingOffice = string;
    }

    /**
     * @param l
     */
    public void setListingPrice(double l) {
        listingPrice = l;
    }

    /**
     * @param string
     */
    public void setListStatus(String string) {
        listStatus = string;
    }

    /**
     * @param string
     */
    public void setListType(String string) {
        listType = string;
    }

    /**
     * @param livingRoomDescription
     *            The livingRoomDescription to set.
     */
    public void setLivingRoomDescription(String livingRoomDescription) {
        this.livingRoomDescription = livingRoomDescription;
    }

    /**
     * @param string
     */
    public void setLivingRoomDimensions(String string) {
        livingRoomDimensions = string;
    }

    /**
     * @param string
     */
    public void setLivingRoomLevel(String string) {
        livingRoomLevel = string;
    }

    /**
     * @param string
     */
    public void setLockBoxDescription(String string) {
        lockBoxDescription = string;
    }

    /**
     * @param l
     */
    public void setLongitude(double l) {
        longitude = l;
    }

    /**
     * @param string
     */
    public void setLotDescription(String string) {
        lotDescription = string;
    }

    /**
     * @param string
     */
    public void setLotDimensions(String string) {
        lotDimensions = string;
    }

    /**
     * @param string
     */
    public void setLotNumber(String string) {
        lotNumber = string;
    }

    /**
     * @param string
     */
    public void setLotRent(String string) {
        lotRent = string;
    }

    /**
     * @param l
     */
    public void setMaintenanceFee(double l) {
        maintenanceFee = l;
    }

    /**
     * @param string
     */
    public void setMaintenanceFeeIncludes(String string) {
        maintenanceFeeIncludes = string;
    }

    /**
     * @param string
     */
    public void setMap(String string) {
        map = string;
    }

    /**
     * @param string
     */
    public void setMapCounty(String string) {
        mapCounty = string;
    }

    /**
     * @param i
     */
    public void setMapPage(int i) {
        mapPage = i;
    }

    /**
     * @param masterBedroomDescription
     *            The masterBedroomDescription to set.
     */
    public void setMasterBedroomDescription(String masterBedroomDescription) {
        this.masterBedroomDescription = masterBedroomDescription;
    }

    /**
     * @param string
     */
    public void setMasterBedroomDimensions(String string) {
        masterBedroomDimensions = string;
    }

    /**
     * @param string
     */
    public void setMasterBedroomLevel(String string) {
        masterBedroomLevel = string;
    }

    /**
     * @param string
     */
    public void setMlsCrossReference(String string) {
        mlsCrossReference = string;
    }

    /**
     * @param string
     */
    public void setMlsNumber(String string) {
        mlsNumber = string;
    }

    /**
     * @param string
     */
    public void setMlsNumber_CRIS(String string) {
        mlsNumber_CRIS = string;
    }

    /**
     * @param string
     */
    public void setMlsType(String string) {
        mlsType = string;
    }

    /**
     * @param l
     */
    public void setMonthlyGas(double l) {
        monthlyGas = l;
    }

    /**
     * @param l
     */
    public void setMonthlyWater(double l) {
        monthlyWater = l;
    }

    /**
     * @param l
     */
    public void setMontlyElectric(double l) {
        montlyElectric = l;
    }

    /**
     * @param string
     */
    public void setMultiplePin(String string) {
        multiplePin = string;
    }

    /**
     * @param string
     */
    public void setNewConstruction(String string) {
        newConstruction = string;
    }

    /**
     * @param i
     */
    public void setNumberOfFloors(int i) {
        numberOfFloors = i;
    }

    /**
     * @param string
     */
    public void setOccupied(String string) {
        occupied = string;
    }

    /**
     * @param date
     */
    public void setOffMarketDate(Date date) {
        offMarketDate = date;
    }

    /**
     * @param oid
     *            The oid to set.
     */
    public void setOid(long oid) {
        this.oid = oid;
    }

    /**
     * @param l
     */
    public void setOriginalListPrice(double l) {
        originalListPrice = l;
    }

    /**
     * @param otherCompensation
     *            The otherCompensation to set.
     */
    public void setOtherCompensation(String otherCompensation) {
        this.otherCompensation = otherCompensation;
    }

    /**
     * @param string
     */
    public void setOtherRoom(String string) {
        otherRoom = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom1Description(String string) {
        otherRoom1Description = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom1Dimensions(String string) {
        otherRoom1Dimensions = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom1Level(String string) {
        otherRoom1Level = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom1Name(String string) {
        otherRoom1Name = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom2Description(String string) {
        otherRoom2Description = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom2Dimensions(String string) {
        otherRoom2Dimensions = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom2Level(String string) {
        otherRoom2Level = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom2Name(String string) {
        otherRoom2Name = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom3Description(String string) {
        otherRoom3Description = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom3Dimensions(String string) {
        otherRoom3Dimensions = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom3Level(String string) {
        otherRoom3Level = string;
    }

    /**
     * @param string
     */
    public void setOtherRoom3Name(String string) {
        otherRoom3Name = string;
    }

    /**
     * @param string
     */
    public void setOwnerAgent(String string) {
        ownerAgent = string;
    }

    /**
     * @param date
     */
    public void setPendingDate(Date date) {
        pendingDate = date;
    }

    /**
     * @param string
     */
    public void setPhotoCode(String string) {
        photoCode = string;
    }

    /**
     * @param i
     */
    public void setPhotoCount(int i) {
        photoCount = i;
    }

    /**
     * @param date
     */
    public void setPhotoDate(Date date) {
        photoDate = date;
    }

    /**
     * @param string
     */
    public void setPhotoInstructions(String string) {
        photoInstructions = string;
    }

    /**
     * @param string
     */
    public void setPosession(String string) {
        posession = string;
    }

    /**
     * @param string
     */
    public void setPropertySubtype(String string) {
        propertySubtype = string;
    }

    /**
     * @param string
     */
    public void setPrototype(String string) {
        prototype = string;
    }

    /**
     * @param publicTransportation
     *            The publicTransportation to set.
     */
    public void setPublicTransportation(String publicTransportation) {
        this.publicTransportation = publicTransportation;
    }

    /**
     * @param string
     */
    public void setRealRemarks(String string) {
        realRemarks = string;
    }

    /**
     * @param i
     */
    public void setRecreationFee(int i) {
        recreationFee = i;
    }

    /**
     * @param string
     */
    public void setRemarks(String string) {
        remarks = string;
    }

    /**
     * @param string
     */
    public void setRestrictions(String string) {
        restrictions = string;
    }

    /**
     * @param roof
     *            The roof to set.
     */
    public void setRoof(String roof) {
        this.roof = roof;
    }

    /**
     * @param i
     */
    public void setRooms(int i) {
        rooms = i;
    }

    /**
     * @param l
     */
    public void setSalesPrice(double l) {
        salesPrice = l;
    }

    /**
     * @param string
     */
    public void setSchoolDistrict(String string) {
        schoolDistrict = string;
    }

    /**
     * @param i
     */
    public void setSellerPoints(int i) {
        sellerPoints = i;
    }

    /**
     * @param string
     */
    public void setSellingAgent(String string) {
        sellingAgent = string;
    }

    /**
     * @param string
     */
    public void setSellingCompany(String string) {
        sellingCompany = string;
    }

    /**
     * @param string
     */
    public void setSellingOffice(String string) {
        sellingOffice = string;
    }

    /**
     * @param string
     */
    public void setShowingInstructions(String string) {
        showingInstructions = string;
    }

    /**
     * @param siding
     *            The siding to set.
     */
    public void setSiding(String siding) {
        this.siding = siding;
    }

    /**
     * @param string
     */
    public void setSquareFootSource(String string) {
        squareFootSource = string;
    }

    /**
     * @param string
     */
    public void setState(String string) {
        state = string;
    }

    /**
     * @param i
     */
    public void setStories(int i) {
        stories = i;
    }

    /**
     * @param string
     */
    public void setStreetDirectional(String string) {
        streetDirectional = string;
    }

    /**
     * @param string
     */
    public void setStreetName(String string) {
        streetName = string;
    }

    /**
     * @param string
     */
    public void setStreetNumber(String string) {
        streetNumber = string;
    }

    /**
     * @param style
     *            The style to set.
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * @param string
     */
    public void setSubdivision(String string) {
        subdivision = string;
    }

    /**
     * @param l
     */
    public void setTaxAmount(double l) {
        taxAmount = l;
    }

    /**
     * @param string
     */
    public void setTaxParcel(String string) {
        taxParcel = string;
    }

    /**
     * @param date
     */
    public void setTempOffMarketDate(Date date) {
        tempOffMarketDate = date;
    }

    /**
     * @param i
     */
    public void setTotalBaths(int i) {
        totalBaths = i;
    }

    /**
     * @param l
     */
    public void setTotalSquareFeet(double l) {
        totalSquareFeet = l;
    }

    /**
     * @param string
     */
    public void setUid(double id) {
        uid = id;
    }

    /**
     * @param i
     */
    public void setUnfinishedSquareFeet(int i) {
        unfinishedSquareFeet = i;
    }

    /**
     * @param viewDescription
     *            The viewDescription to set.
     */
    public void setViewDescription(String viewDescription) {
        this.viewDescription = viewDescription;
    }

    /**
     * @param string
     */
    public void setWarranty(String string) {
        warranty = string;
    }

    /**
     * @param water
     *            The water to set.
     */
    public void setWater(String water) {
        this.water = water;
    }

    /**
     * @param date
     */
    public void setWithdrawnDate(Date date) {
        withdrawnDate = date;
    }

    /**
     * @param i
     */
    public void setYearBuilt(int i) {
        yearBuilt = i;
    }

    /**
     * @param i
     */
    public void setZip(int i) {
        zip = i;
    }

    /**
     * @param i
     */
    public void setZipExtension(int i) {
        zipExtension = i;
    }

    /**
     * @param zoning
     *            The zoning to set.
     */
    public void setZoning(String zoning) {
        this.zoning = zoning;
    }
}
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
public class BusinessOpportunity extends Property {
    private boolean adaCompliant;
    private boolean handicapAccess;
    private boolean franchise;
    private String zoning;
    private String businessClass;
    private String businessType;
    private String downPayment;
    private String requestedDeposit;
    private int buildingSquareFeet;
    private float netAcres;
    private String lotSquareFeet;
    private String restRooms;
    private String hoursWeek;
    private boolean taxReturn;
    private boolean accountantProvided;
    private boolean ownerProvided;
    private boolean limitedInfo;
    private boolean proForma;
    private boolean expNone;
    private boolean centralAirRefrig;
    private boolean centralAirEvap;
    private boolean centralHeatGas;
    private boolean centralHeatElec;
    private boolean baseboard;
    private boolean floorFurnace;
    private boolean heatPump;
    private boolean propane;
    private boolean radiantHeat;
    private boolean roomEvapAir;
    private boolean roomRefrigAir;
    private boolean solarHeat;
    private boolean wallFurnace;
    private boolean woodStove;
    private boolean cclNone;
    private boolean stucco;
    private boolean ccbWood;
    private boolean stuccoWood;
    private boolean stuccoBrick;
    private boolean frame;
    private boolean concrete;
    private boolean siding;
    private boolean brick;
    private boolean flagstone;
    private boolean manufacturer;
    private boolean steel;
    private boolean tiltUp;
    private boolean glass;
    private boolean stone;
    private boolean block;
    private boolean ccbOther;
    private boolean parkingStreet;
    private boolean parkingOffStreet;
    private boolean parkingCovered;
    private boolean parkingShared;
    private boolean parkingAdditional;
    private boolean parkingAvailable;
    private boolean parkingNone;
    private boolean psp0To5;
    private boolean psp6To10;
    private boolean psp11To15;
    private boolean psp16To25;
    private boolean psp26To50;
    private boolean psp51To100;
    private boolean pspOver100;
    private boolean pspOther;
    private boolean woodShingle;
    private boolean concreteShake;
    private boolean compositionShingle;
    private boolean asphalt;
    private boolean tile;
    private boolean roofOther;
    private boolean aitd;
    private boolean assumWithQual;
    private boolean cash;
    private boolean conventional;
    private boolean exchange;
    private boolean leaseOption;
    private boolean leaseOrOption;
    private boolean leasePurchase;
    private boolean ownerWillCarry;
    private boolean sba;
    private boolean subjectTo;
    private boolean trmOther;
    private String phase;
    private String voltage;
    private String amps;
    private Date dateAdded;
    private Date modTimestamp;
    private Date photoTimestamp;
    private String dock;
    private String railroad;
    private boolean fireSprk;
    private boolean sellLBack;
    private boolean exchange2;
    private boolean reIncluded;
    private String emplAware;
    private String dba;
    private Date dbaFromdate;
    private Date dbaToDate;
    private String ownerName;
    private String ownerPhone;
    private String ownerWorks;
    private String numEmpFt;
    private String numEmpPt;
    private String rent;
    private String annualInsurance;
    private String utilities;
    private String license;
    private String supplies;
    private String manExp;
    private String payroll;
    private String payTax;
    private String totalTax;
    private String accounting;
    private String telExp;
    private String equipmentRental;
    private String repairs;
    private String vehicles;
    private String advertisingAnnualDollars;
    private String otherExp;
    private String totalExp;
    private int scheduledGrossIncome;
    private String lessCgs;
    private String grossProfit;
    private String expenses;
    private String annualNetPrice;
    private boolean appointmentCallAgent;
    private boolean appointmentCallListingOffice;
    private boolean appointmentCallOwner;
    private boolean appointmentCallTenant;
    private boolean keyboxCallAgent;
    private boolean keyboxCodeRequired;
    private boolean keyboxSecurityAlarm;
    private boolean keyboxGoDirect;
    private boolean keyboxCallListingOff;
    private boolean keyboxCallOwner;
    private boolean keyboxCallTenant;
    private boolean keyboxVacant;
    private boolean keyCallAgent;
    private boolean keyCallListingOff;
    private boolean scdSeeRemarks;
    private boolean agricultural;
    private boolean extraction;
    private boolean manufacturing;
    private boolean retail;
    private boolean service;
    private boolean wholesale;
    private boolean gas;
    private boolean electric;
    private boolean trash;
    private boolean accountant;
    private boolean attorney;
    private boolean autoBodyShop;
    private boolean carWash;
    private boolean autoParts;
    private boolean autoRepair;
    private boolean autoSaleRental;
    private boolean autoSpecialtyEquipment;
    private boolean bar;
    private boolean beautySalon;
    private boolean beautySupply;
    private boolean tanning;
    private boolean businessOfficeRelated;
    private boolean constructionRelated;
    private boolean cardGiftBoutique;
    private boolean clothing;
    private boolean communicationsRelated;
    private boolean computerRelated;
    private boolean distributionDurable;
    private boolean distributionConsummable;
    private boolean dryCleaningAgency;
    private boolean dryCleaningPlant;
    private boolean entertainment;
    private boolean eyeHearingCare;
    private boolean financial;
    private boolean floristNursery;
    private boolean gasStation;
    private boolean gasMiniMart;
    private boolean gasMiniMartLiquor;
    private boolean groceryFood;
    private boolean gasFoodLiquor;
    private boolean hardware;
    private boolean homeProductsServices;
    private boolean janitorial;
    private boolean laundryCoinOp;
    private boolean laundryWashPress;
    private boolean liquor;
    private boolean livestock;
    private boolean medicalRelated;
    private boolean motionPicRelated;
    private boolean motelHotel;
    private boolean miniMarketFood;
    private boolean miniMarketLiquor;
    private boolean nightClub;
    private boolean oilGasWells;
    private boolean partyCrafts;
    private boolean petRelated;
    private boolean ranchFarm;
    private boolean realEstate;
    private boolean recreation;
    private boolean restaurantFamily;
    private boolean restaurantFastFood;
    private boolean restaurantFoodAndLiquor;
    private boolean sandAndGravel;
    private boolean school;
    private boolean security;
    private boolean sports;
    private boolean transportation;
    private boolean other;
    private boolean storage;
    private boolean childCareRelated;
    private String rentMonth;
    private String camMonth;
    private String leaseDeposit;
    private String renewal1;
    private String renewal2;
    private String goodwill;
    private String equipment;
    private String inventory;
    private String lseValue;
    private String realEst;
    private String licenses8;
    private String cntc;
    private String mca;
    private boolean gross;
    private boolean modfied;
    private boolean tripleNet;
    private boolean percentage;
    private boolean soleProprietor;
    private boolean partner;
    private boolean corporation;
    private String specialCommAgreement;
    private String virtualTour;
    private int longitude;
    private float listPricePerSquareFoot;
    private float salePricePerSquareFoot;
    private String companyList;
    private String companySale;
    private int limitTime;
    /**
     * @return Returns the accountant.
     */
    public boolean isAccountant() {
        return accountant;
    }
    /**
     * @param accountant The accountant to set.
     */
    public void setAccountant(boolean accountant) {
        this.accountant = accountant;
    }
    /**
     * @return Returns the accountantProvided.
     */
    public boolean isAccountantProvided() {
        return accountantProvided;
    }
    /**
     * @param accountantProvided The accountantProvided to set.
     */
    public void setAccountantProvided(boolean accountantProvided) {
        this.accountantProvided = accountantProvided;
    }
    /**
     * @return Returns the accounting.
     */
    public String getAccounting() {
        return accounting;
    }
    /**
     * @param accounting The accounting to set.
     */
    public void setAccounting(String accounting) {
        this.accounting = accounting;
    }
    /**
     * @return Returns the adaCompliant.
     */
    public boolean isAdaCompliant() {
        return adaCompliant;
    }
    /**
     * @param adaCompliant The adaCompliant to set.
     */
    public void setAdaCompliant(boolean adaCompliant) {
        this.adaCompliant = adaCompliant;
    }
    /**
     * @return Returns the advertisingAnnualDollars.
     */
    public String getAdvertisingAnnualDollars() {
        return advertisingAnnualDollars;
    }
    /**
     * @param advertisingAnnualDollars The advertisingAnnualDollars to set.
     */
    public void setAdvertisingAnnualDollars(String advertisingAnnualDollars) {
        this.advertisingAnnualDollars = advertisingAnnualDollars;
    }
    /**
     * @return Returns the agricultural.
     */
    public boolean isAgricultural() {
        return agricultural;
    }
    /**
     * @param agricultural The agricultural to set.
     */
    public void setAgricultural(boolean agricultural) {
        this.agricultural = agricultural;
    }
    /**
     * @return Returns the aitd.
     */
    public boolean isAitd() {
        return aitd;
    }
    /**
     * @param aitd The aitd to set.
     */
    public void setAitd(boolean aitd) {
        this.aitd = aitd;
    }
    /**
     * @return Returns the amps.
     */
    public String getAmps() {
        return amps;
    }
    /**
     * @param amps The amps to set.
     */
    public void setAmps(String amps) {
        this.amps = amps;
    }
    /**
     * @return Returns the annualInsurance.
     */
    public String getAnnualInsurance() {
        return annualInsurance;
    }
    /**
     * @param annualInsurance The annualInsurance to set.
     */
    public void setAnnualInsurance(String annualInsurance) {
        this.annualInsurance = annualInsurance;
    }
    /**
     * @return Returns the annualNetPrice.
     */
    public String getAnnualNetPrice() {
        return annualNetPrice;
    }
    /**
     * @param annualNetPrice The annualNetPrice to set.
     */
    public void setAnnualNetPrice(String annualNetPrice) {
        this.annualNetPrice = annualNetPrice;
    }
    /**
     * @return Returns the appointmentCallAgent.
     */
    public boolean isAppointmentCallAgent() {
        return appointmentCallAgent;
    }
    /**
     * @param appointmentCallAgent The appointmentCallAgent to set.
     */
    public void setAppointmentCallAgent(boolean appointmentCallAgent) {
        this.appointmentCallAgent = appointmentCallAgent;
    }
    /**
     * @return Returns the appointmentCallListingOffice.
     */
    public boolean isAppointmentCallListingOffice() {
        return appointmentCallListingOffice;
    }
    /**
     * @param appointmentCallListingOffice The appointmentCallListingOffice to set.
     */
    public void setAppointmentCallListingOffice(
            boolean appointmentCallListingOffice) {
        this.appointmentCallListingOffice = appointmentCallListingOffice;
    }
    /**
     * @return Returns the appointmentCallOwner.
     */
    public boolean isAppointmentCallOwner() {
        return appointmentCallOwner;
    }
    /**
     * @param appointmentCallOwner The appointmentCallOwner to set.
     */
    public void setAppointmentCallOwner(boolean appointmentCallOwner) {
        this.appointmentCallOwner = appointmentCallOwner;
    }
    /**
     * @return Returns the appointmentCallTenant.
     */
    public boolean isAppointmentCallTenant() {
        return appointmentCallTenant;
    }
    /**
     * @param appointmentCallTenant The appointmentCallTenant to set.
     */
    public void setAppointmentCallTenant(boolean appointmentCallTenant) {
        this.appointmentCallTenant = appointmentCallTenant;
    }
    /**
     * @return Returns the asphalt.
     */
    public boolean isAsphalt() {
        return asphalt;
    }
    /**
     * @param asphalt The asphalt to set.
     */
    public void setAsphalt(boolean asphalt) {
        this.asphalt = asphalt;
    }
    /**
     * @return Returns the assumWithQual.
     */
    public boolean isAssumWithQual() {
        return assumWithQual;
    }
    /**
     * @param assumWithQual The assumWithQual to set.
     */
    public void setAssumWithQual(boolean assumWithQual) {
        this.assumWithQual = assumWithQual;
    }
    /**
     * @return Returns the attorney.
     */
    public boolean isAttorney() {
        return attorney;
    }
    /**
     * @param attorney The attorney to set.
     */
    public void setAttorney(boolean attorney) {
        this.attorney = attorney;
    }
    /**
     * @return Returns the autoBodyShop.
     */
    public boolean isAutoBodyShop() {
        return autoBodyShop;
    }
    /**
     * @param autoBodyShop The autoBodyShop to set.
     */
    public void setAutoBodyShop(boolean autoBodyShop) {
        this.autoBodyShop = autoBodyShop;
    }
    /**
     * @return Returns the autoParts.
     */
    public boolean isAutoParts() {
        return autoParts;
    }
    /**
     * @param autoParts The autoParts to set.
     */
    public void setAutoParts(boolean autoParts) {
        this.autoParts = autoParts;
    }
    /**
     * @return Returns the autoRepair.
     */
    public boolean isAutoRepair() {
        return autoRepair;
    }
    /**
     * @param autoRepair The autoRepair to set.
     */
    public void setAutoRepair(boolean autoRepair) {
        this.autoRepair = autoRepair;
    }
    /**
     * @return Returns the autoSaleRental.
     */
    public boolean isAutoSaleRental() {
        return autoSaleRental;
    }
    /**
     * @param autoSaleRental The autoSaleRental to set.
     */
    public void setAutoSaleRental(boolean autoSaleRental) {
        this.autoSaleRental = autoSaleRental;
    }
    /**
     * @return Returns the autoSpecialtyEquipment.
     */
    public boolean isAutoSpecialtyEquipment() {
        return autoSpecialtyEquipment;
    }
    /**
     * @param autoSpecialtyEquipment The autoSpecialtyEquipment to set.
     */
    public void setAutoSpecialtyEquipment(boolean autoSpecialtyEquipment) {
        this.autoSpecialtyEquipment = autoSpecialtyEquipment;
    }
    /**
     * @return Returns the bar.
     */
    public boolean isBar() {
        return bar;
    }
    /**
     * @param bar The bar to set.
     */
    public void setBar(boolean bar) {
        this.bar = bar;
    }
    /**
     * @return Returns the baseboard.
     */
    public boolean isBaseboard() {
        return baseboard;
    }
    /**
     * @param baseboard The baseboard to set.
     */
    public void setBaseboard(boolean baseboard) {
        this.baseboard = baseboard;
    }
    /**
     * @return Returns the beautySalon.
     */
    public boolean isBeautySalon() {
        return beautySalon;
    }
    /**
     * @param beautySalon The beautySalon to set.
     */
    public void setBeautySalon(boolean beautySalon) {
        this.beautySalon = beautySalon;
    }
    /**
     * @return Returns the beautySupply.
     */
    public boolean isBeautySupply() {
        return beautySupply;
    }
    /**
     * @param beautySupply The beautySupply to set.
     */
    public void setBeautySupply(boolean beautySupply) {
        this.beautySupply = beautySupply;
    }
    /**
     * @return Returns the block.
     */
    public boolean isBlock() {
        return block;
    }
    /**
     * @param block The block to set.
     */
    public void setBlock(boolean block) {
        this.block = block;
    }
    /**
     * @return Returns the brick.
     */
    public boolean isBrick() {
        return brick;
    }
    /**
     * @param brick The brick to set.
     */
    public void setBrick(boolean brick) {
        this.brick = brick;
    }
    /**
     * @return Returns the buildingSquareFeet.
     */
    public int getBuildingSquareFeet() {
        return buildingSquareFeet;
    }
    /**
     * @param buildingSquareFeet The buildingSquareFeet to set.
     */
    public void setBuildingSquareFeet(int buildingSquareFeet) {
        this.buildingSquareFeet = buildingSquareFeet;
    }
    /**
     * @return Returns the businessClass.
     */
    public String getBusinessClass() {
        return businessClass;
    }
    /**
     * @param businessClass The businessClass to set.
     */
    public void setBusinessClass(String businessClass) {
        this.businessClass = businessClass;
    }
    /**
     * @return Returns the businessOfficeRelated.
     */
    public boolean isBusinessOfficeRelated() {
        return businessOfficeRelated;
    }
    /**
     * @param businessOfficeRelated The businessOfficeRelated to set.
     */
    public void setBusinessOfficeRelated(boolean businessOfficeRelated) {
        this.businessOfficeRelated = businessOfficeRelated;
    }
    /**
     * @return Returns the businessType.
     */
    public String getBusinessType() {
        return businessType;
    }
    /**
     * @param businessType The businessType to set.
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    /**
     * @return Returns the camMonth.
     */
    public String getCamMonth() {
        return camMonth;
    }
    /**
     * @param camMonth The camMonth to set.
     */
    public void setCamMonth(String camMonth) {
        this.camMonth = camMonth;
    }
    /**
     * @return Returns the cardGiftBoutique.
     */
    public boolean isCardGiftBoutique() {
        return cardGiftBoutique;
    }
    /**
     * @param cardGiftBoutique The cardGiftBoutique to set.
     */
    public void setCardGiftBoutique(boolean cardGiftBoutique) {
        this.cardGiftBoutique = cardGiftBoutique;
    }
    /**
     * @return Returns the carWash.
     */
    public boolean isCarWash() {
        return carWash;
    }
    /**
     * @param carWash The carWash to set.
     */
    public void setCarWash(boolean carWash) {
        this.carWash = carWash;
    }
    /**
     * @return Returns the cash.
     */
    public boolean isCash() {
        return cash;
    }
    /**
     * @param cash The cash to set.
     */
    public void setCash(boolean cash) {
        this.cash = cash;
    }
    /**
     * @return Returns the ccbOther.
     */
    public boolean isCcbOther() {
        return ccbOther;
    }
    /**
     * @param ccbOther The ccbOther to set.
     */
    public void setCcbOther(boolean ccbOther) {
        this.ccbOther = ccbOther;
    }
    /**
     * @return Returns the ccbWood.
     */
    public boolean isCcbWood() {
        return ccbWood;
    }
    /**
     * @param ccbWood The ccbWood to set.
     */
    public void setCcbWood(boolean ccbWood) {
        this.ccbWood = ccbWood;
    }
    /**
     * @return Returns the cclNone.
     */
    public boolean isCclNone() {
        return cclNone;
    }
    /**
     * @param cclNone The cclNone to set.
     */
    public void setCclNone(boolean cclNone) {
        this.cclNone = cclNone;
    }
    /**
     * @return Returns the centralAirEvap.
     */
    public boolean isCentralAirEvap() {
        return centralAirEvap;
    }
    /**
     * @param centralAirEvap The centralAirEvap to set.
     */
    public void setCentralAirEvap(boolean centralAirEvap) {
        this.centralAirEvap = centralAirEvap;
    }
    /**
     * @return Returns the centralAirRefrig.
     */
    public boolean isCentralAirRefrig() {
        return centralAirRefrig;
    }
    /**
     * @param centralAirRefrig The centralAirRefrig to set.
     */
    public void setCentralAirRefrig(boolean centralAirRefrig) {
        this.centralAirRefrig = centralAirRefrig;
    }
    /**
     * @return Returns the centralHeatElec.
     */
    public boolean isCentralHeatElec() {
        return centralHeatElec;
    }
    /**
     * @param centralHeatElec The centralHeatElec to set.
     */
    public void setCentralHeatElec(boolean centralHeatElec) {
        this.centralHeatElec = centralHeatElec;
    }
    /**
     * @return Returns the centralHeatGas.
     */
    public boolean isCentralHeatGas() {
        return centralHeatGas;
    }
    /**
     * @param centralHeatGas The centralHeatGas to set.
     */
    public void setCentralHeatGas(boolean centralHeatGas) {
        this.centralHeatGas = centralHeatGas;
    }
    /**
     * @return Returns the childCareRelated.
     */
    public boolean isChildCareRelated() {
        return childCareRelated;
    }
    /**
     * @param childCareRelated The childCareRelated to set.
     */
    public void setChildCareRelated(boolean childCareRelated) {
        this.childCareRelated = childCareRelated;
    }
    /**
     * @return Returns the clothing.
     */
    public boolean isClothing() {
        return clothing;
    }
    /**
     * @param clothing The clothing to set.
     */
    public void setClothing(boolean clothing) {
        this.clothing = clothing;
    }
    /**
     * @return Returns the cntc.
     */
    public String getCntc() {
        return cntc;
    }
    /**
     * @param cntc The cntc to set.
     */
    public void setCntc(String cntc) {
        this.cntc = cntc;
    }
    /**
     * @return Returns the communicationsRelated.
     */
    public boolean isCommunicationsRelated() {
        return communicationsRelated;
    }
    /**
     * @param communicationsRelated The communicationsRelated to set.
     */
    public void setCommunicationsRelated(boolean communicationsRelated) {
        this.communicationsRelated = communicationsRelated;
    }
    /**
     * @return Returns the companyList.
     */
    public String getCompanyList() {
        return companyList;
    }
    /**
     * @param companyList The companyList to set.
     */
    public void setCompanyList(String companyList) {
        this.companyList = companyList;
    }
    /**
     * @return Returns the companySale.
     */
    public String getCompanySale() {
        return companySale;
    }
    /**
     * @param companySale The companySale to set.
     */
    public void setCompanySale(String companySale) {
        this.companySale = companySale;
    }
    /**
     * @return Returns the compositionShingle.
     */
    public boolean isCompositionShingle() {
        return compositionShingle;
    }
    /**
     * @param compositionShingle The compositionShingle to set.
     */
    public void setCompositionShingle(boolean compositionShingle) {
        this.compositionShingle = compositionShingle;
    }
    /**
     * @return Returns the computerRelated.
     */
    public boolean isComputerRelated() {
        return computerRelated;
    }
    /**
     * @param computerRelated The computerRelated to set.
     */
    public void setComputerRelated(boolean computerRelated) {
        this.computerRelated = computerRelated;
    }
    /**
     * @return Returns the concrete.
     */
    public boolean isConcrete() {
        return concrete;
    }
    /**
     * @param concrete The concrete to set.
     */
    public void setConcrete(boolean concrete) {
        this.concrete = concrete;
    }
    /**
     * @return Returns the concreteShake.
     */
    public boolean isConcreteShake() {
        return concreteShake;
    }
    /**
     * @param concreteShake The concreteShake to set.
     */
    public void setConcreteShake(boolean concreteShake) {
        this.concreteShake = concreteShake;
    }
    /**
     * @return Returns the constructionRelated.
     */
    public boolean isConstructionRelated() {
        return constructionRelated;
    }
    /**
     * @param constructionRelated The constructionRelated to set.
     */
    public void setConstructionRelated(boolean constructionRelated) {
        this.constructionRelated = constructionRelated;
    }
    /**
     * @return Returns the conventional.
     */
    public boolean isConventional() {
        return conventional;
    }
    /**
     * @param conventional The conventional to set.
     */
    public void setConventional(boolean conventional) {
        this.conventional = conventional;
    }
    /**
     * @return Returns the corporation.
     */
    public boolean isCorporation() {
        return corporation;
    }
    /**
     * @param corporation The corporation to set.
     */
    public void setCorporation(boolean corporation) {
        this.corporation = corporation;
    }
    /**
     * @return Returns the dateAdded.
     */
    public Date getDateAdded() {
        return dateAdded;
    }
    /**
     * @param dateAdded The dateAdded to set.
     */
    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    /**
     * @return Returns the dba.
     */
    public String getDba() {
        return dba;
    }
    /**
     * @param dba The dba to set.
     */
    public void setDba(String dba) {
        this.dba = dba;
    }
    /**
     * @return Returns the dbaFromdate.
     */
    public Date getDbaFromdate() {
        return dbaFromdate;
    }
    /**
     * @param dbaFromdate The dbaFromdate to set.
     */
    public void setDbaFromdate(Date dbaFromdate) {
        this.dbaFromdate = dbaFromdate;
    }
    /**
     * @return Returns the dbaToDate.
     */
    public Date getDbaToDate() {
        return dbaToDate;
    }
    /**
     * @param dbaToDate The dbaToDate to set.
     */
    public void setDbaToDate(Date dbaToDate) {
        this.dbaToDate = dbaToDate;
    }
    /**
     * @return Returns the distributionConsummable.
     */
    public boolean isDistributionConsummable() {
        return distributionConsummable;
    }
    /**
     * @param distributionConsummable The distributionConsummable to set.
     */
    public void setDistributionConsummable(boolean distributionConsummable) {
        this.distributionConsummable = distributionConsummable;
    }
    /**
     * @return Returns the distributionDurable.
     */
    public boolean isDistributionDurable() {
        return distributionDurable;
    }
    /**
     * @param distributionDurable The distributionDurable to set.
     */
    public void setDistributionDurable(boolean distributionDurable) {
        this.distributionDurable = distributionDurable;
    }
    /**
     * @return Returns the dock.
     */
    public String getDock() {
        return dock;
    }
    /**
     * @param dock The dock to set.
     */
    public void setDock(String dock) {
        this.dock = dock;
    }
    /**
     * @return Returns the downPayment.
     */
    public String getDownPayment() {
        return downPayment;
    }
    /**
     * @param downPayment The downPayment to set.
     */
    public void setDownPayment(String downPayment) {
        this.downPayment = downPayment;
    }
    /**
     * @return Returns the dryCleaningAgency.
     */
    public boolean isDryCleaningAgency() {
        return dryCleaningAgency;
    }
    /**
     * @param dryCleaningAgency The dryCleaningAgency to set.
     */
    public void setDryCleaningAgency(boolean dryCleaningAgency) {
        this.dryCleaningAgency = dryCleaningAgency;
    }
    /**
     * @return Returns the dryCleaningPlant.
     */
    public boolean isDryCleaningPlant() {
        return dryCleaningPlant;
    }
    /**
     * @param dryCleaningPlant The dryCleaningPlant to set.
     */
    public void setDryCleaningPlant(boolean dryCleaningPlant) {
        this.dryCleaningPlant = dryCleaningPlant;
    }
    /**
     * @return Returns the electric.
     */
    public boolean isElectric() {
        return electric;
    }
    /**
     * @param electric The electric to set.
     */
    public void setElectric(boolean electric) {
        this.electric = electric;
    }
    /**
     * @return Returns the emplAware.
     */
    public String getEmplAware() {
        return emplAware;
    }
    /**
     * @param emplAware The emplAware to set.
     */
    public void setEmplAware(String emplAware) {
        this.emplAware = emplAware;
    }
    /**
     * @return Returns the entertainment.
     */
    public boolean isEntertainment() {
        return entertainment;
    }
    /**
     * @param entertainment The entertainment to set.
     */
    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }
    /**
     * @return Returns the equipment.
     */
    public String getEquipment() {
        return equipment;
    }
    /**
     * @param equipment The equipment to set.
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    /**
     * @return Returns the equipmentRental.
     */
    public String getEquipmentRental() {
        return equipmentRental;
    }
    /**
     * @param equipmentRental The equipmentRental to set.
     */
    public void setEquipmentRental(String equipmentRental) {
        this.equipmentRental = equipmentRental;
    }
    /**
     * @return Returns the exchange.
     */
    public boolean isExchange() {
        return exchange;
    }
    /**
     * @param exchange The exchange to set.
     */
    public void setExchange(boolean exchange) {
        this.exchange = exchange;
    }
    /**
     * @return Returns the exchange2.
     */
    public boolean isExchange2() {
        return exchange2;
    }
    /**
     * @param exchange2 The exchange2 to set.
     */
    public void setExchange2(boolean exchange2) {
        this.exchange2 = exchange2;
    }
    /**
     * @return Returns the expenses.
     */
    public String getExpenses() {
        return expenses;
    }
    /**
     * @param expenses The expenses to set.
     */
    public void setExpenses(String expenses) {
        this.expenses = expenses;
    }
    /**
     * @return Returns the expNone.
     */
    public boolean isExpNone() {
        return expNone;
    }
    /**
     * @param expNone The expNone to set.
     */
    public void setExpNone(boolean expNone) {
        this.expNone = expNone;
    }
    /**
     * @return Returns the extraction.
     */
    public boolean isExtraction() {
        return extraction;
    }
    /**
     * @param extraction The extraction to set.
     */
    public void setExtraction(boolean extraction) {
        this.extraction = extraction;
    }
    /**
     * @return Returns the eyeHearingCare.
     */
    public boolean isEyeHearingCare() {
        return eyeHearingCare;
    }
    /**
     * @param eyeHearingCare The eyeHearingCare to set.
     */
    public void setEyeHearingCare(boolean eyeHearingCare) {
        this.eyeHearingCare = eyeHearingCare;
    }
    /**
     * @return Returns the financial.
     */
    public boolean isFinancial() {
        return financial;
    }
    /**
     * @param financial The financial to set.
     */
    public void setFinancial(boolean financial) {
        this.financial = financial;
    }
    /**
     * @return Returns the fireSprk.
     */
    public boolean isFireSprk() {
        return fireSprk;
    }
    /**
     * @param fireSprk The fireSprk to set.
     */
    public void setFireSprk(boolean fireSprk) {
        this.fireSprk = fireSprk;
    }
    /**
     * @return Returns the flagstone.
     */
    public boolean isFlagstone() {
        return flagstone;
    }
    /**
     * @param flagstone The flagstone to set.
     */
    public void setFlagstone(boolean flagstone) {
        this.flagstone = flagstone;
    }
    /**
     * @return Returns the floorFurnace.
     */
    public boolean isFloorFurnace() {
        return floorFurnace;
    }
    /**
     * @param floorFurnace The floorFurnace to set.
     */
    public void setFloorFurnace(boolean floorFurnace) {
        this.floorFurnace = floorFurnace;
    }
    /**
     * @return Returns the floristNursery.
     */
    public boolean isFloristNursery() {
        return floristNursery;
    }
    /**
     * @param floristNursery The floristNursery to set.
     */
    public void setFloristNursery(boolean floristNursery) {
        this.floristNursery = floristNursery;
    }
    /**
     * @return Returns the frame.
     */
    public boolean isFrame() {
        return frame;
    }
    /**
     * @param frame The frame to set.
     */
    public void setFrame(boolean frame) {
        this.frame = frame;
    }
    /**
     * @return Returns the franchise.
     */
    public boolean isFranchise() {
        return franchise;
    }
    /**
     * @param franchise The franchise to set.
     */
    public void setFranchise(boolean franchise) {
        this.franchise = franchise;
    }
    /**
     * @return Returns the gas.
     */
    public boolean isGas() {
        return gas;
    }
    /**
     * @param gas The gas to set.
     */
    public void setGas(boolean gas) {
        this.gas = gas;
    }
    /**
     * @return Returns the gasFoodLiquor.
     */
    public boolean isGasFoodLiquor() {
        return gasFoodLiquor;
    }
    /**
     * @param gasFoodLiquor The gasFoodLiquor to set.
     */
    public void setGasFoodLiquor(boolean gasFoodLiquor) {
        this.gasFoodLiquor = gasFoodLiquor;
    }
    /**
     * @return Returns the gasMiniMart.
     */
    public boolean isGasMiniMart() {
        return gasMiniMart;
    }
    /**
     * @param gasMiniMart The gasMiniMart to set.
     */
    public void setGasMiniMart(boolean gasMiniMart) {
        this.gasMiniMart = gasMiniMart;
    }
    /**
     * @return Returns the gasMiniMartLiquor.
     */
    public boolean isGasMiniMartLiquor() {
        return gasMiniMartLiquor;
    }
    /**
     * @param gasMiniMartLiquor The gasMiniMartLiquor to set.
     */
    public void setGasMiniMartLiquor(boolean gasMiniMartLiquor) {
        this.gasMiniMartLiquor = gasMiniMartLiquor;
    }
    /**
     * @return Returns the gasStation.
     */
    public boolean isGasStation() {
        return gasStation;
    }
    /**
     * @param gasStation The gasStation to set.
     */
    public void setGasStation(boolean gasStation) {
        this.gasStation = gasStation;
    }
    /**
     * @return Returns the glass.
     */
    public boolean isGlass() {
        return glass;
    }
    /**
     * @param glass The glass to set.
     */
    public void setGlass(boolean glass) {
        this.glass = glass;
    }
    /**
     * @return Returns the goodwill.
     */
    public String getGoodwill() {
        return goodwill;
    }
    /**
     * @param goodwill The goodwill to set.
     */
    public void setGoodwill(String goodwill) {
        this.goodwill = goodwill;
    }
    /**
     * @return Returns the groceryFood.
     */
    public boolean isGroceryFood() {
        return groceryFood;
    }
    /**
     * @param groceryFood The groceryFood to set.
     */
    public void setGroceryFood(boolean groceryFood) {
        this.groceryFood = groceryFood;
    }
    /**
     * @return Returns the gross.
     */
    public boolean isGross() {
        return gross;
    }
    /**
     * @param gross The gross to set.
     */
    public void setGross(boolean gross) {
        this.gross = gross;
    }
    /**
     * @return Returns the grossProfit.
     */
    public String getGrossProfit() {
        return grossProfit;
    }
    /**
     * @param grossProfit The grossProfit to set.
     */
    public void setGrossProfit(String grossProfit) {
        this.grossProfit = grossProfit;
    }
    /**
     * @return Returns the handicapAccess.
     */
    public boolean isHandicapAccess() {
        return handicapAccess;
    }
    /**
     * @param handicapAccess The handicapAccess to set.
     */
    public void setHandicapAccess(boolean handicapAccess) {
        this.handicapAccess = handicapAccess;
    }
    /**
     * @return Returns the hardware.
     */
    public boolean isHardware() {
        return hardware;
    }
    /**
     * @param hardware The hardware to set.
     */
    public void setHardware(boolean hardware) {
        this.hardware = hardware;
    }
    /**
     * @return Returns the heatPump.
     */
    public boolean isHeatPump() {
        return heatPump;
    }
    /**
     * @param heatPump The heatPump to set.
     */
    public void setHeatPump(boolean heatPump) {
        this.heatPump = heatPump;
    }
    /**
     * @return Returns the homeProductsServices.
     */
    public boolean isHomeProductsServices() {
        return homeProductsServices;
    }
    /**
     * @param homeProductsServices The homeProductsServices to set.
     */
    public void setHomeProductsServices(boolean homeProductsServices) {
        this.homeProductsServices = homeProductsServices;
    }
    /**
     * @return Returns the hoursWeek.
     */
    public String getHoursWeek() {
        return hoursWeek;
    }
    /**
     * @param hoursWeek The hoursWeek to set.
     */
    public void setHoursWeek(String hoursWeek) {
        this.hoursWeek = hoursWeek;
    }
    /**
     * @return Returns the inventory.
     */
    public String getInventory() {
        return inventory;
    }
    /**
     * @param inventory The inventory to set.
     */
    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
    /**
     * @return Returns the janitorial.
     */
    public boolean isJanitorial() {
        return janitorial;
    }
    /**
     * @param janitorial The janitorial to set.
     */
    public void setJanitorial(boolean janitorial) {
        this.janitorial = janitorial;
    }
    /**
     * @return Returns the keyboxCallAgent.
     */
    public boolean isKeyboxCallAgent() {
        return keyboxCallAgent;
    }
    /**
     * @param keyboxCallAgent The keyboxCallAgent to set.
     */
    public void setKeyboxCallAgent(boolean keyboxCallAgent) {
        this.keyboxCallAgent = keyboxCallAgent;
    }
    /**
     * @return Returns the keyboxCallListingOff.
     */
    public boolean isKeyboxCallListingOff() {
        return keyboxCallListingOff;
    }
    /**
     * @param keyboxCallListingOff The keyboxCallListingOff to set.
     */
    public void setKeyboxCallListingOff(boolean keyboxCallListingOff) {
        this.keyboxCallListingOff = keyboxCallListingOff;
    }
    /**
     * @return Returns the keyboxCallOwner.
     */
    public boolean isKeyboxCallOwner() {
        return keyboxCallOwner;
    }
    /**
     * @param keyboxCallOwner The keyboxCallOwner to set.
     */
    public void setKeyboxCallOwner(boolean keyboxCallOwner) {
        this.keyboxCallOwner = keyboxCallOwner;
    }
    /**
     * @return Returns the keyboxCallTenant.
     */
    public boolean isKeyboxCallTenant() {
        return keyboxCallTenant;
    }
    /**
     * @param keyboxCallTenant The keyboxCallTenant to set.
     */
    public void setKeyboxCallTenant(boolean keyboxCallTenant) {
        this.keyboxCallTenant = keyboxCallTenant;
    }
    /**
     * @return Returns the keyboxCodeRequired.
     */
    public boolean isKeyboxCodeRequired() {
        return keyboxCodeRequired;
    }
    /**
     * @param keyboxCodeRequired The keyboxCodeRequired to set.
     */
    public void setKeyboxCodeRequired(boolean keyboxCodeRequired) {
        this.keyboxCodeRequired = keyboxCodeRequired;
    }
    /**
     * @return Returns the keyboxGoDirect.
     */
    public boolean isKeyboxGoDirect() {
        return keyboxGoDirect;
    }
    /**
     * @param keyboxGoDirect The keyboxGoDirect to set.
     */
    public void setKeyboxGoDirect(boolean keyboxGoDirect) {
        this.keyboxGoDirect = keyboxGoDirect;
    }
    /**
     * @return Returns the keyboxSecurityAlarm.
     */
    public boolean isKeyboxSecurityAlarm() {
        return keyboxSecurityAlarm;
    }
    /**
     * @param keyboxSecurityAlarm The keyboxSecurityAlarm to set.
     */
    public void setKeyboxSecurityAlarm(boolean keyboxSecurityAlarm) {
        this.keyboxSecurityAlarm = keyboxSecurityAlarm;
    }
    /**
     * @return Returns the keyboxVacant.
     */
    public boolean isKeyboxVacant() {
        return keyboxVacant;
    }
    /**
     * @param keyboxVacant The keyboxVacant to set.
     */
    public void setKeyboxVacant(boolean keyboxVacant) {
        this.keyboxVacant = keyboxVacant;
    }
    /**
     * @return Returns the keyCallAgent.
     */
    public boolean isKeyCallAgent() {
        return keyCallAgent;
    }
    /**
     * @param keyCallAgent The keyCallAgent to set.
     */
    public void setKeyCallAgent(boolean keyCallAgent) {
        this.keyCallAgent = keyCallAgent;
    }
    /**
     * @return Returns the keyCallListingOff.
     */
    public boolean isKeyCallListingOff() {
        return keyCallListingOff;
    }
    /**
     * @param keyCallListingOff The keyCallListingOff to set.
     */
    public void setKeyCallListingOff(boolean keyCallListingOff) {
        this.keyCallListingOff = keyCallListingOff;
    }
    /**
     * @return Returns the laundryCoinOp.
     */
    public boolean isLaundryCoinOp() {
        return laundryCoinOp;
    }
    /**
     * @param laundryCoinOp The laundryCoinOp to set.
     */
    public void setLaundryCoinOp(boolean laundryCoinOp) {
        this.laundryCoinOp = laundryCoinOp;
    }
    /**
     * @return Returns the laundryWashPress.
     */
    public boolean isLaundryWashPress() {
        return laundryWashPress;
    }
    /**
     * @param laundryWashPress The laundryWashPress to set.
     */
    public void setLaundryWashPress(boolean laundryWashPress) {
        this.laundryWashPress = laundryWashPress;
    }
    /**
     * @return Returns the leaseDeposit.
     */
    public String getLeaseDeposit() {
        return leaseDeposit;
    }
    /**
     * @param leaseDeposit The leaseDeposit to set.
     */
    public void setLeaseDeposit(String leaseDeposit) {
        this.leaseDeposit = leaseDeposit;
    }
    /**
     * @return Returns the leaseOption.
     */
    public boolean isLeaseOption() {
        return leaseOption;
    }
    /**
     * @param leaseOption The leaseOption to set.
     */
    public void setLeaseOption(boolean leaseOption) {
        this.leaseOption = leaseOption;
    }
    /**
     * @return Returns the leaseOrOption.
     */
    public boolean isLeaseOrOption() {
        return leaseOrOption;
    }
    /**
     * @param leaseOrOption The leaseOrOption to set.
     */
    public void setLeaseOrOption(boolean leaseOrOption) {
        this.leaseOrOption = leaseOrOption;
    }
    /**
     * @return Returns the leasePurchase.
     */
    public boolean isLeasePurchase() {
        return leasePurchase;
    }
    /**
     * @param leasePurchase The leasePurchase to set.
     */
    public void setLeasePurchase(boolean leasePurchase) {
        this.leasePurchase = leasePurchase;
    }
    /**
     * @return Returns the lessCgs.
     */
    public String getLessCgs() {
        return lessCgs;
    }
    /**
     * @param lessCgs The lessCgs to set.
     */
    public void setLessCgs(String lessCgs) {
        this.lessCgs = lessCgs;
    }
    /**
     * @return Returns the license.
     */
    public String getLicense() {
        return license;
    }
    /**
     * @param license The license to set.
     */
    public void setLicense(String license) {
        this.license = license;
    }
    /**
     * @return Returns the licenses8.
     */
    public String getLicenses8() {
        return licenses8;
    }
    /**
     * @param licenses8 The licenses8 to set.
     */
    public void setLicenses8(String licenses8) {
        this.licenses8 = licenses8;
    }
    /**
     * @return Returns the limitedInfo.
     */
    public boolean isLimitedInfo() {
        return limitedInfo;
    }
    /**
     * @param limitedInfo The limitedInfo to set.
     */
    public void setLimitedInfo(boolean limitedInfo) {
        this.limitedInfo = limitedInfo;
    }
    /**
     * @return Returns the limitTime.
     */
    public int getLimitTime() {
        return limitTime;
    }
    /**
     * @param limitTime The limitTime to set.
     */
    public void setLimitTime(int limitTime) {
        this.limitTime = limitTime;
    }
    /**
     * @return Returns the liquor.
     */
    public boolean isLiquor() {
        return liquor;
    }
    /**
     * @param liquor The liquor to set.
     */
    public void setLiquor(boolean liquor) {
        this.liquor = liquor;
    }
    /**
     * @return Returns the listPricePerSquareFoot.
     */
    public float getListPricePerSquareFoot() {
        return listPricePerSquareFoot;
    }
    /**
     * @param listPricePerSquareFoot The listPricePerSquareFoot to set.
     */
    public void setListPricePerSquareFoot(float listPricePerSquareFoot) {
        this.listPricePerSquareFoot = listPricePerSquareFoot;
    }
    /**
     * @return Returns the livestock.
     */
    public boolean isLivestock() {
        return livestock;
    }
    /**
     * @param livestock The livestock to set.
     */
    public void setLivestock(boolean livestock) {
        this.livestock = livestock;
    }
    /**
     * @return Returns the longitude.
     */
    public int getLongitude() {
        return longitude;
    }
    /**
     * @param longitude The longitude to set.
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    /**
     * @return Returns the lotSquareFeet.
     */
    public String getLotSquareFeet() {
        return lotSquareFeet;
    }
    /**
     * @param lotSquareFeet The lotSquareFeet to set.
     */
    public void setLotSquareFeet(String lotSquareFeet) {
        this.lotSquareFeet = lotSquareFeet;
    }
    /**
     * @return Returns the lseValue.
     */
    public String getLseValue() {
        return lseValue;
    }
    /**
     * @param lseValue The lseValue to set.
     */
    public void setLseValue(String lseValue) {
        this.lseValue = lseValue;
    }
    /**
     * @return Returns the manExp.
     */
    public String getManExp() {
        return manExp;
    }
    /**
     * @param manExp The manExp to set.
     */
    public void setManExp(String manExp) {
        this.manExp = manExp;
    }
    /**
     * @return Returns the manufacturer.
     */
    public boolean isManufacturer() {
        return manufacturer;
    }
    /**
     * @param manufacturer The manufacturer to set.
     */
    public void setManufacturer(boolean manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**
     * @return Returns the manufacturing.
     */
    public boolean isManufacturing() {
        return manufacturing;
    }
    /**
     * @param manufacturing The manufacturing to set.
     */
    public void setManufacturing(boolean manufacturing) {
        this.manufacturing = manufacturing;
    }
    /**
     * @return Returns the mca.
     */
    public String getMca() {
        return mca;
    }
    /**
     * @param mca The mca to set.
     */
    public void setMca(String mca) {
        this.mca = mca;
    }
    /**
     * @return Returns the medicalRelated.
     */
    public boolean isMedicalRelated() {
        return medicalRelated;
    }
    /**
     * @param medicalRelated The medicalRelated to set.
     */
    public void setMedicalRelated(boolean medicalRelated) {
        this.medicalRelated = medicalRelated;
    }
    /**
     * @return Returns the miniMarketFood.
     */
    public boolean isMiniMarketFood() {
        return miniMarketFood;
    }
    /**
     * @param miniMarketFood The miniMarketFood to set.
     */
    public void setMiniMarketFood(boolean miniMarketFood) {
        this.miniMarketFood = miniMarketFood;
    }
    /**
     * @return Returns the miniMarketLiquor.
     */
    public boolean isMiniMarketLiquor() {
        return miniMarketLiquor;
    }
    /**
     * @param miniMarketLiquor The miniMarketLiquor to set.
     */
    public void setMiniMarketLiquor(boolean miniMarketLiquor) {
        this.miniMarketLiquor = miniMarketLiquor;
    }
    /**
     * @return Returns the modfied.
     */
    public boolean isModfied() {
        return modfied;
    }
    /**
     * @param modfied The modfied to set.
     */
    public void setModfied(boolean modfied) {
        this.modfied = modfied;
    }
    /**
     * @return Returns the modTimestamp.
     */
    public Date getModTimestamp() {
        return modTimestamp;
    }
    /**
     * @param modTimestamp The modTimestamp to set.
     */
    public void setModTimestamp(Date modTimestamp) {
        this.modTimestamp = modTimestamp;
    }
    /**
     * @return Returns the motelHotel.
     */
    public boolean isMotelHotel() {
        return motelHotel;
    }
    /**
     * @param motelHotel The motelHotel to set.
     */
    public void setMotelHotel(boolean motelHotel) {
        this.motelHotel = motelHotel;
    }
    /**
     * @return Returns the motionPicRelated.
     */
    public boolean isMotionPicRelated() {
        return motionPicRelated;
    }
    /**
     * @param motionPicRelated The motionPicRelated to set.
     */
    public void setMotionPicRelated(boolean motionPicRelated) {
        this.motionPicRelated = motionPicRelated;
    }
    /**
     * @return Returns the netAcres.
     */
    public float getNetAcres() {
        return netAcres;
    }
    /**
     * @param netAcres The netAcres to set.
     */
    public void setNetAcres(float netAcres) {
        this.netAcres = netAcres;
    }
    /**
     * @return Returns the nightClub.
     */
    public boolean isNightClub() {
        return nightClub;
    }
    /**
     * @param nightClub The nightClub to set.
     */
    public void setNightClub(boolean nightClub) {
        this.nightClub = nightClub;
    }
    /**
     * @return Returns the numEmpFt.
     */
    public String getNumEmpFt() {
        return numEmpFt;
    }
    /**
     * @param numEmpFt The numEmpFt to set.
     */
    public void setNumEmpFt(String numEmpFt) {
        this.numEmpFt = numEmpFt;
    }
    /**
     * @return Returns the numEmpPt.
     */
    public String getNumEmpPt() {
        return numEmpPt;
    }
    /**
     * @param numEmpPt The numEmpPt to set.
     */
    public void setNumEmpPt(String numEmpPt) {
        this.numEmpPt = numEmpPt;
    }
    /**
     * @return Returns the oilGasWells.
     */
    public boolean isOilGasWells() {
        return oilGasWells;
    }
    /**
     * @param oilGasWells The oilGasWells to set.
     */
    public void setOilGasWells(boolean oilGasWells) {
        this.oilGasWells = oilGasWells;
    }
    /**
     * @return Returns the other.
     */
    public boolean isOther() {
        return other;
    }
    /**
     * @param other The other to set.
     */
    public void setOther(boolean other) {
        this.other = other;
    }
    /**
     * @return Returns the otherExp.
     */
    public String getOtherExp() {
        return otherExp;
    }
    /**
     * @param otherExp The otherExp to set.
     */
    public void setOtherExp(String otherExp) {
        this.otherExp = otherExp;
    }
    /**
     * @return Returns the ownerName.
     */
    public String getOwnerName() {
        return ownerName;
    }
    /**
     * @param ownerName The ownerName to set.
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    /**
     * @return Returns the ownerPhone.
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }
    /**
     * @param ownerPhone The ownerPhone to set.
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    /**
     * @return Returns the ownerProvided.
     */
    public boolean isOwnerProvided() {
        return ownerProvided;
    }
    /**
     * @param ownerProvided The ownerProvided to set.
     */
    public void setOwnerProvided(boolean ownerProvided) {
        this.ownerProvided = ownerProvided;
    }
    /**
     * @return Returns the ownerWillCarry.
     */
    public boolean isOwnerWillCarry() {
        return ownerWillCarry;
    }
    /**
     * @param ownerWillCarry The ownerWillCarry to set.
     */
    public void setOwnerWillCarry(boolean ownerWillCarry) {
        this.ownerWillCarry = ownerWillCarry;
    }
    /**
     * @return Returns the ownerWorks.
     */
    public String getOwnerWorks() {
        return ownerWorks;
    }
    /**
     * @param ownerWorks The ownerWorks to set.
     */
    public void setOwnerWorks(String ownerWorks) {
        this.ownerWorks = ownerWorks;
    }
    /**
     * @return Returns the parkingAdditional.
     */
    public boolean isParkingAdditional() {
        return parkingAdditional;
    }
    /**
     * @param parkingAdditional The parkingAdditional to set.
     */
    public void setParkingAdditional(boolean parkingAdditional) {
        this.parkingAdditional = parkingAdditional;
    }
    /**
     * @return Returns the parkingAvailable.
     */
    public boolean isParkingAvailable() {
        return parkingAvailable;
    }
    /**
     * @param parkingAvailable The parkingAvailable to set.
     */
    public void setParkingAvailable(boolean parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }
    /**
     * @return Returns the parkingCovered.
     */
    public boolean isParkingCovered() {
        return parkingCovered;
    }
    /**
     * @param parkingCovered The parkingCovered to set.
     */
    public void setParkingCovered(boolean parkingCovered) {
        this.parkingCovered = parkingCovered;
    }
    /**
     * @return Returns the parkingNone.
     */
    public boolean isParkingNone() {
        return parkingNone;
    }
    /**
     * @param parkingNone The parkingNone to set.
     */
    public void setParkingNone(boolean parkingNone) {
        this.parkingNone = parkingNone;
    }
    /**
     * @return Returns the parkingOffStreet.
     */
    public boolean isParkingOffStreet() {
        return parkingOffStreet;
    }
    /**
     * @param parkingOffStreet The parkingOffStreet to set.
     */
    public void setParkingOffStreet(boolean parkingOffStreet) {
        this.parkingOffStreet = parkingOffStreet;
    }
    /**
     * @return Returns the parkingShared.
     */
    public boolean isParkingShared() {
        return parkingShared;
    }
    /**
     * @param parkingShared The parkingShared to set.
     */
    public void setParkingShared(boolean parkingShared) {
        this.parkingShared = parkingShared;
    }
    /**
     * @return Returns the parkingStreet.
     */
    public boolean isParkingStreet() {
        return parkingStreet;
    }
    /**
     * @param parkingStreet The parkingStreet to set.
     */
    public void setParkingStreet(boolean parkingStreet) {
        this.parkingStreet = parkingStreet;
    }
    /**
     * @return Returns the partner.
     */
    public boolean isPartner() {
        return partner;
    }
    /**
     * @param partner The partner to set.
     */
    public void setPartner(boolean partner) {
        this.partner = partner;
    }
    /**
     * @return Returns the partyCrafts.
     */
    public boolean isPartyCrafts() {
        return partyCrafts;
    }
    /**
     * @param partyCrafts The partyCrafts to set.
     */
    public void setPartyCrafts(boolean partyCrafts) {
        this.partyCrafts = partyCrafts;
    }
    /**
     * @return Returns the payroll.
     */
    public String getPayroll() {
        return payroll;
    }
    /**
     * @param payroll The payroll to set.
     */
    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }
    /**
     * @return Returns the payTax.
     */
    public String getPayTax() {
        return payTax;
    }
    /**
     * @param payTax The payTax to set.
     */
    public void setPayTax(String payTax) {
        this.payTax = payTax;
    }
    /**
     * @return Returns the percentage.
     */
    public boolean isPercentage() {
        return percentage;
    }
    /**
     * @param percentage The percentage to set.
     */
    public void setPercentage(boolean percentage) {
        this.percentage = percentage;
    }
    /**
     * @return Returns the petRelated.
     */
    public boolean isPetRelated() {
        return petRelated;
    }
    /**
     * @param petRelated The petRelated to set.
     */
    public void setPetRelated(boolean petRelated) {
        this.petRelated = petRelated;
    }
    /**
     * @return Returns the phase.
     */
    public String getPhase() {
        return phase;
    }
    /**
     * @param phase The phase to set.
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }
    /**
     * @return Returns the photoTimestamp.
     */
    public Date getPhotoTimestamp() {
        return photoTimestamp;
    }
    /**
     * @param photoTimestamp The photoTimestamp to set.
     */
    public void setPhotoTimestamp(Date photoTimestamp) {
        this.photoTimestamp = photoTimestamp;
    }
    /**
     * @return Returns the proForma.
     */
    public boolean isProForma() {
        return proForma;
    }
    /**
     * @param proForma The proForma to set.
     */
    public void setProForma(boolean proForma) {
        this.proForma = proForma;
    }
    /**
     * @return Returns the propane.
     */
    public boolean isPropane() {
        return propane;
    }
    /**
     * @param propane The propane to set.
     */
    public void setPropane(boolean propane) {
        this.propane = propane;
    }
    /**
     * @return Returns the psp0To5.
     */
    public boolean isPsp0To5() {
        return psp0To5;
    }
    /**
     * @param psp0To5 The psp0To5 to set.
     */
    public void setPsp0To5(boolean psp0To5) {
        this.psp0To5 = psp0To5;
    }
    /**
     * @return Returns the psp11To15.
     */
    public boolean isPsp11To15() {
        return psp11To15;
    }
    /**
     * @param psp11To15 The psp11To15 to set.
     */
    public void setPsp11To15(boolean psp11To15) {
        this.psp11To15 = psp11To15;
    }
    /**
     * @return Returns the psp16To25.
     */
    public boolean isPsp16To25() {
        return psp16To25;
    }
    /**
     * @param psp16To25 The psp16To25 to set.
     */
    public void setPsp16To25(boolean psp16To25) {
        this.psp16To25 = psp16To25;
    }
    /**
     * @return Returns the psp26To50.
     */
    public boolean isPsp26To50() {
        return psp26To50;
    }
    /**
     * @param psp26To50 The psp26To50 to set.
     */
    public void setPsp26To50(boolean psp26To50) {
        this.psp26To50 = psp26To50;
    }
    /**
     * @return Returns the psp51To100.
     */
    public boolean isPsp51To100() {
        return psp51To100;
    }
    /**
     * @param psp51To100 The psp51To100 to set.
     */
    public void setPsp51To100(boolean psp51To100) {
        this.psp51To100 = psp51To100;
    }
    /**
     * @return Returns the psp6To10.
     */
    public boolean isPsp6To10() {
        return psp6To10;
    }
    /**
     * @param psp6To10 The psp6To10 to set.
     */
    public void setPsp6To10(boolean psp6To10) {
        this.psp6To10 = psp6To10;
    }
    /**
     * @return Returns the pspOther.
     */
    public boolean isPspOther() {
        return pspOther;
    }
    /**
     * @param pspOther The pspOther to set.
     */
    public void setPspOther(boolean pspOther) {
        this.pspOther = pspOther;
    }
    /**
     * @return Returns the pspOver100.
     */
    public boolean isPspOver100() {
        return pspOver100;
    }
    /**
     * @param pspOver100 The pspOver100 to set.
     */
    public void setPspOver100(boolean pspOver100) {
        this.pspOver100 = pspOver100;
    }
    /**
     * @return Returns the radiantHeat.
     */
    public boolean isRadiantHeat() {
        return radiantHeat;
    }
    /**
     * @param radiantHeat The radiantHeat to set.
     */
    public void setRadiantHeat(boolean radiantHeat) {
        this.radiantHeat = radiantHeat;
    }
    /**
     * @return Returns the railroad.
     */
    public String getRailroad() {
        return railroad;
    }
    /**
     * @param railroad The railroad to set.
     */
    public void setRailroad(String railroad) {
        this.railroad = railroad;
    }
    /**
     * @return Returns the ranchFarm.
     */
    public boolean isRanchFarm() {
        return ranchFarm;
    }
    /**
     * @param ranchFarm The ranchFarm to set.
     */
    public void setRanchFarm(boolean ranchFarm) {
        this.ranchFarm = ranchFarm;
    }
    /**
     * @return Returns the realEst.
     */
    public String getRealEst() {
        return realEst;
    }
    /**
     * @param realEst The realEst to set.
     */
    public void setRealEst(String realEst) {
        this.realEst = realEst;
    }
    /**
     * @return Returns the realEstate.
     */
    public boolean isRealEstate() {
        return realEstate;
    }
    /**
     * @param realEstate The realEstate to set.
     */
    public void setRealEstate(boolean realEstate) {
        this.realEstate = realEstate;
    }
    /**
     * @return Returns the recreation.
     */
    public boolean isRecreation() {
        return recreation;
    }
    /**
     * @param recreation The recreation to set.
     */
    public void setRecreation(boolean recreation) {
        this.recreation = recreation;
    }
    /**
     * @return Returns the reIncluded.
     */
    public boolean isReIncluded() {
        return reIncluded;
    }
    /**
     * @param reIncluded The reIncluded to set.
     */
    public void setReIncluded(boolean reIncluded) {
        this.reIncluded = reIncluded;
    }
    /**
     * @return Returns the renewal1.
     */
    public String getRenewal1() {
        return renewal1;
    }
    /**
     * @param renewal1 The renewal1 to set.
     */
    public void setRenewal1(String renewal1) {
        this.renewal1 = renewal1;
    }
    /**
     * @return Returns the renewal2.
     */
    public String getRenewal2() {
        return renewal2;
    }
    /**
     * @param renewal2 The renewal2 to set.
     */
    public void setRenewal2(String renewal2) {
        this.renewal2 = renewal2;
    }
    /**
     * @return Returns the rent.
     */
    public String getRent() {
        return rent;
    }
    /**
     * @param rent The rent to set.
     */
    public void setRent(String rent) {
        this.rent = rent;
    }
    /**
     * @return Returns the rentMonth.
     */
    public String getRentMonth() {
        return rentMonth;
    }
    /**
     * @param rentMonth The rentMonth to set.
     */
    public void setRentMonth(String rentMonth) {
        this.rentMonth = rentMonth;
    }
    /**
     * @return Returns the repairs.
     */
    public String getRepairs() {
        return repairs;
    }
    /**
     * @param repairs The repairs to set.
     */
    public void setRepairs(String repairs) {
        this.repairs = repairs;
    }
    /**
     * @return Returns the requestedDeposit.
     */
    public String getRequestedDeposit() {
        return requestedDeposit;
    }
    /**
     * @param requestedDeposit The requestedDeposit to set.
     */
    public void setRequestedDeposit(String requestedDeposit) {
        this.requestedDeposit = requestedDeposit;
    }
    /**
     * @return Returns the restaurantFamily.
     */
    public boolean isRestaurantFamily() {
        return restaurantFamily;
    }
    /**
     * @param restaurantFamily The restaurantFamily to set.
     */
    public void setRestaurantFamily(boolean restaurantFamily) {
        this.restaurantFamily = restaurantFamily;
    }
    /**
     * @return Returns the restaurantFastFood.
     */
    public boolean isRestaurantFastFood() {
        return restaurantFastFood;
    }
    /**
     * @param restaurantFastFood The restaurantFastFood to set.
     */
    public void setRestaurantFastFood(boolean restaurantFastFood) {
        this.restaurantFastFood = restaurantFastFood;
    }
    /**
     * @return Returns the restaurantFoodAndLiquor.
     */
    public boolean isRestaurantFoodAndLiquor() {
        return restaurantFoodAndLiquor;
    }
    /**
     * @param restaurantFoodAndLiquor The restaurantFoodAndLiquor to set.
     */
    public void setRestaurantFoodAndLiquor(boolean restaurantFoodAndLiquor) {
        this.restaurantFoodAndLiquor = restaurantFoodAndLiquor;
    }
    /**
     * @return Returns the restRooms.
     */
    public String getRestRooms() {
        return restRooms;
    }
    /**
     * @param restRooms The restRooms to set.
     */
    public void setRestRooms(String restRooms) {
        this.restRooms = restRooms;
    }
    /**
     * @return Returns the retail.
     */
    public boolean isRetail() {
        return retail;
    }
    /**
     * @param retail The retail to set.
     */
    public void setRetail(boolean retail) {
        this.retail = retail;
    }
    /**
     * @return Returns the roofOther.
     */
    public boolean isRoofOther() {
        return roofOther;
    }
    /**
     * @param roofOther The roofOther to set.
     */
    public void setRoofOther(boolean roofOther) {
        this.roofOther = roofOther;
    }
    /**
     * @return Returns the roomEvapAir.
     */
    public boolean isRoomEvapAir() {
        return roomEvapAir;
    }
    /**
     * @param roomEvapAir The roomEvapAir to set.
     */
    public void setRoomEvapAir(boolean roomEvapAir) {
        this.roomEvapAir = roomEvapAir;
    }
    /**
     * @return Returns the roomRefrigAir.
     */
    public boolean isRoomRefrigAir() {
        return roomRefrigAir;
    }
    /**
     * @param roomRefrigAir The roomRefrigAir to set.
     */
    public void setRoomRefrigAir(boolean roomRefrigAir) {
        this.roomRefrigAir = roomRefrigAir;
    }
    /**
     * @return Returns the salePricePerSquareFoot.
     */
    public float getSalePricePerSquareFoot() {
        return salePricePerSquareFoot;
    }
    /**
     * @param salePricePerSquareFoot The salePricePerSquareFoot to set.
     */
    public void setSalePricePerSquareFoot(float salePricePerSquareFoot) {
        this.salePricePerSquareFoot = salePricePerSquareFoot;
    }
    /**
     * @return Returns the sandAndGravel.
     */
    public boolean isSandAndGravel() {
        return sandAndGravel;
    }
    /**
     * @param sandAndGravel The sandAndGravel to set.
     */
    public void setSandAndGravel(boolean sandAndGravel) {
        this.sandAndGravel = sandAndGravel;
    }
    /**
     * @return Returns the sba.
     */
    public boolean isSba() {
        return sba;
    }
    /**
     * @param sba The sba to set.
     */
    public void setSba(boolean sba) {
        this.sba = sba;
    }
    /**
     * @return Returns the scdSeeRemarks.
     */
    public boolean isScdSeeRemarks() {
        return scdSeeRemarks;
    }
    /**
     * @param scdSeeRemarks The scdSeeRemarks to set.
     */
    public void setScdSeeRemarks(boolean scdSeeRemarks) {
        this.scdSeeRemarks = scdSeeRemarks;
    }
    /**
     * @return Returns the scheduledGrossIncome.
     */
    public int getScheduledGrossIncome() {
        return scheduledGrossIncome;
    }
    /**
     * @param scheduledGrossIncome The scheduledGrossIncome to set.
     */
    public void setScheduledGrossIncome(int scheduledGrossIncome) {
        this.scheduledGrossIncome = scheduledGrossIncome;
    }
    /**
     * @return Returns the school.
     */
    public boolean isSchool() {
        return school;
    }
    /**
     * @param school The school to set.
     */
    public void setSchool(boolean school) {
        this.school = school;
    }
    /**
     * @return Returns the security.
     */
    public boolean isSecurity() {
        return security;
    }
    /**
     * @param security The security to set.
     */
    public void setSecurity(boolean security) {
        this.security = security;
    }
    /**
     * @return Returns the sellLBack.
     */
    public boolean isSellLBack() {
        return sellLBack;
    }
    /**
     * @param sellLBack The sellLBack to set.
     */
    public void setSellLBack(boolean sellLBack) {
        this.sellLBack = sellLBack;
    }
    /**
     * @return Returns the service.
     */
    public boolean isService() {
        return service;
    }
    /**
     * @param service The service to set.
     */
    public void setService(boolean service) {
        this.service = service;
    }
    /**
     * @return Returns the siding.
     */
    public boolean isSiding() {
        return siding;
    }
    /**
     * @param siding The siding to set.
     */
    public void setSiding(boolean siding) {
        this.siding = siding;
    }
    /**
     * @return Returns the solarHeat.
     */
    public boolean isSolarHeat() {
        return solarHeat;
    }
    /**
     * @param solarHeat The solarHeat to set.
     */
    public void setSolarHeat(boolean solarHeat) {
        this.solarHeat = solarHeat;
    }
    /**
     * @return Returns the soleProprietor.
     */
    public boolean isSoleProprietor() {
        return soleProprietor;
    }
    /**
     * @param soleProprietor The soleProprietor to set.
     */
    public void setSoleProprietor(boolean soleProprietor) {
        this.soleProprietor = soleProprietor;
    }
    /**
     * @return Returns the specialCommAgreement.
     */
    public String getSpecialCommAgreement() {
        return specialCommAgreement;
    }
    /**
     * @param specialCommAgreement The specialCommAgreement to set.
     */
    public void setSpecialCommAgreement(String specialCommAgreement) {
        this.specialCommAgreement = specialCommAgreement;
    }
    /**
     * @return Returns the sports.
     */
    public boolean isSports() {
        return sports;
    }
    /**
     * @param sports The sports to set.
     */
    public void setSports(boolean sports) {
        this.sports = sports;
    }
    /**
     * @return Returns the steel.
     */
    public boolean isSteel() {
        return steel;
    }
    /**
     * @param steel The steel to set.
     */
    public void setSteel(boolean steel) {
        this.steel = steel;
    }
    /**
     * @return Returns the stone.
     */
    public boolean isStone() {
        return stone;
    }
    /**
     * @param stone The stone to set.
     */
    public void setStone(boolean stone) {
        this.stone = stone;
    }
    /**
     * @return Returns the storage.
     */
    public boolean isStorage() {
        return storage;
    }
    /**
     * @param storage The storage to set.
     */
    public void setStorage(boolean storage) {
        this.storage = storage;
    }
    /**
     * @return Returns the stucco.
     */
    public boolean isStucco() {
        return stucco;
    }
    /**
     * @param stucco The stucco to set.
     */
    public void setStucco(boolean stucco) {
        this.stucco = stucco;
    }
    /**
     * @return Returns the stuccoBrick.
     */
    public boolean isStuccoBrick() {
        return stuccoBrick;
    }
    /**
     * @param stuccoBrick The stuccoBrick to set.
     */
    public void setStuccoBrick(boolean stuccoBrick) {
        this.stuccoBrick = stuccoBrick;
    }
    /**
     * @return Returns the stuccoWood.
     */
    public boolean isStuccoWood() {
        return stuccoWood;
    }
    /**
     * @param stuccoWood The stuccoWood to set.
     */
    public void setStuccoWood(boolean stuccoWood) {
        this.stuccoWood = stuccoWood;
    }
    /**
     * @return Returns the subjectTo.
     */
    public boolean isSubjectTo() {
        return subjectTo;
    }
    /**
     * @param subjectTo The subjectTo to set.
     */
    public void setSubjectTo(boolean subjectTo) {
        this.subjectTo = subjectTo;
    }
    /**
     * @return Returns the supplies.
     */
    public String getSupplies() {
        return supplies;
    }
    /**
     * @param supplies The supplies to set.
     */
    public void setSupplies(String supplies) {
        this.supplies = supplies;
    }
    /**
     * @return Returns the tanning.
     */
    public boolean isTanning() {
        return tanning;
    }
    /**
     * @param tanning The tanning to set.
     */
    public void setTanning(boolean tanning) {
        this.tanning = tanning;
    }
    /**
     * @return Returns the taxReturn.
     */
    public boolean isTaxReturn() {
        return taxReturn;
    }
    /**
     * @param taxReturn The taxReturn to set.
     */
    public void setTaxReturn(boolean taxReturn) {
        this.taxReturn = taxReturn;
    }
    /**
     * @return Returns the telExp.
     */
    public String getTelExp() {
        return telExp;
    }
    /**
     * @param telExp The telExp to set.
     */
    public void setTelExp(String telExp) {
        this.telExp = telExp;
    }
    /**
     * @return Returns the tile.
     */
    public boolean isTile() {
        return tile;
    }
    /**
     * @param tile The tile to set.
     */
    public void setTile(boolean tile) {
        this.tile = tile;
    }
    /**
     * @return Returns the tiltUp.
     */
    public boolean isTiltUp() {
        return tiltUp;
    }
    /**
     * @param tiltUp The tiltUp to set.
     */
    public void setTiltUp(boolean tiltUp) {
        this.tiltUp = tiltUp;
    }
    /**
     * @return Returns the totalExp.
     */
    public String getTotalExp() {
        return totalExp;
    }
    /**
     * @param totalExp The totalExp to set.
     */
    public void setTotalExp(String totalExp) {
        this.totalExp = totalExp;
    }
    /**
     * @return Returns the totalTax.
     */
    public String getTotalTax() {
        return totalTax;
    }
    /**
     * @param totalTax The totalTax to set.
     */
    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }
    /**
     * @return Returns the transportation.
     */
    public boolean isTransportation() {
        return transportation;
    }
    /**
     * @param transportation The transportation to set.
     */
    public void setTransportation(boolean transportation) {
        this.transportation = transportation;
    }
    /**
     * @return Returns the trash.
     */
    public boolean isTrash() {
        return trash;
    }
    /**
     * @param trash The trash to set.
     */
    public void setTrash(boolean trash) {
        this.trash = trash;
    }
    /**
     * @return Returns the tripleNet.
     */
    public boolean isTripleNet() {
        return tripleNet;
    }
    /**
     * @param tripleNet The tripleNet to set.
     */
    public void setTripleNet(boolean tripleNet) {
        this.tripleNet = tripleNet;
    }
    /**
     * @return Returns the trmOther.
     */
    public boolean isTrmOther() {
        return trmOther;
    }
    /**
     * @param trmOther The trmOther to set.
     */
    public void setTrmOther(boolean trmOther) {
        this.trmOther = trmOther;
    }
    /**
     * @return Returns the utilities.
     */
    public String getUtilities() {
        return utilities;
    }
    /**
     * @param utilities The utilities to set.
     */
    public void setUtilities(String utilities) {
        this.utilities = utilities;
    }
    /**
     * @return Returns the vehicles.
     */
    public String getVehicles() {
        return vehicles;
    }
    /**
     * @param vehicles The vehicles to set.
     */
    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }
    /**
     * @return Returns the virtualTour.
     */
    public String getVirtualTour() {
        return virtualTour;
    }
    /**
     * @param virtualTour The virtualTour to set.
     */
    public void setVirtualTour(String virtualTour) {
        this.virtualTour = virtualTour;
    }
    /**
     * @return Returns the voltage.
     */
    public String getVoltage() {
        return voltage;
    }
    /**
     * @param voltage The voltage to set.
     */
    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }
    /**
     * @return Returns the wallFurnace.
     */
    public boolean isWallFurnace() {
        return wallFurnace;
    }
    /**
     * @param wallFurnace The wallFurnace to set.
     */
    public void setWallFurnace(boolean wallFurnace) {
        this.wallFurnace = wallFurnace;
    }
    /**
     * @return Returns the wholesale.
     */
    public boolean isWholesale() {
        return wholesale;
    }
    /**
     * @param wholesale The wholesale to set.
     */
    public void setWholesale(boolean wholesale) {
        this.wholesale = wholesale;
    }
    /**
     * @return Returns the woodShingle.
     */
    public boolean isWoodShingle() {
        return woodShingle;
    }
    /**
     * @param woodShingle The woodShingle to set.
     */
    public void setWoodShingle(boolean woodShingle) {
        this.woodShingle = woodShingle;
    }
    /**
     * @return Returns the woodStove.
     */
    public boolean isWoodStove() {
        return woodStove;
    }
    /**
     * @param woodStove The woodStove to set.
     */
    public void setWoodStove(boolean woodStove) {
        this.woodStove = woodStove;
    }
    /**
     * @return Returns the zoning.
     */
    public String getZoning() {
        return zoning;
    }
    /**
     * @param zoning The zoning to set.
     */
    public void setZoning(String zoning) {
        this.zoning = zoning;
    }
}

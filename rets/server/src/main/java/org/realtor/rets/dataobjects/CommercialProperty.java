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
public class CommercialProperty extends Property {
    private String term1;
    private boolean signYesNo;
    private String zoning;
    private String asrCode;
    private String requestedDeposit;
    private String downPayment;
    private String requestedPossession;
    private String sca;
    private Date dateAdded;
    private Date modTimestamp;
    private Date photoTimestamp;
    private String parkingCenterName;
    private int numberOfUnits;
    private String numberOfBuildings;
    private String numFloors;
    private String floorsAvailable;
    private String officeNumber;
    private int yearBuilt;
    private int buildingSquareFeet;
    private String imSquareFeetObtainedBy;
    private float squareFootDol;
    private String rentAdj;
    private String loadFactor;
    private String lotSize;
    private String lotFront;
    private String lotDepth;
    private float numAcres;
    private float netAcres;
    private boolean businessDistrict;
    private boolean corner;
    private boolean integereriorBlockCenter;
    private boolean downtown;
    private boolean industrialDistrict;
    private boolean mall;
    private boolean professionalCenter;
    private boolean retailFrontage;
    private boolean shoppingCenter;
    private boolean standAlone;
    private boolean stripStoreCenter;
    private boolean northSideOfStreet;
    private boolean southSideOfStreet;
    private boolean eastSideOfStreet;
    private boolean westSideOfStreet;
    private boolean locationOther;
    private boolean auto;
    private boolean lodging;
    private boolean manufacturing;
    private boolean mixedUse;
    private boolean office;
    private boolean residential;
    private boolean restaurant;
    private boolean retail;
    private boolean service;
    private boolean ctuShoppingCenter;
    private boolean warehouse;
    private boolean wholesale;
    private boolean other;
    private boolean downSlope;
    private boolean hilltop;
    private boolean irregular;
    private boolean level;
    private boolean upSlope;
    private boolean fenceBlock;
    private boolean fenceChainLink;
    private boolean fenceSlumpStone;
    private boolean fenceWood;
    private boolean fenceWroughtIron;
    private boolean fenceBack;
    private boolean fenceFront;
    private boolean fenceCross;
    private boolean fenceOther;
    private boolean fenceNone;
    private boolean foundationSlab;
    private boolean foundationFenceCombination;
    private boolean foundationFenceRaised;
    private boolean foundationOther;
    private boolean stcDirt;
    private boolean stcPaved;
    private boolean stcPrivate;
    private boolean stcPublic;
    private String curbs;
    private String sidewalks;
    private String streetLights;
    private boolean stcOther;
    private boolean parkingAssigned;
    private boolean parkingEmployees;
    private boolean parkingCovered;
    private boolean parkingGated;
    private boolean parkingOpen;
    private boolean parkingPublic;
    private boolean parkingUnassigned;
    private boolean stl1Story;
    private boolean stl2Story;
    private boolean stl3Story;
    private boolean stl4Story;
    private boolean stlSplitLevel;
    private boolean stlUpperLevel;
    private boolean stlLowerLevel;
    private boolean stlOther;
    private boolean roofAsphaltRock;
    private boolean roofCompositionShingle;
    private boolean roofShingle;
    private boolean roofConcreteShake;
    private boolean roofMetal;
    private boolean roofShake;
    private boolean roofTile;
    private boolean roofWoodShingle;
    private boolean roofOther;
    private boolean cableTV;
    private boolean elecIndMeter;
    private boolean elecMasterMeter;
    private boolean publicSewer;
    private boolean sewerPaid;
    private boolean sewerBond;
    private boolean septicTank;
    private boolean naturalGas;
    private boolean propane;
    private boolean gasIndMeter;
    private boolean gasMasterMeter;
    private boolean wellWater;
    private boolean publicWater;
    private boolean waterIndMeter;
    private boolean waterMasterMeter;
    private boolean displayWindow;
    private boolean floorDrain;
    private boolean fireAlarms;
    private boolean fireSprinklers;
    private boolean sftGat;
    private boolean handicappedAccess;
    private boolean integerercomSystem;
    private boolean kitchenFacilities;
    private boolean landscaping;
    private boolean loadingDock;
    private boolean mezzanine;
    private boolean outsideLighting;
    private boolean railroadAccess;
    private boolean rearAccess;
    private boolean restroomsHandicapped;
    private boolean restroomsPublic;
    private boolean securitySystemLeased;
    private boolean securitySystemOwned;
    private boolean skylights;
    private boolean smokeAlarm;
    private boolean storageArea;
    private boolean truckDoors;
    private boolean renewable;
    private boolean transferable;
    private boolean realEstateIncl;
    private boolean percentage;
    private boolean none;
    private String tenimpall;
    private String cbaths;
    private boolean adaCompliant;
    private String numElevators;
    private String afthrs;
    private float parkRatio;
    private String actOcc;
    private float camSquareFeet;
    private int pricePerSquareFoot;
    private float expSquareFeet;
    private int annualGrossIncome;
    private float grossRentMultiplier;
    private float capRate;
    private float vacPercent;
    private int scheduledGrossIncome;
    private String vacColl;
    private String grossOperatingIncome;
    private String lessExpenses;
    private String netOperatingIncome;
    private String lessDebtService;
    private String preTaxFlow;
    private boolean taxReturn;
    private boolean accountantProvided;
    private boolean ownerProvided;
    private boolean projected;
    private boolean limitedInfo;
    private boolean proForma;
    private boolean expNone;
    private String utilities;
    private String payroll;
    private String elevators;
    private String annualInsurance;
    private String accounting;
    private String annualResManagerPay;
    private String annualMiscFee;
    private String repMainteger;
    private String sewer;
    private String supplies;
    private String totalTax;
    private String contSvc;
    private String nonRegManager;
    private String annualRubbishExpense;
    private String advertisingAnnualDollars;
    private String annualLandscape;
    private String repairs;
    private String annualSecurity;
    private String resv;
    private String totExp;
    private String utlcElectric;
    private String utlcGas;
    private String utlcWater;
    private String utlcTrs;
    private String landValue;
    private int pLand;
    private String impvValue;
    private int pImpv;
    private String perpVal;
    private int pPerp;
    private String totVal;
    private int pTotal;
    private String ten1;
    private String tUnit1;
    private String squareFeet1;
    private String rent1;
    private String tunit;
    private String ltype1;
    private float mrate1;
    private float mpass1;
    private String ten2;
    private String tunit2;
    private String squareFeet2;
    private String rent2;
    private String term2;
    private String ltype2;
    private float mrate2;
    private float mpass2;
    private String ten3;
    private String tunit3;
    private String squareFeet3;
    private String rent3;
    private String term3;
    private String ltype3;
    private float mrate3;
    private float mpass3;
    private String ten4;
    private String tunit4;
    private String squareFeet4;
    private String rent4;
    private String term4;
    private String ltype4;
    private float mrate4;
    private float mpass4;
    private String ten5;
    private String tunit5;
    private String squareFeet5;
    private String rent5;
    private String term5;
    private String ltype5;
    private float mrate5;
    private float mpass5;
    private String ten6;
    private String tunit6;
    private String squareFeet6;
    private String rent6;
    private String term6;
    private String ltype6;
    private float mrate6;
    private float mpass6;
    private String voltage;
    private String phase;
    private String amps;
    private String numParking;
    private String ceilingHeight;
    private int warehouseSquareFeet;
    private String ccbBlock;
    private boolean heatAir;
    private boolean ccbBrick;
    private boolean ccbConcrete;
    private boolean ccbFlagstone;
    private boolean ccbFrame;
    private boolean ccbGlass;
    private boolean ccbManufacture;
    private boolean ccbSiding;
    private boolean ccbSteel;
    private boolean ccbStone;
    private boolean ccbStucco;
    private boolean ccbStuccoBrick;
    private boolean ccbStuccoWood;
    private boolean ccbWood;
    private boolean ccbTiltUp;
    private boolean ccbOther;
    private boolean baseboard;
    private boolean centralAirEvap;
    private boolean centralAirRfrg;
    private boolean centralHeatElec;
    private boolean centralHeatGas;
    private boolean floorFurnace;
    private boolean heatPump;
    private boolean cclPropane;
    private boolean radiantHeat;
    private boolean roomEvapAir;
    private boolean roomRefrigAir;
    private boolean solarHeat;
    private boolean wallFurnace;
    private boolean woodStove;
    private boolean cclNone;
    private boolean concurrentClose;
    private boolean courtApproval;
    private boolean cnt1031Exchange;
    private boolean lenderApproval;
    private boolean nodFiled;
    private boolean cntOther;
    private boolean cntNone;
    private boolean aitd;
    private boolean assumWithQual;
    private boolean cash;
    private boolean conventional;
    private boolean exchange;
    private boolean landContract;
    private boolean leaseOption;
    private boolean leasePurchase;
    private boolean ownerWillCarry;
    private boolean ownerWillCarry2nd;
    private boolean subjectTo;
    private boolean sba;
    private boolean sublease;
    private boolean trmOther;
    private boolean apptCallAgent;
    private boolean apptCallListingOffice;
    private boolean apptCallOwner;
    private boolean apptCallTenant;
    private boolean keyboxCallAgent;
    private boolean keyboxCodeRequired;
    private boolean keyboxGoDirect;
    private boolean keyboxCallListingOff;
    private boolean keyboxCallOwner;
    private boolean keyboxSecurityAlarm;
    private boolean keyboxCallTenant;
    private boolean keyboxVacant;
    private boolean keyCallAgent;
    private boolean keyCallListingOff;
    private boolean scdSeeRemarks;
    private boolean sle;
    private boolean rentalLease;
    private boolean bltOffice;
    private boolean industrial;
    private boolean bltRetail;
    private int squareFeet;
    private String squareFeetRnt;
    private String squareFeetUse;
    private String virtualTour;
    private int longitude;
    private float listPricePerSquareFeet;
    private float salePricePerSquareFeet;
    private String companyList;
    private String companySale;
    private int cmaLimitTime;
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
     * @return Returns the actOcc.
     */
    public String getActOcc() {
        return actOcc;
    }
    /**
     * @param actOcc The actOcc to set.
     */
    public void setActOcc(String actOcc) {
        this.actOcc = actOcc;
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
     * @return Returns the afthrs.
     */
    public String getAfthrs() {
        return afthrs;
    }
    /**
     * @param afthrs The afthrs to set.
     */
    public void setAfthrs(String afthrs) {
        this.afthrs = afthrs;
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
     * @return Returns the annualGrossIncome.
     */
    public int getAnnualGrossIncome() {
        return annualGrossIncome;
    }
    /**
     * @param annualGrossIncome The annualGrossIncome to set.
     */
    public void setAnnualGrossIncome(int annualGrossIncome) {
        this.annualGrossIncome = annualGrossIncome;
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
     * @return Returns the annualLandscape.
     */
    public String getAnnualLandscape() {
        return annualLandscape;
    }
    /**
     * @param annualLandscape The annualLandscape to set.
     */
    public void setAnnualLandscape(String annualLandscape) {
        this.annualLandscape = annualLandscape;
    }
    /**
     * @return Returns the annualMiscFee.
     */
    public String getAnnualMiscFee() {
        return annualMiscFee;
    }
    /**
     * @param annualMiscFee The annualMiscFee to set.
     */
    public void setAnnualMiscFee(String annualMiscFee) {
        this.annualMiscFee = annualMiscFee;
    }
    /**
     * @return Returns the annualResManagerPay.
     */
    public String getAnnualResManagerPay() {
        return annualResManagerPay;
    }
    /**
     * @param annualResManagerPay The annualResManagerPay to set.
     */
    public void setAnnualResManagerPay(String annualResManagerPay) {
        this.annualResManagerPay = annualResManagerPay;
    }
    /**
     * @return Returns the annualRubbishExpense.
     */
    public String getAnnualRubbishExpense() {
        return annualRubbishExpense;
    }
    /**
     * @param annualRubbishExpense The annualRubbishExpense to set.
     */
    public void setAnnualRubbishExpense(String annualRubbishExpense) {
        this.annualRubbishExpense = annualRubbishExpense;
    }
    /**
     * @return Returns the annualSecurity.
     */
    public String getAnnualSecurity() {
        return annualSecurity;
    }
    /**
     * @param annualSecurity The annualSecurity to set.
     */
    public void setAnnualSecurity(String annualSecurity) {
        this.annualSecurity = annualSecurity;
    }
    /**
     * @return Returns the apptCallAgent.
     */
    public boolean isApptCallAgent() {
        return apptCallAgent;
    }
    /**
     * @param apptCallAgent The apptCallAgent to set.
     */
    public void setApptCallAgent(boolean apptCallAgent) {
        this.apptCallAgent = apptCallAgent;
    }
    /**
     * @return Returns the apptCallListingOffice.
     */
    public boolean isApptCallListingOffice() {
        return apptCallListingOffice;
    }
    /**
     * @param apptCallListingOffice The apptCallListingOffice to set.
     */
    public void setApptCallListingOffice(boolean apptCallListingOffice) {
        this.apptCallListingOffice = apptCallListingOffice;
    }
    /**
     * @return Returns the apptCallOwner.
     */
    public boolean isApptCallOwner() {
        return apptCallOwner;
    }
    /**
     * @param apptCallOwner The apptCallOwner to set.
     */
    public void setApptCallOwner(boolean apptCallOwner) {
        this.apptCallOwner = apptCallOwner;
    }
    /**
     * @return Returns the apptCallTenant.
     */
    public boolean isApptCallTenant() {
        return apptCallTenant;
    }
    /**
     * @param apptCallTenant The apptCallTenant to set.
     */
    public void setApptCallTenant(boolean apptCallTenant) {
        this.apptCallTenant = apptCallTenant;
    }
    /**
     * @return Returns the asrCode.
     */
    public String getAsrCode() {
        return asrCode;
    }
    /**
     * @param asrCode The asrCode to set.
     */
    public void setAsrCode(String asrCode) {
        this.asrCode = asrCode;
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
     * @return Returns the auto.
     */
    public boolean isAuto() {
        return auto;
    }
    /**
     * @param auto The auto to set.
     */
    public void setAuto(boolean auto) {
        this.auto = auto;
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
     * @return Returns the bltOffice.
     */
    public boolean isBltOffice() {
        return bltOffice;
    }
    /**
     * @param bltOffice The bltOffice to set.
     */
    public void setBltOffice(boolean bltOffice) {
        this.bltOffice = bltOffice;
    }
    /**
     * @return Returns the bltRetail.
     */
    public boolean isBltRetail() {
        return bltRetail;
    }
    /**
     * @param bltRetail The bltRetail to set.
     */
    public void setBltRetail(boolean bltRetail) {
        this.bltRetail = bltRetail;
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
     * @return Returns the businessDistrict.
     */
    public boolean isBusinessDistrict() {
        return businessDistrict;
    }
    /**
     * @param businessDistrict The businessDistrict to set.
     */
    public void setBusinessDistrict(boolean businessDistrict) {
        this.businessDistrict = businessDistrict;
    }
    /**
     * @return Returns the cableTV.
     */
    public boolean isCableTV() {
        return cableTV;
    }
    /**
     * @param cableTV The cableTV to set.
     */
    public void setCableTV(boolean cableTV) {
        this.cableTV = cableTV;
    }
    /**
     * @return Returns the camSquareFeet.
     */
    public float getCamSquareFeet() {
        return camSquareFeet;
    }
    /**
     * @param camSquareFeet The camSquareFeet to set.
     */
    public void setCamSquareFeet(float camSquareFeet) {
        this.camSquareFeet = camSquareFeet;
    }
    /**
     * @return Returns the capRate.
     */
    public float getCapRate() {
        return capRate;
    }
    /**
     * @param capRate The capRate to set.
     */
    public void setCapRate(float capRate) {
        this.capRate = capRate;
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
     * @return Returns the cbaths.
     */
    public String getCbaths() {
        return cbaths;
    }
    /**
     * @param cbaths The cbaths to set.
     */
    public void setCbaths(String cbaths) {
        this.cbaths = cbaths;
    }
    /**
     * @return Returns the ccbBlock.
     */
    public String getCcbBlock() {
        return ccbBlock;
    }
    /**
     * @param ccbBlock The ccbBlock to set.
     */
    public void setCcbBlock(String ccbBlock) {
        this.ccbBlock = ccbBlock;
    }
    /**
     * @return Returns the ccbBrick.
     */
    public boolean isCcbBrick() {
        return ccbBrick;
    }
    /**
     * @param ccbBrick The ccbBrick to set.
     */
    public void setCcbBrick(boolean ccbBrick) {
        this.ccbBrick = ccbBrick;
    }
    /**
     * @return Returns the ccbConcrete.
     */
    public boolean isCcbConcrete() {
        return ccbConcrete;
    }
    /**
     * @param ccbConcrete The ccbConcrete to set.
     */
    public void setCcbConcrete(boolean ccbConcrete) {
        this.ccbConcrete = ccbConcrete;
    }
    /**
     * @return Returns the ccbFlagstone.
     */
    public boolean isCcbFlagstone() {
        return ccbFlagstone;
    }
    /**
     * @param ccbFlagstone The ccbFlagstone to set.
     */
    public void setCcbFlagstone(boolean ccbFlagstone) {
        this.ccbFlagstone = ccbFlagstone;
    }
    /**
     * @return Returns the ccbFrame.
     */
    public boolean isCcbFrame() {
        return ccbFrame;
    }
    /**
     * @param ccbFrame The ccbFrame to set.
     */
    public void setCcbFrame(boolean ccbFrame) {
        this.ccbFrame = ccbFrame;
    }
    /**
     * @return Returns the ccbGlass.
     */
    public boolean isCcbGlass() {
        return ccbGlass;
    }
    /**
     * @param ccbGlass The ccbGlass to set.
     */
    public void setCcbGlass(boolean ccbGlass) {
        this.ccbGlass = ccbGlass;
    }
    /**
     * @return Returns the ccbManufacture.
     */
    public boolean isCcbManufacture() {
        return ccbManufacture;
    }
    /**
     * @param ccbManufacture The ccbManufacture to set.
     */
    public void setCcbManufacture(boolean ccbManufacture) {
        this.ccbManufacture = ccbManufacture;
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
     * @return Returns the ccbSiding.
     */
    public boolean isCcbSiding() {
        return ccbSiding;
    }
    /**
     * @param ccbSiding The ccbSiding to set.
     */
    public void setCcbSiding(boolean ccbSiding) {
        this.ccbSiding = ccbSiding;
    }
    /**
     * @return Returns the ccbSteel.
     */
    public boolean isCcbSteel() {
        return ccbSteel;
    }
    /**
     * @param ccbSteel The ccbSteel to set.
     */
    public void setCcbSteel(boolean ccbSteel) {
        this.ccbSteel = ccbSteel;
    }
    /**
     * @return Returns the ccbStone.
     */
    public boolean isCcbStone() {
        return ccbStone;
    }
    /**
     * @param ccbStone The ccbStone to set.
     */
    public void setCcbStone(boolean ccbStone) {
        this.ccbStone = ccbStone;
    }
    /**
     * @return Returns the ccbStucco.
     */
    public boolean isCcbStucco() {
        return ccbStucco;
    }
    /**
     * @param ccbStucco The ccbStucco to set.
     */
    public void setCcbStucco(boolean ccbStucco) {
        this.ccbStucco = ccbStucco;
    }
    /**
     * @return Returns the ccbStuccoBrick.
     */
    public boolean isCcbStuccoBrick() {
        return ccbStuccoBrick;
    }
    /**
     * @param ccbStuccoBrick The ccbStuccoBrick to set.
     */
    public void setCcbStuccoBrick(boolean ccbStuccoBrick) {
        this.ccbStuccoBrick = ccbStuccoBrick;
    }
    /**
     * @return Returns the ccbStuccoWood.
     */
    public boolean isCcbStuccoWood() {
        return ccbStuccoWood;
    }
    /**
     * @param ccbStuccoWood The ccbStuccoWood to set.
     */
    public void setCcbStuccoWood(boolean ccbStuccoWood) {
        this.ccbStuccoWood = ccbStuccoWood;
    }
    /**
     * @return Returns the ccbTiltUp.
     */
    public boolean isCcbTiltUp() {
        return ccbTiltUp;
    }
    /**
     * @param ccbTiltUp The ccbTiltUp to set.
     */
    public void setCcbTiltUp(boolean ccbTiltUp) {
        this.ccbTiltUp = ccbTiltUp;
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
     * @return Returns the cclPropane.
     */
    public boolean isCclPropane() {
        return cclPropane;
    }
    /**
     * @param cclPropane The cclPropane to set.
     */
    public void setCclPropane(boolean cclPropane) {
        this.cclPropane = cclPropane;
    }
    /**
     * @return Returns the ceilingHeight.
     */
    public String getCeilingHeight() {
        return ceilingHeight;
    }
    /**
     * @param ceilingHeight The ceilingHeight to set.
     */
    public void setCeilingHeight(String ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
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
     * @return Returns the centralAirRfrg.
     */
    public boolean isCentralAirRfrg() {
        return centralAirRfrg;
    }
    /**
     * @param centralAirRfrg The centralAirRfrg to set.
     */
    public void setCentralAirRfrg(boolean centralAirRfrg) {
        this.centralAirRfrg = centralAirRfrg;
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
     * @return Returns the cmaLimitTime.
     */
    public int getCmaLimitTime() {
        return cmaLimitTime;
    }
    /**
     * @param cmaLimitTime The cmaLimitTime to set.
     */
    public void setCmaLimitTime(int cmaLimitTime) {
        this.cmaLimitTime = cmaLimitTime;
    }
    /**
     * @return Returns the cnt1031Exchange.
     */
    public boolean isCnt1031Exchange() {
        return cnt1031Exchange;
    }
    /**
     * @param cnt1031Exchange The cnt1031Exchange to set.
     */
    public void setCnt1031Exchange(boolean cnt1031Exchange) {
        this.cnt1031Exchange = cnt1031Exchange;
    }
    /**
     * @return Returns the cntNone.
     */
    public boolean isCntNone() {
        return cntNone;
    }
    /**
     * @param cntNone The cntNone to set.
     */
    public void setCntNone(boolean cntNone) {
        this.cntNone = cntNone;
    }
    /**
     * @return Returns the cntOther.
     */
    public boolean isCntOther() {
        return cntOther;
    }
    /**
     * @param cntOther The cntOther to set.
     */
    public void setCntOther(boolean cntOther) {
        this.cntOther = cntOther;
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
     * @return Returns the concurrentClose.
     */
    public boolean isConcurrentClose() {
        return concurrentClose;
    }
    /**
     * @param concurrentClose The concurrentClose to set.
     */
    public void setConcurrentClose(boolean concurrentClose) {
        this.concurrentClose = concurrentClose;
    }
    /**
     * @return Returns the contSvc.
     */
    public String getContSvc() {
        return contSvc;
    }
    /**
     * @param contSvc The contSvc to set.
     */
    public void setContSvc(String contSvc) {
        this.contSvc = contSvc;
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
     * @return Returns the corner.
     */
    public boolean isCorner() {
        return corner;
    }
    /**
     * @param corner The corner to set.
     */
    public void setCorner(boolean corner) {
        this.corner = corner;
    }
    /**
     * @return Returns the courtApproval.
     */
    public boolean isCourtApproval() {
        return courtApproval;
    }
    /**
     * @param courtApproval The courtApproval to set.
     */
    public void setCourtApproval(boolean courtApproval) {
        this.courtApproval = courtApproval;
    }
    /**
     * @return Returns the ctuShoppingCenter.
     */
    public boolean isCtuShoppingCenter() {
        return ctuShoppingCenter;
    }
    /**
     * @param ctuShoppingCenter The ctuShoppingCenter to set.
     */
    public void setCtuShoppingCenter(boolean ctuShoppingCenter) {
        this.ctuShoppingCenter = ctuShoppingCenter;
    }
    /**
     * @return Returns the curbs.
     */
    public String getCurbs() {
        return curbs;
    }
    /**
     * @param curbs The curbs to set.
     */
    public void setCurbs(String curbs) {
        this.curbs = curbs;
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
     * @return Returns the displayWindow.
     */
    public boolean isDisplayWindow() {
        return displayWindow;
    }
    /**
     * @param displayWindow The displayWindow to set.
     */
    public void setDisplayWindow(boolean displayWindow) {
        this.displayWindow = displayWindow;
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
     * @return Returns the downSlope.
     */
    public boolean isDownSlope() {
        return downSlope;
    }
    /**
     * @param downSlope The downSlope to set.
     */
    public void setDownSlope(boolean downSlope) {
        this.downSlope = downSlope;
    }
    /**
     * @return Returns the downtown.
     */
    public boolean isDowntown() {
        return downtown;
    }
    /**
     * @param downtown The downtown to set.
     */
    public void setDowntown(boolean downtown) {
        this.downtown = downtown;
    }
    /**
     * @return Returns the eastSideOfStreet.
     */
    public boolean isEastSideOfStreet() {
        return eastSideOfStreet;
    }
    /**
     * @param eastSideOfStreet The eastSideOfStreet to set.
     */
    public void setEastSideOfStreet(boolean eastSideOfStreet) {
        this.eastSideOfStreet = eastSideOfStreet;
    }
    /**
     * @return Returns the elecIndMeter.
     */
    public boolean isElecIndMeter() {
        return elecIndMeter;
    }
    /**
     * @param elecIndMeter The elecIndMeter to set.
     */
    public void setElecIndMeter(boolean elecIndMeter) {
        this.elecIndMeter = elecIndMeter;
    }
    /**
     * @return Returns the elecMasterMeter.
     */
    public boolean isElecMasterMeter() {
        return elecMasterMeter;
    }
    /**
     * @param elecMasterMeter The elecMasterMeter to set.
     */
    public void setElecMasterMeter(boolean elecMasterMeter) {
        this.elecMasterMeter = elecMasterMeter;
    }
    /**
     * @return Returns the elevators.
     */
    public String getElevators() {
        return elevators;
    }
    /**
     * @param elevators The elevators to set.
     */
    public void setElevators(String elevators) {
        this.elevators = elevators;
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
     * @return Returns the expSquareFeet.
     */
    public float getExpSquareFeet() {
        return expSquareFeet;
    }
    /**
     * @param expSquareFeet The expSquareFeet to set.
     */
    public void setExpSquareFeet(float expSquareFeet) {
        this.expSquareFeet = expSquareFeet;
    }
    /**
     * @return Returns the fenceBack.
     */
    public boolean isFenceBack() {
        return fenceBack;
    }
    /**
     * @param fenceBack The fenceBack to set.
     */
    public void setFenceBack(boolean fenceBack) {
        this.fenceBack = fenceBack;
    }
    /**
     * @return Returns the fenceBlock.
     */
    public boolean isFenceBlock() {
        return fenceBlock;
    }
    /**
     * @param fenceBlock The fenceBlock to set.
     */
    public void setFenceBlock(boolean fenceBlock) {
        this.fenceBlock = fenceBlock;
    }
    /**
     * @return Returns the fenceChainLink.
     */
    public boolean isFenceChainLink() {
        return fenceChainLink;
    }
    /**
     * @param fenceChainLink The fenceChainLink to set.
     */
    public void setFenceChainLink(boolean fenceChainLink) {
        this.fenceChainLink = fenceChainLink;
    }
    /**
     * @return Returns the fenceCross.
     */
    public boolean isFenceCross() {
        return fenceCross;
    }
    /**
     * @param fenceCross The fenceCross to set.
     */
    public void setFenceCross(boolean fenceCross) {
        this.fenceCross = fenceCross;
    }
    /**
     * @return Returns the fenceFront.
     */
    public boolean isFenceFront() {
        return fenceFront;
    }
    /**
     * @param fenceFront The fenceFront to set.
     */
    public void setFenceFront(boolean fenceFront) {
        this.fenceFront = fenceFront;
    }
    /**
     * @return Returns the fenceNone.
     */
    public boolean isFenceNone() {
        return fenceNone;
    }
    /**
     * @param fenceNone The fenceNone to set.
     */
    public void setFenceNone(boolean fenceNone) {
        this.fenceNone = fenceNone;
    }
    /**
     * @return Returns the fenceOther.
     */
    public boolean isFenceOther() {
        return fenceOther;
    }
    /**
     * @param fenceOther The fenceOther to set.
     */
    public void setFenceOther(boolean fenceOther) {
        this.fenceOther = fenceOther;
    }
    /**
     * @return Returns the fenceSlumpStone.
     */
    public boolean isFenceSlumpStone() {
        return fenceSlumpStone;
    }
    /**
     * @param fenceSlumpStone The fenceSlumpStone to set.
     */
    public void setFenceSlumpStone(boolean fenceSlumpStone) {
        this.fenceSlumpStone = fenceSlumpStone;
    }
    /**
     * @return Returns the fenceWood.
     */
    public boolean isFenceWood() {
        return fenceWood;
    }
    /**
     * @param fenceWood The fenceWood to set.
     */
    public void setFenceWood(boolean fenceWood) {
        this.fenceWood = fenceWood;
    }
    /**
     * @return Returns the fenceWroughtIron.
     */
    public boolean isFenceWroughtIron() {
        return fenceWroughtIron;
    }
    /**
     * @param fenceWroughtIron The fenceWroughtIron to set.
     */
    public void setFenceWroughtIron(boolean fenceWroughtIron) {
        this.fenceWroughtIron = fenceWroughtIron;
    }
    /**
     * @return Returns the fireAlarms.
     */
    public boolean isFireAlarms() {
        return fireAlarms;
    }
    /**
     * @param fireAlarms The fireAlarms to set.
     */
    public void setFireAlarms(boolean fireAlarms) {
        this.fireAlarms = fireAlarms;
    }
    /**
     * @return Returns the fireSprinklers.
     */
    public boolean isFireSprinklers() {
        return fireSprinklers;
    }
    /**
     * @param fireSprinklers The fireSprinklers to set.
     */
    public void setFireSprinklers(boolean fireSprinklers) {
        this.fireSprinklers = fireSprinklers;
    }
    /**
     * @return Returns the floorDrain.
     */
    public boolean isFloorDrain() {
        return floorDrain;
    }
    /**
     * @param floorDrain The floorDrain to set.
     */
    public void setFloorDrain(boolean floorDrain) {
        this.floorDrain = floorDrain;
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
     * @return Returns the floorsAvailable.
     */
    public String getFloorsAvailable() {
        return floorsAvailable;
    }
    /**
     * @param floorsAvailable The floorsAvailable to set.
     */
    public void setFloorsAvailable(String floorsAvailable) {
        this.floorsAvailable = floorsAvailable;
    }
    /**
     * @return Returns the foundationFenceCombination.
     */
    public boolean isFoundationFenceCombination() {
        return foundationFenceCombination;
    }
    /**
     * @param foundationFenceCombination The foundationFenceCombination to set.
     */
    public void setFoundationFenceCombination(boolean foundationFenceCombination) {
        this.foundationFenceCombination = foundationFenceCombination;
    }
    /**
     * @return Returns the foundationFenceRaised.
     */
    public boolean isFoundationFenceRaised() {
        return foundationFenceRaised;
    }
    /**
     * @param foundationFenceRaised The foundationFenceRaised to set.
     */
    public void setFoundationFenceRaised(boolean foundationFenceRaised) {
        this.foundationFenceRaised = foundationFenceRaised;
    }
    /**
     * @return Returns the foundationOther.
     */
    public boolean isFoundationOther() {
        return foundationOther;
    }
    /**
     * @param foundationOther The foundationOther to set.
     */
    public void setFoundationOther(boolean foundationOther) {
        this.foundationOther = foundationOther;
    }
    /**
     * @return Returns the foundationSlab.
     */
    public boolean isFoundationSlab() {
        return foundationSlab;
    }
    /**
     * @param foundationSlab The foundationSlab to set.
     */
    public void setFoundationSlab(boolean foundationSlab) {
        this.foundationSlab = foundationSlab;
    }
    /**
     * @return Returns the gasIndMeter.
     */
    public boolean isGasIndMeter() {
        return gasIndMeter;
    }
    /**
     * @param gasIndMeter The gasIndMeter to set.
     */
    public void setGasIndMeter(boolean gasIndMeter) {
        this.gasIndMeter = gasIndMeter;
    }
    /**
     * @return Returns the gasMasterMeter.
     */
    public boolean isGasMasterMeter() {
        return gasMasterMeter;
    }
    /**
     * @param gasMasterMeter The gasMasterMeter to set.
     */
    public void setGasMasterMeter(boolean gasMasterMeter) {
        this.gasMasterMeter = gasMasterMeter;
    }
    /**
     * @return Returns the grossOperatingIncome.
     */
    public String getGrossOperatingIncome() {
        return grossOperatingIncome;
    }
    /**
     * @param grossOperatingIncome The grossOperatingIncome to set.
     */
    public void setGrossOperatingIncome(String grossOperatingIncome) {
        this.grossOperatingIncome = grossOperatingIncome;
    }
    /**
     * @return Returns the grossRentMultiplier.
     */
    public float getGrossRentMultiplier() {
        return grossRentMultiplier;
    }
    /**
     * @param grossRentMultiplier The grossRentMultiplier to set.
     */
    public void setGrossRentMultiplier(float grossRentMultiplier) {
        this.grossRentMultiplier = grossRentMultiplier;
    }
    /**
     * @return Returns the handicappedAccess.
     */
    public boolean isHandicappedAccess() {
        return handicappedAccess;
    }
    /**
     * @param handicappedAccess The handicappedAccess to set.
     */
    public void setHandicappedAccess(boolean handicappedAccess) {
        this.handicappedAccess = handicappedAccess;
    }
    /**
     * @return Returns the heatAir.
     */
    public boolean isHeatAir() {
        return heatAir;
    }
    /**
     * @param heatAir The heatAir to set.
     */
    public void setHeatAir(boolean heatAir) {
        this.heatAir = heatAir;
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
     * @return Returns the hilltop.
     */
    public boolean isHilltop() {
        return hilltop;
    }
    /**
     * @param hilltop The hilltop to set.
     */
    public void setHilltop(boolean hilltop) {
        this.hilltop = hilltop;
    }
    /**
     * @return Returns the impvValue.
     */
    public String getImpvValue() {
        return impvValue;
    }
    /**
     * @param impvValue The impvValue to set.
     */
    public void setImpvValue(String impvValue) {
        this.impvValue = impvValue;
    }
    /**
     * @return Returns the imSquareFeetObtainedBy.
     */
    public String getImSquareFeetObtainedBy() {
        return imSquareFeetObtainedBy;
    }
    /**
     * @param imSquareFeetObtainedBy The imSquareFeetObtainedBy to set.
     */
    public void setImSquareFeetObtainedBy(String imSquareFeetObtainedBy) {
        this.imSquareFeetObtainedBy = imSquareFeetObtainedBy;
    }
    /**
     * @return Returns the industrial.
     */
    public boolean isIndustrial() {
        return industrial;
    }
    /**
     * @param industrial The industrial to set.
     */
    public void setIndustrial(boolean industrial) {
        this.industrial = industrial;
    }
    /**
     * @return Returns the industrialDistrict.
     */
    public boolean isIndustrialDistrict() {
        return industrialDistrict;
    }
    /**
     * @param industrialDistrict The industrialDistrict to set.
     */
    public void setIndustrialDistrict(boolean industrialDistrict) {
        this.industrialDistrict = industrialDistrict;
    }
    /**
     * @return Returns the integerercomSystem.
     */
    public boolean isIntegerercomSystem() {
        return integerercomSystem;
    }
    /**
     * @param integerercomSystem The integerercomSystem to set.
     */
    public void setIntegerercomSystem(boolean integerercomSystem) {
        this.integerercomSystem = integerercomSystem;
    }
    /**
     * @return Returns the integereriorBlockCenter.
     */
    public boolean isIntegereriorBlockCenter() {
        return integereriorBlockCenter;
    }
    /**
     * @param integereriorBlockCenter The integereriorBlockCenter to set.
     */
    public void setIntegereriorBlockCenter(boolean integereriorBlockCenter) {
        this.integereriorBlockCenter = integereriorBlockCenter;
    }
    /**
     * @return Returns the irregular.
     */
    public boolean isIrregular() {
        return irregular;
    }
    /**
     * @param irregular The irregular to set.
     */
    public void setIrregular(boolean irregular) {
        this.irregular = irregular;
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
     * @return Returns the kitchenFacilities.
     */
    public boolean isKitchenFacilities() {
        return kitchenFacilities;
    }
    /**
     * @param kitchenFacilities The kitchenFacilities to set.
     */
    public void setKitchenFacilities(boolean kitchenFacilities) {
        this.kitchenFacilities = kitchenFacilities;
    }
    /**
     * @return Returns the landContract.
     */
    public boolean isLandContract() {
        return landContract;
    }
    /**
     * @param landContract The landContract to set.
     */
    public void setLandContract(boolean landContract) {
        this.landContract = landContract;
    }
    /**
     * @return Returns the landscaping.
     */
    public boolean isLandscaping() {
        return landscaping;
    }
    /**
     * @param landscaping The landscaping to set.
     */
    public void setLandscaping(boolean landscaping) {
        this.landscaping = landscaping;
    }
    /**
     * @return Returns the landValue.
     */
    public String getLandValue() {
        return landValue;
    }
    /**
     * @param landValue The landValue to set.
     */
    public void setLandValue(String landValue) {
        this.landValue = landValue;
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
     * @return Returns the lenderApproval.
     */
    public boolean isLenderApproval() {
        return lenderApproval;
    }
    /**
     * @param lenderApproval The lenderApproval to set.
     */
    public void setLenderApproval(boolean lenderApproval) {
        this.lenderApproval = lenderApproval;
    }
    /**
     * @return Returns the lessDebtService.
     */
    public String getLessDebtService() {
        return lessDebtService;
    }
    /**
     * @param lessDebtService The lessDebtService to set.
     */
    public void setLessDebtService(String lessDebtService) {
        this.lessDebtService = lessDebtService;
    }
    /**
     * @return Returns the lessExpenses.
     */
    public String getLessExpenses() {
        return lessExpenses;
    }
    /**
     * @param lessExpenses The lessExpenses to set.
     */
    public void setLessExpenses(String lessExpenses) {
        this.lessExpenses = lessExpenses;
    }
    /**
     * @return Returns the level.
     */
    public boolean isLevel() {
        return level;
    }
    /**
     * @param level The level to set.
     */
    public void setLevel(boolean level) {
        this.level = level;
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
     * @return Returns the listPricePerSquareFeet.
     */
    public float getListPricePerSquareFeet() {
        return listPricePerSquareFeet;
    }
    /**
     * @param listPricePerSquareFeet The listPricePerSquareFeet to set.
     */
    public void setListPricePerSquareFeet(float listPricePerSquareFeet) {
        this.listPricePerSquareFeet = listPricePerSquareFeet;
    }
    /**
     * @return Returns the loadFactor.
     */
    public String getLoadFactor() {
        return loadFactor;
    }
    /**
     * @param loadFactor The loadFactor to set.
     */
    public void setLoadFactor(String loadFactor) {
        this.loadFactor = loadFactor;
    }
    /**
     * @return Returns the loadingDock.
     */
    public boolean isLoadingDock() {
        return loadingDock;
    }
    /**
     * @param loadingDock The loadingDock to set.
     */
    public void setLoadingDock(boolean loadingDock) {
        this.loadingDock = loadingDock;
    }
    /**
     * @return Returns the locationOther.
     */
    public boolean isLocationOther() {
        return locationOther;
    }
    /**
     * @param locationOther The locationOther to set.
     */
    public void setLocationOther(boolean locationOther) {
        this.locationOther = locationOther;
    }
    /**
     * @return Returns the lodging.
     */
    public boolean isLodging() {
        return lodging;
    }
    /**
     * @param lodging The lodging to set.
     */
    public void setLodging(boolean lodging) {
        this.lodging = lodging;
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
     * @return Returns the lotDepth.
     */
    public String getLotDepth() {
        return lotDepth;
    }
    /**
     * @param lotDepth The lotDepth to set.
     */
    public void setLotDepth(String lotDepth) {
        this.lotDepth = lotDepth;
    }
    /**
     * @return Returns the lotFront.
     */
    public String getLotFront() {
        return lotFront;
    }
    /**
     * @param lotFront The lotFront to set.
     */
    public void setLotFront(String lotFront) {
        this.lotFront = lotFront;
    }
    /**
     * @return Returns the lotSize.
     */
    public String getLotSize() {
        return lotSize;
    }
    /**
     * @param lotSize The lotSize to set.
     */
    public void setLotSize(String lotSize) {
        this.lotSize = lotSize;
    }
    /**
     * @return Returns the ltype1.
     */
    public String getLtype1() {
        return ltype1;
    }
    /**
     * @param ltype1 The ltype1 to set.
     */
    public void setLtype1(String ltype1) {
        this.ltype1 = ltype1;
    }
    /**
     * @return Returns the ltype2.
     */
    public String getLtype2() {
        return ltype2;
    }
    /**
     * @param ltype2 The ltype2 to set.
     */
    public void setLtype2(String ltype2) {
        this.ltype2 = ltype2;
    }
    /**
     * @return Returns the ltype3.
     */
    public String getLtype3() {
        return ltype3;
    }
    /**
     * @param ltype3 The ltype3 to set.
     */
    public void setLtype3(String ltype3) {
        this.ltype3 = ltype3;
    }
    /**
     * @return Returns the ltype4.
     */
    public String getLtype4() {
        return ltype4;
    }
    /**
     * @param ltype4 The ltype4 to set.
     */
    public void setLtype4(String ltype4) {
        this.ltype4 = ltype4;
    }
    /**
     * @return Returns the ltype5.
     */
    public String getLtype5() {
        return ltype5;
    }
    /**
     * @param ltype5 The ltype5 to set.
     */
    public void setLtype5(String ltype5) {
        this.ltype5 = ltype5;
    }
    /**
     * @return Returns the ltype6.
     */
    public String getLtype6() {
        return ltype6;
    }
    /**
     * @param ltype6 The ltype6 to set.
     */
    public void setLtype6(String ltype6) {
        this.ltype6 = ltype6;
    }
    /**
     * @return Returns the mall.
     */
    public boolean isMall() {
        return mall;
    }
    /**
     * @param mall The mall to set.
     */
    public void setMall(boolean mall) {
        this.mall = mall;
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
     * @return Returns the mezzanine.
     */
    public boolean isMezzanine() {
        return mezzanine;
    }
    /**
     * @param mezzanine The mezzanine to set.
     */
    public void setMezzanine(boolean mezzanine) {
        this.mezzanine = mezzanine;
    }
    /**
     * @return Returns the mixedUse.
     */
    public boolean isMixedUse() {
        return mixedUse;
    }
    /**
     * @param mixedUse The mixedUse to set.
     */
    public void setMixedUse(boolean mixedUse) {
        this.mixedUse = mixedUse;
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
     * @return Returns the mpass1.
     */
    public float getMpass1() {
        return mpass1;
    }
    /**
     * @param mpass1 The mpass1 to set.
     */
    public void setMpass1(float mpass1) {
        this.mpass1 = mpass1;
    }
    /**
     * @return Returns the mpass2.
     */
    public float getMpass2() {
        return mpass2;
    }
    /**
     * @param mpass2 The mpass2 to set.
     */
    public void setMpass2(float mpass2) {
        this.mpass2 = mpass2;
    }
    /**
     * @return Returns the mpass3.
     */
    public float getMpass3() {
        return mpass3;
    }
    /**
     * @param mpass3 The mpass3 to set.
     */
    public void setMpass3(float mpass3) {
        this.mpass3 = mpass3;
    }
    /**
     * @return Returns the mpass4.
     */
    public float getMpass4() {
        return mpass4;
    }
    /**
     * @param mpass4 The mpass4 to set.
     */
    public void setMpass4(float mpass4) {
        this.mpass4 = mpass4;
    }
    /**
     * @return Returns the mpass5.
     */
    public float getMpass5() {
        return mpass5;
    }
    /**
     * @param mpass5 The mpass5 to set.
     */
    public void setMpass5(float mpass5) {
        this.mpass5 = mpass5;
    }
    /**
     * @return Returns the mpass6.
     */
    public float getMpass6() {
        return mpass6;
    }
    /**
     * @param mpass6 The mpass6 to set.
     */
    public void setMpass6(float mpass6) {
        this.mpass6 = mpass6;
    }
    /**
     * @return Returns the mrate1.
     */
    public float getMrate1() {
        return mrate1;
    }
    /**
     * @param mrate1 The mrate1 to set.
     */
    public void setMrate1(float mrate1) {
        this.mrate1 = mrate1;
    }
    /**
     * @return Returns the mrate2.
     */
    public float getMrate2() {
        return mrate2;
    }
    /**
     * @param mrate2 The mrate2 to set.
     */
    public void setMrate2(float mrate2) {
        this.mrate2 = mrate2;
    }
    /**
     * @return Returns the mrate3.
     */
    public float getMrate3() {
        return mrate3;
    }
    /**
     * @param mrate3 The mrate3 to set.
     */
    public void setMrate3(float mrate3) {
        this.mrate3 = mrate3;
    }
    /**
     * @return Returns the mrate4.
     */
    public float getMrate4() {
        return mrate4;
    }
    /**
     * @param mrate4 The mrate4 to set.
     */
    public void setMrate4(float mrate4) {
        this.mrate4 = mrate4;
    }
    /**
     * @return Returns the mrate5.
     */
    public float getMrate5() {
        return mrate5;
    }
    /**
     * @param mrate5 The mrate5 to set.
     */
    public void setMrate5(float mrate5) {
        this.mrate5 = mrate5;
    }
    /**
     * @return Returns the mrate6.
     */
    public float getMrate6() {
        return mrate6;
    }
    /**
     * @param mrate6 The mrate6 to set.
     */
    public void setMrate6(float mrate6) {
        this.mrate6 = mrate6;
    }
    /**
     * @return Returns the naturalGas.
     */
    public boolean isNaturalGas() {
        return naturalGas;
    }
    /**
     * @param naturalGas The naturalGas to set.
     */
    public void setNaturalGas(boolean naturalGas) {
        this.naturalGas = naturalGas;
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
     * @return Returns the netOperatingIncome.
     */
    public String getNetOperatingIncome() {
        return netOperatingIncome;
    }
    /**
     * @param netOperatingIncome The netOperatingIncome to set.
     */
    public void setNetOperatingIncome(String netOperatingIncome) {
        this.netOperatingIncome = netOperatingIncome;
    }
    /**
     * @return Returns the nodFiled.
     */
    public boolean isNodFiled() {
        return nodFiled;
    }
    /**
     * @param nodFiled The nodFiled to set.
     */
    public void setNodFiled(boolean nodFiled) {
        this.nodFiled = nodFiled;
    }
    /**
     * @return Returns the none.
     */
    public boolean isNone() {
        return none;
    }
    /**
     * @param none The none to set.
     */
    public void setNone(boolean none) {
        this.none = none;
    }
    /**
     * @return Returns the nonRegManager.
     */
    public String getNonRegManager() {
        return nonRegManager;
    }
    /**
     * @param nonRegManager The nonRegManager to set.
     */
    public void setNonRegManager(String nonRegManager) {
        this.nonRegManager = nonRegManager;
    }
    /**
     * @return Returns the northSideOfStreet.
     */
    public boolean isNorthSideOfStreet() {
        return northSideOfStreet;
    }
    /**
     * @param northSideOfStreet The northSideOfStreet to set.
     */
    public void setNorthSideOfStreet(boolean northSideOfStreet) {
        this.northSideOfStreet = northSideOfStreet;
    }
    /**
     * @return Returns the numAcres.
     */
    public float getNumAcres() {
        return numAcres;
    }
    /**
     * @param numAcres The numAcres to set.
     */
    public void setNumAcres(float numAcres) {
        this.numAcres = numAcres;
    }
    /**
     * @return Returns the numberOfBuildings.
     */
    public String getNumberOfBuildings() {
        return numberOfBuildings;
    }
    /**
     * @param numberOfBuildings The numberOfBuildings to set.
     */
    public void setNumberOfBuildings(String numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }
    /**
     * @return Returns the numberOfUnits.
     */
    public int getNumberOfUnits() {
        return numberOfUnits;
    }
    /**
     * @param numberOfUnits The numberOfUnits to set.
     */
    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    /**
     * @return Returns the numElevators.
     */
    public String getNumElevators() {
        return numElevators;
    }
    /**
     * @param numElevators The numElevators to set.
     */
    public void setNumElevators(String numElevators) {
        this.numElevators = numElevators;
    }
    /**
     * @return Returns the numFloors.
     */
    public String getNumFloors() {
        return numFloors;
    }
    /**
     * @param numFloors The numFloors to set.
     */
    public void setNumFloors(String numFloors) {
        this.numFloors = numFloors;
    }
    /**
     * @return Returns the numParking.
     */
    public String getNumParking() {
        return numParking;
    }
    /**
     * @param numParking The numParking to set.
     */
    public void setNumParking(String numParking) {
        this.numParking = numParking;
    }
    /**
     * @return Returns the office.
     */
    public boolean isOffice() {
        return office;
    }
    /**
     * @param office The office to set.
     */
    public void setOffice(boolean office) {
        this.office = office;
    }
    /**
     * @return Returns the officeNumber.
     */
    public String getOfficeNumber() {
        return officeNumber;
    }
    /**
     * @param officeNumber The officeNumber to set.
     */
    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
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
     * @return Returns the outsideLighting.
     */
    public boolean isOutsideLighting() {
        return outsideLighting;
    }
    /**
     * @param outsideLighting The outsideLighting to set.
     */
    public void setOutsideLighting(boolean outsideLighting) {
        this.outsideLighting = outsideLighting;
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
     * @return Returns the ownerWillCarry2nd.
     */
    public boolean isOwnerWillCarry2nd() {
        return ownerWillCarry2nd;
    }
    /**
     * @param ownerWillCarry2nd The ownerWillCarry2nd to set.
     */
    public void setOwnerWillCarry2nd(boolean ownerWillCarry2nd) {
        this.ownerWillCarry2nd = ownerWillCarry2nd;
    }
    /**
     * @return Returns the parkingAssigned.
     */
    public boolean isParkingAssigned() {
        return parkingAssigned;
    }
    /**
     * @param parkingAssigned The parkingAssigned to set.
     */
    public void setParkingAssigned(boolean parkingAssigned) {
        this.parkingAssigned = parkingAssigned;
    }
    /**
     * @return Returns the parkingCenterName.
     */
    public String getParkingCenterName() {
        return parkingCenterName;
    }
    /**
     * @param parkingCenterName The parkingCenterName to set.
     */
    public void setParkingCenterName(String parkingCenterName) {
        this.parkingCenterName = parkingCenterName;
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
     * @return Returns the parkingEmployees.
     */
    public boolean isParkingEmployees() {
        return parkingEmployees;
    }
    /**
     * @param parkingEmployees The parkingEmployees to set.
     */
    public void setParkingEmployees(boolean parkingEmployees) {
        this.parkingEmployees = parkingEmployees;
    }
    /**
     * @return Returns the parkingGated.
     */
    public boolean isParkingGated() {
        return parkingGated;
    }
    /**
     * @param parkingGated The parkingGated to set.
     */
    public void setParkingGated(boolean parkingGated) {
        this.parkingGated = parkingGated;
    }
    /**
     * @return Returns the parkingOpen.
     */
    public boolean isParkingOpen() {
        return parkingOpen;
    }
    /**
     * @param parkingOpen The parkingOpen to set.
     */
    public void setParkingOpen(boolean parkingOpen) {
        this.parkingOpen = parkingOpen;
    }
    /**
     * @return Returns the parkingPublic.
     */
    public boolean isParkingPublic() {
        return parkingPublic;
    }
    /**
     * @param parkingPublic The parkingPublic to set.
     */
    public void setParkingPublic(boolean parkingPublic) {
        this.parkingPublic = parkingPublic;
    }
    /**
     * @return Returns the parkingUnassigned.
     */
    public boolean isParkingUnassigned() {
        return parkingUnassigned;
    }
    /**
     * @param parkingUnassigned The parkingUnassigned to set.
     */
    public void setParkingUnassigned(boolean parkingUnassigned) {
        this.parkingUnassigned = parkingUnassigned;
    }
    /**
     * @return Returns the parkRatio.
     */
    public float getParkRatio() {
        return parkRatio;
    }
    /**
     * @param parkRatio The parkRatio to set.
     */
    public void setParkRatio(float parkRatio) {
        this.parkRatio = parkRatio;
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
     * @return Returns the perpVal.
     */
    public String getPerpVal() {
        return perpVal;
    }
    /**
     * @param perpVal The perpVal to set.
     */
    public void setPerpVal(String perpVal) {
        this.perpVal = perpVal;
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
     * @return Returns the pImpv.
     */
    public int getPImpv() {
        return pImpv;
    }
    /**
     * @param impv The pImpv to set.
     */
    public void setPImpv(int impv) {
        pImpv = impv;
    }
    /**
     * @return Returns the pLand.
     */
    public int getPLand() {
        return pLand;
    }
    /**
     * @param land The pLand to set.
     */
    public void setPLand(int land) {
        pLand = land;
    }
    /**
     * @return Returns the pPerp.
     */
    public int getPPerp() {
        return pPerp;
    }
    /**
     * @param perp The pPerp to set.
     */
    public void setPPerp(int perp) {
        pPerp = perp;
    }
    /**
     * @return Returns the preTaxFlow.
     */
    public String getPreTaxFlow() {
        return preTaxFlow;
    }
    /**
     * @param preTaxFlow The preTaxFlow to set.
     */
    public void setPreTaxFlow(String preTaxFlow) {
        this.preTaxFlow = preTaxFlow;
    }
    /**
     * @return Returns the pricePerSquareFoot.
     */
    public int getPricePerSquareFoot() {
        return pricePerSquareFoot;
    }
    /**
     * @param pricePerSquareFoot The pricePerSquareFoot to set.
     */
    public void setPricePerSquareFoot(int pricePerSquareFoot) {
        this.pricePerSquareFoot = pricePerSquareFoot;
    }
    /**
     * @return Returns the professionalCenter.
     */
    public boolean isProfessionalCenter() {
        return professionalCenter;
    }
    /**
     * @param professionalCenter The professionalCenter to set.
     */
    public void setProfessionalCenter(boolean professionalCenter) {
        this.professionalCenter = professionalCenter;
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
     * @return Returns the projected.
     */
    public boolean isProjected() {
        return projected;
    }
    /**
     * @param projected The projected to set.
     */
    public void setProjected(boolean projected) {
        this.projected = projected;
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
     * @return Returns the pTotal.
     */
    public int getPTotal() {
        return pTotal;
    }
    /**
     * @param total The pTotal to set.
     */
    public void setPTotal(int total) {
        pTotal = total;
    }
    /**
     * @return Returns the publicSewer.
     */
    public boolean isPublicSewer() {
        return publicSewer;
    }
    /**
     * @param publicSewer The publicSewer to set.
     */
    public void setPublicSewer(boolean publicSewer) {
        this.publicSewer = publicSewer;
    }
    /**
     * @return Returns the publicWater.
     */
    public boolean isPublicWater() {
        return publicWater;
    }
    /**
     * @param publicWater The publicWater to set.
     */
    public void setPublicWater(boolean publicWater) {
        this.publicWater = publicWater;
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
     * @return Returns the railroadAccess.
     */
    public boolean isRailroadAccess() {
        return railroadAccess;
    }
    /**
     * @param railroadAccess The railroadAccess to set.
     */
    public void setRailroadAccess(boolean railroadAccess) {
        this.railroadAccess = railroadAccess;
    }
    /**
     * @return Returns the realEstateIncl.
     */
    public boolean isRealEstateIncl() {
        return realEstateIncl;
    }
    /**
     * @param realEstateIncl The realEstateIncl to set.
     */
    public void setRealEstateIncl(boolean realEstateIncl) {
        this.realEstateIncl = realEstateIncl;
    }
    /**
     * @return Returns the rearAccess.
     */
    public boolean isRearAccess() {
        return rearAccess;
    }
    /**
     * @param rearAccess The rearAccess to set.
     */
    public void setRearAccess(boolean rearAccess) {
        this.rearAccess = rearAccess;
    }
    /**
     * @return Returns the renewable.
     */
    public boolean isRenewable() {
        return renewable;
    }
    /**
     * @param renewable The renewable to set.
     */
    public void setRenewable(boolean renewable) {
        this.renewable = renewable;
    }
    /**
     * @return Returns the rent1.
     */
    public String getRent1() {
        return rent1;
    }
    /**
     * @param rent1 The rent1 to set.
     */
    public void setRent1(String rent1) {
        this.rent1 = rent1;
    }
    /**
     * @return Returns the rent2.
     */
    public String getRent2() {
        return rent2;
    }
    /**
     * @param rent2 The rent2 to set.
     */
    public void setRent2(String rent2) {
        this.rent2 = rent2;
    }
    /**
     * @return Returns the rent3.
     */
    public String getRent3() {
        return rent3;
    }
    /**
     * @param rent3 The rent3 to set.
     */
    public void setRent3(String rent3) {
        this.rent3 = rent3;
    }
    /**
     * @return Returns the rent4.
     */
    public String getRent4() {
        return rent4;
    }
    /**
     * @param rent4 The rent4 to set.
     */
    public void setRent4(String rent4) {
        this.rent4 = rent4;
    }
    /**
     * @return Returns the rent5.
     */
    public String getRent5() {
        return rent5;
    }
    /**
     * @param rent5 The rent5 to set.
     */
    public void setRent5(String rent5) {
        this.rent5 = rent5;
    }
    /**
     * @return Returns the rent6.
     */
    public String getRent6() {
        return rent6;
    }
    /**
     * @param rent6 The rent6 to set.
     */
    public void setRent6(String rent6) {
        this.rent6 = rent6;
    }
    /**
     * @return Returns the rentAdj.
     */
    public String getRentAdj() {
        return rentAdj;
    }
    /**
     * @param rentAdj The rentAdj to set.
     */
    public void setRentAdj(String rentAdj) {
        this.rentAdj = rentAdj;
    }
    /**
     * @return Returns the rentalLease.
     */
    public boolean isRentalLease() {
        return rentalLease;
    }
    /**
     * @param rentalLease The rentalLease to set.
     */
    public void setRentalLease(boolean rentalLease) {
        this.rentalLease = rentalLease;
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
     * @return Returns the repMainteger.
     */
    public String getRepMainteger() {
        return repMainteger;
    }
    /**
     * @param repMainteger The repMainteger to set.
     */
    public void setRepMainteger(String repMainteger) {
        this.repMainteger = repMainteger;
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
     * @return Returns the requestedPossession.
     */
    public String getRequestedPossession() {
        return requestedPossession;
    }
    /**
     * @param requestedPossession The requestedPossession to set.
     */
    public void setRequestedPossession(String requestedPossession) {
        this.requestedPossession = requestedPossession;
    }
    /**
     * @return Returns the residential.
     */
    public boolean isResidential() {
        return residential;
    }
    /**
     * @param residential The residential to set.
     */
    public void setResidential(boolean residential) {
        this.residential = residential;
    }
    /**
     * @return Returns the restaurant.
     */
    public boolean isRestaurant() {
        return restaurant;
    }
    /**
     * @param restaurant The restaurant to set.
     */
    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }
    /**
     * @return Returns the restroomsHandicapped.
     */
    public boolean isRestroomsHandicapped() {
        return restroomsHandicapped;
    }
    /**
     * @param restroomsHandicapped The restroomsHandicapped to set.
     */
    public void setRestroomsHandicapped(boolean restroomsHandicapped) {
        this.restroomsHandicapped = restroomsHandicapped;
    }
    /**
     * @return Returns the restroomsPublic.
     */
    public boolean isRestroomsPublic() {
        return restroomsPublic;
    }
    /**
     * @param restroomsPublic The restroomsPublic to set.
     */
    public void setRestroomsPublic(boolean restroomsPublic) {
        this.restroomsPublic = restroomsPublic;
    }
    /**
     * @return Returns the resv.
     */
    public String getResv() {
        return resv;
    }
    /**
     * @param resv The resv to set.
     */
    public void setResv(String resv) {
        this.resv = resv;
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
     * @return Returns the retailFrontage.
     */
    public boolean isRetailFrontage() {
        return retailFrontage;
    }
    /**
     * @param retailFrontage The retailFrontage to set.
     */
    public void setRetailFrontage(boolean retailFrontage) {
        this.retailFrontage = retailFrontage;
    }
    /**
     * @return Returns the roofAsphaltRock.
     */
    public boolean isRoofAsphaltRock() {
        return roofAsphaltRock;
    }
    /**
     * @param roofAsphaltRock The roofAsphaltRock to set.
     */
    public void setRoofAsphaltRock(boolean roofAsphaltRock) {
        this.roofAsphaltRock = roofAsphaltRock;
    }
    /**
     * @return Returns the roofCompositionShingle.
     */
    public boolean isRoofCompositionShingle() {
        return roofCompositionShingle;
    }
    /**
     * @param roofCompositionShingle The roofCompositionShingle to set.
     */
    public void setRoofCompositionShingle(boolean roofCompositionShingle) {
        this.roofCompositionShingle = roofCompositionShingle;
    }
    /**
     * @return Returns the roofConcreteShake.
     */
    public boolean isRoofConcreteShake() {
        return roofConcreteShake;
    }
    /**
     * @param roofConcreteShake The roofConcreteShake to set.
     */
    public void setRoofConcreteShake(boolean roofConcreteShake) {
        this.roofConcreteShake = roofConcreteShake;
    }
    /**
     * @return Returns the roofMetal.
     */
    public boolean isRoofMetal() {
        return roofMetal;
    }
    /**
     * @param roofMetal The roofMetal to set.
     */
    public void setRoofMetal(boolean roofMetal) {
        this.roofMetal = roofMetal;
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
     * @return Returns the roofShake.
     */
    public boolean isRoofShake() {
        return roofShake;
    }
    /**
     * @param roofShake The roofShake to set.
     */
    public void setRoofShake(boolean roofShake) {
        this.roofShake = roofShake;
    }
    /**
     * @return Returns the roofShingle.
     */
    public boolean isRoofShingle() {
        return roofShingle;
    }
    /**
     * @param roofShingle The roofShingle to set.
     */
    public void setRoofShingle(boolean roofShingle) {
        this.roofShingle = roofShingle;
    }
    /**
     * @return Returns the roofTile.
     */
    public boolean isRoofTile() {
        return roofTile;
    }
    /**
     * @param roofTile The roofTile to set.
     */
    public void setRoofTile(boolean roofTile) {
        this.roofTile = roofTile;
    }
    /**
     * @return Returns the roofWoodShingle.
     */
    public boolean isRoofWoodShingle() {
        return roofWoodShingle;
    }
    /**
     * @param roofWoodShingle The roofWoodShingle to set.
     */
    public void setRoofWoodShingle(boolean roofWoodShingle) {
        this.roofWoodShingle = roofWoodShingle;
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
     * @return Returns the salePricePerSquareFeet.
     */
    public float getSalePricePerSquareFeet() {
        return salePricePerSquareFeet;
    }
    /**
     * @param salePricePerSquareFeet The salePricePerSquareFeet to set.
     */
    public void setSalePricePerSquareFeet(float salePricePerSquareFeet) {
        this.salePricePerSquareFeet = salePricePerSquareFeet;
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
     * @return Returns the sca.
     */
    public String getSca() {
        return sca;
    }
    /**
     * @param sca The sca to set.
     */
    public void setSca(String sca) {
        this.sca = sca;
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
     * @return Returns the securitySystemLeased.
     */
    public boolean isSecuritySystemLeased() {
        return securitySystemLeased;
    }
    /**
     * @param securitySystemLeased The securitySystemLeased to set.
     */
    public void setSecuritySystemLeased(boolean securitySystemLeased) {
        this.securitySystemLeased = securitySystemLeased;
    }
    /**
     * @return Returns the securitySystemOwned.
     */
    public boolean isSecuritySystemOwned() {
        return securitySystemOwned;
    }
    /**
     * @param securitySystemOwned The securitySystemOwned to set.
     */
    public void setSecuritySystemOwned(boolean securitySystemOwned) {
        this.securitySystemOwned = securitySystemOwned;
    }
    /**
     * @return Returns the septicTank.
     */
    public boolean isSepticTank() {
        return septicTank;
    }
    /**
     * @param septicTank The septicTank to set.
     */
    public void setSepticTank(boolean septicTank) {
        this.septicTank = septicTank;
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
     * @return Returns the sewer.
     */
    public String getSewer() {
        return sewer;
    }
    /**
     * @param sewer The sewer to set.
     */
    public void setSewer(String sewer) {
        this.sewer = sewer;
    }
    /**
     * @return Returns the sewerBond.
     */
    public boolean isSewerBond() {
        return sewerBond;
    }
    /**
     * @param sewerBond The sewerBond to set.
     */
    public void setSewerBond(boolean sewerBond) {
        this.sewerBond = sewerBond;
    }
    /**
     * @return Returns the sewerPaid.
     */
    public boolean isSewerPaid() {
        return sewerPaid;
    }
    /**
     * @param sewerPaid The sewerPaid to set.
     */
    public void setSewerPaid(boolean sewerPaid) {
        this.sewerPaid = sewerPaid;
    }
    /**
     * @return Returns the sftGat.
     */
    public boolean isSftGat() {
        return sftGat;
    }
    /**
     * @param sftGat The sftGat to set.
     */
    public void setSftGat(boolean sftGat) {
        this.sftGat = sftGat;
    }
    /**
     * @return Returns the shoppingCenter.
     */
    public boolean isShoppingCenter() {
        return shoppingCenter;
    }
    /**
     * @param shoppingCenter The shoppingCenter to set.
     */
    public void setShoppingCenter(boolean shoppingCenter) {
        this.shoppingCenter = shoppingCenter;
    }
    /**
     * @return Returns the sidewalks.
     */
    public String getSidewalks() {
        return sidewalks;
    }
    /**
     * @param sidewalks The sidewalks to set.
     */
    public void setSidewalks(String sidewalks) {
        this.sidewalks = sidewalks;
    }
    /**
     * @return Returns the signYesNo.
     */
    public boolean isSignYesNo() {
        return signYesNo;
    }
    /**
     * @param signYesNo The signYesNo to set.
     */
    public void setSignYesNo(boolean signYesNo) {
        this.signYesNo = signYesNo;
    }
    /**
     * @return Returns the skylights.
     */
    public boolean isSkylights() {
        return skylights;
    }
    /**
     * @param skylights The skylights to set.
     */
    public void setSkylights(boolean skylights) {
        this.skylights = skylights;
    }
    /**
     * @return Returns the sle.
     */
    public boolean isSle() {
        return sle;
    }
    /**
     * @param sle The sle to set.
     */
    public void setSle(boolean sle) {
        this.sle = sle;
    }
    /**
     * @return Returns the smokeAlarm.
     */
    public boolean isSmokeAlarm() {
        return smokeAlarm;
    }
    /**
     * @param smokeAlarm The smokeAlarm to set.
     */
    public void setSmokeAlarm(boolean smokeAlarm) {
        this.smokeAlarm = smokeAlarm;
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
     * @return Returns the southSideOfStreet.
     */
    public boolean isSouthSideOfStreet() {
        return southSideOfStreet;
    }
    /**
     * @param southSideOfStreet The southSideOfStreet to set.
     */
    public void setSouthSideOfStreet(boolean southSideOfStreet) {
        this.southSideOfStreet = southSideOfStreet;
    }
    /**
     * @return Returns the squareFeet.
     */
    public int getSquareFeet() {
        return squareFeet;
    }
    /**
     * @param squareFeet The squareFeet to set.
     */
    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }
    /**
     * @return Returns the squareFeet1.
     */
    public String getSquareFeet1() {
        return squareFeet1;
    }
    /**
     * @param squareFeet1 The squareFeet1 to set.
     */
    public void setSquareFeet1(String squareFeet1) {
        this.squareFeet1 = squareFeet1;
    }
    /**
     * @return Returns the squareFeet2.
     */
    public String getSquareFeet2() {
        return squareFeet2;
    }
    /**
     * @param squareFeet2 The squareFeet2 to set.
     */
    public void setSquareFeet2(String squareFeet2) {
        this.squareFeet2 = squareFeet2;
    }
    /**
     * @return Returns the squareFeet3.
     */
    public String getSquareFeet3() {
        return squareFeet3;
    }
    /**
     * @param squareFeet3 The squareFeet3 to set.
     */
    public void setSquareFeet3(String squareFeet3) {
        this.squareFeet3 = squareFeet3;
    }
    /**
     * @return Returns the squareFeet4.
     */
    public String getSquareFeet4() {
        return squareFeet4;
    }
    /**
     * @param squareFeet4 The squareFeet4 to set.
     */
    public void setSquareFeet4(String squareFeet4) {
        this.squareFeet4 = squareFeet4;
    }
    /**
     * @return Returns the squareFeet5.
     */
    public String getSquareFeet5() {
        return squareFeet5;
    }
    /**
     * @param squareFeet5 The squareFeet5 to set.
     */
    public void setSquareFeet5(String squareFeet5) {
        this.squareFeet5 = squareFeet5;
    }
    /**
     * @return Returns the squareFeet6.
     */
    public String getSquareFeet6() {
        return squareFeet6;
    }
    /**
     * @param squareFeet6 The squareFeet6 to set.
     */
    public void setSquareFeet6(String squareFeet6) {
        this.squareFeet6 = squareFeet6;
    }
    /**
     * @return Returns the squareFeetRnt.
     */
    public String getSquareFeetRnt() {
        return squareFeetRnt;
    }
    /**
     * @param squareFeetRnt The squareFeetRnt to set.
     */
    public void setSquareFeetRnt(String squareFeetRnt) {
        this.squareFeetRnt = squareFeetRnt;
    }
    /**
     * @return Returns the squareFeetUse.
     */
    public String getSquareFeetUse() {
        return squareFeetUse;
    }
    /**
     * @param squareFeetUse The squareFeetUse to set.
     */
    public void setSquareFeetUse(String squareFeetUse) {
        this.squareFeetUse = squareFeetUse;
    }
    /**
     * @return Returns the squareFootDol.
     */
    public float getSquareFootDol() {
        return squareFootDol;
    }
    /**
     * @param squareFootDol The squareFootDol to set.
     */
    public void setSquareFootDol(float squareFootDol) {
        this.squareFootDol = squareFootDol;
    }
    /**
     * @return Returns the standAlone.
     */
    public boolean isStandAlone() {
        return standAlone;
    }
    /**
     * @param standAlone The standAlone to set.
     */
    public void setStandAlone(boolean standAlone) {
        this.standAlone = standAlone;
    }
    /**
     * @return Returns the stcDirt.
     */
    public boolean isStcDirt() {
        return stcDirt;
    }
    /**
     * @param stcDirt The stcDirt to set.
     */
    public void setStcDirt(boolean stcDirt) {
        this.stcDirt = stcDirt;
    }
    /**
     * @return Returns the stcOther.
     */
    public boolean isStcOther() {
        return stcOther;
    }
    /**
     * @param stcOther The stcOther to set.
     */
    public void setStcOther(boolean stcOther) {
        this.stcOther = stcOther;
    }
    /**
     * @return Returns the stcPaved.
     */
    public boolean isStcPaved() {
        return stcPaved;
    }
    /**
     * @param stcPaved The stcPaved to set.
     */
    public void setStcPaved(boolean stcPaved) {
        this.stcPaved = stcPaved;
    }
    /**
     * @return Returns the stcPrivate.
     */
    public boolean isStcPrivate() {
        return stcPrivate;
    }
    /**
     * @param stcPrivate The stcPrivate to set.
     */
    public void setStcPrivate(boolean stcPrivate) {
        this.stcPrivate = stcPrivate;
    }
    /**
     * @return Returns the stcPublic.
     */
    public boolean isStcPublic() {
        return stcPublic;
    }
    /**
     * @param stcPublic The stcPublic to set.
     */
    public void setStcPublic(boolean stcPublic) {
        this.stcPublic = stcPublic;
    }
    /**
     * @return Returns the stl1Story.
     */
    public boolean isStl1Story() {
        return stl1Story;
    }
    /**
     * @param stl1Story The stl1Story to set.
     */
    public void setStl1Story(boolean stl1Story) {
        this.stl1Story = stl1Story;
    }
    /**
     * @return Returns the stl2Story.
     */
    public boolean isStl2Story() {
        return stl2Story;
    }
    /**
     * @param stl2Story The stl2Story to set.
     */
    public void setStl2Story(boolean stl2Story) {
        this.stl2Story = stl2Story;
    }
    /**
     * @return Returns the stl3Story.
     */
    public boolean isStl3Story() {
        return stl3Story;
    }
    /**
     * @param stl3Story The stl3Story to set.
     */
    public void setStl3Story(boolean stl3Story) {
        this.stl3Story = stl3Story;
    }
    /**
     * @return Returns the stl4Story.
     */
    public boolean isStl4Story() {
        return stl4Story;
    }
    /**
     * @param stl4Story The stl4Story to set.
     */
    public void setStl4Story(boolean stl4Story) {
        this.stl4Story = stl4Story;
    }
    /**
     * @return Returns the stlLowerLevel.
     */
    public boolean isStlLowerLevel() {
        return stlLowerLevel;
    }
    /**
     * @param stlLowerLevel The stlLowerLevel to set.
     */
    public void setStlLowerLevel(boolean stlLowerLevel) {
        this.stlLowerLevel = stlLowerLevel;
    }
    /**
     * @return Returns the stlOther.
     */
    public boolean isStlOther() {
        return stlOther;
    }
    /**
     * @param stlOther The stlOther to set.
     */
    public void setStlOther(boolean stlOther) {
        this.stlOther = stlOther;
    }
    /**
     * @return Returns the stlSplitLevel.
     */
    public boolean isStlSplitLevel() {
        return stlSplitLevel;
    }
    /**
     * @param stlSplitLevel The stlSplitLevel to set.
     */
    public void setStlSplitLevel(boolean stlSplitLevel) {
        this.stlSplitLevel = stlSplitLevel;
    }
    /**
     * @return Returns the stlUpperLevel.
     */
    public boolean isStlUpperLevel() {
        return stlUpperLevel;
    }
    /**
     * @param stlUpperLevel The stlUpperLevel to set.
     */
    public void setStlUpperLevel(boolean stlUpperLevel) {
        this.stlUpperLevel = stlUpperLevel;
    }
    /**
     * @return Returns the storageArea.
     */
    public boolean isStorageArea() {
        return storageArea;
    }
    /**
     * @param storageArea The storageArea to set.
     */
    public void setStorageArea(boolean storageArea) {
        this.storageArea = storageArea;
    }
    /**
     * @return Returns the streetLights.
     */
    public String getStreetLights() {
        return streetLights;
    }
    /**
     * @param streetLights The streetLights to set.
     */
    public void setStreetLights(String streetLights) {
        this.streetLights = streetLights;
    }
    /**
     * @return Returns the stripStoreCenter.
     */
    public boolean isStripStoreCenter() {
        return stripStoreCenter;
    }
    /**
     * @param stripStoreCenter The stripStoreCenter to set.
     */
    public void setStripStoreCenter(boolean stripStoreCenter) {
        this.stripStoreCenter = stripStoreCenter;
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
     * @return Returns the sublease.
     */
    public boolean isSublease() {
        return sublease;
    }
    /**
     * @param sublease The sublease to set.
     */
    public void setSublease(boolean sublease) {
        this.sublease = sublease;
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
     * @return Returns the ten1.
     */
    public String getTen1() {
        return ten1;
    }
    /**
     * @param ten1 The ten1 to set.
     */
    public void setTen1(String ten1) {
        this.ten1 = ten1;
    }
    /**
     * @return Returns the ten2.
     */
    public String getTen2() {
        return ten2;
    }
    /**
     * @param ten2 The ten2 to set.
     */
    public void setTen2(String ten2) {
        this.ten2 = ten2;
    }
    /**
     * @return Returns the ten3.
     */
    public String getTen3() {
        return ten3;
    }
    /**
     * @param ten3 The ten3 to set.
     */
    public void setTen3(String ten3) {
        this.ten3 = ten3;
    }
    /**
     * @return Returns the ten4.
     */
    public String getTen4() {
        return ten4;
    }
    /**
     * @param ten4 The ten4 to set.
     */
    public void setTen4(String ten4) {
        this.ten4 = ten4;
    }
    /**
     * @return Returns the ten5.
     */
    public String getTen5() {
        return ten5;
    }
    /**
     * @param ten5 The ten5 to set.
     */
    public void setTen5(String ten5) {
        this.ten5 = ten5;
    }
    /**
     * @return Returns the ten6.
     */
    public String getTen6() {
        return ten6;
    }
    /**
     * @param ten6 The ten6 to set.
     */
    public void setTen6(String ten6) {
        this.ten6 = ten6;
    }
    /**
     * @return Returns the tenimpall.
     */
    public String getTenimpall() {
        return tenimpall;
    }
    /**
     * @param tenimpall The tenimpall to set.
     */
    public void setTenimpall(String tenimpall) {
        this.tenimpall = tenimpall;
    }
    /**
     * @return Returns the term2.
     */
    public String getTerm2() {
        return term2;
    }
    /**
     * @param term2 The term2 to set.
     */
    public void setTerm2(String term2) {
        this.term2 = term2;
    }
    /**
     * @return Returns the term3.
     */
    public String getTerm3() {
        return term3;
    }
    /**
     * @param term3 The term3 to set.
     */
    public void setTerm3(String term3) {
        this.term3 = term3;
    }
    /**
     * @return Returns the term4.
     */
    public String getTerm4() {
        return term4;
    }
    /**
     * @param term4 The term4 to set.
     */
    public void setTerm4(String term4) {
        this.term4 = term4;
    }
    /**
     * @return Returns the term5.
     */
    public String getTerm5() {
        return term5;
    }
    /**
     * @param term5 The term5 to set.
     */
    public void setTerm5(String term5) {
        this.term5 = term5;
    }
    /**
     * @return Returns the term6.
     */
    public String getTerm6() {
        return term6;
    }
    /**
     * @param term6 The term6 to set.
     */
    public void setTerm6(String term6) {
        this.term6 = term6;
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
     * @return Returns the totExp.
     */
    public String getTotExp() {
        return totExp;
    }
    /**
     * @param totExp The totExp to set.
     */
    public void setTotExp(String totExp) {
        this.totExp = totExp;
    }
    /**
     * @return Returns the totVal.
     */
    public String getTotVal() {
        return totVal;
    }
    /**
     * @param totVal The totVal to set.
     */
    public void setTotVal(String totVal) {
        this.totVal = totVal;
    }
    /**
     * @return Returns the transferable.
     */
    public boolean isTransferable() {
        return transferable;
    }
    /**
     * @param transferable The transferable to set.
     */
    public void setTransferable(boolean transferable) {
        this.transferable = transferable;
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
     * @return Returns the truckDoors.
     */
    public boolean isTruckDoors() {
        return truckDoors;
    }
    /**
     * @param truckDoors The truckDoors to set.
     */
    public void setTruckDoors(boolean truckDoors) {
        this.truckDoors = truckDoors;
    }
    /**
     * @return Returns the tunit.
     */
    public String getTunit() {
        return tunit;
    }
    /**
     * @param tunit The tunit to set.
     */
    public void setTunit(String tunit) {
        this.tunit = tunit;
    }
    /**
     * @return Returns the tUnit1.
     */
    public String getTUnit1() {
        return tUnit1;
    }
    /**
     * @param unit1 The tUnit1 to set.
     */
    public void setTUnit1(String unit1) {
        tUnit1 = unit1;
    }
    /**
     * @return Returns the tunit2.
     */
    public String getTunit2() {
        return tunit2;
    }
    /**
     * @param tunit2 The tunit2 to set.
     */
    public void setTunit2(String tunit2) {
        this.tunit2 = tunit2;
    }
    /**
     * @return Returns the tunit3.
     */
    public String getTunit3() {
        return tunit3;
    }
    /**
     * @param tunit3 The tunit3 to set.
     */
    public void setTunit3(String tunit3) {
        this.tunit3 = tunit3;
    }
    /**
     * @return Returns the tunit4.
     */
    public String getTunit4() {
        return tunit4;
    }
    /**
     * @param tunit4 The tunit4 to set.
     */
    public void setTunit4(String tunit4) {
        this.tunit4 = tunit4;
    }
    /**
     * @return Returns the tunit5.
     */
    public String getTunit5() {
        return tunit5;
    }
    /**
     * @param tunit5 The tunit5 to set.
     */
    public void setTunit5(String tunit5) {
        this.tunit5 = tunit5;
    }
    /**
     * @return Returns the tunit6.
     */
    public String getTunit6() {
        return tunit6;
    }
    /**
     * @param tunit6 The tunit6 to set.
     */
    public void setTunit6(String tunit6) {
        this.tunit6 = tunit6;
    }
    /**
     * @return Returns the upSlope.
     */
    public boolean isUpSlope() {
        return upSlope;
    }
    /**
     * @param upSlope The upSlope to set.
     */
    public void setUpSlope(boolean upSlope) {
        this.upSlope = upSlope;
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
     * @return Returns the utlcElectric.
     */
    public String getUtlcElectric() {
        return utlcElectric;
    }
    /**
     * @param utlcElectric The utlcElectric to set.
     */
    public void setUtlcElectric(String utlcElectric) {
        this.utlcElectric = utlcElectric;
    }
    /**
     * @return Returns the utlcGas.
     */
    public String getUtlcGas() {
        return utlcGas;
    }
    /**
     * @param utlcGas The utlcGas to set.
     */
    public void setUtlcGas(String utlcGas) {
        this.utlcGas = utlcGas;
    }
    /**
     * @return Returns the utlcTrs.
     */
    public String getUtlcTrs() {
        return utlcTrs;
    }
    /**
     * @param utlcTrs The utlcTrs to set.
     */
    public void setUtlcTrs(String utlcTrs) {
        this.utlcTrs = utlcTrs;
    }
    /**
     * @return Returns the utlcWater.
     */
    public String getUtlcWater() {
        return utlcWater;
    }
    /**
     * @param utlcWater The utlcWater to set.
     */
    public void setUtlcWater(String utlcWater) {
        this.utlcWater = utlcWater;
    }
    /**
     * @return Returns the vacColl.
     */
    public String getVacColl() {
        return vacColl;
    }
    /**
     * @param vacColl The vacColl to set.
     */
    public void setVacColl(String vacColl) {
        this.vacColl = vacColl;
    }
    /**
     * @return Returns the vacPercent.
     */
    public float getVacPercent() {
        return vacPercent;
    }
    /**
     * @param vacPercent The vacPercent to set.
     */
    public void setVacPercent(float vacPercent) {
        this.vacPercent = vacPercent;
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
     * @return Returns the warehouse.
     */
    public boolean isWarehouse() {
        return warehouse;
    }
    /**
     * @param warehouse The warehouse to set.
     */
    public void setWarehouse(boolean warehouse) {
        this.warehouse = warehouse;
    }
    /**
     * @return Returns the warehouseSquareFeet.
     */
    public int getWarehouseSquareFeet() {
        return warehouseSquareFeet;
    }
    /**
     * @param warehouseSquareFeet The warehouseSquareFeet to set.
     */
    public void setWarehouseSquareFeet(int warehouseSquareFeet) {
        this.warehouseSquareFeet = warehouseSquareFeet;
    }
    /**
     * @return Returns the waterIndMeter.
     */
    public boolean isWaterIndMeter() {
        return waterIndMeter;
    }
    /**
     * @param waterIndMeter The waterIndMeter to set.
     */
    public void setWaterIndMeter(boolean waterIndMeter) {
        this.waterIndMeter = waterIndMeter;
    }
    /**
     * @return Returns the waterMasterMeter.
     */
    public boolean isWaterMasterMeter() {
        return waterMasterMeter;
    }
    /**
     * @param waterMasterMeter The waterMasterMeter to set.
     */
    public void setWaterMasterMeter(boolean waterMasterMeter) {
        this.waterMasterMeter = waterMasterMeter;
    }
    /**
     * @return Returns the wellWater.
     */
    public boolean isWellWater() {
        return wellWater;
    }
    /**
     * @param wellWater The wellWater to set.
     */
    public void setWellWater(boolean wellWater) {
        this.wellWater = wellWater;
    }
    /**
     * @return Returns the westSideOfStreet.
     */
    public boolean isWestSideOfStreet() {
        return westSideOfStreet;
    }
    /**
     * @param westSideOfStreet The westSideOfStreet to set.
     */
    public void setWestSideOfStreet(boolean westSideOfStreet) {
        this.westSideOfStreet = westSideOfStreet;
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
     * @return Returns the yearBuilt.
     */
    public int getYearBuilt() {
        return yearBuilt;
    }
    /**
     * @param yearBuilt The yearBuilt to set.
     */
    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
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
    /**
     * @return Returns the term1.
     */
    public String getTerm1() {
        return term1;
    }
    /**
     * @param term1 The term1 to set.
     */
    public void setTerm1(String term1) {
        this.term1 = term1;
    }
}

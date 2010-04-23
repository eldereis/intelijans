/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.dataobjects;

import java.util.Date;

/**
 * @author jthomas
 *
 */
public class MultiFamily extends Residence {
    private String zoning;
    private int numberOfUnits;
    private String financing;
    private int buildingSquareFeet;
    private int lotSize;
    private int approximateAge;
    private int oneBedroomUnits;
    private int twoBedroomUnits;
    private int threeBedroomUnits;
    private int fourBedroomUnits;
    private int studioUnits;
    private int otherUnits;
    private int pricePerUnit;
    private int pricePerSquareFoot;
    private int grossRent;
    private float grossRentMultiplier;
    private float capRate;
    private int annualGrossIncome;
    private int actualVacancyPercent;
    private float grsPercent;
    private int scheduledGrossIncome;
    private String otherIncome;
    private float otherIncomePercent;
    private String lessVacancy;
    private float vacPercent;
    private String grossOperatingIncome;
    private float grossOperatingIncomePercent;
    private String lessExpenses;
    private float lessExpensesPercent;
    private String netOperatingIncome;
    private float netOperatingIncomePercent;
    private String lessDebtService;
    private float lessDebtServicePercent;
    private String preTaxflow;
    private float preTaxflowPercent;
    private int taxPercent;
    private String totalTax;
    private int taxRate;
    private int taxRated;
    private String annualInsurance;
    private String utilities;
    private String advertisingAnnualDollars;
    private int annualLicenses;
    private String annualRubbishExpense;
    private String annualLandscape;
    private int annualPoolService;
    private int annualPestControl;
    private String repMaint;
    private String elevator;
    private String annualSecurity;
    private String annualResManagerPay;
    private int annualManagementFee;
    private String annualMiscFee;
    private float resvPercent;
    private String resv;
    private String totExp;
    private int perNet;
    private float expenseRatioPercent;
    private int expenseRatio;
    private String utilElec;
    private String utilWater;
    private String utilGas;
    private String utilHeater;
    private int unit1ID;
    private int unit2ID;
    private int unit3ID;
    private int unit4ID;
    private int unit5ID;
    private int unit6ID;
    private int unit7ID;
    private int unit8ID;
    private int unit9ID;
    private int unit10ID;
    private int unit11;
    private int unit12;
    private int unit13;
    private int unit14;
    private int unit15;
    private int unit16;
    private int unit17;
    private int unit18;
    private int unit19;
    private int unit1Rent;
    private int unit2Rent;
    private int unit3Rent;
    private int unit4Rent;
    private int unit5Rent;
    private int unit6Rent;
    private int unit7Rent;
    private int unit8Rent;
    private int unit9Rent;
    private int unit10Rent;
    private int unit11Rent;
    private int unit12Rent;
    private int unit13Rent;
    private int unit14Rent;
    private int unit15Rent;
    private int unit16Rent;
    private int unit17Rent;
    private int unit18Rent;
    private int unit19Rent;
    private String type01;
    private String type02;
    private String type03;
    private String type04;
    private String type05;
    private String type06;
    private String type07;
    private String type08;
    private String type09;
    private String type10;
    private String type11;
    private String type12;
    private String type13;
    private String type14;
    private String type15;
    private String type16;
    private String type17;
    private String type18;
    private String type19;
    private boolean rentControl;
    private boolean alley;
    private boolean secAccess;
    private boolean adaCompliant;
    private boolean contingency;
    private boolean elevators;
    private String numElevators;
    private boolean sprinklrd;
    private String numParking;
    private int parkOpNum;
    private int parkCovered;
    private int parkSubt;
    private String heatingType;
    private String coolingType;
    private String roofType;
    private String constructionType;
    private String spckFtrs;
    private String motivation;
    private String exchangeFor;
    private Date photoTimeStamp;
    private Date dateAdded;
    private Date modTimeStamp;
    private String sca;
    private String virtualTour;
    private int longitude;
    private String companyList;
    private String companySale;
    private int cmaLimitTime;
    
    /**
     * @return Returns the actualVacancyPercent.
     */
    public int getActualVacancyPercent() {
        return actualVacancyPercent;
    }
    /**
     * @param actualVacancyPercent The actualVacancyPercent to set.
     */
    public void setActualVacancyPercent(int actualVacancyPercent) {
        this.actualVacancyPercent = actualVacancyPercent;
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
     * @return Returns the alley.
     */
    public boolean isAlley() {
        return alley;
    }
    /**
     * @param alley The alley to set.
     */
    public void setAlley(boolean alley) {
        this.alley = alley;
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
     * @return Returns the annualLicenses.
     */
    public int getAnnualLicenses() {
        return annualLicenses;
    }
    /**
     * @param annualLicenses The annualLicenses to set.
     */
    public void setAnnualLicenses(int annualLicenses) {
        this.annualLicenses = annualLicenses;
    }
    /**
     * @return Returns the annualManagementFee.
     */
    public int getAnnualManagementFee() {
        return annualManagementFee;
    }
    /**
     * @param annualManagementFee The annualManagementFee to set.
     */
    public void setAnnualManagementFee(int annualManagementFee) {
        this.annualManagementFee = annualManagementFee;
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
     * @return Returns the annualPestControl.
     */
    public int getAnnualPestControl() {
        return annualPestControl;
    }
    /**
     * @param annualPestControl The annualPestControl to set.
     */
    public void setAnnualPestControl(int annualPestControl) {
        this.annualPestControl = annualPestControl;
    }
    /**
     * @return Returns the annualPoolService.
     */
    public int getAnnualPoolService() {
        return annualPoolService;
    }
    /**
     * @param annualPoolService The annualPoolService to set.
     */
    public void setAnnualPoolService(int annualPoolService) {
        this.annualPoolService = annualPoolService;
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
     * @return Returns the approximateAge.
     */
    public int getApproximateAge() {
        return approximateAge;
    }
    /**
     * @param approximateAge The approximateAge to set.
     */
    public void setApproximateAge(int approximateAge) {
        this.approximateAge = approximateAge;
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
     * @return Returns the constructionType.
     */
    public String getConstructionType() {
        return constructionType;
    }
    /**
     * @param constructionType The constructionType to set.
     */
    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }
    /**
     * @return Returns the contingency.
     */
    public boolean isContingency() {
        return contingency;
    }
    /**
     * @param contingency The contingency to set.
     */
    public void setContingency(boolean contingency) {
        this.contingency = contingency;
    }
    /**
     * @return Returns the coolingType.
     */
    public String getCoolingType() {
        return coolingType;
    }
    /**
     * @param coolingType The coolingType to set.
     */
    public void setCoolingType(String coolingType) {
        this.coolingType = coolingType;
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
     * @return Returns the elevator.
     */
    public String getElevator() {
        return elevator;
    }
    /**
     * @param elevator The elevator to set.
     */
    public void setElevator(String elevator) {
        this.elevator = elevator;
    }
    /**
     * @return Returns the elevators.
     */
    public boolean isElevators() {
        return elevators;
    }
    /**
     * @param elevators The elevators to set.
     */
    public void setElevators(boolean elevators) {
        this.elevators = elevators;
    }
    /**
     * @return Returns the exchangeFor.
     */
    public String getExchangeFor() {
        return exchangeFor;
    }
    /**
     * @param exchangeFor The exchangeFor to set.
     */
    public void setExchangeFor(String exchangeFor) {
        this.exchangeFor = exchangeFor;
    }
    /**
     * @return Returns the expenseRatio.
     */
    public int getExpenseRatio() {
        return expenseRatio;
    }
    /**
     * @param expenseRatio The expenseRatio to set.
     */
    public void setExpenseRatio(int expenseRatio) {
        this.expenseRatio = expenseRatio;
    }
    /**
     * @return Returns the expenseRatioPercent.
     */
    public float getExpenseRatioPercent() {
        return expenseRatioPercent;
    }
    /**
     * @param expenseRatioPercent The expenseRatioPercent to set.
     */
    public void setExpenseRatioPercent(float expenseRatioPercent) {
        this.expenseRatioPercent = expenseRatioPercent;
    }
    /**
     * @return Returns the financing.
     */
    public String getFinancing() {
        return financing;
    }
    /**
     * @param financing The financing to set.
     */
    public void setFinancing(String financing) {
        this.financing = financing;
    }
    /**
     * @return Returns the fourBedroomUnits.
     */
    public int getFourBedroomUnits() {
        return fourBedroomUnits;
    }
    /**
     * @param fourBedroomUnits The fourBedroomUnits to set.
     */
    public void setFourBedroomUnits(int fourBedroomUnits) {
        this.fourBedroomUnits = fourBedroomUnits;
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
     * @return Returns the grossOperatingIncomePercent.
     */
    public float getGrossOperatingIncomePercent() {
        return grossOperatingIncomePercent;
    }
    /**
     * @param grossOperatingIncomePercent The grossOperatingIncomePercent to set.
     */
    public void setGrossOperatingIncomePercent(float grossOperatingIncomePercent) {
        this.grossOperatingIncomePercent = grossOperatingIncomePercent;
    }
    /**
     * @return Returns the grossRent.
     */
    public int getGrossRent() {
        return grossRent;
    }
    /**
     * @param grossRent The grossRent to set.
     */
    public void setGrossRent(int grossRent) {
        this.grossRent = grossRent;
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
     * @return Returns the grsPercent.
     */
    public float getGrsPercent() {
        return grsPercent;
    }
    /**
     * @param grsPercent The grsPercent to set.
     */
    public void setGrsPercent(float grsPercent) {
        this.grsPercent = grsPercent;
    }
    /**
     * @return Returns the heatingType.
     */
    public String getHeatingType() {
        return heatingType;
    }
    /**
     * @param heatingType The heatingType to set.
     */
    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
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
     * @return Returns the lessDebtServicePercent.
     */
    public float getLessDebtServicePercent() {
        return lessDebtServicePercent;
    }
    /**
     * @param lessDebtServicePercent The lessDebtServicePercent to set.
     */
    public void setLessDebtServicePercent(float lessDebtServicePercent) {
        this.lessDebtServicePercent = lessDebtServicePercent;
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
     * @return Returns the lessExpensesPercent.
     */
    public float getLessExpensesPercent() {
        return lessExpensesPercent;
    }
    /**
     * @param lessExpensesPercent The lessExpensesPercent to set.
     */
    public void setLessExpensesPercent(float lessExpensesPercent) {
        this.lessExpensesPercent = lessExpensesPercent;
    }
    /**
     * @return Returns the lessVacancy.
     */
    public String getLessVacancy() {
        return lessVacancy;
    }
    /**
     * @param lessVacancy The lessVacancy to set.
     */
    public void setLessVacancy(String lessVacancy) {
        this.lessVacancy = lessVacancy;
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
     * @return Returns the lotSize.
     */
    public int getLotSize() {
        return lotSize;
    }
    /**
     * @param lotSize The lotSize to set.
     */
    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }
    /**
     * @return Returns the modTimeStamp.
     */
    public Date getModTimeStamp() {
        return modTimeStamp;
    }
    /**
     * @param modTimeStamp The modTimeStamp to set.
     */
    public void setModTimeStamp(Date modTimeStamp) {
        this.modTimeStamp = modTimeStamp;
    }
    /**
     * @return Returns the motivation.
     */
    public String getMotivation() {
        return motivation;
    }
    /**
     * @param motivation The motivation to set.
     */
    public void setMotivation(String motivation) {
        this.motivation = motivation;
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
     * @return Returns the netOperatingIncomePercent.
     */
    public float getNetOperatingIncomePercent() {
        return netOperatingIncomePercent;
    }
    /**
     * @param netOperatingIncomePercent The netOperatingIncomePercent to set.
     */
    public void setNetOperatingIncomePercent(float netOperatingIncomePercent) {
        this.netOperatingIncomePercent = netOperatingIncomePercent;
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
     * @return Returns the oneBedroomUnits.
     */
    public int getOneBedroomUnits() {
        return oneBedroomUnits;
    }
    /**
     * @param oneBedroomUnits The oneBedroomUnits to set.
     */
    public void setOneBedroomUnits(int oneBedroomUnits) {
        this.oneBedroomUnits = oneBedroomUnits;
    }
    /**
     * @return Returns the otherIncome.
     */
    public String getOtherIncome() {
        return otherIncome;
    }
    /**
     * @param otherIncome The otherIncome to set.
     */
    public void setOtherIncome(String otherIncome) {
        this.otherIncome = otherIncome;
    }
    /**
     * @return Returns the otherIncomePercent.
     */
    public float getOtherIncomePercent() {
        return otherIncomePercent;
    }
    /**
     * @param otherIncomePercent The otherIncomePercent to set.
     */
    public void setOtherIncomePercent(float otherIncomePercent) {
        this.otherIncomePercent = otherIncomePercent;
    }
    /**
     * @return Returns the otherUnits.
     */
    public int getOtherUnits() {
        return otherUnits;
    }
    /**
     * @param otherUnits The otherUnits to set.
     */
    public void setOtherUnits(int otherUnits) {
        this.otherUnits = otherUnits;
    }
    /**
     * @return Returns the parkCovered.
     */
    public int getParkCovered() {
        return parkCovered;
    }
    /**
     * @param parkCovered The parkCovered to set.
     */
    public void setParkCovered(int parkCovered) {
        this.parkCovered = parkCovered;
    }
    /**
     * @return Returns the parkOpNum.
     */
    public int getParkOpNum() {
        return parkOpNum;
    }
    /**
     * @param parkOpNum The parkOpNum to set.
     */
    public void setParkOpNum(int parkOpNum) {
        this.parkOpNum = parkOpNum;
    }
    /**
     * @return Returns the parkSubt.
     */
    public int getParkSubt() {
        return parkSubt;
    }
    /**
     * @param parkSubt The parkSubt to set.
     */
    public void setParkSubt(int parkSubt) {
        this.parkSubt = parkSubt;
    }
    /**
     * @return Returns the perNet.
     */
    public int getPerNet() {
        return perNet;
    }
    /**
     * @param perNet The perNet to set.
     */
    public void setPerNet(int perNet) {
        this.perNet = perNet;
    }
    /**
     * @return Returns the photoTimeStamp.
     */
    public Date getPhotoTimeStamp() {
        return photoTimeStamp;
    }
    /**
     * @param photoTimeStamp The photoTimeStamp to set.
     */
    public void setPhotoTimeStamp(Date photoTimeStamp) {
        this.photoTimeStamp = photoTimeStamp;
    }
    /**
     * @return Returns the preTaxflow.
     */
    public String getPreTaxflow() {
        return preTaxflow;
    }
    /**
     * @param preTaxflow The preTaxflow to set.
     */
    public void setPreTaxflow(String preTaxflow) {
        this.preTaxflow = preTaxflow;
    }
    /**
     * @return Returns the preTaxflowPercent.
     */
    public float getPreTaxflowPercent() {
        return preTaxflowPercent;
    }
    /**
     * @param preTaxflowPercent The preTaxflowPercent to set.
     */
    public void setPreTaxflowPercent(float preTaxflowPercent) {
        this.preTaxflowPercent = preTaxflowPercent;
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
     * @return Returns the pricePerUnit.
     */
    public int getPricePerUnit() {
        return pricePerUnit;
    }
    /**
     * @param pricePerUnit The pricePerUnit to set.
     */
    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
    /**
     * @return Returns the rentControl.
     */
    public boolean isRentControl() {
        return rentControl;
    }
    /**
     * @param rentControl The rentControl to set.
     */
    public void setRentControl(boolean rentControl) {
        this.rentControl = rentControl;
    }
    /**
     * @return Returns the repMaint.
     */
    public String getRepMaint() {
        return repMaint;
    }
    /**
     * @param repMaint The repMaint to set.
     */
    public void setRepMaint(String repMaint) {
        this.repMaint = repMaint;
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
     * @return Returns the resvPercent.
     */
    public float getResvPercent() {
        return resvPercent;
    }
    /**
     * @param resvPercent The resvPercent to set.
     */
    public void setResvPercent(float resvPercent) {
        this.resvPercent = resvPercent;
    }
    /**
     * @return Returns the roofType.
     */
    public String getRoofType() {
        return roofType;
    }
    /**
     * @param roofType The roofType to set.
     */
    public void setRoofType(String roofType) {
        this.roofType = roofType;
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
     * @return Returns the secAccess.
     */
    public boolean isSecAccess() {
        return secAccess;
    }
    /**
     * @param secAccess The secAccess to set.
     */
    public void setSecAccess(boolean secAccess) {
        this.secAccess = secAccess;
    }
    /**
     * @return Returns the spckFtrs.
     */
    public String getSpckFtrs() {
        return spckFtrs;
    }
    /**
     * @param spckFtrs The spckFtrs to set.
     */
    public void setSpckFtrs(String spckFtrs) {
        this.spckFtrs = spckFtrs;
    }
    /**
     * @return Returns the sprinklrd.
     */
    public boolean isSprinklrd() {
        return sprinklrd;
    }
    /**
     * @param sprinklrd The sprinklrd to set.
     */
    public void setSprinklrd(boolean sprinklrd) {
        this.sprinklrd = sprinklrd;
    }
    /**
     * @return Returns the studioUnits.
     */
    public int getStudioUnits() {
        return studioUnits;
    }
    /**
     * @param studioUnits The studioUnits to set.
     */
    public void setStudioUnits(int studioUnits) {
        this.studioUnits = studioUnits;
    }
    /**
     * @return Returns the taxPercent.
     */
    public int getTaxPercent() {
        return taxPercent;
    }
    /**
     * @param taxPercent The taxPercent to set.
     */
    public void setTaxPercent(int taxPercent) {
        this.taxPercent = taxPercent;
    }
    /**
     * @return Returns the taxRate.
     */
    public int getTaxRate() {
        return taxRate;
    }
    /**
     * @param taxRate The taxRate to set.
     */
    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }
    /**
     * @return Returns the taxRated.
     */
    public int getTaxRated() {
        return taxRated;
    }
    /**
     * @param taxRated The taxRated to set.
     */
    public void setTaxRated(int taxRated) {
        this.taxRated = taxRated;
    }
    /**
     * @return Returns the threeBedroomUnits.
     */
    public int getThreeBedroomUnits() {
        return threeBedroomUnits;
    }
    /**
     * @param threeBedroomUnits The threeBedroomUnits to set.
     */
    public void setThreeBedroomUnits(int threeBedroomUnits) {
        this.threeBedroomUnits = threeBedroomUnits;
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
     * @return Returns the twoBedroomUnits.
     */
    public int getTwoBedroomUnits() {
        return twoBedroomUnits;
    }
    /**
     * @param twoBedroomUnits The twoBedroomUnits to set.
     */
    public void setTwoBedroomUnits(int twoBedroomUnits) {
        this.twoBedroomUnits = twoBedroomUnits;
    }
    /**
     * @return Returns the type01.
     */
    public String getType01() {
        return type01;
    }
    /**
     * @param type01 The type01 to set.
     */
    public void setType01(String type01) {
        this.type01 = type01;
    }
    /**
     * @return Returns the type02.
     */
    public String getType02() {
        return type02;
    }
    /**
     * @param type02 The type02 to set.
     */
    public void setType02(String type02) {
        this.type02 = type02;
    }
    /**
     * @return Returns the type03.
     */
    public String getType03() {
        return type03;
    }
    /**
     * @param type03 The type03 to set.
     */
    public void setType03(String type03) {
        this.type03 = type03;
    }
    /**
     * @return Returns the type04.
     */
    public String getType04() {
        return type04;
    }
    /**
     * @param type04 The type04 to set.
     */
    public void setType04(String type04) {
        this.type04 = type04;
    }
    /**
     * @return Returns the type05.
     */
    public String getType05() {
        return type05;
    }
    /**
     * @param type05 The type05 to set.
     */
    public void setType05(String type05) {
        this.type05 = type05;
    }
    /**
     * @return Returns the type06.
     */
    public String getType06() {
        return type06;
    }
    /**
     * @param type06 The type06 to set.
     */
    public void setType06(String type06) {
        this.type06 = type06;
    }
    /**
     * @return Returns the type07.
     */
    public String getType07() {
        return type07;
    }
    /**
     * @param type07 The type07 to set.
     */
    public void setType07(String type07) {
        this.type07 = type07;
    }
    /**
     * @return Returns the type08.
     */
    public String getType08() {
        return type08;
    }
    /**
     * @param type08 The type08 to set.
     */
    public void setType08(String type08) {
        this.type08 = type08;
    }
    /**
     * @return Returns the type09.
     */
    public String getType09() {
        return type09;
    }
    /**
     * @param type09 The type09 to set.
     */
    public void setType09(String type09) {
        this.type09 = type09;
    }
    /**
     * @return Returns the type10.
     */
    public String getType10() {
        return type10;
    }
    /**
     * @param type10 The type10 to set.
     */
    public void setType10(String type10) {
        this.type10 = type10;
    }
    /**
     * @return Returns the type11.
     */
    public String getType11() {
        return type11;
    }
    /**
     * @param type11 The type11 to set.
     */
    public void setType11(String type11) {
        this.type11 = type11;
    }
    /**
     * @return Returns the type12.
     */
    public String getType12() {
        return type12;
    }
    /**
     * @param type12 The type12 to set.
     */
    public void setType12(String type12) {
        this.type12 = type12;
    }
    /**
     * @return Returns the type13.
     */
    public String getType13() {
        return type13;
    }
    /**
     * @param type13 The type13 to set.
     */
    public void setType13(String type13) {
        this.type13 = type13;
    }
    /**
     * @return Returns the type14.
     */
    public String getType14() {
        return type14;
    }
    /**
     * @param type14 The type14 to set.
     */
    public void setType14(String type14) {
        this.type14 = type14;
    }
    /**
     * @return Returns the type15.
     */
    public String getType15() {
        return type15;
    }
    /**
     * @param type15 The type15 to set.
     */
    public void setType15(String type15) {
        this.type15 = type15;
    }
    /**
     * @return Returns the type16.
     */
    public String getType16() {
        return type16;
    }
    /**
     * @param type16 The type16 to set.
     */
    public void setType16(String type16) {
        this.type16 = type16;
    }
    /**
     * @return Returns the type17.
     */
    public String getType17() {
        return type17;
    }
    /**
     * @param type17 The type17 to set.
     */
    public void setType17(String type17) {
        this.type17 = type17;
    }
    /**
     * @return Returns the type18.
     */
    public String getType18() {
        return type18;
    }
    /**
     * @param type18 The type18 to set.
     */
    public void setType18(String type18) {
        this.type18 = type18;
    }
    /**
     * @return Returns the type19.
     */
    public String getType19() {
        return type19;
    }
    /**
     * @param type19 The type19 to set.
     */
    public void setType19(String type19) {
        this.type19 = type19;
    }
    /**
     * @return Returns the unit10ID.
     */
    public int getUnit10ID() {
        return unit10ID;
    }
    /**
     * @param unit10ID The unit10ID to set.
     */
    public void setUnit10ID(int unit10ID) {
        this.unit10ID = unit10ID;
    }
    /**
     * @return Returns the unit10Rent.
     */
    public int getUnit10Rent() {
        return unit10Rent;
    }
    /**
     * @param unit10Rent The unit10Rent to set.
     */
    public void setUnit10Rent(int unit10Rent) {
        this.unit10Rent = unit10Rent;
    }
    /**
     * @return Returns the unit11.
     */
    public int getUnit11() {
        return unit11;
    }
    /**
     * @param unit11 The unit11 to set.
     */
    public void setUnit11(int unit11) {
        this.unit11 = unit11;
    }
    /**
     * @return Returns the unit11Rent.
     */
    public int getUnit11Rent() {
        return unit11Rent;
    }
    /**
     * @param unit11Rent The unit11Rent to set.
     */
    public void setUnit11Rent(int unit11Rent) {
        this.unit11Rent = unit11Rent;
    }
    /**
     * @return Returns the unit12.
     */
    public int getUnit12() {
        return unit12;
    }
    /**
     * @param unit12 The unit12 to set.
     */
    public void setUnit12(int unit12) {
        this.unit12 = unit12;
    }
    /**
     * @return Returns the unit12Rent.
     */
    public int getUnit12Rent() {
        return unit12Rent;
    }
    /**
     * @param unit12Rent The unit12Rent to set.
     */
    public void setUnit12Rent(int unit12Rent) {
        this.unit12Rent = unit12Rent;
    }
    /**
     * @return Returns the unit13.
     */
    public int getUnit13() {
        return unit13;
    }
    /**
     * @param unit13 The unit13 to set.
     */
    public void setUnit13(int unit13) {
        this.unit13 = unit13;
    }
    /**
     * @return Returns the unit13Rent.
     */
    public int getUnit13Rent() {
        return unit13Rent;
    }
    /**
     * @param unit13Rent The unit13Rent to set.
     */
    public void setUnit13Rent(int unit13Rent) {
        this.unit13Rent = unit13Rent;
    }
    /**
     * @return Returns the unit14.
     */
    public int getUnit14() {
        return unit14;
    }
    /**
     * @param unit14 The unit14 to set.
     */
    public void setUnit14(int unit14) {
        this.unit14 = unit14;
    }
    /**
     * @return Returns the unit14Rent.
     */
    public int getUnit14Rent() {
        return unit14Rent;
    }
    /**
     * @param unit14Rent The unit14Rent to set.
     */
    public void setUnit14Rent(int unit14Rent) {
        this.unit14Rent = unit14Rent;
    }
    /**
     * @return Returns the unit15.
     */
    public int getUnit15() {
        return unit15;
    }
    /**
     * @param unit15 The unit15 to set.
     */
    public void setUnit15(int unit15) {
        this.unit15 = unit15;
    }
    /**
     * @return Returns the unit15Rent.
     */
    public int getUnit15Rent() {
        return unit15Rent;
    }
    /**
     * @param unit15Rent The unit15Rent to set.
     */
    public void setUnit15Rent(int unit15Rent) {
        this.unit15Rent = unit15Rent;
    }
    /**
     * @return Returns the unit16.
     */
    public int getUnit16() {
        return unit16;
    }
    /**
     * @param unit16 The unit16 to set.
     */
    public void setUnit16(int unit16) {
        this.unit16 = unit16;
    }
    /**
     * @return Returns the unit16Rent.
     */
    public int getUnit16Rent() {
        return unit16Rent;
    }
    /**
     * @param unit16Rent The unit16Rent to set.
     */
    public void setUnit16Rent(int unit16Rent) {
        this.unit16Rent = unit16Rent;
    }
    /**
     * @return Returns the unit17.
     */
    public int getUnit17() {
        return unit17;
    }
    /**
     * @param unit17 The unit17 to set.
     */
    public void setUnit17(int unit17) {
        this.unit17 = unit17;
    }
    /**
     * @return Returns the unit17Rent.
     */
    public int getUnit17Rent() {
        return unit17Rent;
    }
    /**
     * @param unit17Rent The unit17Rent to set.
     */
    public void setUnit17Rent(int unit17Rent) {
        this.unit17Rent = unit17Rent;
    }
    /**
     * @return Returns the unit18.
     */
    public int getUnit18() {
        return unit18;
    }
    /**
     * @param unit18 The unit18 to set.
     */
    public void setUnit18(int unit18) {
        this.unit18 = unit18;
    }
    /**
     * @return Returns the unit18Rent.
     */
    public int getUnit18Rent() {
        return unit18Rent;
    }
    /**
     * @param unit18Rent The unit18Rent to set.
     */
    public void setUnit18Rent(int unit18Rent) {
        this.unit18Rent = unit18Rent;
    }
    /**
     * @return Returns the unit19.
     */
    public int getUnit19() {
        return unit19;
    }
    /**
     * @param unit19 The unit19 to set.
     */
    public void setUnit19(int unit19) {
        this.unit19 = unit19;
    }
    /**
     * @return Returns the unit19Rent.
     */
    public int getUnit19Rent() {
        return unit19Rent;
    }
    /**
     * @param unit19Rent The unit19Rent to set.
     */
    public void setUnit19Rent(int unit19Rent) {
        this.unit19Rent = unit19Rent;
    }
    /**
     * @return Returns the unit1ID.
     */
    public int getUnit1ID() {
        return unit1ID;
    }
    /**
     * @param unit1ID The unit1ID to set.
     */
    public void setUnit1ID(int unit1ID) {
        this.unit1ID = unit1ID;
    }
    /**
     * @return Returns the unit1Rent.
     */
    public int getUnit1Rent() {
        return unit1Rent;
    }
    /**
     * @param unit1Rent The unit1Rent to set.
     */
    public void setUnit1Rent(int unit1Rent) {
        this.unit1Rent = unit1Rent;
    }
    /**
     * @return Returns the unit2ID.
     */
    public int getUnit2ID() {
        return unit2ID;
    }
    /**
     * @param unit2ID The unit2ID to set.
     */
    public void setUnit2ID(int unit2ID) {
        this.unit2ID = unit2ID;
    }
    /**
     * @return Returns the unit2Rent.
     */
    public int getUnit2Rent() {
        return unit2Rent;
    }
    /**
     * @param unit2Rent The unit2Rent to set.
     */
    public void setUnit2Rent(int unit2Rent) {
        this.unit2Rent = unit2Rent;
    }
    /**
     * @return Returns the unit3ID.
     */
    public int getUnit3ID() {
        return unit3ID;
    }
    /**
     * @param unit3ID The unit3ID to set.
     */
    public void setUnit3ID(int unit3ID) {
        this.unit3ID = unit3ID;
    }
    /**
     * @return Returns the unit3Rent.
     */
    public int getUnit3Rent() {
        return unit3Rent;
    }
    /**
     * @param unit3Rent The unit3Rent to set.
     */
    public void setUnit3Rent(int unit3Rent) {
        this.unit3Rent = unit3Rent;
    }
    /**
     * @return Returns the unit4ID.
     */
    public int getUnit4ID() {
        return unit4ID;
    }
    /**
     * @param unit4ID The unit4ID to set.
     */
    public void setUnit4ID(int unit4ID) {
        this.unit4ID = unit4ID;
    }
    /**
     * @return Returns the unit4Rent.
     */
    public int getUnit4Rent() {
        return unit4Rent;
    }
    /**
     * @param unit4Rent The unit4Rent to set.
     */
    public void setUnit4Rent(int unit4Rent) {
        this.unit4Rent = unit4Rent;
    }
    /**
     * @return Returns the unit5ID.
     */
    public int getUnit5ID() {
        return unit5ID;
    }
    /**
     * @param unit5ID The unit5ID to set.
     */
    public void setUnit5ID(int unit5ID) {
        this.unit5ID = unit5ID;
    }
    /**
     * @return Returns the unit5Rent.
     */
    public int getUnit5Rent() {
        return unit5Rent;
    }
    /**
     * @param unit5Rent The unit5Rent to set.
     */
    public void setUnit5Rent(int unit5Rent) {
        this.unit5Rent = unit5Rent;
    }
    /**
     * @return Returns the unit6ID.
     */
    public int getUnit6ID() {
        return unit6ID;
    }
    /**
     * @param unit6ID The unit6ID to set.
     */
    public void setUnit6ID(int unit6ID) {
        this.unit6ID = unit6ID;
    }
    /**
     * @return Returns the unit6Rent.
     */
    public int getUnit6Rent() {
        return unit6Rent;
    }
    /**
     * @param unit6Rent The unit6Rent to set.
     */
    public void setUnit6Rent(int unit6Rent) {
        this.unit6Rent = unit6Rent;
    }
    /**
     * @return Returns the unit7ID.
     */
    public int getUnit7ID() {
        return unit7ID;
    }
    /**
     * @param unit7ID The unit7ID to set.
     */
    public void setUnit7ID(int unit7ID) {
        this.unit7ID = unit7ID;
    }
    /**
     * @return Returns the unit7Rent.
     */
    public int getUnit7Rent() {
        return unit7Rent;
    }
    /**
     * @param unit7Rent The unit7Rent to set.
     */
    public void setUnit7Rent(int unit7Rent) {
        this.unit7Rent = unit7Rent;
    }
    /**
     * @return Returns the unit8ID.
     */
    public int getUnit8ID() {
        return unit8ID;
    }
    /**
     * @param unit8ID The unit8ID to set.
     */
    public void setUnit8ID(int unit8ID) {
        this.unit8ID = unit8ID;
    }
    /**
     * @return Returns the unit8Rent.
     */
    public int getUnit8Rent() {
        return unit8Rent;
    }
    /**
     * @param unit8Rent The unit8Rent to set.
     */
    public void setUnit8Rent(int unit8Rent) {
        this.unit8Rent = unit8Rent;
    }
    /**
     * @return Returns the unit9ID.
     */
    public int getUnit9ID() {
        return unit9ID;
    }
    /**
     * @param unit9ID The unit9ID to set.
     */
    public void setUnit9ID(int unit9ID) {
        this.unit9ID = unit9ID;
    }
    /**
     * @return Returns the unit9Rent.
     */
    public int getUnit9Rent() {
        return unit9Rent;
    }
    /**
     * @param unit9Rent The unit9Rent to set.
     */
    public void setUnit9Rent(int unit9Rent) {
        this.unit9Rent = unit9Rent;
    }
    /**
     * @return Returns the utilElec.
     */
    public String getUtilElec() {
        return utilElec;
    }
    /**
     * @param utilElec The utilElec to set.
     */
    public void setUtilElec(String utilElec) {
        this.utilElec = utilElec;
    }
    /**
     * @return Returns the utilGas.
     */
    public String getUtilGas() {
        return utilGas;
    }
    /**
     * @param utilGas The utilGas to set.
     */
    public void setUtilGas(String utilGas) {
        this.utilGas = utilGas;
    }
    /**
     * @return Returns the utilHeater.
     */
    public String getUtilHeater() {
        return utilHeater;
    }
    /**
     * @param utilHeater The utilHeater to set.
     */
    public void setUtilHeater(String utilHeater) {
        this.utilHeater = utilHeater;
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
     * @return Returns the utilWater.
     */
    public String getUtilWater() {
        return utilWater;
    }
    /**
     * @param utilWater The utilWater to set.
     */
    public void setUtilWater(String utilWater) {
        this.utilWater = utilWater;
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

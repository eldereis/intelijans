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
public class MobileHome extends Residence {
    private String spaceNumber;
    private String shortPay;
    private String requestedDeposit;
    private String requestedTimeInEscrow;
    private String requestedPossession;
    private String parkName;
    private int newSpaceRent;
    private String parkDeposit;
    private int homeAssocFee;
    private String hoaFeePeriod;
    private String manufacturerName;
    private String tradeName;
    private Date manufactureDate;
    private String serialNumber1;
    private String serialNumber2;
    private String serialNumber3;
    private String serialNumber4;
    private String decimalNumber;
    private String label1;
    private String label2;
    private String label3;
    private String label4;
    private String size;
    private boolean agt;
    private String homeProtPlan;
    private boolean landIncluded;
    private String ownerName;
    private String ownerPhone;
    private String managerName;
    private String managerPhone;
    private Date dateAdded;
    private Date modTimeStamp;
    private Date photoTimeStamp;
    private boolean clothesDryer;
    private boolean clothesWasher;
    private boolean cnt1031Exchange;
    private boolean concurrentClose;
    private boolean courtApproval;
    private boolean homeOfChoice;
    private boolean jobTransfer;
    private boolean lenderApproval;
    private boolean nodFiled;
    private boolean cntNone;
    private boolean cntOther;
    private boolean front;
    private boolean back;
    private boolean block;
    private boolean chainLink;
    private boolean fnmWood;
    private boolean wroughtIron;
    private boolean combination;
    private boolean fnmNone;
    private boolean awnings;
    private boolean patio;
    private boolean porch;
    private boolean shed;
    private boolean ramp;
    private boolean metal;
    private boolean mxtWood;
    private boolean mxtCombination;
    private boolean siding;
    private boolean other;
    private boolean senior;
    private boolean barbecues;
    private boolean clubhouse;
    private boolean pool;
    private boolean spa;
    private boolean family;
    private boolean gated;
    private boolean gym;
    private boolean playground;
    private boolean recreationArea;
    private boolean rvParking;
    private boolean tennisCourts;
    private boolean sauna;
    private boolean securityComplex;
    private boolean securityPerson;
    private boolean pftNone;
    private boolean rock;
    private boolean flat;
    private boolean sewerConnected;
    private boolean sewerFeePaid;
    private boolean sewerLien;
    private boolean sewerUnknown;
    private boolean fha;
    private boolean va;
    private boolean ownerWillCarry;
    private boolean aitd;
    private boolean assumWithQual;
    private boolean calVet;
    private boolean cash;
    private boolean conventional;
    private boolean exchange;
    private boolean landContract;
    private boolean leaseOption;
    private boolean leasePurchase;
    private boolean assumeWithNoQual;
    private boolean vaNoNo;
    private boolean trmOther;
    private String petsAllowed;
    private String specialCommAgreement;
    private boolean doubleWide;
    private boolean doubleExpando;
    private boolean expando;
    private boolean quad;
    private boolean singleWide;
    private boolean tripleWide;
    private String virtualTour;
    private int longitude;
    private String companyList;
    private String companySale;
    private int cmaLimitTime;
    /**
     * @return Returns the agt.
     */
    public boolean isAgt() {
        return agt;
    }
    /**
     * @param agt The agt to set.
     */
    public void setAgt(boolean agt) {
        this.agt = agt;
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
     * @return Returns the assumeWithNoQual.
     */
    public boolean isAssumeWithNoQual() {
        return assumeWithNoQual;
    }
    /**
     * @param assumeWithNoQual The assumeWithNoQual to set.
     */
    public void setAssumeWithNoQual(boolean assumeWithNoQual) {
        this.assumeWithNoQual = assumeWithNoQual;
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
     * @return Returns the awnings.
     */
    public boolean isAwnings() {
        return awnings;
    }
    /**
     * @param awnings The awnings to set.
     */
    public void setAwnings(boolean awnings) {
        this.awnings = awnings;
    }
    /**
     * @return Returns the back.
     */
    public boolean isBack() {
        return back;
    }
    /**
     * @param back The back to set.
     */
    public void setBack(boolean back) {
        this.back = back;
    }
    /**
     * @return Returns the barbecues.
     */
    public boolean isBarbecues() {
        return barbecues;
    }
    /**
     * @param barbecues The barbecues to set.
     */
    public void setBarbecues(boolean barbecues) {
        this.barbecues = barbecues;
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
     * @return Returns the calVet.
     */
    public boolean isCalVet() {
        return calVet;
    }
    /**
     * @param calVet The calVet to set.
     */
    public void setCalVet(boolean calVet) {
        this.calVet = calVet;
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
     * @return Returns the chainLink.
     */
    public boolean isChainLink() {
        return chainLink;
    }
    /**
     * @param chainLink The chainLink to set.
     */
    public void setChainLink(boolean chainLink) {
        this.chainLink = chainLink;
    }
    /**
     * @return Returns the clothesDryer.
     */
    public boolean isClothesDryer() {
        return clothesDryer;
    }
    /**
     * @param clothesDryer The clothesDryer to set.
     */
    public void setClothesDryer(boolean clothesDryer) {
        this.clothesDryer = clothesDryer;
    }
    /**
     * @return Returns the clothesWasher.
     */
    public boolean isClothesWasher() {
        return clothesWasher;
    }
    /**
     * @param clothesWasher The clothesWasher to set.
     */
    public void setClothesWasher(boolean clothesWasher) {
        this.clothesWasher = clothesWasher;
    }
    /**
     * @return Returns the clubhouse.
     */
    public boolean isClubhouse() {
        return clubhouse;
    }
    /**
     * @param clubhouse The clubhouse to set.
     */
    public void setClubhouse(boolean clubhouse) {
        this.clubhouse = clubhouse;
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
     * @return Returns the combination.
     */
    public boolean isCombination() {
        return combination;
    }
    /**
     * @param combination The combination to set.
     */
    public void setCombination(boolean combination) {
        this.combination = combination;
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
     * @return Returns the decimalNumber.
     */
    public String getDecimalNumber() {
        return decimalNumber;
    }
    /**
     * @param decimalNumber The decimalNumber to set.
     */
    public void setDecimalNumber(String decimalNumber) {
        this.decimalNumber = decimalNumber;
    }
    /**
     * @return Returns the doubleExpando.
     */
    public boolean isDoubleExpando() {
        return doubleExpando;
    }
    /**
     * @param doubleExpando The doubleExpando to set.
     */
    public void setDoubleExpando(boolean doubleExpando) {
        this.doubleExpando = doubleExpando;
    }
    /**
     * @return Returns the doubleWide.
     */
    public boolean isDoubleWide() {
        return doubleWide;
    }
    /**
     * @param doubleWide The doubleWide to set.
     */
    public void setDoubleWide(boolean doubleWide) {
        this.doubleWide = doubleWide;
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
     * @return Returns the expando.
     */
    public boolean isExpando() {
        return expando;
    }
    /**
     * @param expando The expando to set.
     */
    public void setExpando(boolean expando) {
        this.expando = expando;
    }
    /**
     * @return Returns the family.
     */
    public boolean isFamily() {
        return family;
    }
    /**
     * @param family The family to set.
     */
    public void setFamily(boolean family) {
        this.family = family;
    }
    /**
     * @return Returns the fha.
     */
    public boolean isFha() {
        return fha;
    }
    /**
     * @param fha The fha to set.
     */
    public void setFha(boolean fha) {
        this.fha = fha;
    }
    /**
     * @return Returns the flat.
     */
    public boolean isFlat() {
        return flat;
    }
    /**
     * @param flat The flat to set.
     */
    public void setFlat(boolean flat) {
        this.flat = flat;
    }
    /**
     * @return Returns the fnmNone.
     */
    public boolean isFnmNone() {
        return fnmNone;
    }
    /**
     * @param fnmNone The fnmNone to set.
     */
    public void setFnmNone(boolean fnmNone) {
        this.fnmNone = fnmNone;
    }
    /**
     * @return Returns the front.
     */
    public boolean isFront() {
        return front;
    }
    /**
     * @param front The front to set.
     */
    public void setFront(boolean front) {
        this.front = front;
    }
    /**
     * @return Returns the gated.
     */
    public boolean isGated() {
        return gated;
    }
    /**
     * @param gated The gated to set.
     */
    public void setGated(boolean gated) {
        this.gated = gated;
    }
    /**
     * @return Returns the gym.
     */
    public boolean isGym() {
        return gym;
    }
    /**
     * @param gym The gym to set.
     */
    public void setGym(boolean gym) {
        this.gym = gym;
    }
    /**
     * @return Returns the hoaFeePeriod.
     */
    public String getHoaFeePeriod() {
        return hoaFeePeriod;
    }
    /**
     * @param hoaFeePeriod The hoaFeePeriod to set.
     */
    public void setHoaFeePeriod(String hoaFeePeriod) {
        this.hoaFeePeriod = hoaFeePeriod;
    }
    /**
     * @return Returns the homeAssocFee.
     */
    public int getHomeAssocFee() {
        return homeAssocFee;
    }
    /**
     * @param homeAssocFee The homeAssocFee to set.
     */
    public void setHomeAssocFee(int homeAssocFee) {
        this.homeAssocFee = homeAssocFee;
    }
    /**
     * @return Returns the homeOfChoice.
     */
    public boolean isHomeOfChoice() {
        return homeOfChoice;
    }
    /**
     * @param homeOfChoice The homeOfChoice to set.
     */
    public void setHomeOfChoice(boolean homeOfChoice) {
        this.homeOfChoice = homeOfChoice;
    }
    /**
     * @return Returns the homeProtPlan.
     */
    public String getHomeProtPlan() {
        return homeProtPlan;
    }
    /**
     * @param homeProtPlan The homeProtPlan to set.
     */
    public void setHomeProtPlan(String homeProtPlan) {
        this.homeProtPlan = homeProtPlan;
    }
    /**
     * @return Returns the jobTransfer.
     */
    public boolean isJobTransfer() {
        return jobTransfer;
    }
    /**
     * @param jobTransfer The jobTransfer to set.
     */
    public void setJobTransfer(boolean jobTransfer) {
        this.jobTransfer = jobTransfer;
    }
    /**
     * @return Returns the label1.
     */
    public String getLabel1() {
        return label1;
    }
    /**
     * @param label1 The label1 to set.
     */
    public void setLabel1(String label1) {
        this.label1 = label1;
    }
    /**
     * @return Returns the label2.
     */
    public String getLabel2() {
        return label2;
    }
    /**
     * @param label2 The label2 to set.
     */
    public void setLabel2(String label2) {
        this.label2 = label2;
    }
    /**
     * @return Returns the label3.
     */
    public String getLabel3() {
        return label3;
    }
    /**
     * @param label3 The label3 to set.
     */
    public void setLabel3(String label3) {
        this.label3 = label3;
    }
    /**
     * @return Returns the label4.
     */
    public String getLabel4() {
        return label4;
    }
    /**
     * @param label4 The label4 to set.
     */
    public void setLabel4(String label4) {
        this.label4 = label4;
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
     * @return Returns the landIncluded.
     */
    public boolean isLandIncluded() {
        return landIncluded;
    }
    /**
     * @param landIncluded The landIncluded to set.
     */
    public void setLandIncluded(boolean landIncluded) {
        this.landIncluded = landIncluded;
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
     * @return Returns the managerName.
     */
    public String getManagerName() {
        return managerName;
    }
    /**
     * @param managerName The managerName to set.
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    /**
     * @return Returns the managerPhone.
     */
    public String getManagerPhone() {
        return managerPhone;
    }
    /**
     * @param managerPhone The managerPhone to set.
     */
    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
    /**
     * @return Returns the manufactureDate.
     */
    public Date getManufactureDate() {
        return manufactureDate;
    }
    /**
     * @param manufactureDate The manufactureDate to set.
     */
    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    /**
     * @return Returns the manufacturerName.
     */
    public String getManufacturerName() {
        return manufacturerName;
    }
    /**
     * @param manufacturerName The manufacturerName to set.
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
    /**
     * @return Returns the metal.
     */
    public boolean isMetal() {
        return metal;
    }
    /**
     * @param metal The metal to set.
     */
    public void setMetal(boolean metal) {
        this.metal = metal;
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
     * @return Returns the mxtCombination.
     */
    public boolean isMxtCombination() {
        return mxtCombination;
    }
    /**
     * @param mxtCombination The mxtCombination to set.
     */
    public void setMxtCombination(boolean mxtCombination) {
        this.mxtCombination = mxtCombination;
    }
    /**
     * @return Returns the mxtWood.
     */
    public boolean isMxtWood() {
        return mxtWood;
    }
    /**
     * @param mxtWood The mxtWood to set.
     */
    public void setMxtWood(boolean mxtWood) {
        this.mxtWood = mxtWood;
    }
    /**
     * @return Returns the newSpaceRent.
     */
    public int getNewSpaceRent() {
        return newSpaceRent;
    }
    /**
     * @param newSpaceRent The newSpaceRent to set.
     */
    public void setNewSpaceRent(int newSpaceRent) {
        this.newSpaceRent = newSpaceRent;
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
     * @return Returns the parkDeposit.
     */
    public String getParkDeposit() {
        return parkDeposit;
    }
    /**
     * @param parkDeposit The parkDeposit to set.
     */
    public void setParkDeposit(String parkDeposit) {
        this.parkDeposit = parkDeposit;
    }
    /**
     * @return Returns the parkName.
     */
    public String getParkName() {
        return parkName;
    }
    /**
     * @param parkName The parkName to set.
     */
    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
    /**
     * @return Returns the patio.
     */
    public boolean isPatio() {
        return patio;
    }
    /**
     * @param patio The patio to set.
     */
    public void setPatio(boolean patio) {
        this.patio = patio;
    }
    /**
     * @return Returns the petsAllowed.
     */
    public String getPetsAllowed() {
        return petsAllowed;
    }
    /**
     * @param petsAllowed The petsAllowed to set.
     */
    public void setPetsAllowed(String petsAllowed) {
        this.petsAllowed = petsAllowed;
    }
    /**
     * @return Returns the pftNone.
     */
    public boolean isPftNone() {
        return pftNone;
    }
    /**
     * @param pftNone The pftNone to set.
     */
    public void setPftNone(boolean pftNone) {
        this.pftNone = pftNone;
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
     * @return Returns the playground.
     */
    public boolean isPlayground() {
        return playground;
    }
    /**
     * @param playground The playground to set.
     */
    public void setPlayground(boolean playground) {
        this.playground = playground;
    }
    /**
     * @return Returns the pool.
     */
    public boolean isPool() {
        return pool;
    }
    /**
     * @param pool The pool to set.
     */
    public void setPool(boolean pool) {
        this.pool = pool;
    }
    /**
     * @return Returns the porch.
     */
    public boolean isPorch() {
        return porch;
    }
    /**
     * @param porch The porch to set.
     */
    public void setPorch(boolean porch) {
        this.porch = porch;
    }
    /**
     * @return Returns the quad.
     */
    public boolean isQuad() {
        return quad;
    }
    /**
     * @param quad The quad to set.
     */
    public void setQuad(boolean quad) {
        this.quad = quad;
    }
    /**
     * @return Returns the ramp.
     */
    public boolean isRamp() {
        return ramp;
    }
    /**
     * @param ramp The ramp to set.
     */
    public void setRamp(boolean ramp) {
        this.ramp = ramp;
    }
    /**
     * @return Returns the recreationArea.
     */
    public boolean isRecreationArea() {
        return recreationArea;
    }
    /**
     * @param recreationArea The recreationArea to set.
     */
    public void setRecreationArea(boolean recreationArea) {
        this.recreationArea = recreationArea;
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
     * @return Returns the requestedTimeInEscrow.
     */
    public String getRequestedTimeInEscrow() {
        return requestedTimeInEscrow;
    }
    /**
     * @param requestedTimeInEscrow The requestedTimeInEscrow to set.
     */
    public void setRequestedTimeInEscrow(String requestedTimeInEscrow) {
        this.requestedTimeInEscrow = requestedTimeInEscrow;
    }
    /**
     * @return Returns the rock.
     */
    public boolean isRock() {
        return rock;
    }
    /**
     * @param rock The rock to set.
     */
    public void setRock(boolean rock) {
        this.rock = rock;
    }
    /**
     * @return Returns the rvParking.
     */
    public boolean isRvParking() {
        return rvParking;
    }
    /**
     * @param rvParking The rvParking to set.
     */
    public void setRvParking(boolean rvParking) {
        this.rvParking = rvParking;
    }
    /**
     * @return Returns the sauna.
     */
    public boolean isSauna() {
        return sauna;
    }
    /**
     * @param sauna The sauna to set.
     */
    public void setSauna(boolean sauna) {
        this.sauna = sauna;
    }
    /**
     * @return Returns the securityComplex.
     */
    public boolean isSecurityComplex() {
        return securityComplex;
    }
    /**
     * @param securityComplex The securityComplex to set.
     */
    public void setSecurityComplex(boolean securityComplex) {
        this.securityComplex = securityComplex;
    }
    /**
     * @return Returns the securityPerson.
     */
    public boolean isSecurityPerson() {
        return securityPerson;
    }
    /**
     * @param securityPerson The securityPerson to set.
     */
    public void setSecurityPerson(boolean securityPerson) {
        this.securityPerson = securityPerson;
    }
    /**
     * @return Returns the senior.
     */
    public boolean isSenior() {
        return senior;
    }
    /**
     * @param senior The senior to set.
     */
    public void setSenior(boolean senior) {
        this.senior = senior;
    }
    /**
     * @return Returns the serialNumber1.
     */
    public String getSerialNumber1() {
        return serialNumber1;
    }
    /**
     * @param serialNumber1 The serialNumber1 to set.
     */
    public void setSerialNumber1(String serialNumber1) {
        this.serialNumber1 = serialNumber1;
    }
    /**
     * @return Returns the serialNumber2.
     */
    public String getSerialNumber2() {
        return serialNumber2;
    }
    /**
     * @param serialNumber2 The serialNumber2 to set.
     */
    public void setSerialNumber2(String serialNumber2) {
        this.serialNumber2 = serialNumber2;
    }
    /**
     * @return Returns the serialNumber3.
     */
    public String getSerialNumber3() {
        return serialNumber3;
    }
    /**
     * @param serialNumber3 The serialNumber3 to set.
     */
    public void setSerialNumber3(String serialNumber3) {
        this.serialNumber3 = serialNumber3;
    }
    /**
     * @return Returns the serialNumber4.
     */
    public String getSerialNumber4() {
        return serialNumber4;
    }
    /**
     * @param serialNumber4 The serialNumber4 to set.
     */
    public void setSerialNumber4(String serialNumber4) {
        this.serialNumber4 = serialNumber4;
    }
    /**
     * @return Returns the sewerConnected.
     */
    public boolean isSewerConnected() {
        return sewerConnected;
    }
    /**
     * @param sewerConnected The sewerConnected to set.
     */
    public void setSewerConnected(boolean sewerConnected) {
        this.sewerConnected = sewerConnected;
    }
    /**
     * @return Returns the sewerFeePaid.
     */
    public boolean isSewerFeePaid() {
        return sewerFeePaid;
    }
    /**
     * @param sewerFeePaid The sewerFeePaid to set.
     */
    public void setSewerFeePaid(boolean sewerFeePaid) {
        this.sewerFeePaid = sewerFeePaid;
    }
    /**
     * @return Returns the sewerLien.
     */
    public boolean isSewerLien() {
        return sewerLien;
    }
    /**
     * @param sewerLien The sewerLien to set.
     */
    public void setSewerLien(boolean sewerLien) {
        this.sewerLien = sewerLien;
    }
    /**
     * @return Returns the sewerUnknown.
     */
    public boolean isSewerUnknown() {
        return sewerUnknown;
    }
    /**
     * @param sewerUnknown The sewerUnknown to set.
     */
    public void setSewerUnknown(boolean sewerUnknown) {
        this.sewerUnknown = sewerUnknown;
    }
    /**
     * @return Returns the shed.
     */
    public boolean isShed() {
        return shed;
    }
    /**
     * @param shed The shed to set.
     */
    public void setShed(boolean shed) {
        this.shed = shed;
    }
    /**
     * @return Returns the shortPay.
     */
    public String getShortPay() {
        return shortPay;
    }
    /**
     * @param shortPay The shortPay to set.
     */
    public void setShortPay(String shortPay) {
        this.shortPay = shortPay;
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
     * @return Returns the singleWide.
     */
    public boolean isSingleWide() {
        return singleWide;
    }
    /**
     * @param singleWide The singleWide to set.
     */
    public void setSingleWide(boolean singleWide) {
        this.singleWide = singleWide;
    }
    /**
     * @return Returns the size.
     */
    public String getSize() {
        return size;
    }
    /**
     * @param size The size to set.
     */
    public void setSize(String size) {
        this.size = size;
    }
    /**
     * @return Returns the spa.
     */
    public boolean isSpa() {
        return spa;
    }
    /**
     * @param spa The spa to set.
     */
    public void setSpa(boolean spa) {
        this.spa = spa;
    }
    /**
     * @return Returns the spaceNumber.
     */
    public String getSpaceNumber() {
        return spaceNumber;
    }
    /**
     * @param spaceNumber The spaceNumber to set.
     */
    public void setSpaceNumber(String spaceNumber) {
        this.spaceNumber = spaceNumber;
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
     * @return Returns the tennisCourts.
     */
    public boolean isTennisCourts() {
        return tennisCourts;
    }
    /**
     * @param tennisCourts The tennisCourts to set.
     */
    public void setTennisCourts(boolean tennisCourts) {
        this.tennisCourts = tennisCourts;
    }
    /**
     * @return Returns the tradeName.
     */
    public String getTradeName() {
        return tradeName;
    }
    /**
     * @param tradeName The tradeName to set.
     */
    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
    /**
     * @return Returns the tripleWide.
     */
    public boolean isTripleWide() {
        return tripleWide;
    }
    /**
     * @param tripleWide The tripleWide to set.
     */
    public void setTripleWide(boolean tripleWide) {
        this.tripleWide = tripleWide;
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
     * @return Returns the va.
     */
    public boolean isVa() {
        return va;
    }
    /**
     * @param va The va to set.
     */
    public void setVa(boolean va) {
        this.va = va;
    }
    /**
     * @return Returns the vaNoNo.
     */
    public boolean isVaNoNo() {
        return vaNoNo;
    }
    /**
     * @param vaNoNo The vaNoNo to set.
     */
    public void setVaNoNo(boolean vaNoNo) {
        this.vaNoNo = vaNoNo;
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
     * @return Returns the wroughtIron.
     */
    public boolean isWroughtIron() {
        return wroughtIron;
    }
    /**
     * @param wroughtIron The wroughtIron to set.
     */
    public void setWroughtIron(boolean wroughtIron) {
        this.wroughtIron = wroughtIron;
    }
    /**
     * @return Returns the fnmWood.
     */
    public boolean isFnmWood() {
        return fnmWood;
    }
    /**
     * @param fnmWood The fnmWood to set.
     */
    public void setFnmWood(boolean fnmWood) {
        this.fnmWood = fnmWood;
    }
}

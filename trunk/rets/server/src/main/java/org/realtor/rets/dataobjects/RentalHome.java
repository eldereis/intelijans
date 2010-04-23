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
public class RentalHome extends Residence {
    private int tractNumber;
    private String attachedOrDetachedResidence;
    private int securityDepositRequired;
    private int totalMoveIn;
    private boolean creditReport;
    private String petsAllowed;
    private Date dateAvailable;
    private int improvedSquareFeet;
    private int lotSquareFeet;
    private String lotSizeRange;
    private String zoning;
    private String tractName;
    private String occupantName;
    private String occupantPhone;
    private Date dateAdded;
    private Date modTimeStamp;
    private Date photoTimeStamp;
    private boolean communityPool;
    private boolean communityTennisCourt;
    private boolean exteriorMaint;
    private boolean foundation;
    private boolean greenbeltPark;
    private boolean guardSecurity;
    private boolean insurance;
    private boolean recreationBuilding;
    private boolean roofMaint;
    private boolean sauna;
    private boolean spa;
    private boolean storageArea;
    private boolean trashRemoval;
    private boolean water;
    private boolean waterHot;
    private boolean hoaOther;
    private boolean hoaNone;
    private boolean unknown;
    private boolean apartStyle;
    private boolean townhouse;
    private boolean manufactured;
    private boolean sfd;
    private boolean pud;
    private boolean detachedCondo;
    private boolean accessoryBuildings;
    private boolean ageRestriction;
    private boolean atrium;
    private boolean bonusRoom;
    private boolean cabana;
    private boolean elevator;
    private boolean gatedCommunity;
    private boolean guestHouse;
    private boolean guestQuarters;
    private boolean horseFacilities;
    private boolean loft;
    private boolean playground;
    private boolean recreationRoom;
    private boolean ftrSauna;
    private boolean tennisCourt;
    private boolean waterfront;
    private boolean workshop;
    private boolean block;
    private boolean chainLink;
    private boolean slumpStone;
    private boolean fenceWood;
    private boolean wroughtIron;
    private boolean front;
    private boolean back;
    private boolean cross;
    private boolean fncOther;
    private boolean fncNone;
    private boolean garage4CarOrMore;
    private boolean garagePullThru;
    private boolean garageTandem;
    private boolean garageDirectAccess;
    private boolean garageAttached;
    private boolean garageDetached;
    private boolean garageConverted;
    private boolean hrsYes;
    private boolean hrsNo;
    private boolean hrsSeeRemarks;
    private boolean balcony;
    private boolean covered;
    private boolean deck;
    private boolean enclosed;
    private boolean slab;
    private boolean permitted;
    private boolean ptoOther;
    private boolean ptoNone;
    private boolean poolEquipment;
    private boolean poolPrivate;
    private boolean community;
    private boolean aboveGround;
    private boolean inGroundGunite;
    private boolean inGroundOther;
    private boolean fenced;
    private boolean gasHeated;
    private boolean solarHeated;
    private boolean poolNone;
    private boolean asphalt;
    private boolean concreteShake;
    private boolean woodShingle;
    private boolean rvaYes;
    private boolean rvaNo;
    private boolean common;
    private boolean rvaCovered;
    private boolean paved;
    private boolean possible;
    private boolean spaPrivate;
    private boolean spaCommunity;
    private boolean spaAboveGround;
    private boolean spaInGroundGunite;
    private boolean spaInGroundOther;
    private boolean spaGasHeated;
    private boolean spaSolarHeated;
    private boolean spaNone;
    private boolean capeCod;
    private boolean colonial;
    private boolean contemporary;
    private boolean french;
    private boolean mediterranean;
    private boolean modern;
    private boolean ranch;
    private boolean spanish;
    private boolean traditional;
    private boolean tudor;
    private boolean victorian;
    private boolean styOther;
    private boolean oneStory;
    private boolean twoStory;
    private boolean threeStory;
    private boolean fourStory;
    private boolean splitLevel;
    private boolean triLevel;
    private boolean upperLevel;
    private boolean lowerLevel;
    private boolean stlOther;
    private boolean electric;
    private boolean uopWater;
    private boolean cable;
    private boolean gas;
    private boolean trash;
    private boolean gardner;
    private boolean uopNone;
    private boolean lease;
    private boolean leaseOption;
    private boolean monthToMonth;
    private boolean section8;
    private String sca;
    private String virtualTour;
    private int longitude;
    private String companyList;
    private String companySale;
    private int cmaLimitTime;

    /**
     * @return Returns the aboveGround.
     */
    public boolean isAboveGround() {
        return aboveGround;
    }
    /**
     * @param aboveGround The aboveGround to set.
     */
    public void setAboveGround(boolean aboveGround) {
        this.aboveGround = aboveGround;
    }
    /**
     * @return Returns the accessoryBuildings.
     */
    public boolean isAccessoryBuildings() {
        return accessoryBuildings;
    }
    /**
     * @param accessoryBuildings The accessoryBuildings to set.
     */
    public void setAccessoryBuildings(boolean accessoryBuildings) {
        this.accessoryBuildings = accessoryBuildings;
    }
    /**
     * @return Returns the ageRestriction.
     */
    public boolean isAgeRestriction() {
        return ageRestriction;
    }
    /**
     * @param ageRestriction The ageRestriction to set.
     */
    public void setAgeRestriction(boolean ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
    /**
     * @return Returns the apartStyle.
     */
    public boolean isApartStyle() {
        return apartStyle;
    }
    /**
     * @param apartStyle The apartStyle to set.
     */
    public void setApartStyle(boolean apartStyle) {
        this.apartStyle = apartStyle;
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
     * @return Returns the atrium.
     */
    public boolean isAtrium() {
        return atrium;
    }
    /**
     * @param atrium The atrium to set.
     */
    public void setAtrium(boolean atrium) {
        this.atrium = atrium;
    }
    /**
     * @return Returns the attachedOrDetachedResidence.
     */
    public String getAttachedOrDetachedResidence() {
        return attachedOrDetachedResidence;
    }
    /**
     * @param attachedOrDetachedResidence The attachedOrDetachedResidence to set.
     */
    public void setAttachedOrDetachedResidence(
            String attachedOrDetachedResidence) {
        this.attachedOrDetachedResidence = attachedOrDetachedResidence;
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
     * @return Returns the balcony.
     */
    public boolean isBalcony() {
        return balcony;
    }
    /**
     * @param balcony The balcony to set.
     */
    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
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
     * @return Returns the bonusRoom.
     */
    public boolean isBonusRoom() {
        return bonusRoom;
    }
    /**
     * @param bonusRoom The bonusRoom to set.
     */
    public void setBonusRoom(boolean bonusRoom) {
        this.bonusRoom = bonusRoom;
    }
    /**
     * @return Returns the cabana.
     */
    public boolean isCabana() {
        return cabana;
    }
    /**
     * @param cabana The cabana to set.
     */
    public void setCabana(boolean cabana) {
        this.cabana = cabana;
    }
    /**
     * @return Returns the cable.
     */
    public boolean isCable() {
        return cable;
    }
    /**
     * @param cable The cable to set.
     */
    public void setCable(boolean cable) {
        this.cable = cable;
    }
    /**
     * @return Returns the capeCod.
     */
    public boolean isCapeCod() {
        return capeCod;
    }
    /**
     * @param capeCod The capeCod to set.
     */
    public void setCapeCod(boolean capeCod) {
        this.capeCod = capeCod;
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
     * @return Returns the colonial.
     */
    public boolean isColonial() {
        return colonial;
    }
    /**
     * @param colonial The colonial to set.
     */
    public void setColonial(boolean colonial) {
        this.colonial = colonial;
    }
    /**
     * @return Returns the common.
     */
    public boolean isCommon() {
        return common;
    }
    /**
     * @param common The common to set.
     */
    public void setCommon(boolean common) {
        this.common = common;
    }
    /**
     * @return Returns the community.
     */
    public boolean isCommunity() {
        return community;
    }
    /**
     * @param community The community to set.
     */
    public void setCommunity(boolean community) {
        this.community = community;
    }
    /**
     * @return Returns the communityPool.
     */
    public boolean isCommunityPool() {
        return communityPool;
    }
    /**
     * @param communityPool The communityPool to set.
     */
    public void setCommunityPool(boolean communityPool) {
        this.communityPool = communityPool;
    }
    /**
     * @return Returns the communityTennisCourt.
     */
    public boolean isCommunityTennisCourt() {
        return communityTennisCourt;
    }
    /**
     * @param communityTennisCourt The communityTennisCourt to set.
     */
    public void setCommunityTennisCourt(boolean communityTennisCourt) {
        this.communityTennisCourt = communityTennisCourt;
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
     * @return Returns the contemporary.
     */
    public boolean isContemporary() {
        return contemporary;
    }
    /**
     * @param contemporary The contemporary to set.
     */
    public void setContemporary(boolean contemporary) {
        this.contemporary = contemporary;
    }
    /**
     * @return Returns the covered.
     */
    public boolean isCovered() {
        return covered;
    }
    /**
     * @param covered The covered to set.
     */
    public void setCovered(boolean covered) {
        this.covered = covered;
    }
    /**
     * @return Returns the creditReport.
     */
    public boolean isCreditReport() {
        return creditReport;
    }
    /**
     * @param creditReport The creditReport to set.
     */
    public void setCreditReport(boolean creditReport) {
        this.creditReport = creditReport;
    }
    /**
     * @return Returns the cross.
     */
    public boolean isCross() {
        return cross;
    }
    /**
     * @param cross The cross to set.
     */
    public void setCross(boolean cross) {
        this.cross = cross;
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
     * @return Returns the dateAvailable.
     */
    public Date getDateAvailable() {
        return dateAvailable;
    }
    /**
     * @param dateAvailable The dateAvailable to set.
     */
    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }
    /**
     * @return Returns the deck.
     */
    public boolean isDeck() {
        return deck;
    }
    /**
     * @param deck The deck to set.
     */
    public void setDeck(boolean deck) {
        this.deck = deck;
    }
    /**
     * @return Returns the detachedCondo.
     */
    public boolean isDetachedCondo() {
        return detachedCondo;
    }
    /**
     * @param detachedCondo The detachedCondo to set.
     */
    public void setDetachedCondo(boolean detachedCondo) {
        this.detachedCondo = detachedCondo;
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
     * @return Returns the elevator.
     */
    public boolean isElevator() {
        return elevator;
    }
    /**
     * @param elevator The elevator to set.
     */
    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }
    /**
     * @return Returns the enclosed.
     */
    public boolean isEnclosed() {
        return enclosed;
    }
    /**
     * @param enclosed The enclosed to set.
     */
    public void setEnclosed(boolean enclosed) {
        this.enclosed = enclosed;
    }
    /**
     * @return Returns the exteriorMaint.
     */
    public boolean isExteriorMaint() {
        return exteriorMaint;
    }
    /**
     * @param exteriorMaint The exteriorMaint to set.
     */
    public void setExteriorMaint(boolean exteriorMaint) {
        this.exteriorMaint = exteriorMaint;
    }
    /**
     * @return Returns the fenced.
     */
    public boolean isFenced() {
        return fenced;
    }
    /**
     * @param fenced The fenced to set.
     */
    public void setFenced(boolean fenced) {
        this.fenced = fenced;
    }
    /**
     * @return Returns the fncNone.
     */
    public boolean isFncNone() {
        return fncNone;
    }
    /**
     * @param fncNone The fncNone to set.
     */
    public void setFncNone(boolean fncNone) {
        this.fncNone = fncNone;
    }
    /**
     * @return Returns the fncOther.
     */
    public boolean isFncOther() {
        return fncOther;
    }
    /**
     * @param fncOther The fncOther to set.
     */
    public void setFncOther(boolean fncOther) {
        this.fncOther = fncOther;
    }
    /**
     * @return Returns the foundation.
     */
    public boolean isFoundation() {
        return foundation;
    }
    /**
     * @param foundation The foundation to set.
     */
    public void setFoundation(boolean foundation) {
        this.foundation = foundation;
    }
    /**
     * @return Returns the fourStory.
     */
    public boolean isFourStory() {
        return fourStory;
    }
    /**
     * @param fourStory The fourStory to set.
     */
    public void setFourStory(boolean fourStory) {
        this.fourStory = fourStory;
    }
    /**
     * @return Returns the french.
     */
    public boolean isFrench() {
        return french;
    }
    /**
     * @param french The french to set.
     */
    public void setFrench(boolean french) {
        this.french = french;
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
     * @return Returns the ftrSauna.
     */
    public boolean isFtrSauna() {
        return ftrSauna;
    }
    /**
     * @param ftrSauna The ftrSauna to set.
     */
    public void setFtrSauna(boolean ftrSauna) {
        this.ftrSauna = ftrSauna;
    }
    /**
     * @return Returns the garage4CarOrMore.
     */
    public boolean isGarage4CarOrMore() {
        return garage4CarOrMore;
    }
    /**
     * @param garage4CarOrMore The garage4CarOrMore to set.
     */
    public void setGarage4CarOrMore(boolean garage4CarOrMore) {
        this.garage4CarOrMore = garage4CarOrMore;
    }
    /**
     * @return Returns the garageAttached.
     */
    public boolean isGarageAttached() {
        return garageAttached;
    }
    /**
     * @param garageAttached The garageAttached to set.
     */
    public void setGarageAttached(boolean garageAttached) {
        this.garageAttached = garageAttached;
    }
    /**
     * @return Returns the garageConverted.
     */
    public boolean isGarageConverted() {
        return garageConverted;
    }
    /**
     * @param garageConverted The garageConverted to set.
     */
    public void setGarageConverted(boolean garageConverted) {
        this.garageConverted = garageConverted;
    }
    /**
     * @return Returns the garageDetached.
     */
    public boolean isGarageDetached() {
        return garageDetached;
    }
    /**
     * @param garageDetached The garageDetached to set.
     */
    public void setGarageDetached(boolean garageDetached) {
        this.garageDetached = garageDetached;
    }
    /**
     * @return Returns the garageDirectAccess.
     */
    public boolean isGarageDirectAccess() {
        return garageDirectAccess;
    }
    /**
     * @param garageDirectAccess The garageDirectAccess to set.
     */
    public void setGarageDirectAccess(boolean garageDirectAccess) {
        this.garageDirectAccess = garageDirectAccess;
    }
    /**
     * @return Returns the garagePullThru.
     */
    public boolean isGaragePullThru() {
        return garagePullThru;
    }
    /**
     * @param garagePullThru The garagePullThru to set.
     */
    public void setGaragePullThru(boolean garagePullThru) {
        this.garagePullThru = garagePullThru;
    }
    /**
     * @return Returns the garageTandem.
     */
    public boolean isGarageTandem() {
        return garageTandem;
    }
    /**
     * @param garageTandem The garageTandem to set.
     */
    public void setGarageTandem(boolean garageTandem) {
        this.garageTandem = garageTandem;
    }
    /**
     * @return Returns the gardner.
     */
    public boolean isGardner() {
        return gardner;
    }
    /**
     * @param gardner The gardner to set.
     */
    public void setGardner(boolean gardner) {
        this.gardner = gardner;
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
     * @return Returns the gasHeated.
     */
    public boolean isGasHeated() {
        return gasHeated;
    }
    /**
     * @param gasHeated The gasHeated to set.
     */
    public void setGasHeated(boolean gasHeated) {
        this.gasHeated = gasHeated;
    }
    /**
     * @return Returns the gatedCommunity.
     */
    public boolean isGatedCommunity() {
        return gatedCommunity;
    }
    /**
     * @param gatedCommunity The gatedCommunity to set.
     */
    public void setGatedCommunity(boolean gatedCommunity) {
        this.gatedCommunity = gatedCommunity;
    }
    /**
     * @return Returns the greenbeltPark.
     */
    public boolean isGreenbeltPark() {
        return greenbeltPark;
    }
    /**
     * @param greenbeltPark The greenbeltPark to set.
     */
    public void setGreenbeltPark(boolean greenbeltPark) {
        this.greenbeltPark = greenbeltPark;
    }
    /**
     * @return Returns the guardSecurity.
     */
    public boolean isGuardSecurity() {
        return guardSecurity;
    }
    /**
     * @param guardSecurity The guardSecurity to set.
     */
    public void setGuardSecurity(boolean guardSecurity) {
        this.guardSecurity = guardSecurity;
    }
    /**
     * @return Returns the guestHouse.
     */
    public boolean isGuestHouse() {
        return guestHouse;
    }
    /**
     * @param guestHouse The guestHouse to set.
     */
    public void setGuestHouse(boolean guestHouse) {
        this.guestHouse = guestHouse;
    }
    /**
     * @return Returns the guestQuarters.
     */
    public boolean isGuestQuarters() {
        return guestQuarters;
    }
    /**
     * @param guestQuarters The guestQuarters to set.
     */
    public void setGuestQuarters(boolean guestQuarters) {
        this.guestQuarters = guestQuarters;
    }
    /**
     * @return Returns the hoaNone.
     */
    public boolean isHoaNone() {
        return hoaNone;
    }
    /**
     * @param hoaNone The hoaNone to set.
     */
    public void setHoaNone(boolean hoaNone) {
        this.hoaNone = hoaNone;
    }
    /**
     * @return Returns the hoaOther.
     */
    public boolean isHoaOther() {
        return hoaOther;
    }
    /**
     * @param hoaOther The hoaOther to set.
     */
    public void setHoaOther(boolean hoaOther) {
        this.hoaOther = hoaOther;
    }
    /**
     * @return Returns the horseFacilities.
     */
    public boolean isHorseFacilities() {
        return horseFacilities;
    }
    /**
     * @param horseFacilities The horseFacilities to set.
     */
    public void setHorseFacilities(boolean horseFacilities) {
        this.horseFacilities = horseFacilities;
    }
    /**
     * @return Returns the hrsNo.
     */
    public boolean isHrsNo() {
        return hrsNo;
    }
    /**
     * @param hrsNo The hrsNo to set.
     */
    public void setHrsNo(boolean hrsNo) {
        this.hrsNo = hrsNo;
    }
    /**
     * @return Returns the hrsSeeRemarks.
     */
    public boolean isHrsSeeRemarks() {
        return hrsSeeRemarks;
    }
    /**
     * @param hrsSeeRemarks The hrsSeeRemarks to set.
     */
    public void setHrsSeeRemarks(boolean hrsSeeRemarks) {
        this.hrsSeeRemarks = hrsSeeRemarks;
    }
    /**
     * @return Returns the hrsYes.
     */
    public boolean isHrsYes() {
        return hrsYes;
    }
    /**
     * @param hrsYes The hrsYes to set.
     */
    public void setHrsYes(boolean hrsYes) {
        this.hrsYes = hrsYes;
    }
    /**
     * @return Returns the improvedSquareFeet.
     */
    public int getImprovedSquareFeet() {
        return improvedSquareFeet;
    }
    /**
     * @param improvedSquareFeet The improvedSquareFeet to set.
     */
    public void setImprovedSquareFeet(int improvedSquareFeet) {
        this.improvedSquareFeet = improvedSquareFeet;
    }
    /**
     * @return Returns the inGroundGunite.
     */
    public boolean isInGroundGunite() {
        return inGroundGunite;
    }
    /**
     * @param inGroundGunite The inGroundGunite to set.
     */
    public void setInGroundGunite(boolean inGroundGunite) {
        this.inGroundGunite = inGroundGunite;
    }
    /**
     * @return Returns the inGroundOther.
     */
    public boolean isInGroundOther() {
        return inGroundOther;
    }
    /**
     * @param inGroundOther The inGroundOther to set.
     */
    public void setInGroundOther(boolean inGroundOther) {
        this.inGroundOther = inGroundOther;
    }
    /**
     * @return Returns the insurance.
     */
    public boolean isInsurance() {
        return insurance;
    }
    /**
     * @param insurance The insurance to set.
     */
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
    /**
     * @return Returns the lease.
     */
    public boolean isLease() {
        return lease;
    }
    /**
     * @param lease The lease to set.
     */
    public void setLease(boolean lease) {
        this.lease = lease;
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
     * @return Returns the loft.
     */
    public boolean isLoft() {
        return loft;
    }
    /**
     * @param loft The loft to set.
     */
    public void setLoft(boolean loft) {
        this.loft = loft;
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
     * @return Returns the lotSizeRange.
     */
    public String getLotSizeRange() {
        return lotSizeRange;
    }
    /**
     * @param lotSizeRange The lotSizeRange to set.
     */
    public void setLotSizeRange(String lotSizeRange) {
        this.lotSizeRange = lotSizeRange;
    }
    /**
     * @return Returns the lotSquareFeet.
     */
    public int getLotSquareFeet() {
        return lotSquareFeet;
    }
    /**
     * @param lotSquareFeet The lotSquareFeet to set.
     */
    public void setLotSquareFeet(int lotSquareFeet) {
        this.lotSquareFeet = lotSquareFeet;
    }
    /**
     * @return Returns the lowerLevel.
     */
    public boolean isLowerLevel() {
        return lowerLevel;
    }
    /**
     * @param lowerLevel The lowerLevel to set.
     */
    public void setLowerLevel(boolean lowerLevel) {
        this.lowerLevel = lowerLevel;
    }
    /**
     * @return Returns the manufactured.
     */
    public boolean isManufactured() {
        return manufactured;
    }
    /**
     * @param manufactured The manufactured to set.
     */
    public void setManufactured(boolean manufactured) {
        this.manufactured = manufactured;
    }
    /**
     * @return Returns the mediterranean.
     */
    public boolean isMediterranean() {
        return mediterranean;
    }
    /**
     * @param mediterranean The mediterranean to set.
     */
    public void setMediterranean(boolean mediterranean) {
        this.mediterranean = mediterranean;
    }
    /**
     * @return Returns the modern.
     */
    public boolean isModern() {
        return modern;
    }
    /**
     * @param modern The modern to set.
     */
    public void setModern(boolean modern) {
        this.modern = modern;
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
     * @return Returns the monthToMonth.
     */
    public boolean isMonthToMonth() {
        return monthToMonth;
    }
    /**
     * @param monthToMonth The monthToMonth to set.
     */
    public void setMonthToMonth(boolean monthToMonth) {
        this.monthToMonth = monthToMonth;
    }
    /**
     * @return Returns the occupantName.
     */
    public String getOccupantName() {
        return occupantName;
    }
    /**
     * @param occupantName The occupantName to set.
     */
    public void setOccupantName(String occupantName) {
        this.occupantName = occupantName;
    }
    /**
     * @return Returns the occupantPhone.
     */
    public String getOccupantPhone() {
        return occupantPhone;
    }
    /**
     * @param occupantPhone The occupantPhone to set.
     */
    public void setOccupantPhone(String occupantPhone) {
        this.occupantPhone = occupantPhone;
    }
    /**
     * @return Returns the oneStory.
     */
    public boolean isOneStory() {
        return oneStory;
    }
    /**
     * @param oneStory The oneStory to set.
     */
    public void setOneStory(boolean oneStory) {
        this.oneStory = oneStory;
    }
    /**
     * @return Returns the paved.
     */
    public boolean isPaved() {
        return paved;
    }
    /**
     * @param paved The paved to set.
     */
    public void setPaved(boolean paved) {
        this.paved = paved;
    }
    /**
     * @return Returns the permitted.
     */
    public boolean isPermitted() {
        return permitted;
    }
    /**
     * @param permitted The permitted to set.
     */
    public void setPermitted(boolean permitted) {
        this.permitted = permitted;
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
     * @return Returns the poolEquipment.
     */
    public boolean isPoolEquipment() {
        return poolEquipment;
    }
    /**
     * @param poolEquipment The poolEquipment to set.
     */
    public void setPoolEquipment(boolean poolEquipment) {
        this.poolEquipment = poolEquipment;
    }
    /**
     * @return Returns the poolNone.
     */
    public boolean isPoolNone() {
        return poolNone;
    }
    /**
     * @param poolNone The poolNone to set.
     */
    public void setPoolNone(boolean poolNone) {
        this.poolNone = poolNone;
    }
    /**
     * @return Returns the poolPrivate.
     */
    public boolean isPoolPrivate() {
        return poolPrivate;
    }
    /**
     * @param poolPrivate The poolPrivate to set.
     */
    public void setPoolPrivate(boolean poolPrivate) {
        this.poolPrivate = poolPrivate;
    }
    /**
     * @return Returns the possible.
     */
    public boolean isPossible() {
        return possible;
    }
    /**
     * @param possible The possible to set.
     */
    public void setPossible(boolean possible) {
        this.possible = possible;
    }
    /**
     * @return Returns the ptoNone.
     */
    public boolean isPtoNone() {
        return ptoNone;
    }
    /**
     * @param ptoNone The ptoNone to set.
     */
    public void setPtoNone(boolean ptoNone) {
        this.ptoNone = ptoNone;
    }
    /**
     * @return Returns the ptoOther.
     */
    public boolean isPtoOther() {
        return ptoOther;
    }
    /**
     * @param ptoOther The ptoOther to set.
     */
    public void setPtoOther(boolean ptoOther) {
        this.ptoOther = ptoOther;
    }
    /**
     * @return Returns the pud.
     */
    public boolean isPud() {
        return pud;
    }
    /**
     * @param pud The pud to set.
     */
    public void setPud(boolean pud) {
        this.pud = pud;
    }
    /**
     * @return Returns the ranch.
     */
    public boolean isRanch() {
        return ranch;
    }
    /**
     * @param ranch The ranch to set.
     */
    public void setRanch(boolean ranch) {
        this.ranch = ranch;
    }
    /**
     * @return Returns the recreationBuilding.
     */
    public boolean isRecreationBuilding() {
        return recreationBuilding;
    }
    /**
     * @param recreationBuilding The recreationBuilding to set.
     */
    public void setRecreationBuilding(boolean recreationBuilding) {
        this.recreationBuilding = recreationBuilding;
    }
    /**
     * @return Returns the recreationRoom.
     */
    public boolean isRecreationRoom() {
        return recreationRoom;
    }
    /**
     * @param recreationRoom The recreationRoom to set.
     */
    public void setRecreationRoom(boolean recreationRoom) {
        this.recreationRoom = recreationRoom;
    }
    /**
     * @return Returns the roofMaint.
     */
    public boolean isRoofMaint() {
        return roofMaint;
    }
    /**
     * @param roofMaint The roofMaint to set.
     */
    public void setRoofMaint(boolean roofMaint) {
        this.roofMaint = roofMaint;
    }
    /**
     * @return Returns the rvaCovered.
     */
    public boolean isRvaCovered() {
        return rvaCovered;
    }
    /**
     * @param rvaCovered The rvaCovered to set.
     */
    public void setRvaCovered(boolean rvaCovered) {
        this.rvaCovered = rvaCovered;
    }
    /**
     * @return Returns the rvaNo.
     */
    public boolean isRvaNo() {
        return rvaNo;
    }
    /**
     * @param rvaNo The rvaNo to set.
     */
    public void setRvaNo(boolean rvaNo) {
        this.rvaNo = rvaNo;
    }
    /**
     * @return Returns the rvaYes.
     */
    public boolean isRvaYes() {
        return rvaYes;
    }
    /**
     * @param rvaYes The rvaYes to set.
     */
    public void setRvaYes(boolean rvaYes) {
        this.rvaYes = rvaYes;
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
     * @return Returns the section8.
     */
    public boolean isSection8() {
        return section8;
    }
    /**
     * @param section8 The section8 to set.
     */
    public void setSection8(boolean section8) {
        this.section8 = section8;
    }
    /**
     * @return Returns the securityDepositRequired.
     */
    public int getSecurityDepositRequired() {
        return securityDepositRequired;
    }
    /**
     * @param securityDepositRequired The securityDepositRequired to set.
     */
    public void setSecurityDepositRequired(int securityDepositRequired) {
        this.securityDepositRequired = securityDepositRequired;
    }
    /**
     * @return Returns the sfd.
     */
    public boolean isSfd() {
        return sfd;
    }
    /**
     * @param sfd The sfd to set.
     */
    public void setSfd(boolean sfd) {
        this.sfd = sfd;
    }
    /**
     * @return Returns the slab.
     */
    public boolean isSlab() {
        return slab;
    }
    /**
     * @param slab The slab to set.
     */
    public void setSlab(boolean slab) {
        this.slab = slab;
    }
    /**
     * @return Returns the slumpStone.
     */
    public boolean isSlumpStone() {
        return slumpStone;
    }
    /**
     * @param slumpStone The slumpStone to set.
     */
    public void setSlumpStone(boolean slumpStone) {
        this.slumpStone = slumpStone;
    }
    /**
     * @return Returns the solarHeated.
     */
    public boolean isSolarHeated() {
        return solarHeated;
    }
    /**
     * @param solarHeated The solarHeated to set.
     */
    public void setSolarHeated(boolean solarHeated) {
        this.solarHeated = solarHeated;
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
     * @return Returns the spaAboveGround.
     */
    public boolean isSpaAboveGround() {
        return spaAboveGround;
    }
    /**
     * @param spaAboveGround The spaAboveGround to set.
     */
    public void setSpaAboveGround(boolean spaAboveGround) {
        this.spaAboveGround = spaAboveGround;
    }
    /**
     * @return Returns the spaCommunity.
     */
    public boolean isSpaCommunity() {
        return spaCommunity;
    }
    /**
     * @param spaCommunity The spaCommunity to set.
     */
    public void setSpaCommunity(boolean spaCommunity) {
        this.spaCommunity = spaCommunity;
    }
    /**
     * @return Returns the spaGasHeated.
     */
    public boolean isSpaGasHeated() {
        return spaGasHeated;
    }
    /**
     * @param spaGasHeated The spaGasHeated to set.
     */
    public void setSpaGasHeated(boolean spaGasHeated) {
        this.spaGasHeated = spaGasHeated;
    }
    /**
     * @return Returns the spaInGroundGunite.
     */
    public boolean isSpaInGroundGunite() {
        return spaInGroundGunite;
    }
    /**
     * @param spaInGroundGunite The spaInGroundGunite to set.
     */
    public void setSpaInGroundGunite(boolean spaInGroundGunite) {
        this.spaInGroundGunite = spaInGroundGunite;
    }
    /**
     * @return Returns the spaInGroundOther.
     */
    public boolean isSpaInGroundOther() {
        return spaInGroundOther;
    }
    /**
     * @param spaInGroundOther The spaInGroundOther to set.
     */
    public void setSpaInGroundOther(boolean spaInGroundOther) {
        this.spaInGroundOther = spaInGroundOther;
    }
    /**
     * @return Returns the spanish.
     */
    public boolean isSpanish() {
        return spanish;
    }
    /**
     * @param spanish The spanish to set.
     */
    public void setSpanish(boolean spanish) {
        this.spanish = spanish;
    }
    /**
     * @return Returns the spaNone.
     */
    public boolean isSpaNone() {
        return spaNone;
    }
    /**
     * @param spaNone The spaNone to set.
     */
    public void setSpaNone(boolean spaNone) {
        this.spaNone = spaNone;
    }
    /**
     * @return Returns the spaPrivate.
     */
    public boolean isSpaPrivate() {
        return spaPrivate;
    }
    /**
     * @param spaPrivate The spaPrivate to set.
     */
    public void setSpaPrivate(boolean spaPrivate) {
        this.spaPrivate = spaPrivate;
    }
    /**
     * @return Returns the spaSolarHeated.
     */
    public boolean isSpaSolarHeated() {
        return spaSolarHeated;
    }
    /**
     * @param spaSolarHeated The spaSolarHeated to set.
     */
    public void setSpaSolarHeated(boolean spaSolarHeated) {
        this.spaSolarHeated = spaSolarHeated;
    }
    /**
     * @return Returns the splitLevel.
     */
    public boolean isSplitLevel() {
        return splitLevel;
    }
    /**
     * @param splitLevel The splitLevel to set.
     */
    public void setSplitLevel(boolean splitLevel) {
        this.splitLevel = splitLevel;
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
     * @return Returns the styOther.
     */
    public boolean isStyOther() {
        return styOther;
    }
    /**
     * @param styOther The styOther to set.
     */
    public void setStyOther(boolean styOther) {
        this.styOther = styOther;
    }
    /**
     * @return Returns the tennisCourt.
     */
    public boolean isTennisCourt() {
        return tennisCourt;
    }
    /**
     * @param tennisCourt The tennisCourt to set.
     */
    public void setTennisCourt(boolean tennisCourt) {
        this.tennisCourt = tennisCourt;
    }
    /**
     * @return Returns the threeStory.
     */
    public boolean isThreeStory() {
        return threeStory;
    }
    /**
     * @param threeStory The threeStory to set.
     */
    public void setThreeStory(boolean threeStory) {
        this.threeStory = threeStory;
    }
    /**
     * @return Returns the totalMoveIn.
     */
    public int getTotalMoveIn() {
        return totalMoveIn;
    }
    /**
     * @param totalMoveIn The totalMoveIn to set.
     */
    public void setTotalMoveIn(int totalMoveIn) {
        this.totalMoveIn = totalMoveIn;
    }
    /**
     * @return Returns the townhouse.
     */
    public boolean isTownhouse() {
        return townhouse;
    }
    /**
     * @param townhouse The townhouse to set.
     */
    public void setTownhouse(boolean townhouse) {
        this.townhouse = townhouse;
    }
    /**
     * @return Returns the tractName.
     */
    public String getTractName() {
        return tractName;
    }
    /**
     * @param tractName The tractName to set.
     */
    public void setTractName(String tractName) {
        this.tractName = tractName;
    }
    /**
     * @return Returns the tractNumber.
     */
    public int getTractNumber() {
        return tractNumber;
    }
    /**
     * @param tractNumber The tractNumber to set.
     */
    public void setTractNumber(int tractNumber) {
        this.tractNumber = tractNumber;
    }
    /**
     * @return Returns the traditional.
     */
    public boolean isTraditional() {
        return traditional;
    }
    /**
     * @param traditional The traditional to set.
     */
    public void setTraditional(boolean traditional) {
        this.traditional = traditional;
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
     * @return Returns the trashRemoval.
     */
    public boolean isTrashRemoval() {
        return trashRemoval;
    }
    /**
     * @param trashRemoval The trashRemoval to set.
     */
    public void setTrashRemoval(boolean trashRemoval) {
        this.trashRemoval = trashRemoval;
    }
    /**
     * @return Returns the triLevel.
     */
    public boolean isTriLevel() {
        return triLevel;
    }
    /**
     * @param triLevel The triLevel to set.
     */
    public void setTriLevel(boolean triLevel) {
        this.triLevel = triLevel;
    }
    /**
     * @return Returns the tudor.
     */
    public boolean isTudor() {
        return tudor;
    }
    /**
     * @param tudor The tudor to set.
     */
    public void setTudor(boolean tudor) {
        this.tudor = tudor;
    }
    /**
     * @return Returns the twoStory.
     */
    public boolean isTwoStory() {
        return twoStory;
    }
    /**
     * @param twoStory The twoStory to set.
     */
    public void setTwoStory(boolean twoStory) {
        this.twoStory = twoStory;
    }
    /**
     * @return Returns the unknown.
     */
    public boolean isUnknown() {
        return unknown;
    }
    /**
     * @param unknown The unknown to set.
     */
    public void setUnknown(boolean unknown) {
        this.unknown = unknown;
    }
    /**
     * @return Returns the uopNone.
     */
    public boolean isUopNone() {
        return uopNone;
    }
    /**
     * @param uopNone The uopNone to set.
     */
    public void setUopNone(boolean uopNone) {
        this.uopNone = uopNone;
    }
    /**
     * @return Returns the uopWater.
     */
    public boolean isUopWater() {
        return uopWater;
    }
    /**
     * @param uopWater The uopWater to set.
     */
    public void setUopWater(boolean uopWater) {
        this.uopWater = uopWater;
    }
    /**
     * @return Returns the upperLevel.
     */
    public boolean isUpperLevel() {
        return upperLevel;
    }
    /**
     * @param upperLevel The upperLevel to set.
     */
    public void setUpperLevel(boolean upperLevel) {
        this.upperLevel = upperLevel;
    }
    /**
     * @return Returns the victorian.
     */
    public boolean isVictorian() {
        return victorian;
    }
    /**
     * @param victorian The victorian to set.
     */
    public void setVictorian(boolean victorian) {
        this.victorian = victorian;
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
     * @return Returns the water.
     */
    public boolean isWater() {
        return water;
    }
    /**
     * @param water The water to set.
     */
    public void setWater(boolean water) {
        this.water = water;
    }
    /**
     * @return Returns the waterfront.
     */
    public boolean isWaterfront() {
        return waterfront;
    }
    /**
     * @param waterfront The waterfront to set.
     */
    public void setWaterfront(boolean waterfront) {
        this.waterfront = waterfront;
    }
    /**
     * @return Returns the waterHot.
     */
    public boolean isWaterHot() {
        return waterHot;
    }
    /**
     * @param waterHot The waterHot to set.
     */
    public void setWaterHot(boolean waterHot) {
        this.waterHot = waterHot;
    }
    /**
     * @return Returns the wood.
     */
    public boolean isFenceWood() {
        return fenceWood;
    }
    /**
     * @param wood The wood to set.
     */
    public void setFenceWood(boolean wood) {
        this.fenceWood = wood;
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
     * @return Returns the workshop.
     */
    public boolean isWorkshop() {
        return workshop;
    }
    /**
     * @param workshop The workshop to set.
     */
    public void setWorkshop(boolean workshop) {
        this.workshop = workshop;
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

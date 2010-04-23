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
public class LotsAndLand extends Property {
    private float grossAcres;
    private int width;
    private int depth;
    private int appSquareFeetGross;
    private String downPaymentType;
    private String downPaymentAmount;
    private String zoning;
    private String zoningObtained;
    private String tractMap;
    private boolean signYesNo;
    private Date dateAdded;
    private Date modTimeStamp;
    private Date photoTimeStamp;
    private boolean buyerToAssume;
    private boolean sellerToPay;
    private boolean melloRoos;
    private boolean buyerToVerify;
    private boolean govenmentActionPending;
    private boolean bndNone;
    private boolean hasConditions;
    private boolean cerPending;
    private boolean cerCompleted;
    private boolean cerNotRequired;
    private boolean cerRequired;
    private boolean cerHasCertOfException;
    private boolean cerUnknown;
    private boolean cerNone;
    private String electric;
    private String legalAccess;
    private String roadSurface;
    private String telephone;
    private boolean sidewalks;
    private boolean curbs;
    private boolean streetLights;
    private boolean bonded;
    private boolean non;
    private boolean agricultural;
    private boolean residential;
    private boolean openSpace;
    private boolean lowDensity;
    private boolean hgh;
    private boolean qop;
    private boolean qof;
    private boolean mlt;
    private boolean com;
    private boolean inl;
    private boolean inh;
    private boolean rec;
    private boolean lanUnknown;
    private boolean unimproved;
    private boolean rdfPrivate;
    private boolean rdfPublic;
    private boolean rdfNone;
    private boolean sis;
    private boolean connected;
    private boolean feePaid;
    private boolean septicTank;
    private boolean cessPool;
    private boolean swlNone;
    private boolean swlUnknown;
    private boolean mutual;
    private boolean wtlPrivate;
    private boolean wtlPublic;
    private boolean stockCo;
    private boolean inStreet;
    private boolean ownWell;
    private boolean sharesWell;
    private boolean fireHydrant;
    private boolean other;
    private boolean wtlNone;
    private boolean square;
    private boolean rectangular;
    private boolean irregular;
    private boolean corner;
    private boolean culDeSac;
    private boolean done;
    private boolean sellerPays;
    private boolean buyerPays;
    private boolean cornersMarked;
    private boolean srvNone;
    private boolean fha;
    private boolean va;
    private boolean ownerWillCarry;
    private boolean aitd;
    private boolean assumWithQual;
    private boolean cash;
    private boolean conventional;
    private boolean exchange;
    private boolean landContract;
    private boolean leaseOption;
    private boolean leasePurchase;
    private boolean subjectTo;
    private boolean calVet;
    private boolean vaNoNo;
    private boolean trmOther;
    private boolean level;
    private int deleted;
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
     * @return Returns the appSquareFeetGross.
     */
    public int getAppSquareFeetGross() {
        return appSquareFeetGross;
    }
    /**
     * @param appSquareFeetGross The appSquareFeetGross to set.
     */
    public void setAppSquareFeetGross(int appSquareFeetGross) {
        this.appSquareFeetGross = appSquareFeetGross;
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
     * @return Returns the bndNone.
     */
    public boolean isBndNone() {
        return bndNone;
    }
    /**
     * @param bndNone The bndNone to set.
     */
    public void setBndNone(boolean bndNone) {
        this.bndNone = bndNone;
    }
    /**
     * @return Returns the bonded.
     */
    public boolean isBonded() {
        return bonded;
    }
    /**
     * @param bonded The bonded to set.
     */
    public void setBonded(boolean bonded) {
        this.bonded = bonded;
    }
    /**
     * @return Returns the buyerPays.
     */
    public boolean isBuyerPays() {
        return buyerPays;
    }
    /**
     * @param buyerPays The buyerPays to set.
     */
    public void setBuyerPays(boolean buyerPays) {
        this.buyerPays = buyerPays;
    }
    /**
     * @return Returns the buyerToAssume.
     */
    public boolean isBuyerToAssume() {
        return buyerToAssume;
    }
    /**
     * @param buyerToAssume The buyerToAssume to set.
     */
    public void setBuyerToAssume(boolean buyerToAssume) {
        this.buyerToAssume = buyerToAssume;
    }
    /**
     * @return Returns the buyerToVerify.
     */
    public boolean isBuyerToVerify() {
        return buyerToVerify;
    }
    /**
     * @param buyerToVerify The buyerToVerify to set.
     */
    public void setBuyerToVerify(boolean buyerToVerify) {
        this.buyerToVerify = buyerToVerify;
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
     * @return Returns the cerCompleted.
     */
    public boolean isCerCompleted() {
        return cerCompleted;
    }
    /**
     * @param cerCompleted The cerCompleted to set.
     */
    public void setCerCompleted(boolean cerCompleted) {
        this.cerCompleted = cerCompleted;
    }
    /**
     * @return Returns the cerHasCertOfException.
     */
    public boolean isCerHasCertOfException() {
        return cerHasCertOfException;
    }
    /**
     * @param cerHasCertOfException The cerHasCertOfException to set.
     */
    public void setCerHasCertOfException(boolean cerHasCertOfException) {
        this.cerHasCertOfException = cerHasCertOfException;
    }
    /**
     * @return Returns the cerNone.
     */
    public boolean isCerNone() {
        return cerNone;
    }
    /**
     * @param cerNone The cerNone to set.
     */
    public void setCerNone(boolean cerNone) {
        this.cerNone = cerNone;
    }
    /**
     * @return Returns the cerNotRequired.
     */
    public boolean isCerNotRequired() {
        return cerNotRequired;
    }
    /**
     * @param cerNotRequired The cerNotRequired to set.
     */
    public void setCerNotRequired(boolean cerNotRequired) {
        this.cerNotRequired = cerNotRequired;
    }
    /**
     * @return Returns the cerPending.
     */
    public boolean isCerPending() {
        return cerPending;
    }
    /**
     * @param cerPending The cerPending to set.
     */
    public void setCerPending(boolean cerPending) {
        this.cerPending = cerPending;
    }
    /**
     * @return Returns the cerRequired.
     */
    public boolean isCerRequired() {
        return cerRequired;
    }
    /**
     * @param cerRequired The cerRequired to set.
     */
    public void setCerRequired(boolean cerRequired) {
        this.cerRequired = cerRequired;
    }
    /**
     * @return Returns the cerUnknown.
     */
    public boolean isCerUnknown() {
        return cerUnknown;
    }
    /**
     * @param cerUnknown The cerUnknown to set.
     */
    public void setCerUnknown(boolean cerUnknown) {
        this.cerUnknown = cerUnknown;
    }
    /**
     * @return Returns the cessPool.
     */
    public boolean isCessPool() {
        return cessPool;
    }
    /**
     * @param cessPool The cessPool to set.
     */
    public void setCessPool(boolean cessPool) {
        this.cessPool = cessPool;
    }
    /**
     * @return Returns the cityLightsView.
     */
    public boolean isCityLightsView() {
        return cityLightsView;
    }
    /**
     * @param cityLightsView The cityLightsView to set.
     */
    public void setCityLightsView(boolean cityLightsView) {
        this.cityLightsView = cityLightsView;
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
     * @return Returns the com.
     */
    public boolean isCom() {
        return com;
    }
    /**
     * @param com The com to set.
     */
    public void setCom(boolean com) {
        this.com = com;
    }
    /**
     * @return Returns the combinedRemarks.
     */
    public boolean isCombinedRemarks() {
        return combinedRemarks;
    }
    /**
     * @param combinedRemarks The combinedRemarks to set.
     */
    public void setCombinedRemarks(boolean combinedRemarks) {
        this.combinedRemarks = combinedRemarks;
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
     * @return Returns the connected.
     */
    public boolean isConnected() {
        return connected;
    }
    /**
     * @param connected The connected to set.
     */
    public void setConnected(boolean connected) {
        this.connected = connected;
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
     * @return Returns the cornersMarked.
     */
    public boolean isCornersMarked() {
        return cornersMarked;
    }
    /**
     * @param cornersMarked The cornersMarked to set.
     */
    public void setCornersMarked(boolean cornersMarked) {
        this.cornersMarked = cornersMarked;
    }
    /**
     * @return Returns the culDeSac.
     */
    public boolean isCulDeSac() {
        return culDeSac;
    }
    /**
     * @param culDeSac The culDeSac to set.
     */
    public void setCulDeSac(boolean culDeSac) {
        this.culDeSac = culDeSac;
    }
    /**
     * @return Returns the curbs.
     */
    public boolean isCurbs() {
        return curbs;
    }
    /**
     * @param curbs The curbs to set.
     */
    public void setCurbs(boolean curbs) {
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
     * @return Returns the depth.
     */
    public int getDepth() {
        return depth;
    }
    /**
     * @param depth The depth to set.
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
    /**
     * @return Returns the delete flag.
     */
    public int getDeleted() {
        return deleted;
    }
    /**
     * @param deleted Set the delete flag.
     */
    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
    /**
     * @return Returns the done.
     */
    public boolean isDone() {
        return done;
    }
    /**
     * @param done The done to set.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
    /**
     * @return Returns the downPaymentAmount.
     */
    public String getDownPaymentAmount() {
        return downPaymentAmount;
    }
    /**
     * @param downPaymentAmount The downPaymentAmount to set.
     */
    public void setDownPaymentAmount(String downPaymentAmount) {
        this.downPaymentAmount = downPaymentAmount;
    }
    /**
     * @return Returns the downPaymentType.
     */
    public String getDownPaymentType() {
        return downPaymentType;
    }
    /**
     * @param downPaymentType The downPaymentType to set.
     */
    public void setDownPaymentType(String downPaymentType) {
        this.downPaymentType = downPaymentType;
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
     * @return Returns the electric.
     */
    public String getElectric() {
        return electric;
    }
    /**
     * @param electric The electric to set.
     */
    public void setElectric(String electric) {
        this.electric = electric;
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
     * @return Returns the feePaid.
     */
    public boolean isFeePaid() {
        return feePaid;
    }
    /**
     * @param feePaid The feePaid to set.
     */
    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
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
     * @return Returns the fireHydrant.
     */
    public boolean isFireHydrant() {
        return fireHydrant;
    }
    /**
     * @param fireHydrant The fireHydrant to set.
     */
    public void setFireHydrant(boolean fireHydrant) {
        this.fireHydrant = fireHydrant;
    }
    /**
     * @return Returns the ftlOther.
     */
    public boolean isFtlOther() {
        return ftlOther;
    }
    /**
     * @param ftlOther The ftlOther to set.
     */
    public void setFtlOther(boolean ftlOther) {
        this.ftlOther = ftlOther;
    }
    /**
     * @return Returns the gasNone.
     */
    public boolean isGasNone() {
        return gasNone;
    }
    /**
     * @param gasNone The gasNone to set.
     */
    public void setGasNone(boolean gasNone) {
        this.gasNone = gasNone;
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
     * @return Returns the geologicalCurrent.
     */
    public boolean isGeologicalCurrent() {
        return geologicalCurrent;
    }
    /**
     * @param geologicalCurrent The geologicalCurrent to set.
     */
    public void setGeologicalCurrent(boolean geologicalCurrent) {
        this.geologicalCurrent = geologicalCurrent;
    }
    /**
     * @return Returns the govenmentActionPending.
     */
    public boolean isGovenmentActionPending() {
        return govenmentActionPending;
    }
    /**
     * @param govenmentActionPending The govenmentActionPending to set.
     */
    public void setGovenmentActionPending(boolean govenmentActionPending) {
        this.govenmentActionPending = govenmentActionPending;
    }
    /**
     * @return Returns the grossAcres.
     */
    public float getGrossAcres() {
        return grossAcres;
    }
    /**
     * @param grossAcres The grossAcres to set.
     */
    public void setGrossAcres(float grossAcres) {
        this.grossAcres = grossAcres;
    }
    /**
     * @return Returns the hasConditions.
     */
    public boolean isHasConditions() {
        return hasConditions;
    }
    /**
     * @param hasConditions The hasConditions to set.
     */
    public void setHasConditions(boolean hasConditions) {
        this.hasConditions = hasConditions;
    }
    /**
     * @return Returns the hgh.
     */
    public boolean isHgh() {
        return hgh;
    }
    /**
     * @param hgh The hgh to set.
     */
    public void setHgh(boolean hgh) {
        this.hgh = hgh;
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
     * @return Returns the horseProperty.
     */
    public boolean isHorseProperty() {
        return horseProperty;
    }
    /**
     * @param horseProperty The horseProperty to set.
     */
    public void setHorseProperty(boolean horseProperty) {
        this.horseProperty = horseProperty;
    }
    /**
     * @return Returns the inh.
     */
    public boolean isInh() {
        return inh;
    }
    /**
     * @param inh The inh to set.
     */
    public void setInh(boolean inh) {
        this.inh = inh;
    }
    /**
     * @return Returns the inl.
     */
    public boolean isInl() {
        return inl;
    }
    /**
     * @param inl The inl to set.
     */
    public void setInl(boolean inl) {
        this.inl = inl;
    }
    /**
     * @return Returns the inStreet.
     */
    public boolean isInStreet() {
        return inStreet;
    }
    /**
     * @param inStreet The inStreet to set.
     */
    public void setInStreet(boolean inStreet) {
        this.inStreet = inStreet;
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
     * @return Returns the lanUnknown.
     */
    public boolean isLanUnknown() {
        return lanUnknown;
    }
    /**
     * @param lanUnknown The lanUnknown to set.
     */
    public void setLanUnknown(boolean lanUnknown) {
        this.lanUnknown = lanUnknown;
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
     * @return Returns the legalAccess.
     */
    public String getLegalAccess() {
        return legalAccess;
    }
    /**
     * @param legalAccess The legalAccess to set.
     */
    public void setLegalAccess(String legalAccess) {
        this.legalAccess = legalAccess;
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
     * @return Returns the lowDensity.
     */
    public boolean isLowDensity() {
        return lowDensity;
    }
    /**
     * @param lowDensity The lowDensity to set.
     */
    public void setLowDensity(boolean lowDensity) {
        this.lowDensity = lowDensity;
    }
    /**
     * @return Returns the melloRoos.
     */
    public boolean isMelloRoos() {
        return melloRoos;
    }
    /**
     * @param melloRoos The melloRoos to set.
     */
    public void setMelloRoos(boolean melloRoos) {
        this.melloRoos = melloRoos;
    }
    /**
     * @return Returns the mlt.
     */
    public boolean isMlt() {
        return mlt;
    }
    /**
     * @param mlt The mlt to set.
     */
    public void setMlt(boolean mlt) {
        this.mlt = mlt;
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
     * @return Returns the mountainView.
     */
    public boolean isMountainView() {
        return mountainView;
    }
    /**
     * @param mountainView The mountainView to set.
     */
    public void setMountainView(boolean mountainView) {
        this.mountainView = mountainView;
    }
    /**
     * @return Returns the mutual.
     */
    public boolean isMutual() {
        return mutual;
    }
    /**
     * @param mutual The mutual to set.
     */
    public void setMutual(boolean mutual) {
        this.mutual = mutual;
    }
    /**
     * @return Returns the naturalAvailable.
     */
    public boolean isNaturalAvailable() {
        return naturalAvailable;
    }
    /**
     * @param naturalAvailable The naturalAvailable to set.
     */
    public void setNaturalAvailable(boolean naturalAvailable) {
        this.naturalAvailable = naturalAvailable;
    }
    /**
     * @return Returns the non.
     */
    public boolean isNon() {
        return non;
    }
    /**
     * @param non The non to set.
     */
    public void setNon(boolean non) {
        this.non = non;
    }
    /**
     * @return Returns the onProperty.
     */
    public boolean isOnProperty() {
        return onProperty;
    }
    /**
     * @param onProperty The onProperty to set.
     */
    public void setOnProperty(boolean onProperty) {
        this.onProperty = onProperty;
    }
    /**
     * @return Returns the openSpace.
     */
    public boolean isOpenSpace() {
        return openSpace;
    }
    /**
     * @param openSpace The openSpace to set.
     */
    public void setOpenSpace(boolean openSpace) {
        this.openSpace = openSpace;
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
     * @return Returns the ownWell.
     */
    public boolean isOwnWell() {
        return ownWell;
    }
    /**
     * @param ownWell The ownWell to set.
     */
    public void setOwnWell(boolean ownWell) {
        this.ownWell = ownWell;
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
     * @return Returns the qof.
     */
    public boolean isQof() {
        return qof;
    }
    /**
     * @param qof The qof to set.
     */
    public void setQof(boolean qof) {
        this.qof = qof;
    }
    /**
     * @return Returns the qop.
     */
    public boolean isQop() {
        return qop;
    }
    /**
     * @param qop The qop to set.
     */
    public void setQop(boolean qop) {
        this.qop = qop;
    }
    /**
     * @return Returns the rdfNone.
     */
    public boolean isRdfNone() {
        return rdfNone;
    }
    /**
     * @param rdfNone The rdfNone to set.
     */
    public void setRdfNone(boolean rdfNone) {
        this.rdfNone = rdfNone;
    }
    /**
     * @return Returns the rdfPrivate.
     */
    public boolean isRdfPrivate() {
        return rdfPrivate;
    }
    /**
     * @param rdfPrivate The rdfPrivate to set.
     */
    public void setRdfPrivate(boolean rdfPrivate) {
        this.rdfPrivate = rdfPrivate;
    }
    /**
     * @return Returns the rdfPublic.
     */
    public boolean isRdfPublic() {
        return rdfPublic;
    }
    /**
     * @param rdfPublic The rdfPublic to set.
     */
    public void setRdfPublic(boolean rdfPublic) {
        this.rdfPublic = rdfPublic;
    }
    /**
     * @return Returns the rec.
     */
    public boolean isRec() {
        return rec;
    }
    /**
     * @param rec The rec to set.
     */
    public void setRec(boolean rec) {
        this.rec = rec;
    }
    /**
     * @return Returns the rectangular.
     */
    public boolean isRectangular() {
        return rectangular;
    }
    /**
     * @param rectangular The rectangular to set.
     */
    public void setRectangular(boolean rectangular) {
        this.rectangular = rectangular;
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
     * @return Returns the roadSurface.
     */
    public String getRoadSurface() {
        return roadSurface;
    }
    /**
     * @param roadSurface The roadSurface to set.
     */
    public void setRoadSurface(String roadSurface) {
        this.roadSurface = roadSurface;
    }
    /**
     * @return Returns the rptOther.
     */
    public boolean isRptOther() {
        return rptOther;
    }
    /**
     * @param rptOther The rptOther to set.
     */
    public void setRptOther(boolean rptOther) {
        this.rptOther = rptOther;
    }
    /**
     * @return Returns the sellerPays.
     */
    public boolean isSellerPays() {
        return sellerPays;
    }
    /**
     * @param sellerPays The sellerPays to set.
     */
    public void setSellerPays(boolean sellerPays) {
        this.sellerPays = sellerPays;
    }
    /**
     * @return Returns the sellerToPay.
     */
    public boolean isSellerToPay() {
        return sellerToPay;
    }
    /**
     * @param sellerToPay The sellerToPay to set.
     */
    public void setSellerToPay(boolean sellerToPay) {
        this.sellerToPay = sellerToPay;
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
     * @return Returns the sharesWell.
     */
    public boolean isSharesWell() {
        return sharesWell;
    }
    /**
     * @param sharesWell The sharesWell to set.
     */
    public void setSharesWell(boolean sharesWell) {
        this.sharesWell = sharesWell;
    }
    /**
     * @return Returns the sidewalks.
     */
    public boolean isSidewalks() {
        return sidewalks;
    }
    /**
     * @param sidewalks The sidewalks to set.
     */
    public void setSidewalks(boolean sidewalks) {
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
     * @return Returns the sis.
     */
    public boolean isSis() {
        return sis;
    }
    /**
     * @param sis The sis to set.
     */
    public void setSis(boolean sis) {
        this.sis = sis;
    }
    /**
     * @return Returns the soilsCurrent.
     */
    public boolean isSoilsCurrent() {
        return soilsCurrent;
    }
    /**
     * @param soilsCurrent The soilsCurrent to set.
     */
    public void setSoilsCurrent(boolean soilsCurrent) {
        this.soilsCurrent = soilsCurrent;
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
     * @return Returns the square.
     */
    public boolean isSquare() {
        return square;
    }
    /**
     * @param square The square to set.
     */
    public void setSquare(boolean square) {
        this.square = square;
    }
    /**
     * @return Returns the srvNone.
     */
    public boolean isSrvNone() {
        return srvNone;
    }
    /**
     * @param srvNone The srvNone to set.
     */
    public void setSrvNone(boolean srvNone) {
        this.srvNone = srvNone;
    }
    /**
     * @return Returns the stockCo.
     */
    public boolean isStockCo() {
        return stockCo;
    }
    /**
     * @param stockCo The stockCo to set.
     */
    public void setStockCo(boolean stockCo) {
        this.stockCo = stockCo;
    }
    /**
     * @return Returns the streetLights.
     */
    public boolean isStreetLights() {
        return streetLights;
    }
    /**
     * @param streetLights The streetLights to set.
     */
    public void setStreetLights(boolean streetLights) {
        this.streetLights = streetLights;
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
     * @return Returns the swlNone.
     */
    public boolean isSwlNone() {
        return swlNone;
    }
    /**
     * @param swlNone The swlNone to set.
     */
    public void setSwlNone(boolean swlNone) {
        this.swlNone = swlNone;
    }
    /**
     * @return Returns the swlUnknown.
     */
    public boolean isSwlUnknown() {
        return swlUnknown;
    }
    /**
     * @param swlUnknown The swlUnknown to set.
     */
    public void setSwlUnknown(boolean swlUnknown) {
        this.swlUnknown = swlUnknown;
    }
    /**
     * @return Returns the telephone.
     */
    public String getTelephone() {
        return telephone;
    }
    /**
     * @param telephone The telephone to set.
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    /**
     * @return Returns the tractMap.
     */
    public String getTractMap() {
        return tractMap;
    }
    /**
     * @param tractMap The tractMap to set.
     */
    public void setTractMap(String tractMap) {
        this.tractMap = tractMap;
    }
    /**
     * @return Returns the trees.
     */
    public boolean isTrees() {
        return trees;
    }
    /**
     * @param trees The trees to set.
     */
    public void setTrees(boolean trees) {
        this.trees = trees;
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
     * @return Returns the unimproved.
     */
    public boolean isUnimproved() {
        return unimproved;
    }
    /**
     * @param unimproved The unimproved to set.
     */
    public void setUnimproved(boolean unimproved) {
        this.unimproved = unimproved;
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
     * @return Returns the view.
     */
    public boolean isView() {
        return view;
    }
    /**
     * @param view The view to set.
     */
    public void setView(boolean view) {
        this.view = view;
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
     * @return Returns the width.
     */
    public int getWidth() {
        return width;
    }
    /**
     * @param width The width to set.
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * @return Returns the wtlNone.
     */
    public boolean isWtlNone() {
        return wtlNone;
    }
    /**
     * @param wtlNone The wtlNone to set.
     */
    public void setWtlNone(boolean wtlNone) {
        this.wtlNone = wtlNone;
    }
    /**
     * @return Returns the wtlPrivate.
     */
    public boolean isWtlPrivate() {
        return wtlPrivate;
    }
    /**
     * @param wtlPrivate The wtlPrivate to set.
     */
    public void setWtlPrivate(boolean wtlPrivate) {
        this.wtlPrivate = wtlPrivate;
    }
    /**
     * @return Returns the wtlPublic.
     */
    public boolean isWtlPublic() {
        return wtlPublic;
    }
    /**
     * @param wtlPublic The wtlPublic to set.
     */
    public void setWtlPublic(boolean wtlPublic) {
        this.wtlPublic = wtlPublic;
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
     * @return Returns the zoningObtained.
     */
    public String getZoningObtained() {
        return zoningObtained;
    }
    /**
     * @param zoningObtained The zoningObtained to set.
     */
    public void setZoningObtained(String zoningObtained) {
        this.zoningObtained = zoningObtained;
    }
    private boolean downSlope;
    private boolean upSlope;
    private boolean hilltop;
    private boolean combinedRemarks;
    private String specialCommAgreement;
    private boolean gated;
    private boolean horseProperty;
    private boolean trees;
    private boolean view;
    private boolean cityLightsView;
    private boolean mountainView;
    private boolean ftlOther;
    private boolean naturalAvailable;
    private boolean propane;
    private boolean onProperty;
    private boolean gasNone;
    private boolean geologicalCurrent;
    private boolean soilsCurrent;
    private boolean rptOther;
    private String virtualTour;
    private int longitude;
    private String companyList;
    private String companySale;
    private int cmaLimitTime;
}

/*
 * Created on Feb 14, 2005
 *
 */
package org.realtor.rets.dataobjects;

/**
 * @author jthomas
 *
 */
public class Residence extends Property {
    private int yearBuilt;
    private int bedrooms;
    private int deleted;
    /**
     * @return Returns the appNone.
     */
    public boolean isAppNone() {
        return appNone;
    }
    /**
     * @param appNone The appNone to set.
     */
    public void setAppNone(boolean appNone) {
        this.appNone = appNone;
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
     * @return Returns the appSeeRemarks.
     */
    public boolean isAppSeeRemarks() {
        return appSeeRemarks;
    }
    /**
     * @param appSeeRemarks The appSeeRemarks to set.
     */
    public void setAppSeeRemarks(boolean appSeeRemarks) {
        this.appSeeRemarks = appSeeRemarks;
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
     * @return Returns the baths.
     */
    public float getBaths() {
        return baths;
    }
    /**
     * @param baths The baths to set.
     */
    public void setBaths(float baths) {
        this.baths = baths;
    }
    /**
     * @return Returns the bedrooms.
     */
    public int getBedrooms() {
        return bedrooms;
    }
    /**
     * @param bedrooms The bedrooms to set.
     */
    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }
    /**
     * @return Returns the breakfastBar.
     */
    public boolean isBreakfastBar() {
        return breakfastBar;
    }
    /**
     * @param breakfastBar The breakfastBar to set.
     */
    public void setBreakfastBar(boolean breakfastBar) {
        this.breakfastBar = breakfastBar;
    }
    /**
     * @return Returns the breakfastNook.
     */
    public boolean isBreakfastNook() {
        return breakfastNook;
    }
    /**
     * @param breakfastNook The breakfastNook to set.
     */
    public void setBreakfastNook(boolean breakfastNook) {
        this.breakfastNook = breakfastNook;
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
     * @return Returns the carpet.
     */
    public boolean isCarpet() {
        return carpet;
    }
    /**
     * @param carpet The carpet to set.
     */
    public void setCarpet(boolean carpet) {
        this.carpet = carpet;
    }
    /**
     * @return Returns the carport.
     */
    public boolean isCarport() {
        return carport;
    }
    /**
     * @param carport The carport to set.
     */
    public void setCarport(boolean carport) {
        this.carport = carport;
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
     * @return Returns the convectionOven.
     */
    public boolean isConvectionOven() {
        return convectionOven;
    }
    /**
     * @param convectionOven The convectionOven to set.
     */
    public void setConvectionOven(boolean convectionOven) {
        this.convectionOven = convectionOven;
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
     * @return Returns the diningArea.
     */
    public boolean isDiningArea() {
        return diningArea;
    }
    /**
     * @param diningArea The diningArea to set.
     */
    public void setDiningArea(boolean diningArea) {
        this.diningArea = diningArea;
    }
    /**
     * @return Returns the diningInKitchen.
     */
    public boolean isDiningInKitchen() {
        return diningInKitchen;
    }
    /**
     * @param diningInKitchen The diningInKitchen to set.
     */
    public void setDiningInKitchen(boolean diningInKitchen) {
        this.diningInKitchen = diningInKitchen;
    }
    /**
     * @return Returns the diningSeeRemarks.
     */
    public boolean isDiningSeeRemarks() {
        return diningSeeRemarks;
    }
    /**
     * @param diningSeeRemarks The diningSeeRemarks to set.
     */
    public void setDiningSeeRemarks(boolean diningSeeRemarks) {
        this.diningSeeRemarks = diningSeeRemarks;
    }
    /**
     * @return Returns the dishwasher.
     */
    public boolean isDishwasher() {
        return dishwasher;
    }
    /**
     * @param dishwasher The dishwasher to set.
     */
    public void setDishwasher(boolean dishwasher) {
        this.dishwasher = dishwasher;
    }
    /**
     * @return Returns the disposal.
     */
    public boolean isDisposal() {
        return disposal;
    }
    /**
     * @param disposal The disposal to set.
     */
    public void setDisposal(boolean disposal) {
        this.disposal = disposal;
    }
    /**
     * @return Returns the doubleOven.
     */
    public boolean isDoubleOven() {
        return doubleOven;
    }
    /**
     * @param doubleOven The doubleOven to set.
     */
    public void setDoubleOven(boolean doubleOven) {
        this.doubleOven = doubleOven;
    }
    /**
     * @return Returns the electric220.
     */
    public boolean isElectric220() {
        return electric220;
    }
    /**
     * @param electric220 The electric220 to set.
     */
    public void setElectric220(boolean electric220) {
        this.electric220 = electric220;
    }
    /**
     * @return Returns the fireplaceFamilyRoom.
     */
    public boolean isFireplaceFamilyRoom() {
        return fireplaceFamilyRoom;
    }
    /**
     * @param fireplaceFamilyRoom The fireplaceFamilyRoom to set.
     */
    public void setFireplaceFamilyRoom(boolean fireplaceFamilyRoom) {
        this.fireplaceFamilyRoom = fireplaceFamilyRoom;
    }
    /**
     * @return Returns the fireplaceFreestanding.
     */
    public boolean isFireplaceFreestanding() {
        return fireplaceFreestanding;
    }
    /**
     * @param fireplaceFreestanding The fireplaceFreestanding to set.
     */
    public void setFireplaceFreestanding(boolean fireplaceFreestanding) {
        this.fireplaceFreestanding = fireplaceFreestanding;
    }
    /**
     * @return Returns the fireplaceGas.
     */
    public boolean isFireplaceGas() {
        return fireplaceGas;
    }
    /**
     * @param fireplaceGas The fireplaceGas to set.
     */
    public void setFireplaceGas(boolean fireplaceGas) {
        this.fireplaceGas = fireplaceGas;
    }
    /**
     * @return Returns the fireplaceLivingRoom.
     */
    public boolean isFireplaceLivingRoom() {
        return fireplaceLivingRoom;
    }
    /**
     * @param fireplaceLivingRoom The fireplaceLivingRoom to set.
     */
    public void setFireplaceLivingRoom(boolean fireplaceLivingRoom) {
        this.fireplaceLivingRoom = fireplaceLivingRoom;
    }
    /**
     * @return Returns the fireplaceMasterBedroom.
     */
    public boolean isFireplaceMasterBedroom() {
        return fireplaceMasterBedroom;
    }
    /**
     * @param fireplaceMasterBedroom The fireplaceMasterBedroom to set.
     */
    public void setFireplaceMasterBedroom(boolean fireplaceMasterBedroom) {
        this.fireplaceMasterBedroom = fireplaceMasterBedroom;
    }
    /**
     * @return Returns the fireplaceNone.
     */
    public boolean isFireplaceNone() {
        return fireplaceNone;
    }
    /**
     * @param fireplaceNone The fireplaceNone to set.
     */
    public void setFireplaceNone(boolean fireplaceNone) {
        this.fireplaceNone = fireplaceNone;
    }
    /**
     * @return Returns the fireplaceSeeRemarks.
     */
    public boolean isFireplaceSeeRemarks() {
        return fireplaceSeeRemarks;
    }
    /**
     * @param fireplaceSeeRemarks The fireplaceSeeRemarks to set.
     */
    public void setFireplaceSeeRemarks(boolean fireplaceSeeRemarks) {
        this.fireplaceSeeRemarks = fireplaceSeeRemarks;
    }
    /**
     * @return Returns the fireplaceWoodburning.
     */
    public boolean isFireplaceWoodburning() {
        return fireplaceWoodburning;
    }
    /**
     * @param fireplaceWoodburning The fireplaceWoodburning to set.
     */
    public void setFireplaceWoodburning(boolean fireplaceWoodburning) {
        this.fireplaceWoodburning = fireplaceWoodburning;
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
     * @return Returns the floorSeeRemarks.
     */
    public boolean isFloorSeeRemarks() {
        return floorSeeRemarks;
    }
    /**
     * @param floorSeeRemarks The floorSeeRemarks to set.
     */
    public void setFloorSeeRemarks(boolean floorSeeRemarks) {
        this.floorSeeRemarks = floorSeeRemarks;
    }
    /**
     * @return Returns the formal.
     */
    public boolean isFormal() {
        return formal;
    }
    /**
     * @param formal The formal to set.
     */
    public void setFormal(boolean formal) {
        this.formal = formal;
    }
    /**
     * @return Returns the freezer.
     */
    public boolean isFreezer() {
        return freezer;
    }
    /**
     * @param freezer The freezer to set.
     */
    public void setFreezer(boolean freezer) {
        this.freezer = freezer;
    }
    /**
     * @return Returns the ftrBarbeque.
     */
    public boolean isFtrBarbeque() {
        return ftrBarbeque;
    }
    /**
     * @param ftrBarbeque The ftrBarbeque to set.
     */
    public void setFtrBarbeque(boolean ftrBarbeque) {
        this.ftrBarbeque = ftrBarbeque;
    }
    /**
     * @return Returns the ftrDen.
     */
    public boolean isFtrDen() {
        return ftrDen;
    }
    /**
     * @param ftrDen The ftrDen to set.
     */
    public void setFtrDen(boolean ftrDen) {
        this.ftrDen = ftrDen;
    }
    /**
     * @return Returns the ftrFamilyRoom.
     */
    public boolean isFtrFamilyRoom() {
        return ftrFamilyRoom;
    }
    /**
     * @param ftrFamilyRoom The ftrFamilyRoom to set.
     */
    public void setFtrFamilyRoom(boolean ftrFamilyRoom) {
        this.ftrFamilyRoom = ftrFamilyRoom;
    }
    /**
     * @return Returns the ftrLawnFront.
     */
    public boolean isFtrLawnFront() {
        return ftrLawnFront;
    }
    /**
     * @param ftrLawnFront The ftrLawnFront to set.
     */
    public void setFtrLawnFront(boolean ftrLawnFront) {
        this.ftrLawnFront = ftrLawnFront;
    }
    /**
     * @return Returns the ftrLawnRear.
     */
    public boolean isFtrLawnRear() {
        return ftrLawnRear;
    }
    /**
     * @param ftrLawnRear The ftrLawnRear to set.
     */
    public void setFtrLawnRear(boolean ftrLawnRear) {
        this.ftrLawnRear = ftrLawnRear;
    }
    /**
     * @return Returns the ftrSeeRemarks.
     */
    public boolean isFtrSeeRemarks() {
        return ftrSeeRemarks;
    }
    /**
     * @param ftrSeeRemarks The ftrSeeRemarks to set.
     */
    public void setFtrSeeRemarks(boolean ftrSeeRemarks) {
        this.ftrSeeRemarks = ftrSeeRemarks;
    }
    /**
     * @return Returns the ftrView.
     */
    public boolean isFtrView() {
        return ftrView;
    }
    /**
     * @param ftrView The ftrView to set.
     */
    public void setFtrView(boolean ftrView) {
        this.ftrView = ftrView;
    }
    /**
     * @return Returns the ftrWheelchairAcc.
     */
    public boolean isFtrWheelchairAcc() {
        return ftrWheelchairAcc;
    }
    /**
     * @param ftrWheelchairAcc The ftrWheelchairAcc to set.
     */
    public void setFtrWheelchairAcc(boolean ftrWheelchairAcc) {
        this.ftrWheelchairAcc = ftrWheelchairAcc;
    }
    /**
     * @return Returns the ftrWheelchairAdp.
     */
    public boolean isFtrWheelchairAdp() {
        return ftrWheelchairAdp;
    }
    /**
     * @param ftrWheelchairAdp The ftrWheelchairAdp to set.
     */
    public void setFtrWheelchairAdp(boolean ftrWheelchairAdp) {
        this.ftrWheelchairAdp = ftrWheelchairAdp;
    }
    /**
     * @return Returns the garage.
     */
    public boolean isGarage() {
        return garage;
    }
    /**
     * @param garage The garage to set.
     */
    public void setGarage(boolean garage) {
        this.garage = garage;
    }
    /**
     * @return Returns the garage1Car.
     */
    public boolean isGarage1Car() {
        return garage1Car;
    }
    /**
     * @param garage1Car The garage1Car to set.
     */
    public void setGarage1Car(boolean garage1Car) {
        this.garage1Car = garage1Car;
    }
    /**
     * @return Returns the garage2Car.
     */
    public boolean isGarage2Car() {
        return garage2Car;
    }
    /**
     * @param garage2Car The garage2Car to set.
     */
    public void setGarage2Car(boolean garage2Car) {
        this.garage2Car = garage2Car;
    }
    /**
     * @return Returns the garage3Car.
     */
    public boolean isGarage3Car() {
        return garage3Car;
    }
    /**
     * @param garage3Car The garage3Car to set.
     */
    public void setGarage3Car(boolean garage3Car) {
        this.garage3Car = garage3Car;
    }
    /**
     * @return Returns the garageDoorOpener.
     */
    public boolean isGarageDoorOpener() {
        return garageDoorOpener;
    }
    /**
     * @param garageDoorOpener The garageDoorOpener to set.
     */
    public void setGarageDoorOpener(boolean garageDoorOpener) {
        this.garageDoorOpener = garageDoorOpener;
    }
    /**
     * @return Returns the garageNone.
     */
    public boolean isGarageNone() {
        return garageNone;
    }
    /**
     * @param garageNone The garageNone to set.
     */
    public void setGarageNone(boolean garageNone) {
        this.garageNone = garageNone;
    }
    /**
     * @return Returns the garageSeeRemarks.
     */
    public boolean isGarageSeeRemarks() {
        return garageSeeRemarks;
    }
    /**
     * @param garageSeeRemarks The garageSeeRemarks to set.
     */
    public void setGarageSeeRemarks(boolean garageSeeRemarks) {
        this.garageSeeRemarks = garageSeeRemarks;
    }
    /**
     * @return Returns the gradeSchool.
     */
    public String getGradeSchool() {
        return gradeSchool;
    }
    /**
     * @param gradeSchool The gradeSchool to set.
     */
    public void setGradeSchool(String gradeSchool) {
        this.gradeSchool = gradeSchool;
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
     * @return Returns the highSchool.
     */
    public String getHighSchool() {
        return highSchool;
    }
    /**
     * @param highSchool The highSchool to set.
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
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
     * @return Returns the keyboxCallListingOffice.
     */
    public boolean isKeyboxCallListingOffice() {
        return keyboxCallListingOffice;
    }
    /**
     * @param keyboxCallListingOffice The keyboxCallListingOffice to set.
     */
    public void setKeyboxCallListingOffice(boolean keyboxCallListingOffice) {
        this.keyboxCallListingOffice = keyboxCallListingOffice;
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
     * @return Returns the keyboxKeyboxVacant.
     */
    public boolean isKeyboxKeyboxVacant() {
        return keyboxKeyboxVacant;
    }
    /**
     * @param keyboxKeyboxVacant The keyboxKeyboxVacant to set.
     */
    public void setKeyboxKeyboxVacant(boolean keyboxKeyboxVacant) {
        this.keyboxKeyboxVacant = keyboxKeyboxVacant;
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
     * @return Returns the keyCallListingOffice.
     */
    public boolean isKeyCallListingOffice() {
        return keyCallListingOffice;
    }
    /**
     * @param keyCallListingOffice The keyCallListingOffice to set.
     */
    public void setKeyCallListingOffice(boolean keyCallListingOffice) {
        this.keyCallListingOffice = keyCallListingOffice;
    }
    /**
     * @return Returns the keySeeRemarks.
     */
    public boolean isKeySeeRemarks() {
        return keySeeRemarks;
    }
    /**
     * @param keySeeRemarks The keySeeRemarks to set.
     */
    public void setKeySeeRemarks(boolean keySeeRemarks) {
        this.keySeeRemarks = keySeeRemarks;
    }
    /**
     * @return Returns the laminate.
     */
    public boolean isLaminate() {
        return laminate;
    }
    /**
     * @param laminate The laminate to set.
     */
    public void setLaminate(boolean laminate) {
        this.laminate = laminate;
    }
    /**
     * @return Returns the laundryArea.
     */
    public boolean isLaundryArea() {
        return laundryArea;
    }
    /**
     * @param laundryArea The laundryArea to set.
     */
    public void setLaundryArea(boolean laundryArea) {
        this.laundryArea = laundryArea;
    }
    /**
     * @return Returns the laundryCommonArea.
     */
    public boolean isLaundryCommonArea() {
        return laundryCommonArea;
    }
    /**
     * @param laundryCommonArea The laundryCommonArea to set.
     */
    public void setLaundryCommonArea(boolean laundryCommonArea) {
        this.laundryCommonArea = laundryCommonArea;
    }
    /**
     * @return Returns the laundryElectricHookUp.
     */
    public boolean isLaundryElectricHookUp() {
        return laundryElectricHookUp;
    }
    /**
     * @param laundryElectricHookUp The laundryElectricHookUp to set.
     */
    public void setLaundryElectricHookUp(boolean laundryElectricHookUp) {
        this.laundryElectricHookUp = laundryElectricHookUp;
    }
    /**
     * @return Returns the laundryGasHookUp.
     */
    public boolean isLaundryGasHookUp() {
        return laundryGasHookUp;
    }
    /**
     * @param laundryGasHookUp The laundryGasHookUp to set.
     */
    public void setLaundryGasHookUp(boolean laundryGasHookUp) {
        this.laundryGasHookUp = laundryGasHookUp;
    }
    /**
     * @return Returns the laundryInGarage.
     */
    public boolean isLaundryInGarage() {
        return laundryInGarage;
    }
    /**
     * @param laundryInGarage The laundryInGarage to set.
     */
    public void setLaundryInGarage(boolean laundryInGarage) {
        this.laundryInGarage = laundryInGarage;
    }
    /**
     * @return Returns the laundryInUnit.
     */
    public boolean isLaundryInUnit() {
        return laundryInUnit;
    }
    /**
     * @param laundryInUnit The laundryInUnit to set.
     */
    public void setLaundryInUnit(boolean laundryInUnit) {
        this.laundryInUnit = laundryInUnit;
    }
    /**
     * @return Returns the laundryRoom.
     */
    public boolean isLaundryRoom() {
        return laundryRoom;
    }
    /**
     * @param laundryRoom The laundryRoom to set.
     */
    public void setLaundryRoom(boolean laundryRoom) {
        this.laundryRoom = laundryRoom;
    }
    /**
     * @return Returns the laundrySeeRemarks.
     */
    public boolean isLaundrySeeRemarks() {
        return laundrySeeRemarks;
    }
    /**
     * @param laundrySeeRemarks The laundrySeeRemarks to set.
     */
    public void setLaundrySeeRemarks(boolean laundrySeeRemarks) {
        this.laundrySeeRemarks = laundrySeeRemarks;
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
     * @return Returns the microwave.
     */
    public boolean isMicrowave() {
        return microwave;
    }
    /**
     * @param microwave The microwave to set.
     */
    public void setMicrowave(boolean microwave) {
        this.microwave = microwave;
    }
    /**
     * @return Returns the middleSchool.
     */
    public String getMiddleSchool() {
        return middleSchool;
    }
    /**
     * @param middleSchool The middleSchool to set.
     */
    public void setMiddleSchool(String middleSchool) {
        this.middleSchool = middleSchool;
    }
    /**
     * @return Returns the modelName.
     */
    public String getModelName() {
        return modelName;
    }
    /**
     * @param modelName The modelName to set.
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    /**
     * @return Returns the multizone.
     */
    public boolean isMultizone() {
        return multizone;
    }
    /**
     * @param multizone The multizone to set.
     */
    public void setMultizone(boolean multizone) {
        this.multizone = multizone;
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
     * @return Returns the noLaundryInUnit.
     */
    public boolean isNoLaundryInUnit() {
        return noLaundryInUnit;
    }
    /**
     * @param noLaundryInUnit The noLaundryInUnit to set.
     */
    public void setNoLaundryInUnit(boolean noLaundryInUnit) {
        this.noLaundryInUnit = noLaundryInUnit;
    }
    /**
     * @return Returns the occupancyType.
     */
    public String getOccupancyType() {
        return occupancyType;
    }
    /**
     * @param occupancyType The occupancyType to set.
     */
    public void setOccupancyType(String occupancyType) {
        this.occupancyType = occupancyType;
    }
    /**
     * @return Returns the ovenElectric.
     */
    public boolean isOvenElectric() {
        return ovenElectric;
    }
    /**
     * @param ovenElectric The ovenElectric to set.
     */
    public void setOvenElectric(boolean ovenElectric) {
        this.ovenElectric = ovenElectric;
    }
    /**
     * @return Returns the ovenGas.
     */
    public boolean isOvenGas() {
        return ovenGas;
    }
    /**
     * @param ovenGas The ovenGas to set.
     */
    public void setOvenGas(boolean ovenGas) {
        this.ovenGas = ovenGas;
    }
    /**
     * @return Returns the ownWell.
     */
    public boolean isWaterOwnWell() {
        return waterOwnWell;
    }
    /**
     * @param ownWell The ownWell to set.
     */
    public void setWaterOwnWell(boolean ownWell) {
        this.waterOwnWell = ownWell;
    }
    /**
     * @return Returns the ppiAntenna.
     */
    public boolean isPpiAntenna() {
        return ppiAntenna;
    }
    /**
     * @param ppiAntenna The ppiAntenna to set.
     */
    public void setPpiAntenna(boolean ppiAntenna) {
        this.ppiAntenna = ppiAntenna;
    }
    /**
     * @return Returns the ppiClothesDryer.
     */
    public boolean isPpiClothesDryer() {
        return ppiClothesDryer;
    }
    /**
     * @param ppiClothesDryer The ppiClothesDryer to set.
     */
    public void setPpiClothesDryer(boolean ppiClothesDryer) {
        this.ppiClothesDryer = ppiClothesDryer;
    }
    /**
     * @return Returns the ppiClothesWasher.
     */
    public boolean isPpiClothesWasher() {
        return ppiClothesWasher;
    }
    /**
     * @param ppiClothesWasher The ppiClothesWasher to set.
     */
    public void setPpiClothesWasher(boolean ppiClothesWasher) {
        this.ppiClothesWasher = ppiClothesWasher;
    }
    /**
     * @return Returns the ppiExteriorLighting.
     */
    public boolean isPpiExteriorLighting() {
        return ppiExteriorLighting;
    }
    /**
     * @param ppiExteriorLighting The ppiExteriorLighting to set.
     */
    public void setPpiExteriorLighting(boolean ppiExteriorLighting) {
        this.ppiExteriorLighting = ppiExteriorLighting;
    }
    /**
     * @return Returns the ppiFireplaceLogs.
     */
    public boolean isPpiFireplaceLogs() {
        return ppiFireplaceLogs;
    }
    /**
     * @param ppiFireplaceLogs The ppiFireplaceLogs to set.
     */
    public void setPpiFireplaceLogs(boolean ppiFireplaceLogs) {
        this.ppiFireplaceLogs = ppiFireplaceLogs;
    }
    /**
     * @return Returns the ppiFireplaceScreen.
     */
    public boolean isPpiFireplaceScreen() {
        return ppiFireplaceScreen;
    }
    /**
     * @param ppiFireplaceScreen The ppiFireplaceScreen to set.
     */
    public void setPpiFireplaceScreen(boolean ppiFireplaceScreen) {
        this.ppiFireplaceScreen = ppiFireplaceScreen;
    }
    /**
     * @return Returns the ppiNone.
     */
    public boolean isPpiNone() {
        return ppiNone;
    }
    /**
     * @param ppiNone The ppiNone to set.
     */
    public void setPpiNone(boolean ppiNone) {
        this.ppiNone = ppiNone;
    }
    /**
     * @return Returns the ppiPortableDishwasher.
     */
    public boolean isPpiPortableDishwasher() {
        return ppiPortableDishwasher;
    }
    /**
     * @param ppiPortableDishwasher The ppiPortableDishwasher to set.
     */
    public void setPpiPortableDishwasher(boolean ppiPortableDishwasher) {
        this.ppiPortableDishwasher = ppiPortableDishwasher;
    }
    /**
     * @return Returns the ppiSatelliteDish.
     */
    public boolean isPpiSatelliteDish() {
        return ppiSatelliteDish;
    }
    /**
     * @param ppiSatelliteDish The ppiSatelliteDish to set.
     */
    public void setPpiSatelliteDish(boolean ppiSatelliteDish) {
        this.ppiSatelliteDish = ppiSatelliteDish;
    }
    /**
     * @return Returns the ppiSecuritySystem.
     */
    public boolean isPpiSecuritySystem() {
        return ppiSecuritySystem;
    }
    /**
     * @param ppiSecuritySystem The ppiSecuritySystem to set.
     */
    public void setPpiSecuritySystem(boolean ppiSecuritySystem) {
        this.ppiSecuritySystem = ppiSecuritySystem;
    }
    /**
     * @return Returns the ppiSeeRemarks.
     */
    public boolean isPpiSeeRemarks() {
        return ppiSeeRemarks;
    }
    /**
     * @param ppiSeeRemarks The ppiSeeRemarks to set.
     */
    public void setPpiSeeRemarks(boolean ppiSeeRemarks) {
        this.ppiSeeRemarks = ppiSeeRemarks;
    }
    /**
     * @return Returns the ppiWaterSoftener.
     */
    public boolean isPpiWaterSoftener() {
        return ppiWaterSoftener;
    }
    /**
     * @param ppiWaterSoftener The ppiWaterSoftener to set.
     */
    public void setPpiWaterSoftener(boolean ppiWaterSoftener) {
        this.ppiWaterSoftener = ppiWaterSoftener;
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
     * @return Returns the rangeElectric.
     */
    public boolean isRangeElectric() {
        return rangeElectric;
    }
    /**
     * @param rangeElectric The rangeElectric to set.
     */
    public void setRangeElectric(boolean rangeElectric) {
        this.rangeElectric = rangeElectric;
    }
    /**
     * @return Returns the rangeGas.
     */
    public boolean isRangeGas() {
        return rangeGas;
    }
    /**
     * @param rangeGas The rangeGas to set.
     */
    public void setRangeGas(boolean rangeGas) {
        this.rangeGas = rangeGas;
    }
    /**
     * @return Returns the refrigerator.
     */
    public boolean isRefrigerator() {
        return refrigerator;
    }
    /**
     * @param refrigerator The refrigerator to set.
     */
    public void setRefrigerator(boolean refrigerator) {
        this.refrigerator = refrigerator;
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
     * @return Returns the septicSystem.
     */
    public boolean isSepticSystem() {
        return septicSystem;
    }
    /**
     * @param septicSystem The septicSystem to set.
     */
    public void setSepticSystem(boolean septicSystem) {
        this.septicSystem = septicSystem;
    }
    /**
     * @return Returns the sewerInStreet.
     */
    public boolean isSewerInStreet() {
        return sewerInStreet;
    }
    /**
     * @param sewerInStreet The sewerInStreet to set.
     */
    public void setSewerInStreet(boolean sewerInStreet) {
        this.sewerInStreet = sewerInStreet;
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
     * @return Returns the spkAutomatic.
     */
    public boolean isSpkAutomatic() {
        return spkAutomatic;
    }
    /**
     * @param spkAutomatic The spkAutomatic to set.
     */
    public void setSpkAutomatic(boolean spkAutomatic) {
        this.spkAutomatic = spkAutomatic;
    }
    /**
     * @return Returns the spkDripSystem.
     */
    public boolean isSpkDripSystem() {
        return spkDripSystem;
    }
    /**
     * @param spkDripSystem The spkDripSystem to set.
     */
    public void setSpkDripSystem(boolean spkDripSystem) {
        this.spkDripSystem = spkDripSystem;
    }
    /**
     * @return Returns the spkFront.
     */
    public boolean isSpkFront() {
        return spkFront;
    }
    /**
     * @param spkFront The spkFront to set.
     */
    public void setSpkFront(boolean spkFront) {
        this.spkFront = spkFront;
    }
    /**
     * @return Returns the spkManual.
     */
    public boolean isSpkManual() {
        return spkManual;
    }
    /**
     * @param spkManual The spkManual to set.
     */
    public void setSpkManual(boolean spkManual) {
        this.spkManual = spkManual;
    }
    /**
     * @return Returns the spkNone.
     */
    public boolean isSpkNone() {
        return spkNone;
    }
    /**
     * @param spkNone The spkNone to set.
     */
    public void setSpkNone(boolean spkNone) {
        this.spkNone = spkNone;
    }
    /**
     * @return Returns the spkOther.
     */
    public boolean isSpkOther() {
        return spkOther;
    }
    /**
     * @param spkOther The spkOther to set.
     */
    public void setSpkOther(boolean spkOther) {
        this.spkOther = spkOther;
    }
    /**
     * @return Returns the spkSide.
     */
    public boolean isSpkSide() {
        return spkSide;
    }
    /**
     * @param spkSide The spkSide to set.
     */
    public void setSpkSide(boolean spkSide) {
        this.spkSide = spkSide;
    }
    /**
     * @return Returns the sreetLights.
     */
    public String getStreetLights() {
        return streetLights;
    }
    /**
     * @param sreetLights The sreetLights to set.
     */
    public void setStreetLights(String sreetLights) {
        this.streetLights = sreetLights;
    }
    /**
     * @return Returns the stcAlleyAccess.
     */
    public boolean isStcAlleyAccess() {
        return stcAlleyAccess;
    }
    /**
     * @param stcAlleyAccess The stcAlleyAccess to set.
     */
    public void setStcAlleyAccess(boolean stcAlleyAccess) {
        this.stcAlleyAccess = stcAlleyAccess;
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
     * @return Returns the tractCode.
     */
    public String getTractCode() {
        return tractCode;
    }
    /**
     * @param tractCode The tractCode to set.
     */
    public void setTractCode(String tractCode) {
        this.tractCode = tractCode;
    }
    /**
     * @return Returns the trashCompactor.
     */
    public boolean isTrashCompactor() {
        return trashCompactor;
    }
    /**
     * @param trashCompactor The trashCompactor to set.
     */
    public void setTrashCompactor(boolean trashCompactor) {
        this.trashCompactor = trashCompactor;
    }
    /**
     * @return Returns the utilityNone.
     */
    public boolean isUtilityNone() {
        return utilityNone;
    }
    /**
     * @param utilityNone The utilityNone to set.
     */
    public void setUtilityNone(boolean utilityNone) {
        this.utilityNone = utilityNone;
    }
    /**
     * @return Returns the utilityPropane.
     */
    public boolean isUtilityPropane() {
        return utilityPropane;
    }
    /**
     * @param utilityPropane The utilityPropane to set.
     */
    public void setUtilityPropane(boolean utilityPropane) {
        this.utilityPropane = utilityPropane;
    }
    /**
     * @return Returns the vinylLinoleum.
     */
    public boolean isVinylLinoleum() {
        return vinylLinoleum;
    }
    /**
     * @param vinylLinoleum The vinylLinoleum to set.
     */
    public void setVinylLinoleum(boolean vinylLinoleum) {
        this.vinylLinoleum = vinylLinoleum;
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
     * @return Returns the waterNoWater.
     */
    public boolean isWaterNoWater() {
        return waterNoWater;
    }
    /**
     * @param waterNoWater The waterNoWater to set.
     */
    public void setWaterNoWater(boolean waterNoWater) {
        this.waterNoWater = waterNoWater;
    }
    /**
     * @return Returns the waterOther.
     */
    public boolean isWaterOther() {
        return waterOther;
    }
    /**
     * @param waterOther The waterOther to set.
     */
    public void setWaterOther(boolean waterOther) {
        this.waterOther = waterOther;
    }
    /**
     * @return Returns the waterPublicUtility.
     */
    public boolean isWaterPublicUtility() {
        return waterPublicUtility;
    }
    /**
     * @param waterPublicUtility The waterPublicUtility to set.
     */
    public void setWaterPublicUtility(boolean waterPublicUtility) {
        this.waterPublicUtility = waterPublicUtility;
    }
    /**
     * @return Returns the waterSharedWell.
     */
    public boolean isWaterSharedWell() {
        return waterSharedWell;
    }
    /**
     * @param waterSharedWell The waterSharedWell to set.
     */
    public void setWaterSharedWell(boolean waterSharedWell) {
        this.waterSharedWell = waterSharedWell;
    }
    /**
     * @return Returns the waterStockCompany.
     */
    public boolean isWaterStockCompany() {
        return waterStockCompany;
    }
    /**
     * @param waterStockCompany The waterStockCompany to set.
     */
    public void setWaterStockCompany(boolean waterStockCompany) {
        this.waterStockCompany = waterStockCompany;
    }
    /**
     * @return Returns the wood.
     */
    public boolean isWood() {
        return wood;
    }
    /**
     * @param wood The wood to set.
     */
    public void setWood(boolean wood) {
        this.wood = wood;
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
    private float baths;
    private String tractCode;
    private String modelName;
    private String occupancyType;
    private String gradeSchool;
    private String middleSchool;
    private String highSchool;
    private boolean convectionOven;
    private boolean disposal;
    private boolean dishwasher;
    private boolean doubleOven;
    private boolean freezer;
    private boolean microwave;
    private boolean ovenElectric;
    private boolean ovenGas;
    private boolean rangeElectric;
    private boolean rangeGas;
    private boolean refrigerator;
    private boolean trashCompactor;
    private boolean appSeeRemarks;
    private boolean cclNone;
    private boolean centralAirRefrig;
    private boolean centralAirEvap;
    private boolean centralHeatGas;
    private boolean centralHeatElec;
    private boolean baseboard;
    private boolean floorFurnace;
    private boolean heatPump;
    private boolean multizone;
    private boolean propane;
    private boolean radiantHeat;
    private boolean roomEvapAir;
    private boolean roomRefrigAir;
    private boolean solarHeat;
    private boolean wallFurnace;
    private boolean woodStove;
    private boolean appNone;
    private boolean formal;
    private boolean diningArea;
    private boolean diningInKitchen;
    private boolean breakfastBar;
    private boolean breakfastNook;
    private boolean diningSeeRemarks;
    private boolean carpet;
    private boolean laminate;
    private boolean wood;
    private boolean floorSeeRemarks;
    private boolean tile;
    private boolean vinylLinoleum;
    private boolean fireplaceFamilyRoom;
    private boolean fireplaceLivingRoom;
    private boolean fireplaceMasterBedroom;
    private boolean fireplaceGas;
    private boolean fireplaceFreestanding;
    private boolean fireplaceWoodburning;
    private boolean fireplaceSeeRemarks;
    private boolean fireplaceNone;
    private boolean ftrFamilyRoom;
    private boolean ftrDen;
    private boolean ftrView;
    private boolean ftrBarbeque;
    private boolean ftrWheelchairAcc;
    private boolean ftrWheelchairAdp;
    private boolean ftrSeeRemarks;
    private boolean ftrLawnRear;
    private boolean ftrLawnFront;
    private boolean garage1Car;
    private boolean garage2Car;
    private boolean garage3Car;
    private boolean carport;
    private boolean garageSeeRemarks;
    private boolean garageDoorOpener;
    private boolean garageNone;
    private boolean garage;
    private boolean laundryArea;
    private boolean laundryCommonArea;
    private boolean laundryElectricHookUp;
    private boolean laundryGasHookUp;
    private boolean laundryInGarage;
    private boolean noLaundryInUnit;
    private boolean laundryRoom;
    private boolean laundryInUnit;
    private boolean laundrySeeRemarks;
    private boolean ppiAntenna;
    private boolean ppiClothesDryer;
    private boolean ppiClothesWasher;
    private boolean ppiExteriorLighting;
    private boolean ppiFireplaceLogs;
    private boolean ppiFireplaceScreen;
    private boolean ppiPortableDishwasher;
    private boolean ppiSatelliteDish;
    private boolean ppiSecuritySystem;
    private boolean ppiWaterSoftener;
    private boolean ppiSeeRemarks;
    private boolean ppiNone;
    private boolean roofCompositionShingle;
    private boolean roofMetal;
    private boolean roofShake;
    private boolean roofTile;
    private boolean roofOther;
    private boolean appointmentCallAgent;
    private boolean appointmentCallListingOffice;
    private boolean appointmentCallOwner;
    private boolean appointmentCallTenant;
    private boolean keyboxCallAgent;
    private boolean keyboxCodeRequired;
    private boolean keyboxSecurityAlarm;
    private boolean keyboxGoDirect;
    private boolean keyboxCallListingOffice;
    private boolean keyboxCallOwner;
    private boolean keyboxCallTenant;
    private boolean keyboxKeyboxVacant;
    private boolean keyCallAgent;
    private boolean keyCallListingOffice;
    private boolean keySeeRemarks;
    private boolean spkAutomatic;
    private boolean spkDripSystem;
    private boolean spkFront;
    private boolean spkSide;
    private boolean spkRear;
    private boolean spkOther;
    private boolean spkNone;
    private boolean spkManual;
    private boolean stcAlleyAccess;
    private boolean stcDirt;
    private boolean stcPaved;
    private boolean stcPrivate;
    private boolean stcPublic;
    private boolean stcOther;
    private String curbs;
    private String sidewalks;
    private String streetLights;
    private boolean cessPool;
    private boolean septicSystem;
    private boolean sewerInStreet;
    private boolean electric220;
    private boolean cableTV;
    private boolean naturalGas;
    private boolean utilityPropane;
    private boolean utilityNone;
    private boolean waterOwnWell;
    private boolean waterPublicUtility;
    private boolean waterSharedWell;
    private boolean waterStockCompany;
    private boolean waterNoWater;
    private boolean waterOther;
    private float listPricePerSquareFoot;
    private float salePricePerSquareFoot;
    /**
     * @return Returns the spkRear.
     */
    public boolean isSpkRear() {
        return spkRear;
    }
    /**
     * @param spkRear The spkRear to set.
     */
    public void setSpkRear(boolean spkRear) {
        this.spkRear = spkRear;
    }
}

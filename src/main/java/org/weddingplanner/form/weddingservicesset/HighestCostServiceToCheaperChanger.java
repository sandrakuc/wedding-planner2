package org.weddingplanner.form.weddingservicesset;

import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesWrapper;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;
import org.weddingplanner.utils.CommonUtils;

import java.util.List;

public class HighestCostServiceToCheaperChanger {

    private static WeddingServicesSet changeService(String className, WeddingServicesSet set, WeddingServicesWrapper servicesWrapper){
        if(CommonUtils.WEDDING_DRESS_STORE_MODEL_CLASS_NAME.equals(className)){
            CheaperFromListGetter<WeddingDressStoreListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setDressStore(cheaperFromListGetter.findCheapModel(servicesWrapper.getWeddingDressStores()));
        } else if (CommonUtils.WEDDING_SUITE_MODEL_MODEL_CLASS_NAME.equals(className)) {
            CheaperFromListGetter<WeddingSuitesListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setSuiteStore(cheaperFromListGetter.findCheapModel(servicesWrapper.getWeddingSuitesStores()));
        } else if (CommonUtils.WEDDING_HALL_MODEL_MODEL_CLASS_NAME.equals(className)){
            CheaperFromListGetter<WeddingHallListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setHall(cheaperFromListGetter.findCheapModel(servicesWrapper.getWeddingHalls()));
        } else if (CommonUtils.PHOTOGRAPHER_MODEL_CLASS_NAME.equals(className)){
            CheaperFromListGetter<PhotographerListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setPhotographer(cheaperFromListGetter.findCheapModel(servicesWrapper.getPhotographers()));
        } else if (CommonUtils.MUSIC_BAND_MODEL_CLASS_NAME.equals(className)) {
            CheaperFromListGetter<MusicBandListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setMusicBand(cheaperFromListGetter.findCheapModel(servicesWrapper.getMusicBands()));
        } else if (CommonUtils.FLORISTIC_SERVICE_MODEL_CLASS_NAME.equals(className)) {
            CheaperFromListGetter<FloristicServicesListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setFloristicService(cheaperFromListGetter.findCheapModel(servicesWrapper.getFloristicServices()));
        } else if (CommonUtils.CAR_RENTING_MODEL_CLASS_NAME.equals(className)) {
            CheaperFromListGetter<CarRentingListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setCarRenting(cheaperFromListGetter.findCheapModel(servicesWrapper.getCarRentings()));
        } else if (CommonUtils.MAKE_UP_SALON_MODEL_CLASS_NAME.equals(className)){
            CheaperFromListGetter<MakeUpSalonListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setMakeUpSalon(cheaperFromListGetter.findCheapModel(servicesWrapper.getMakeUpSalons()));
        } else if (CommonUtils.HAIR_DRESSER_CLASS_NAME.equals(className)){
            CheaperFromListGetter<HairDresserListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setHairDresser(cheaperFromListGetter.findCheapModel(servicesWrapper.getHairDressers()));
        } else if (CommonUtils.BEAUTY_SALON_MODEL_CLASS_NAME.equals(className)){
            CheaperFromListGetter<BeautySalonListInternalModel> cheaperFromListGetter = new CheaperFromListGetter<>();
            set.setBeautySalon(cheaperFromListGetter.findCheapModel(servicesWrapper.getBeautySalons()));
        }
        return set;
    }

    private static Boolean checkPriorityCriteria(String className, InputDataForm form){
        if(CommonUtils.WEDDING_DRESS_STORE_MODEL_CLASS_NAME.equals(className) || CommonUtils.WEDDING_SUITE_MODEL_MODEL_CLASS_NAME.equals(className)){
            return form.getWeddingOutfitCriteria().getPriceCriteria() > form.getWeddingOutfitCriteria().getNoteCriteria();
        } else if (CommonUtils.WEDDING_HALL_MODEL_MODEL_CLASS_NAME.equals(className)){
            return form.getWeddingHallCriteria().getPriceCriteria() > form.getWeddingHallCriteria().getNoteCriteria()
                    && form.getWeddingHallCriteria().getPriceCriteria() > form.getWeddingHallCriteria().getDistanceCriteria();
        } else if (CommonUtils.PHOTOGRAPHER_MODEL_CLASS_NAME.equals(className)){
            return form.getPhotographicAndFilmServicesCriteria().getPriceCriteria() > form.getPhotographicAndFilmServicesCriteria().getNoteCriteria();
        } else if (CommonUtils.MUSIC_BAND_MODEL_CLASS_NAME.equals(className)) {
            return form.getMusicBandCriteria().getPriceCriteria() > form.getMusicBandCriteria().getNoteCriteria();
        } else if (CommonUtils.FLORISTIC_SERVICE_MODEL_CLASS_NAME.equals(className)) {
            return form.getFloristicServicesCriteria().getPriceCriteria() > form.getFloristicServicesCriteria().getNoteCriteria();
        } else if (CommonUtils.CAR_RENTING_MODEL_CLASS_NAME.equals(className)) {
            return form.getCarRentingServicesCriteria().getPriceCriteria() > form.getCarRentingServicesCriteria().getNoteCriteria();
        } else {
            return form.getBeautyServicesCriteria().getPriceCriteria() > form.getBeautyServicesCriteria().getNoteCriteria();
        }
    }

    public static WeddingServicesSet changeServicesToCheaper(WeddingServicesSet set, InputDataForm inputDataForm, WeddingServicesWrapper servicesWrapper){
        List<HigherCostWrapper> wrappers = SetToListOfHigherCostWrapperConverter.convert(set);
        while (set.getTotalAmount() > (inputDataForm.getBudget() + inputDataForm.getBudgetMargin()) && !wrappers.isEmpty()){
            if(checkPriorityCriteria(wrappers.get(wrappers.size() - 1).getClassName(), inputDataForm)){
                set = changeService(wrappers.get(wrappers.size() - 1).getClassName(), set, servicesWrapper);
            }
            wrappers.remove(wrappers.size() - 1);
        }
        return set;
    }
}

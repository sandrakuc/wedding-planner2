package org.weddingplanner.form.weddingservicesfilter;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.beautysalonlist.BeautySalonListApiHandler;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.CarRentingListApiHandler;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.floristicservices.FloristicServicesListApiHandler;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.HairDresserListApiHandler;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.MakeUpSalonListApiHandler;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.MusicBandListApiHandler;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.PhotographerListApiHandler;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.WeddingDressStoreListApiHandler;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.WeddingHallListApiHandler;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.WeddingSuitesListApiHandler;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class WeddingServicesFilter {

    private static List<BeautySalonListInternalModel> getBeautySalons(InputDataForm form) throws IOException {
        BeautySalonListApiHandler handler = new BeautySalonListApiHandler();
        List<BeautySalonListInternalModel> beautySalons = handler.getBeautySalonList(form);
        beautySalons = WeddingServicesClassificator.classifyBeautySalons(beautySalons);
        ServiceGrouping<BeautySalonListInternalModel> serviceGrouping = new ServiceGrouping<>();
        beautySalons = serviceGrouping.groupServices(beautySalons, form.getBeautyServicesCriteria().getPriceCriteria(), form.getBeautyServicesCriteria().getNoteCriteria());
        return beautySalons;
    }

    private static List<CarRentingListInternalModel> getCarRentings(InputDataForm form) throws IOException {
        CarRentingListApiHandler handler = new CarRentingListApiHandler();
        List<CarRentingListInternalModel> carRentings = handler.getCarRentingList(form);
        carRentings = WeddingServicesClassificator.classifyCarRentings(carRentings);
        ServiceGrouping<CarRentingListInternalModel> serviceGrouping = new ServiceGrouping<>();
        carRentings = serviceGrouping.groupServices(carRentings, form.getCarRentingServicesCriteria().getPriceCriteria(), form.getCarRentingServicesCriteria().getNoteCriteria());
        return carRentings;
    }

    private static List<FloristicServicesListInternalModel> getFloristicServices(InputDataForm form) throws IOException {
        FloristicServicesListApiHandler handler = new FloristicServicesListApiHandler();
        List<FloristicServicesListInternalModel> floristicServices = handler.getFloristicServicesList(form);
        floristicServices = WeddingServicesClassificator.classifyFloristicServices(floristicServices);
        ServiceGrouping<FloristicServicesListInternalModel> serviceGrouping = new ServiceGrouping<>();
        floristicServices = serviceGrouping.groupServices(floristicServices, form.getFloristicServicesCriteria().getPriceCriteria(), form.getFloristicServicesCriteria().getNoteCriteria());
        return floristicServices;
    }

    private static List<HairDresserListInternalModel> getHairDressers(InputDataForm form) throws IOException {
        HairDresserListApiHandler handler = new HairDresserListApiHandler();
        List<HairDresserListInternalModel> hairDressers = handler.getHairDresserList(form);
        hairDressers = WeddingServicesClassificator.classifyHairDressers(hairDressers);
        ServiceGrouping<HairDresserListInternalModel> serviceGrouping = new ServiceGrouping<>();
        hairDressers = serviceGrouping.groupServices(hairDressers, form.getBeautyServicesCriteria().getPriceCriteria(), form.getBeautyServicesCriteria().getNoteCriteria());
        return hairDressers;
    }

    private static List<MakeUpSalonListInternalModel> getMakeUpSalons(InputDataForm form) throws IOException {
        MakeUpSalonListApiHandler handler = new MakeUpSalonListApiHandler();
        List<MakeUpSalonListInternalModel> makeUpSalons = handler.getMakeUpSalonList(form);
        makeUpSalons = WeddingServicesClassificator.classifyMakeUpSalons(makeUpSalons);
        ServiceGrouping<MakeUpSalonListInternalModel> serviceGrouping = new ServiceGrouping<>();
        makeUpSalons = serviceGrouping.groupServices(makeUpSalons, form.getBeautyServicesCriteria().getPriceCriteria(), form.getBeautyServicesCriteria().getNoteCriteria());
        return makeUpSalons;
    }

    private static List<MusicBandListInternalModel> getMusicBands(InputDataForm form) throws IOException {
        MusicBandListApiHandler handler = new MusicBandListApiHandler();
        List<MusicBandListInternalModel> musicBands = handler.getMusicBandList(form);
        musicBands = WeddingServicesClassificator.classifyMusicBands(musicBands);
        ServiceGrouping<MusicBandListInternalModel> serviceGrouping = new ServiceGrouping<>();
        musicBands = serviceGrouping.groupServices(musicBands, form.getMusicBandCriteria().getPriceCriteria(), form.getMusicBandCriteria().getNoteCriteria());
        return musicBands;
    }

    private static List<PhotographerListInternalModel> getPhotographers(InputDataForm form) throws IOException {
        PhotographerListApiHandler handler = new PhotographerListApiHandler();
        List<PhotographerListInternalModel> photographers = handler.getPhotographerList(form);
        photographers = WeddingServicesClassificator.classifyPhotographers(photographers);
        ServiceGrouping<PhotographerListInternalModel> serviceGrouping = new ServiceGrouping<>();
        photographers = serviceGrouping.groupServices(photographers, form.getPhotographicAndFilmServicesCriteria().getPriceCriteria(), form.getPhotographicAndFilmServicesCriteria().getNoteCriteria());
        return photographers;
    }

    private static List<WeddingDressStoreListInternalModel> getWeddingDressStores(InputDataForm form) throws IOException {
        WeddingDressStoreListApiHandler handler = new WeddingDressStoreListApiHandler();
        List<WeddingDressStoreListInternalModel> weddingDressStores = handler.getWeddingDressStoresList(form);
        weddingDressStores = WeddingServicesClassificator.classifyWeddingDressStores(weddingDressStores);
        ServiceGrouping<WeddingDressStoreListInternalModel> serviceGrouping = new ServiceGrouping<>();
        weddingDressStores = serviceGrouping.groupServices(weddingDressStores, form.getWeddingOutfitCriteria().getPriceCriteria(), form.getWeddingOutfitCriteria().getNoteCriteria());
        return weddingDressStores;
    }

    private static List<WeddingSuitesListInternalModel> getWeddingSuitesStores(InputDataForm form) throws IOException {
        WeddingSuitesListApiHandler handler = new WeddingSuitesListApiHandler();
        List<WeddingSuitesListInternalModel> weddingSuitesStores = handler.getWeddingSuitesList(form);
        weddingSuitesStores = WeddingServicesClassificator.classifyWeddingSuitesStores(weddingSuitesStores);
        ServiceGrouping<WeddingSuitesListInternalModel> serviceGrouping = new ServiceGrouping<>();
        weddingSuitesStores = serviceGrouping.groupServices(weddingSuitesStores, form.getWeddingOutfitCriteria().getPriceCriteria(), form.getWeddingOutfitCriteria().getNoteCriteria());
        return weddingSuitesStores;
    }

    private static List<WeddingHallListInternalModel> getWeddingHalls(InputDataForm form) throws IOException {
        WeddingHallListApiHandler handler = new WeddingHallListApiHandler();
        List<WeddingHallListInternalModel> weddingHalls = handler.getWeddingHallList(form);
        weddingHalls = weddingHalls.stream().filter(weddingHall -> weddingHall.getMaxGuestsQuantity() >= form.getGuestQuantity()).collect(Collectors.toList());
        weddingHalls = WeddingServicesClassificator.classifyWeddingHalls(weddingHalls);
        ServiceGrouping<WeddingHallListInternalModel> serviceGrouping = new ServiceGrouping<>();
        weddingHalls = serviceGrouping.groupWeddingHalls(weddingHalls, form.getWeddingHallCriteria().getPriceCriteria(), form.getWeddingHallCriteria().getNoteCriteria(), form.getWeddingHallCriteria().getDistanceCriteria());
        return weddingHalls;
    }

    public static WeddingServicesWrapper buildServicesWrapper(InputDataForm form) throws IOException {
        WeddingServicesWrapper wrapper = new WeddingServicesWrapper()
                .builder()
                .beautySalons(getBeautySalons(form))
                .carRentings(getCarRentings(form))
                .floristicServices(getFloristicServices(form))
                .hairDressers(getHairDressers(form))
                .makeUpSalons(getMakeUpSalons(form))
                .musicBands(getMusicBands(form))
                .photographers(getPhotographers(form))
                .weddingDressStores(getWeddingDressStores(form))
                .weddingSuitesStores(getWeddingSuitesStores(form))
                .weddingHalls(getWeddingHalls(form))
                .build();
        return wrapper;
    }
}

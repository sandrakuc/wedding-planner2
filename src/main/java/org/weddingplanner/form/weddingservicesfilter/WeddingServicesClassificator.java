package org.weddingplanner.form.weddingservicesfilter;

import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.DistanceClassification;
import org.weddingplanner.searchservices.weddinghalllist.internal.PriceClassification;
import org.weddingplanner.searchservices.weddinghalllist.internal.SatisfactionClassification;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;

import java.util.List;
import java.util.stream.Collectors;

public class WeddingServicesClassificator {
    private static double countMedian(List<Double> values){
        values = values.stream().sorted().collect(Collectors.toList());
        if(values.size() % 2 == 0){
            return (values.get((values.size()/2)-1) + values.get((values.size()/2)))/2;
        } else {
            return values.get((values.size()-1)/2);
        }
    }

    public static List<BeautySalonListInternalModel> classifyBeautySalons(List<BeautySalonListInternalModel> beautySalons){
        List<Double> pricesValues = beautySalons.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = beautySalons.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(BeautySalonListInternalModel beautySalon : beautySalons){
            beautySalon.setPriceClassification(beautySalon.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            beautySalon.setSatisfactionClassification(beautySalon.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return beautySalons;
    }

    public static List<CarRentingListInternalModel> classifyCarRentings(List<CarRentingListInternalModel> carRentings){
        List<Double> pricesValues = carRentings.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = carRentings.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(CarRentingListInternalModel carRenting : carRentings){
            carRenting.setPriceClassification(carRenting.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            carRenting.setSatisfactionClassification(carRenting.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return carRentings;
    }

    public static List<FloristicServicesListInternalModel> classifyFloristicServices(List<FloristicServicesListInternalModel> floristicServices){
        List<Double> pricesValues = floristicServices.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = floristicServices.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(FloristicServicesListInternalModel floristicService : floristicServices){
            floristicService.setPriceClassification(floristicService.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            floristicService.setSatisfactionClassification(floristicService.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return floristicServices;
    }

    public static List<HairDresserListInternalModel> classifyHairDressers(List<HairDresserListInternalModel> hairDressers){
        List<Double> pricesValues = hairDressers.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = hairDressers.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(HairDresserListInternalModel hairDresser : hairDressers){
            hairDresser.setPriceClassification(hairDresser.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            hairDresser.setSatisfactionClassification(hairDresser.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return hairDressers;
    }

    public static List<MakeUpSalonListInternalModel> classifyMakeUpSalons(List<MakeUpSalonListInternalModel> makeUpSalons){
        List<Double> pricesValues = makeUpSalons.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = makeUpSalons.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(MakeUpSalonListInternalModel makeUpSalon : makeUpSalons){
            makeUpSalon.setPriceClassification(makeUpSalon.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            makeUpSalon.setSatisfactionClassification(makeUpSalon.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return makeUpSalons;
    }

    public static List<MusicBandListInternalModel> classifyMusicBands(List<MusicBandListInternalModel> musicBands){
        List<Double> pricesValues = musicBands.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = musicBands.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(MusicBandListInternalModel musicBand : musicBands){
            musicBand.setPriceClassification(musicBand.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            musicBand.setSatisfactionClassification(musicBand.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return musicBands;
    }

    public static List<PhotographerListInternalModel> classifyPhotographers(List<PhotographerListInternalModel> photographers){
        List<Double> pricesValues = photographers.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = photographers.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(PhotographerListInternalModel photographer : photographers){
            photographer.setPriceClassification(photographer.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            photographer.setSatisfactionClassification(photographer.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return photographers;
    }

    public static List<WeddingDressStoreListInternalModel> classifyWeddingDressStores(List<WeddingDressStoreListInternalModel> weddingDressStores){
        List<Double> pricesValues = weddingDressStores.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = weddingDressStores.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(WeddingDressStoreListInternalModel weddingDressStore : weddingDressStores){
            weddingDressStore.setPriceClassification(weddingDressStore.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            weddingDressStore.setSatisfactionClassification(weddingDressStore.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return weddingDressStores;
    }

    public static List<WeddingSuitesListInternalModel> classifyWeddingSuitesStores(List<WeddingSuitesListInternalModel> weddingSuitesStores){
        List<Double> pricesValues = weddingSuitesStores.stream().map(price -> Double.valueOf(price.getAvgPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = weddingSuitesStores.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        for(WeddingSuitesListInternalModel weddingSuitesStore : weddingSuitesStores){
            weddingSuitesStore.setPriceClassification(weddingSuitesStore.getAvgPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            weddingSuitesStore.setSatisfactionClassification(weddingSuitesStore.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
        }
        return weddingSuitesStores;
    }

    public static List<WeddingHallListInternalModel> classifyWeddingHalls(List<WeddingHallListInternalModel> weddingHalls){
        List<Double> pricesValues = weddingHalls.stream().map(price -> Double.valueOf(price.getPrice())).collect(Collectors.toList());
        double priceMedian = countMedian(pricesValues);
        List<Double> satisfactionValues = weddingHalls.stream().map(satisfaction -> satisfaction.getRating()).collect(Collectors.toList());
        double satisfactionMedian = countMedian(satisfactionValues);
        List<Double> distanceValues = weddingHalls.stream().map(distance -> distance.getDistanceFromWeddingVenue()).collect(Collectors.toList());
        double distanceMedian = countMedian(distanceValues);
        for(WeddingHallListInternalModel weddingHall : weddingHalls){
            weddingHall.setPriceClassification(weddingHall.getPrice() < priceMedian ? PriceClassification.CHEAP : PriceClassification.EXPENSIVE);
            weddingHall.setSatisfactionClassification(weddingHall.getRating() < satisfactionMedian ? SatisfactionClassification.BAD : SatisfactionClassification.GOOD);
            weddingHall.setDistanceClassification(weddingHall.getDistanceFromWeddingVenue() < distanceMedian ? DistanceClassification.NEAR : DistanceClassification.FAR);
        }
        return weddingHalls;
    }
}

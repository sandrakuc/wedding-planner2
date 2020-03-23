package org.weddingplanner.form.weddingservicesset;

import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesFilter;
import org.weddingplanner.form.weddingservicesfilter.WeddingServicesWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeddingServicesSetSelector {

    private static int findMinimalNumberOfSets(WeddingServicesWrapper wrapper){
        int[] servicesListSizes = {wrapper.getBeautySalons().size(),
                wrapper.getCarRentings().size(),
                wrapper.getFloristicServices().size(),
                wrapper.getHairDressers().size(),
                wrapper.getMakeUpSalons().size(),
                wrapper.getMusicBands().size(),
                wrapper.getPhotographers().size(),
                wrapper.getWeddingDressStores().size(),
                wrapper.getWeddingSuitesStores().size(),
                wrapper.getWeddingHalls().size()
        };
        Arrays.sort(servicesListSizes);
        return servicesListSizes[0];
    }

    public static List<WeddingServicesSet> createServicesSetByDesertIslandRule(InputDataForm inputDataForm) throws IOException {
        WeddingServicesWrapper wrapper = WeddingServicesFilter.buildServicesWrapper(inputDataForm);
        int minimalNumberOfSets = findMinimalNumberOfSets(wrapper);
        List<WeddingServicesSet> weddingServicesSets = new ArrayList<>();
        for(int i = 0; i < minimalNumberOfSets; i++){
            WeddingServicesSet servicesSet = new WeddingServicesSet()
                    .builder()
                    .beautySalon(wrapper.getBeautySalons().get(i))
                    .carRenting(wrapper.getCarRentings().get(i))
                    .floristicService(wrapper.getFloristicServices().get(i))
                    .hairDresser(wrapper.getHairDressers().get(i))
                    .makeUpSalon(wrapper.getMakeUpSalons().get(i))
                    .musicBand(wrapper.getMusicBands().get(i))
                    .photographer(wrapper.getPhotographers().get(i))
                    .dressStore(wrapper.getWeddingDressStores().get(i))
                    .suiteStore(wrapper.getWeddingSuitesStores().get(i))
                    .hall(wrapper.getWeddingHalls().get(i))
                    .build();
            if(servicesSet.getTotalAmount() > (inputDataForm.getBudget() + inputDataForm.getBudgetMargin())){
                servicesSet = HighestCostServiceToCheaperChanger.changeServicesToCheaper(servicesSet, inputDataForm, wrapper);
            }
            if(servicesSet.getTotalAmount() <= (inputDataForm.getBudget() + inputDataForm.getBudgetMargin())) {
                weddingServicesSets.add(servicesSet);
            }
        }
        Collections.sort(weddingServicesSets);
        Collections.reverse(weddingServicesSets);
        return weddingServicesSets;
    }

}

package org.weddingplanner.form.weddingservicesset;

import org.weddingplanner.searchservices.ServiceInternalModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetToListOfHigherCostWrapperConverter {

    private static HigherCostWrapper setWrapper(ServiceInternalModel model){
        return new HigherCostWrapper(model.getClass().getName(), model.getAvgPrice());
    }

    public static List<HigherCostWrapper> convert(WeddingServicesSet set){
        List<HigherCostWrapper> higherCostWrappers = new ArrayList<>();
        higherCostWrappers.add(setWrapper(set.getBeautySalon()));
        higherCostWrappers.add(setWrapper(set.getCarRenting()));
        higherCostWrappers.add(setWrapper(set.getFloristicService()));
        higherCostWrappers.add(setWrapper(set.getHairDresser()));
        higherCostWrappers.add(setWrapper(set.getMakeUpSalon()));
        higherCostWrappers.add(setWrapper(set.getMusicBand()));
        higherCostWrappers.add(setWrapper(set.getPhotographer()));
        higherCostWrappers.add(setWrapper(set.getDressStore()));
        higherCostWrappers.add(setWrapper(set.getSuiteStore()));
        higherCostWrappers.add(setWrapper(set.getHall()));
        Collections.sort(higherCostWrappers);
        return higherCostWrappers;
    }
}

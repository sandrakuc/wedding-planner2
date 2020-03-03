package org.weddingplanner.searchservices.floristicservices.internal;

import org.weddingplanner.searchservices.floristicservices.external.FloristicServicesListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloristicServicesListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 20;
        return randomMultiplicand * 100;
    }

    public static FloristicServicesListInternalModel convert(FloristicServicesListResultsResponse externalModel){
        FloristicServicesListInternalModel internalModel = new FloristicServicesListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .avgPrice(getPrice())
                .build();
        return internalModel;
    }

    public static List<FloristicServicesListInternalModel> convertList(FloristicServicesListResultsResponse[] externalModels){
        List<FloristicServicesListInternalModel> internalModels = new ArrayList<>();
        for(FloristicServicesListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

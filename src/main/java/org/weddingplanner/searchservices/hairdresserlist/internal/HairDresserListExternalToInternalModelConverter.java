package org.weddingplanner.searchservices.hairdresserlist.internal;

import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListResultsResponse;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HairDresserListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 10;
        return randomMultiplicand * 10;
    }

    public static HairDresserListInternalModel convert(HairDresserListResultsResponse externalModel){
        HairDresserListInternalModel internalModel = new HairDresserListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .avgPrice(getPrice())
                .build();
        return internalModel;
    }

    public static List<HairDresserListInternalModel> convertList(HairDresserListResultsResponse[] externalModels){
        List<HairDresserListInternalModel> internalModels = new ArrayList<>();
        for(HairDresserListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}
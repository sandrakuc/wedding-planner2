package org.weddingplanner.searchservices.weddingsuiteslist.internal;

import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListResultsResponse;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.external.WeddingSuitesListResultsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingSuitesStoreListExternalToInternalModelConverter {

    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(33) + 8;
        return randomMultiplicand * 100;
    }

    public static WeddingSuitesListInternalModel convert(WeddingSuitesListResultsResponse externalModel){
        WeddingSuitesListInternalModel internalModel = new WeddingSuitesListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .avgPrice(getPrice())
                .build();
        return internalModel;
    }

    public static List<WeddingSuitesListInternalModel> convertList(WeddingSuitesListResultsResponse[] externalModels){
        List<WeddingSuitesListInternalModel> internalModels = new ArrayList<>();
        for(WeddingSuitesListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}
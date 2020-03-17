package org.weddingplanner.searchservices.weddingdressstoreslist.internal;

import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListResultsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingDressStoreListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(9) + 2;
        return randomMultiplicand * 1000;
    }

    public static WeddingDressStoreListInternalModel convert(WeddingDressStoreListResultsResponse externalModel){
        WeddingDressStoreListInternalModel internalModel = new WeddingDressStoreListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(getPrice());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<WeddingDressStoreListInternalModel> convertList(WeddingDressStoreListResultsResponse[] externalModels){
        List<WeddingDressStoreListInternalModel> internalModels = new ArrayList<>();
        for(WeddingDressStoreListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

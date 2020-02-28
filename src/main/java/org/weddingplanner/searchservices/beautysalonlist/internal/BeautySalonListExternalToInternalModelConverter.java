package org.weddingplanner.searchservices.beautysalonlist.internal;

import org.weddingplanner.searchservices.beautysalonlist.external.BeautySalonListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeautySalonListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 10;
        return randomMultiplicand * 10;
    }

    public static BeautySalonListInternalModel convert(BeautySalonListResultsResponse externalModel){
        BeautySalonListInternalModel internalModel = new BeautySalonListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .avgPrice(getPrice())
                .build();
        return internalModel;
    }

    public static List<BeautySalonListInternalModel> convertList(BeautySalonListResultsResponse[] externalModels){
        List<BeautySalonListInternalModel> internalModels = new ArrayList<>();
        for(BeautySalonListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

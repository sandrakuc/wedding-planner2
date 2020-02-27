package org.weddingplanner.searchservices.makeupsalonlist.internal;

import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListResultsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeUpSalonListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 10;
        return randomMultiplicand * 10;
    }

    public static MakeUpSalonListInternalModel convert(MakeUpSalonListResultsResponse externalModel){
        MakeUpSalonListInternalModel internalModel = new MakeUpSalonListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .avgPrice(getPrice())
                .build();
        return internalModel;
    }

    public static List<MakeUpSalonListInternalModel> convertList(MakeUpSalonListResultsResponse[] externalModels){
        List<MakeUpSalonListInternalModel> internalModels = new ArrayList<>();
        for(MakeUpSalonListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

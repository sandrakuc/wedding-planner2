package org.weddingplanner.searchservices.musicbandlist.internal;

import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListResultsResponse;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicBandListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(9) + 4;
        return randomMultiplicand * 500;
    }

    public static MusicBandListInternalModel convert(MusicBandListResultsResponse externalModel){
        MusicBandListInternalModel internalModel = new MusicBandListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .avgPrice(getPrice())
                .build();
        return internalModel;
    }

    public static List<MusicBandListInternalModel> convertList(MusicBandListResultsResponse[] externalModels){
        List<MusicBandListInternalModel> internalModels = new ArrayList<>();
        for(MusicBandListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

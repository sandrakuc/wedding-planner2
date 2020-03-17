package org.weddingplanner.searchservices.photographerlist.internal;

import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.external.PhotographerListResultsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhotographerListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(30) + 31;
        return randomMultiplicand * 100;
    }

    public static PhotographerListInternalModel convert(PhotographerListResultsResponse externalModel){
        PhotographerListInternalModel internalModel = new PhotographerListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(getPrice());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<PhotographerListInternalModel> convertList(PhotographerListResultsResponse[] externalModels){
        List<PhotographerListInternalModel> internalModels = new ArrayList<>();
        for(PhotographerListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

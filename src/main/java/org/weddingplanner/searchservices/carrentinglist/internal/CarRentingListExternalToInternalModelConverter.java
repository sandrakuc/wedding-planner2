package org.weddingplanner.searchservices.carrentinglist.internal;

import org.weddingplanner.searchservices.carrentinglist.external.CarRentingListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRentingListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(15) + 5;
        return randomMultiplicand * 100;
    }

    public static CarRentingListInternalModel convert(CarRentingListResultsResponse externalModel){
        CarRentingListInternalModel internalModel = new CarRentingListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(getPrice());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<CarRentingListInternalModel> convertList(CarRentingListResultsResponse[] externalModels){
        List<CarRentingListInternalModel> internalModels = new ArrayList<>();
        for(CarRentingListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

package org.weddingplanner.searchservices.weddinghalllist.internal;

import org.weddingplanner.searchservices.weddinghalllist.external.WeddingHallListResultsResponse;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationExternalToInternalModelConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingHallListExternalModelToInternalModelConverter {

    private WeddingHallListExternalModelToInternalModelConverter() throws Exception {
        throw new Exception(String.format("Sorry, there is no %s instance for you!", this.getClass()));
    }

    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(21) + 10;
        return randomMultiplicand * 10;
    }

    private static int getMaxGuestsQuantity(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(23) + 8;
        return randomMultiplicand * 10;
    }

    public static WeddingHallListInternalModel convert(WeddingHallListResultsResponse externalModel){
        WeddingHallListInternalModel weddingHallListInternalModel = new WeddingHallListInternalModel()
                .builder()
                .name(externalModel.getName())
                .address(externalModel.getFormatted_address())
                .rating(externalModel.getRating())
                .latitude(String.valueOf(externalModel.getGeometry().getLocation().getLat()))
                .longitude(String.valueOf(externalModel.getGeometry().getLocation().getLng()))
                .price(getPrice())
                .maxGuestsQuantity(getMaxGuestsQuantity())
                .build();
        return weddingHallListInternalModel;
    }

    public static List<WeddingHallListInternalModel> convertList(WeddingHallListResultsResponse[] externalModels){
        List<WeddingHallListInternalModel> internalModels = new ArrayList<>();
        for(WeddingHallListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel));
        }
        return internalModels;
    }
}

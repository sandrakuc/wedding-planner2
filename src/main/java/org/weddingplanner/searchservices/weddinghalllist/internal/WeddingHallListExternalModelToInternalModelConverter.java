package org.weddingplanner.searchservices.weddinghalllist.internal;

import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddinghalllist.external.WeddingHallListResultsResponse;
import org.weddingplanner.searchservices.weddingvenuegeolocation.WeddingVenueGeolocationApiHandler;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationExternalToInternalModelConverter;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationInternalModel;
import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.WeddingVenueWeddingHallDistanceApiHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingHallListExternalModelToInternalModelConverter {

    private WeddingHallListExternalModelToInternalModelConverter() throws Exception {
        throw new Exception(String.format("Sorry, there is no %s instance for you!", this.getClass()));
    }

    private static int getPrice(InputDataForm form){ // todo get from new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(21) + 10;
        return randomMultiplicand * 10 * form.getGuestQuantity();
    }

    private static int getMaxGuestsQuantity(){ // todo get from new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(23) + 8;
        return randomMultiplicand * 10;
    }

    public static WeddingHallListInternalModel convert(WeddingHallListResultsResponse externalModel, WeddingVenueGeolocationInternalModel geolocationInternalModel, InputDataForm form) throws IOException {
        WeddingVenueWeddingHallDistanceApiHandler apiHandler = new WeddingVenueWeddingHallDistanceApiHandler();
        WeddingHallListInternalModel weddingHallListInternalModel = new WeddingHallListInternalModel();
        weddingHallListInternalModel.setName(externalModel.getName());
        weddingHallListInternalModel.setAddress(externalModel.getFormatted_address());
        weddingHallListInternalModel.setRating(externalModel.getRating());
        weddingHallListInternalModel.setLatitude(String.valueOf(externalModel.getGeometry().getLocation().getLat()));
        weddingHallListInternalModel.setLongitude(String.valueOf(externalModel.getGeometry().getLocation().getLng()));
        weddingHallListInternalModel.setAvgPrice(getPrice(form));
        weddingHallListInternalModel.setMaxGuestsQuantity(getMaxGuestsQuantity());
        weddingHallListInternalModel.setDistanceFromWeddingVenue(apiHandler.getDistance(geolocationInternalModel.getLatitude(), geolocationInternalModel.getLongitude(), String.valueOf(externalModel.getGeometry().getLocation().getLat()), String.valueOf(externalModel.getGeometry().getLocation().getLng())));
        return weddingHallListInternalModel;
    }

    public static List<WeddingHallListInternalModel> convertList(WeddingHallListResultsResponse[] externalModels, InputDataForm form) throws IOException {
        WeddingVenueGeolocationApiHandler apiHandler = new WeddingVenueGeolocationApiHandler();
        WeddingVenueGeolocationInternalModel internalModel = apiHandler.getWeddingVenueGeolocation(form);
        List<WeddingHallListInternalModel> internalModels = new ArrayList<>();
        for(WeddingHallListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, internalModel, form));
        }
        return internalModels;
    }
}

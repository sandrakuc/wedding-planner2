package org.weddingplanner.searchservices.weddingvenuegeolocation.internal;

import org.weddingplanner.searchservices.weddingvenuegeolocation.external.WeddingVenueGeolocationPositionResponse;
import org.weddingplanner.searchservices.weddingvenuegeolocation.external.WeddingVenueGeolocationResponse;

public enum WeddingVenueGeolocationExternalToInternalModelConverter {

    INSTANCE;

    public WeddingVenueGeolocationInternalModel convert(WeddingVenueGeolocationResponse response){
        WeddingVenueGeolocationPositionResponse externalModel = response.getView()[0].getResult()[0].getLocation().getDisplayPosition();
        WeddingVenueGeolocationInternalModel internalModel = new WeddingVenueGeolocationInternalModel()
                .builder()
                .latitude(String.valueOf(externalModel.getLatitude()))
                .longitude(String.valueOf(externalModel.getLongitude()))
                .build();
        return internalModel;
    }
}

package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingvenuegeolocation.WeddingVenueGeolocationApiHandler;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationInternalModel;

import java.io.IOException;

public class WeddingVenueGeolocationTest {

    @Test
    public void getWeddingVenueGeolocation() throws IOException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .build();
        WeddingVenueGeolocationApiHandler apiHandler = new WeddingVenueGeolocationApiHandler();
        WeddingVenueGeolocationInternalModel internalModel = apiHandler.getWeddingVenueGeolocation(form);
        Assert.assertTrue(internalModel != null);
        Assert.assertTrue(Double.parseDouble(internalModel.getLatitude()) >= 50 && Double.parseDouble(internalModel.getLatitude()) <= 51);
        Assert.assertTrue(Double.parseDouble(internalModel.getLongitude()) >= 20 && Double.parseDouble(internalModel.getLongitude()) <= 21);
    }
}

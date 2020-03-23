package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddinghalllist.WeddingHallListApiHandler;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

import java.io.IOException;
import java.util.List;

public class WeddingHallListTest {

    @Test
    public void getWeddingHallListTest() throws IOException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .build();
        WeddingHallListApiHandler apiHandler = new WeddingHallListApiHandler();
        List<WeddingHallListInternalModel> internalModels = apiHandler.getWeddingHallList(form);
        Assert.assertNotNull(internalModels);
        Assert.assertTrue(internalModels.size() > 0);
        for(WeddingHallListInternalModel internalModel : internalModels){
            Assert.assertTrue(internalModel.getAvgPrice() >= (100 * form.getGuestQuantity()) && internalModel.getAvgPrice() <= (300 * form.getGuestQuantity()));
            Assert.assertTrue(internalModel.getMaxGuestsQuantity() >= 80 && internalModel.getMaxGuestsQuantity() <= 300);
            Assert.assertTrue(internalModel.getDistanceFromWeddingVenue() > 0);
        }
    }
}

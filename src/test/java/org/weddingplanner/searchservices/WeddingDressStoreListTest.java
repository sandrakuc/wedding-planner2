package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingdressstoreslist.WeddingDressStoreListApiHandler;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;

import java.io.IOException;
import java.util.List;

public class WeddingDressStoreListTest {

    @Test
    public void getWeddingDressStoreListTest() throws IOException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .build();
        WeddingDressStoreListApiHandler apiHandler = new WeddingDressStoreListApiHandler();
        List<WeddingDressStoreListInternalModel> internalModelList = apiHandler.getWeddingDressStoresList(form);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(WeddingDressStoreListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 2000 && internalModel.getAvgPrice() <= 10000);
        }
    }
}

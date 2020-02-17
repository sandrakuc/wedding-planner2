package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.searchservices.weddinghalllist.WeddingHallListApiHandler;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

import java.io.IOException;
import java.util.List;

public class WeddingHallListTest {

    @Test
    public void getWeddingHallListTest() throws IOException {
        String provinceName = "świętokrzyskie";
        WeddingHallListApiHandler apiHandler = new WeddingHallListApiHandler();
        List<WeddingHallListInternalModel> internalModels = apiHandler.getWeddingHallList(provinceName);
        Assert.assertNotNull(internalModels);
        Assert.assertTrue(internalModels.size() > 0);
        for(WeddingHallListInternalModel internalModel : internalModels){
            Assert.assertTrue(internalModel.getPrice() >= 100 && internalModel.getPrice() <= 300);
            Assert.assertTrue(internalModel.getMaxGuestsQuantity() >= 80 && internalModel.getMaxGuestsQuantity() <= 300);
        }
    }
}

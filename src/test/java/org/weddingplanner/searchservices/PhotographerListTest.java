package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.musicbandlist.MusicBandListApiHandler;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.PhotographerListApiHandler;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;

import java.io.IOException;
import java.util.List;

public class PhotographerListTest {

    @Test
    public void getPhotographerListTest() throws IOException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .build();
        PhotographerListApiHandler apiHandler = new PhotographerListApiHandler();
        List<PhotographerListInternalModel> internalModelList = apiHandler.getPhotographerList(form);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(PhotographerListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 3000 && internalModel.getAvgPrice() <= 6000);
        }
    }
}

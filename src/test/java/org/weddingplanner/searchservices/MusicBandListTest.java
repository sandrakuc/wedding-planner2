package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.makeupsalonlist.MakeUpSalonListApiHandler;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.MusicBandListApiHandler;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;

import java.io.IOException;
import java.util.List;

public class MusicBandListTest {

    @Test
    public void getMakeUpSalonListTest() throws IOException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .build();
        MusicBandListApiHandler apiHandler = new MusicBandListApiHandler();
        List<MusicBandListInternalModel> internalModelList = apiHandler.getMusicBandList(form);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(MusicBandListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 2000 && internalModel.getAvgPrice() <= 6000);
        }
    }
}

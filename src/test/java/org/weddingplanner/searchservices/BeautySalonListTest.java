package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.beautysalonlist.BeautySalonListApiHandler;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.HairDresserListApiHandler;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;

import java.io.IOException;
import java.util.List;

public class BeautySalonListTest {

    @Test
    public void getBeautySalonListTest() throws IOException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .brideLivingProvince("świętokrzyskie")
                .build();
        BeautySalonListApiHandler apiHandler = new BeautySalonListApiHandler();
        List<BeautySalonListInternalModel> internalModelList = apiHandler.getBeautySalonList(form);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(BeautySalonListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 100 && internalModel.getAvgPrice() <= 200);
        }
    }
}

package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.companies.CompanyDaoImpl;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.hairdresserlist.HairDresserListApiHandler;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HairDresserListTest {

    @Test
    public void getHairDresserListTest() throws IOException, SQLException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .build();
        CompanyDao companyDao = new CompanyDaoImpl();
        HairDresserListApiHandler apiHandler = new HairDresserListApiHandler();
        List<HairDresserListInternalModel> internalModelList = apiHandler.getHairDresserList(form, companyDao);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(HairDresserListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 100 && internalModel.getAvgPrice() <= 200);
        }
    }
}

package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.companies.CompanyDaoImpl;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.photographerlist.PhotographerListApiHandler;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PhotographerListTest {

    @Test
    public void getPhotographerListTest() throws IOException, SQLException {
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
        PhotographerListApiHandler apiHandler = new PhotographerListApiHandler();
        List<PhotographerListInternalModel> internalModelList = apiHandler.getPhotographerList(form, companyDao);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(PhotographerListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 3000 && internalModel.getAvgPrice() <= 6000);
        }
    }
}

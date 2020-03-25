package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.companies.CompanyDaoImpl;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingdressstoreslist.WeddingDressStoreListApiHandler;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.WeddingSuitesListApiHandler;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class WeddingSuitesListTest {

    @Test
    public void getWeddingSuitesListTest() throws IOException, SQLException {
        InputDataForm form = new InputDataForm()
                .builder()
                .weddingVenueStreet("Pl. Panny Marii")
                .weddingVenuePossessionNumber("3")
                .weddingVenuePostalCode("25-010")
                .weddingVenueCity("Kielce")
                .weddingVenueProvince("świętokrzyskie")
                .brideLivingCity("Skorzeszyce")
                .groomLivingCity("Strawczyn")
                .build();
        CompanyDao companyDao = new CompanyDaoImpl();
        WeddingSuitesListApiHandler apiHandler = new WeddingSuitesListApiHandler();
        List<WeddingSuitesListInternalModel> internalModelList = apiHandler.getWeddingSuitesList(form, companyDao);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(WeddingSuitesListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 800 && internalModel.getAvgPrice() <= 4000);
        }
    }
}

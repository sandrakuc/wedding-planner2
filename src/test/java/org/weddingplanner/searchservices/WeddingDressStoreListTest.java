package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.companies.CompanyDaoImpl;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingdressstoreslist.WeddingDressStoreListApiHandler;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class WeddingDressStoreListTest {

    @Test
    public void getWeddingDressStoreListTest() throws IOException, SQLException {
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
        WeddingDressStoreListApiHandler apiHandler = new WeddingDressStoreListApiHandler();
        List<WeddingDressStoreListInternalModel> internalModelList = apiHandler.getWeddingDressStoresList(form, companyDao);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(WeddingDressStoreListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 2000 && internalModel.getAvgPrice() <= 10000);
        }
    }
}

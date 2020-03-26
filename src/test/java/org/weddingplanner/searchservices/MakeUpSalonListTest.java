package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.companies.CompanyDaoImpl;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.makeupsalonlist.MakeUpSalonListApiHandler;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MakeUpSalonListTest {

    @Test
    public void getMakeUpSalonListTest() throws IOException, SQLException {
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
        MakeUpSalonListApiHandler apiHandler = new MakeUpSalonListApiHandler();
        List<MakeUpSalonListInternalModel> internalModelList = apiHandler.getMakeUpSalonList(form, companyDao);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(MakeUpSalonListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 100 && internalModel.getAvgPrice() <= 200);
        }
    }

}

package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.companies.CompanyDaoImpl;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.carrentinglist.CarRentingListApiHandler;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarRentingListTest {

    @Test
    public void getCarRentingListTest() throws IOException, SQLException {
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
        CompanyDao companyDao = new CompanyDaoImpl();
        CarRentingListApiHandler apiHandler = new CarRentingListApiHandler();
        List<CarRentingListInternalModel> internalModelList = apiHandler.getCarRentingList(form, companyDao);
        Assert.assertNotNull(internalModelList);
        Assert.assertTrue(internalModelList.size() > 0);
        for(CarRentingListInternalModel internalModel : internalModelList){
            Assert.assertTrue(internalModel.getAvgPrice() >= 500 && internalModel.getAvgPrice() <= 2000);
        }
    }
}

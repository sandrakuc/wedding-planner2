package org.weddingplanner.searchservices.carrentinglist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.carrentinglist.external.CarRentingListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRentingListExternalToInternalModelConverter {
    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(15) + 5;
        return randomMultiplicand * 100;
    }

    public static CarRentingListInternalModel convert(CarRentingListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        CarRentingListInternalModel internalModel = new CarRentingListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_CARS[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.CAR_RENTING_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<CarRentingListInternalModel> convertList(CarRentingListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<CarRentingListInternalModel> internalModels = new ArrayList<>();
        for(CarRentingListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

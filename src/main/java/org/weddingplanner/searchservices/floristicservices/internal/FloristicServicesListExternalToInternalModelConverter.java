package org.weddingplanner.searchservices.floristicservices.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.floristicservices.external.FloristicServicesListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloristicServicesListExternalToInternalModelConverter {
    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 20;
        return randomMultiplicand * 100;
    }

    public static FloristicServicesListInternalModel convert(FloristicServicesListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        FloristicServicesListInternalModel internalModel = new FloristicServicesListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_FS[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.FLORIST_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<FloristicServicesListInternalModel> convertList(FloristicServicesListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<FloristicServicesListInternalModel> internalModels = new ArrayList<>();
        for(FloristicServicesListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

package org.weddingplanner.searchservices.weddingsuiteslist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.weddingsuiteslist.external.WeddingSuitesListResultsResponse;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingSuitesStoreListExternalToInternalModelConverter {

    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(33) + 8;
        return randomMultiplicand * 100;
    }

    public static WeddingSuitesListInternalModel convert(WeddingSuitesListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        WeddingSuitesListInternalModel internalModel = new WeddingSuitesListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setRating(externalModel.getRating());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_WS[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.WEDDING_SUITE_WEBSITE : company.getWebsite());
        internalModel.setEmail(CommonUtils.WEDDING_SUITE_EMAIL);
        internalModel.setPhoneNumber(CommonUtils.generatePhoneNumber());
        return internalModel;
    }

    public static List<WeddingSuitesListInternalModel> convertList(WeddingSuitesListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<WeddingSuitesListInternalModel> internalModels = new ArrayList<>();
        for(WeddingSuitesListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

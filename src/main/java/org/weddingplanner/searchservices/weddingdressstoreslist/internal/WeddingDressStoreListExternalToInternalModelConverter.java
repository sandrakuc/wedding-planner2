package org.weddingplanner.searchservices.weddingdressstoreslist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListResultsResponse;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingDressStoreListExternalToInternalModelConverter {
    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(9) + 2;
        return randomMultiplicand * 1000;
    }

    public static WeddingDressStoreListInternalModel convert(WeddingDressStoreListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        WeddingDressStoreListInternalModel internalModel = new WeddingDressStoreListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_WD[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.WEDDING_DRESS_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<WeddingDressStoreListInternalModel> convertList(WeddingDressStoreListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<WeddingDressStoreListInternalModel> internalModels = new ArrayList<>();
        for(WeddingDressStoreListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

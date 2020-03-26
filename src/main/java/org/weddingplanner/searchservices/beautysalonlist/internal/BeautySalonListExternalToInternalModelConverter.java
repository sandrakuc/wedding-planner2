package org.weddingplanner.searchservices.beautysalonlist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.beautysalonlist.external.BeautySalonListResultsResponse;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeautySalonListExternalToInternalModelConverter {

    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 10;
        return randomMultiplicand * 10;
    }

    public static BeautySalonListInternalModel convert(BeautySalonListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        BeautySalonListInternalModel internalModel = new BeautySalonListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setRating(externalModel.getRating());
        internalModel.setImage(company == null ? CommonUtils.PHOTOS_BS[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.BEAUTY_SALON_WEBSITE : company.getWebsite());
        internalModel.setEmail(CommonUtils.BEAUTY_SALON_EMAIL);
        internalModel.setPhoneNumber(CommonUtils.generatePhoneNumber());
        return internalModel;
    }

    public static List<BeautySalonListInternalModel> convertList(BeautySalonListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<BeautySalonListInternalModel> internalModels = new ArrayList<>();
        for(BeautySalonListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

package org.weddingplanner.searchservices.hairdresserlist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListResultsResponse;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HairDresserListExternalToInternalModelConverter {
    private static int getPrice(){ // todo getFrom new base
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 10;
        return randomMultiplicand * 10;
    }

    public static HairDresserListInternalModel convert(HairDresserListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        HairDresserListInternalModel internalModel = new HairDresserListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_HD[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.HAIR_DRESSER_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<HairDresserListInternalModel> convertList(HairDresserListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<HairDresserListInternalModel> internalModels = new ArrayList<>();
        for(HairDresserListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

package org.weddingplanner.searchservices.photographerlist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.external.PhotographerListResultsResponse;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhotographerListExternalToInternalModelConverter {
    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(30) + 31;
        return randomMultiplicand * 100;
    }

    public static PhotographerListInternalModel convert(PhotographerListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        PhotographerListInternalModel internalModel = new PhotographerListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_PH[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.PHOTOGRAPHER_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<PhotographerListInternalModel> convertList(PhotographerListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<PhotographerListInternalModel> internalModels = new ArrayList<>();
        for(PhotographerListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

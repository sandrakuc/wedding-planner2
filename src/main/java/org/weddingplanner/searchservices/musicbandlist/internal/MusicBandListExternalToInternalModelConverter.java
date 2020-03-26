package org.weddingplanner.searchservices.musicbandlist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicBandListExternalToInternalModelConverter {

    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(9) + 4;
        return randomMultiplicand * 500;
    }

    public static MusicBandListInternalModel convert(MusicBandListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        MusicBandListInternalModel internalModel = new MusicBandListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_MB[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.MUSIC_BAND_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        internalModel.setEmail(CommonUtils.MUSIC_BAND_EMAIL);
        internalModel.setPhoneNumber(CommonUtils.generatePhoneNumber());
        return internalModel;
    }

    public static List<MusicBandListInternalModel> convertList(MusicBandListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<MusicBandListInternalModel> internalModels = new ArrayList<>();
        for(MusicBandListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

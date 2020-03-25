package org.weddingplanner.searchservices.makeupsalonlist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListResultsResponse;
import org.weddingplanner.utils.CommonUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MakeUpSalonListExternalToInternalModelConverter {
    private static int getPrice(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(11) + 10;
        return randomMultiplicand * 10;
    }

    public static MakeUpSalonListInternalModel convert(MakeUpSalonListResultsResponse externalModel, CompanyDao companyDao, String city) throws SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), city);
        MakeUpSalonListInternalModel internalModel = new MakeUpSalonListInternalModel();
        internalModel.setName(externalModel.getName());
        internalModel.setAddress(externalModel.getFormatted_address());
        internalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice() : company.getPrice());
        internalModel.setImage(company == null ? CommonUtils.PHOTO_MK[index] : company.getImage());
        internalModel.setWebsite(company == null ? CommonUtils.MAKE_UP_WEBSITE : company.getWebsite());
        internalModel.setRating(externalModel.getRating());
        return internalModel;
    }

    public static List<MakeUpSalonListInternalModel> convertList(MakeUpSalonListResultsResponse[] externalModels, CompanyDao companyDao, String city) throws SQLException {
        List<MakeUpSalonListInternalModel> internalModels = new ArrayList<>();
        for(MakeUpSalonListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, companyDao, city));
        }
        return internalModels;
    }
}

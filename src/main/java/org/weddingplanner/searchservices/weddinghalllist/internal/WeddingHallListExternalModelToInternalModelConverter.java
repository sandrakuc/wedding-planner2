package org.weddingplanner.searchservices.weddinghalllist.internal;

import org.weddingplanner.form.companies.Company;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddinghalllist.external.WeddingHallListResultsResponse;
import org.weddingplanner.searchservices.weddingvenuegeolocation.WeddingVenueGeolocationApiHandler;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationInternalModel;
import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.WeddingVenueWeddingHallDistanceApiHandler;
import org.weddingplanner.utils.CommonUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeddingHallListExternalModelToInternalModelConverter {

    private static int getPrice(InputDataForm form){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(21) + 10;
        return randomMultiplicand * 10 * form.getGuestQuantity();
    }

    private static int getMaxGuestsQuantity(){
        Random rd = new Random();
        int randomMultiplicand = rd.nextInt(23) + 8;
        return randomMultiplicand * 10;
    }

    public static WeddingHallListInternalModel convert(WeddingHallListResultsResponse externalModel, WeddingVenueGeolocationInternalModel geolocationInternalModel, InputDataForm form, CompanyDao companyDao) throws IOException, SQLException {
        Random random = new Random();
        int index = random.nextInt(10);
        Company company = companyDao.getCompanyByNameAndCity(externalModel.getName(), form.getWeddingVenueCity());
        WeddingVenueWeddingHallDistanceApiHandler apiHandler = new WeddingVenueWeddingHallDistanceApiHandler();
        WeddingHallListInternalModel weddingHallListInternalModel = new WeddingHallListInternalModel();
        weddingHallListInternalModel.setName(externalModel.getName());
        weddingHallListInternalModel.setAddress(externalModel.getFormatted_address());
        weddingHallListInternalModel.setRating(externalModel.getRating());
        weddingHallListInternalModel.setLatitude(String.valueOf(externalModel.getGeometry().getLocation().getLat()));
        weddingHallListInternalModel.setLongitude(String.valueOf(externalModel.getGeometry().getLocation().getLng()));
        weddingHallListInternalModel.setAvgPrice(company == null || company.getPrice() < 100 ? getPrice(form) : company.getPrice());
        weddingHallListInternalModel.setImage(company == null ? CommonUtils.PHOTO_WH[index] : company.getImage());
        weddingHallListInternalModel.setWebsite(company == null ? CommonUtils.WEDDING_HALL_WEBSITE : company.getWebsite());
        weddingHallListInternalModel.setMaxGuestsQuantity(company == null || company.getGuests() == 0 ? getMaxGuestsQuantity() : company.getGuests());
        weddingHallListInternalModel.setDistanceFromWeddingVenue(apiHandler.getDistance(geolocationInternalModel.getLatitude(), geolocationInternalModel.getLongitude(), String.valueOf(externalModel.getGeometry().getLocation().getLat()), String.valueOf(externalModel.getGeometry().getLocation().getLng())));
        weddingHallListInternalModel.setEmail(CommonUtils.WEDDING_HALL_EMAIL);
        weddingHallListInternalModel.setPhoneNumber(CommonUtils.generatePhoneNumber());
        return weddingHallListInternalModel;
    }

    public static List<WeddingHallListInternalModel> convertList(WeddingHallListResultsResponse[] externalModels, InputDataForm form, CompanyDao companyDao) throws IOException, SQLException {
        WeddingVenueGeolocationApiHandler apiHandler = new WeddingVenueGeolocationApiHandler();
        WeddingVenueGeolocationInternalModel internalModel = apiHandler.getWeddingVenueGeolocation(form);
        List<WeddingHallListInternalModel> internalModels = new ArrayList<>();
        for(WeddingHallListResultsResponse externalModel : externalModels){
            internalModels.add(convert(externalModel, internalModel, form, companyDao));
        }
        return internalModels;
    }
}

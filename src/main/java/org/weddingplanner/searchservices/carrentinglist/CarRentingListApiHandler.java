package org.weddingplanner.searchservices.carrentinglist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.carrentinglist.external.CarRentingListExternalModel;
import org.weddingplanner.searchservices.carrentinglist.external.CarRentingListResultsResponse;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class CarRentingListApiHandler {

    public String getEndpoint(String provinceName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=wynajem+samochodów+" + provinceName + "&key=" + CarRentingListUtils.getApiKey();
        return endpoint;
    }

    private CarRentingListResultsResponse[] sendRequest(String provinceName) throws IOException {
        URL url = new URL(getEndpoint(provinceName));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder content;
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        content = new StringBuilder();
        while ((line = in.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }
        ObjectMapper objectMapper = new ObjectMapper();
        CarRentingListExternalModel response = objectMapper.readValue(content.toString(), CarRentingListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<CarRentingListInternalModel> getCarRentingList(InputDataForm inputDataForm, CompanyDao companyDao) throws IOException, SQLException {
        CarRentingListResultsResponse[] externalModels = sendRequest(inputDataForm.getWeddingVenueProvince());
        List<CarRentingListInternalModel> internalModels = CarRentingListExternalToInternalModelConverter.convertList(externalModels, companyDao, inputDataForm.getWeddingVenueCity());
        return internalModels;
    }
}

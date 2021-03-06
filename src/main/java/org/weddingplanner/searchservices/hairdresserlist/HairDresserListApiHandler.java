package org.weddingplanner.searchservices.hairdresserlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListExternalModel;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class HairDresserListApiHandler {

    public String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=salon+fryzjerski+" + cityName + "&key=" + HairDresserListUtils.getApiKey();
        return endpoint;
    }

    private HairDresserListResultsResponse[] sendRequest(String cityName) throws IOException {
        URL url = new URL(getEndpoint(cityName));
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
        HairDresserListExternalModel response = objectMapper.readValue(content.toString(), HairDresserListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<HairDresserListInternalModel> getHairDresserList(InputDataForm inputDataForm, CompanyDao companyDao) throws IOException, SQLException {
        HairDresserListResultsResponse[] externalModels = sendRequest(inputDataForm.getWeddingVenueCity());
        List<HairDresserListInternalModel> internalModels = HairDresserListExternalToInternalModelConverter.convertList(externalModels, companyDao, inputDataForm.getWeddingVenueCity());
        return internalModels;
    }
}

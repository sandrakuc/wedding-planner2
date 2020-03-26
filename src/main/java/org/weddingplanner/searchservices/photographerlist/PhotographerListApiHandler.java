package org.weddingplanner.searchservices.photographerlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.photographerlist.external.PhotographerListExternalModel;
import org.weddingplanner.searchservices.photographerlist.external.PhotographerListResultsResponse;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class PhotographerListApiHandler {

    public String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=fotograf+" + cityName + "&key=" + PhotographerListUtils.getApiKey();
        return endpoint;
    }

    private PhotographerListResultsResponse[] sendRequest(String cityName) throws IOException {
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
        PhotographerListExternalModel response = objectMapper.readValue(content.toString(), PhotographerListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<PhotographerListInternalModel> getPhotographerList(InputDataForm inputDataForm, CompanyDao companyDao) throws IOException, SQLException {
        PhotographerListResultsResponse[] externalModels = sendRequest(inputDataForm.getWeddingVenueCity());
        List<PhotographerListInternalModel> internalModels = PhotographerListExternalToInternalModelConverter.convertList(externalModels, companyDao, inputDataForm.getWeddingVenueCity());
        return internalModels;
    }
}

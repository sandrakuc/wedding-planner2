package org.weddingplanner.searchservices.floristicservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.floristicservices.external.FloristicServicesListExternalModel;
import org.weddingplanner.searchservices.floristicservices.external.FloristicServicesListResultsResponse;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class FloristicServicesListApiHandler {
    public String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=kwiaciarnia+" + cityName + "&key=" + FloristicServicesListUtils.getApiKey();
        return endpoint;
    }

    private FloristicServicesListResultsResponse[] sendRequest(String cityName) throws IOException {
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
        FloristicServicesListExternalModel response = objectMapper.readValue(content.toString(), FloristicServicesListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<FloristicServicesListInternalModel> getFloristicServicesList(InputDataForm inputDataForm, CompanyDao companyDao) throws IOException, SQLException {
        FloristicServicesListResultsResponse[] externalModels = sendRequest(inputDataForm.getWeddingVenueCity());
        List<FloristicServicesListInternalModel> internalModels = FloristicServicesListExternalToInternalModelConverter.convertList(externalModels, companyDao, inputDataForm.getWeddingVenueCity());
        return internalModels;
    }
}

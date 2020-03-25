package org.weddingplanner.searchservices.weddinghalllist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddinghalllist.external.WeddingHallListExternalModel;
import org.weddingplanner.searchservices.weddinghalllist.external.WeddingHallListResultsResponse;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListExternalModelToInternalModelConverter;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class WeddingHallListApiHandler {
    private String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=sale+weselne+" + cityName + "&key=" + WeddingHallListUtils.getApiKey();
        return endpoint;
    }

    private WeddingHallListResultsResponse[] sendRequest(String cityName) throws IOException {
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
        WeddingHallListExternalModel response = objectMapper.readValue(content.toString(), WeddingHallListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<WeddingHallListInternalModel> getWeddingHallList(InputDataForm form, CompanyDao companyDao) throws IOException, SQLException {
        WeddingHallListResultsResponse[] externalModels = sendRequest(form.getWeddingVenueCity());
        List<WeddingHallListInternalModel> internalModels = WeddingHallListExternalModelToInternalModelConverter.convertList(externalModels, form, companyDao);
        return internalModels;
    }
}

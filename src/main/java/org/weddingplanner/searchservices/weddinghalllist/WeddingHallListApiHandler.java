package org.weddingplanner.searchservices.weddinghalllist;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.List;

public class WeddingHallListApiHandler {
    private String getEndpoint(String provinceName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=sale+weselne+" + provinceName + "&key=" + WeddingHallListUtils.getApiKey();
        return endpoint;
    }

    private WeddingHallListResultsResponse[] sendRequest(String provinceName) throws IOException {
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
        WeddingHallListExternalModel response = objectMapper.readValue(content.toString(), WeddingHallListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<WeddingHallListInternalModel> getWeddingHallList(InputDataForm form) throws IOException {
        WeddingHallListResultsResponse[] externalModels = sendRequest(form.getWeddingVenueProvince());
        List<WeddingHallListInternalModel> internalModels = WeddingHallListExternalModelToInternalModelConverter.convertList(externalModels, form);
        return internalModels;
    }
}

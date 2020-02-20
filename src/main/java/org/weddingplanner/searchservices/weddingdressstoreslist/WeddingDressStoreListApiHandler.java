package org.weddingplanner.searchservices.weddingdressstoreslist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListExternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.external.WeddingDressStoreListResultsResponse;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class WeddingDressStoreListApiHandler {
    public String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=salon+sukni+ślubnych+" + cityName + "&key=" + WeddingDressStoreListUtils.getApiKey();
        return endpoint;
    }

    private WeddingDressStoreListResultsResponse[] sendRequest(String cityName) throws IOException {
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
        WeddingDressStoreListExternalModel response = objectMapper.readValue(content.toString(), WeddingDressStoreListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<WeddingDressStoreListInternalModel> getWeddingDressStoresList(InputDataForm inputDataForm) throws IOException {
        WeddingDressStoreListResultsResponse[] externalModels = sendRequest(inputDataForm.getBrideLivingCity());
        List<WeddingDressStoreListInternalModel> internalModels = WeddingDressStoreListExternalToInternalModelConverter.convertList(externalModels);
        return internalModels;
    }
}

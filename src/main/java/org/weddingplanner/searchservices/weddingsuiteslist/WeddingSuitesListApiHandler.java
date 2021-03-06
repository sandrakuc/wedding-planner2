package org.weddingplanner.searchservices.weddingsuiteslist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.companies.CompanyDao;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingsuiteslist.external.WeddingSuitesListExternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.external.WeddingSuitesListResultsResponse;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesStoreListExternalToInternalModelConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

public class WeddingSuitesListApiHandler {

    public String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=garnitury+" + cityName + "&key=" + WeddingSuitesListUtils.getApiKey();
        return endpoint;
    }

    private WeddingSuitesListResultsResponse[] sendRequest(String cityName) throws IOException {
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
        WeddingSuitesListExternalModel response = objectMapper.readValue(content.toString(), WeddingSuitesListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<WeddingSuitesListInternalModel> getWeddingSuitesList(InputDataForm inputDataForm, CompanyDao companyDao) throws IOException, SQLException {
        WeddingSuitesListResultsResponse[] externalModels = sendRequest(inputDataForm.getGroomLivingCity());
        List<WeddingSuitesListInternalModel> internalModels = WeddingSuitesStoreListExternalToInternalModelConverter.convertList(externalModels, companyDao, inputDataForm.getGroomLivingCity());
        return internalModels;
    }
}

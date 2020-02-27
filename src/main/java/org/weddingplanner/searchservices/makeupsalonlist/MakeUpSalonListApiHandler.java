package org.weddingplanner.searchservices.makeupsalonlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.hairdresserlist.HairDresserListUtils;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListExternalModel;
import org.weddingplanner.searchservices.hairdresserlist.external.HairDresserListResultsResponse;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListExternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListResultsResponse;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MakeUpSalonListApiHandler {
    public String getEndpoint(String cityName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=makijaż+" + cityName + "&key=" + MakeUpSalonListUtils.getApiKey();
        return endpoint;
    }

    private MakeUpSalonListResultsResponse[] sendRequest(String cityName) throws IOException {
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
        MakeUpSalonListExternalModel response = objectMapper.readValue(content.toString(), MakeUpSalonListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<MakeUpSalonListInternalModel> getMakeUpSalonList(InputDataForm inputDataForm) throws IOException {
        MakeUpSalonListResultsResponse[] externalModels = sendRequest(inputDataForm.getWeddingVenueCity());
        List<MakeUpSalonListInternalModel> internalModels = MakeUpSalonListExternalToInternalModelConverter.convertList(externalModels);
        return internalModels;
    }
}

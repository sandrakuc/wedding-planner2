package org.weddingplanner.searchservices.musicbandlist;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.makeupsalonlist.MakeUpSalonListUtils;
import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListExternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.external.MakeUpSalonListResultsResponse;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListExternalModel;
import org.weddingplanner.searchservices.musicbandlist.external.MusicBandListResultsResponse;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListExternalToInternalModelConverter;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MusicBandListApiHandler {
    public String getEndpoint(String provinceName) throws IOException {
        String endpoint = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=makijaż+" + provinceName + "&key=" + MusicBandListUtils.getApiKey();
        return endpoint;
    }

    private MusicBandListResultsResponse[] sendRequest(String provinceName) throws IOException {
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
        MusicBandListExternalModel response = objectMapper.readValue(content.toString(), MusicBandListExternalModel.class);
        connection.disconnect();
        return response.getResults();
    }

    public List<MusicBandListInternalModel> getMusicBandList(InputDataForm inputDataForm) throws IOException {
        MusicBandListResultsResponse[] externalModels = sendRequest(inputDataForm.getWeddingVenueProvince());
        List<MusicBandListInternalModel> internalModels = MusicBandListExternalToInternalModelConverter.convertList(externalModels);
        return internalModels;
    }
}

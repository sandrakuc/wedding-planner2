package org.weddingplanner.searchservices.weddingvenuegeolocation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.form.model.InputDataForm;
import org.weddingplanner.searchservices.weddingvenuegeolocation.external.WeddingVenueGeolocationExternalModel;
import org.weddingplanner.searchservices.weddingvenuegeolocation.external.WeddingVenueGeolocationPositionResponse;
import org.weddingplanner.searchservices.weddingvenuegeolocation.external.WeddingVenueGeolocationResponse;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationExternalToInternalModelConverter;
import org.weddingplanner.searchservices.weddingvenuegeolocation.internal.WeddingVenueGeolocationInternalModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeddingVenueGeolocationApiHandler {

    private String getEndpoint(InputDataForm form) throws IOException {
        String endpoint = "https://geocoder.ls.hereapi.com/6.2/geocode.json?apiKey=" + WeddingVenueGeolocationUtils.getApiKey() + "&searchtext=" + WeddingVenueGeolocationUtils.getFormattedAddressString(form);
        return endpoint;
    }

    private WeddingVenueGeolocationResponse sendRequest(InputDataForm form) throws IOException {
        URL url = new URL(getEndpoint(form));
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
        WeddingVenueGeolocationExternalModel response =objectMapper.readValue(content.toString(), WeddingVenueGeolocationExternalModel.class);
        connection.disconnect();
        return response.getResponse();
    }

    public WeddingVenueGeolocationInternalModel getWeddingVenueGeolocation(InputDataForm form) throws IOException {
        WeddingVenueGeolocationResponse geolocationResponse = sendRequest(form);
        WeddingVenueGeolocationInternalModel internalModel = WeddingVenueGeolocationExternalToInternalModelConverter.INSTANCE.convert(geolocationResponse);
        return internalModel;
    }
}

package org.weddingplanner.searchservices.weddingvenueweddinghalldistance;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external.WeddingVenueWeddingHallDistanceExternalModel;
import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external.WeddingVenueWeddingHallDistanceResponse;
import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.internal.WeddingVenueWeddingHallDistanceCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeddingVenueWeddingHallDistanceApiHandler {

    private String getEndpoint(String venueLatitude, String venueLongitude, String hallLatitude, String hallLongitude) throws IOException {
        String endpoint = "https://route.ls.hereapi.com/routing/7.2/calculateroute.json?apiKey=" + WeddingVenueWeddingHallDistanceUtils.getApiKey() + "&waypoint0=geo!" + venueLatitude + "," + venueLongitude + "&waypoint1=geo!" + hallLatitude + "," + hallLongitude + "&mode=fastest;car;traffic:disabled";
        return endpoint;
    }

    private WeddingVenueWeddingHallDistanceResponse sendRequest(String venueLatitude, String venueLongitude, String hallLatitude, String hallLongitude) throws IOException {
        URL url = new URL(getEndpoint(venueLatitude, venueLongitude, hallLatitude, hallLongitude));
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
        WeddingVenueWeddingHallDistanceExternalModel response = objectMapper.readValue(content.toString(), WeddingVenueWeddingHallDistanceExternalModel.class);
        connection.disconnect();
        return response.getResponse();
    }

    public double getDistance(String venueLatitude, String venueLongitude, String hallLatitude, String hallLongitude) throws IOException {
        WeddingVenueWeddingHallDistanceResponse externalModel = sendRequest(venueLatitude, venueLongitude, hallLatitude, hallLongitude);
        double distance = WeddingVenueWeddingHallDistanceCounter.countDistance(externalModel);
        return distance;
    }

}

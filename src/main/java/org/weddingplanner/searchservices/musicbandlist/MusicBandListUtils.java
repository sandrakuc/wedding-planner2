package org.weddingplanner.searchservices.musicbandlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MusicBandListUtils {

    private MusicBandListUtils() throws Exception {
        throw new Exception(String.format("Sorry, there is no %s instance for you!", this.getClass()));
    }

    public static String getApiKey() throws IOException {
        String fileName = "musicband-api-key.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String apiKey = reader.readLine();
        reader.close();
        return apiKey;
    }
}

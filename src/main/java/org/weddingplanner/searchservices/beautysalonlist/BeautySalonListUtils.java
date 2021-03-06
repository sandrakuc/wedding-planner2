package org.weddingplanner.searchservices.beautysalonlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BeautySalonListUtils {

    private BeautySalonListUtils() throws Exception {
        throw new Exception(String.format("Sorry, there is no %s instance for you!", this.getClass()));
    }

    public static String getApiKey() throws IOException {
        String fileName = "beautysalon-api-key.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String apiKey = reader.readLine();
        reader.close();
        return apiKey;
    }
}

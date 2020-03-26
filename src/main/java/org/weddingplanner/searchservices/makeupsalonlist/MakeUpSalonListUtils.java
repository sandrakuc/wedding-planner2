package org.weddingplanner.searchservices.makeupsalonlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MakeUpSalonListUtils {

    private MakeUpSalonListUtils() throws Exception {
        throw new Exception(String.format("Sorry, there is no %s instance for you!", this.getClass()));
    }

    public static String getApiKey() throws IOException {
        String fileName = "makeup-api-key.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String apiKey = reader.readLine();
        reader.close();
        return apiKey;
    }
}

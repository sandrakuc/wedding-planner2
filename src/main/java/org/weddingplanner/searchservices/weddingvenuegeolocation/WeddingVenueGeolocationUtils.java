package org.weddingplanner.searchservices.weddingvenuegeolocation;

import org.weddingplanner.form.model.InputDataForm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class WeddingVenueGeolocationUtils {

    private WeddingVenueGeolocationUtils() throws Exception {
        throw new Exception(String.format("Sorry, there is no %s instance for you!", this.getClass()));
    }

   public static String getFormattedAddressString(InputDataForm form){
        String formattedAddress = "";
        String[] streetName = form.getWeddingVenueStreet().split(" ");
        if(streetName[0].equals("Pl.")) streetName[0] = "Plac";
        else if(streetName[0].equals("Os.")) streetName[0] = "Osiedle";
        else if(streetName[0].equals("Al.")) streetName[0] = "Aleja";
        for(int i = 0; i < streetName.length; i++){
            formattedAddress += streetName[i] + "+";
        }
        formattedAddress += form.getWeddingVenuePossessionNumber() + "+";
        formattedAddress += form.getWeddingVenuePostalCode() + "+";
        formattedAddress += form.getWeddingVenueCity() + "+";
        formattedAddress += form.getWeddingVenueProvince();
        return formattedAddress;
   }

    public static String getApiKey() throws IOException {
        String fileName = "geolocation-api-key.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String apiKey = reader.readLine();
        reader.close();
        return apiKey;
    }
}

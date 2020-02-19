package org.weddingplanner.searchservices;

import org.junit.Assert;
import org.junit.Test;
import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.WeddingVenueWeddingHallDistanceApiHandler;

import java.io.IOException;

public class WeddingVenueWeddingHallDistanceTest {

    @Test
    public void getWeddingVenueWeddingHallDistance() throws IOException {
        String venueLatitude = "50.88857";
        String venueLongitude = "20.64262";
        String hallLatitude = "50.90305559999999";
        String hallLongitude = "20.7247222";

        WeddingVenueWeddingHallDistanceApiHandler apiHandler = new WeddingVenueWeddingHallDistanceApiHandler();
        double distance = apiHandler.getDistance(venueLatitude, venueLongitude, hallLatitude, hallLongitude);
        Assert.assertNotNull(distance);
        Assert.assertTrue(distance > 0);
    }
}

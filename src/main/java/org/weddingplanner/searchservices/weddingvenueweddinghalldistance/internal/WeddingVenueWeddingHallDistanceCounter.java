package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.internal;

import org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external.WeddingVenueWeddingHallDistanceResponse;

public class WeddingVenueWeddingHallDistanceCounter {

    public static double countDistance(WeddingVenueWeddingHallDistanceResponse externalModel){
        int distanceInMeters = externalModel.getRoute()[0].getSummary().getDistance();
        double distance = (double) distanceInMeters/1000;
        return distance;
    }
}

package org.weddingplanner.searchservices.weddinghalllist.internal;

import org.weddingplanner.searchservices.DistanceClassification;
import org.weddingplanner.searchservices.ServiceInternalModel;

public class WeddingHallListInternalModel extends ServiceInternalModel {

    private String latitude;

    private String longitude;

    private int maxGuestsQuantity;

    private double distanceFromWeddingVenue;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getMaxGuestsQuantity() {
        return maxGuestsQuantity;
    }

    public void setMaxGuestsQuantity(int maxGuestsQuantity) {
        this.maxGuestsQuantity = maxGuestsQuantity;
    }

    public double getDistanceFromWeddingVenue() {
        return distanceFromWeddingVenue;
    }

    public void setDistanceFromWeddingVenue(double distanceFromWeddingVenue) {
        this.distanceFromWeddingVenue = distanceFromWeddingVenue;
    }

    public DistanceClassification getDistanceClassification() {
        return distanceClassification;
    }

    public void setDistanceClassification(DistanceClassification distanceClassification) {
        this.distanceClassification = distanceClassification;
    }

    private DistanceClassification distanceClassification;

}

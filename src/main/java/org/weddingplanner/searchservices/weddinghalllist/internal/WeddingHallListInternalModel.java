package org.weddingplanner.searchservices.weddinghalllist.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHallListInternalModel {

    private String name;

    private String address;

    private double rating;

    private String latitude;

    private String longitude;

    private int price;

    private int maxGuestsQuantity;

    private double distanceFromWeddingVenue;

    private DistanceClassification distanceClassification;

    private PriceClassification priceClassification;

    private SatisfactionClassification satisfactionClassification;
}

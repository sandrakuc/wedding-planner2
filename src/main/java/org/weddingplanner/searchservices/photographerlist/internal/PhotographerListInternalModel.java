package org.weddingplanner.searchservices.photographerlist.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.weddingplanner.searchservices.weddinghalllist.internal.PriceClassification;
import org.weddingplanner.searchservices.weddinghalllist.internal.SatisfactionClassification;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotographerListInternalModel {
    private String name;

    private String address;

    private double rating;

    private int avgPrice;

    private PriceClassification priceClassification;

    private SatisfactionClassification satisfactionClassification;
}

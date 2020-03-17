package org.weddingplanner.searchservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInternalModel {

    public String name;

    public String address;

    public double rating;

    public int avgPrice;

    public PriceClassification priceClassification;

    public SatisfactionClassification satisfactionClassification;
}

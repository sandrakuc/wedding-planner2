package org.weddingplanner.searchservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInternalModel implements Comparable<ServiceInternalModel>{

    public String name;

    public String address;

    public double rating;

    public int avgPrice;

    public PriceClassification priceClassification;

    public SatisfactionClassification satisfactionClassification;

    public int points;

    public String website;

    public String image;

    public String phoneNumber;

    public String email;

    @Override
    public int compareTo(ServiceInternalModel o) {
        return Integer.compare(this.getPoints(), o.getPoints());
    }
}

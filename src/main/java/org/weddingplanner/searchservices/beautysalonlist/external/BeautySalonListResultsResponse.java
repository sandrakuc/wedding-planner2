package org.weddingplanner.searchservices.beautysalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeautySalonListResultsResponse {
    public String formatted_address;

    public BeautySalonListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public BeautySalonListPhotoResponse[] photos;

    public BeautySalonListPlusCodeResponse plus_code;

    public BeautySalonListOpeningHoursResponse opening_hours;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

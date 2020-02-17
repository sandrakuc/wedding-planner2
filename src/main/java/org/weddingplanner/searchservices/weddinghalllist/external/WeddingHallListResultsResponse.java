package org.weddingplanner.searchservices.weddinghalllist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHallListResultsResponse {

    public String formatted_address;

    public WeddingHallListGeometryResponseList geometry;

    public String icon;

    public String id;

    public String name;

    public WeddingHallListPhotoResponse[] photos;

    public WeddingHallListPlusCodeResponse plus_code;

    public WeddingHallListOpeningHoursResponse opening_hours;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

package org.weddingplanner.searchservices.hairdresserlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HairDresserListResultsResponse {
    public String formatted_address;

    public HairDresserListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public HairDresserListPhotoResponse[] photos;

    public HairDresserListPlusCodeResponse plus_code;

    public HairDresserListOpeningHoursResponse opening_hours;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

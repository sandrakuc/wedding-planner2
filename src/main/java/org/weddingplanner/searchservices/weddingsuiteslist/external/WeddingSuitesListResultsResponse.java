package org.weddingplanner.searchservices.weddingsuiteslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingSuitesListResultsResponse {
    public String formatted_address;

    public WeddingSuitesListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public WeddingSuitesListPhotoResponse[] photos;

    public WeddingSuitesListPlusCodeResponse plus_code;

    public WeddingSuitesListOpeningHoursResponse opening_hours;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;

    public int price_level;
}

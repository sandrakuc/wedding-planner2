package org.weddingplanner.searchservices.carrentinglist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRentingListResultsResponse {
    public String formatted_address;

    public CarRentingListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public CarRentingListPhotoResponse[] photos;

    public CarRentingListPlusCodeResponse plus_code;

    public CarRentingListOpeningHoursResponse opening_hours;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

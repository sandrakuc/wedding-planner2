package org.weddingplanner.searchservices.floristicservices.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloristicServicesListResultsResponse {
    public String formatted_address;

    public FloristicServicesListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public FloristicServicesListPhotoResponse[] photos;

    public FloristicServicesListPlusCodeResponse plus_code;

    public FloristicServicesListOpeningHoursResponse opening_hours;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

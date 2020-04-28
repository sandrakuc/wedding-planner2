package org.weddingplanner.searchservices.photographerlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotographerListResultsResponse {
    public String formatted_address;

    public PhotographerListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public PhotographerListPhotoResponse[] photos;

    public PhotographerListPlusCodeResponse plus_code;

    public PhotographerListOpeningHoursResponse opening_hours;

    public String business_status;

    public boolean permanently_closed;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

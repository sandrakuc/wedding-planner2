package org.weddingplanner.searchservices.makeupsalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeUpSalonListResultsResponse {
    public String formatted_address;

    public MakeUpSalonListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public MakeUpSalonListPhotoResponse[] photos;

    public MakeUpSalonListPlusCodeResponse plus_code;

    public MakeUpSalonListOpeningHoursResponse opening_hours;

    public String business_status;

    public boolean permanently_closed;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

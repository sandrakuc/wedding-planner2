package org.weddingplanner.searchservices.weddingdressstoreslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingDressStoreListResultsResponse {
    public String formatted_address;

    public WeddingDressStoreListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public WeddingDressStoreListPhotoResponse[] photos;

    public WeddingDressStoreListPlusCodeResponse plus_code;

    public WeddingDressStoreListOpeningHoursResponse opening_hours;

    public String business_status;

    public boolean permanently_closed;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

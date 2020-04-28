package org.weddingplanner.searchservices.musicbandlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicBandListResultsResponse {
    public String formatted_address;

    public MusicBandListGeometryResponse geometry;

    public String icon;

    public String id;

    public String name;

    public MusicBandListPhotoResponse[] photos;

    public MusicBandListPlusCodeResponse plus_code;

    public MusicBandListOpeningHoursResponse opening_hours;

    public String business_status;

    public boolean permanently_closed;

    public String place_id;

    public double rating;

    public String reference;

    public String[] types;

    public int user_ratings_total;
}

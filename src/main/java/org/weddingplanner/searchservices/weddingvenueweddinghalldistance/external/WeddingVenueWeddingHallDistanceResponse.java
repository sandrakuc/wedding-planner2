package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceResponse {
    public WeddingVenueWeddingHallDistanceMetaInfoResponse metaInfo;

    public WeddingVenueWeddingHallDistanceRouteResponse[] route;

    public String language;
}

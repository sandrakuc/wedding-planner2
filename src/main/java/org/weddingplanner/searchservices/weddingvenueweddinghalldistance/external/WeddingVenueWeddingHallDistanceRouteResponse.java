package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceRouteResponse {
    public WeddingVenueWeddingHallDistanceWaypointResponse[] waypoint;

    public WeddingVenueWeddingHallDistanceModeResponse mode;

    public WeddingVenueWeddingHallDistanceLegResponse[] leg;

    public WeddingVenueWeddingHallDistanceSummaryResponse summary;
}

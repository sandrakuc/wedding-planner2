package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceLegResponse {
    public WeddingVenueWeddingHallDistanceWaypointResponse start;

    public WeddingVenueWeddingHallDistanceWaypointResponse end;

    public int length;

    public int travelTime;

    public WeddingVenueWeddingHallDistanceManouverResponse[] maneuver;
}

package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceWaypointResponse {
    public String linkId;

    public WeddingVenueWeddingHallDistancePositionResponse mappedPosition;

    public WeddingVenueWeddingHallDistancePositionResponse originalPosition;

    public String type;

    public double spot;

    public String sideOfStreet;

    public String mappedRoadName;

    public String label;

    public int shapeIndex;

    public String source;
}

package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistancePositionResponse {
    public double latitude;

    public double longitude;
}

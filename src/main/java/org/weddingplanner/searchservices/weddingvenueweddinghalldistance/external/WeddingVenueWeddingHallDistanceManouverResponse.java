package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceManouverResponse {
    public WeddingVenueWeddingHallDistancePositionResponse position;

    public String instruction;

    public int travelTime;

    public int length;

    public String id;

    public String _type;
}

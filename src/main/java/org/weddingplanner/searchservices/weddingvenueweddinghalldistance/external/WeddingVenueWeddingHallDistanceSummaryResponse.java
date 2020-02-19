package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceSummaryResponse {
    public int distance;

    public int trafficTime;

    public int baseTime;

    public String[] flags;

    public String text;

    public int travelTime;

    public String _type;
}

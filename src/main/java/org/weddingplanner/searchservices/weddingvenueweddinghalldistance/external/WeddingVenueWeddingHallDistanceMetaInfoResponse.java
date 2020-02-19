package org.weddingplanner.searchservices.weddingvenueweddinghalldistance.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueWeddingHallDistanceMetaInfoResponse {
    public String timestamp;

    public String mapVersion;

    public String moduleVersion;

    public String interfaceVersion;

    public String[] availableMapVersion;
}

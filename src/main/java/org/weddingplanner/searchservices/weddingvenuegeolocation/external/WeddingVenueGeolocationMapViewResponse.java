package org.weddingplanner.searchservices.weddingvenuegeolocation.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationMapViewResponse {
    public WeddingVenueGeolocationPositionResponse TopLeft;

    public WeddingVenueGeolocationPositionResponse BottomRight;
}

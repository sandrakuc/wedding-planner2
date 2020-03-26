package org.weddingplanner.searchservices.weddingvenuegeolocation.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationLocationResponse {
    public String LocationId;

    public String LocationType;

    public WeddingVenueGeolocationPositionResponse DisplayPosition;

    public WeddingVenueGeolocationPositionResponse[] NavigationPosition;

    public WeddingVenueGeolocationMapViewResponse MapView;

    public WeddingVenueGeolocationAddressResponse Address;
}

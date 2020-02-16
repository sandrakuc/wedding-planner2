package org.weddingplanner.searchservices.weddingvenuegeolocation.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationResponse {
    public WeddingVenueGeolocationMetaInfoResponse MetaInfo;
    public WeddingVenueGeolocationViewResponse[] View;
}

package org.weddingplanner.searchservices.weddingvenuegeolocation.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationMatchQualityResponse {
    public double City;

    public double Street[];

    public double HouseNumber;

    public double State;

    public double PostalCode;
}

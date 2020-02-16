package org.weddingplanner.searchservices.weddingvenuegeolocation.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationAddressResponse {
    public String Label;
    public String Country;
    public String State;
    public String County;
    public String City;
    public String District;
    public String Street;
    public String PostalCode;
    public String HouseNumber;
    public WeddingVenueGeolocationAdditionalDataResponse[] AdditionalData;
}

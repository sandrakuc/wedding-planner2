package org.weddingplanner.searchservices.weddingvenuegeolocation.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationViewResponse {
    public String _type;

    public int ViewId;

    public WeddingVenueGeolocationResultResponse[] Result;
}
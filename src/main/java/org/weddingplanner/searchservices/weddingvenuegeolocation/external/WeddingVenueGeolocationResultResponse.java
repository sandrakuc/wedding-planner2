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
public class WeddingVenueGeolocationResultResponse {
    public double Relevance;

    public String MatchLevel;

    public WeddingVenueGeolocationMatchQualityResponse MatchQuality;

    public String MatchType;

    public WeddingVenueGeolocationLocationResponse Location;
}

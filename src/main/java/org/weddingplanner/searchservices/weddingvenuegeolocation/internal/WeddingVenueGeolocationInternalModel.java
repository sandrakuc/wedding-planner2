package org.weddingplanner.searchservices.weddingvenuegeolocation.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingVenueGeolocationInternalModel {

    private String latitude;

    private String longitude;
}

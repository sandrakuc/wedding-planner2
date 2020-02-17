package org.weddingplanner.searchservices.weddinghalllist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHallListLocationResponse {
    public double lat;

    public double lng;
}

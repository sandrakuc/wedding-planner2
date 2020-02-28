package org.weddingplanner.searchservices.beautysalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeautySalonListLocationResponse {
    public double lat;

    public double lng;
}

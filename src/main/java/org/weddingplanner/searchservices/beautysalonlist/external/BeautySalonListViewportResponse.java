package org.weddingplanner.searchservices.beautysalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeautySalonListViewportResponse {
    public BeautySalonListLocationResponse northeast;

    public BeautySalonListLocationResponse southwest;
}

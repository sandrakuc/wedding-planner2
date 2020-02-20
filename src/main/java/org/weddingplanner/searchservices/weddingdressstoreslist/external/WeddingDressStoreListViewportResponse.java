package org.weddingplanner.searchservices.weddingdressstoreslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.weddingplanner.searchservices.weddinghalllist.external.WeddingHallListLocationResponse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingDressStoreListViewportResponse {
    public WeddingDressStoreListLocationResponse northeast;

    public WeddingDressStoreListLocationResponse southwest;
}

package org.weddingplanner.searchservices.weddingdressstoreslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingDressStoreListGeometryResponse {
    public WeddingDressStoreListLocationResponse location;

    public WeddingDressStoreListViewportResponse viewport;
}

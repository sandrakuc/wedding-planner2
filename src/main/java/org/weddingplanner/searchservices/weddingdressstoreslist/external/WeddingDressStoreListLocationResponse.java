package org.weddingplanner.searchservices.weddingdressstoreslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingDressStoreListLocationResponse {
    public double lat;

    public double lng;
}

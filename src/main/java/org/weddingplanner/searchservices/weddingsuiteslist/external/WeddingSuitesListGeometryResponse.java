package org.weddingplanner.searchservices.weddingsuiteslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingSuitesListGeometryResponse {
    public WeddingSuitesListLocationResponse location;

    public WeddingSuitesListViewportResponse viewport;
}

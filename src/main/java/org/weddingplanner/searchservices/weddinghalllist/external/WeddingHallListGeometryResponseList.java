package org.weddingplanner.searchservices.weddinghalllist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHallListGeometryResponseList {
    public WeddingHallListLocationResponse location;

    public WeddingHallListViewportResponse viewport;
}

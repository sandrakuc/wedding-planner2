package org.weddingplanner.searchservices.hairdresserlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HairDresserListGeometryResponse {
    public HairDresserListLocationResponse location;

    public HairDresserListViewportResponse viewport;
}

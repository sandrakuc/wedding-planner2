package org.weddingplanner.searchservices.makeupsalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeUpSalonListGeometryResponse {
    public MakeUpSalonListLocationResponse location;

    public MakeUpSalonListViewportResponse viewport;
}

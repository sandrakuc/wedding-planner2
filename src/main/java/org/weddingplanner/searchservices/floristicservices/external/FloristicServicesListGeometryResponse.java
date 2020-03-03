package org.weddingplanner.searchservices.floristicservices.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloristicServicesListGeometryResponse {
    public FloristicServicesListLocationResponse location;

    public FloristicServicesListViewportResponse viewport;
}

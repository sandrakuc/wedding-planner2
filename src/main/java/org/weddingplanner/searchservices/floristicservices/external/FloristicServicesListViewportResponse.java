package org.weddingplanner.searchservices.floristicservices.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloristicServicesListViewportResponse {
    public FloristicServicesListLocationResponse northeast;
    public FloristicServicesListLocationResponse southwest;
}

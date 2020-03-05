package org.weddingplanner.searchservices.carrentinglist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRentingListViewportResponse {
    public CarRentingListLocationResponse northeast;

    public CarRentingListLocationResponse southwest;
}

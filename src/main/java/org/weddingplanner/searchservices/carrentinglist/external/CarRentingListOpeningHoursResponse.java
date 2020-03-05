package org.weddingplanner.searchservices.carrentinglist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRentingListOpeningHoursResponse {
    public boolean open_now;
}

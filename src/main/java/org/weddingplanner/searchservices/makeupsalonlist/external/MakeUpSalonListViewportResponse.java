package org.weddingplanner.searchservices.makeupsalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeUpSalonListViewportResponse {
    public MakeUpSalonListLocationResponse northeast;

    public MakeUpSalonListLocationResponse southwest;
}

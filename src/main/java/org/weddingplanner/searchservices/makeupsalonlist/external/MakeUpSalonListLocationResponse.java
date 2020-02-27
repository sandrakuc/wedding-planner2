package org.weddingplanner.searchservices.makeupsalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeUpSalonListLocationResponse {
    public double lat;

    public double lng;
}

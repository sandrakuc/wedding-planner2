package org.weddingplanner.searchservices.floristicservices.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloristicServicesListPlusCodeResponse {
    public String compound_code;

    public String global_code;
}

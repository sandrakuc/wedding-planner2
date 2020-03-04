package org.weddingplanner.searchservices.photographerlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotographerListPlusCodeResponse {
    public String compound_code;

    public String global_code;
}

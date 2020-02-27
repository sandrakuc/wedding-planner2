package org.weddingplanner.searchservices.makeupsalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeUpSalonListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public MakeUpSalonListResultsResponse[] results;

    public String status;
}

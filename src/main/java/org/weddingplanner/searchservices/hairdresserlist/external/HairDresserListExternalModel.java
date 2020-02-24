package org.weddingplanner.searchservices.hairdresserlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HairDresserListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public HairDresserListResultsResponse[] results;

    public String status;
}

package org.weddingplanner.searchservices.beautysalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeautySalonListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public BeautySalonListResultsResponse[] results;

    public String status;
}

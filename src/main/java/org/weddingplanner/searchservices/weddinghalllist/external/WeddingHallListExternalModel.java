package org.weddingplanner.searchservices.weddinghalllist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingHallListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public WeddingHallListResultsResponse[] results;

    public String status;
}

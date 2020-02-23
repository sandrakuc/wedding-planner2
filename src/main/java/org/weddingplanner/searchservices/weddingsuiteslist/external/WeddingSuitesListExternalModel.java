package org.weddingplanner.searchservices.weddingsuiteslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingSuitesListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public WeddingSuitesListResultsResponse[] results;

    public String status;
}

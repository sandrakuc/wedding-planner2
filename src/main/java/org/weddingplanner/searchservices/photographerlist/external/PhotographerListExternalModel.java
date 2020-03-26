package org.weddingplanner.searchservices.photographerlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotographerListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public PhotographerListResultsResponse[] results;

    public String status;
}

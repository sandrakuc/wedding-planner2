package org.weddingplanner.searchservices.weddingdressstoreslist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingDressStoreListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public WeddingDressStoreListResultsResponse[] results;

    public String status;
}

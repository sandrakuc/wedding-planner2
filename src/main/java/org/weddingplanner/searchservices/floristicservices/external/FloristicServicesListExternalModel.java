package org.weddingplanner.searchservices.floristicservices.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FloristicServicesListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public FloristicServicesListResultsResponse[] results;

    public String status;
}

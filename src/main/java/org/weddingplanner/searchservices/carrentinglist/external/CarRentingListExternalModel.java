package org.weddingplanner.searchservices.carrentinglist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarRentingListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public CarRentingListResultsResponse[] results;

    public String status;
}

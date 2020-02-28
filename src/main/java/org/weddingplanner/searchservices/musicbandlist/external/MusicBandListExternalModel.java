package org.weddingplanner.searchservices.musicbandlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicBandListExternalModel {
    public String[] html_attributions;

    public String next_page_token;

    public MusicBandListResultsResponse[] results;

    public String status;
}

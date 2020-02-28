package org.weddingplanner.searchservices.musicbandlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicBandListPlusCodeResponse {
    public String compound_code;

    public String global_code;
}

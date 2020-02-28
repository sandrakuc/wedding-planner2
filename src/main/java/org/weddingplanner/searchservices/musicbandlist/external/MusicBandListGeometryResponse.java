package org.weddingplanner.searchservices.musicbandlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicBandListGeometryResponse {
    public MusicBandListLocationResponse location;

    public MusicBandListViewportResponse viewport;
}

package org.weddingplanner.searchservices.beautysalonlist.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeautySalonListPhotoResponse {
    public int height;

    public String[] html_attributions;

    public String photo_reference;

    public int width;
}

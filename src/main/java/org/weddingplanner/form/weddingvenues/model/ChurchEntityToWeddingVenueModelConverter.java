package org.weddingplanner.form.weddingvenues.model;

import org.weddingplanner.form.weddingvenues.Church;

import java.util.ArrayList;
import java.util.List;

public class ChurchEntityToWeddingVenueModelConverter {

    public WeddingVenueModel convert(Church church){
        WeddingVenueModel weddingVenueModel = new WeddingVenueModel()
                .builder()
                .name(church.getName())
                .street(church.getStreet())
                .possessionNumber(church.getPossessionNumber())
                .postalCode(church.getPostalCode())
                .city(church.getCity())
                .build();
        return weddingVenueModel;
    }

    public List<WeddingVenueModel> convertList(List<Church> churches){
        List<WeddingVenueModel> weddingVenueModels = new ArrayList<>();
        for(Church church : churches){
            weddingVenueModels.add(convert(church));
        }
        return weddingVenueModels;
    }
}

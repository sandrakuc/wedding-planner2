package org.weddingplanner.form.weddingvenues.model;

import org.weddingplanner.form.weddingvenues.RegistryOffice;

import java.util.ArrayList;
import java.util.List;

public class RegistryOfficeEntityToWeddingVenueModelConverter {

    public WeddingVenueModel convert(RegistryOffice registryOffice){
        WeddingVenueModel weddingVenueModel = new WeddingVenueModel()
                .builder()
                .name(registryOffice.getName())
                .street(registryOffice.getStreet())
                .possessionNumber(registryOffice.getPossessionNumber())
                .postalCode(registryOffice.getPostalCode())
                .city(registryOffice.getCity())
                .build();
        return weddingVenueModel;
    }

    public List<WeddingVenueModel> convert(List<RegistryOffice> registryOffices){
        List<WeddingVenueModel> weddingVenueModels = new ArrayList<>();
        for(RegistryOffice registryOffice : registryOffices){
            weddingVenueModels.add(convert(registryOffice));
        }
        return weddingVenueModels;
    }
}

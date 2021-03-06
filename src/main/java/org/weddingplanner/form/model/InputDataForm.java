package org.weddingplanner.form.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputDataForm {

    private int guestQuantity;

    private long budget;

    private long budgetMargin;

    private String weddingVenueName;

    private String weddingVenueStreet;

    private String weddingVenuePossessionNumber;

    private String weddingVenuePostalCode;

    private String weddingVenueCity;

    private String weddingVenueProvince;

    private String brideLivingCity;

    private String brideLivingProvince;

    private String groomLivingCity;

    private String groomLivingProvince;

    private Boolean needCarRenting;

    private WeddingHallCriteria weddingHallCriteria;

    private WeddingOutfitCriteria weddingOutfitCriteria;

    private BeautyServicesCriteria beautyServicesCriteria;

    private MusicBandCriteria musicBandCriteria;

    private FloristicServicesCriteria floristicServicesCriteria;

    private PhotographicAndFilmServicesCriteria photographicAndFilmServicesCriteria;

    private CarRentingServicesCriteria carRentingServicesCriteria;

}

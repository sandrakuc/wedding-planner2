package org.weddingplanner.form.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputDataForm {

    private Date weddingDate;

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

    private Boolean needChildrenPlayAnimator;

    private Boolean needCarRenting;

    private WeddingHallCriteria weddingHallCriteria;

    private WeddingOutfitCriteria weddingOutfitCriteria;

    private BeautyServicesCriteria beautyServicesCriteria;

    private MusicBandCriteria musicBandCriteria;

    private FloristicServicesCriteria floristicServicesCriteria;

    private PhotographicAndFilmServicesCriteria photographicAndFilmServicesCriteria;

    private CarRentingServicesCriteria carRentingServicesCriteria;

    private ChildrenPlayServicesCriteria childrenPlayServicesCriteria;
}

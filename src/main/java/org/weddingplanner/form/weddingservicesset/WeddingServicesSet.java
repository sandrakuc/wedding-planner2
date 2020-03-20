package org.weddingplanner.form.weddingservicesset;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.floristicservices.internal.FloristicServicesListInternalModel;
import org.weddingplanner.searchservices.hairdresserlist.internal.HairDresserListInternalModel;
import org.weddingplanner.searchservices.makeupsalonlist.internal.MakeUpSalonListInternalModel;
import org.weddingplanner.searchservices.musicbandlist.internal.MusicBandListInternalModel;
import org.weddingplanner.searchservices.photographerlist.internal.PhotographerListInternalModel;
import org.weddingplanner.searchservices.weddingdressstoreslist.internal.WeddingDressStoreListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;
import org.weddingplanner.searchservices.weddingsuiteslist.internal.WeddingSuitesListInternalModel;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingServicesSet {

    private BeautySalonListInternalModel beautySalon;

    private CarRentingListInternalModel carRenting;

    private FloristicServicesListInternalModel floristicService;

    private HairDresserListInternalModel hairDresser;

    private MakeUpSalonListInternalModel makeUpSalon;

    private MusicBandListInternalModel musicBand;

    private PhotographerListInternalModel photographer;

    private WeddingDressStoreListInternalModel dressStore;

    private WeddingSuitesListInternalModel suiteStore;

    private WeddingHallListInternalModel hall;

    private int totalPoints;

    public int getTotalAmount(){
        return beautySalon.getAvgPrice()
                + carRenting.getAvgPrice()
                + floristicService.getAvgPrice()
                + hairDresser.getAvgPrice()
                + makeUpSalon.getAvgPrice()
                + photographer.getAvgPrice()
                + dressStore.getAvgPrice()
                + suiteStore.getAvgPrice()
                + hall.getAvgPrice();
    }
}

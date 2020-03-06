package org.weddingplanner.form.weddingservicesfilter;

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

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeddingServicesWrapper {

    private List<BeautySalonListInternalModel> beautySalons;

    private List<CarRentingListInternalModel> carRentings;

    private List<FloristicServicesListInternalModel> floristicServices;

    private List<HairDresserListInternalModel> hairDressers;

    private List<MakeUpSalonListInternalModel> makeUpSalons;

    private List<MusicBandListInternalModel> musicBands;

    private List<PhotographerListInternalModel> photographers;

    private List<WeddingDressStoreListInternalModel> weddingDressStores;

    private List<WeddingSuitesListInternalModel> weddingSuitesStores;

    private List<WeddingHallListInternalModel> weddingHalls;
}

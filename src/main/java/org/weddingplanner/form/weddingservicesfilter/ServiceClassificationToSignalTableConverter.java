package org.weddingplanner.form.weddingservicesfilter;

import org.weddingplanner.searchservices.DistanceClassification;
import org.weddingplanner.searchservices.PriceClassification;
import org.weddingplanner.searchservices.SatisfactionClassification;
import org.weddingplanner.searchservices.ServiceInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

public class ServiceClassificationToSignalTableConverter {

    public static int[] convert(WeddingHallListInternalModel model){
        int priceSignal = PriceClassification.CHEAP.equals(model.getPriceClassification()) ? 1 : -1,
                satisfactionSignal = SatisfactionClassification.GOOD.equals(model.getSatisfactionClassification()) ? 1 : -1,
                distanceSignal = DistanceClassification.NEAR.equals(model.getDistanceClassification()) ? 1 : -1;
        int[] signalTable = {priceSignal, satisfactionSignal, distanceSignal};
        return signalTable;
    }

    public static int[] convert(ServiceInternalModel model){
        int priceSignal = PriceClassification.CHEAP.equals(model.getPriceClassification()) ? 1 : -1,
                satisfactionSignal = SatisfactionClassification.GOOD.equals(model.getSatisfactionClassification()) ? 1 : -1;
        int[] signalTable = {priceSignal, satisfactionSignal};
        return signalTable;
    }
}

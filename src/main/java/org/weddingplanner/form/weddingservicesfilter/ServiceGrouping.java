package org.weddingplanner.form.weddingservicesfilter;

import org.weddingplanner.searchservices.ServiceInternalModel;
import org.weddingplanner.searchservices.beautysalonlist.internal.BeautySalonListInternalModel;
import org.weddingplanner.searchservices.carrentinglist.internal.CarRentingListInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceGrouping <T extends ServiceInternalModel>{

    private static final int[][] hallsWeightMatrix = {{0,1,1}, {1,0,1}, {1,1,0}};
    private static final int[][] otherWeightMatrix = {{0,1}, {0,1}};
    private static final int[] hallsAttractor = {1,1,1};
    private static final int[] otherAttractor = {1,1};
    private static final int[] hallsAntiAttractor = {-1,-1,-1};
    private static final int[] otherAntiAttractor = {-1,-1};

    private static boolean compareTables(int[] first, int[] second){
        if(first.length != second.length){
            return false;
        }
        for(int i = 0; i < first.length; i++){
            if(first[i] != second[i]){
                return false;
            }
        }
        return true;
    }

    public List<T> groupServices(List<T> serviceModels){
        List<T> attractiveServices = new ArrayList<>();
        for(T model : serviceModels){
            int[] signals = ServiceClassificationToSignalTableConverter.convert(model);
            int[] similarity = SignalTableGetter.getSimilaritySignal(signals, otherWeightMatrix);
            if(compareTables(similarity, otherAttractor)){
                attractiveServices.add(model);
            }
        }
        return attractiveServices;
    }

    public List<WeddingHallListInternalModel> groupWeddingHalls(List<WeddingHallListInternalModel> halls){
        List<WeddingHallListInternalModel> attractiveHalls = new ArrayList<>();
        for(WeddingHallListInternalModel hall : halls){
            int[] signals = ServiceClassificationToSignalTableConverter.convert(hall);
            int[] similarity = SignalTableGetter.getSimilaritySignal(signals, hallsWeightMatrix);
            if (compareTables(similarity, hallsAttractor)){
                attractiveHalls.add(hall);
            }
        }
        return attractiveHalls;
    }
}

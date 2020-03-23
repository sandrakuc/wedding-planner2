package org.weddingplanner.form.weddingservicesset;

import org.weddingplanner.searchservices.PriceClassification;
import org.weddingplanner.searchservices.ServiceInternalModel;

import java.util.List;

public class CheaperFromListGetter <T extends ServiceInternalModel> {

    public T findCheapModel(List<T> models){
        for(T model : models){
            if(model.getPriceClassification().equals(PriceClassification.CHEAP)){
                return model;
            }
        }
        return null;
    }
}

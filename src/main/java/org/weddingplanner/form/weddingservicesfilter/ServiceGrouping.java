package org.weddingplanner.form.weddingservicesfilter;

import org.weddingplanner.searchservices.DistanceClassification;
import org.weddingplanner.searchservices.PriceClassification;
import org.weddingplanner.searchservices.SatisfactionClassification;
import org.weddingplanner.searchservices.ServiceInternalModel;
import org.weddingplanner.searchservices.weddinghalllist.internal.WeddingHallListInternalModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceGrouping <T extends ServiceInternalModel>{

    private static final int[][] hallsWeightMatrix = {{0,1,1}, {1,0,1}, {1,1,0}};
    private static final int[][] otherWeightMatrix = {{0,1}, {0,1}};
    private static final int[] hallsAttractor = {1,1,1};
    private static final int[] otherAttractor = {1,1};

    private List<T> sortByPrice(List<T> serviceInternalModels){
        List<T> newServiceInternalModels = serviceInternalModels.stream().collect(Collectors.toList());;
        Comparator<T> comparatorByPrice = Comparator.comparingInt(ServiceInternalModel::getAvgPrice);
        Collections.sort(newServiceInternalModels, comparatorByPrice);
        Collections.reverse(newServiceInternalModels);
        return newServiceInternalModels;
    }

    private List<T> sortBySatisfaction(List<T> serviceInternalModels){
        List<T> newServiceInternalModels = serviceInternalModels.stream().collect(Collectors.toList());
        Comparator<T> comparatorBySatisfaction = Comparator.comparingDouble(ServiceInternalModel::getRating);
        Collections.sort(newServiceInternalModels, comparatorBySatisfaction);
        return newServiceInternalModels;
    }

    private List<WeddingHallListInternalModel> sortByPriceHalls(List<WeddingHallListInternalModel> serviceInternalModels){
        List<WeddingHallListInternalModel> newServiceInternalModel = serviceInternalModels.stream().collect(Collectors.toList());
        Comparator<WeddingHallListInternalModel> comparatorByPrice = Comparator.comparingInt(ServiceInternalModel::getAvgPrice);
        Collections.sort(newServiceInternalModel, comparatorByPrice);
        Collections.reverse(newServiceInternalModel);
        return newServiceInternalModel;
    }

    private List<WeddingHallListInternalModel> sortBySatisfactionHalls(List<WeddingHallListInternalModel> serviceInternalModels){
        List<WeddingHallListInternalModel> newServiceInternalModel = serviceInternalModels.stream().collect(Collectors.toList());
        Comparator<WeddingHallListInternalModel> comparatorBySatisfaction = Comparator.comparingDouble(ServiceInternalModel::getRating);
        Collections.sort(newServiceInternalModel, comparatorBySatisfaction);
        return newServiceInternalModel;
    }

    private List<WeddingHallListInternalModel> sortByDistance(List<WeddingHallListInternalModel> halls){
        List<WeddingHallListInternalModel> newServiceInternalModel = halls.stream().collect(Collectors.toList());
        Comparator<WeddingHallListInternalModel> comparatorByDistance = Comparator.comparingDouble(WeddingHallListInternalModel::getDistanceFromWeddingVenue);
        Collections.sort(newServiceInternalModel, comparatorByDistance);
        Collections.reverse(newServiceInternalModel);
        return newServiceInternalModel;
    }

    private int getPricePoints(List<T> serviceInternalModels, T model, int priceCriteria){
        int position = serviceInternalModels.indexOf(model);
        int pricePoints = position * priceCriteria;
        if(model.getPriceClassification().equals(PriceClassification.CHEAP)){
            pricePoints += 10;
        }
        return pricePoints;
    }

    private int getSatisfactionPoints(List<T> serviceInternalModels, T model, int satisfactionCriteria){
        int position = serviceInternalModels.indexOf(model);
        int satisfactionPoints = position * satisfactionCriteria;
        if(model.getSatisfactionClassification().equals(SatisfactionClassification.GOOD)){
            satisfactionPoints += 10;
        }
        return satisfactionPoints;
    }

    private int getPricePoints(List<WeddingHallListInternalModel> serviceInternalModels, WeddingHallListInternalModel model, int priceCriteria){
        int position = serviceInternalModels.indexOf(model);
        int pricePoints = position * priceCriteria;
        if(model.getPriceClassification().equals(PriceClassification.CHEAP)){
            pricePoints += 10;
        }
        return pricePoints;
    }

    private int getSatisfactionPoints(List<WeddingHallListInternalModel> serviceInternalModels, WeddingHallListInternalModel model, int satisfactionCriteria){
        int position = serviceInternalModels.indexOf(model);
        int satisfactionPoints = position * satisfactionCriteria;
        if(model.getSatisfactionClassification().equals(SatisfactionClassification.GOOD)){
            satisfactionPoints += 10;
        }
        return satisfactionPoints;
    }

    private int getDistancePoints(List<WeddingHallListInternalModel> halls, WeddingHallListInternalModel hall, int distanceCriteria){
        int position = halls.indexOf(hall);
        int distancePoints = position * distanceCriteria;
        if(hall.getDistanceClassification().equals(DistanceClassification.NEAR)){
            distancePoints += 10;
        }
        return distancePoints;
    }

    private boolean compareTables(int[] first, int[] second){
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

    public List<T> groupServices(List<T> serviceModels, int priceCriteria, int satisfactionCriteria){
        List<T> attractiveServices = new ArrayList<>();
        List<T> sortedByPrice = sortByPrice(serviceModels);
        List<T> sortedBySatisfaction = sortBySatisfaction(serviceModels);
        for(T model : serviceModels){
            int[] signals = ServiceClassificationToSignalTableConverter.convert(model);
            int[] similarity = SignalTableGetter.getSimilaritySignal(signals, otherWeightMatrix);
            if(compareTables(similarity, otherAttractor)){
                model.setPoints(getPricePoints(sortedByPrice, model, priceCriteria)
                        + getSatisfactionPoints(sortedBySatisfaction, model, satisfactionCriteria));
                attractiveServices.add(model);
            }
        }
        Collections.sort(attractiveServices);
        Collections.reverse(attractiveServices);
        return attractiveServices;
    }

    public List<WeddingHallListInternalModel> groupWeddingHalls(List<WeddingHallListInternalModel> halls, int priceCriteria, int satisfactionCriteria, int distanceCriteria){
        List<WeddingHallListInternalModel> attractiveHalls = new ArrayList<>();
        List<WeddingHallListInternalModel> sortedByPrice = sortByPriceHalls(halls);
        List<WeddingHallListInternalModel> sortedBySatisfaction = sortBySatisfactionHalls(halls);
        List<WeddingHallListInternalModel> sortedByDistance = sortByDistance(halls);
        for(WeddingHallListInternalModel hall : halls){
            int[] signals = ServiceClassificationToSignalTableConverter.convert(hall);
            int[] similarity = SignalTableGetter.getSimilaritySignal(signals, hallsWeightMatrix);
            if (compareTables(similarity, hallsAttractor)){
                hall.setPoints(getPricePoints(sortedByPrice, hall, priceCriteria)
                    + getSatisfactionPoints(sortedBySatisfaction, hall, satisfactionCriteria)
                    + getDistancePoints(sortedByDistance, hall, distanceCriteria));
                attractiveHalls.add(hall);
            }
        }
        Collections.sort(attractiveHalls);
        Collections.reverse(attractiveHalls);
        return attractiveHalls;
    }
}

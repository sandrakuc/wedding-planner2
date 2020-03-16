package org.weddingplanner.form.weddingservicesfilter;

public class SignalTableGetter {

    private static int getSignal(int tableIndex, int[] tableOfSignals, int[][] weightMatrix){
        int signal = 0;
        for(int i = 0; i < tableOfSignals.length; i++){
            signal += tableOfSignals[i] * weightMatrix[tableIndex][i];
        }
        if (signal < 0) return -1;
        else if(signal > 0) return 1;
        else return tableOfSignals[tableIndex];
    }

    public static int[] getSimilaritySignal(int[] tableOfSignals, int[][] weightMatrix){
        int[] similaritySignals = new int[tableOfSignals.length];
        for(int i = 0; i< tableOfSignals.length; i++){
            similaritySignals[i] = getSignal(i,tableOfSignals, weightMatrix);
        }
        return similaritySignals;
    }
}

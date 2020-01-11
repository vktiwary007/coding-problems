package com.vivekasu;

public class MostProfitAssignWork {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = worker.length;

        int maxDifficulty = 0;

        for(int i=0;i<difficulty.length;i++){
            if(difficulty[i]>maxDifficulty)
                maxDifficulty = difficulty[i];
        }

        for(int i=0;i<worker.length;i++){
            if(worker[i]>maxDifficulty)
                maxDifficulty = worker[i];
        }

        int[] maxprofit = new int[maxDifficulty+2];

        for(int i=0;i<difficulty.length;i++){

            maxprofit[difficulty[i]] = Math.max(maxprofit[difficulty[i]], profit[i]);

        }
        maxprofit[0] = 0;


        for(int i=1;i<maxDifficulty+1;i++){
            maxprofit[i] = Math.max(maxprofit[i], maxprofit[i-1]);
        }

        int maxsum = 0;
        for(int i=0;i<worker.length;i++){

            maxsum = maxsum + maxprofit[worker[i]];

        }

        return maxsum;

    }
}

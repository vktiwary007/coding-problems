package com.vivekasu;

public class GrumpyBookstoreOwner {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {


        int ans = 0;
        int nongrumpysum = 0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                nongrumpysum+=customers[i];
        }

        int grumpysum = 0;
        for(int i=0;i<X;i++){
            if(grumpy[i]==1)
                grumpysum+=customers[i];
        }

        int maxsum = grumpysum + nongrumpysum;
        int sum = maxsum;
        for(int i=X;i<customers.length;i++){

            if(grumpy[i-X]==1){
                sum = sum - customers[i-X];
            }

            if(grumpy[i]==1){
                sum = sum + customers[i];
            }

            if(maxsum<sum)
                maxsum = sum;

        }

        return maxsum;

    }
}

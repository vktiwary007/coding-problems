package com.vivekasu;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        if(amount<1)
            return 0;
        int[] mincoins = new int[amount +1];

        Arrays.fill(mincoins, Integer.MAX_VALUE);
        mincoins[0] = coins.length<1?0:1;

        for(int i=1;i<amount+1;i++){
            for(int j=0;j<coins.length;j++){

                if(coins[j]<=i){
                    if(coins[j]==i)
                        mincoins[i] = 1;
                    else if(mincoins[i-coins[j]]!=Integer.MAX_VALUE)
                        mincoins[i] = Math.min(mincoins[i-coins[j]]+1, mincoins[i]);
                }
            }
        }

        return mincoins[amount]!=Integer.MAX_VALUE?mincoins[amount]:-1;
    }
}

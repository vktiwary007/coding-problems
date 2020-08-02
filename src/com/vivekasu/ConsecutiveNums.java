package com.vivekasu;

public class ConsecutiveNums {

    public static void main(String[] args) {

        System.out.println(consecutiveNumbersSum(15));
    }

    public static int consecutiveNumbersSum(int N) {

        int ways = 0;
        int lim = (int)(Math.sqrt(2*N+0.25) - 0.5);

        for(int i=1;i<=lim;++i){

            N-=i;
            if(N%i==0)
                ways++;

        }

        return ways;

    }
}

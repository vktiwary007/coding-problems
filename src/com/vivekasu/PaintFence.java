package com.vivekasu;

public class PaintFence {

    public static void main(String[] args){
        PaintFence obj = new PaintFence();

        System.out.println(obj.numWays(3,2));
    }

    public int numWays(int n, int k) {

        if(k<= n-2)
            return 0;
        int[][] ways = new int[n+1][k+1];
        for(int i=1;i<k+1;i++)
            ways[1][i] = i;
        ways[2][1] = 1;

        for(int i=2;i<n+1;i++){

            for(int j=1;j<k+1;j++){
                ways[i][j] = ways[i][j] +ways[i][j-1]+ways[i-2][j]+ways[i-1][j-1];
            }
        }


        return ways[n][k];
    }
}

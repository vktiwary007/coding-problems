package com.vivekasu;

public class MinDistanceDeleteString {

    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        if(n==0 || m==0)
            return Math.max(n,m);

        int[][] delete = new int[n+1][m+1];

        for(int i=0;i<n+1;i++)
            delete[i][0] = i;

        for(int i=0;i<m+1;i++)
            delete[0][i] = i;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){

                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    delete[i][j] = 1 + Math.min(delete[i-1][j], delete[i][j-1]);
                }
                else
                    delete[i][j] = delete[i-1][j-1];

            }
        }

        return delete[n][m];

    }
}

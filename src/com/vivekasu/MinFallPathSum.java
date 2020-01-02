package com.vivekasu;

import java.util.Arrays;

public class MinFallPathSum {

    public int minFallingPathSum(int[][] A) {

        int minpathsum = Integer.MAX_VALUE;
        int row = A.length;
        int col = A[0].length;
        int[][] minsum = new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(minsum[i], Integer.MAX_VALUE);
        }

        for(int i=0;i<col;i++){
            minsum[0][i] = A[0][i];
        }
        for(int i:A[0]){
            if(i<minpathsum)
                minpathsum = i;
        }
        int[] selection = {-1,0,1};
        for(int i=1;i<row;i++){

            int minrow = Integer.MAX_VALUE;
            for(int j=0;j<col;j++){

                for(int k=0;k<3;k++){
                    int c = selection[k]+j;
                    if(c>=0 && c<col){
                        minsum[i][j] = Math.min(minsum[i][j], minsum[i-1][c]+A[i][j]);
                    }
                }
                if(minsum[i][j]<minrow)
                    minrow = minsum[i][j];
            }
            minpathsum=minrow;
        }

        return minpathsum;
    }
}

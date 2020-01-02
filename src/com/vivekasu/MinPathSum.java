package com.vivekasu;

public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minpathsum = new int[m][n];
        minpathsum[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            minpathsum[0][i] = grid[0][i]+minpathsum[0][i-1];
        }
        for(int i=1;i<m;i++){
            minpathsum[i][0] = grid[i][0] + minpathsum[i-1][0];
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                minpathsum[i][j] = grid[i][j] + Math.min(minpathsum[i-1][j],minpathsum[i][j-1]);
            }
        }

        return minpathsum[m-1][n-1];
    }
}

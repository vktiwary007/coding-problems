package com.vivekasu;

import java.util.Arrays;

public class MaxscorePath {

    public static void main(String[] args){
        int[][] grid = {{5,3,7,2},
                        {4,5,1,4}};
        System.out.println(maxPathSum(grid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

    int row = obstacleGrid.length;
    int col = obstacleGrid[0].length;

    int[][] paths = new int[row][col];
    if(obstacleGrid[0][0]!=1)
        paths[0][0] = 1;
    for(int i=1;i<col;i++){
        if(obstacleGrid[0][i]!=1 )
            paths[0][i] = paths[0][i-1];
    }

    for(int i=1;i<row; i++){
        if(obstacleGrid[i][0]!=1)
            paths[i][0] = paths[i-1][0];
    }

    for(int i=1; i<row; i++){
        for(int j=1;j<col;j++){
            if(obstacleGrid[i][j]!=1)
                paths[i][j] = paths[i-1][j] + paths[i][j-1];

        }
    }

    return paths[row-1][col-1];
    }


    public int uniquePaths(int m, int n) {

        int row = m;
        int col = n;
        int[][] paths = new int[row][col];
        paths[0][0] = 1;
        for(int i=1;i<col;i++){
            paths[0][i] = paths[0][i-1];
        }

        for(int i=1;i<row; i++){
            paths[i][0] = paths[i-1][0];
        }

        for(int i=1; i<row; i++){
            for(int j=1;j<col;j++){
                paths[i][j] = paths[i-1][j] + paths[i][j-1];

            }
        }

        return paths[row-1][col-1];
    }


    public static int minPathSum(int[][] grid) {
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

    public static int maxPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] maxpathsum = new int[m][n];
        maxpathsum[0][0] = grid[0][0];
        for(int i=1;i<n;i++){
            maxpathsum[0][i] = Math.min(grid[0][i],maxpathsum[0][i-1]);
        }
        for(int i=1;i<m;i++){
            maxpathsum[i][0] = Math.min(grid[i][0],maxpathsum[i-1][0]);
        }

        for(int i=1; i<m;i++){
            for(int j=1; j<n; j++){
                if(i==m-1 && j==n-1 )
                    maxpathsum[i][j] = Math.max(maxpathsum[i-1][j],maxpathsum[i][j-1]);
                else
                    maxpathsum[i][j] = Math.min(grid[i][j],Math.min(maxpathsum[i-1][j],maxpathsum[i][j-1]));
            }
        }

        return maxpathsum[m-1][n-1];
    }

}

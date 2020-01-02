package com.vivekasu;

public class UniquePaths {

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
}

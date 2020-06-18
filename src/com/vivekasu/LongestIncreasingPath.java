package com.vivekasu;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        if(m==0)
            return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }

        return max;

    }

    public int dfs(int[][] matrix, int[][] dp, int r, int c){

        if(dp[r][c]!=0)
            return dp[r][c];

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] d: dir){

            int i = r + d[0];
            int j = c + d[1];

            if(i>=0 && j>=0 && i<matrix.length && j<matrix[0].length){

                if(matrix[i][j]>matrix[r][c]){
                    dp[r][c] = Math.max(dp[r][c], dfs(matrix, dp, i, j));
                }
            }

        }

        return ++dp[r][c];

    }
}

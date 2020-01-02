package com.vivekasu;

public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length<1)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int row = m-1;
        int col = 0;

        while(row>=0 && row<m && col>=0 && col<n){

            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]>target){
                row--;
            }
            else if(matrix[row][col]<target){
                col++;
            }
        }


        return false;
    }
}

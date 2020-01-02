package com.vivekasu;

public class RotateImage {

    public void rotate(int[][] matrix) {

        if(matrix.length<1)
            return ;
        transpose(matrix);
        reverseRow(matrix);

    }

    public void transpose(int[][] matrix){

        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseRow(int[][] matrix){
        int len = matrix.length;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){

                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len-j-1];
                matrix[i][len-j-1] = temp;
            }
        }
    }
}

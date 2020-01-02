package com.vivekasu;

public class NumUniqueBST {

    public int numTrees(int n) {

        if(n<1)
            return 1;
        int[] numOfBST = new int[n+1];
        numOfBST[0] = 1;
        numOfBST[1] = 1;

        for(int i=2;i<n+1;i++){

            for(int j=1;j<=i;j++){
                numOfBST[i] = numOfBST[i] + numOfBST[j-1]*numOfBST[i-j];
            }

        }


        return numOfBST[n];

    }
}

package com.vivekasu;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {


        int n = triangle.size();
        if(n<1)
            return 0;
        if(triangle.get(0).isEmpty())
            return 0;

        if(n==1)
            return triangle.get(0).get(0);

        int[][] minpath = new int[n+1][n+1];

        Arrays.fill(minpath[0], 0);
        minpath[1][0] = triangle.get(0).get(0);
        int minsum = Integer.MAX_VALUE;
        for(int i=2;i<n+1;i++){

            List<Integer> rowList = triangle.get(i-1);
            Integer[] lst = rowList.toArray(new Integer[rowList.size()]);
            for(int j=0;j< i;j++){
                if(j!=0 && j!=lst.length-1){
                    minpath[i][j] = lst[j] + Math.min(minpath[i-1][j],minpath[i-1][j-1]);
                }
                else if(j==lst.length-1){
                    minpath[i][j] = lst[j] + minpath[i-1][j-1];
                }
                else if(j==0){
                    minpath[i][j] = lst[j] + minpath[i-1][0];
                }

                if(i==n && minpath[i][j]<minsum){
                    minsum = minpath[i][j];
                }
            }

        }


        return minsum;

    }
}

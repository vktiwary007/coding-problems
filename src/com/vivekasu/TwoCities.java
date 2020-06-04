package com.vivekasu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class TwoCities {

    public static void main(String[] args) {
        TwoCities obj = new TwoCities();
        //[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}; //{{10,20},{30,200},{400,50},{30,20}}; //{{10,20},{30,10},{20,20},{30,40}};
        System.out.println(obj.twoCitySchedCost(costs));
    }

    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int n = costs.length/2;
        int minCost = 0;
        for(int i=0;i<n;i++){
            minCost+=costs[i][0] + costs[i+n][1];
        }

        return minCost;

    }
}

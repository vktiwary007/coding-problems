package com.vivekasu;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinEffort {

    public static int getMinEffort(List<List<Integer>> C) {
        // Write your code here

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> pq = new PriorityQueue<>((a, b)->(a[0]-b[0]));
        pq.add(new int[]{0, 0, 0});
        int r = C.size();
        int c = C.get(0).size();
        boolean[][] visited = new boolean[r][c];
        int maxEffort = 0;
        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            visited[i][j] = true;
            maxEffort = Math.max(maxEffort, curr[0]);
            if(i==r-1 && j==c-1){
                return maxEffort;
            }
            for(int[] dir: dirs){
                int r_new = i + dir[0];
                int c_new = j + dir[1];

                if(r_new>=0 && c_new>=0 && r_new<r && c_new<c && !visited[r_new][c_new]){

                    int diff = Math.abs(C.get(r_new).get(c_new) - C.get(i).get(j));

                    pq.add(new int[]{diff, r_new, c_new});

                }
            }


        }

        return maxEffort;

    }
}

package com.vivekasu;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> que = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int min = 0;
        int fresh = 0;
        int rotten = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    que.add(new int[]{i, j});
                }
                else if(grid[i][j]==1)
                    fresh++;
            }
        }

        if(fresh==0)
            return 0;

        min = bfs(que, grid, fresh);


        return min;

    }

    private int bfs(Queue<int[]> que, int[][] grid, int fresh){

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int nextLevel = 1;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        while(!que.isEmpty()){

            int lvl = que.size();
            time++;
            for(int i=0;i<lvl;i++ ){

                int[] rotten = que.poll();
                int row = rotten[0];
                int col = rotten[1];
                for(int[] dir: dirs){

                    int r = row + dir[0];
                    int c = col + dir[1];

                    if(r>=0 && c>=0 && r<m && c<n && fresh>0 && grid[r][c]==1){
                        grid[r][c] = 2;
                        que.add(new int[]{r, c});
                        fresh--;
                    }

                }

            }

        }


        return fresh==0?(time-1):-1;

    }
}

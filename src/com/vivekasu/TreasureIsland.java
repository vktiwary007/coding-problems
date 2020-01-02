package com.vivekasu;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreasureIsland {


    public static void main(String[] args){
        char[][] grid = {{'O','O','O','O'},{'D','O','D','O'},{'O','O','O','O'},{'X','D','D','O'}};
        System.out.println(minPath(grid));
    }

    private static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};

    public static int minPath(char[][] grid){

        int minpath = 1;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Point> que = new ArrayDeque<>();
        Point point = new Point(0,0);
        grid[0][0] = 'D';
        que.add(point);
        while(!que.isEmpty()){
            minpath++;
            for(int i=0;i<que.size();i++){
                Point chk = que.poll();
                for(int[] dir: dirs){
                    int r = chk.r + dir[0];
                    int c = chk.c + dir[1];
                    if(isSafe(grid,r,c)){
                        if(grid[r][c]=='X'){
                            return minpath;
                        }
                        grid[r][c] = 'D';
                        Point p = new Point(r,c);
                        que.add(p);
                    }
                }
            }

        }

        return -1;
    }

    public static boolean isSafe(char[][] grid, int r, int c){
        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]!='D')
            return true;

        return false;
    }
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

}

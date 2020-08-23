package com.vivekasu;

import java.util.Arrays;

public class LabyrinthCheck {

    boolean labyrinthEscape(int n, int m, int[][] obstacles, int[][] teleports){
        int[][] move = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<teleports.length;i++){
            move[teleports[i][0]][teleports[i][1]] = move[teleports[i][2]][teleports[i][3]];
        }

        for(int i=0;i<obstacles.length;i++){
            move[obstacles[i][0]][obstacles[i][1]] = -1;
        }

        return dfs(0, 0, move, visited);
    }

    private boolean dfs(int r, int c, int[][] move, boolean[][] visited){

        if(!(r>=0 && c>=0 && r<move.length && c<move[0].length) || visited[r][c])
            return false;

        visited[r][c] = true;


        return false;


    }
}

package com.vivekasu;

import java.util.*;

public class SurroundedRegions {

    public static void main(String[] args){

        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','O','X'}};
        SurroundedRegions obj = new SurroundedRegions();

        obj.solve(board);

        System.out.println(false&&false);

        System.out.println(board);
    }

    public void solve(char[][] board) {

        int r = board.length;
        int c = r>0?board[0].length:0;
        boolean[][] visited= new boolean[r][c];
        if(c<1)
            return;
        for(int i=0;i<c;i++){
            if(board[0][i]=='O' && !visited[0][i]){
                dfs(board, visited, 0, i);
            }

            if(board[r-1][i]=='O' && !visited[r-1][i]){
                dfs(board, visited, r-1, i);
            }
        }

        for(int i=0;i<r;i++){
            if(board[i][0]=='O' && !visited[i][0]){
                dfs(board, visited, i, 0);
            }

            if(board[i][c-1]=='O' && !visited[i][c-1]){
                dfs(board, visited, i, c-1);
            }
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='O' &&!visited[i][j])
                    board[i][j] = 'X';
            }
        }


    }

    public void dfs(char[][] board, boolean[][] visited, int r, int c){


        int[] row = {0,1,0,-1};
        visited[r][c] = true;
        int[] col = {1,0,-1,0};


        for(int i=0;i<4;i++){

            int rn = r + row[i];
            int cn = c + col[i];
            if(rn>=0 && cn>=0 && rn<board.length && cn<board[0].length){
                if(board[rn][cn]=='O' && !visited[rn][cn]){
                    dfs(board, visited, rn, cn);
                }
            }
        }

    }


}

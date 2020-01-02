package com.vivekasu;

public class NumIslands {

    public int numIslands(char[][] grid) {


        if(grid.length < 1)
            return 0;

        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean[][] recurstack = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    findIslands(i,j, grid, visited, recurstack);
                    count++;
                }
            }
        }


        return count;

    }


    public void findIslands(int r, int c, char[][] grid, boolean[][] visited, boolean[][] recurstack){

        if(recurstack[r][c])
            return;

        recurstack[r][c] = true;
        visited[r][c] = true;

        int[] row = {1,0,-1,0};
        int[] col = {0, 1, 0, -1};

        for(int i=0;i<row.length;i++){
            int currow = r+row[i];
            int curcol = c+col[i];
            if(currow<grid.length && curcol<grid[0].length && currow>=0 && curcol>=0){
                if(!visited[currow][curcol] && grid[currow][curcol]=='1'){
                    findIslands(currow,curcol, grid, visited, recurstack);
                }
            }
        }

        recurstack[r][c] = false;

    }
}

package com.vivekasu;

public class IslandPerimeter {

    int perimeter;
    public int islandPerimeter(int[][] grid) {

        perimeter = 0;
        int n = grid.length;
        if(n<1)
            return 0;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(i, j, grid, visited);
                    break;
                }

            }
        }

        return perimeter;

    }


    public void dfs(int r, int c, int[][] grid, boolean[][] visited){

        int n = grid.length;
        int m = grid[0].length;
        if(!(r>=0 && c>=0 && r<n && c<m) || (grid[r][c]==1 && visited[r][c]))
            return;

        int val = perimeter;
        visited[r][c] = true;
        if(grid[r][c]==1){

            if(r==0 || c==0 || r==n-1 || c==m-1){

                if((r==0 && c==0) || (r==n-1 && c==0) || (r==n-1 && c==m-1) || (r==0 && c==m-1)){
                    perimeter+=2;
                }
                else if(((r==0 || r==n-1) && (c>0 && c<m-1)) || ((c==0 || c==m-1) && (r>0 && r<n-1))){
                    perimeter+=1;
                }

                if(n-1==0 && m-1==0)
                    perimeter+=2;
                else if(n-1==0 || m-1==0)
                    perimeter+=1;


            }

            dfs(r+1, c, grid, visited);
            dfs(r, c+1, grid, visited);
            dfs(r-1, c, grid, visited);
            dfs(r, c-1, grid, visited);
        }
        else
            perimeter+=1;

    }
}

package com.vivekasu;

public class WallNGates {

    public void wallsAndGates(int[][] rooms) {

        int m = rooms.length;
        if(rooms.length<1 || rooms[0].length<1)
            return;
        int n = rooms[0].length>0?rooms[0].length:0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j]==0){
                    updateGates(rooms,i,j,0);
                }
            }
        }

    }


    public void updateGates(int[][] rooms, int r, int c, int d){

        if(!(r>=0 && c>=0 && r<rooms.length && c<rooms[0].length) || rooms[r][c]==-1 || d>rooms[r][c])
            return;

        rooms[r][c] = d;
        updateGates(rooms, r+1, c, d+1);
        updateGates(rooms, r, c+1, d+1);
        updateGates(rooms, r-1, c, d+1);
        updateGates(rooms, r, c-1, d+1);

    }
}

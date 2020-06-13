package com.vivekasu;

import java.util.*;

public class TestSolution {

    class Artifact{

        int[] topLeft;
        int[] bottomRight;
        int cells;
        int covered;

        public Artifact(){
            topLeft = new int[2];
            bottomRight = new int[2];
            cells = 0;
            covered = 0;
        }

    }

    class Solution{

        public int[] solution(int N, String artifacts, String searched) {
            // write your code in Java
            Map<Integer, Artifact> artifactMap = new HashMap<>();
            int[] ans = new int[2];
            int[][] layout = new int[N][N];
            //Set<String> seachKeys = new HashSet<String>();
            String[] artifactLocations = artifacts.split(",");
            int ind = 1;
            for(String location: artifactLocations){
                String[] current = location.split(" ");
                int[] topLeft = getCells(current[0]);
                int[] bottomRight = getCells(current[1]);
                fillArea(layout, topLeft, bottomRight, ind);
                Artifact artifact = new Artifact();
                artifact.covered = 0;
                artifact.topLeft = topLeft;
                artifact.bottomRight = bottomRight;
                artifact.cells = getArea(topLeft, bottomRight);
                artifactMap.put(ind, artifact);
                ind++;
            }
            for(String str : searched.split(" ")){
                int[] location = getCells(str);
                int key = layout[location[0]][location[1]];
                if(key != 0){
                    Artifact atr = artifactMap.get(key);
                    atr.covered++;
                }
            }
            for(int key : artifactMap.keySet()){
                Artifact atr = artifactMap.get(key);
                if(atr.covered == atr.cells) ans[0]++;
                else if(atr.covered > 0) ans[1]++;
            }

            return ans;
        }

        public void fillArea(int [][] layout, int [] topLeft, int [] bottomRight, int key){
            for(int i = topLeft[0]; i <= bottomRight[0]; i++){
                for(int j = topLeft[1]; j <= bottomRight[1]; j++){
                    layout[i][j] = key;
                }
            }
        }

        public int[] getCells(String location){
            int[] ind = new int[2];
            ind[0] = Integer.parseInt(String.valueOf(location.charAt(0))) - 1;
            ind[1] = location.charAt(0) - 'A';
            return ind;
        }

        public int getArea(int[] topLeft, int[] bottomRight){
            return Math.abs((bottomRight[0] - topLeft[0] + 1)*(bottomRight[1] - topLeft[1] + 1));
        }

    }
}

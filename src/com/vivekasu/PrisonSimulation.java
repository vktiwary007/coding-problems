package com.vivekasu;

import java.util.Arrays;
import java.util.HashMap;

public class PrisonSimulation {

    public static void main(String[] args){

        int[] cells = {0,1,0,1,1,0,0,1};
        int[] afterndays = prisonAfterNDays(cells, 7);
        for(int i=0;i<afterndays.length;i++){
            System.out.print(afterndays[i]+" ");
        }
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {

        int[][] days = new int[2][cells.length];
        days[0] = cells;
        Arrays.fill(days[1],0);
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<Integer, String> getValue = new HashMap<>();
        int period = 0;
        for(int i=1;i<=N;i++){
            String s = "";
            s = s+days[1][0]+",";
            for(int j=1;j<7;j++){


                if((days[0][j-1]==1 && days[0][j+1]==1) || (days[0][j-1]==0 && days[0][j+1]==0)){
                    days[1][j] = 1;
                }
                else{
                    days[1][j] = 0;
                }
                s = s +days[1][j]+",";
            }
            s = s +days[1][7];
            if(!hm.containsKey(s)){
                hm.put(s,1);
                getValue.put(period+1,s);
                period++;
            }
            else{
                break;
            }
            System.arraycopy(days[1],0,days[0],0,8);
        }

        int rem = N%period;
        int[] finalday = new int[8];
        int i = 0;
        if(rem==0)
            rem = period;
        for(String st:getValue.get(rem).split(",")){
            finalday[i] = Integer.parseInt(st);
            i++;
        }

        return finalday;
    }
}

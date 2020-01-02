package com.vivekasu;

import java.util.*;

public class Streetlights {

    public static void main(String[] args){


        List arlist = new ArrayList();
        arlist.add(2);
        arlist.add(0);
        arlist.add(0);
        arlist.add(0);
        System.out.println(fountainActivation(arlist));
    }


   /* public static int streetLights(int n, int[][] lights){

        int minlights = 0;
        int width = 0;
        int[] start = new int[lights.length];
        int[] end = new int[lights.length];
        TreeMap<Integer, Integer> hmstart = new TreeMap<Integer, Integer>();

        int lastinterval = 0;
        for(int i=0;i<lights.length;i++){

            start[i] = lights[i][1]-lights[i][0];
            end[i] = lights[i][1] + lights[i][0];
            if(end[i]>lastinterval)
                lastinterval = end[i];

        }

        int[] indarr = new int[lastinterval+1];
        for(int i=1;i<lastinterval;i++){

        }
        int startpath = start[0];
        int endpath = end[0];
        if(endpath-startpath<n){
            width = n - endpath;
            minlights++;
            startpath = endpath;
        }
        if(width<=0)
            return minlights;
        for(int i=1;i<lights.length;i++){


        }



        return minlights;
    }*/


    public static long carParkingRoof(List<Long> cars, int k){
        long rooflen = Long.MAX_VALUE;

        Collections.sort(cars);
        for(int i=0;i<cars.size()-k;i++){
            rooflen = Math.min(rooflen, cars.get(i+k)-cars.get(i) +1l);
        }

        return rooflen ;
    }


    public static int fountainActivation(List<Integer> a){
        int n = a.size();

        int minfountains = 0;
        //List<List<Integer>> range = new ArrayList<>();
        TreeMap<Integer, Integer> hm = new TreeMap<>();
        int maxval = 0;
        for(int i=0;i<n;i++){
            List<Integer> arr = new ArrayList<>();
            int start = Math.max(i+1-a.get(i),1);
            int end = Math.min(i+1+a.get(i),n);
           /* arr.add(0,start);
            arr.add(1,end);
            range.add(i,arr);
*/
            if(end>maxval)
                maxval = end;
            if(!hm.containsKey(start)){
                hm.put(start, end);
            }
            else{
                int curr = hm.get(start);
                hm.put(start, Math.max(curr, end));
            }
        }

        int[] arr = new int[maxval+1];
        Arrays.fill(arr,0);
        for(int i:hm.keySet()){
            arr[i] = hm.get(i);
        }

        int currmax = 0;
        int currstart = 0;
        for(int i=1;i<arr.length;i++){

            int currval = arr[i];
            if(currval >0 && currval>currmax){
                currmax = currval;

                if(currstart<i){

                }
                minfountains++;
                currstart = i;
            }

            if(currval>=n){
                break;
            }

        }

        return minfountains;
    }

}

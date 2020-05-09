package com.vivekasu;

import java.util.HashMap;

public class GumBalls {

    public static void main(String[] args){
        GumBalls obj = new GumBalls();
        String[] balls = {"red","green","blue","red","white","black"};
        System.out.println(obj.getMinCost(2,balls));
    }

    public double getMinCost(int n, String[] balls){

        double cost = 0.0;
        HashMap<String, Integer> color = new HashMap<>();
        String minColor = "";
        for(int i=0;i<balls.length;i++){
            if(color.containsKey(balls[i])){
                color.put(balls[i], 1000);
            }
            else if(!color.containsKey((balls[i])) && color.size()==3) {

                double min = 1001;
                for(String k : color.keySet()){
                    if(color.get(k)<min){
                        min = color.get(k);
                        minColor = k;
                    }
                }
                cost = cost + min;
                color.remove(minColor);
                color.put(balls[i],1000);
            }
            else if(!color.containsKey((balls[i])) && color.size()<3){
                color.put(balls[i],1000);
            }

            for(String k : color.keySet()){
               color.put(k,color.get(k)-10);
            }
            

        }


        return cost/100;
    }

}

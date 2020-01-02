package com.vivekasu;

import java.util.*;

public class OptimalUtilization {

    public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        List<List<Integer>> res = new ArrayList<>();
        int len1 = forwardRouteList.length;
        int len2 = returnRouteList.length;
        if(len1 == 0 || len2 == 0)
            return res;
        Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
        Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));

        int left = 0;
        int right = len2 - 1;
        int maxVal = -1;
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        while(left < len1 && right >= 0){
            int sum = forwardRouteList[left][1] + returnRouteList[right][1];
            if(sum > maxTravelDist){ --right; continue;}
            if(sum >= maxVal){
                int r = right;
                map.putIfAbsent(sum, new ArrayList<>());
                // check the duplicates
                while(r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]){
                    List<Integer> list = new ArrayList<>();
                    list.add(forwardRouteList[left][0]);
                    list.add(returnRouteList[r][0]);
                    map.get(sum).add(list);
                    --r;
                }
                maxVal = sum;
            }
            ++left;
        }
        return map.get(maxVal);
    }


    public static void main(String[] args){

        OptimalUtilization obj = new OptimalUtilization();

        int maxtraveldist = 10000;
        int[][] forward = {{1,3000},{2,5000},{3,7000},{4,10000}};
        int[][] returnRoute = {{1,2000},{2,3000}, {3,4000}, {4,5000}};
        List<List<Integer>> list = obj.aircraftUtilization(maxtraveldist, forward,returnRoute);

        Iterator itr = list.iterator();
        while(itr.hasNext()){

            List<Integer> lst = (List<Integer>) itr.next();
            Iterator itr1 = lst.iterator();
            while(itr1.hasNext()){
                System.out.println(itr1.next());
            }
        }
    }
}

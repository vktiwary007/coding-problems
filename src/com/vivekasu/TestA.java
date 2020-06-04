package com.vivekasu;

import java.util.*;

public class TestA {

    private final void foo() {}

    public static void main(String[] args) {
        //System.out.println(minimumMoves("101", 2));
        Integer[] a = new Integer[]{13,14,13,1};
        Integer[] b = new Integer[]{8,12,12,9};
        List<Integer> arr = Arrays.asList(a);
        List<Integer> brr = Arrays.asList(b);
        Integer[] c = new Integer[]{15,15,14,14};
        Integer[] d = new Integer[]{15,10,10,5};
        List<List<Integer>> lst = new ArrayList<>();
        lst.add(Arrays.asList(a));
        lst.add(Arrays.asList(b));
        lst.add(Arrays.asList(c));
        lst.add(Arrays.asList(d));
        System.out.println(getMinEffort(lst));
    }

    public static int minimumMoves(String s, int d) {
        // Write your code here

        int moves = 0;
        int left = 0;
        int right = 0;
        boolean first1 = s.charAt(0)=='1';
        int i = 0;
        while(right<s.length()){

            if(s.charAt(right)=='1'){
                left = right;
            }
            else{
                if(right - left + 1 >= d){
                    if(!first1 && left==0 || right - left + 1 > d) {
                        moves++;
                        left = right;
                    }

                }
            }

            right++;

        }

        return moves;

    }

    public static String arrangeStudents(List<Integer> a, List<Integer> b) {
        // Write your code here
        Collections.sort(a);
        Collections.sort(b);

        int i=0, j=0;
        String possible = "YES";
        boolean isBoy = false;
        if(a.get(0)<=b.get(j)){
            i++;
            isBoy = true;
        }
        else{
            j++;
        }

        while(i<a.size() && j<b.size()){

            if(a.get(i)<=b.get(j) && !isBoy){
                i++;
                isBoy = true;
            }
            else if(b.get(j)<=a.get(i) && isBoy){
                j++;
                isBoy = false;
            }
            else{
                return "NO";
            }

        }

        if(Math.abs(i-j)>1)
            return "NO";

        return possible;

    }


    public static int getMinEffort(List<List<Integer>> C) {
        // Write your code here

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.add(new int[]{0, 0, 0});
        int r = C.size();
        int c = C.get(0).size();
        boolean[][] visited = new boolean[r][c];
        int maxEffort = 0;
        while(!pq.isEmpty()){

            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            visited[i][j] = true;
            maxEffort = Math.max(maxEffort, curr[0]);
            if(i==r-1 && j==c-1){
                return maxEffort;
            }
            for(int[] dir: dirs){
                int r_new = i + dir[0];
                int c_new = j + dir[1];

                if(r_new>=0 && c_new>=0 && r_new<r && c_new<c && !visited[r_new][c_new]){

                    int diff = Math.abs(C.get(r_new).get(c_new) - C.get(i).get(j));

                    pq.add(new int[]{diff, r_new, c_new});

                }
            }


        }

        return maxEffort;

    }


}

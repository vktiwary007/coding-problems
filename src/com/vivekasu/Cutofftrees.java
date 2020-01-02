package com.vivekasu;

import java.util.*;

public class Cutofftrees {


    /**
     *
     * @param args
     *
     *
     * [[4557,6199,7461,2554,6132,7471,7103,4290],
     * [2034,2301,6733,6040,2603,5697,9541,6678],
     * [7308,7368,9618,4386,6944,3923,4754,4294],
     * [0,3016,7242,5284,6631,1897,1767,7603],
     * [2228,0,3625,7713,2956,3264,3371,6124],
     * [9195,7804,2787,0,4919,9304,5161,502]]
     */
    public static void main(String[] args){
        List<List<Integer>> forest = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(4557);
        l1.add(6199);
        l1.add(7461);
        l1.add(2554);

        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(0);
        l2.add(5);
        //l2.add(7);

        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(7);
        l3.add(8);
        //l3.add(9);

        forest.add(l1);
        forest.add(l2);
        forest.add(l3);

        System.out.println(cutOffTree(forest));

    }

    public static int cutOffTree(List<List<Integer>> forest) {
        int minpath = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Point> que = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return forest.get(o1.r).get(o1.c).compareTo(forest.get(o2.r).get(o2.c));
            }

        });

        List<List<Integer>> celllist = new ArrayList<>();

        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2).compareTo(o2.get(2));
            }
        };
        Point point = new Point(0,0);
        if(forest.get(0).get(0)==0)
            return -1;
        visited[0][0] = true;
        que.add(point);
        List<Integer> pt0 = new ArrayList<>();
        pt0.add(0);
        pt0.add(0);
        pt0.add(forest.get(0).get(0));
        celllist.add(pt0);
        int totaltrees = 0;
        for(List<Integer> lst: forest){
            for(int cell:lst){
                if(cell>1)
                    totaltrees++;
            }
        }
        int treescut =0;
        while(!que.isEmpty()){
            for(int i=0;i<que.size();i++){

                Point chk = que.poll();

                if(forest.get(chk.r).get(chk.c)>1){
                    treescut++;
                }
                if(treescut==totaltrees)
                    break;
                for(int[] dir: dirs){
                    int r = chk.r + dir[0];
                    int c = chk.c + dir[1];
                    if(isSafe(forest,r,c,visited)){
                        visited[r][c] = true;
                        Point p = new Point(r,c);
                        que.add(p);
                        List<Integer> pt = new ArrayList<>();
                        pt.add(r);
                        pt.add(c);
                        pt.add(forest.get(r).get(c));
                        celllist.add(pt);
                    }
                }
            }

        }

        if(treescut==totaltrees){
            Collections.sort(celllist, comparator);
            List<Integer> prev = pt0;
            for(List<Integer> cells: celllist){
                int dist = Math.abs(cells.get(0)-prev.get(0))+Math.abs(cells.get(1)-prev.get(1));
                System.out.println(cells.get(0)+","+cells.get(1)+" :: "+cells.get(2)+":: dist = "+dist);

                minpath = minpath + dist;
                prev = cells;
            }

            return minpath;
        }


        return -1;
    }



    private static int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};


    public static boolean isSafe(List<List<Integer>>  grid, int r, int c, boolean[][] visited){
        if(r>=0 && r<grid.size() && c>=0 && c<grid.get(0).size() && grid.get(r).get(c)!=0 && !visited[r][c])
            return true;

        return false;
    }
    static class Point{
        int r;
        int c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}

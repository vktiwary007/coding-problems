package com.vivekasu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseScheculeII {

    class Graph{

        int V;
        List<List<Integer>> edges;

        public Graph(int V){

            this.V = V;
            edges = new ArrayList<>();
            for(int i=0;i<V;i++){
                edges.add(new ArrayList<>());
            }
        }

    }

    Graph graph;
    int WHITE = 0;
    int GRAY = 1;
    int BLACK = 2;
    HashMap<Integer, Integer> color;
    boolean cycle;
    List<Integer> order;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        this.graph = new Graph(numCourses);
        this.color = new HashMap<>();

        order = new ArrayList<>();
        int n = prerequisites.length;

        for(int i=0; i<n; i++){
            int[] edge = prerequisites[i];
            graph.edges.get(edge[1]).add(edge[0]);
        }

        if(n<1){
            for(int i=0;i<numCourses;i++){
                order.add(i);
            }

            return order.stream().mapToInt(Integer::intValue).toArray();
        }

        for(int i=0; i<numCourses;i++){
            color.put(i, WHITE);
        }

        for(int i=0; i<numCourses; i++){

            if(color.get(i)==WHITE){
                dfs(i);
            }

        }

        if(cycle)
            return new int[]{};

        int[] ans = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            int k = numCourses-i-1;
            ans[i] = order.get(k);
        }

        return ans;
    }

    public void dfs(int node){

        if(cycle)
            return;

        color.put(node, GRAY);
        for(int i: graph.edges.get(node)){

            if(color.get(i)==WHITE){
                dfs(i);
            }
            else if(color.get(i)==GRAY){
                cycle = true;
            }
        }
        color.put(node, BLACK);
        order.add(node);

    }
}

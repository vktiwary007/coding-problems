package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

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

        public void addEdge(int source, int dest){
            edges.get(source).add(dest);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Graph graph = new Graph(numCourses);

        for(int[] edge:prerequisites){
            graph.addEdge(edge[1],edge[0]);
        }

        boolean[] visited = new boolean[graph.V];
        boolean[] recurStack = new boolean[graph.V];

        for(int i=0;i<graph.V;i++){

            for(int course: graph.edges.get(i)){
                if(isCyclic(visited, recurStack,course,graph)){
                    return false;
                }
            }

        }

        return true;

    }


    public boolean isCyclic(boolean[] visited, boolean[] recurStack, int dest, Graph graph){
        if(recurStack[dest])
            return true;
        if(visited[dest])
            return false;

        visited[dest] = true;
        recurStack[dest] = true;
        for(int i:graph.edges.get(dest)){
            if(isCyclic(visited, recurStack,i, graph)){
                return true;
            }
        }

        recurStack[dest] = false;

        return false;

    }
}

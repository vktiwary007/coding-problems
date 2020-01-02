package com.vivekasu;

import java.util.*;

public class WordLadderII {

    public static void main(String[] args){
        WordLadderII obj = new WordLadderII();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(obj.findLadders("hit","cog", Arrays.asList(words)));
    }

    class Node{
        String word;
        boolean isVisited;

        public Node(String word, boolean visited){
            this.word = word;
            this.isVisited = visited;
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> paths = new ArrayList<>();
        HashMap<String, Node> nodesmap = new HashMap<>();
        HashMap<String, List<String>> wordmap = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();
        int steps = 0;
        Node begin = new Node(beginWord, false);
        que.add(begin);
        boolean checkend = false;
        for(String s : wordList){

            for(int i=0;i<s.length();i++){
                String st = s.substring(0,i)+"*"+s.substring(i+1);
                List<String> arr = wordmap.getOrDefault(st, new ArrayList<String>());
                arr.add(s);
                wordmap.put(st, arr);
            }

            if(s.equalsIgnoreCase(endWord))
                checkend = true;

        }

        if(!checkend)
            return paths;

        int lvlsize = 1;
        List<String> prefix = new ArrayList<>();
        int currMinSteps = Integer.MAX_VALUE;
        while(!que.isEmpty()){

            steps++;
            int currsize = 0;
            if(currMinSteps<=steps)
                break;
            for(int k=0;k<lvlsize;k++){

                Node currNode = que.poll();
                if(currNode.isVisited)
                    continue;
                currNode.isVisited = true;
                List<String> levelPaths = new ArrayList<String>(prefix);
                levelPaths.add(currNode.word);
                for(int i=0;i<currNode.word.length();i++){
                    String st = currNode.word.substring(0,i)+"*"+currNode.word.substring(i+1);
                    if(wordmap.containsKey(st)){
                        for(String neighbors: wordmap.get(st)){

                            if(neighbors.equalsIgnoreCase(endWord) && steps<=currMinSteps){
                                List<String> shortestpath = new ArrayList<String>(levelPaths);
                                shortestpath.add(endWord);
                                paths.add(shortestpath);
                                currMinSteps = steps;
                            }
                            if(!nodesmap.containsKey(neighbors)){
                                Node neighborNode = new Node(neighbors, false);
                                nodesmap.put(neighbors, neighborNode);
                                que.add(neighborNode);
                                currsize++;
                            }


                        }
                    }
                }

                prefix = new ArrayList<String>(levelPaths);
            }
            lvlsize = currsize;

        }
        return paths;
    }
}

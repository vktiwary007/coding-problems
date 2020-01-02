package com.vivekasu;

import java.util.*;

public class WordLadderDiffSol {

    public static void main(String[] args){
        WordLadderDiffSol obj = new WordLadderDiffSol();
        String[] words = {"hot","dot","dog","lot","log","cog"};
        System.out.println(obj.ladderLength("hit","cog",Arrays.asList(words)));
    }

    class Node{
        String word;
        boolean isVisited;

        public Node(String word, boolean visited){
            this.word = word;
            this.isVisited = visited;
        }

    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

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
            return 0;

        int lvlsize = 1;
        while(!que.isEmpty()){

            steps++;
            int currsize = 0;
            for(int k=0;k<lvlsize;k++){

                Node currNode = que.poll();
                if(currNode.isVisited)
                    continue;
                currNode.isVisited = true;

                for(int i=0;i<currNode.word.length();i++){
                    String st = currNode.word.substring(0,i)+"*"+currNode.word.substring(i+1);
                    if(wordmap.containsKey(st)){
                        for(String neighbors: wordmap.get(st)){

                            if(neighbors.equalsIgnoreCase(endWord))
                                return steps+1;
                            if(!nodesmap.containsKey(neighbors)){
                                Node neighborNode = new Node(neighbors, false);
                                nodesmap.put(neighbors, neighborNode);
                                que.add(neighborNode);
                                currsize++;
                            }


                        }
                    }
                }

            }
            lvlsize = currsize;

        }
        return 0;
    }
}

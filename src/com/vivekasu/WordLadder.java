package com.vivekasu;

import java.util.*;

public class WordLadder {

    public static void main(String[] args){
        WordLadder obj = new WordLadder();
        String[] arr = {"hot","cog","dog","tot","hog","hop","pot","dot"};
        System.out.println(obj.ladderLength("hot","dog", Arrays.asList(arr)));
    }

    class Node{
        String val;
        boolean isVisited;
        Set<Node> neighbors;
    }







    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        HashMap<String, Node> nodesmap = new HashMap<>();
        Queue<Node> que = new ArrayDeque<>();
        int steps = 0;
        Node beginnode = new Node();
        beginnode.val = beginWord;
        beginnode.neighbors = new HashSet<>();
        nodesmap.put(beginWord,beginnode);
        que.add(beginnode);
        for(String s : wordList){
            if(!nodesmap.containsKey(s)){
                Node node = new Node();
                node.val = s;
                node.neighbors = new HashSet<>();
                nodesmap.put(s,node);
            }
        }

        for(String s : wordList){

            char[] ch = s.toCharArray();

            int beginDiff = 0;
            for(int i=0;i<ch.length;i++){
                if(i<beginWord.length() && beginWord.charAt(i)!=ch[i]){
                    beginDiff++;
                }
            }
            if(beginDiff==1){
                Node node = nodesmap.get(s);
                node.neighbors.add(beginnode);
                beginnode.neighbors.add(node);
            }

            for(int i=0;i<wordList.size();i++){
                int diff = 0;
                char[] c1 = wordList.get(i).toCharArray();
                diff = Math.abs(c1.length-ch.length);
                if(diff>1)
                    continue;
                for(int j=0;j<c1.length;j++){
                    if(j<ch.length && ch[j]!=c1[j]){
                        diff++;
                    }
                }

                if(diff==1){
                    Node newNode = nodesmap.get(wordList.get(i));
                    newNode.neighbors.add(nodesmap.get(s));
                    nodesmap.get(s).neighbors.add(newNode);
                }
            }
        }

        int lvlsize = 1;
        while(!que.isEmpty()){
            steps++;
            int currsize = 0;
            for(int i=0;i<lvlsize;i++){
                Node curr = que.poll();
                curr.isVisited = true;
                if(curr.val.equalsIgnoreCase(endWord)){
                    return steps;
                }
                for(Node neighbor : curr.neighbors){

                    if(neighbor.isVisited)
                        continue;
                    que.add(neighbor);
                    currsize++;
                }
            }
            lvlsize = currsize;


        }

        return 0;

    }
}

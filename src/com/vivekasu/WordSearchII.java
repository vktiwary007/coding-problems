package com.vivekasu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSearchII {

    class TrieNode{

        HashMap<Character, TrieNode> links;
        String word;
        public TrieNode(){
            links = new HashMap<>();
        }

        public HashMap<Character, TrieNode> getLinks(){
            return links;
        }

        public TrieNode get(char ch){
            return links.get(ch);
        }

        public void put(char ch, TrieNode node){
            links.put(ch,node);
        }

        public String getWord(){
            return word;
        }

        public void setWord(String word){
            this.word = word;
        }
    }


    char[][] board;
    List<String> search;
    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        this.board = board;
        for(String s : words){
            TrieNode trie = root;
            for(int i=0;i<s.length();i++){
                char ch = s.charAt(i);
                if(!trie.getLinks().containsKey(ch)){
                    trie.put(ch, new TrieNode());
                }
                trie = trie.get(ch);
            }

            trie.setWord(s);
        }

        search = new ArrayList<>();

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board[0].length;j++){
                char ch = board[i][j];
                if(root.getLinks().containsKey(ch)){
                    searchWords(i,j,root);
                }
            }
        }

        return search;
    }

    public void searchWords(int row, int col, TrieNode node) {

        char ch = board[row][col];

        TrieNode currNode = node.get(ch);
        if(currNode.getWord()!=null){
            search.add(currNode.getWord());
            currNode.setWord(null);
        }

        board[row][col] = '#';

        int[] rows = {-1,0,1,0};
        int[] cols = {0,1,0,-1};
        for(int i=0;i<4;i++){

            int newrow = row + rows[i];
            int newcol = col + cols[i];
            if(newrow<0 || newcol<0 || newrow>=board.length || newcol>=board[0].length)
                continue;
            if(currNode.getLinks().containsKey(board[newrow][newcol])){
                searchWords(newrow, newcol, currNode);
            }

        }

        board[row][col] = ch;

    }
}

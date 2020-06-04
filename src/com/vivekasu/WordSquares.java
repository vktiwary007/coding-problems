package com.vivekasu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSquares {

    public static void main(String[] args){

        WordSquares obj = new WordSquares();
        String[] arr = {"area","lead","wall","lady","ball"};
        System.out.println(obj.wordSquares(arr));
    }


    String[] words;
    int n;
    Map<String, List<String>> prefix;
    public List<List<String>> wordSquares(String[] words) {
        this.words = words;
        this.n = words[0].length();
        prefix = new HashMap<>();
        createPrefix();
        List<List<String>> ans = new ArrayList<>();
        for(String word: words){
            List<String> temp = new ArrayList<>();
            temp.add(word);
            backtrack(1, temp, ans);
        }

        return ans;
    }

    public void backtrack(int k, List<String> temp, List<List<String>> ans){

        if(k==n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        StringBuilder pre = new StringBuilder();
        for(String word: temp){
            pre.append(word.charAt(k));
        }

        if(!prefix.containsKey(pre.toString()))
            return;

        for(String word: prefix.get(pre.toString())){
            temp.add(word);
            backtrack(k+1, temp, ans);
            temp.remove(temp.size()-1);

        }

    }

    public void createPrefix(){

        int k = words[0].length();

        for(String word: words){
            for(int i=1;i<k;i++){

                String curr = word.substring(0,i);
                List<String> lst = prefix.get(curr);
                if(lst==null){
                    List<String> arr = new ArrayList<>();
                    arr.add(word);
                    prefix.put(curr, arr);
                }
                else{
                    lst.add(word);
                }

            }
        }

    }
}

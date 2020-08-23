package com.vivekasu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GuessWord {

    interface Master {
     public int guess(String word);
    }

    public void findSecretWord(String[] wordlist, Master master) {

        int n = 0;
        List<String> words = Arrays.asList(wordlist);
        for(int i=0;i<10;i++){
            n = words.size();
            if(n<1)
                return;
            int k = new Random().nextInt(n);
            int cnt = master.guess(words.get(k));
            if(cnt==6)
                return;

            List<String> tmp = new ArrayList<>();

            for(int j=0;j<n;j++){
                if(j!=k && compareWords(words.get(k), words.get(j))==cnt)
                    tmp.add(words.get(j));
            }
            if(!tmp.isEmpty())
                words = tmp;

        }

    }

    private int compareWords(String s1, String s2){
        int count = 0;
        for(int i=0;i<6;i++){
            if(s1.charAt(i)==s2.charAt(i))
                count++;
        }

        return count;
    }
}

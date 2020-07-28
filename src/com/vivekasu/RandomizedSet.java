package com.vivekasu;

import java.util.*;

public class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> set;
    List<Integer> arr;
    int ind;
    public RandomizedSet() {
        set = new HashMap<>();
        arr = new ArrayList<>();
        ind = -1;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(set.containsKey(val))
            return false;

        set.put(val, ++ind);
        arr.add(ind, val);
        return true;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(set.containsKey(val)){
            int swapInd = set.get(val);
            int tmp = arr.get(ind);
            arr.set(swapInd, arr.get(ind));
            set.put(tmp, swapInd);
            arr.remove(ind--);
            set.remove(val);
            return true;
        }

        return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {

        Random generator = new Random();

        return arr.get(generator.nextInt(ind+1));

    }
}

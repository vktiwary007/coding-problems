package com.vivekasu;

import java.util.*;



public class IPOShares {

        /*
         * Complete the 'getUnallottedUsers' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. 2D_INTEGER_ARRAY bids
         *  2. INTEGER totalShares
         */

        public static List<Integer> getUnallottedUsers(List<List<Integer>> bids, int totalShares) {
            // Write your code here

            List<Integer> ans = new ArrayList<>();
            Collections.sort(bids, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> a, List<Integer> b){
                    if(a.get(2).equals(b.get(2)))
                        return a.get(3)-b.get(3);

                    return b.get(2) - a.get(2);
                }
            });

            Map<Integer, List<List<Integer>>> map = new HashMap<>();

            for(int i=0; i<bids.size();i++){
                if(!map.containsKey(bids.get(i).get(2))){
                    map.put(bids.get(i).get(2), new ArrayList<>());
                    map.get(bids.get(i).get(2)).add(bids.get(i));
                }
                else{
                    map.get(bids.get(i).get(2)).add(bids.get(i));
                }

            }

            for(int i=0;i<bids.size() && totalShares>0;i++){
                int curr = bids.get(i).get(2);

                List<List<Integer>> order = map.get(curr);
                if(order.size()==1){
                    int nums = order.get(0).get(1);
                    if(nums<=totalShares){
                        totalShares-=nums;
                        order.get(0).set(1, 0);
                    }
                    else{
                        order.get(0).set(1, nums - totalShares );
                    }
                }
                else{
                    for(List<Integer> val: map.get(curr)){
                        int nums = val.get(1);
                        if(nums<=totalShares){
                            totalShares-=nums;
                            val.set(1, 0);
                        }
                        else{
                            val.set(1, nums - totalShares );
                        }
                    }
                }

            }

            return ans;

        }

    }



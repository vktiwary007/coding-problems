package com.vivekasu;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxLevelSumBT {

    public int maxLevelSum(TreeNode root) {

        if(root==null)
            return 1;
        Queue<TreeNode> que = new ArrayDeque<>();
        int lvlsize = 1;
        int level = 0;
        que.add(root);
        int maxsum = Integer.MIN_VALUE;

        int maxlevel = 1;
        while(!que.isEmpty()){

            int nxtlevel = 0;
            int c = lvlsize;
            int currsum = 0;
            for(int i = 0;i<lvlsize;i++){
                TreeNode currNode = que.poll();
                if(currNode.left!=null){
                    que.add(currNode.left);
                    nxtlevel++;
                }
                if(currNode.right!=null){
                    que.add(currNode.right);
                    nxtlevel++;
                }

                currsum = currsum + currNode.val;
            }
            if(currsum>maxsum){
                maxsum = currsum;
                maxlevel = level+1;
            }

            lvlsize = nxtlevel;
            level++;


        }
        return maxlevel;

    }
}

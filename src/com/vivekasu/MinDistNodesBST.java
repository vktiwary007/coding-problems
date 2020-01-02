package com.vivekasu;

public class MinDistNodesBST {

    int diff ;
    Integer prev;
    public int minDiffInBST(TreeNode root) {

        diff = Integer.MAX_VALUE;
        prev = null;
        mindiff(root);
        return diff;
    }


    public void mindiff(TreeNode node){

        if(node==null)
            return;
        mindiff(node.left);
        if(prev!=null)
            diff = Math.min(Math.abs(prev-node.val), diff);
        prev = node.val;
        mindiff(node.right);

    }
}

package com.vivekasu;

public class DiameterBT {

    int val;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
            return 0;

        TreeNode r = root;
        val = Integer.MIN_VALUE;
        getdiameter(r);
        return val-1;
    }


    public int getdiameter(TreeNode root){

        if(root==null)
            return 0;

        int rightlen =getdiameter(root.right);
        int leftlen = getdiameter(root.left);
        val = Math.max(val, rightlen+leftlen+1);

        return 1 + Math.max(rightlen,leftlen);
    }
}

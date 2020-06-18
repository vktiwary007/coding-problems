package com.vivekasu;

public class CountNodesBT {

    public int countNodes(TreeNode root) {

        if(root==null)
            return 0;

        return count(root);
    }


    public int count(TreeNode root){

        if(root==null)
            return 0;

        return 1 + count(root.left) + count(root.right);

    }
}

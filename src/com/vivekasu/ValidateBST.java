package com.vivekasu;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {

        if(root==null)
            return true;

        int maxval = root.val;
        Integer lower = null;
        Integer upper = null;
        return checkBST(root, lower, upper);
    }


    public boolean checkBST(TreeNode root, Integer lower, Integer upper){

        if(root==null)
            return true;

        if(lower!=null && root.val<=lower)
            return false;

        if(upper!=null && root.val>=upper)
            return false;

        return checkBST(root.left, lower, root.val) && checkBST(root.right, root.val, upper);


    }
}

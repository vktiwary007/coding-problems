package com.vivekasu;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;

        return checkSymmetry(root.left, root.right);
    }


    public boolean checkSymmetry(TreeNode node1, TreeNode node2){
        if(node1==null && node2==null)
            return true;

        if(node1==null || node2==null)
            return false;

        return node1.val==node2.val && checkSymmetry(node1.left, node2.right) && checkSymmetry(node1.right, node2.left);
    }
}

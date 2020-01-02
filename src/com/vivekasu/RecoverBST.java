package com.vivekasu;

public class RecoverBST {

    TreeNode x = null, y = null, pred = null;
    public void swapNodes(TreeNode n1, TreeNode n2){

        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;

    }

    public void inorderGetSwapNodes(TreeNode root){
        if(root==null)
            return;

        inorderGetSwapNodes(root.left);
        if(pred!=null && root.val<pred.val){
            x = root;
            if(y==null){
                y = pred;
            }
            else
                return;
        }
        pred = root;
        inorderGetSwapNodes(root.right);
    }

    public void recoverTree(TreeNode root) {

        inorderGetSwapNodes(root);
        swapNodes(x,y);
    }
}

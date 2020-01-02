package com.vivekasu;

public class LcaBT {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null)
            return null;

        if(root.val==p.val || root.val==q.val){
            return root;
        }

        TreeNode leftlca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightlca = lowestCommonAncestor(root.right, p, q);

        if(leftlca!=null && rightlca!=null)
            return root;

        return leftlca!=null?leftlca:rightlca;


    }
}

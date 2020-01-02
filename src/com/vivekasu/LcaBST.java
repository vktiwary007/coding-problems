package com.vivekasu;

public class LcaBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p==null || q==null)
            return root;

        if(root==null)
            return null;

        if(p.val<root.val && q.val>root.val)
            return root;

        if(p.val==root.val || q.val==root.val)
            return root;

        TreeNode leftlca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightlca = lowestCommonAncestor(root.right, p, q);

        if(leftlca!=null && rightlca!=null)
            return root;

        return leftlca!=null?leftlca:rightlca;

    }
}

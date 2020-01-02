package com.vivekasu;

public class MinDepthBT {

    public int minDepth(TreeNode root) {

        if(root==null)
            return 0;
        if(root.left==null && root.right!=null)
            return 1 + minDepth(root.right);

        if(root.right==null && root.left!=null)
            return 1+minDepth(root.left);

        int ldepth = 1+minDepth(root.left);
        int rdepth = 1+minDepth(root.right);

        return Math.min(ldepth, rdepth);
    }
}

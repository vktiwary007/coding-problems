package com.vivekasu;

public class MaxDepthBT {

    public int maxDepth(TreeNode root) {

        if(root==null)
            return 0;

        int leftdepth = 1 + maxDepth(root.left);
        int rightdepth = 1+ maxDepth(root.right);

        return Math.max(leftdepth, rightdepth);
    }
}

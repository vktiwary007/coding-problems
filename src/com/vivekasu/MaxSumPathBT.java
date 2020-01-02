package com.vivekasu;

public class MaxSumPathBT {

    int sum;

    public int maxPathSum(TreeNode root) {

        if(root==null)
            return 0;

        sum = Integer.MIN_VALUE;
        sumpath(root);
        return sum;
    }

    public int sumpath(TreeNode node){

        if(node==null)
            return 0;

        int sumleft =sumpath(node.left);
        int sumright = sumpath(node.right);

        int maxsum = Math.max(Math.max(sumleft, sumright) + node.val, node.val);
        int subnodemaxsum = Math.max(maxsum, sumleft + sumright + node.val);

        sum = Math.max(sum, subnodemaxsum);
        return maxsum;
    }
}

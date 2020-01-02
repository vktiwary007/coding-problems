package com.vivekasu;

import java.util.HashMap;

public class BinaryTreeFromInorderPostorder {

    HashMap<Integer, Integer> inorderIndex;
    int postInd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        inorderIndex = new HashMap<>();
        int len = postorder.length;
        postInd = len-1;

        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i], i);
        }

        TreeNode root = constructTree(0, len-1, postorder);

        return root;
    }


    public TreeNode constructTree(int start, int end, int[] postorder){

        if(start>end)
            return null;

        TreeNode node = new TreeNode(postorder[postInd--]);
        if(start==end)
            return node;

        int curInd = inorderIndex.get(node.val);
        //for postorder, recur right as we are decreasing index of root
        node.right = constructTree(curInd+1, end, postorder);
        node.left = constructTree(start, curInd-1, postorder);

        return node;

    }

}

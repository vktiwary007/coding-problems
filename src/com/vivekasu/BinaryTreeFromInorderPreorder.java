package com.vivekasu;

import java.util.HashMap;

public class BinaryTreeFromInorderPreorder {

    HashMap<Integer, Integer> inorderIndex;
    int preInd;
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        inorderIndex = new HashMap<>();
        preInd = 0;
        for(int i=0;i<inorder.length;i++){
            inorderIndex.put(inorder[i], i);
        }

        int len = preorder.length;
        TreeNode root = constructTree(0, len-1, preorder);

        return root;
    }


    public TreeNode constructTree(int start, int end, int[] preorder){

        if(start>end )
            return null;

        TreeNode node = new TreeNode(preorder[preInd++]);
        if(start==end)
            return node;

        int curInd = inorderIndex.get(node.val);
        node.left = constructTree(start, curInd-1, preorder);
        node.right = constructTree(curInd+1, end, preorder);

        return node;

    }
}

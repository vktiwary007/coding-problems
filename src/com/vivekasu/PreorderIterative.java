package com.vivekasu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderIterative {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        if(root==null)
            return preorder;

        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        st.push(node);

        while(!st.isEmpty()){

            node = st.pop();
            preorder.add(node.val);
            if(node.right!=null)
                st.push(node.right);

            if(node.left!=null)
                st.push(node.left);

        }

        return preorder;

    }
}

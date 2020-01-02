package com.vivekasu;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        if(root==null)
            return ans;
        rightview(root, ans, 0);

        return ans;

    }

    public void rightview(TreeNode root, List<Integer> ans, int level){

        if(root==null)
            return;

        if(ans.size()<=level)
            ans.add(level, root.val);

        rightview(root.right, ans, level+1);
        rightview(root.left, ans, level+1);

    }
}

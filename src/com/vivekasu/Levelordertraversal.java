package com.vivekasu;

import java.util.*;

public class Levelordertraversal {

    public static void main(String[] args){

        TreeNode t1 = new TreeNode(-10);
        t1.right = new TreeNode(20);
        t1.left = new TreeNode(9);
        t1.right.right =  new TreeNode(7);
        t1.right.left = new TreeNode(15);

        t1.right.left.left = new TreeNode(12);
        t1.right.left.right = new TreeNode(32);
        /*TreeNode t2 = new TreeNode(1);
        t2.right =  new TreeNode(2);
        t2.left = new TreeNode(3);*/
        System.out.println("op: "+maxPathSum(t1));
        /*List<List<Integer>>  testlevel = levelOrder(t1);
        for(List<Integer> l1: testlevel){
            for(int vals:l1){
                System.out.println(vals);
            }
        }*/

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelTree = new ArrayList<>();
        if(root==null)
            return levelTree;
        Queue<TreeNode> que = new ArrayDeque<>();
        int lvlsize = 1;
        int level = 0;
        que.add(root);

        while(!que.isEmpty()){

            List<Integer> arrlevel = new ArrayList<>();
            int nxtlevel = 0;
            int c = lvlsize;
            for(int i = 0;i<lvlsize;i++){
                TreeNode currNode = que.poll();
                if(currNode.left!=null){
                    que.add(currNode.left);
                    nxtlevel++;
                }
                if(currNode.right!=null){
                    que.add(currNode.right);
                    nxtlevel++;
                }

                arrlevel.add(currNode.val);
                arrlevel.add(currNode.val);
            }
            lvlsize = nxtlevel;
            levelTree.add(level,arrlevel);
            level++;

        }
        return levelTree;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> levelTree = new ArrayList<>();
        if(root==null)
            return levelTree;
        Queue<TreeNode> que = new ArrayDeque<>();
        int lvlsize = 1;
        int level = 0;
        que.add(root);
        boolean zigzag = false;
        while(!que.isEmpty()){

            List<Integer> arrlevel = new ArrayList<>();
            int nxtlevel = 0;
            int c = lvlsize;
            for(int i = 0;i<lvlsize;i++){
                TreeNode currNode = que.poll();
                if(currNode.left!=null){
                    que.add(currNode.left);
                    nxtlevel++;
                }
                if(currNode.right!=null){
                    que.add(currNode.right);
                    nxtlevel++;
                }
                arrlevel.add(currNode.val);
            }
            if(zigzag){
                Collections.reverse(arrlevel);
                levelTree.add(level,arrlevel);
                zigzag = !zigzag;
            }
            else{
                levelTree.add(level,arrlevel);
                zigzag = !zigzag;
            }

            lvlsize = nxtlevel;

            level++;

        }
        return levelTree;

    }

    public static int maxLevelSum(TreeNode root) {

        if(root==null)
            return 1;
        Queue<TreeNode> que = new ArrayDeque<>();
        int lvlsize = 1;
        int level = 0;
        que.add(root);
        int maxsum = Integer.MIN_VALUE;
        int currsum = 0;
        int maxlevel = 1;
        while(!que.isEmpty()){

            int nxtlevel = 0;
            int c = lvlsize;
            for(int i = 0;i<lvlsize;i++){
                TreeNode currNode = que.poll();
                if(currNode.left!=null){
                    que.add(currNode.left);
                    nxtlevel++;
                }
                if(currNode.right!=null){
                    que.add(currNode.right);
                    nxtlevel++;
                }

                currsum = currsum + currNode.val;
            }

            lvlsize = nxtlevel;
            level++;
            if(currsum>maxsum){
                maxsum = currsum;
                maxlevel = level;
            }

        }
        return maxlevel;

    }


    static int sum;
    public static int maxPathSum(TreeNode root) {

        if(root==null)
            return 0;

        sum = 0;
        sumpath(root);
        return sum;
    }

    public static int sumpath(TreeNode node){
        if(node==null)
            return 0;

        int sumleft =sumpath(node.left);
        int sumright = sumpath(node.right);

        int maxsum = Math.max(Math.max(sumleft, sumright) + node.val, node.val);
        int subnodemaxsum = Math.max(maxsum, sumleft + sumright + node.val);

        sum = Math.max(sum, subnodemaxsum);
        return maxsum;
    }



    public static boolean checkSubtree(TreeNode s, TreeNode t){

        if(s==null && t==null)
            return true;

        if(s!=null && t==null)
            return true;
        if(s==null && t!=null)
            return false;

        if(s.val!=t.val){
            checkSubtree(s.left,t);
            checkSubtree(s.right,t);
        }else{
            checkSubtree(s.left, t.left);
            checkSubtree(s.right, t.right);
        }

        return true;

    }

    static int val;
    public static int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
            return 0;

        TreeNode r = root;
        val = Integer.MIN_VALUE;
        return getdiameter(r);
    }


    public static int getdiameter(TreeNode root){

        if(root==null)
            return 0;

        int rightlen =getdiameter(root.right);
        int leftlen = getdiameter(root.left);
        val = Math.max(val, rightlen+leftlen+1);

        return 1 + Math.max(rightlen,leftlen);
    }
}

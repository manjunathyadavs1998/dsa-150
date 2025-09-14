package com.dsa.top.dsa_problems.trees;


public class SymmetricTrees {

    public boolean isSymmetric(TreeNode root){
        if(root==null||(root.left==null&&root.right==null)) return true;
        return bfs(root.left, root.right);
    }

    private boolean bfs(TreeNode left, TreeNode right){

        if(left==null ||right==null){
            return left==right;
        }
        return left.val==right.val && bfs(left.left,right.right)&&bfs(left.right, right.left);
    }
}

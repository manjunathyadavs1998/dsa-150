package com.dsa.top.dsa_problems.trees;

public class DiameterOfTree {
    private static int diameter;

    public static int diameter(TreeNode root){
        height(root);
        return diameter;
    }

    private static int height(TreeNode root) {
        if(root==null )return 0;
        int left=height(root.left);
        int right=height(root.right);
        diameter=Math.max(diameter, left+right);
        return 1+Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        System.out.println(diameter(root));
    }
}

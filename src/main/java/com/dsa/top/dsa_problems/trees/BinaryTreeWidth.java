package com.dsa.top.dsa_problems.trees;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    long level;
    TreeNode node;
    Pair(TreeNode node, long level){
        this.node=node;
        this.level=level;
    }
}
public class BinaryTreeWidth {

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;
        Queue<Pair>q=new LinkedList<>();
        int maxWidth=0;
        q.add(new Pair(root,1));
        while (!q.isEmpty()){
            int size=q.size();
            long start=q.peek().level;
            long end=start;
            for(int i=0; i<size; i++){
               Pair p=q.poll();
               long idx=p.level-start;
               end=p.level;
               if(p.node.left!=null)q.add(new Pair(p.node.left, 2*idx));

               if(p.node.right!=null)q.add(new Pair(p.node.right, 2*idx+1));
               maxWidth = Math.max(maxWidth, (int) (end - start + 1));
            }

        }
        return maxWidth;
    }

    public static void main(String[] args) {
        // Manually creating nodes
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        // root.right.left = null (skipped)
        root.right.right = new TreeNode(9);

        // Test BinaryTreeWidth
        BinaryTreeWidth btw = new BinaryTreeWidth();
        int width = btw.widthOfBinaryTree(root);

        System.out.println("Maximum Width of Binary Tree = " + width);
    }
}

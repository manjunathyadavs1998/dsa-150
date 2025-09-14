package com.dsa.top.dsa_problems.trees;

import java.util.*;


public class BoundaryTraversal {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val);

        // Left boundary
        addLeftBoundary(root.left, res);

        // Leaf nodes
        addLeaves(root, res);

        // Right boundary
        List<Integer> right = new ArrayList<>();
        addRightBoundary(root.right, right);
        Collections.reverse(right);
        res.addAll(right);

        return res;
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
    }

    private void addLeaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    // Driver
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);

        BoundaryTraversal bt = new BoundaryTraversal();
        System.out.println(bt.boundaryOfBinaryTree(root));
        // Output: [20, 8, 4, 10, 14, 25, 22]
    }
}

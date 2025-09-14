package com.dsa.top.dsa_problems.trees;

public class MaxPathSum {
    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(0, dfs(node.left));   // drop negative paths
        int right = Math.max(0, dfs(node.right));

        // Path through current node
        maxPath = Math.max(maxPath, node.val + left + right);

        // Return best single path (cannot take both sides when returning)
        return node.val + Math.max(left, right);
    }
}

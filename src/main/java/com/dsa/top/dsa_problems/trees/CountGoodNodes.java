package com.dsa.top.dsa_problems.trees;

import java.util.*;

public class CountGoodNodes {
    public static int goodNodes(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, root.val));
        int count = 0;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            TreeNode node = current.node;
            int maxSoFar = current.max;

            if (node.val >= maxSoFar) {
                count++;
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, Math.max(maxSoFar, node.val)));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, Math.max(maxSoFar, node.val)));
            }
        }

        return count;
    }

    static class Pair {
        TreeNode node;
        int max;
        Pair(TreeNode node, int max) {
            this.node = node;
            this.max = max;
        }
    }
}


package com.dsa.top.dsa_problems.trees;

import java.util.*;

class PairNode {
    TreeNode node;
    int col;   // vertical index
    int row;   // level
    PairNode(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}


public class VerticalOrder {
    public List<List<Integer>> verticalLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<PairNode> queue = new LinkedList<>();
        Map<Integer, List<int[]>> nodeMap = new HashMap<>();
        // col -> list of {row, val}

        int minCol = 0, maxCol = 0;

        queue.offer(new PairNode(root, 0, 0));

        while (!queue.isEmpty()) {
            PairNode curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col, row = curr.row;

            if (!nodeMap.containsKey(col)) {
                nodeMap.put(col, new ArrayList<>());
            }
            nodeMap.get(col).add(new int[]{row, node.val});
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null) {
                queue.offer(new PairNode(node.left, col - 1, row + 1));
            }
            if (node.right != null) {
                queue.offer(new PairNode(node.right, col + 1, row + 1));
            }
        }

        // Build result: sort by row first, then value order
        for (int c = minCol; c <= maxCol; c++) {
            List<int[]> list = nodeMap.get(c);
            list.sort((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]); // same row → smaller val first
                return Integer.compare(a[0], b[0]); // sort by row
            });
            List<Integer> colVals = new ArrayList<>();
            for (int[] arr : list) colVals.add(arr[1]);
            res.add(colVals);
        }

        return res;
    }
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<PairNode> queue = new LinkedList<>();
        Map<Integer, int[]> nodeMap = new HashMap<>();
        // col -> {row, value}
        int minCol = 0, maxCol = 0;

        queue.offer(new PairNode(root, 0, 0));

        while (!queue.isEmpty()) {
            PairNode curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col, row = curr.row;

            // overwrite: bottom-most (max row) stays
            if (!nodeMap.containsKey(col) || nodeMap.get(col)[0] <= row) {
                nodeMap.put(col, new int[]{row, node.val});
            }

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (node.left != null) queue.offer(new PairNode(node.left, col - 1, row + 1));
            if (node.right != null) queue.offer(new PairNode(node.right, col + 1, row + 1));
        }

        for (int c = minCol; c <= maxCol; c++) {
            res.add(nodeMap.get(c)[1]);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        VerticalOrder z=new VerticalOrder();
        System.out.println(z.verticalLevelOrder(root));

        System.out.println(z.bottomView(root));
    }
}


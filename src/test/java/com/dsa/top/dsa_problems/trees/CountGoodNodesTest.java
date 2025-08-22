package com.dsa.top.dsa_problems.trees;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountGoodNodesTest {

    @Test
    void testSingleNode() {
        TreeNode root = new TreeNode(5);
        assertEquals(1, CountGoodNodes.goodNodes(root));
    }

    @Test
    void testAllGoodNodes() {
        // Tree:
        //       3
        //      / \
        //     1   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        assertEquals(2, CountGoodNodes.goodNodes(root));
    }

    @Test
    void testSomeBadNodes() {
        // Tree:
        //       3
        //      / \
        //     1   4
        //        / \
        //       1   5
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        assertEquals(3, CountGoodNodes.goodNodes(root));
    }

    @Test
    void testStrictlyDecreasingTree() {
        // Tree:
        //    5
        //   /
        //  4
        // /
        //3
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);

        assertEquals(1, CountGoodNodes.goodNodes(root));
    }

    @Test
    void testStrictlyIncreasingTree() {
        // Tree:
        //    1
        //     \
        //      2
        //       \
        //        3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        assertEquals(3, CountGoodNodes.goodNodes(root));
    }
}

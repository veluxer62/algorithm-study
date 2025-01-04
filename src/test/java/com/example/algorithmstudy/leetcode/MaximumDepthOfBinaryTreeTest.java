package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthOfBinaryTreeTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, return its maximum depth.

    A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: 3
    Example 2:

    Input: root = [1,null,2]
    Output: 2


    Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100

     */

    @Test
    public void test_maxDepth() {
        var root = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        var actual = sut.maxDepth(root);
        assertEquals(3, actual);

        root = TreeNode.of(new Integer[]{1, null, 2});
        actual = sut.maxDepth(root);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            return preOrder(root, 0);
        }

        public int preOrder(TreeNode root, int depth) {
            if (root == null) return depth;

            var left = preOrder(root.left, depth);
            var right = preOrder(root.right, depth);

            return Math.max(left, right) + 1;
        }
    }
}

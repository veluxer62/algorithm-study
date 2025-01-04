package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDepthOfBinaryTreeTest {
    private final Solution sut = new Solution();

    /*

    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

    Note: A leaf is a node with no children.



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: 2
    Example 2:

    Input: root = [2,null,3,null,4,null,5,null,6]
    Output: 5


    Constraints:

    The number of nodes in the tree is in the range [0, 105].
    -1000 <= Node.val <= 1000

     */

    @Test
    public void test_minDepth() {
        var root = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        var actual = sut.minDepth(root);
        assertEquals(2, actual);

        root = TreeNode.of(new Integer[]{2, null, 3, null, null, null, 4, null, null, null, null, null, null, null, 5, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 6});
        actual = sut.minDepth(root);
        assertEquals(5, actual);
    }

    private static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int leftDepth = (root.left != null) ? minDepth(root.left) : Integer.MAX_VALUE;
            int rightDepth = (root.right != null) ? minDepth(root.right) : Integer.MAX_VALUE;

            return Math.min(leftDepth, rightDepth) + 1;
        }
    }
}

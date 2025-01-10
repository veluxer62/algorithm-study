package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InvertBinaryTreeTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, invert the tree, and return its root.



    Example 1:


    Input: root = [4,2,7,1,3,6,9]
    Output: [4,7,2,9,6,3,1]
    Example 2:


    Input: root = [2,1,3]
    Output: [2,3,1]
    Example 3:

    Input: root = []
    Output: []


    Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

     */

    @Test
    public void test_invertTree() {
        var root = TreeNode.of(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        var actual = sut.invertTree(root);
        assertEquals(
                TreeNode.of(new Integer[]{4, 7, 2, 9, 6, 3, 1}),
                actual
        );

        root = TreeNode.of(new Integer[]{2,1,3});
        actual = sut.invertTree(root);
        assertEquals(
                TreeNode.of(new Integer[]{2,3,1}),
                actual
        );

        root = null;
        actual = sut.invertTree(root);
        assertNull(actual);
    }

    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;

            var left = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(left);

            return root;
        }
    }
}

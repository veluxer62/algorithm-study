package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBinaryTreeTest {
    private final Solution sut = new Solution();

    /*

    Given a binary tree, determine if it is height-balanced.



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: true
    Example 2:


    Input: root = [1,2,2,3,3,null,null,4,4]
    Output: false
    Example 3:

    Input: root = []
    Output: true


    Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -104 <= Node.val <= 104

     */

    @Test
    public void test_isBalanced() {
        var root = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        var actual = sut.isBalanced(root);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});
        actual = sut.isBalanced(root);
        assertFalse(actual);

        root = null;
        actual = sut.isBalanced(root);
        assertTrue(actual);
    }

    private static class Solution {
        public boolean isBalanced(TreeNode root) {
            return checkHeight(root) != -1;
        }

        private int checkHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int leftHeight = checkHeight(node.left);
            int rightHeight = checkHeight(node.right);

            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}

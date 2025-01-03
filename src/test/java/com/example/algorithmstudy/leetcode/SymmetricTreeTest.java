package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SymmetricTreeTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



    Example 1:


    Input: root = [1,2,2,3,4,4,3]
    Output: true
    Example 2:


    Input: root = [1,2,2,null,3,null,3]
    Output: false


    Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    -100 <= Node.val <= 100

     */

    @Test
    public void test_isSymmetric() {
        var root = TreeNode.of(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        var actual = sut.isSymmetric(root);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{1, 2, 2, null, 3, null, 3});
        actual = sut.isSymmetric(root);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSame(root.left, root.right);
        }

        private boolean isSame(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
    }
}

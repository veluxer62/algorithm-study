package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PathSumTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

    A leaf is a node with no children.



    Example 1:


    Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    Output: true
    Explanation: The root-to-leaf path with the target sum is shown.
    Example 2:


    Input: root = [1,2,3], targetSum = 5
    Output: false
    Explanation: There are two root-to-leaf paths in the tree:
    (1 --> 2): The sum is 3.
    (1 --> 3): The sum is 4.
    There is no root-to-leaf path with sum = 5.
    Example 3:

    Input: root = [], targetSum = 0
    Output: false
    Explanation: Since the tree is empty, there are no root-to-leaf paths.


    Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -1000 <= Node.val <= 1000
    -1000 <= targetSum <= 1000

     */

    @Test
    public void test_pathSum() {
        var root = TreeNode.of(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        var targetSum = 22;
        var actual = sut.hasPathSum(root, targetSum);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{1, 2, 3});
        targetSum = 5;
        actual = sut.hasPathSum(root, targetSum);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return calc(root, targetSum);
        }

        private boolean calc(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (root.left == null && root.right == null && root.val == targetSum) return true;

            var remain = targetSum - root.val;

            var left = calc(root.left, remain);
            var right = calc(root.right, remain);

            return left || right;
        }
    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoSumIVInputIsABSTTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.



    Example 1:


    Input: root = [5,3,6,2,4,null,7], k = 9
    Output: true
    Example 2:


    Input: root = [5,3,6,2,4,null,7], k = 28
    Output: false


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -104 <= Node.val <= 104
    root is guaranteed to be a valid binary search tree.
    -105 <= k <= 105

     */

    @Test
    public void test_findTarget() {
        var root = TreeNode.of(new Integer[]{5,3,6,2,4,null,7});
        var k = 9;
        var actual = sut.findTarget(root, k);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{5,3,6,2,4,null,7});
        k = 28;
        actual = sut.findTarget(root, k);
        assertFalse(actual);

        root = TreeNode.of(new Integer[]{2,1,3});
        k = 3;
        actual = sut.findTarget(root, k);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{2,1,3});
        k = 1;
        actual = sut.findTarget(root, k);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            var set = new HashSet<Integer>();
            return dfs(root, set, k);
        }

        private boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
            if (root == null) return false;

            if (set.contains(k - root.val)) return true;
            set.add(root.val);

            return dfs(root.left, set, k) || dfs(root.right, set, k);
        }
    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumAbsoluteDifferenceInBSTTest {
    /*

    Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.



    Example 1:


    Input: root = [4,2,6,1,3]
    Output: 1
    Example 2:


    Input: root = [1,0,48,null,null,12,49]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 105


     */


    @Test
    public void test_getMinimumDifference() {
        var root = TreeNode.of(new Integer[]{4,2,6,1,3});
        var actual = new Solution().getMinimumDifference(root);
        assertEquals(1, actual);

        root = TreeNode.of(new Integer[]{1,0,48,null,null,12,49});
        actual = new Solution().getMinimumDifference(root);
        assertEquals(1, actual);

        root = TreeNode.of(new Integer[]{236,104,701,null,227,null,911});
        actual = new Solution().getMinimumDifference(root);
        assertEquals(9, actual);
    }

    private static class Solution {
        private int min = Integer.MAX_VALUE;
        private Integer prev = null;

        public int getMinimumDifference(TreeNode root) {
            if (root == null) return min;

            getMinimumDifference(root.left);

            if (prev != null) {
                min = Math.min(min, root.val - prev);
            }

            prev = root.val;

            getMinimumDifference(root.right);

            return min;
        }
    }
}

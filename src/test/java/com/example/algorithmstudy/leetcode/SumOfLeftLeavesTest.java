package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumOfLeftLeavesTest {
    /*

    Given the root of a binary tree, return the sum of all left leaves.

    A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: 24
    Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
    Example 2:

    Input: root = [1]
    Output: 0


    Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    -1000 <= Node.val <= 1000

     */

    @Test
    public void test_sumOfLeftLeaves() {
        var root = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        var actual = new Solution().sumOfLeftLeaves(root);
        assertEquals(24, actual);

        root = TreeNode.of(new Integer[]{1});
        actual = new Solution().sumOfLeftLeaves(root);
        assertEquals(0, actual);
    }

    private static class Solution {
        private int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            preOrder(root, null);
            return sum;
        }

        private void preOrder(TreeNode root, String position) {
            if (root == null) return;

            preOrder(root.left, "left");

            if (root.left == null && root.right == null && "left".equals(position)) {
                sum += root.val;
            }

            preOrder(root.right, "right");
        }
    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountCompleteTreeNodesTest {

    /*

    Given the root of a complete binary tree, return the number of the nodes in the tree.

    According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

    Design an algorithm that runs in less than O(n) time complexity.



    Example 1:


    Input: root = [1,2,3,4,5,6]
    Output: 6
    Example 2:

    Input: root = []
    Output: 0
    Example 3:

    Input: root = [1]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [0, 5 * 104].
    0 <= Node.val <= 5 * 104
    The tree is guaranteed to be complete.

     */

    @Test
    public void test_countNodes() {
        var root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, 6});
        var actual = new Solution().countNodes(root);
        assertEquals(6, actual);

        root = null;
        actual = new Solution().countNodes(root);
        assertEquals(0, actual);

        root = TreeNode.of(new Integer[]{1});
        actual = new Solution().countNodes(root);
        assertEquals(1, actual);
    }

    private static class Solution {
        private int count = 0;

        public int countNodes(TreeNode root) {
            if (root == null) return 0;

            searchNode(root);

            return count;
        }

        private void searchNode(TreeNode root) {
            if (root == null) return;

            count++;

            if (root.left != null) searchNode(root.left);
            if (root.right != null) searchNode(root.right);
        }
    }
}

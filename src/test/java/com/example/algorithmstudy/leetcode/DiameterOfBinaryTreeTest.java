package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiameterOfBinaryTreeTest {

    /*

    Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.



    Example 1:


    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
    Example 2:

    Input: root = [1,2]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -100 <= Node.val <= 100

     */

    @Test
    public void test_diameterOfBinaryTree() {
        var root = TreeNode.of(new Integer[]{1, 2, 3});
        var actual = new Solution().diameterOfBinaryTree(root);
        assertEquals(2, actual);

        root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5});
        actual = new Solution().diameterOfBinaryTree(root);
        assertEquals(3, actual);

        root = TreeNode.of(new Integer[]{1, 2});
        actual = new Solution().diameterOfBinaryTree(root);
        assertEquals(1, actual);
    }

    private static class Solution {
        private int diameter = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            search(root);
            return diameter;
        }

        private int search(TreeNode root) {
            if (root == null) return 0;

            int left = search(root.left);
            int right = search(root.right);

            diameter = Math.max(diameter, left + right);

            return Math.max(left, right) + 1;
        }
    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeInorderTraversalTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, return the inorder traversal of its nodes' values.



    Example 1:

    Input: root = [1,null,2,3]

    Output: [1,3,2]

    Explanation:



    Example 2:

    Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

    Output: [4,2,6,5,7,1,3,9,8]

    Explanation:



    Example 3:

    Input: root = []

    Output: []

    Example 4:

    Input: root = [1]

    Output: [1]



    Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

     */

    @Test
    public void test_inorderTraversal() {
        var root = TreeNode.of(new Integer[]{1, null, 2, null, null, 3});
        var actual = sut.inorderTraversal(root);
        assertEquals(
                List.of(1, 3, 2),
                actual
        );

        root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        actual = sut.inorderTraversal(root);
        assertEquals(
                List.of(4, 2, 6, 5, 7, 1, 3, 9, 8),
                actual
        );
    }

    @Test
    public void test_inorderTraversal2() {
        var root = TreeNode.of(new Integer[]{1, null, 2, null, null, 3});
        var actual = sut.inorderTraversal2(root);
        assertEquals(
                List.of(1, 3, 2),
                actual
        );

        root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        actual = sut.inorderTraversal2(root);
        assertEquals(
                List.of(4, 2, 6, 5, 7, 1, 3, 9, 8),
                actual
        );
    }

    private static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderHelper(root, result);
            return result;
        }

        private void inorderHelper(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }

            inorderHelper(node.left, result);
            result.add(node.val);
            inorderHelper(node.right, result);
        }

        public List<Integer> inorderTraversal2(TreeNode root) {
            var result = new ArrayList<Integer>();
            var stack = new ArrayDeque<TreeNode>();
            var current = root;

            while (current != null || !stack.isEmpty()) {
                while(current != null) {
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }

            return result;
        }

    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePreorderTraversalTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, return the preorder traversal of its nodes' values.



    Example 1:

    Input: root = [1,null,2,3]

    Output: [1,2,3]

    Explanation:



    Example 2:

    Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

    Output: [1,2,4,5,6,7,3,8,9]

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


    Follow up: Recursive solution is trivial, could you do it iteratively?

     */

    @Test
    public void test_preorderTraversal() {
        var root = TreeNode.of(new Integer[]{1, null, 2, null, null, 3});
        var actual = sut.preorderTraversal(root);
        assertEquals(
                List.of(1, 2, 3),
                actual
        );

        root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        actual = sut.preorderTraversal(root);
        assertEquals(
                List.of(1, 2, 4, 5, 6, 7, 3, 8, 9),
                actual
        );

        root = null;
        actual = sut.preorderTraversal(root);
        assertEquals(
                List.of(),
                actual
        );

        root = TreeNode.of(new Integer[]{1});
        actual = sut.preorderTraversal(root);
        assertEquals(
                List.of(1),
                actual
        );
    }

    private static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            var result = new ArrayList<Integer>();
            preorder(root, result);
            return result;
        }

        private void preorder(TreeNode root, List<Integer> res) {
            if (root == null) return;

            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }
    }
}

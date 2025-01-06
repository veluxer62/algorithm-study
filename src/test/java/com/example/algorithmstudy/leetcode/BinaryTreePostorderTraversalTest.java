package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePostorderTraversalTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, return the postorder traversal of its nodes' values.



    Example 1:

    Input: root = [1,null,2,3]

    Output: [3,2,1]

    Explanation:



    Example 2:

    Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

    Output: [4,6,7,5,2,9,8,3,1]

    Explanation:



    Example 3:

    Input: root = []

    Output: []

    Example 4:

    Input: root = [1]

    Output: [1]



    Constraints:

    The number of the nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100


     */

    @Test
    public void test_postorderTraversal() {
        var root = TreeNode.of(new Integer[]{1, null, 2, null, null, 3});
        var actual = sut.postorderTraversal(root);
        assertEquals(
                List.of(3, 2, 1),
                actual
        );

        root = TreeNode.of(new Integer[]{1, 2, 3, 4, 5, null, 8, null, null, 6, 7, null, null, 9});
        actual = sut.postorderTraversal(root);
        assertEquals(
                List.of(4, 6, 7, 5, 2, 9, 8, 3, 1),
                actual
        );

        root = null;
        actual = sut.postorderTraversal(root);
        assertEquals(
                List.of(),
                actual
        );

        root = TreeNode.of(new Integer[]{1});
        actual = sut.postorderTraversal(root);
        assertEquals(
                List.of(1),
                actual
        );
    }

    private static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            var result = new ArrayList<Integer>();
            postorder(root, result);
            return result;
        }

        private void postorder(TreeNode root, List<Integer> res) {
            if (root == null) return;

            postorder(root.left, res);
            postorder(root.right, res);
            res.add(root.val);
        }
    }
}

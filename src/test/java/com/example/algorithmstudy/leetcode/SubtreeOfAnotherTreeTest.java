package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubtreeOfAnotherTreeTest {
    private final Solution sut = new Solution();

    /*

    Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

    A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.



    Example 1:


    Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    Output: true
    Example 2:


    Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    Output: false


    Constraints:

    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000].
    -104 <= root.val <= 104
    -104 <= subRoot.val <= 104

     */

    @Test
    public void test_isSubtree() {
        var root = TreeNode.of(new Integer[]{3, 4, 5, 1, 2});
        var subRoot = TreeNode.of(new Integer[]{4, 1, 2});
        var actual = sut.isSubtree(root, subRoot);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0});
        subRoot = TreeNode.of(new Integer[]{4, 1, 2});
        actual = sut.isSubtree(root, subRoot);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) return false;
            if (equals(root, subRoot)) return true;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean equals(TreeNode left, TreeNode right) {
            if (left == null && right == null) return true;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            return equals(left.left, right.left) && equals(left.right, right.right);
        }
    }
}

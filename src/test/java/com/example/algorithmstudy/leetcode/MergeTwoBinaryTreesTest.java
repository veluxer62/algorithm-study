package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoBinaryTreesTest {
    private final Solution sut = new Solution();

    /*

    You are given two binary trees root1 and root2.

    Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

    Return the merged tree.

    Note: The merging process must start from the root nodes of both trees.



    Example 1:


    Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
    Output: [3,4,5,5,4,null,7]
    Example 2:

    Input: root1 = [1], root2 = [1,2]
    Output: [2,2]


    Constraints:

    The number of nodes in both trees is in the range [0, 2000].
    -104 <= Node.val <= 104

     */

    @Test
    public void test_mergeTrees() {
        var root1 = TreeNode.of(new Integer[]{1, 3, 2, 5});
        var root2 = TreeNode.of(new Integer[]{2, 1, 3, null, 4, null, 7});
        var actual = sut.mergeTrees(root1, root2);
        assertEquals(
                TreeNode.of(new Integer[]{3, 4, 5, 5, 4, null, 7}),
                actual
        );

        root1 = TreeNode.of(new Integer[]{1});
        root2 = TreeNode.of(new Integer[]{1, 2});
        actual = sut.mergeTrees(root1, root2);
        assertEquals(
                TreeNode.of(new Integer[]{2, 2}),
                actual
        );
    }

    private static class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return merge(root1, root2);
        }

        private TreeNode merge(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) return null;
            if (root1 == null) return root2;
            if (root2 == null) return root1;

            root1.left = merge(root1.left, root2.left);
            root1.val = root1.val + root2.val;
            root1.right = merge(root1.right, root2.right);
            return root1;
        }
    }
}

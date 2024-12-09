package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTreeToGreaterSumTreeTest {
    private final Solution sut = new Solution();

    /*
     * BST의 각 노드를 자신과 자신보다 더 큰 값을 가진 모든 노드의 합으로 만들어라.
     */

    @Test
    public void test_sumTree() {
        var root = TreeNode.of(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 9});
        var actual = sut.bstToGst(root);
        assertEquals(
                TreeNode.of(new Integer[]{31, 37, 22, 37, 36, 27, 16, null, null, null, 34, null, null, null, 9}),
                actual
        );
    }

    private static class Solution {
        private int val = 0;

        public TreeNode bstToGst(TreeNode root) {
            if (root != null) {
                bstToGst(root.right);
                val += root.val;
                root.val = val;
                bstToGst(root.left);
            }

            return root;
        }
    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SameTreeTest {
    private final Solution sut = new Solution();

    @Test
    public void test_isSameTree() {
        var p = TreeNode.of(new Integer[]{1, 2, 3});
        var q = TreeNode.of(new Integer[]{1, 2, 3});
        var actual = sut.isSameTree(p, q);
        assertTrue(actual);

        p = TreeNode.of(new Integer[]{1, 2});
        q = TreeNode.of(new Integer[]{1, null, 2});
        actual = sut.isSameTree(p, q);
        assertFalse(actual);

        p = TreeNode.of(new Integer[]{1, 2, 1});
        q = TreeNode.of(new Integer[]{1, 1, 2});
        actual = sut.isSameTree(p, q);
        assertFalse(actual);

        p = TreeNode.of(new Integer[]{10, 5, 15});
        q = TreeNode.of(new Integer[]{10, 5, null, null, 15});
        actual = sut.isSameTree(p, q);
        assertFalse(actual);

        p = TreeNode.of(new Integer[]{2, 2, 2, null, 2, null, null, 2});
        q = TreeNode.of(new Integer[]{2, 2, 2, 2, null, 2, null});
        actual = sut.isSameTree(p, q);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            return isSame(p, q);
        }

        private boolean isSame(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;
            if (p.val != q.val) return false;

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}

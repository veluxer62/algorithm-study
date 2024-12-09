package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedBinaryTreeTest {
    private final Solution sut = new Solution();

    /*
     * 이진 트리가 높이 균형인지 판단하라. 높이 균형은 모든 노드의 서브 트리 간의 높이 차이가 1 이하인 것을 말한다.
     */

    @Test
    public void test_isBalanced() {
        var root = TreeNode.of(new Integer[]{1, 9, 20, null, null, 15, 7});
        var actual = sut.isBalanced(root);
        assertTrue(actual);

        root = TreeNode.of(new Integer[]{1,2,3,4,5,null,null,6,7});
        actual = sut.isBalanced(root);
        assertFalse(actual);
    }

    private static class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        private int dfs(TreeNode root) {
            if (root == null) return 0;

            var left = dfs(root.left);
            var right = dfs(root.right);

            if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

            return Math.max(left, right) + 1;
        }
    }
}

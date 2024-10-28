package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestUnivaluePathTest {
    private final Solution sut = new Solution();

    /*
     * 동일한 값을 지닌 가장 긴 경로를 찾아라.
     */

    @Test
    public void test_longestUnivaluePath() {
        var root = TreeNode.of(new Integer[]{3, 4, 3, 1, 1, null, 3});
        var actual = sut.longestUnivaluePath(root);
        assertEquals(2, actual);

        root = TreeNode.of(new Integer[]{1, 6, 5, 6, 6, null, 5});
        actual = sut.longestUnivaluePath(root);
        assertEquals(2, actual);
    }

    private static class Solution {
        private int result = 0;

        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return result;
        }

        private int dfs(TreeNode node) {
            if (node == null) return 0;

            var left = dfs(node.left);
            var right = dfs(node.right);

            if (node.left != null && node.left.val == node.val) {
                left++;
            } else {
                left = 0;
            }

            if (node.right != null && node.right.val == node.val) {
                right++;
            } else {
                right = 0;
            }

            this.result = Math.max(result, left + right);
            return Math.max(left, right);
        }
    }
}

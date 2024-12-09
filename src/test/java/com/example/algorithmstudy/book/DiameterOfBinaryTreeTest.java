package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiameterOfBinaryTreeTest {
    private final Solution sut = new Solution();

    /*
     * 이진 트리에서 두 노드 간 가장 긴 경로의 길이를 출력하라.
     */

    @Test
    public void test_diameterOfBinaryTree() {
        var root = TreeNode.of(new Integer[]{1, 2, 6, 4, 5, null, null});
        var actual = sut.diameterOfBinaryTree(root);
        assertEquals(3, actual);
    }

    private static class Solution {
        private int longest = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return longest;
        }

        private int dfs(TreeNode root) {
            if (root == null) return -1;

            int left = dfs(root.left);
            int right = dfs(root.right);

            this.longest = Math.max(this.longest, left + right + 2);
            return Math.max(left, right) + 1;
        }
    }
}

package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumDepthOfBinaryTreeTest {
    private final Solution sut = new Solution();

    /*
     * 이진 트리의 최대 깊이를 구하라.
     */

    @Test
    public void test_maxDepth() {
        var root = TreeNode.of(new Integer[]{3, 9, 10, null, null, 15, 7});
        var actual = sut.maxDepth(root);
        assertEquals(3, actual);
    }

    @Test
    public void test_maxDepth2() {
        var root = TreeNode.of(new Integer[]{3, 9, 10, null, null, 15, 7});
        var actual = sut.maxDepth2(root);
        assertEquals(3, actual);
    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;

            while (!queue.isEmpty()) {
                depth++;
                var q_size = queue.size();

                for (int i = 0; i < q_size; i++) {
                    var cur = queue.poll();

                    if (cur.left != null) {
                        queue.add(cur.left);
                    }

                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
            }

            return depth;
        }

        public int maxDepth2(TreeNode root) {
            if (root == null) return 0;

            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);

            return Math.max(left, right) + 1;
        }
    }
}

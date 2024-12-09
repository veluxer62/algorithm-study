package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeSumOfBstTest {
    private final Solution sut = new Solution();

    /*
     * 이진 탐색 트리(BST)가 주어졌을 때 low 이상 high 이하의 값을 지닌 노드의 합을 구하라.
     */

    @Test
    public void test_rangeSumBST() {
        var root = TreeNode.of(new Integer[]{10, 5, 15, 3, 6, null, 18});
        var low = 6;
        var high = 15;
        var actual = sut.rangeSumBST(root, low, high);
        assertEquals(31, actual);
    }

    @Test
    public void test_rangeSumBST2() {
        var root = TreeNode.of(new Integer[]{10, 5, 15, 3, 6, null, 18});
        var low = 6;
        var high = 15;
        var actual = sut.rangeSumBST2(root, low, high);
        assertEquals(31, actual);
    }

    @Test
    public void test_rangeSumBST3() {
        var root = TreeNode.of(new Integer[]{10, 5, 15, 3, 6, null, 18});
        var low = 6;
        var high = 15;
        var actual = sut.rangeSumBST3(root, low, high);
        assertEquals(31, actual);
    }

    @Test
    public void test_rangeSumBST4() {
        var root = TreeNode.of(new Integer[]{10, 5, 15, 3, 6, null, 18});
        var low = 6;
        var high = 15;
        var actual = sut.rangeSumBST4(root, low, high);
        assertEquals(31, actual);
    }

    private static class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;

            var result = 0;
            if (low <= root.val && root.val <= high) {
                result = root.val;
            }

            result += rangeSumBST(root.left, low, high);
            result += rangeSumBST(root.right, low, high);

            return result;
        }

        public int rangeSumBST2(TreeNode root, int low, int high) {
            if (root == null) return 0;

            if (root.val > high) {
                return rangeSumBST2(root.left, low, high);
            }

            if (root.val < low) {
                return rangeSumBST2(root.right, low, high);
            }

            return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
        }

        public int rangeSumBST3(TreeNode root, int low, int high) {
            var stack = new ArrayDeque<TreeNode>();
            stack.push(root);

            var result = 0;

            while (!stack.isEmpty()) {
                var node = stack.pop();

                if (node.val > low && node.left != null) {
                    stack.push(node.left);
                }

                if (node.val < high && node.right != null) {
                    stack.push(node.right);
                }

                if (low <= node.val && node.val <= high) {
                    result += node.val;
                }
            }

            return result;
        }

        public int rangeSumBST4(TreeNode root, int low, int high) {
            var queue = new LinkedList<TreeNode>();
            queue.add(root);

            var result = 0;

            while (!queue.isEmpty()) {
                var node = queue.poll();

                if (node.val > low && node.left != null) {
                    queue.add(node.left);
                }

                if (node.val < high && node.right != null) {
                    queue.add(node.right);
                }

                if (low <= node.val && node.val <= high) {
                    result += node.val;
                }
            }

            return result;
        }
    }
}

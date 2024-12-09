package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvertBinaryTreeTest {
    private final Solution sut = new Solution();

    /*
     * 이진 트리를 반전시켜라.
     */

    @Test
    public void test_invertTree() {
        var root = TreeNode.of(new Integer[]{4, 5, 7, 1, 3, 6, 9});
        var actual = sut.invertTree(root);
        assertEquals(
                TreeNode.of(new Integer[]{4, 7, 5, 9, 6, 3, 1}),
                actual
        );
    }

    @Test
    public void test_invertTree2() {
        var root = TreeNode.of(new Integer[]{4, 5, 7, 1, 3, 6, 9});
        var actual = sut.invertTree2(root);
        assertEquals(
                TreeNode.of(new Integer[]{4, 7, 5, 9, 6, 3, 1}),
                actual
        );
    }

    @Test
    public void test_invertTree3() {
        var root = TreeNode.of(new Integer[]{4, 5, 7, 1, 3, 6, 9});
        var actual = sut.invertTree3(root);
        assertEquals(
                TreeNode.of(new Integer[]{4, 7, 5, 9, 6, 3, 1}),
                actual
        );
    }

    @Test
    public void test_invertTree4() {
        var root = TreeNode.of(new Integer[]{4, 5, 7, 1, 3, 6, 9});
        var actual = sut.invertTree4(root);
        assertEquals(
                TreeNode.of(new Integer[]{4, 7, 5, 9, 6, 3, 1}),
                actual
        );
    }

    @Test
    public void test_invertTree5() {
        var root = TreeNode.of(new Integer[]{4, 5, 7, 1, 3, 6, 9});
        var actual = sut.invertTree5(root);
        assertEquals(
                TreeNode.of(new Integer[]{4, 7, 5, 9, 6, 3, 1}),
                actual
        );
    }

    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;

            var newNode = new TreeNode(root.val);
            newNode.left = invertTree(root.right);
            newNode.right = invertTree(root.left);

            return newNode;
        }

        public TreeNode invertTree2(TreeNode root) {
            if (root != null) {
                var temp = root.left;
                root.left = root.right;
                root.right = temp;

                invertTree2(root.left);
                invertTree2(root.right);
            }

            return root;
        }

        public TreeNode invertTree3(TreeNode root) {
            if (root != null) {
                invertTree3(root.left);
                invertTree3(root.right);

                var temp = root.left;
                root.left = root.right;
                root.right = temp;
            }

            return root;
        }

        public TreeNode invertTree4(TreeNode root) {
            if (root == null) return null;

            var stack = new ArrayDeque<TreeNode>();
            stack.push(root);

            while (!stack.isEmpty()) {
                var node = stack.pop();

                var temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }

            return root;
        }

        public TreeNode invertTree5(TreeNode root) {
            if (root == null) return null;

            var queue = new LinkedList<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                var node = queue.poll();

                var temp = node.left;
                node.left = node.right;
                node.right = temp;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            return root;
        }
    }
}

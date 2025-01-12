package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreePathsTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, return all root-to-leaf paths in any order.

    A leaf is a node with no children.



    Example 1:


    Input: root = [1,2,3,null,5]
    Output: ["1->2->5","1->3"]
    Example 2:

    Input: root = [1]
    Output: ["1"]


    Constraints:

    The number of nodes in the tree is in the range [1, 100].
    -100 <= Node.val <= 100

     */

    @Test
    public void test_binaryTreePaths() {
        var root = TreeNode.of(new Integer[]{1, 2, 3, null, 5});
        var actual = sut.binaryTreePaths(root);
        assertEquals(
                List.of("1->2->5", "1->3"),
                actual
        );

        root = TreeNode.of(new Integer[]{1});
        actual = sut.binaryTreePaths(root);
        assertEquals(
                List.of("1"),
                actual
        );
    }

    @Test
    public void test_binaryTreePaths2() {
        var root = TreeNode.of(new Integer[]{1, 2, 3, null, 5});
        var actual = sut.binaryTreePaths2(root);
        assertEquals(
                List.of("1->2->5", "1->3"),
                actual
        );

        root = TreeNode.of(new Integer[]{1});
        actual = sut.binaryTreePaths2(root);
        assertEquals(
                List.of("1"),
                actual
        );
    }

    private static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if (root == null) {
                return paths;
            }
            findPaths(root, "", paths);
            return paths;
        }

        private void findPaths(TreeNode node, String path, List<String> paths) {
            if (node == null) {
                return;
            }

            path += Integer.toString(node.val);

            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                path += "->";
                findPaths(node.left, path, paths);
                findPaths(node.right, path, paths);
            }
        }

        public List<String> binaryTreePaths2(TreeNode root) {
            List<String> paths = new ArrayList<>();

            var stack = new ArrayDeque<TreeNode>();
            var pathStack = new ArrayDeque<String>();
            stack.push(root);
            pathStack.push(String.valueOf(root.val));

            while (!stack.isEmpty()) {
                var curr = stack.pop();
                var currPath = pathStack.pop();

                if (curr.left == null && curr.right == null) {
                    paths.add(currPath);
                }

                if (curr.right != null) {
                    stack.push(curr.right);
                    pathStack.push(currPath + "->" + curr.right.val);
                }

                if (curr.left != null) {
                    stack.push(curr.left);
                    pathStack.push(currPath + "->" + curr.left.val);
                }
            }

            return paths;
        }
    }
}

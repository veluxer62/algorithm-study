package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FindModeInBinarySearchTreeTest {

    /*

    Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.

    If the tree has more than one mode, return them in any order.

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.


    Example 1:


    Input: root = [1,null,2,2]
    Output: [2]
    Example 2:

    Input: root = [0]
    Output: [0]


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -105 <= Node.val <= 105


    Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

     */

    @Test
    public void test_findMode() {
        var root = TreeNode.of(new Integer[]{1, null, 2, null, null, 2});
        var actual = new Solution().findMode(root);
        assertArrayEquals(
                new int[]{2},
                actual
        );

        root = TreeNode.of(new Integer[]{0});
        actual = new Solution().findMode(root);
        assertArrayEquals(
                new int[]{0},
                actual
        );

        root = TreeNode.of(new Integer[]{1, null, 2});
        actual = new Solution().findMode(root);
        assertArrayEquals(
                new int[]{1, 2},
                actual
        );
    }

    private static class Solution {
        int max = 0;

        public int[] findMode(TreeNode root) {
            var countMap = new HashMap<Integer, Integer>();
            var reverseMap = new HashMap<Integer, List<Integer>>();

            search(root, countMap, reverseMap);

            return reverseMap.get(max).stream().mapToInt(i -> i).toArray();
        }

        private void search(TreeNode root, Map<Integer, Integer> countMap, Map<Integer, List<Integer>> reverseMap) {
            if (root == null) return;

            search(root.left, countMap, reverseMap);

            int value = countMap.getOrDefault(root.val, 0) + 1;

            countMap.put(root.val, value);
            reverseMap.put(value, reverseMap.getOrDefault(value, new ArrayList<>()));
            reverseMap.get(value).add(root.val);

            max = Math.max(max, value);

            search(root.right, countMap, reverseMap);
        }

    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDistanceBetweenBSTNodesTest {

    /*

    Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.



    Example 1:


    Input: root = [4,2,6,1,3]
    Output: 1
    Example 2:


    Input: root = [1,0,48,null,null,12,49]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [2, 100].
    0 <= Node.val <= 105

     */

    @Test
    public void test_minDiffInBST() {
        var root = TreeNode.of(new Integer[]{4, 2, 6, 1, 3});
        var actual = new Solution().minDiffInBST(root);
        assertEquals(1, actual);

        root = TreeNode.of(new Integer[]{1, 0, 48, null, null, 12, 49});
        actual = new Solution().minDiffInBST(root);
        assertEquals(1, actual);
    }

    @Test
    public void test_minDiffInBST2() {
        var root = TreeNode.of(new Integer[]{4, 2, 6, 1, 3});
        var actual = new Solution().minDiffInBST2(root);
        assertEquals(1, actual);

        root = TreeNode.of(new Integer[]{1, 0, 48, null, null, 12, 49});
        actual = new Solution().minDiffInBST2(root);
        assertEquals(1, actual);
    }

    private static class Solution {
        public int minDiffInBST(TreeNode root) {
            var pq = new PriorityQueue<Integer>();
            dfs(root, pq);

            var min = Integer.MAX_VALUE;
            var prev = pq.poll();

            while (!pq.isEmpty()) {
                var curr = pq.poll();
                min = Math.min(min, Math.abs(prev - curr));
                prev = curr;
            }

            return min;
        }

        private void dfs(TreeNode root, PriorityQueue<Integer> pq) {
            if (root == null) return;

            pq.add(root.val);
            dfs(root.left, pq);
            dfs(root.right, pq);
        }

        int minDiff = Integer.MAX_VALUE;
        int prev = -1;

        public int minDiffInBST2(TreeNode root) {
            inOrder(root);
            return minDiff;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;

            inOrder(root.left);
            if (prev != -1) {
                minDiff = Math.min(minDiff, Math.abs(root.val - prev));
            }
            prev = root.val;
            inOrder(root.right);
        }
    }
}

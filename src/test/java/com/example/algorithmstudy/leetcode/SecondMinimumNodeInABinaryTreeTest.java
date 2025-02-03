package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondMinimumNodeInABinaryTreeTest {
    private final Solution sut = new Solution();

    /*

    Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

    Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

    If no such second minimum value exists, output -1 instead.





    Example 1:


    Input: root = [2,2,5,null,null,5,7]
    Output: 5
    Explanation: The smallest value is 2, the second smallest value is 5.
    Example 2:


    Input: root = [2,2,2]
    Output: -1
    Explanation: The smallest value is 2, but there isn't any second smallest value.


    Constraints:

    The number of nodes in the tree is in the range [1, 25].
    1 <= Node.val <= 231 - 1
    root.val == min(root.left.val, root.right.val) for each internal node of the tree.

     */

    @Test
    public void test_findSecondMinimumValue() {
        var root = TreeNode.of(new Integer[]{2, 2, 5, null, null, 5, 7});
        var actual = sut.findSecondMinimumValue(root);
        assertEquals(5, actual);

        root = TreeNode.of(new Integer[]{2, 2, 2});
        actual = sut.findSecondMinimumValue(root);
        assertEquals(-1, actual);
    }

    private static class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            var queue = new PriorityQueue<Integer>();

            search(root, queue);

            if (queue.size() == 1) return -1;

            queue.poll();
            return queue.poll();
        }

        private void search(TreeNode root, PriorityQueue<Integer> queue) {
            if (root == null) return;

            search(root.left, queue);
            if (!queue.contains(root.val)) {
                queue.add(root.val);
            }
            search(root.right, queue);
        }
    }
}

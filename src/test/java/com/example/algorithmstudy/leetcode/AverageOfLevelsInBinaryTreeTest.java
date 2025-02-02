package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageOfLevelsInBinaryTreeTest {
    private final Solution sut = new Solution();

    /*

    Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.


    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: [3.00000,14.50000,11.00000]
    Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
    Hence return [3, 14.5, 11].
    Example 2:


    Input: root = [3,9,20,15,7]
    Output: [3.00000,14.50000,11.00000]


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1

     */

    @Test
    public void test_averageOfLevels() {
        var root = TreeNode.of(new Integer[]{3, 9, 20, null, null, 15, 7});
        var actual = sut.averageOfLevels(root);
        assertEquals(
                List.of(3d, 14.5d, 11d),
                actual
        );

        root = TreeNode.of(new Integer[]{3, 9, 20, 15, 7});
        actual = sut.averageOfLevels(root);
        assertEquals(
                List.of(3d, 14.5d, 11d),
                actual
        );

        root = TreeNode.of(new Integer[]{1, 1});
        actual = sut.averageOfLevels(root);
        assertEquals(
                List.of(1d, 1d),
                actual
        );

        root = TreeNode.of(new Integer[]{3,1,5,0,2,4,6});
        actual = sut.averageOfLevels(root);
        assertEquals(
                List.of(3d, 3d, 3d),
                actual
        );
    }

    private static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            var queue = new LinkedList<TreeNode>();
            var result = new ArrayList<Double>();

            queue.add(root);
            bfs(queue, result);

            return result;
        }

        private void bfs(Queue<TreeNode> queue, List<Double> result) {
            if (queue.isEmpty()) return;

            var len = queue.size();
            var tempLen = len;
            var sum = 0d;

            while (tempLen > 0) {
                var curr = queue.poll();

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);

                sum += curr.val;
                tempLen--;
            }

            result.add(sum / len);
            bfs(queue, result);
        }
    }
}

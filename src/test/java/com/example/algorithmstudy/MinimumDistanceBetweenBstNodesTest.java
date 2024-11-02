package com.example.algorithmstudy;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumDistanceBetweenBstNodesTest {
    private final Solution sut = new Solution();

    /*
     * 두 노드 간 값의 차이 최솟값을 출력하라.
     */

    @Test
    public void test_minDistanceBST() {
        var root = TreeNode.of(new Integer[]{10, 4, 16, 1, 8, null, 19, null, null, 7});
        var actual = sut.minDistanceBST(root);
        assertEquals(1, actual);
    }

    @Test
    public void test_minDistanceBST2() {
        var root = TreeNode.of(new Integer[]{10, 4, 16, 1, 8, null, 19, null, null, 7});
        var actual = sut.minDistanceBST2(root);
        assertEquals(1, actual);
    }

    private static class Solution {
        private int prev = Integer.MIN_VALUE + 100000;
        private int minDiff = Integer.MAX_VALUE;

        public int minDistanceBST(TreeNode root) {
            if (root.left != null) minDistanceBST(root.left);

            minDiff = Math.min(minDiff, root.val - prev);
            prev = root.val;

            if (root.right != null) minDistanceBST(root.right);

            return minDiff;
        }

        /*
         * t = [10, 4, 16, 1, 8, null, 19, null, null, 7]
         * p=-121312313123123
         * m = 12312312313213
         *
         * r=10
         *      r=4
         *          r=1
         *          m=12312312313123
         *          p=1
         *      m=3
         *      p=4
         *          r=8
         *              r=7
         *              m=3
         *              p=7
         *          m=1
         *          p=8
         * m=1
         * p=10
         *      r=16
         *      m=1
         *      p=16
         *          r=19
         *          m=1
         *          p=19
         *
         */

        public int minDistanceBST2(TreeNode root) {
            var prev = Integer.MIN_VALUE + 100000;
            var minDiff = Integer.MAX_VALUE;

            var stack = new ArrayDeque<TreeNode>();
            var node = root;

            while (!stack.isEmpty() || node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }

                node = stack.pop();

                minDiff = Math.min(minDiff, node.val - prev);
                prev = node.val;

                node = node.right;
            }

            return minDiff;
        }

        /*
         * t = [10, 4, 16, 1, 8, null, 19, null, null, 7]
         * p=-123123123123123
         * m=123123123123213123
         * s=[]
         * n=10
         *
         * s=[10]
         * n=4
         *
         * s=[10,4]
         * n=1
         *
         * s=[10,4,1]
         * n=null
         *
         * n=1
         * s=[10,4]
         *
         * m=13132413241234
         * p=1
         * n=null
         *
         * n=4
         * s=[10]
         *
         * m=3
         * p=4
         * n=8
         *
         * s=[10,8]
         * n=7
         *
         * s=[10,8,7]
         *
         * n=null
         *
         * n=7
         * s=[10,8]
         * m=3
         * p=7
         *
         * n=null
         *
         * n=8
         * s=[10]
         * m=1
         * p=8
         *
         * n=null
         */
    }
}

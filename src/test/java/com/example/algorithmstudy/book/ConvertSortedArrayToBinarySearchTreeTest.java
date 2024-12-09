package com.example.algorithmstudy.book;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertSortedArrayToBinarySearchTreeTest {
    private final Solution sut = new Solution();

    /*
     * 정렬된 배열을 받아 높이 균형 이진 탐색 트리로 변환하라. 높이 균형이란 모든 노드의 두 서브 트리 간 깊이 차이가 1 이하인 것을 말한다.
     */

    @Test
    public void test_sortedArrayToBST() {
        var nums = new int[]{-10, -7, -3, 0, 5, 7, 9};
        var actual = sut.sortedArrayToBST(nums);
        assertEquals(
                TreeNode.of(new Integer[]{0, -7, 7, -10, -3, 5, 9}),
                actual
        );
    }

    private static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums.length == 0) return null;
            return construct(nums, 0, nums.length - 1);
        }

        private TreeNode construct(int[] nums, int lo, int hi) {
            if (lo > hi) return null;

            int mid = lo + (hi - lo) / 2;

            var node = new TreeNode(nums[mid]);
            node.left = construct(nums, lo, mid - 1);
            node.right = construct(nums, mid + 1, hi);

            return node;
        }
    }
}

package com.example.algorithmstudy.leetcode;

import com.example.algorithmstudy.utils.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertSortedArrayToBinarySearchTreeTest {
    private final Solution sut = new Solution();

    /*

    Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.



    Example 1:


    Input: nums = [-10,-3,0,5,9]
    Output: [0,-3,9,-10,null,5]
    Explanation: [0,-10,5,null,-3,null,9] is also accepted:

    Example 2:


    Input: nums = [1,3]
    Output: [3,1]
    Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.


    Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in a strictly increasing order.

     */

    @Test
    public void test_sortedArrayToBST() {
        var nums = new int[]{-10, -3, 0, 5, 9};
        var actual = sut.sortedArrayToBST(nums);
        assertEquals(
                TreeNode.of(new Integer[]{0, -10, 5, null, -3, null, 9}),
                actual
        );

        nums = new int[]{1, 3};
        actual = sut.sortedArrayToBST(nums);
        assertEquals(
                TreeNode.of(new Integer[]{1, null, 3}),
                actual
        );
    }

    private static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return buildBST(nums, 0, nums.length - 1);
        }

        private TreeNode buildBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }

            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);

            root.left = buildBST(nums, left, mid - 1);
            root.right = buildBST(nums, mid + 1, right);

            return root;
        }
    }
}

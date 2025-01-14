package com.example.algorithmstudy.leetcode;

public class RangeSumQueryImmutableTest {

    /*

    Given an integer array nums, handle multiple queries of the following type:

    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
    Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


    Example 1:

    Input
    ["NumArray", "sumRange", "sumRange", "sumRange"]
    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    Output
    [null, 1, -1, -3]

    Explanation
    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
    numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
    numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3


    Constraints:

    1 <= nums.length <= 104
    -105 <= nums[i] <= 105
    0 <= left <= right < nums.length
    At most 104 calls will be made to sumRange.

     */

    // 시간 복잡도:
    //  NumArray 생성자: O(1)
    //  sumRange 메서드: O(n) (n은 nums 배열의 길이)
    class NumArray {
        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            var result = 0;
            for (var i = left; i <= right; i++) {
                result += this.nums[i];
            }

            return result;
        }
    }

    // 시간 복잡도:
    //  NumArray 생성자: O(n) (n은 nums 배열의 길이)
    //  sumRange 메서드: O(1)
    class NumArray2 {
        private final int[] prefixSum;

        public NumArray2(int[] nums) {
            prefixSum = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                prefixSum[i + 1] = prefixSum[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefixSum[right + 1] - prefixSum[left];
        }
    }
}

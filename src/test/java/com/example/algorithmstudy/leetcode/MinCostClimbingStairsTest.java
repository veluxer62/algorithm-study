package com.example.algorithmstudy.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinCostClimbingStairsTest {
    private final Solution sut = new Solution();

    /*

    You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

    You can either start from the step with index 0, or the step with index 1.

    Return the minimum cost to reach the top of the floor.



    Example 1:

    Input: cost = [10,15,20]
    Output: 15
    Explanation: You will start at index 1.
    - Pay 15 and climb two steps to reach the top.
    The total cost is 15.
    Example 2:

    Input: cost = [1,100,1,1,1,100,1,1,100,1]
    Output: 6
    Explanation: You will start at index 0.
    - Pay 1 and climb two steps to reach index 2.
    - Pay 1 and climb two steps to reach index 4.
    - Pay 1 and climb two steps to reach index 6.
    - Pay 1 and climb one step to reach index 7.
    - Pay 1 and climb two steps to reach index 9.
    - Pay 1 and climb one step to reach the top.
    The total cost is 6.


    Constraints:

    2 <= cost.length <= 1000
    0 <= cost[i] <= 999

     */

    @Test
    public void test_minCostClimbingStairs() {
        var cost = new int[]{10, 15, 20};
        var actual = sut.minCostClimbingStairs(cost);
        assertEquals(15, actual);

        cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        actual = sut.minCostClimbingStairs(cost);
        assertEquals(6, actual);

        cost = new int[]{0, 0, 0, 1};
        actual = sut.minCostClimbingStairs(cost);
        assertEquals(0, actual);

        cost = new int[]{0,1,0,0};
        actual = sut.minCostClimbingStairs(cost);
        assertEquals(0, actual);

        System.out.println("===");
        cost = new int[]{0,1,2,2};
        actual = sut.minCostClimbingStairs(cost);
        assertEquals(2, actual);
    }

    private static class Solution {
        public int minCostClimbingStairs(int[] cost) {
            var n = cost.length;
            var result = new int[n];

            result[0] = cost[0];
            result[1] = cost[1];

            for (int i = 2; i < n; i++) {
                result[i] = Math.min(result[i - 1], result[i - 2]) + cost[i];
            }

            return Math.min(result[n - 1], result[n - 2]);
        }
    }
}
